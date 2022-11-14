package ep.fsce.seguro.backend.ws;

import java.util.List;

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
import ep.fsce.seguro.backend.dto.request.SolicitudPrestamoDTO;
import ep.fsce.seguro.backend.dto.request.UsuarioDTO;
import ep.fsce.seguro.backend.dto.response.AporteFscecReponse;
import ep.fsce.seguro.backend.dto.response.DetallePagoResponse;
import ep.fsce.seguro.backend.dto.response.NoticiasReponse;
import ep.fsce.seguro.backend.dto.response.PagosResponse;
import ep.fsce.seguro.backend.dto.response.ProductosReponse;
import ep.fsce.seguro.backend.dto.response.SaldoTipoPrestamoResponse;
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
	public ResponseEntity<List<SaldoTipoPrestamoResponse>> consultaPrestamosPorPersona(@PathVariable(value = "dni") String dni) {
		return ResponseEntity.ok(seguroCesacionService.consultaPrestamosPorPersona(dni));
	}

	// REST 07 - JVEGA nro-aa-mm
	@GetMapping("/private/p/detalle/{codAdm}/pago/{idDetalle}")
	public ResponseEntity<List<DetallePagoResponse>> consultaDetallePago(@PathVariable(value = "codAdm") String codAdm,
			@PathVariable(value = "idDetalle") String idDetalle) {
		List<DetallePagoResponse> reponse = seguroCesacionService.consultaDetallePago(codAdm, idDetalle);
		return ResponseEntity.ok(reponse);
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
