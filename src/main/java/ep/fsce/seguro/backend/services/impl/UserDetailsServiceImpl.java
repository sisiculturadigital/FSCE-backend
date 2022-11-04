package ep.fsce.seguro.backend.services.impl;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ep.fsce.seguro.backend.domain.Usuario;
import ep.fsce.seguro.backend.jwt.UserDetailsImpl;
import ep.fsce.seguro.backend.repository.UsuarioRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	protected UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Usuario u = usuarioRepository.findByEmail(email);
		if (!Objects.isNull(u)) {
			return new UserDetailsImpl(u);

		} else {
			throw new UsernameNotFoundException("El usuario " + email + " no existe");
		}
	}

}
