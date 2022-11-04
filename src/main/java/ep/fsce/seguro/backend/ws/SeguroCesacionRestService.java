package ep.fsce.seguro.backend.ws;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ep.fsce.seguro.backend.dto.MensajeBean;
import ep.fsce.seguro.backend.dto.request.AuthDTO;
import ep.fsce.seguro.backend.dto.request.EmailDTO;
import ep.fsce.seguro.backend.dto.request.PwdDTO;
import ep.fsce.seguro.backend.dto.request.RecoverPassDTO;
import ep.fsce.seguro.backend.dto.request.UsuarioDTO;
import ep.fsce.seguro.backend.dto.response.PrestamoResponse;
import ep.fsce.seguro.backend.dto.response.TokenResponse;

@RestController
public class SeguroCesacionRestService extends SeguroCesacionRestAbastract {

	// REST 01 - JVEGA
	@PostMapping("/publico/u/registro")
	public MensajeBean registrarUsuario(@RequestBody UsuarioDTO user) {
		return seguroCesacionService.registrarUsuario(user);
	}

	// REST 02 - JVEGA
	@PostMapping("/publico/u/authenticate")
	public ResponseEntity<TokenResponse> authenticateToken(@RequestBody AuthDTO authDto) {
		TokenResponse tokenInfo = seguroCesacionService.authenticateToken(authDto);
		return ResponseEntity.ok(tokenInfo);
	}

	// REST 03 - JVEGA
	@PutMapping("/private/u/actualizar/pass")
	public ResponseEntity<MensajeBean> actualizarPassword(@RequestBody PwdDTO pwd) {
		return ResponseEntity.ok(seguroCesacionService.actualizarPassword(pwd));
	}

	// REST 04 - JVEGA
	@PostMapping("/publico/u/enviarcorreo/pass")
	public MensajeBean enviarCorreoOlvidePassword(@RequestBody EmailDTO email) {
		return seguroCesacionService.enviarCorreoOlvidePassword(email);
	}

	// REST 05 - JVEGA
	@PostMapping("/publico/u/recuperar/pass")
	public MensajeBean recuperarPassword(@RequestBody RecoverPassDTO recuperarPass) {
		return seguroCesacionService.recuperarPassword(recuperarPass);
	}

	// REST 06 - JVEGA
	@GetMapping("/private/p/prestamo/{dni}")
	public ResponseEntity<List<PrestamoResponse>> consultaPrestamosPorPersona(@PathVariable(value = "dni") String dni) {
		return ResponseEntity.ok(seguroCesacionService.consultaPrestamosPorPersona(dni));
	}

	// REST 07 - JVEGA
	@PostMapping("/private/p/reporteprestamo/{dni}")
	public ResponseEntity<Resource> exportReportePrestamoPorPersona(@PathVariable(value = "dni") String dni)
			throws Exception {
		byte[] reporte = seguroCesacionService.exportReportePrestamoPorPersona(dni);
		String sdf = (new SimpleDateFormat("dd/MM/yyyy")).format(new Date());
		StringBuilder stringBuilder = new StringBuilder().append("exportPrestamoPDF:");
		ContentDisposition contentDisposition = ContentDisposition.builder("attachment")
				.filename(stringBuilder.append(dni).append("generateDate:").append(sdf).append(".pdf").toString())
				.build();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentDisposition(contentDisposition);
		return ResponseEntity.ok().contentLength((long) reporte.length).contentType(MediaType.APPLICATION_PDF)
				.headers(headers).body(new ByteArrayResource(reporte));

	}

	// REST 09 - JVEGA
	@GetMapping("/private/a/aportes/{tipoArpote}")
	public ResponseEntity<MensajeBean> consultaAportes(@PathVariable(value = "tipoArpote") String tipoArpote) {
		MensajeBean msj = new MensajeBean();
		return ResponseEntity.ok(msj);
	}

	// REST 10 - JVEGA
	@PostMapping("/private/a/reporteaportes/{tipoAporte}")
	public ResponseEntity<MensajeBean> exportReporteAportes(@PathVariable(value = "tipoAporte") String arpote) {
		MensajeBean msj = new MensajeBean();
		return ResponseEntity.ok(msj);
	}

	// REST 11 - JVEGA
	@GetMapping("/private/s/pagosrecibidos/socio/{dni}")
	public ResponseEntity<MensajeBean> consultaPagosRecibidosPorSocio(@PathVariable(value = "dni") String dni) {
		MensajeBean msj = new MensajeBean();
		return ResponseEntity.ok(msj);
	}

	// REST 12 - JVEGA
	@PostMapping("/private/ds/solcitud/{dni}")
	public ResponseEntity<MensajeBean> registrarSolicitudDs(@PathVariable(value = "dni") String documento) {
		MensajeBean msj = new MensajeBean();
		return ResponseEntity.ok(msj);
	}

	// REST 13 - JVEGA
	@PostMapping("/private/p/guardararchivo/{dni}")
	public ResponseEntity<MensajeBean> guardarArchivosPorPersona(
			@PathVariable(value = "dni") String documentoIdentidad) {
		MensajeBean msj = new MensajeBean();
		return ResponseEntity.ok(msj);
	}

	// REST 14 - JVEGA
	@PostMapping("/private/s/solicitud/prestamo/{codSede}")
	public ResponseEntity<MensajeBean> registrarSolicitudPrestamoPorSede(
			@PathVariable(value = "codSede") String codSede) {
		MensajeBean msj = new MensajeBean();
		return ResponseEntity.ok(msj);
	}

}
