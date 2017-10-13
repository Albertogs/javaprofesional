package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import beans.Cliente;

public class GestorClientes {
	DataSource ds;
	public GestorClientes() {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/reflibros");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public void altaCliente(Cliente c) {	
		try(Connection cn = ds.getConnection();){
			String sql = "insert into clientes (usuario, password, email, telefono) values (?, ?, ?, ?)";
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(1, c.getUsuario());
			ps.setString(2, c.getPassword());
			ps.setString(3, c.getEmail());
			ps.setInt(4, c.getTelefono());
			ps.execute();
			
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
	}
	public boolean validarCliente(String usuario, String password) {
		boolean res = false;
		try(Connection cn = ds.getConnection();){
			String sql = "select * from clientes where usuario=? and password=?";
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(1, usuario);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				res=true;
			}			
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		return res;
	} 
	
	
	
	
}
