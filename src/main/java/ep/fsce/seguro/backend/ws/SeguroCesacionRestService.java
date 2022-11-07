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
import ep.fsce.seguro.backend.dto.request.DetallePagoDTO;
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
import ep.fsce.seguro.backend.dto.response.PrestamoResponse;
import ep.fsce.seguro.backend.dto.response.TokenResponse;

@RestController
public class SeguroCesacionRestService extends SeguroCesacionRestAbastract {

	// REST 01 - JVEGA
	@PostMapping("/publico/u/registro")
	public ResponseEntity<MensajeBean> registrarUsuario(@RequestBody UsuarioDTO user) {
		return ResponseEntity.ok(seguroCesacionService.registrarUsuario(user));
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
	public ResponseEntity<MensajeBean> enviarCorreoOlvidePassword(@RequestBody EmailDTO email) {
		return ResponseEntity.ok(seguroCesacionService.enviarCorreoOlvidePassword(email));
	}

	// REST 05 - JVEGA
	@PostMapping("/publico/u/recuperar/pass")
	public ResponseEntity<MensajeBean> recuperarPassword(@RequestBody RecoverPassDTO recuperarPass) {
		return ResponseEntity.ok(seguroCesacionService.recuperarPassword(recuperarPass));
	}

	// REST 06 - JVEGA
	@GetMapping("/private/p/prestamo/{dni}")
	public ResponseEntity<List<PrestamoResponse>> consultaPrestamosPorPersona(@PathVariable(value = "dni") String dni) {
		return ResponseEntity.ok(seguroCesacionService.consultaPrestamosPorPersona(dni));
	}

	// REST 07 - JVEGA
	@GetMapping("/private/p/detalle/pago")
	public ResponseEntity<List<DetallePagoResponse>> consultaDetallePago(@RequestBody DetallePagoDTO detallePago) {
		List<DetallePagoResponse> reponse = seguroCesacionService.consultaDetallePago(detallePago);
		return ResponseEntity.ok(reponse);
	}

	// REST 08 - JVEGA
	@PostMapping("/private/p/reporte/detallepago/{dni}")
	public ResponseEntity<Resource> exportDetallePago(@PathVariable(value = "dni") String dni,
			@RequestBody DetallePagoDTO detalle) throws Exception {
		byte[] reporte = seguroCesacionService.exportReportePrestamoPorPersona(dni);
		String sdf = (new SimpleDateFormat("dd/MM/yyyy")).format(new Date());
		StringBuilder stringBuilder = new StringBuilder().append(dni);
		ContentDisposition contentDisposition = ContentDisposition.builder("attachment").filename(stringBuilder
				.append("-" + detalle.getMmCuo().toUpperCase()).append("-").append(sdf).append(".pdf").toString())
				.build();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentDisposition(contentDisposition);
		return ResponseEntity.ok().contentLength((long) reporte.length).contentType(MediaType.APPLICATION_PDF)
				.headers(headers).body(new ByteArrayResource(reporte));

	}

	// REST 09 - JVEGA
	@GetMapping("/private/a/aportes/{codAdm}")
	public ResponseEntity<AporteFscecReponse> consultaAportesFscec(@PathVariable(value = "codAdm") String codAdm) {
		AporteFscecReponse response = seguroCesacionService.consultaAportePorPersona(codAdm);
		return ResponseEntity.ok(response);
	}

	// REST 11 - JVEGA
	@GetMapping("/private/s/pagosrecibidos/socio/{codAdm}")
	public ResponseEntity<PagosResponse> consultaPagosRecibidosPorSocio(@PathVariable(value = "codAdm") String codAdm) {
		PagosResponse response = seguroCesacionService.consultaPagosRecibidosPorSocio(codAdm);
		return ResponseEntity.ok(response);
	}

	// REST 13 - JVEGA
	@GetMapping("/private/s/productos")
	public ResponseEntity<ProductosReponse> listaProductos() {
		ProductosReponse reponse = seguroCesacionService.consultaProductos();
		return ResponseEntity.ok(reponse);
	}

	// REST 14 - JVEGA
	@PostMapping("/private/s/solicitud/prestamo")
	public ResponseEntity<MensajeBean> registrarSolicitudPrestamoPorSede(@RequestBody SolicitudPrestamoDTO solicitud) {
		MensajeBean reponse = seguroCesacionService.registrarSolicitud(solicitud);
		return ResponseEntity.ok(reponse);
	}

	// REST 15 - JVEGA
	@GetMapping("/publico/noticias")
	public ResponseEntity<NoticiasReponse> listaNoticia() {
		NoticiasReponse reponse = new NoticiasReponse();
		return ResponseEntity.ok(reponse);
	}

}
