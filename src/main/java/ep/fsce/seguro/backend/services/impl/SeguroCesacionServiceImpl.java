package ep.fsce.seguro.backend.services.impl;

import java.io.File;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import ep.fsce.seguro.backend.domain.PagoRecibido;
import ep.fsce.seguro.backend.domain.Persona;
import ep.fsce.seguro.backend.domain.PrestamoInsp;
import ep.fsce.seguro.backend.domain.Producto;
import ep.fsce.seguro.backend.domain.PreSolicitud;
import ep.fsce.seguro.backend.domain.TipoUsuario;
import ep.fsce.seguro.backend.domain.Usuario;
import ep.fsce.seguro.backend.dto.AporteFscecPersona;
import ep.fsce.seguro.backend.dto.MensajeBean;
import ep.fsce.seguro.backend.dto.PagoRecibidoBean;
import ep.fsce.seguro.backend.dto.Prestamo;
import ep.fsce.seguro.backend.dto.ProductoBean;
import ep.fsce.seguro.backend.dto.request.AuthDTO;
import ep.fsce.seguro.backend.dto.request.EmailDTO;
import ep.fsce.seguro.backend.dto.request.PwdDTO;
import ep.fsce.seguro.backend.dto.request.RecoverPassDTO;
import ep.fsce.seguro.backend.dto.request.SolicitudPrestamoDTO;
import ep.fsce.seguro.backend.dto.request.UsuarioDTO;
import ep.fsce.seguro.backend.dto.response.AporteFscecReponse;
import ep.fsce.seguro.backend.dto.response.DetallePagoResponse;
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

@Service
public class SeguroCesacionServiceImpl extends SeguroCesacionServiceAbstract implements SeguroCesacionService {

	@Override
	public MensajeBean registrarUsuario(UsuarioDTO user) {
		try {
			if (!ParametersValidateUtil.cumpleValidacionUsuario(user)) {
				return MensajeUtil.mensajeReponse("422", "Debe ingresar todos los campos solicitados");
			}
			Optional<Persona> pe = personaRepository.findByDniAndCodAdmAndFecNac(user.getDni(), user.getCodAdm(),
					user.getFechaNac());
			if (pe.isPresent()) {
				Optional<Usuario> isUser = usuarioRepository.findByDniAndCodAdm(pe.get().getDni(),
						pe.get().getCodAdm());
				if (isUser.isPresent()) {
					return MensajeUtil.mensajeReponse("422", "Usted ya se encuentra registrado");
				}
				TipoUsuario r = roleRepository.findByTipoUsuario(Integer.parseInt(user.getCodRole()));
				if (!Objects.isNull(r)) {
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
					return MensajeUtil.mensajeReponse("200", "Registro de usuario éxitoso");
				} else {
					return MensajeUtil.mensajeReponse("422", "Codigo de rol invalido");
				}

			} else {
				return MensajeUtil.mensajeReponse("422", "Ingrese correctamente sus datos");
			}

		} catch (Exception e) {
			return MensajeUtil.mensajeReponse("422", e.getMessage());
		}
	}

