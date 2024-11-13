package vista;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import modelos.Pedido;
import modelos.Producto;
import service.PedidosService;

import javax.swing.JList;
import javax.swing.JScrollPane;

public class carritoCompras extends JPanel {

	private static final long serialVersionUID = 1L;
	private DefaultListModel<String> modeloLista;
	private Pedido pedido;

	public carritoCompras(Pedido pedido) {
		this.pedido = pedido;
		initialize();
		updateCarritoList();
	}
	
	private void initialize() {
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
		
		modeloLista = new DefaultListModel<>();
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(460, 129, 300, 400);
        add(scrollPane);
        
        JList<String> listProductos = new JList<>(modeloLista);
        scrollPane.setViewportView(listProductos);
        
		JLabel lblTotal = new JLabel("Total: ");
		lblTotal.setForeground(Color.WHITE);
		lblTotal.setBounds(460, 550, 300, 40);
		add(lblTotal);
		
		JButton btnPagar = new JButton("Pagar");
        btnPagar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	JFrame marco = (JFrame) SwingUtilities.getWindowAncestor((Component) e.getSource());
            	//PedidoCliente pedidoClientePanel = new PedidoCliente(pedido);
                pedidos.enviarPedidoAlServidor(pedido);
            	marco.setContentPane(new PedidoCliente(pedido));
                marco.validate();
            }
        });
        btnPagar.setBounds(460, 613, 100, 30);
        add(btnPagar);
        
        GradientPanel gradientPanel = new GradientPanel(Color.ORANGE, Color.BLUE);
        gradientPanel.setBounds(0, 0, 1280, 720);
        add(gradientPanel);  
	}
	
	PedidosService pedidos = new PedidosService();
	Producto producto;
	
	private void updateCarritoList() {
		modeloLista.clear();
		for (Producto producto : pedido.getProductos()) {
			modeloLista.addElement(producto.getNombre_producto());
		}
	}
}
