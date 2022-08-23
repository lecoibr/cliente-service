package br.com.talent.util;

public class Constante {
	
	public static final String HTTP_400 = "Invalid input parameters";
	public static final String HTTP_401 = "Not authorized";
	public static final String HTTP_403 = "Forbidden";
	public static final String HTTP_404 = "Not Found";
	public static final String HTTP_500 = "Unknown Error";
	
	public static final String LOG_INFO_INSERT = "method=insert entity={} id={} message={}";
	public static final String LOG_INFO_UPDATE = "method=update entity={} id={} message={}";
	public static final String LOG_INFO_DELETE = "method=delete entity={} id={} message={}";
	public static final String LOG_ERROR_PERSISTENCE = "method={} entity={} cause={}";
	
	public static final String NOT_FOUND = "Nenhum registro encontrado";
	public static final String ID_ALREADY_REGISTERED = "Id j\u00e1 cadastrado";
	public static final String COMMISSION_CONFLICT = "Este registro conflita com os registro: %s";

}
