package br.com.zaul.geo.bean;

/**
 * 
 * @author thiago
 *
 */
public enum GeoStatus {
	
	/** OK */
	OK,
	
	/** Nenhum resultado */
	ZERO_RESULTS,
	
	/** Limite de pesquisas expirado */
	OVER_QUERY_LIMIT,
	
	/** Requisicao Negada. Verificar parametro SENSOR da URL */
	REQUEST_DENIED,
	
	/** Faltando parametros */
	INVALID_REQUEST

}
