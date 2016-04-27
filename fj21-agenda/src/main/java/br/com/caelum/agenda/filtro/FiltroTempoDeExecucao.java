package br.com.caelum.agenda.filtro;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;


/**Classe para filtro de tempo de execuxão de cada processo.
 * 
 * 
 * @author Danilo Silva
 *
 */
@WebFilter("/*")
public class FiltroTempoDeExecucao implements Filter {
	

	/**
	 * 
	 * @param request - Servlet que está requisitando o metodo.
	 * @param response -  a resposta que o Servlet irá ter
	 * @param chain - Variavel que controla todo o fluxo de inda e vida.
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// recupera tempo inicial
		long tempoInicial = System.currentTimeMillis();

		//partida no processamento
		chain.doFilter(request, response);

		//recupera o tempo apos ter processado e apresenta no console.
		long tempoFinal = System.currentTimeMillis();
		String uri = ((HttpServletRequest) request).getRequestURI();
		String parametros = ((HttpServletRequest) request).getParameter("logica");
		System.out.println("Tempo da requisicao de " + uri + "?logica=" + parametros + " demorou (ms): "
				+ (tempoFinal - tempoInicial));

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
