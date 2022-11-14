package ep.fsce.seguro.backend.ws;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import ep.fsce.seguro.backend.services.SeguroCesacionService;
import org.springframework.core.io.Resource;

@Controller
public class ReporteDetalleController {
	@Autowired
	protected SeguroCesacionService seguroCesacionService;

	// REST 08 - JVEGA
	@GetMapping(value = "/publico/pdf/{dni}", produces = MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<Resource> exportDetallePago(@PathVariable(value = "dni") String dni) {
		return seguroCesacionService.exportReportePrestamoPorPersona(dni);
	}
}
