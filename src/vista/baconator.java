package vista;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;

public class baconator extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public baconator() {
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
		
		JLabel imagenBaconator = new JLabel(new ImageIcon("C:\\Users\\Taro\\eclipse-workspace\\ProyectoFARSHBUNS\\img\\hamburguesas\\baconatorImagenGrande.png"));
		imagenBaconator.setBounds(104,107,601,489);
		add(imagenBaconator);
		
		JLabel lblBaconator = new JLabel("BACONATOR");
		lblBaconator.setHorizontalAlignment(SwingConstants.CENTER);
		lblBaconator.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 30));
		lblBaconator.setBounds(715, 107, 398, 33);
		add(lblBaconator);
		
		JButton btnAgregarCarrito = new JButton("AÑADIR AL CARRITO");
		btnAgregarCarrito.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAgregarCarrito.setBounds(804, 536, 233, 40);
		add(btnAgregarCarrito);
		
		JLabel lblBaconatorIngredientes = new JLabel("Carne de res, bacon, queso cheddar, pan de hamburguesa.");
		lblBaconatorIngredientes.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBaconatorIngredientes.setBounds(715, 395, 475, 33);
		add(lblBaconatorIngredientes);
		
		JTextPane textPaneDescripcionBaconator = new JTextPane();
		textPaneDescripcionBaconator.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textPaneDescripcionBaconator.setText("La Baconator es una hamburguesa épica para los amantes del bacon. Cuenta con dos jugosas hamburguesas de carne de res, acompañadas de seis tiras crujientes de bacon, cubiertas con abundante queso cheddar derretido. Todo esto en un pan suave que hace que cada bocado sea una explosión de sabor.");
		textPaneDescripcionBaconator.setBounds(715, 151, 475, 233);
		textPaneDescripcionBaconator.setOpaque(false);
		textPaneDescripcionBaconator.setBackground(new Color(0, 0, 0, 0));
		add(textPaneDescripcionBaconator);
		
		GradientPanel gradientPanel = new GradientPanel(Color.ORANGE, Color.BLUE);
        gradientPanel.setBounds(0, 0, 1280, 720);
        add(gradientPanel);  

	}
}
