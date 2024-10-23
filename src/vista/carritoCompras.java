package vista;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class carritoCompras extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public carritoCompras() {
		setBackground(new Color(0, 128, 192));
		setForeground(new Color(255, 255, 255));
		setLayout(null);
		setBounds(0, 0, 1280, 720);
		
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
		
		DefaultListModel<String> modeloLista = new DefaultListModel<>();
	        JScrollPane scrollPane = new JScrollPane();
	        scrollPane.setBounds(460, 129, 300, 400);
	        add(scrollPane);
	        
	        	        JList<String> listProductos = new JList<>(modeloLista);
	        	        scrollPane.setViewportView(listProductos);

	        // Etiqueta para mostrar total del carrito
	        JLabel lblTotal = new JLabel("Total: ");
	        lblTotal.setForeground(Color.WHITE);
	        lblTotal.setBounds(460, 573, 200, 30);
	        add(lblTotal);

	        //
	        JButton btnPagar = new JButton("Pagar");
	        btnPagar.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	JFrame marco = (JFrame) SwingUtilities.getWindowAncestor((Component) e.getSource());
	                marco.setContentPane(new PedidoCliente());
	                marco.validate();
	            }
	        });
	        btnPagar.setBounds(460, 613, 100, 30);
	        add(btnPagar);
	        
	        GradientPanel gradientPanel = new GradientPanel(Color.ORANGE, Color.BLUE);
	        gradientPanel.setBounds(0, 0, 1280, 720);
	        add(gradientPanel);  
	}
}
