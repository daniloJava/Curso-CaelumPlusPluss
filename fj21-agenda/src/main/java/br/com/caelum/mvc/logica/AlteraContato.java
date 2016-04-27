package br.com.caelum.mvc.logica;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

/**Altera contato atravez de uma servlet
 * 
 * 
 * @author Danilo Silva
 *
 */

public class AlteraContato implements Logica {

	/**
	 * @param request HttpServletRequest - Recuper o request 
	 * @param response HttpServletResponse- Deve uma resposta
	 * @return String -  de listar os contatos.
	 */
	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//recupera e cria o um contato atravez do ID passado.
		Contato contato = new Contato();
		Long id = Long.parseLong(request.getParameter("id"));
		contato.setId(id);
		contato.setNome(request.getParameter("nome"));
		contato.setEmail(request.getParameter("email"));
		contato.setEndereco(request.getParameter("endereco"));
		
		//Converte a data corretamente.
		String dataEmTexto = request.getParameter("dataNascimento");
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		Calendar data = Calendar.getInstance();
		data.setTime(formato.parse(dataEmTexto));
		
		contato.setDataNascimento(data);
		
		System.out.println("Atualizando contato...");
		//recupera a coneção com o banco atravez do atributo do doFilter connection.
		Connection connection = (Connection) request.getAttribute("connection");
		
		//cria um DAO passando a conexão. E altera o contato.
		ContatoDao dao = new ContatoDao(connection);
		dao.altera(contato);
		
		
		return "mvc?logica=ListaContatosLogic";
	}

}