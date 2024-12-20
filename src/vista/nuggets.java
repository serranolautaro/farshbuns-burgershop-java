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
import javax.swing.JTextPane;

import modelos.Pedido;
import modelos.Producto;
import service.ProductoService;

public class nuggets extends JPanel {

	private static final long serialVersionUID = 1L;

	private Pedido pedido;
	private ProductoService productoService = new ProductoService();
	private Producto producto;

	public nuggets(Pedido pedido) {
		this.pedido = pedido;
		this.productoService = new ProductoService();
		initialize();
		cargarNuggetsData();
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
		
		JLabel imagenNuggets = new JLabel(new ImageIcon("img\\hamburguesas\\NNuggetsGrande.jpg"));
		imagenNuggets.setBounds(104, 107, 601, 489);
		add(imagenNuggets);
		
		JLabel lblNuggets = new JLabel("NUGGETS");
		lblNuggets.setForeground(new Color(255, 255, 255));
		lblNuggets.setHorizontalAlignment(SwingConstants.CENTER);
		lblNuggets.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 26));
		lblNuggets.setBounds(715, 107, 398, 33);
		add(lblNuggets);
		
		JButton btnAgregarCarrito = new JButton("AÑADIR AL CARRITO");
		btnAgregarCarrito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pedido.agregarProducto(producto); // Añadir el producto al pedido
			}
		});
		btnAgregarCarrito.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAgregarCarrito.setBounds(804, 536, 233, 40);
		add(btnAgregarCarrito);
		
		JLabel lblNuggetsIngredientes = new JLabel("Pollo, empanizado crujiente.");
		lblNuggetsIngredientes.setForeground(new Color(255, 255, 255));
		lblNuggetsIngredientes.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNuggetsIngredientes.setBounds(715, 395, 398, 33);
		add(lblNuggetsIngredientes);
		
		JTextPane txtpnDescNuggets = new JTextPane();
		txtpnDescNuggets.setForeground(new Color(255, 255, 255));
		txtpnDescNuggets.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtpnDescNuggets.setText("Nuestros Nuggets son bocados crujientes y dorados por fuera, tiernos y jugosos por dentro. Perfectos para compartir o disfrutar como acompañamiento, vienen acompañados de una salsa especial que realza su sabor.");
		txtpnDescNuggets.setBounds(715, 151, 433, 233);
		txtpnDescNuggets.setOpaque(false);
		txtpnDescNuggets.setBackground(new Color(0, 0, 0, 0));
		add(txtpnDescNuggets);
		
		GradientPanel gradientPanel = new GradientPanel(Color.ORANGE, Color.BLUE);
        gradientPanel.setBounds(0, 0, 1280, 720);
        add(gradientPanel);  
	}
	
	private void cargarNuggetsData() {
		ArrayList<Producto> lista = productoService.traerProductoBD();
		for (Producto producto : lista) {
			if(producto.getNombre_producto().equalsIgnoreCase("nuggets")) {
				this.producto = producto;
				break; // Detener una vez que encontramos el producto "nuggets"
			}
		}
	}
}

