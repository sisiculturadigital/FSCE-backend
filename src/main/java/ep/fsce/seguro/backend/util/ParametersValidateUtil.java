package ep.fsce.seguro.backend.util;

import ep.fsce.seguro.backend.dto.request.AuthDTO;
import ep.fsce.seguro.backend.dto.request.UsuarioDTO;

public class ParametersValidateUtil {

	public static boolean cumpleValidacionUsuario(UsuarioDTO user) {

		if (user.getEmail().isEmpty() || user.getEmail() == null) {
			return false;
		}

		if (user.getPassword().isEmpty() || user.getPassword() == null) {
			return false;
		}

		if (user.getNombres().isEmpty() || user.getNombres() == null) {
			return false;
		}

		if (user.getApellidos().isEmpty() || user.getApellidos() == null) {
			return false;
		}

		if (user.getDni().isEmpty() || user.getDni() == null) {
			return false;
		}

		if (user.getFechaNac().toString().isEmpty() || user.getFechaNac() == null) {
			return false;
		}

		if (user.getCodAdm().isEmpty() || user.getCodAdm() == null) {
			return false;
		}

		return true;
	}

	public static boolean cumpleValidacionSession(AuthDTO auth) {
		
		if (auth.getEmail().isEmpty() || auth.getEmail() == null) {
			return false;
		}

		if (auth.getPwd().isEmpty() || auth.getPwd() == null) {
			return false;
		}

		return true;
	}
}
