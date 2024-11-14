package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelos.Pago;

public class PagoDAO {

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
	
	public boolean insertarPago(Pago nuevoPago) {
	    Connection c = null;
	    boolean resultado = false;
	    try {
	        c = conectar();
	        String sql = "INSERT INTO pago (importeTotal, costoPorEnvio, nroTarjeta, codeSec, nombreUsuario, dniUsuario) VALUES (?, ?, ?, ?, ?, ?)";
	        PreparedStatement pstmt = c.prepareStatement(sql);
	        pstmt.setInt(1, nuevoPago.getImporte_total());
	        pstmt.setInt(2, nuevoPago.getCosto_por_envio());
	        pstmt.setInt(3, nuevoPago.getNroTarjeta());
	        pstmt.setInt(4, nuevoPago.getCodeSec());
	        pstmt.setString(5, nuevoPago.getNombreUsuario());
	        pstmt.setInt(6, nuevoPago.getDniUsuario());

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
	
	
	public ArrayList<Pago> traerTodosLosPagos() {

		ArrayList<Pago> pagos = new ArrayList<>();
		String columnaImporteTotal = "importeTotal";
		String columnaCostoPorEnvio = "costoPorEnvio";
		String columnaNroTarjeta = "nroTarjeta";
		String columnaCodeSec = "codeSec";
		String columnaNombreUsuario = "nombreUsuario";
		String columnaDniUsuario = "dniUsuario";
		Connection c = null;
		try {
			c = conectar();
			String sql = "SELECT `pago`.`importeTotal`,`pago`.`costoPorEnvio`,`pago`.`nroTarjeta`,`pago`.`codeSec`,`pago`.`nombreUsuario`,`pago`.`dniUsuario`FROM `farshbuns`.`pago`;";
			Statement stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				int importeTotal = rs.getInt(columnaImporteTotal);
				int costoEnvio = rs.getInt(columnaCostoPorEnvio);
				int nroTarjeta = rs.getInt(columnaNroTarjeta);
				int codigoSeguridad = rs.getInt(columnaCodeSec);
				String nombreUsuario = rs.getString(columnaNombreUsuario);
				int DNIuser = rs.getInt(columnaDniUsuario);
				Pago pago = new Pago(importeTotal, costoEnvio, nroTarjeta, codigoSeguridad, nombreUsuario, DNIuser);
				pagos.add(pago);
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
		return pagos;

	}
}
