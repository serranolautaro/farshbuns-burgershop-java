package vista;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import modelos.Pedido;
import modelos.Producto;
import service.ProductoService;

import javax.swing.JTextPane;

public class cheeseBurger extends JPanel {

	private static final long serialVersionUID = 1L;

	Pedido pedido;
	ProductoService productoService = new ProductoService();
	Producto producto;

	public cheeseBurger(Pedido pedido) {
		this.pedido = pedido;
		this.productoService = new ProductoService();
		initialize();
		cargarCheeseBurger();
	}
	
	private void initialize() {
		setBackground(new Color(0, 128, 192));
		setForeground(new Color(255, 255, 255));
		setBounds(0, 0, 1280, 720);
		setLayout(null);
		
		JButton btnLogo = new JButton("");
		btnLogo.setIcon(new ImageIcon("img\\logo\\logo5.png"));
		btnLogo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame marco = (JFrame) SwingUtilities.getWindowAncestor((Component) e.getSource());
				marco.setContentPane(new pantallaPrincipal(pedido));
				marco.validate();
			}
		});
		btnLogo.setOpaque(false);
		btnLogo.setBorderPainted(false);
		btnLogo.setContentAreaFilled(false);
		btnLogo.setBounds(10, 11, 119, 100);
		add(btnLogo);
		
		JButton btnCarritoCompras = new JButton("");
		btnCarritoCompras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame marco = (JFrame) SwingUtilities.getWindowAncestor((Component) e.getSource());
				marco.setContentPane(new carritoCompras(pedido));
				marco.validate();
			}
		});
		btnCarritoCompras.setIcon(new ImageIcon("img\\pantallaPrincipal\\carrito.png"));
		btnCarritoCompras.setBounds(1016, 11, 83, 59);
		btnCarritoCompras.setOpaque(false);
		btnCarritoCompras.setBorderPainted(false);
		btnCarritoCompras.setContentAreaFilled(false);
		add(btnCarritoCompras);
		
		JButton btnIniciarSesion = new JButton("");
		btnIniciarSesion.setBackground(new Color(255, 255, 255));
		btnIniciarSesion.setOpaque(false);
		btnIniciarSesion.setBorderPainted(false);
		btnIniciarSesion.setContentAreaFilled(false);
		
		btnIniciarSesion.setIcon(new ImageIcon("img\\pantallaPrincipal\\usuario.png"));
		btnIniciarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame marco = (JFrame) SwingUtilities.getWindowAncestor((Component) e.getSource());
				marco.setContentPane(new inicioSesion());
				marco.validate();
			}
		});
		btnIniciarSesion.setBounds(1128, 11, 62, 59);
		add(btnIniciarSesion);
		
		JLabel imagenCheeseburger = new JLabel(new ImageIcon("img\\hamburguesas\\cheeseburgerSimpleGrande.jpg"));
		imagenCheeseburger.setBounds(104,107,601,489);
		add(imagenCheeseburger);
		
		JLabel lblCheeseburgerTitulo = new JLabel("CHEESE BURGER");
		lblCheeseburgerTitulo.setForeground(new Color(255, 255, 255));
		lblCheeseburgerTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblCheeseburgerTitulo.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 26));
		lblCheeseburgerTitulo.setBounds(715, 107, 398, 33);
		add(lblCheeseburgerTitulo);
		
		JButton btnAgregarCarrito = new JButton("AÑADIR AL CARRITO");
		btnAgregarCarrito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pedido.agregarProducto(producto);
			}
		});
		btnAgregarCarrito.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAgregarCarrito.setBounds(804, 536, 233, 40);
		add(btnAgregarCarrito);
		
		JLabel lblCheeseburgerIngredientes = new JLabel("Carne de res, queso cheddar, pan de hamburguesa.");
		lblCheeseburgerIngredientes.setForeground(new Color(255, 255, 255));
		lblCheeseburgerIngredientes.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCheeseburgerIngredientes.setBounds(715, 395, 419, 33);
		add(lblCheeseburgerIngredientes);
		
		JTextPane txtpnDescCheeseBurger = new JTextPane();
		txtpnDescCheeseBurger.setForeground(new Color(255, 255, 255));
		txtpnDescCheeseBurger.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtpnDescCheeseBurger.setText("Nuestra Cheese Burger clásica es perfecta para los amantes del queso. Con dos capas de jugosa carne de res, cubiertas con una generosa porción de queso cheddar derretido, todo dentro de un pan esponjoso. Es una delicia simple pero irresistible.");
		txtpnDescCheeseBurger.setBounds(715, 151, 419, 233);
		txtpnDescCheeseBurger.setOpaque(false);
		txtpnDescCheeseBurger.setBackground(new Color(0, 0, 0, 0));
		add(txtpnDescCheeseBurger);
		
		GradientPanel gradientPanel = new GradientPanel(Color.ORANGE, Color.BLUE);
        gradientPanel.setBounds(0, 0, 1280, 720);
        add(gradientPanel);  
	}
	
	private void cargarCheeseBurger() {
		ArrayList<Producto> lista = productoService.traerProductoBD();
		for (Producto producto : lista) {
			if(producto.getNombre_producto().equalsIgnoreCase("cheeseburger")) {
				this.producto = producto;
				break;
			}
		}
	}
}

