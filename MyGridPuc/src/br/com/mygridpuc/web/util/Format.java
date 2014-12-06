package br.com.mygridpuc.web.util;

/**
 * Classe com formatos dos dias da semana
 * 
 * @author David Rodrigues
 *
 */
public abstract class Format {

	public static Integer strDiaSemanaToInt(String diaSemana){
		diaSemana = diaSemana.toUpperCase();
		switch (diaSemana){

		case "DOM":	
			return 1;
		case "SEG":
			return 2;
		case "TER":	
			return 3;
		case "QUA":	
			return 4;
		case "QUI":	
			return 5;
		case "SEX":	
			return 6;
		case "SÁB":	
			return 7;
		case "SAB":	
			return 7;
		default:
			return 0;
		}
	}
}
