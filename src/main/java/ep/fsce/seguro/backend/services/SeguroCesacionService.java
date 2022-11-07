package ep.fsce.seguro.backend.services;

import java.util.List;

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
import ep.fsce.seguro.backend.dto.response.PagosResponse;
import ep.fsce.seguro.backend.dto.response.PrestamoResponse;
import ep.fsce.seguro.backend.dto.response.ProductosReponse;
import ep.fsce.seguro.backend.dto.response.TokenResponse;

public interface SeguroCesacionService {
	
	public MensajeBean registrarUsuario(UsuarioDTO user);

	public TokenResponse authenticateToken(AuthDTO authDto);

	public MensajeBean actualizarPassword(PwdDTO pwd);

	public MensajeBean enviarCorreoOlvidePassword(EmailDTO emailDto);

	public MensajeBean recuperarPassword(RecoverPassDTO recuperarPass);

	public List<PrestamoResponse> consultaPrestamosPorPersona(String dni);
	
	public byte[] exportReportePrestamoPorPersona(String dni) throws Exception;

	public AporteFscecReponse consultaAportePorPersona(String codAdm);

	public ProductosReponse consultaProductos();

	public MensajeBean registrarSolicitud(SolicitudPrestamoDTO solicitud);

	public PagosResponse consultaPagosRecibidosPorSocio(String codAdm);

	public List<DetallePagoResponse> consultaDetallePago(DetallePagoDTO detallePago);

}
