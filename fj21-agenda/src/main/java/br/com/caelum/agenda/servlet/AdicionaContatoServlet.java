package br.com.caelum.agenda.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.ServerException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

/**Classe para adicionar um contato de forma com Servlet
 * De uma forma que toda logica seria criar uma nova servlet.
 * 
 * @author Danilo Silva
 *
 */
@WebServlet("/adicionaContato")
public class AdicionaContatoServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServerException {

		// buscando os parâmetros no request
		String nome = request.getParameter("nome");
		String endereco = request.getParameter("endereco");
		String email = request.getParameter("email");
		String dataEmTexto = request.getParameter("dataNascimento");
		Calendar dataNascimento = null;

		// fazendo a conversão da data.

		try {
			Date data = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
			dataNascimento = Calendar.getInstance();
			dataNascimento.setTime(data);

		} catch (ParseException e) {
			System.out.println("Erro na conversão da data");
		}

		// monta um objeto contato
		Contato contato = new Contato();
		contato.setNome(nome);
		contato.setEndereco(endereco);
		contato.setEmail(email);
		contato.setDataNascimento(dataNascimento);

		// salva o contato
		try {
			Connection connection = (Connection) request.getAttribute("connection");
			
			ContatoDao dao = new ContatoDao(connection);
			dao.adiciona(contato);
			RequestDispatcher rd = request
			        .getRequestDispatcher("/contato-adicionado.jsp");
			rd.forward(request,response);
			
		} catch (ServletException e) {
			System.out.println("Erro ao redirecionar a pagina");
			e.printStackTrace();
		}	

	
		
		
	}
}
