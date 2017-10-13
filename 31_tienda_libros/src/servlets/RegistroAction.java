package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Cliente;
import modelo.GestorClientes;


@WebServlet("/RegistroAction")
public class RegistroAction extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usuario = request.getParameter("usuario");
		String pwd     = request.getParameter("pwd");
		String email   = request.getParameter("email");
		int    tlf     = Integer.parseInt(request.getParameter("tlf"));
		System.out.println("usuario = "+usuario);
		System.out.println("pwd = "+pwd);
		System.out.println("email = "+email);
		System.out.println("tlf = "+tlf);
		
		GestorClientes g = new GestorClientes();
		g.altaCliente(new Cliente(usuario, pwd, email, tlf));
		request.getRequestDispatcher("login.html").forward(request,  response);
	}

}
