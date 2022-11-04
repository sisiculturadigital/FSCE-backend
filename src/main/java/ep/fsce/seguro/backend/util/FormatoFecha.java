package ep.fsce.seguro.backend.util;

import java.time.format.DateTimeFormatter;

public class FormatoFecha {
	public static final String ZONA_HORARIA = "GMT-5:00";
	public static final String yyyyMMdd = "yyyy-MM-dd";
	public static final String ddMMyyyy = "dd-MM-yyyy";
	public static final String MMyyyy_SLASH = "MM/yyyy";
	public static final String MMddyyyy_SLASH = "MM/dd/yyyy";
	public static final String MMyyyy = "MMyyyy";
	public static final String ddMMyyyy_SLASH = "dd/MM/yyyy";
	public static final String ddMMyyyyHHmmss_SLASH = "dd/MM/yyyy HH:mm:ss";
	public static final String HHmmssa_TWO_POINTS = "HH:mm:ss a";
	public static final String ddMMyyyyHHmmss = "dd-MM-yyyy HH:mm:ss";
	public static final String ddMMyyyyHHmm = "dd-MM-yyyy HH:mm";
	public static final String ddMMyyyy_SIN_GUION = "ddMMyyyy";
	public static final String yyyyMMddTHHmmssSSSXXX = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX";
	public static final String ddMMyyyyHHmmss_SIMPLE = "ddMMyyyyHHmmss";
	public static final String yyyyMMddHHmmss_SIMPLE = "yyyyMMddHHmmss";
	public static final String FORMAT_FECHA_YYYYMM = "yyyyMM";
	public static final String FORMAT_FECHA_DDMMYYYY = "dd/MM/yyyy";
	public static final String FORMAT_FECHA_YYYYMMDD = "yyyy-MM-dd";
	public static final String FORMAT_FECHA_YYYYMM01 = "yyyy-MM-01";
	public static final String FORMAT_FECHA_YYYYMMDD_CORTO = "yyyyMMdd";
	public static final String FORMAT_FECHA_DDMMYYYY_CORTO = "ddMMyyyy";
	public static final String FORMAT_FECHAHORA_YYYYMMDDHHMMSS = "yyyy-MM-dd HH:mm:ss";
	public static final String FORMAT_FECHAHORA_DDMMYYYYHHMMSS = "dd/MM/yyyy HH:mm:ss";
	public static final String FORMAT_HORA_HHMMSS = "HH:mm:ss";
	public static final String FORMAT_HORA_HHMM = "HH:mm";
	public static final String FORMAT_HORA_ENVIO_BUZON = "dd/MM/yyyy-HH:mm:ss";
	public static final String FORMAT_HORA_ENVIO_EMAIL = "ddMMyyyy_HHmmss";
	public static final String FORMAT_FECHA_01MMYYYY = "01/MM/yyyy";
	public static final String FORMAT_FECHA_MMYYYY = "/MM/yyyy";
	public static final String FECHA_HORA_POR_DEFECTO = "01/01/0001 00:00:00";
	public static final String FECHA_POR_DEFECTO = "01/01/0001";
	public static final String FECHA_FIN_POR_DEFECTO = "31/12/2100";
	public static final String yyyyMMdd_HHmmss = "yyyyMMdd_HHmmss";

	public static final DateTimeFormatter dtm_yyyyMM = DateTimeFormatter.ofPattern(FORMAT_FECHA_YYYYMM);
}
