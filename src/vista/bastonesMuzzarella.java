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

	/**
	 * Create the panel.
	 */
	public bastonesMuzzarella() {
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
		
		JLabel imagenBastones = new JLabel(new ImageIcon("img\\hamburguesas\\bastonesMuzzaGrande.jpg"));
		imagenBastones.setBounds(104,107,601,489);
		add(imagenBastones);
		
		JLabel lblBastonesTitulo = new JLabel("BASTONES DE MUZZARELLA");
		lblBastonesTitulo.setForeground(new Color(255, 255, 255));
		lblBastonesTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblBastonesTitulo.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 26));
		lblBastonesTitulo.setBounds(715, 107, 398, 33);
		add(lblBastonesTitulo);
		
		JButton btnAgregarCarrito = new JButton("AÑADIR AL CARRITO");
		btnAgregarCarrito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pedido.agregarProducto(producto);
			}
		});
		btnAgregarCarrito.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAgregarCarrito.setBounds(804, 536, 233, 40);
		add(btnAgregarCarrito);
		
		JLabel lblBastonesIngredientes = new JLabel("Mozzarella, empanizado crujiente, salsa marinara.");
		lblBastonesIngredientes.setForeground(new Color(255, 255, 255));
		lblBastonesIngredientes.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBastonesIngredientes.setBounds(715, 395, 476, 33);
		add(lblBastonesIngredientes);
		
		JTextPane txtpnBastonesMuzza = new JTextPane();
		txtpnBastonesMuzza.setForeground(new Color(255, 255, 255));
		txtpnBastonesMuzza.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtpnBastonesMuzza.setText("Los Bastones de Muzzarella son una verdadera delicia para los amantes del queso. Están hechos de mozzarella derretida, envuelta en un crujiente empanizado y fritos hasta alcanzar la perfección dorada. Acompañados de una salsa marinara para mojar.");
		txtpnBastonesMuzza.setBounds(714, 151, 476, 233);
		txtpnBastonesMuzza.setOpaque(false);
		txtpnBastonesMuzza.setBackground(new Color(0, 0, 0, 0));
		add(txtpnBastonesMuzza);
		
		GradientPanel gradientPanel = new GradientPanel(Color.ORANGE, Color.BLUE);
        gradientPanel.setBounds(0, 0, 1280, 720);
        add(gradientPanel);  
	}
	
	Pedido pedido = new Pedido();
	ProductoService productoService = new ProductoService();
	Producto producto = new Producto();
	public bastonesMuzzarella(Pedido pedido) {
		this();
		this.pedido = pedido;
		ArrayList<Producto> lista = productoService.traerProductoBD();
		for (Producto producto : lista) {
			if(producto.getNombre_producto().equalsIgnoreCase("bastonesMuzzarella")) {
				this.producto = producto;
			}
		}
	}
}
