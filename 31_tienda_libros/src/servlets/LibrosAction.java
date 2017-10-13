package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Libro;
import modelo.GestorLibros;


@WebServlet("/LibrosAction")
public class LibrosAction extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idTema = Integer.parseInt(request.getParameter("tema"));
		GestorLibros g = new GestorLibros();
		List<Libro> libros = g.recuperarLibros(idTema);
		request.setAttribute("libros", libros);
		request.getRequestDispatcher("listaLibros.jsp").forward(request, response);
	}
}
