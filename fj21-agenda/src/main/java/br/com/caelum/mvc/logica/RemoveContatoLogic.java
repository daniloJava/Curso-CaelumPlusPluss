package br.com.caelum.mvc.logica;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.synth.SynthSeparatorUI;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;


/**Logica para remover o contato 
 * 
 * 
 * @author Danilo Silva
 *
 */
public class RemoveContatoLogic implements Logica{
	
	/**
	 * @param request HttpServletRequest - Recuper o request 
	 * @param response HttpServletResponse- Deve uma resposta
	 * @return String -  a pagina de lista contatos que vai aprentar os dados.
	 */
	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		//Recupera o ID para remoção no BD
		Long id = Long.parseLong(req.getParameter("id"));
		Contato contato = new Contato();
		contato.setId(id);
		
		// recupera a coneção com o banco atravez do atributo do doFilter connection.
		Connection connection = (Connection) req
                .getAttribute("connection");
        
        // passe a conexão no construtor
        ContatoDao dao = new ContatoDao(connection); 
		
        
		System.out.println("Excluindo conato..");
		dao.remove(contato);
		
		return "mvc?logica=ListaContatosLogic";
	}
	
}
