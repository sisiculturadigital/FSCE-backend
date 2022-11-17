package ep.fsce.seguro.backend.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import ep.fsce.seguro.backend.repository.*;

public abstract class SeguroCesacionServiceAbstract {

	@Autowired
	protected AuthenticationManager authenticationManager;

	@Autowired
	protected UserDetailsService usuarioDetailsService;

	@Autowired
	protected BCryptPasswordEncoder encoder;

	@Autowired
	protected UsuarioRepository usuarioRepository;

	@Autowired
	protected TipoUsuarioRepository roleRepository;

	@Autowired
	protected PersonaRepository personaRepository;

	@Autowired
	protected JavaMailSender javaMailSender;

	@Autowired
	protected PrestamosIsnpRepository prestamosIsnpRepository;

	@Autowired
	protected AporteFscecRepository aporteFscecRepository;
	
	@Autowired
	protected ProductoRepository productoRepository;
	
	@Autowired
	protected PreSolicitudRepository solicitudSedeRepository;
	
	@Autowired
	protected PagoRecibidoRepository pagoRecibidoRepository;
	
	@Autowired
	protected DetallePagoRepository detallePagoRepository;
	
	@Autowired
	protected NoticiaRepository noticiaRepository;
	
	@Autowired
	protected LineaProductoRepository lineaProductoRepository;
}

