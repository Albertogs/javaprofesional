<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
		<%	Cookie[] cks = request.getCookies();
	  		String usuario = null;
			if(cks !=null){
				for(Cookie ck: cks){
					if(ck.getName().equals("ususario")){
						usuario = ck.getValue(); 
					}
				}
			}
	%>
		<form action="Controller?op=doLogin" method="post">
			Usuario:    <input type="text" name="usuario" value='<%=usuario!=null?usuario:""%>'/><br/>
			Contraseña: <input type="password" name="pwd"/><br/>
			
			<input type="submit" value="entrar">
		</form>
		<br/>
		<input type="checkbox" name="recordar" value="1"/> Recordar
		<br/><br/>
		<a href="Controller?op=toRegistro">Registrarse</a>
	</center>
</body>
</html>