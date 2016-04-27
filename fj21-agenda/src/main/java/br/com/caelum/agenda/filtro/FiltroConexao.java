package br.com.caelum.agenda.filtro;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import br.com.caelum.jdbc.ConnectionFactory;

/**Classe de Filtro para criar uma conexão com o BD antes de acessar a pagina
 * e fecha depois da execução da pagina.
 * 
 * @author Danilo Silva
 *
 */

@WebFilter("/*")
public class FiltroConexao implements Filter{

	/**
	 * 
	 * @param request - Servlet que está requisitando o metodo.
	 * @param response -  a resposta que o Servlet irá ter
	 * @param chain - Variavel que controla todo o fluxo de inda e vida.
	 */
	public void doFilter(ServletRequest request, 
	        ServletResponse response, FilterChain chain)
	        throws IOException, ServletException {
	                
	    try {
	    	//cria conexão
	        Connection connection = new ConnectionFactory()
	                .getConnection();
	        
	        // pendurando a connection na requisição atribuindo um atributo e a conexão criada     
	        request.setAttribute("connection", connection);
	        
	        //inicio do precessamento da requet com a conexão aberta
	        chain.doFilter(request, response);
	        
	        //apos ter passado fecha a conexão
	        connection.close();
	    } catch (SQLException e) {
	        throw new ServletException(e);
	    }
	}
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
}
