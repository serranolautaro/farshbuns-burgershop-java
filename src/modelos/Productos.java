package modelos;

public class Productos {

	private int id_producto;
	private String nombre_producto;
	private boolean esHamburguesa;
	private boolean esAcompaniamiento;
	
	public int getId_producto() {
		return id_producto;
	}
	public void setId_producto(int id_producto) {
		this.id_producto = id_producto;
	}
	public String getNombre_producto() {
		return nombre_producto;
	}
	public void setNombre_producto(String nombre_producto) {
		this.nombre_producto = nombre_producto;
	}
	public boolean getEsHamburguesa() {
		return esHamburguesa;
	}
	public void setEsHamburguesa(boolean esHamburguesa) {
		this.esHamburguesa = esHamburguesa;
	}
	public boolean getEsAcompaniamiento() {
		return esAcompaniamiento;
	}
	public void setEsAcompaniamiento(boolean esAcompaniamiento) {
		this.esAcompaniamiento = esAcompaniamiento;
	}
	
}
