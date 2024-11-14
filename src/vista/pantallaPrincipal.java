package vista;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import modelos.Producto;
import modelos.Pedido;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;

import java.awt.Font;

public class pantallaPrincipal extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textFieldBarraBusqueda;
	private chatbot chatBot;
	private JTextArea chatDisplay;
	private JTextField chatInput;
	private static final int MAX_LINES = 10;

	/**
	 * Create the panel.
	 */
	public pantallaPrincipal() {
		setBackground(new Color(0, 128, 192));
		setForeground(new Color(255, 255, 255));
		setLayout(null);
		setBounds(0, 0, 1280, 720);

		//Como poner una imagen
		JLabel logo = new JLabel(new ImageIcon(""));
		logo.setBounds(85,171,50,50);
		add(logo);
		
		JButton btnIniciarSesion = new JButton("");
		btnIniciarSesion.setBackground(new Color(255, 255, 255));
		
		//Transparenta la imagen de unboton
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
		
		textFieldBarraBusqueda = new JTextField();
		textFieldBarraBusqueda.setBackground(new Color(255, 255, 255));
		textFieldBarraBusqueda.setForeground(new Color(0, 0, 0));
		textFieldBarraBusqueda.setBounds(410, 23, 437, 41);
		add(textFieldBarraBusqueda);
		textFieldBarraBusqueda.setColumns(10);
		
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
		
		JButton btnAsistente = new JButton("");
		btnAsistente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAsistente.setIcon(new ImageIcon("img\\pantallaPrincipal\\asistenteVirtual.png"));
		btnAsistente.setBounds(1190, 410, 50, 50);
		btnAsistente.setOpaque(false);
		btnAsistente.setBorderPainted(false);
		btnAsistente.setContentAreaFilled(false);
		add(btnAsistente);
		
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
		
		JButton btnBaconator = new JButton("");
		btnBaconator.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame marco = (JFrame) SwingUtilities.getWindowAncestor((Component) e.getSource());
				marco.setContentPane(new baconator(pedido));
				marco.validate();
			}
		});
		btnBaconator.setIcon(new ImageIcon("img\\hamburguesas\\baconator.jpg"));
		btnBaconator.setBounds(336, 127, 200, 200);
		add(btnBaconator);
		
		JButton btnCheeseBurger = new JButton("");
		btnCheeseBurger.setIcon(new ImageIcon("img\\hamburguesas\\bbb.png"));
		btnCheeseBurger.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame marco = (JFrame) SwingUtilities.getWindowAncestor((Component) e.getSource());
				marco.setContentPane(new cheeseBurger(pedido));
				marco.validate();
			}
		});
		btnCheeseBurger.setBounds(546, 127, 200, 200);
		add(btnCheeseBurger);
		
		JButton btnVeganBurger = new JButton("");
		btnVeganBurger.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame marco = (JFrame) SwingUtilities.getWindowAncestor((Component) e.getSource());
				marco.setContentPane(new veganBurger(pedido));
				marco.validate();
			}
		});
		btnVeganBurger.setIcon(new ImageIcon("img\\hamburguesas\\veganburgerGrande.jpg"));
		btnVeganBurger.setBounds(756, 127, 200, 200);
		add(btnVeganBurger);
		
		JButton btnNuggets = new JButton("");
		btnNuggets.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame marco = (JFrame) SwingUtilities.getWindowAncestor((Component) e.getSource());
				marco.setContentPane(new nuggets(pedido));
				marco.validate();
			}
		});
		btnNuggets.setIcon(new ImageIcon("img\\hamburguesas\\NNuggets.jpg"));
		btnNuggets.setBounds(435, 376, 200, 200);
		add(btnNuggets);
		
		JButton btnBastones = new JButton("");
		btnBastones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame marco = (JFrame) SwingUtilities.getWindowAncestor((Component) e.getSource());
				marco.setContentPane(new bastonesMuzzarella());
				marco.validate();
			}
		});
		btnBastones.setIcon(new ImageIcon("img/hamburguesas/bastonesMuzza.jpg"));
		btnBastones.setBounds(678, 376, 200, 200);
		add(btnBastones);
		
		JLabel lblCheeseBurger = new JLabel("CHEESE BURGER");
		lblCheeseBurger.setForeground(new Color(255, 255, 255));
		lblCheeseBurger.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCheeseBurger.setBounds(546, 334, 200, 14);
		add(lblCheeseBurger);
		
		JLabel lblBaconator = new JLabel("BACONATOR");
		lblBaconator.setForeground(new Color(255, 255, 255));
		lblBaconator.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblBaconator.setBounds(336, 334, 200, 14);
		add(lblBaconator);
		
		JLabel lblVeganBurger = new JLabel("VEGAN BURGER");
		lblVeganBurger.setForeground(new Color(255, 255, 255));
		lblVeganBurger.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblVeganBurger.setBounds(756, 334, 200, 14);
		add(lblVeganBurger);
		
		JLabel lblNuggets = new JLabel("NUGGETS");
		lblNuggets.setForeground(new Color(255, 255, 255));
		lblNuggets.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNuggets.setBounds(435, 579, 200, 14);
		add(lblNuggets);
		
		JLabel lblBastonesDeMuzzarella = new JLabel("BASTONES DE MUZZARELLA");
		lblBastonesDeMuzzarella.setForeground(new Color(255, 255, 255));
		lblBastonesDeMuzzarella.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblBastonesDeMuzzarella.setBounds(678, 579, 200, 14);
		add(lblBastonesDeMuzzarella);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String textoBusqueda = textFieldBarraBusqueda.getText().trim().toLowerCase();
				 if (textoBusqueda.isEmpty() || "baconator".contains(textoBusqueda)) {
			        	JFrame marco = (JFrame) SwingUtilities.getWindowAncestor((Component) e.getSource());
						marco.setContentPane(new baconator());
						marco.validate();
			        } else if (textoBusqueda.isEmpty() || "cheese".contains(textoBusqueda)) {
			        	JFrame marco = (JFrame) SwingUtilities.getWindowAncestor((Component) e.getSource());
						marco.setContentPane(new cheeseBurger(pedido));
						marco.validate();
					} else if (textoBusqueda.isEmpty() || "vegan".contains(textoBusqueda)) {
						JFrame marco = (JFrame) SwingUtilities.getWindowAncestor((Component) e.getSource());
						marco.setContentPane(new veganBurger(pedido));
						marco.validate();
					} else if (textoBusqueda.isEmpty() || "bastones".contains(textoBusqueda)) {
						JFrame marco = (JFrame) SwingUtilities.getWindowAncestor((Component) e.getSource());
						marco.setContentPane(new bastonesMuzzarella());
						marco.validate();
					}else if(textoBusqueda.isEmpty() || "nuggets".contains(textoBusqueda)){
						JFrame marco = (JFrame) SwingUtilities.getWindowAncestor((Component) e.getSource());
						marco.setContentPane(new nuggets(pedido));
						marco.validate();
			        }
			}
		});
		btnBuscar.setBounds(857, 23, 99, 41);
		add(btnBuscar);
		
		chatBot = new chatbot();

		// Área de despliegue del chat
		chatDisplay = new JTextArea();
		chatDisplay.setEditable(false);
		chatDisplay.setBounds(888, 463, 371, 146);
		add(chatDisplay);

		
		chatInput = new JTextField();
		chatInput.setBounds(888, 612, 290, 30);
		add(chatInput);

		// Botón para enviar el mensaje
		JButton sendButton = new JButton("Enviar");
		sendButton.setBounds(1180, 612, 79, 30);
		sendButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				enviarMensajeChatBot();
			}
		});
		add(sendButton);
	
		// Listener para enviar mensaje con Enter
		chatInput.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					enviarMensajeChatBot();
				}
			}
		});

		GradientPanel gradientPanel = new GradientPanel(Color.ORANGE, Color.BLUE);
        gradientPanel.setBounds(0, 0, 1280, 720);
        add(gradientPanel);
	}
	
	public pantallaPrincipal(Pedido pedido) {
		this();
		this.pedido = pedido;
	}
	
	Pedido pedido = new Pedido();
	
	private void enviarMensajeChatBot() {
	    String userMessage = chatInput.getText();
	    if (!userMessage.isEmpty()) {
	        chatDisplay.append("Tú: " + userMessage + "\n");
	        String botResponse = chatBot.buscarRespuesta(userMessage);
	        chatDisplay.append("FarshBot: " + botResponse + "\n\n");
	        chatInput.setText("");
	        
	        // Verifica si el número de líneas en chatDisplay supera MAX_LINES
	        if (chatDisplay.getLineCount() > MAX_LINES) {
	            chatDisplay.setText(""); // Reinicia el área de texto
	            chatDisplay.append("Chat refrescado por politicas de espacio.\n\n");
	        }
	    }
	}
}