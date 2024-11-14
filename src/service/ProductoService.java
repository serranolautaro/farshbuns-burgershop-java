package service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import modelos.Producto;

public class ProductoService {
	
	
	public ArrayList<Producto> traerProductoBD() {
		ArrayList<Producto> productos = new ArrayList<>();
        productos.add(new Producto(1, "baconator", 12500, true, false));
        productos.add(new Producto(2, "bastonesMuzzarella", 5000, false, true));
        productos.add(new Producto(3, "cheeseburger", 9000, true, false));
        productos.add(new Producto(4, "nuggets", 6500,false, true));
        productos.add(new Producto(5, "veganBurger",11000 , true, false));
        return productos;
	}
}
