package br.com.caelum.agenda.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.mvc.logica.Logica;

/**
 * Fora de aclopamento a Função é criar uma classe generica, que possa receber
 * qualquer tipo de classe e instanciar qualquer tipo de classe. atravez na
 * anotação @WebServlet as paginas podem acessar qualquer tipo de logica.
 * 
 * @author Danilo Silva
 *
 */
@WebServlet("/mvc")
public class ControllerServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Recupera o paremetro passado pelas paginas com o nome de logica e
		// cria o pacote para criar o Objeto
		String parametro = request.getParameter("logica");
		String nomeDaClasse = "br.com.caelum.mvc.logica." + parametro;

		try {
			// cria a classe conforme os dados recebidos
			Class<?> classe = Class.forName(nomeDaClasse);
			// instancia o objeto correto atravez de uma interface
			Logica logica = (Logica) classe.newInstance();
			String pagina = logica.executa(request, response);

			request.getRequestDispatcher(pagina).forward(request, response);

		} catch (Exception e) {
			throw new ServletException("A lógica de negócios causou uma exceção", e);
		}
	}
}