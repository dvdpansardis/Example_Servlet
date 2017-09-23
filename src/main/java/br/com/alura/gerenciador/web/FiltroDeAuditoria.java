package br.com.alura.gerenciador.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import br.com.alura.gerenciador.Usuario;

@WebFilter(urlPatterns = "/*")
public class FiltroDeAuditoria implements Filter {

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpReq = (HttpServletRequest) req;
		String uri = httpReq.getRequestURI();

		String usuario = getUsuario(httpReq);

		System.out.println("Usuario: " + usuario);
		System.out.println("Usuario acessando uri: " + uri);
		chain.doFilter(req, res);
	}

	private String getUsuario(HttpServletRequest httpReq) {
		Usuario usuario = (Usuario) httpReq.getSession().getAttribute("usuarioLogado");
		if(usuario == null) return "<deslogado>";
		return usuario.getEmail();
		
//		String usuario = "<deslogado>";
//		if (httpReq.getCookies() != null) {
//			Cookie[] cookies = httpReq.getCookies();
//			for (Cookie cookie : cookies) {
//				if (cookie.getName().equals("usuario.logado")) {
//					cookie.setMaxAge(600);
//					HttpServletResponse resp = (HttpServletResponse) res;
//					resp.addCookie(cookie);
//					usuario = cookie.getValue();
//				}
//			}
//		}
//		return usuario;
	}

}
