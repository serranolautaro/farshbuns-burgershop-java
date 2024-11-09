package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelos.Local;

public class LocalDAO {

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
	
	public ArrayList<Local> traerTodosLosLocales() {

		ArrayList<Local> locales = new ArrayList<>();
		String columnaNombreLocales = "nombreLocal";
		String columnaUbicacionLocales = "ubicacionLocal";
		String columnaTelefonoLocales = "telefonoLocal";
		String columnaZonaLocal = "zonaLocal";
		Connection c = null;
		try {
			c = conectar();
			String sql = "SELECT `local`.`nombreLocal`,`local`.`ubicacionLocal`,`local`.`telefonoLocal`,`local`.`zonaLocal`FROM `farshbuns`.`local`;";
			Statement stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String nombre = rs.getString(columnaNombreLocales);
				String ubicacion = rs.getString(columnaUbicacionLocales);
				int telefono = rs.getInt(columnaTelefonoLocales);
				int zonaLocal = rs.getInt(columnaZonaLocal);
				Local local = new Local(nombre, ubicacion, telefono, zonaLocal);
				locales.add(local);
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
		return locales;

	}
}
