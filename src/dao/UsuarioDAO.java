package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelos.Usuarios;

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
	
	public ArrayList<Usuarios> traerTodasLosUsuarios() {

		ArrayList<Usuarios> usuarios = new ArrayList<>();
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
				Usuarios usuario = new Usuarios(id, nombre, contrasenia, ubicacion, telefono);
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
}
