package modelos;

import java.util.ArrayList;

public class Pedidos {

	private int id_pedido;
	private int costo;
	private boolean tipo_de_entrega;
	
	public Pedidos (int id_pedido, int costo, boolean tipo_de_entrega) {
		super();
		this.id_pedido = id_pedido;
		this.costo = costo;
		this.tipo_de_entrega = tipo_de_entrega;
		}
	
	private ArrayList<Pedidos> pedidos = new ArrayList<>();
	public void agregarCuenta(Pedidos pedidoAgregar) {
		pedidos.add(pedidoAgregar);
	}
	
	public int getId_pedido() {
		return id_pedido;
	}
	public void setId_pedido(int id_pedido) {
		this.id_pedido = id_pedido;
	}
	public float getCosto() {
		return costo;
	}
	public void setCosto(int costo) {
		this.costo = costo;
	}
	public boolean getTipo_de_entrega() {
		return tipo_de_entrega;
	}
	public void setTipo_de_entrega(boolean tipo_de_entrega) {
		this.tipo_de_entrega = tipo_de_entrega;
	}
	
}
