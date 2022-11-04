package ep.fsce.seguro.backend.ws;

import org.springframework.beans.factory.annotation.Autowired;

import ep.fsce.seguro.backend.services.SeguroCesacionService;

public abstract class SeguroCesacionRestAbastract {

	@Autowired
	protected SeguroCesacionService seguroCesacionService;

}
