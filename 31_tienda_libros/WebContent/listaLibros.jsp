<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List, beans.Libro"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
		<%
			List<Libro> libros = (List<Libro>) request.getAttribute("libros");
		%>
		<table border="1">
			<tr>
				<th>Titulo</th><th>Autor</th><th>Precio</th><th>Paginas</th><th>IdTema</th>
			</tr>
			<%for(Libro l : libros){ %>
				<tr>
					<td><%=l.getTitulo()%></td> <td><%=l.getAutor()%></td><td><%=l.getPrecio()%></td><td><%=l.getPaginas()%></td><td><%=l.getIdTema()%></td>
				</tr>
		
			<%} %>
		</table>
		
		<br/><br/><br/>
		<a href="Controller?op=toLogin">volver a temas</a>
	</center>
</body>
</html>