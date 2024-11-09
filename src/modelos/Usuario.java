package modelos;

import java.util.ArrayList;

public class Usuario {

	private int idUsuario;
	private String nombreUsuario;
	private String contraseniaUsuario;
	private String ubicacion;
	private int telefono;
	
	public Usuario(int idUsuario, String nombreUsuario, String contraseniaUsuario, String ubicacion, int telefono) {
		super();
		this.idUsuario = idUsuario;
		this.nombreUsuario = nombreUsuario;
		this.contraseniaUsuario = contraseniaUsuario;
		this.ubicacion = ubicacion;
		this.telefono = telefono;
	}
	
	private ArrayList<Usuario> usuarios = new ArrayList<>();
	public void agregarCuenta(Usuario usuarioAgregar) {
		usuarios.add(usuarioAgregar);
	}
	
	public int getId_usuario() {
		return idUsuario;
	}
	public void setId_usuario(int id_usuario) {
		this.idUsuario = id_usuario;
	}
	public String getNombre_usuario() {
		return nombreUsuario;
	}
	public void setNombre_usuario(String nombre_usuario) {
		this.nombreUsuario = nombre_usuario;
	}
	public String getContraseñaUsuario() {
		return contraseniaUsuario;
	}
	public void setContraseñaUsuario(String contraseñaUsuario) {
		this.contraseniaUsuario = contraseñaUsuario;
	}
	public String getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	
	
}
