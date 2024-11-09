package modelos;

import java.util.ArrayList;

public class Local {

	private String nombre_local;
	private String ubicacion_local;
	private int telefono_local;
	private int zona_local;
	
	
	public Local (String nombre_local, String ubicacion_local, int telefono_local, int zona_local) {
		super();
		this.nombre_local = nombre_local;
		this.ubicacion_local = ubicacion_local;
		this.telefono_local = telefono_local;
		this.zona_local = zona_local;
	}
	
	private ArrayList<Local> locales = new ArrayList<>();
	public void agregarLocal(Local localAgregar) {
		locales.add(localAgregar);
	}
	
	public String getNombre_local() {
		return nombre_local;
	}
	public void setNombre_local(String nombre_local) {
		this.nombre_local = nombre_local;
	}
	public String getUbicacion_local() {
		return ubicacion_local;
	}
	public void setUbicacion_local(String ubicacion_local) {
		this.ubicacion_local = ubicacion_local;
	}
	public int getTelefono_local() {
		return telefono_local;
	}
	public void setTelefono_local(int telefono_local) {
		this.telefono_local = telefono_local;
	}
	public int getZona_local() {
		return zona_local;
	}
	public void setZona_local(int zona_local) {
		this.zona_local = zona_local;
	}
	
	
	
}
