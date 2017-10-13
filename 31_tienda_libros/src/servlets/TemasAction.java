package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.GestorLibros;


@WebServlet("/TemasAction")
public class TemasAction extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GestorLibros g = new GestorLibros();
		List temas = g.recuperarTemas();
		request.setAttribute("temas", temas);
		request.getRequestDispatcher("temas.jsp").forward(request, response);
	}
}
