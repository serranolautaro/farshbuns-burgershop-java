package vista;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

import modelos.Pedido;
import modelos.Producto;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;

public class PedidoCliente extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textFieldNroTarjeta;
	private JTextField textFieldDNI;
	private JTextField textFieldNombreCompleto;
	private JTextField textFieldCodSeguridad;

	/**
	 * Create the panel.
	 */
	public PedidoCliente(Pedido pedido) {
		
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
		
		JLabel lblPedido = new JLabel("PEDIDOS");
		lblPedido.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblPedido.setBounds(590, 127, 104, 27);
		add(lblPedido);
		
		DefaultListModel<String> modeloLista = new DefaultListModel<>();
	    JList<String> listProductos = new JList<>(modeloLista);
	    JScrollPane scrollPane = new JScrollPane(listProductos);
	    scrollPane.setBounds(159, 191, 300, 400);
	        add(scrollPane);

	        // Rellenar JList con productos del pedido
	        for (Producto producto : pedido.getProductos()) {
	            modeloLista.addElement(producto.getNombre_producto());
	        }
        	        
        	        JLabel lblNumeroTarjeta = new JLabel("INGRESE EL NUMERO DE SU TARJETA:");
        	        lblNumeroTarjeta.setFont(new Font("Tahoma", Font.BOLD, 13));
        	        lblNumeroTarjeta.setBounds(501, 215, 253, 14);
        	        add(lblNumeroTarjeta);
        	        
        	        textFieldNroTarjeta = new JTextField();
        	        textFieldNroTarjeta.setBounds(501, 230, 223, 20);
        	        add(textFieldNroTarjeta);
        	        textFieldNroTarjeta.setColumns(10);
        	        
        	        JLabel lblNumeroDNI = new JLabel("INGRESE SU NUMERO DE DOCUMENTO:");
        	        lblNumeroDNI.setFont(new Font("Tahoma", Font.BOLD, 13));
        	        lblNumeroDNI.setBounds(501, 261, 253, 14);
        	        add(lblNumeroDNI);
        	        
        	        textFieldDNI = new JTextField();
        	        textFieldDNI.setColumns(10);
        	        textFieldDNI.setBounds(501, 276, 223, 20);
        	        add(textFieldDNI);
        	        
        	        JLabel lblIngreseSuCodigo = new JLabel("INGRESE SU NOMBRE COMPLETO:");
        	        lblIngreseSuCodigo.setFont(new Font("Tahoma", Font.BOLD, 13));
        	        lblIngreseSuCodigo.setBounds(501, 307, 253, 14);
        	        add(lblIngreseSuCodigo);
        	        
        	        textFieldNombreCompleto = new JTextField();
        	        textFieldNombreCompleto.setColumns(10);
        	        textFieldNombreCompleto.setBounds(501, 323, 223, 20);
        	        add(textFieldNombreCompleto);
        	        
        	        JLabel lblCodSeguridad = new JLabel("INGRESE SU CODIGO DE SEGURIDAD:\r\n");
        	        lblCodSeguridad.setFont(new Font("Tahoma", Font.BOLD, 13));
        	        lblCodSeguridad.setBounds(501, 354, 253, 14);
        	        add(lblCodSeguridad);
        	        
        	        textFieldCodSeguridad = new JTextField();
        	        textFieldCodSeguridad.setColumns(10);
        	        textFieldCodSeguridad.setBounds(501, 370, 223, 20);
        	        add(textFieldCodSeguridad);
        	        
        	        JLabel lblTotalPedido = new JLabel("TOTAL: ");
        	        lblTotalPedido.setFont(new Font("Tahoma", Font.BOLD, 13));
        	        lblTotalPedido.setBounds(501, 401, 63, 14);
        	        add(lblTotalPedido);
        	        
        	        JButton btnPagar = new JButton("PAGAR");
        	        btnPagar.setFont(new Font("Tahoma", Font.BOLD, 11));
        	        btnPagar.setBounds(541, 442, 162, 27);
        	        add(btnPagar);

        	        GradientPanel gradientPanel = new GradientPanel(Color.ORANGE, Color.BLUE);
        	        gradientPanel.setBounds(0, 0, 1280, 720);
        	        add(gradientPanel);  

	}
	
	

}
