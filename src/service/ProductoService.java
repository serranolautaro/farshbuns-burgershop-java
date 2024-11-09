package service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import modelos.Producto;

public class ProductoService {
	
	
	public ArrayList<Producto> traerProductoBD() {
		ArrayList<Producto> productos = new ArrayList<>();
        productos.add(new Producto(1, "Baconator", true, false));
        productos.add(new Producto(2, "Hamburguesa con Queso", true, false));
        productos.add(new Producto(3, "Papas Fritas", false, true));
        productos.add(new Producto(4, "Aros de Cebolla", false, true));
        productos.add(new Producto(5, "Hamburguesa Doble", true, false));
        productos.add(new Producto(6, "Ensalada", false, true));
        productos.add(new Producto(7, "Hamburguesa Vegetariana", true, false));
        productos.add(new Producto(8, "Refresco", false, true));
        productos.add(new Producto(9, "Agua Mineral", false, true));
        productos.add(new Producto(10, "Hamburguesa BBQ", true, false));
        
        return productos;
	}
}
