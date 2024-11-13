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
import javax.swing.JTextPane;

public class veganBurger extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public veganBurger() {
		setBackground(new Color(0, 128, 192));
		setForeground(new Color(255, 255, 255));
		setBounds(0, 0, 1280, 720);
		setLayout(null);
		
		JButton btnLogo = new JButton("");
		btnLogo.setIcon(new ImageIcon("img\\logo\\logo5.png"));
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
		
		JLabel imagenVeganBurger = new JLabel(new ImageIcon("img\\hamburguesas\\veganburgerGrande.jpg"));
		imagenVeganBurger.setBounds(104,107,601,489);
		add(imagenVeganBurger);
		
		JLabel lblVeganBurger = new JLabel("VEGAN BURGER");
		lblVeganBurger.setForeground(new Color(255, 255, 255));
		lblVeganBurger.setHorizontalAlignment(SwingConstants.CENTER);
		lblVeganBurger.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 26));
		lblVeganBurger.setBounds(715, 107, 398, 33);
		add(lblVeganBurger);
		
		JButton btnAgregarCarrito = new JButton("AÑADIR AL CARRITO");
		btnAgregarCarrito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnAgregarCarrito.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAgregarCarrito.setBounds(804, 536, 233, 40);
		add(btnAgregarCarrito);
		
		JLabel lblVeganBurgerIngredientes = new JLabel("Proteína vegetal, queso vegano, pan de hamburguesa integral.");
		lblVeganBurgerIngredientes.setForeground(new Color(255, 255, 255));
		lblVeganBurgerIngredientes.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblVeganBurgerIngredientes.setBounds(715, 395, 511, 33);
		add(lblVeganBurgerIngredientes);
		
		JTextPane txtpnDescVegan = new JTextPane();
		txtpnDescVegan.setForeground(new Color(255, 255, 255));
		txtpnDescVegan.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtpnDescVegan.setText("Nuestra Vegan Burger clásica es ideal para los amantes de la comida vegetal. Con dos capas de jugosa hamburguesa a base de proteína vegetal, cubiertas con una generosa porción de queso vegano derretido, todo dentro de un suave pan integral. Es una delicia simple pero llena de sabor que te conquistará desde el primer bocado.");
		txtpnDescVegan.setBounds(715, 151, 456, 241);
		txtpnDescVegan.setOpaque(false);
		txtpnDescVegan.setBackground(new Color(0, 0, 0, 0));
		add(txtpnDescVegan);
		
		GradientPanel gradientPanel = new GradientPanel(Color.ORANGE, Color.BLUE);
        gradientPanel.setBounds(0, 0, 1280, 720);
        add(gradientPanel);
	}

}
