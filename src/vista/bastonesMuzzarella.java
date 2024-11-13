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

public class bastonesMuzzarella extends JPanel {

	private static final long serialVersionUID = 1L;
	private Pedido pedido;
	private Producto producto;

	/**
	 * Constructor que inicializa los elementos de la interfaz.
	 */
	public bastonesMuzzarella() {
		this(new Pedido()); // Llama al otro constructor con un nuevo pedido como predeterminado
	}

	/**
	 * Constructor que recibe un pedido y carga el producto desde la base de datos.
	 */
	public bastonesMuzzarella(Pedido pedido) {
		this.pedido = pedido;
		setBackground(new Color(0, 128, 192));
		setForeground(new Color(255, 255, 255));
		setBounds(0, 0, 1280, 720);
		setLayout(null);

		// Botón del logo
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

		// Botón del carrito de compras
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

		// Botón de inicio de sesión
		JButton btnIniciarSesion = new JButton("");
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

		// Imagen del producto
		JLabel imagenBastones = new JLabel(new ImageIcon("img\\hamburguesas\\bastonesMuzzaGrande.jpg"));
		imagenBastones.setBounds(104, 107, 601, 489);
		add(imagenBastones);

		// Título del producto
		JLabel lblBastonesTitulo = new JLabel("BASTONES DE MUZZARELLA");
		lblBastonesTitulo.setForeground(new Color(255, 255, 255));
		lblBastonesTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblBastonesTitulo.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 26));
		lblBastonesTitulo.setBounds(715, 107, 398, 33);
		add(lblBastonesTitulo);

		// Botón para añadir al carrito
		JButton btnAgregarCarrito = new JButton("AÑADIR AL CARRITO");
		btnAgregarCarrito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pedido.agregarProducto(producto);
			}
		});
		btnAgregarCarrito.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAgregarCarrito.setBounds(804, 536, 233, 40);
		add(btnAgregarCarrito);

		// Ingredientes del producto
		JLabel lblBastonesIngredientes = new JLabel("Mozzarella, empanizado crujiente, salsa marinara.");
		lblBastonesIngredientes.setForeground(new Color(255, 255, 255));
		lblBastonesIngredientes.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBastonesIngredientes.setBounds(715, 395, 476, 33);
		add(lblBastonesIngredientes);

		// Descripción del producto
		JTextPane txtpnBastonesMuzza = new JTextPane();
		txtpnBastonesMuzza.setForeground(new Color(255, 255, 255));
		txtpnBastonesMuzza.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtpnBastonesMuzza.setText("Los Bastones de Muzzarella son una verdadera delicia para los amantes del queso. Están hechos de mozzarella derretida, envuelta en un crujiente empanizado y fritos hasta alcanzar la perfección dorada. Acompañados de una salsa marinara para mojar.");
		txtpnBastonesMuzza.setBounds(714, 151, 476, 233);
		txtpnBastonesMuzza.setOpaque(false);
		txtpnBastonesMuzza.setBackground(new Color(0, 0, 0, 0));
		add(txtpnBastonesMuzza);

		// Fondo con degradado
		GradientPanel gradientPanel = new GradientPanel(Color.ORANGE, Color.BLUE);
		gradientPanel.setBounds(0, 0, 1280, 720);
		add(gradientPanel);

		// Carga del producto desde la base de datos
		cargarProducto();
	}

	/**
	 * Método para cargar el producto "Bastones de Muzzarella" desde la base de datos.
	 */
	private void cargarProducto() {
		ProductoService productoService = new ProductoService();
		ArrayList<Producto> lista = productoService.traerProductoBD();
		for (Producto p : lista) {
			if (p.getNombre_producto().equalsIgnoreCase("bastonesMuzzarella")) {
				this.producto = p;
				break;
			}
		}
	}
}

