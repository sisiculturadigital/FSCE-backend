package ep.fsce.seguro.backend.services.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import ep.fsce.seguro.backend.domain.PrestamoInsp;
import ep.fsce.seguro.backend.domain.TipoUsuario;
import ep.fsce.seguro.backend.domain.Usuario;
import ep.fsce.seguro.backend.dto.MensajeBean;
import ep.fsce.seguro.backend.dto.PersonaBean;
import ep.fsce.seguro.backend.dto.request.AuthDTO;
import ep.fsce.seguro.backend.dto.request.EmailDTO;
import ep.fsce.seguro.backend.dto.request.PwdDTO;
import ep.fsce.seguro.backend.dto.request.RecoverPassDTO;
import ep.fsce.seguro.backend.dto.request.UsuarioDTO;
import ep.fsce.seguro.backend.dto.response.PrestamoResponse;
import ep.fsce.seguro.backend.dto.response.TokenResponse;
import ep.fsce.seguro.backend.jwt.UserDetailsImpl;
import ep.fsce.seguro.backend.services.SeguroCesacionService;
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

@Service
public class SeguroCesacionServiceImpl extends SeguroCesacionServiceAbstract implements SeguroCesacionService {

	@Override
	public MensajeBean registrarUsuario(UsuarioDTO user) {
		try {
			if (!ParametersValidateUtil.cumpleValidacionUsuario(user)) {
				return MensajeUtil.mensajeReponse("422", "Debe ingresar todos los campos solicitados");
			}

			Optional<PersonaBean> pe = personaRepository.findByDniAndCodAdmAndFecNac(user.getDni(), user.getCodAdm(),
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

					return MensajeUtil.mensajeReponse("200", "Usuario registrado éxitoso");

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
		Usuario u = usuarioRepository.findByEmail(pwd.getEmail());
		if (!Objects.isNull(u)) {
			u.setPassword(encoder.encode(pwd.getNewPwd()));
			usuarioRepository.save(u);
			return MensajeUtil.mensajeReponse("200", "Password actualizado");
		} else {
			return MensajeUtil.mensajeReponse("422", "Datos incorrectos");
		}
	}

	@Override
	public MensajeBean enviarCorreoOlvidePassword(EmailDTO email) {
		MensajeBean msj = new MensajeBean();
		try {
			SimpleMailMessage message = new SimpleMailMessage();
			message.setFrom("randy.vdiaz@gmail.com");
			message.setTo(email.getTo());
			message.setText(email.getMessage());
			message.setSubject(email.getSubject());
			javaMailSender.send(message);
			msj.setCode("200");
			msj.setMessage("Correo enviado");
			return msj;
		} catch (Exception ex) {
			msj.setCode("200");
			msj.setMessage("Correo no enviado " + ex.getMessage());
			return msj;
		}

	}

	@Override
	public MensajeBean recuperarPassword(RecoverPassDTO recuperarPass) {
		return null;
	}

	@Override
	public List<PrestamoResponse> consultaPrestamosPorPersona(String dni) {
		List<PrestamoInsp> lstPrestamo = prestamosIsnpRepository.findByDni(dni);
		List<PrestamoResponse> response = new ArrayList<>();
		if (!lstPrestamo.isEmpty()) {
			for (PrestamoInsp item : lstPrestamo) {
				PrestamoResponse p = new PrestamoResponse();
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
				response.add(p);
			}
		}

		return response;
	}

	@Override
	public byte[] exportReportePrestamoPorPersona(String dni) throws Exception {
		Optional<PersonaBean> persona = personaRepository.findByDni(dni);
		JasperPrint jasperPrint = null;
		if (persona.isPresent()) {
			List<PersonaBean> listPersona = new ArrayList<>();
			listPersona.add(persona.get());
			File file = ResourceUtils.getFile("classpath:reportSaldoPrestamo.jasper");
			JasperReport report = (JasperReport) JRLoader.loadObject(file);
			HashMap<String, Object> parameter = new HashMap<>();
			parameter.put("dsPersona", new JRBeanArrayDataSource(listPersona.toArray()));
			jasperPrint = JasperFillManager.fillReport(report, parameter, new JREmptyDataSource());
		}
		return JasperExportManager.exportReportToPdf(jasperPrint);
	}

}
