package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import beans.Cliente;
import beans.Libro;
import beans.Tema;

public class GestorLibros {
	DataSource ds ;
	
	public GestorLibros() {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/reflibros");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public List<Tema> recuperarTemas(){
		List<Tema> temas = new ArrayList<>();
		try(Connection cn = ds.getConnection();){
			String sql = "select * from temas";
			PreparedStatement ps = cn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				temas.add(new Tema(rs.getString("tema")));
			}
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		return temas;
	}
	public List<Libro> recuperarLibros(int idTema){
		System.out.println("idTema = "+idTema);
		List<Libro> libros = new ArrayList<>();
		String sql = "";
		ResultSet rs = null;
		try(Connection cn = ds.getConnection();){
			if(idTema == 0) {
				sql =  "select * from libros";
				PreparedStatement ps = cn.prepareStatement(sql);
				rs = ps.executeQuery();
			}
			else{
				sql =  "select * from libros where idTema=?";
				PreparedStatement ps = cn.prepareStatement(sql);
				ps.setInt(1, idTema);
				rs = ps.executeQuery();
			}
			
			while(rs.next()) {
				libros.add(new Libro(rs.getString("titulo"),
									 rs.getString("autor"),
									 rs.getDouble("precio"),
									 rs.getInt("paginas"),
									 rs.getInt("idTema")
						));
			}
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		
		return libros;
	}
	
	
}
