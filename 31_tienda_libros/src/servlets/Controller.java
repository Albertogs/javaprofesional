package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Controller")
public class Controller extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op=request.getParameter("op");
		String url="";
		switch(op) {
		case "doLogin":
			url="LoginAction";
			break;
		case "doRegistrar":
			url="RegistroAction";
			break;
		case "toRegistro":
			url="registro.html";
			break;
		case "toLogin":
			url="login.jsp";
			break;
		case "doLibros":
			url = "LibrosAction";
			break;
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
}
