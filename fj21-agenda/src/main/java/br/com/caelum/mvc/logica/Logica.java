package br.com.caelum.mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** Generalização do que deve ser implementado pelas logicas de negocio.
 * 
 * 
 * @author Danilo Silva
 *
 */
public interface Logica {
	String executa(HttpServletRequest req,
            HttpServletResponse res) throws Exception;
}
