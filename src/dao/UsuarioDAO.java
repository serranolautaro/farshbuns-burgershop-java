package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelos.Usuario;

public class UsuarioDAO {
	
	private Connection conectar() {
		String url = "jdbc:mysql://localhost:3306/farshbuns";
		String usr = "root";
		String pass = "admin";
		Connection c = null;
		try {
			c = DriverManager.getConnection(url, usr, pass);
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		return c;
	}
	
	public boolean insertarUsuario(Usuario nuevoUsuario) {
	    Connection c = null;
	    boolean resultado = false;
	    try {
	        c = conectar();
	        String sql = "INSERT INTO usuario (nombreUsuario, contraseniaUsuario, ubicacionUsuario, telefonoUsuario) VALUES (?, ?, ?, ?)";
	        PreparedStatement pstmt = c.prepareStatement(sql);
	        pstmt.setString(1, nuevoUsuario.getNombre_usuario());
	        pstmt.setString(2, nuevoUsuario.getContraseñaUsuario());
	        pstmt.setString(3, nuevoUsuario.getUbicacion());
	        pstmt.setInt(4, nuevoUsuario.getTelefono());

	        int filasAfectadas = pstmt.executeUpdate();
	        if (filasAfectadas > 0) {
	            resultado = true;
	        }
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    } finally {
	        try {
	            if (c != null) {
	                c.close();
	            }
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }
	    }
	    return resultado;
	}
	
	public ArrayList<Usuario> traerTodasLosUsuarios() {

		ArrayList<Usuario> usuarios = new ArrayList<>();
		String ColumnaIdUsuario = "idUsuario";
		String columnaNombre = "nombreUsuario";
		String columnaContrasenia = "contraseniaUsuario";
		String columnaUbicacion = "ubicacionUsuario";
		String columnaTelefono = "telefonoUsuario";
		Connection c = null;
		try {
			c = conectar();
			String sql = "SELECT `usuario`.`idUsuario`,`usuario`.`nombreUsuario`,`usuario`.`contraseniaUsuario`,`usuario`.`ubicacionUsuario`,`usuario`.`telefonoUsuario`FROM `farshbuns`.`usuario`;";
			Statement stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt(ColumnaIdUsuario);
				String nombre = rs.getString(columnaNombre);
				String contrasenia = rs.getString(columnaContrasenia);
				String ubicacion = rs.getString(columnaUbicacion);
				int telefono = rs.getInt(columnaTelefono);
				Usuario usuario = new Usuario(id, nombre, contrasenia, ubicacion, telefono);
				usuarios.add(usuario);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (c != null) {
					c.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		return usuarios;

	}
	
	public boolean eliminarUsuario(Usuario usuario) {
	    Connection c = null;
	    boolean resultado = false;
	    try {
	        c = conectar();
	        String sql = "DELETE FROM usuario WHERE idUsuario = ?";
	        PreparedStatement pstmt = c.prepareStatement(sql);
	        pstmt.setInt(1, usuario.getId_usuario());

	        int filasAfectadas = pstmt.executeUpdate();
	        if (filasAfectadas > 0) {
	            resultado = true;
	        }
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    } finally {
	        try {
	            if (c != null) {
	                c.close();
	            }
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }
	    }
	    return resultado;
	}

}
