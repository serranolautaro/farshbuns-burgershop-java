package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelos.Pedido;

public class PedidoDAO {
	
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
	
	public ArrayList<Pedido> traerTodosLosPedidos() {

		ArrayList<Pedido> pedidos = new ArrayList<>();
		String columnaIdPedidos = "idPedido";
		String columnaCosto = "costo";
		String columnaTipoDeEntrega = "tipoDeEntrega";
		Connection c = null;
		try {
			c = conectar();
			String sql = "SELECT `pedido`.`idPedido`,`pedido`.`costo`,`pedido`.`tipoDeEntrega`FROM `farshbuns`.`pedido`;";
			Statement stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt(columnaIdPedidos);
				int costo = rs.getInt(columnaCosto);
				boolean tipo_de_entrega = rs.getBoolean(columnaTipoDeEntrega);
				Pedido pedido = new Pedido(id, costo, tipo_de_entrega);
				pedidos.add(pedido);
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
		return pedidos;

	}

}
