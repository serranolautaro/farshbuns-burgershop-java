package vista;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelos.Usuarios;
import dao.UsuarioDAO;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class registrarUsuario extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textFieldUsuario;
	private JTextField textFieldContrasenia;
	private JTextField textFieldTelefono;
	private JTextField textFieldUbicacion;

	/**
	 * Create the panel.
	 */
	public registrarUsuario() {
		setBackground(new Color(0, 128, 192));
		setForeground(new Color(255, 255, 255));
		setLayout(null);
		setBounds(0, 0, 1280, 720);
		
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
		
		
		JLabel lblUsuario = new JLabel("USUARIO");
        lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblUsuario.setBounds(338, 259, 200, 14);
		add(lblUsuario);
		
		JLabel lblContraseña = new JLabel("CONTRASEÑA");
		lblContraseña.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblContraseña.setBounds(712, 259, 127, 14);
		add(lblContraseña);
		
		textFieldUsuario = new JTextField();
		textFieldUsuario.setBounds(338, 274, 187, 20);
		add(textFieldUsuario);
		textFieldUsuario.setColumns(10);
		
		textFieldContrasenia = new JTextField();
		textFieldContrasenia.setBounds(712, 274, 187, 20);
		add(textFieldContrasenia);
		textFieldContrasenia.setColumns(10);
		
		JLabel lblNuevoRegistro = new JLabel("CREA TU CUENTA");
		lblNuevoRegistro.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblNuevoRegistro.setBounds(516, 189, 194, 27);
		add(lblNuevoRegistro);
		
		JLabel lblMensajeError = new JLabel("");
		lblMensajeError.setBounds(516, 467, 194, 20);
		
		JButton btnCreaTuCuenta = new JButton("CREA TU CUENTA");
		btnCreaTuCuenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombreUsuario = textFieldUsuario.getText();
		        String contraseniaUsuario = textFieldContrasenia.getText();
		        int telefono = 0;
		        try {
		            telefono = Integer.parseInt(textFieldTelefono.getText());
		        } catch (NumberFormatException ex) {
		            lblMensajeError.setText("TELÉFONO INVÁLIDO");
		            add(lblMensajeError);
		            return;
		        }
		        String ubicacion = textFieldUbicacion.getText();

		        // Crear un objeto Usuario con los datos ingresados
		        Usuarios nuevoUsuario = new Usuarios(0, nombreUsuario, contraseniaUsuario, ubicacion, telefono); // Puedes ajustar los valores por defecto

		        // Instanciar el DAO y agregar el nuevo usuario a la base de datos
		        UsuarioDAO usuarioDAO = new UsuarioDAO();
		        boolean registroExitoso = usuarioDAO.insertarUsuario(nuevoUsuario);

		        // Verificar si el registro fue exitoso
		        if (registroExitoso) {
		            // Redirigir a la pantalla principal si el registro fue exitoso
		            JFrame marco = (JFrame) SwingUtilities.getWindowAncestor((Component) e.getSource());
		            marco.setContentPane(new pantallaPrincipal());
		            marco.validate();
		        } else {
		            // Mostrar mensaje de error si el registro falló
		        	lblMensajeError.setText("ERROR AL REGISTRAR USUARIO");
		        	add(lblMensajeError);
		        }
			}
		});
		btnCreaTuCuenta.setBounds(516, 374, 194, 20);
		add(btnCreaTuCuenta);
		
		textFieldTelefono = new JTextField();
		textFieldTelefono.setBounds(338, 327, 187, 20);
		add(textFieldTelefono);
		textFieldTelefono.setColumns(10);
		
		JLabel lblTelefono = new JLabel("TELEFONO");
		lblTelefono.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTelefono.setBounds(338, 313, 200, 14);
		add(lblTelefono);
		
		JLabel lblUbicacion = new JLabel("UBICACION");
		lblUbicacion.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblUbicacion.setBounds(712, 313, 200, 14);
		add(lblUbicacion);
		
		textFieldUbicacion = new JTextField();
		textFieldUbicacion.setColumns(10);
		textFieldUbicacion.setBounds(712, 327, 187, 20);
		add(textFieldUbicacion);
		
		JButton btnRegresar = new JButton("REGRESAR");
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame marco = (JFrame) SwingUtilities.getWindowAncestor((Component) e.getSource());
                marco.setContentPane(new pantallaPrincipal());
                marco.validate();
			}
		});
		btnRegresar.setBounds(516, 453, 194, 20);
		add(btnRegresar);

		GradientPanel gradientPanel = new GradientPanel(Color.ORANGE, Color.BLUE);
        gradientPanel.setBounds(0, 0, 1280, 720);
        add(gradientPanel);

	}
}
