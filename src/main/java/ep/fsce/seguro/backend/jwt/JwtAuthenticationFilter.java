//package ep.fsce.seguro.backend.jwt;
//
//import java.io.IOException;
//import java.util.Collections;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//import ep.fsce.seguro.backend.entity.dto.AuthDTO;
//import ep.fsce.seguro.backend.util.TokenUtils;
//
//public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
//
//	@Override
//	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
//			throws AuthenticationException {
//
//		AuthDTO authCredentials = new AuthDTO();
//
//		try {
//			authCredentials = new ObjectMapper().readValue(request.getReader(), AuthDTO.class);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//
//		UsernamePasswordAuthenticationToken userNamePas = new UsernamePasswordAuthenticationToken(
//				authCredentials.getEmail(), authCredentials.getPwd(), Collections.emptyList());
//
//		return getAuthenticationManager().authenticate(userNamePas);
//	}
//
//	@Override
//	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
//			Authentication authResult) throws IOException, ServletException {
//		UserDetailsImpl userDetails = (UserDetailsImpl) authResult.getPrincipal();
//
//		String token = TokenUtils.createToken(userDetails.getNombre(), userDetails.getUsername());
//
//		response.addHeader("Authorization", "Bearer " + token);
//		response.getWriter().flush();
//
//		super.successfulAuthentication(request, response, chain, authResult);
//	}
//
//}
