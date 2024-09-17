package vista;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class nuggets extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public nuggets() {
		setBackground(new Color(0, 128, 192));
		setForeground(new Color(255, 255, 255));
		setBounds(0, 0, 1280, 720);
		setLayout(null);
		
		JButton btnLogo = new JButton("");
		btnLogo.setIcon(new ImageIcon("C:\\Users\\Taro\\eclipse-workspace\\ProyectoFARSHBUNS\\img\\logo\\logo5.png"));
		btnLogo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame marco = (JFrame) SwingUtilities.getWindowAncestor((Component) e.getSource());
				marco.setContentPane(new pantallaPrincipal());
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
				marco.setContentPane(new carritoCompras());
				marco.validate();
			}
		});
		btnCarritoCompras.setIcon(new ImageIcon("C:\\Users\\Taro\\eclipse-workspace\\ProyectoFARSHBUNS\\img\\pantallaPrincipal\\carrito.png"));
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
		
		btnIniciarSesion.setIcon(new ImageIcon("C:\\Users\\Taro\\eclipse-workspace\\ProyectoFARSHBUNS\\img\\pantallaPrincipal\\usuario.png"));
		btnIniciarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame marco = (JFrame) SwingUtilities.getWindowAncestor((Component) e.getSource());
				marco.setContentPane(new inicioSesion());
				marco.validate();
			}
		});
		btnIniciarSesion.setBounds(1128, 11, 62, 59);
		add(btnIniciarSesion);
		
		JLabel imagenNuggets = new JLabel(new ImageIcon("C:\\Users\\Taro\\eclipse-workspace\\ProyectoFARSHBUNS\\img\\hamburguesas\\baconatorImagenGrande.png"));
		imagenNuggets.setBounds(104,107,601,489);
		add(imagenNuggets);
		
		JLabel lblNuggets = new JLabel("NUGGETS");
		lblNuggets.setHorizontalAlignment(SwingConstants.CENTER);
		lblNuggets.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 26));
		lblNuggets.setBounds(715, 107, 398, 33);
		add(lblNuggets);
		
		JLabel lblNuggetsDescripcion = new JLabel("Nuestros Nuggets son bocados crujientes y dorados por fuera, tiernos y jugosos por dentro. Perfectos para compartir o disfrutar como acompañamiento, vienen acompañados de una salsa especial que realza su sabor.");
		lblNuggetsDescripcion.setVerticalAlignment(SwingConstants.TOP);
		lblNuggetsDescripcion.setHorizontalAlignment(SwingConstants.CENTER);
		lblNuggetsDescripcion.setBounds(715, 176, 398, 208);
		add(lblNuggetsDescripcion);
		
		JButton btnAgregarCarrito = new JButton("AÑADIR AL CARRITO");
		btnAgregarCarrito.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAgregarCarrito.setBounds(804, 536, 233, 40);
		add(btnAgregarCarrito);
		
		JLabel lblNuggetsIngredientes = new JLabel("Ingredientes: Pollo, empanizado crujiente.");
		lblNuggetsIngredientes.setBounds(715, 395, 398, 33);
		add(lblNuggetsIngredientes);


	}

}
