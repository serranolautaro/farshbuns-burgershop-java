package service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import modelos.Producto;

public class ProductoService {
	
	
	public ArrayList<Producto> traerProductoBD() {
		ArrayList<Producto> productos = new ArrayList<>();
        productos.add(new Producto(1, "baconator", true, false));
        productos.add(new Producto(2, "bastonesMuzzarella", false, true));
        productos.add(new Producto(3, "cheeseburger", true, false));
        productos.add(new Producto(4, "nuggets", false, true));
        productos.add(new Producto(5, "veganBurger", true, false));
        return productos;
	}
}
