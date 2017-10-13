<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List, beans.Tema"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
		<%
			List<Tema> temas = (List<Tema>) request.getAttribute("temas");  
		%>
		
		<form action="Controller?op=doLibros" method="post">
			<select name="tema">
				<option value="0">Todos</option>
				<%for(Tema t : temas){%>
					<option value=<%=t.getIdTema()%>><%=t.getTema()%></option>
				<%}%>
			</select>
			<br/>
			<input type="submit">
		</form>
		<br/><br/>
		<a href="Controller?op=toLogin">volver</a>
		
		
	</center>
</body>
</html>