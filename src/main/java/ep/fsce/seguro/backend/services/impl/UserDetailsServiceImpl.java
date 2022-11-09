package ep.fsce.seguro.backend.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ep.fsce.seguro.backend.domain.Usuario;
import ep.fsce.seguro.backend.exception.UnprocessableEntityException;
import ep.fsce.seguro.backend.jwt.UserDetailsImpl;
import ep.fsce.seguro.backend.repository.UsuarioRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	protected UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<Usuario> u = usuarioRepository.findByEmail(email);
		if (!u.isPresent()) {
			throw new UnprocessableEntityException("500", HttpStatus.INTERNAL_SERVER_ERROR, "No se encontró usuario");
		}
		if (u.isPresent()) {
			return new UserDetailsImpl(u.get());
		} else {
			throw new UsernameNotFoundException("El usuario " + email + " no existe");
		}
	}

}
