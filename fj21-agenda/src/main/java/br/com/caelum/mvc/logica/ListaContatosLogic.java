package br.com.caelum.mvc.logica;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

/**
 * Lista contato de forma correta
 * 
 * @author Danilo Silva
 *
 */
public class ListaContatosLogic implements Logica {

	/**
	 * @param request HttpServletRequest - Recuper o request 
	 * @param response HttpServletResponse- Deve uma resposta
	 * @return String -  a pagina de lista contatos que vai aprentar os dados.
	 */
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// recupera a coneção com o banco atravez do atributo do doFilter
		// connection.
		Connection connection = (Connection) req.getAttribute("connection");

		// cria um Dao e uma lista
		ContatoDao dao = new ContatoDao(connection);
		List<Contato> contatos = dao.getLista();
		
		//Repassa a lista por atributo
		req.setAttribute("contatos", contatos);

		return "lista-contatos.jsp";
	}
}