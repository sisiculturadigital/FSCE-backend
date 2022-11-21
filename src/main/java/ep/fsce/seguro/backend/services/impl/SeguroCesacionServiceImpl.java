package ep.fsce.seguro.backend.services.impl;

import java.io.File;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.mail.internet.MimeMessage;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import ep.fsce.seguro.backend.domain.AporteFscec;
import ep.fsce.seguro.backend.domain.DetallePago;
import ep.fsce.seguro.backend.domain.LineaProducto;
import ep.fsce.seguro.backend.domain.Noticia;
import ep.fsce.seguro.backend.domain.PagoRecibido;
import ep.fsce.seguro.backend.domain.PersRem;
import ep.fsce.seguro.backend.domain.PersRemDatos;
import ep.fsce.seguro.backend.domain.Persona;
import ep.fsce.seguro.backend.domain.PrestamoInsp;
import ep.fsce.seguro.backend.domain.Producto;
import ep.fsce.seguro.backend.domain.PreSolicitud;
import ep.fsce.seguro.backend.domain.TipoUsuario;
import ep.fsce.seguro.backend.domain.Usuario;
import ep.fsce.seguro.backend.dto.AporteFscecPersona;
import ep.fsce.seguro.backend.dto.MensajeBean;
import ep.fsce.seguro.backend.dto.PagoRecibidoBean;
import ep.fsce.seguro.backend.dto.PersonaBean;
import ep.fsce.seguro.backend.dto.Prestamo;
import ep.fsce.seguro.backend.dto.ProductoBean;
import ep.fsce.seguro.backend.dto.SolicitudDs;
import ep.fsce.seguro.backend.dto.request.AuthDTO;
import ep.fsce.seguro.backend.dto.request.EmailDTO;
import ep.fsce.seguro.backend.dto.request.PwdDTO;
import ep.fsce.seguro.backend.dto.request.RecoverPassDTO;
import ep.fsce.seguro.backend.dto.request.SolicitudPrestamoDTO;
import ep.fsce.seguro.backend.dto.request.UsuarioDTO;
import ep.fsce.seguro.backend.dto.response.AporteFscecReponse;
import ep.fsce.seguro.backend.dto.response.DetallePagoResponse;
import ep.fsce.seguro.backend.dto.response.NoticiasReponse;
import ep.fsce.seguro.backend.dto.response.PagosResponse;
import ep.fsce.seguro.backend.dto.response.ProductosReponse;
import ep.fsce.seguro.backend.dto.response.SaldoTipoPrestamoResponse;
import ep.fsce.seguro.backend.dto.response.TokenResponse;
import ep.fsce.seguro.backend.exception.UnprocessableEntityException;
import ep.fsce.seguro.backend.jwt.UserDetailsImpl;
import ep.fsce.seguro.backend.services.SeguroCesacionService;
import ep.fsce.seguro.backend.util.Constantes;
import ep.fsce.seguro.backend.util.MensajeUtil;
import ep.fsce.seguro.backend.util.ParametersValidateUtil;
import ep.fsce.seguro.backend.util.TokenUtils;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanArrayDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import org.springframework.core.io.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class SeguroCesacionServiceImpl extends SeguroCesacionServiceAbstract implements SeguroCesacionService {

	private static final Logger log = LoggerFactory.getLogger(SeguroCesacionServiceImpl.class);

	@Override
	public MensajeBean registrarUsuario(UsuarioDTO user) {

		log.info("INICIO METODO DEL METODO REGISTRAR USUARIO");
		if (!ParametersValidateUtil.cumpleValidacionUsuario(user)) {
			log.info("SE INGRESARON CAMPOS VACIOS");
			throw new UnprocessableEntityException(Constantes.R422, HttpStatus.UNPROCESSABLE_ENTITY,
					"CAMPOS VACIOS O NULL");
		}

		try {
			log.info("INICIO BUSQUEDA DE PERSONA POR DNI $$ CODADM && FECHANAC ");
			Optional<Persona> pe = personaRepository.findByDniAndCodAdmAndFecNac(user.getDni(), user.getCodAdm(),
					user.getFechaNac());
			log.info("FIN BUSQUEDA DE PERSONA POR DNI $$ CODADM && FECHANAC ");

			if (pe.isPresent()) {
				log.info("DATOS PERSONA : {}", pe.get().getDni());

				log.info("INICIO BUSQUEDA DE USUARIO");
				Optional<Usuario> isUser = usuarioRepository.findByDniAndCodAdm(pe.get().getDni(),
						pe.get().getCodAdm());
				log.info("FIN BUSQUEDA DE USUARIO");

				if (isUser.isPresent()) {
					log.info("EXISTE REGISTRO EN USUARIO");
					return MensajeUtil.mensajeReponse(Constantes.R422, "Usted ya se encuentra registrado");
				}

				log.info("INICIO BUSQUEDA DE TIPOS DE ROLES");
				TipoUsuario r = roleRepository.findByTipoUsuario(Integer.parseInt(user.getCodRole()));
				log.info("FIN BUSQUEDA DE TIPOS DE ROLES");

				if (!Objects.isNull(r)) {
					log.info("INICIO DE REGISTRO DE USUARIO");
					Usuario u = new Usuario();
					u.setDni(pe.get().getDni());
					u.setCodAdm(pe.get().getCodAdm());
					u.setPassword(encoder.encode(user.getPassword()));
					u.setNombres(user.getNombres().toUpperCase());
					u.setApellidos(user.getApellidos().toUpperCase());
					u.setEmail(user.getEmail());
					u.setEstado("0");
					u.setTipoUser(r);
					usuarioRepository.save(u);
					log.info("FIN METODO DE REGISTRO DE USUARIO");
					return MensajeUtil.mensajeReponse(Constantes.R200, "Registro de usuario éxitoso");
				} else {
					log.info("CODIGO DE ROL INCORRECTO SOLO USER O ADMINISTRADOR");
					return MensajeUtil.mensajeReponse(Constantes.R422, "Codigo de rol invalido");
				}

			} else {
				log.info("NO SE ENCONTRO NINGUNA PERSONA CON ESTOS DATOS");
				return MensajeUtil.mensajeReponse(Constantes.R422, "Ingrese correctamente sus datos");
			}

		} catch (Exception e) {
			log.info(Constantes.LEVEL_ERROR, e.getMessage(), Thread.currentThread().getStackTrace());
			return MensajeUtil.mensajeReponse(Constantes.R422, e.getMessage());
		}
	}

	@Override
	public TokenResponse authenticateToken(AuthDTO authDto) {

		if (!ParametersValidateUtil.cumpleValidacionSession(authDto)) {
			log.info("SE INGRESARON CAMPOS VACIOS");
			throw new UnprocessableEntityException(Constantes.R422, HttpStatus.UNPROCESSABLE_ENTITY,
					"CAMPOS VACIOS O NULL");
		}

		log.info("AUTH - INICIO DEL METODO AUTHENTICATE TOKEN");
		log.info("INICIO VALIDACION DE CREDENCIALES");
		authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(authDto.getEmail(), authDto.getPwd()));
		UserDetailsImpl userDetails = (UserDetailsImpl) usuarioDetailsService.loadUserByUsername(authDto.getEmail());
		log.info("FIN VALIDACION DE CREDENCIALES");
		log.info("INICIO METODO GENERAR TOKEN");
		String jwt = TokenUtils.createToken(userDetails.getNombre(), userDetails.getUsername(), userDetails.getRol());
		log.info("FIN METODO GENERAR TOKEN");
		log.info("AUTH - FIN DEL METODO AUTHENTICATE TOKEN");
		return new TokenResponse(jwt);
	}

	@Override
	public MensajeBean actualizarPassword(PwdDTO pwd) {
		log.info("PWD - INICIO METODO ACTUALIZAR CONTRASENIA");
		if (!ParametersValidateUtil.cumpleValidacionPassword(pwd)) {
			log.info("SE INGRESARON CAMPOS VACIOS");
			throw new UnprocessableEntityException(Constantes.R422, HttpStatus.UNPROCESSABLE_ENTITY,
					"CAMPOS VACIOS O NULL");
		}
		try {
			log.info("INICIO BUSQUEDA DE USUARIO");
			Optional<Usuario> u = usuarioRepository.findByEmail(pwd.getEmail());
			log.info("FIN BUSQUEDA DE USUARIO");
			if (u.isPresent()) {
				log.info("USUARIO ENCONTRADO {}", u.get().getEmail());
				u.get().setPassword(encoder.encode(pwd.getNewPwd()));
				log.info("INICIO ACTUALIZACION DE PASSWORD");
				usuarioRepository.save(u.get());
				log.info("PWD - FIN METODO ACTUALIZAR CONTRASENIA");
				return MensajeUtil.mensajeReponse(Constantes.R200, "Password actualizado");
			} else {
				log.info("CORREO NO SE ENCUENTRA REGISTRADO");
				return MensajeUtil.mensajeReponse(Constantes.R422, "Datos incorrectos");
			}
		} catch (Exception e) {
			throw new UnprocessableEntityException(Constantes.R500, HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		}
	}

	@Override
	public MensajeBean enviarCorreoOlvidePassword(EmailDTO email) {
		log.info("INICIO METODO ENVIO CORREO");
		if (!ParametersValidateUtil.cumpleValidacionEmail(email)) {
			log.info("SE INGRESARON CAMPOS VACIOS");
			throw new UnprocessableEntityException(Constantes.R422, HttpStatus.UNPROCESSABLE_ENTITY,
					"CAMPOS VACIOS O NULL");
		}
		try {
			log.info("INICIO SE BUSQUEDA DE CORREO REGISTRADO");
			Optional<Usuario> p = usuarioRepository.findByEmail(email.getTo());
			log.info("FIN DE BUSQUEDA DE CORREO REGISTRADO");
			if (!p.isPresent()) {
				log.info("NO SE ENCONTRARON DATOS CON EL CORREO {}", email.getTo());
				return MensajeUtil.mensajeReponse(Constantes.R422, "Correo no registrado");
			}
			MimeMessage msg = javaMailSender.createMimeMessage();
			MimeMessageHelper message = new MimeMessageHelper(msg, true);
			message.setFrom(email.getTo());
			message.setTo(email.getTo());
			message.setText(email.getMessage(), true);
			message.setSubject(email.getSubject());
			javaMailSender.send(msg);
			log.info("FIN METODO ENVIO CORREO");
			return MensajeUtil.mensajeReponse(Constantes.R200, "Correo enviado");
		} catch (Exception ex) {
			throw new UnprocessableEntityException(Constantes.R500, HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
		}
	}

	@Override
	public MensajeBean recuperarPassword(RecoverPassDTO recuperarPass) {
		log.info("INICIO METODO RECUPERACION DE CONTRASENIA");
		try {
			Optional<Persona> pe = personaRepository.findByDniAndCodAdmAndFecNac(recuperarPass.getDni(),
					recuperarPass.getCodAdm(), recuperarPass.getFechaNac());
			if (pe.isPresent()) {
				Optional<Usuario> u = usuarioRepository.findByEmail(recuperarPass.getEmail());
				if (u.isPresent()) {
					u.get().setPassword(encoder.encode(recuperarPass.getPassword()));
					usuarioRepository.save(u.get());
					return MensajeUtil.mensajeReponse(Constantes.R200, "Password actualizado");
				} else {
					return MensajeUtil.mensajeReponse(Constantes.R422, "Datos incorrectos");
				}
			}
			log.info("FIN METODO RECUPERACION DE CONTRASENIA");
			return MensajeUtil.mensajeReponse(Constantes.R200, "Constraseña Actualizada");
		} catch (Exception e) {
			throw new UnprocessableEntityException(Constantes.R500, HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		}
	}

	@Override
	public List<SaldoTipoPrestamoResponse> consultaPrestamosPorPersona(String dni) {
		log.info("PRESTAMO - INICIO CONSULTA PRESTAMO POR PERSONA");
		try {
			log.info("INICIO DE BUSQUEDA PRESTAMOS POR PERSONA");
			List<PrestamoInsp> lstPrestamo = prestamosIsnpRepository.findByDni(dni);
			log.info("FIN DE BUSQUEDA PRESTAMOS POR PERSONA");
			List<SaldoTipoPrestamoResponse> response = new ArrayList<>();

			if (lstPrestamo.isEmpty()) {
				throw new UnprocessableEntityException(Constantes.R404, HttpStatus.NOT_FOUND,
						"NO SE ENCONTRO DATA " + dni);
			}
			log.info("INICIO AGRUPACION PRESTAMO");
			Map<String, List<PrestamoInsp>> groupByPrestamo = groupByPrestamoIsnp(lstPrestamo);
			List<LineaProducto> lp = lineaProductoRepository.findByLineaDni(dni);
			lp.forEach(item -> {
				log.info("INICIO BUSQUEDA DE PRODUCTO");
				Optional<Producto> product = productoRepository.findByEcPtmo(item.getLineaProductoPk().getEcPtmo());
				SaldoTipoPrestamoResponse s = new SaldoTipoPrestamoResponse();
				if (product.isPresent()) {
					s.setCodigoPrestamo(product.get().getEcPtmo());
					s.setTipoPrestamo(product.get().getDesProducto());
				}
				s.setImpApo(item.getImporte().toString());
				Prestamo p = new Prestamo();
				groupByPrestamo.forEach((key, value) -> {
					List<Prestamo> listPrestamo = new ArrayList<>();
					if (item.getLineaProductoPk().getEcPtmo().equals(key)) {
						value.forEach(x -> {
							p.setNroChe(x.getNroChe());
							p.setCodAdm(x.getCodAdm());
							p.setDest(x.getDest());
							p.setTipoPrest(x.getTipoPrest());
							p.setAnoEnv(x.getAnoEnv());
							p.setMesEnv(x.getMesEnv());
							p.setImpSol(x.getImpSol());
							p.setDeudaTotIni(x.getDeudaTotIni());
							p.setFecAprob(x.getFecAprob());
							p.setImpDesmbls(x.getImpDesmbls());
							p.setNroCuo(x.getNroCuo());
							p.setCuoMen(x.getCuoMen());
							p.setCuoCap(x.getCuoCap());
							p.setIntereses(x.getIntereses());
							p.setSaldoActual(x.getSaldoActual());
							p.setSaldoSint(x.getSaldoSint());
							p.setDni(x.getDni());
							p.setSaldoVigente(x.getSaldoVigente());
							p.setSaldoVigenteCap(x.getSaldoVigenteCap());
							p.setAtraso(x.getAtraso());
							p.setDevGracia(x.getDevGracia());
							p.setTipoDscto(x.getTipoDscto());
							p.setCodEp(x.getCodEp());
							p.setCodCpmp(x.getCodCpmp());
							p.setRefinancia(x.getRefinancia());
							p.setCodEcPtmo(x.getEcPtmo());
							listPrestamo.add(p);
						});
						s.setPrestamos(listPrestamo);
					}
				});
				response.add(s);
			});
			log.info("FIN METODO CONSULTA PRESTAMO POR PERSONA");
			return response;
		} catch (Exception e) {
			throw new UnprocessableEntityException(Constantes.R500, HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		}
	}

	private static Map<String, List<PrestamoInsp>> groupByPrestamoIsnp(List<PrestamoInsp> prestamos) {
		return prestamos.stream().collect(Collectors.groupingBy(PrestamoInsp::getEcPtmo, Collectors.toList()));
	}

	@Override
	public ResponseEntity<Resource> exportReportePrestamoPorPersona(String dni, String idDetalle, String codAdm) {
		log.info("INICIO METODO EXPORT PDF PRESTAMO POR PERSONA");
		try {
			Optional<Persona> persona = personaRepository.findByDni(dni);
			JasperPrint jasperPrint = null;
			String[] partesIdDetalle = idDetalle.split(Constantes.GUION);
			if (validarPartesIdDetalle(partesIdDetalle)) {
				throw new UnprocessableEntityException(Constantes.R422, HttpStatus.BAD_REQUEST,
						"Ingrese correctamente detalle NRO-AA-MM");
			}
			String nroChe = partesIdDetalle[0];
			String aaCuo = partesIdDetalle[1];
			String mmCuo = partesIdDetalle[2];
			if (!ParametersValidateUtil.validarCamposIdDetalle(codAdm, nroChe, aaCuo, mmCuo)) {
				throw new UnprocessableEntityException(Constantes.R422, HttpStatus.BAD_REQUEST,
						"Ingrese correctamente los parametros");
			}
			List<DetallePago> data = detallePagoRepository.buscarDetalle(codAdm, aaCuo, mmCuo, nroChe);

			if (persona.isPresent() && !data.isEmpty()) {

				List<Persona> listPersona = new ArrayList<>();
				listPersona.add(persona.get());

				List<DetallePago> listDetalle = new ArrayList<>();
				listDetalle.add(data.get(0));

				ClassPathResource resource = new ClassPathResource(
						"reportes" + File.separator + "reportSaldoPrestamo.jasper");

				ClassPathResource imagen = new ClassPathResource("images" + File.separator + "logo.png");

				InputStream jasperStream = resource.getInputStream();
				JasperReport report = (JasperReport) JRLoader.loadObject(jasperStream);
				HashMap<String, Object> parameter = new HashMap<>();

				parameter.put("dsPersona", new JRBeanArrayDataSource(listPersona.toArray()));
				parameter.put("dsPago", new JRBeanArrayDataSource(listDetalle.toArray()));
				parameter.put("logo", imagen.getInputStream());
				log.info("INICIO COMPLETAR DATOS PDF");
				jasperPrint = JasperFillManager.fillReport(report, parameter, new JREmptyDataSource());
				log.info("FIN COMPLETAR DATOS PDF");
				byte[] reporte = JasperExportManager.exportReportToPdf(jasperPrint);
				log.info("INICIO ASIGNACION DE NOMBRE PDF");
				String sdf = (new SimpleDateFormat("ddMMyyyy")).format(new Date());
				StringBuilder stringBuilder = new StringBuilder().append(dni);
				ContentDisposition contentDisposition = ContentDisposition.builder("attachment")
						.filename(stringBuilder.append("-").append(sdf).append(".pdf").toString()).build();
				HttpHeaders headers = new HttpHeaders();
				headers.setContentDisposition(contentDisposition);
				log.info("FIN EXPORT PDF PRESTAMO POR PERSONA");
				return ResponseEntity.ok().contentLength((long) reporte.length).contentType(MediaType.APPLICATION_PDF)
						.headers(headers).body(new ByteArrayResource(reporte));
			} else {
				return ResponseEntity.noContent().build();
			}
		} catch (Exception e) {
			throw new UnprocessableEntityException(Constantes.R500, HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		}
	}

	@Override
	public AporteFscecReponse consultaAportePorPersona(String codAdm) {
		log.info("INICIO METODO CONSULTA DE APORTES POR PERSONA");
		try {
			
			log.info("BUSCAR APORTES POR COD ADM {}", codAdm);
			List<AporteFscec> aporte = aporteFscecRepository.findByCodAdm(codAdm);
			log.info("FIN BUSQUEDA POR COD ADM {}", codAdm);
			
			log.info("BUSCAR DATOS DE LA PERSONA{}", codAdm);
			Optional<Persona> p = personaRepository.findByCodAdm(codAdm);
			log.info("FIN BUSCAR DATOS DE LA PERSONA{}", codAdm);
			
			AporteFscecReponse reponse = new AporteFscecReponse();
			List<AporteFscecPersona> listAporteFscec = new ArrayList<>();
			DecimalFormat df = new DecimalFormat(Constantes.DECIMAL_FORMAT_05);

			if (p.isPresent()) {
				int nroAporte = 0;
				double impAporte = 0.0;
				if (!Objects.isNull(p.get().getNroApo()) && !p.get().getNroApo().isEmpty()) {
					nroAporte = Integer.parseInt(p.get().getNroApo());
				}

				if (!Objects.isNull(p.get().getImpApo()) && !p.get().getImpApo().toString().isEmpty()) {
					impAporte = p.get().getImpApo();
				}
				double subTotalAporte = 0;
				double totalAporte = 0;
				int i = 0;
				if (!aporte.isEmpty()) {
					for (AporteFscec item : aporte) {
						AporteFscecPersona apPersona = new AporteFscecPersona();
						apPersona.setCodAdm(item.getCodAdm());
						apPersona.setAaApa(item.getAaApa());
						apPersona.setImpApa(item.getImpApa().toString().startsWith(Constantes.STRING_CERO)
								? Constantes.STRING_CERO.concat(df.format(item.getImpApa()))
								: df.format(item.getImpApa()));
						apPersona.setImpDu(item.getImpDu().toString().startsWith(Constantes.STRING_CERO)
								? Constantes.STRING_CERO.concat(df.format(item.getImpDu()))
								: df.format(item.getImpDu()));
						apPersona.setMmApa(item.getMmApa());
						apPersona.setTipoApa(item.getTipApa().getDescApa());
						apPersona.setImpApoLiq(item.getImpApoliq().toString().startsWith(Constantes.STRING_CERO)
								? Constantes.STRING_CERO.concat(df.format(item.getImpApoliq()))
								: df.format(item.getImpApoliq()));
						listAporteFscec.add(apPersona);
						subTotalAporte = subTotalAporte + item.getImpApa();
						i++;
					}
					log.info("INICIO CALCULO DE APORTE TOTAL");
					totalAporte = subTotalAporte + impAporte;
					log.info("FIN CALCULO DE APORTES TOTAL");
					reponse.setSubTotalAportes(df.format(subTotalAporte));
					reponse.setSubTotalCuotas(String.valueOf(i));
					reponse.setTotalAportes(df.format(totalAporte));
					reponse.setTotalCuotas(String.valueOf(i + nroAporte));
					reponse.setAportes(listAporteFscec);
				}

			}
			log.info("FIN METODO CONSULTA DE APORTES POR PERSONA");
			return reponse;
		} catch (Exception e) {
			throw new UnprocessableEntityException(Constantes.R500, HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		}
	}

	@Override
	public ProductosReponse consultaProductos() {
		log.info("INICIO METODO CONSULTA PRODUCTOS");
		try {
			ProductosReponse response = new ProductosReponse();
			List<Producto> producto = productoRepository.findAll();
			List<ProductoBean> lista = new ArrayList<>();
			if (!producto.isEmpty()) {
				producto.forEach(item -> {
					ProductoBean p = new ProductoBean();
					p.setCodigo(item.getEcPtmo().trim());
					p.setDesProducto(item.getDesProducto());
					lista.add(p);
				});
				response.setProductos(lista);
			}
			log.info("FIN METODO CONSULTA PRODUCTOS");
			return response;
		} catch (Exception e) {
			throw new UnprocessableEntityException(Constantes.R500, HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		}
	}

	@Override
	public MensajeBean registrarSolicitud(SolicitudPrestamoDTO solicitud) {
		log.info("INICIO METODO REGISTRO SOLICITUD POR SEDE");
		try {
			PreSolicitud soli = new PreSolicitud();
			int secunciaSolicitud = solicitudSedeRepository.cantidadRegistros() + 1;
			Optional<Persona> p = personaRepository.findByDni(solicitud.getDni().trim());
			if (p.isPresent()) {
				soli.setNroSol(String.valueOf(secunciaSolicitud));
				soli.setNroCuo(solicitud.getNroCuo());
				soli.setImpSol(solicitud.getImpSol());
				soli.setUsuIng(solicitud.getUsuIng().toUpperCase());
				soli.setFecIng(new Date());
				soli.setnLiquidez(solicitud.getLiquidez());
				soli.setDni(solicitud.getDni());
				soli.setEcPtmo(solicitud.getEcPtmo());
				solicitudSedeRepository.save(soli);
			} else {
				throw new UnprocessableEntityException(Constantes.R422, HttpStatus.NOT_FOUND, "DNI no registrado");
			}
			log.info("FIN METODO REGISTRO SOLICITUD POR SEDE");
			return MensajeUtil.mensajeReponse(Constantes.R200, "Registro solicitud exitoso");
		} catch (Exception e) {
			throw new UnprocessableEntityException(Constantes.R500, HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		}
	}

	@Override
	public PagosResponse consultaPagosRecibidosPorSocio(String codAdm) {
		log.info("INICIO METODO CONSULTA DE PAGOS RECIBIDOS POR SOCIO");
		try {
			PagosResponse response = new PagosResponse();
			List<PagoRecibido> lista = pagoRecibidoRepository.findByCodAdm(codAdm);
			if (!lista.isEmpty()) {
				double impPagoTotal = 0;
				double impDevTotal = 0;
				List<PagoRecibidoBean> listaPago = new ArrayList<>();
				List<PagoRecibidoBean> listaDevolucion = new ArrayList<>();
				for (PagoRecibido item : lista) {
					if (item.getConcepto().trim().equals(Constantes.CONCEPTO_DEVOLUCION)) {
						impDevTotal = impDevTotal + item.getImporte();
						PagoRecibidoBean pd = new PagoRecibidoBean();
						pd.setConcepto(item.getConcepto());
						pd.setImporte(item.getImporte());
						pd.setFechChe(item.getFecChe());
						listaDevolucion.add(pd);
					} else {
						impPagoTotal = impPagoTotal + item.getImporte();
						PagoRecibidoBean pr = new PagoRecibidoBean();
						pr.setConcepto(item.getConcepto());
						pr.setImporte(item.getImporte());
						pr.setFechChe(item.getFecChe());
						listaPago.add(pr);
					}
				}
				DecimalFormat df = new DecimalFormat(Constantes.DECIMAL_FORMAT_02);
				double totalTransferido = impPagoTotal + impDevTotal;
				response.setDevolucionTotal(df.format(impDevTotal));
				response.setPagoTotal(df.format(impPagoTotal));
				response.setTotalTransferido(df.format(totalTransferido));
				response.setCodAdm(codAdm);
				response.setPagos(listaPago);
				if (!listaDevolucion.isEmpty()) {
					response.setDevoluciones(listaDevolucion);
				}
			}
			log.info("FIN METODO CONSULTA DE PAGOS RECIBIDOS POR SOCIO");
			return response;
		} catch (Exception e) {
			throw new UnprocessableEntityException(Constantes.R500, HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		}
	}

	@Override
	public List<DetallePagoResponse> consultaDetallePago(String codAdm, String idDetalle) {
		log.info("INICIO METODO CONSULTA DE PAGOS DETALLES DE PAGO POR SOCIO");
		try {
			String[] partesIdDetalle = idDetalle.split(Constantes.GUION);
			if (validarPartesIdDetalle(partesIdDetalle)) {
				throw new UnprocessableEntityException(Constantes.R422, HttpStatus.BAD_REQUEST,
						"Ingrese correctamente detalle NRO-AA-MM");
			}
			String nroChe = partesIdDetalle[0];
			String aaCuo = partesIdDetalle[1];
			String mmCuo = partesIdDetalle[2];
			if (!ParametersValidateUtil.validarCamposIdDetalle(codAdm, nroChe, aaCuo, mmCuo)) {
				throw new UnprocessableEntityException(Constantes.R422, HttpStatus.BAD_REQUEST,
						"Ingrese correctamente los parametros");
			}
			List<DetallePagoResponse> response = new ArrayList<>();
			List<DetallePago> data = detallePagoRepository.buscarDetalle(codAdm, aaCuo, mmCuo, nroChe);
			if (!data.isEmpty()) {
				for (DetallePago item : data) {
					DetallePagoResponse detalle = new DetallePagoResponse();
					detalle.setAaCuo(item.getDetallePagopk().getAaCuo());
					detalle.setCodAdm(item.getDetallePagopk().getCodAdm());
					detalle.setMmCuo(item.getDetallePagopk().getMmCuo());
					detalle.setNroChe(item.getDetallePagopk().getNroChe());
					detalle.setNroCuo(item.getNroCuo());
					detalle.setImpCuCap(item.getImpCuCap());
					detalle.setImpPago(item.getImpPago());
					detalle.setSituacion(item.getSituacion());
					detalle.setImpCuoInt(item.getImpCuoInt());
					detalle.setImpCuo(item.getImpCuo());
					response.add(detalle);
				}
			}
			log.info("FIN METODO CONSULTA DE PAGOS DETALLES DE PAGO POR SOCIO");
			return response;
		} catch (Exception e) {
			throw new UnprocessableEntityException(Constantes.R500, HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		}
	}

	private boolean validarPartesIdDetalle(String[] partesDetalle) {
		return partesDetalle.length != 3;
	}

	@Override
	public PersonaBean datosPersona(String email) {
		log.info("INICIO METODO DATOS DE LA PERSONA");
		try {
			Optional<Usuario> usuario = usuarioRepository.findByEmail(email);
			PersonaBean persona = new PersonaBean();
			if (usuario.isPresent()) {
				Optional<Persona> p = personaRepository.findByDni(usuario.get().getDni());
				if (p.isPresent()) {
					persona.setDni(p.get().getDni());
					persona.setCodAdm(p.get().getCodAdm());
					persona.setNombreApe(p.get().getNom());
					persona.setSituacion(p.get().getSituacion());
					persona.setGrado(p.get().getGrado());
					persona.setEdad(p.get().getEdad());
					persona.setFechIngreso(p.get().getFechaIng());
					persona.setProceso(p.get().getProceso());
					persona.setAaServicio(p.get().getAaServ());
					persona.setNroApo(p.get().getNroApo());
					persona.setImpApo(p.get().getImpApo());
				}
			}
			log.info("FIN METODO DATOS DE LA PERSONA");
			return persona;
		} catch (Exception e) {
			throw new UnprocessableEntityException(Constantes.R500, HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		}
	}

	@Override
	public List<NoticiasReponse> listaNoticias() {
		log.info("INICIO METODO LISTAR NOTICIAS");
		try {
			Calendar fecha = Calendar.getInstance();
			Integer anio = fecha.get(Calendar.YEAR);
			Integer mes = fecha.get(Calendar.MONTH) + 1;

			List<Noticia> listNoticia = noticiaRepository.findNoticiaMesAnio(String.valueOf(anio), String.valueOf(mes));
			List<NoticiasReponse> response = new ArrayList<>();
			listNoticia.forEach(item -> {
				NoticiasReponse n = new NoticiasReponse();
				n.setTitulo(item.getTitulo());
				n.setAutor(item.getAutor());
				n.setCoAutor(item.getCoAutor());
				n.setFechPubl(item.getFechPubl());
				n.setFuente(item.getFuente());
				n.setImg1(item.getImg1());
				n.setImg2(item.getImg2());
				n.setParrafo1(item.getParrafo1());
				n.setParrafo2(item.getParrafo2());
				n.setParrafo3(item.getParrafo3());
				n.setParrafo4(item.getParrafo4());
				n.setParrafo5(item.getParrafo5());
				n.setParrafo6(item.getParrafo6());
				response.add(n);
			});
			log.info("FIN METODO LISTAR NOTICIAS");
			return response;
		} catch (Exception e) {
			throw new UnprocessableEntityException(Constantes.R500, HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		}
	}

	@Override
	public MensajeBean registrarSolcitudDs(SolicitudDs solicitudDs) {
		log.info("INICIO METODO REGISTRAR SOLICITUD DS");
		try {
			Optional<PersRem> psRem = persRemRepository.findByVCodAdm(solicitudDs.getvCodAdm());
			Optional<PersRemDatos> psRemDatos = persRemDatosRepository.findByVCodAdm(solicitudDs.getvCodAdm());
			if (psRem.isPresent()) {
				if (!psRemDatos.isPresent()) {
					PersRemDatos psDatos = new PersRemDatos();
					psDatos.setvCodAdm(solicitudDs.getvCodAdm());
					psDatos.setvDir(solicitudDs.getDireccion());
					psDatos.setvDist(solicitudDs.getDistrito());
					psDatos.setvProv(solicitudDs.getProvincia());
					psDatos.setvDepa(solicitudDs.getDepartamento());
					psDatos.setvNroCel(solicitudDs.getNroContacto());
					psDatos.setvEmail(solicitudDs.getCorreo());
					psDatos.setvBanco(solicitudDs.getTipoBanco());
					psDatos.setvNroCta(solicitudDs.getNroCuenta());
					psDatos.setvNroCci(solicitudDs.getNroCii());
					psDatos.setdFecIng(new Date());
					persRemDatosRepository.save(psDatos);

					persRemRepository.updateCuenta(solicitudDs.getNroContacto(), solicitudDs.getCorreo(),
							solicitudDs.getDireccion(), solicitudDs.getNroCuenta(), solicitudDs.getNroCii(),
							solicitudDs.getvCodAdm());

					return MensajeUtil.mensajeReponse(Constantes.R200, "Registro solicitud exitoso");
				}

				PersRemDatos psDatos = new PersRemDatos();
				psDatos.setvCodAdm(solicitudDs.getvCodAdm());
				psDatos.setvDir(solicitudDs.getDireccion());
				psDatos.setvDist(solicitudDs.getDistrito());
				psDatos.setvProv(solicitudDs.getProvincia());
				psDatos.setvDepa(solicitudDs.getDepartamento());
				psDatos.setvNroCel(solicitudDs.getNroContacto());
				psDatos.setvEmail(solicitudDs.getCorreo());
				psDatos.setvBanco(solicitudDs.getTipoBanco());
				psDatos.setvNroCta(solicitudDs.getNroCuenta());
				psDatos.setvNroCci(solicitudDs.getNroCii());
				psDatos.setdFecIng(new Date());
				psDatos.setvFlagVerif(psRemDatos.get().getvFlagVerif());
				psDatos.setvFlagReg(psRemDatos.get().getvFlagReg());
				psDatos.setvFlagVouch(psRemDatos.get().getvFlagVouch());
				psDatos.setvFlagCrono(psRemDatos.get().getvFlagCrono());
				psDatos.setvFlagDesem(psRemDatos.get().getvFlagDesem());
				psDatos.setvFlagFalle(psRemDatos.get().getvFlagFalle());
				psDatos.setvFlagAtrasoPres(psRemDatos.get().getvFlagAtrasoPres());
				psDatos.setvAnomesAtraso(psRemDatos.get().getvAnomesAtraso());
				persRemDatosRepository.save(psDatos);

				persRemRepository.updateCuenta(solicitudDs.getNroContacto(), solicitudDs.getCorreo(),
						solicitudDs.getDireccion(), solicitudDs.getNroCuenta(), solicitudDs.getNroCii(),
						solicitudDs.getvCodAdm());
				log.info("FIN METODO REGISTRAR SOLICITUD DS");
				return MensajeUtil.mensajeReponse(Constantes.R200, "SE ACTUALIZARON LOS DATOS");
			} else {
				throw new UnprocessableEntityException(Constantes.R422, HttpStatus.NOT_FOUND,
						"PERSONA REM NO ENCONTRADO");
			}

		} catch (Exception e) {
			throw new UnprocessableEntityException(Constantes.R500, HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		}
	}
}
