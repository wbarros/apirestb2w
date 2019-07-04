package com.b2w.recomendacoes.apirest.util;

import java.text.DateFormat;
import java.text.Normalizer;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {
	
	public static String toSlug(String input) {
	    String nowhitespace = input.replaceAll(" ","-");
	    String normalized = Normalizer.normalize(nowhitespace, Normalizer.Form.NFD).replaceAll("\\p{M}", "");
	    return normalized.toLowerCase();
	}
	
	public static String dateFormat(Date date) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
		return dateFormat.format(date); 
	}
}
