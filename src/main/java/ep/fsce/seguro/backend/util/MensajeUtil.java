package ep.fsce.seguro.backend.util;

import ep.fsce.seguro.backend.dto.MensajeBean;

public class MensajeUtil extends MensajeBean {

	public static MensajeBean mensajeReponse(String codigo, String msg) {
		MensajeBean bean = new MensajeBean();
		bean.setCode(codigo);
		bean.setMessage(msg);
		return bean;
	}
}
