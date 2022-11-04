package ep.fsce.seguro.backend.util;

import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	private static final SimpleDateFormat formatDefault = new SimpleDateFormat(Constantes.FORMAT_DATE_NUMBER);
	static SimpleDateFormat sdf = new SimpleDateFormat(Constantes.FORMAT_DATE_SHOW);

	/**
	 * 
	 * @param dateAsString
	 * @return
	 * @throws ParseException
	 */
	public static Date stringToDate(String dateAsString) throws ParseException {
		return stringToDate(dateAsString, Constantes.FORMAT_DATE_SHOW);
	}

	/**
	 * 
	 * @param dateAsString
	 * @param format
	 * @return
	 * @throws ParseException
	 */
	public static Date stringToDate(String dateAsString, String format) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Date date = sdf.parse(dateAsString);
		return new Date(date.getTime());
	}

	/**
	 * 
	 * @param date
	 * @param format
	 * @return
	 * @throws ParseException
	 */
	public static String dateToString(Date date, String format) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		String dateAsString = sdf.format(date);
		return dateAsString;
	}

	public static String dateToStringFormat(Date date, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		String dateAsString = sdf.format(date);
		return dateAsString;
	}

	public static String dateToStringFormatEmpty(Date date, String format) {
		String dateAsString = "";
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			dateAsString = sdf.format(date);
		} catch (Exception e) {
			dateAsString = StringUtils.EMPTY;
		}
		return dateAsString;
	}

	/**
	 * 
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static String dateToStringYYYYMMDD(Date date) throws ParseException {
		String dateAsString = DateUtil.dateToString(date, "yyyy/MM/dd");
		return dateAsString;
	}

	/**
	 * 
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static String dateToStringYYYYMMDDFormat(Date date) throws ParseException {
		String dateAsString = DateUtil.dateToString(date, "yyyy-MM-dd");
		return dateAsString;
	}

	/**
	 * 
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static String dateToStringDDMMYYY(Date date) throws ParseException {
		String dateAsString = DateUtil.dateToString(date, "dd/MM/yyy");
		return dateAsString;
	}

	public static String dateToStringFortmatDDMMYYY(Date date) {
		String dateAsString = "";
		try {
			dateAsString = DateUtil.dateToString(date, "dd/MM/yyy");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return dateAsString;
	}

	/**
	 * 
	 * @param fecha
	 * @return
	 * @throws ParseException
	 */
	public static Date fechasinhhmmss(Date fecha) throws ParseException {
		String fec = new SimpleDateFormat(Constantes.FORMAT_DATE_SHOW).format(fecha);
		Date f1 = new SimpleDateFormat(Constantes.FORMAT_DATE_SHOW).parse(fec);
		return f1;
	}

	/**
	 * 
	 * @param fecha <code>java.util.Date</code>
	 * @return <code>java.lang.Integer</code>
	 */
	public static Integer dateToInteger(Date fecha) {
		if (fecha == null)
			return -1;
		return new Integer(formatDefault.format(fecha));
	}

	public static Boolean dateIsValid(String fecha) {
		SimpleDateFormat sdf = new SimpleDateFormat(FormatoFecha.FORMAT_FECHA_YYYYMMDD_CORTO);
		try {
			sdf.parse(fecha);
		} catch (ParseException e) {
			return false;
		}
		return true;
	}

	public static String fechaCambio(String fecha) {
		try {
			Date dateCambio = DateUtil.stringToDate(fecha, FormatoFecha.FORMAT_FECHA_DDMMYYYY);
			return DateUtil.dateToString(dateCambio, FormatoFecha.FORMAT_FECHA_YYYYMMDD_CORTO);
		} catch (Exception e) {
			return null;
		}
	}

	public static String fechaCambioBean(String fecha) {
		try {
			Date dateCambio = DateUtil.stringToDate(fecha, FormatoFecha.FORMAT_FECHA_YYYYMMDD_CORTO);
			return DateUtil.dateToString(dateCambio, FormatoFecha.FORMAT_FECHA_DDMMYYYY);
		} catch (Exception e) {
			return null;
		}
	}
}