package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.GestorClientes;


@WebServlet("/LoginAction")
public class LoginAction extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usuario   = request.getParameter("usuario");
		String pwd       = request.getParameter("pwd");
		String recordar  = request.getParameter("recordar");
		
		GestorClientes g = new GestorClientes();
		
		if(g.validarCliente(usuario, pwd)) {
			
			if(recordar!=null) {
				crearCookie(response, usuario);
			}
			else {
				crearCookie(response, "");
			}
			
			request.getRequestDispatcher("TemasAction").forward(request, response);
		}
		
		request.getRequestDispatcher("Error.html").forward(request, response);
	}
	
	private void crearCookie(HttpServletResponse response, String valor){
        //crear objeto Cookie
        Cookie ck=new Cookie("user",valor);
        //periodo de vida
        ck.setMaxAge(100000);
        //Añade cookie a la cabecera de la respuesta
        response.addCookie(ck);
    }

	

}
