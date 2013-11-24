package com.kallSonys.common.dal.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Utils {

	
	/**
	 * Convierte un String a Calendar dado un formato
	 */
	public static Calendar getStringToCalendar(String sbFecha, String formato)
	{
		Calendar calendar = null;
		SimpleDateFormat formatoDelTexto = null;
		
		if(sbFecha != null && formato != null)
		{
			calendar = Calendar.getInstance();
			Date fecha = null;
			try{
				formatoDelTexto = new SimpleDateFormat(formato);
				fecha = formatoDelTexto.parse(sbFecha);
				calendar.setTime(fecha);
			} catch (Exception e) {
				calendar = null;
			}finally{
				formatoDelTexto = null;
			}
		}

		return calendar;
	}
	
	
}