	@Override
	public TokenResponse authenticateToken(AuthDTO authDto) {
		authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(authDto.getEmail(), authDto.getPwd()));
		UserDetailsImpl userDetails = (UserDetailsImpl) usuarioDetailsService.loadUserByUsername(authDto.getEmail());
		String jwt = TokenUtils.createToken(userDetails.getNombre(), userDetails.getUsername());
		return new TokenResponse(jwt);
	}

	@Override
	public MensajeBean actualizarPassword(PwdDTO pwd) {
		Optional<Usuario> u = usuarioRepository.findByEmail(pwd.getEmail());
		if (u.isPresent()) {
			u.get().setPassword(encoder.encode(pwd.getNewPwd()));
			usuarioRepository.save(u.get());
			return MensajeUtil.mensajeReponse("200", "Password actualizado");
		} else {
			return MensajeUtil.mensajeReponse("422", "Datos incorrectos");
		}
	}

	@Override
	public MensajeBean enviarCorreoOlvidePassword(EmailDTO email) {
		try {
			Optional<Usuario> p = usuarioRepository.findByEmail(email.getTo());
			if (!p.isPresent()) {
				return MensajeUtil.mensajeReponse("422", "Correo no registrado");
			}
			MimeMessage msg = javaMailSender.createMimeMessage();
			MimeMessageHelper message = new MimeMessageHelper(msg, true);
			message.setFrom(email.getTo());
			message.setTo(email.getTo());
			message.setText(email.getMessage(), true);
			message.setSubject(email.getSubject());
			javaMailSender.send(msg);
			return MensajeUtil.mensajeReponse("200", "Correo enviado");
		} catch (Exception ex) {
			return MensajeUtil.mensajeReponse("500", "Correo no enviado " + ex.getMessage());
		}
	}

	@Override
	public MensajeBean recuperarPassword(RecoverPassDTO recuperarPass) {
		Optional<Persona> pe = personaRepository.findByDniAndCodAdmAndFecNac(recuperarPass.getDni(),
				recuperarPass.getCodAdm(), recuperarPass.getFechaNac());
		if (pe.isPresent()) {
			Optional<Usuario> u = usuarioRepository.findByEmail(recuperarPass.getEmail());
			if (u.isPresent()) {
				u.get().setPassword(encoder.encode(recuperarPass.getPassword()));
				usuarioRepository.save(u.get());
				return MensajeUtil.mensajeReponse("200", "Password actualizado");
			} else {
				return MensajeUtil.mensajeReponse("422", "Datos incorrectos");
			}
		}
		return MensajeUtil.mensajeReponse("200", "Constraseña Actualizada");
	}

	@Override
	public List<SaldoTipoPrestamoResponse> consultaPrestamosPorPersona(String dni) {
		List<PrestamoInsp> lstPrestamo = prestamosIsnpRepository.findByDni(dni);
		List<SaldoTipoPrestamoResponse> response = new ArrayList<>();
		Map<String, List<PrestamoInsp>> groupByPrestamo = groupByPrestamoIsnp(lstPrestamo);
		groupByPrestamo.forEach((key, value) -> {
			List<Prestamo> listPrestamo = new ArrayList<>();
			SaldoTipoPrestamoResponse s = new SaldoTipoPrestamoResponse();
			s.setTipoPrestamo(key);
			value.forEach(item -> {
				Prestamo p = new Prestamo();
				p.setNroChe(item.getNroChe());
				p.setCodAdm(item.getCodAdm());
				p.setDest(item.getDest());
				p.setTipoPrest(item.getTipoPrest());
				p.setAnoEnv(item.getAnoEnv());
				p.setMesEnv(item.getMesEnv());
				p.setImpSol(item.getImpSol());
				p.setDeudaTotIni(item.getDeudaTotIni());
				p.setFecAprob(item.getFecAprob());
				p.setImpDesmbls(item.getImpDesmbls());
				p.setNroCuo(item.getNroCuo());
				p.setCuoMen(item.getCuoMen());
				p.setCuoCap(item.getCuoCap());
				p.setIntereses(item.getIntereses());
				p.setSaldoActual(item.getSaldoActual());
				p.setSaldoSint(item.getSaldoSint());
				p.setDni(item.getDni());
				p.setSaldoVigente(item.getSaldoVigente());
				p.setSaldoVigenteCap(item.getSaldoVigenteCap());
				p.setAtraso(item.getAtraso());
				p.setDevGracia(item.getDevGracia());
				p.setTipoDscto(item.getTipoDscto());
				p.setCodEp(item.getCodEp());
				p.setCodCpmp(item.getCodCpmp());
				p.setRefinancia(item.getRefinancia());
				listPrestamo.add(p);
			});
			s.setPrestamos(listPrestamo);
			response.add(s);
		});
		return response;
	}

	private static Map<String, List<PrestamoInsp>> groupByPrestamoIsnp(List<PrestamoInsp> empleados) {
		return empleados.stream().collect(Collectors.groupingBy(PrestamoInsp::getTipoPrest, Collectors.toList()));
	}

	@Override
	public ResponseEntity<Resource> exportReportePrestamoPorPersona(String dni) {
		Optional<Persona> persona = personaRepository.findByDni(dni);
		JasperPrint jasperPrint = null;
		if (persona.isPresent()) {
			try {
				List<Persona> listPersona = new ArrayList<>();
				listPersona.add(persona.get());

				ClassPathResource resource = new ClassPathResource(
						"reportes" + File.separator + "reportSaldoPrestamo.jasper");
				InputStream jasperStream = resource.getInputStream();
				JasperReport report = (JasperReport) JRLoader.loadObject(jasperStream);
				HashMap<String, Object> parameter = new HashMap<>();

				parameter.put("dsPersona", new JRBeanArrayDataSource(listPersona.toArray()));
				jasperPrint = JasperFillManager.fillReport(report, parameter, new JREmptyDataSource());

				byte[] reporte = JasperExportManager.exportReportToPdf(jasperPrint);

				String sdf = (new SimpleDateFormat("dd/MM/yyyy")).format(new Date());
				StringBuilder stringBuilder = new StringBuilder().append(dni);
				ContentDisposition contentDisposition = ContentDisposition.builder("attachment")
						.filename(stringBuilder.append("-").append(sdf).append(".pdf").toString()).build();
				HttpHeaders headers = new HttpHeaders();
				headers.setContentDisposition(contentDisposition);
				return ResponseEntity.ok().contentLength((long) reporte.length).contentType(MediaType.APPLICATION_PDF)
						.headers(headers).body(new ByteArrayResource(reporte));
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			return ResponseEntity.noContent().build();
		}
		return null;
	}

	@Override
	public AporteFscecReponse consultaAportePorPersona(String codAdm) {
		List<AporteFscec> aporte = aporteFscecRepository.findByCodAdm(codAdm);
		AporteFscecReponse reponse = new AporteFscecReponse();
		List<AporteFscecPersona> listAporteFscec = new ArrayList<>();
		DecimalFormat df = new DecimalFormat(Constantes.DECIMAL_FORMAT_05);
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
				totalAporte = totalAporte + item.getImpApa();
				i++;
			}
			reponse.setTotalAportes(df.format(totalAporte));
			reponse.setTotalCuotas(String.valueOf(i));
			reponse.setAportes(listAporteFscec);
		}
		return reponse;
	}

	@Override
	public ProductosReponse consultaProductos() {
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
		return response;
	}

	@Override
	public MensajeBean registrarSolicitud(SolicitudPrestamoDTO solicitud) {
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
			throw new UnprocessableEntityException("422", HttpStatus.NOT_FOUND, "DNI no registrado");
		}
		return MensajeUtil.mensajeReponse("200", "Registro solicitud exitoso");
	}

	@Override
	public PagosResponse consultaPagosRecibidosPorSocio(String codAdm) {
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
		return response;
	}

	@Override
	public List<DetallePagoResponse> consultaDetallePago(String codAdm, String idDetalle) {
		String[] partesIdDetalle = idDetalle.split(Constantes.GUION);
		if (validarPartesIdDetalle(partesIdDetalle)) {
			throw new UnprocessableEntityException("422", HttpStatus.BAD_REQUEST,
					"Ingrese correctamente detalle NRO-AA-MM");
		}
		String nroChe = partesIdDetalle[0];
		String aaCuo = partesIdDetalle[1];
		String mmCuo = partesIdDetalle[2];
		if (!ParametersValidateUtil.validarCamposIdDetalle(codAdm, nroChe, aaCuo, mmCuo)) {
			throw new UnprocessableEntityException("422", HttpStatus.BAD_REQUEST,
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
		return response;
	}

	private boolean validarPartesIdDetalle(String[] partesDetalle) {
		return partesDetalle.length != 3;
	}

}
