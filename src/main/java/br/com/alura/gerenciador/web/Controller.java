package br.com.alura.gerenciador.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/executa")
public class Controller extends HttpServlet {

	private static final String PACKAGE_CONTROLLERS = "br.com.alura.gerenciador.web.";
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String tarefa = req.getParameter("tarefa");
		
		if(tarefa == null) throw new IllegalArgumentException("Tarefa não informada.");
		
		tarefa = PACKAGE_CONTROLLERS + tarefa;
		
		try {
			Class<?> tipo = Class.forName(tarefa);
			Tarefa instancia = (Tarefa) tipo.newInstance();
			String pagina = instancia.executa(req, res);
			RequestDispatcher requestDispatcher = req.getRequestDispatcher(pagina);
			requestDispatcher.forward(req, res);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			throw new ServletException(e);
		}
	}

}
