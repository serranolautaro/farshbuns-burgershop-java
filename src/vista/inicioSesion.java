package vista;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import modelos.Usuario;
import dao.UsuarioDAO;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class inicioSesion extends JPanel {

    private static final long serialVersionUID = 1L;
    private JTextField textFieldUsuario;
    private JTextField textFieldContraseña;
    private JLabel lblMensajeError;  // Declaración del JLabel

    /**
     * Create the panel.
     */
    public inicioSesion() {
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
        
        JLabel lblUsuario = new JLabel("USUARIO");
        lblUsuario.setForeground(new Color(255, 255, 255));
        lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblUsuario.setBounds(433, 217, 172, 28);
        add(lblUsuario);
        
        textFieldUsuario = new JTextField();
        textFieldUsuario.setBounds(433, 256, 172, 28);
        add(textFieldUsuario);
        textFieldUsuario.setColumns(10);
        
        JLabel lblContraseña = new JLabel("CONTRASEÑA");
        lblContraseña.setForeground(new Color(255, 255, 255));
        lblContraseña.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblContraseña.setBounds(677, 217, 172, 28);
        add(lblContraseña);
        
        textFieldContraseña = new JTextField();
        textFieldContraseña.setBounds(677, 256, 172, 28);
        add(textFieldContraseña);
        textFieldContraseña.setColumns(10);
        
        // Inicializa el JLabel para el mensaje de error
        lblMensajeError = new JLabel("");
        lblMensajeError.setForeground(Color.RED); // Para que el texto sea rojo
        lblMensajeError.setFont(new Font("Tahoma", Font.BOLD, 14)); // Opcional: mayor visibilidad
        lblMensajeError.setBounds(190, 217, 300, 28);  // Posiciona el mensaje
        add(lblMensajeError);  // Añade el JLabel al panel desde el inicio
        
        JButton btnIngresar = new JButton("INGRESAR");
        btnIngresar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	String nombreUsuario = textFieldUsuario.getText();
                String contrasenaUsuario = textFieldContraseña.getText();
                
                UsuarioDAO usuarioDAO = new UsuarioDAO();
                ArrayList<Usuario> usuarios = usuarioDAO.traerTodasLosUsuarios();

                Usuario usuarioValido = null;

                // Verifica si el nombre de usuario y la contraseña coinciden
                for (Usuario usuario : usuarios) {
                    if (usuario.getNombre_usuario().equals(nombreUsuario) &&
                        usuario.getContraseñaUsuario().equals(contrasenaUsuario)) {
                        usuarioValido = usuario;
                        break;
                    }
                }

                // Si el usuario es válido, redirige a perfilUsuario
                if (usuarioValido != null) {
                    JFrame marco = (JFrame) SwingUtilities.getWindowAncestor((Component) e.getSource());
                    marco.setContentPane(new perfilUsuario(usuarioValido));
                    marco.validate();
                } else {
                    // Muestra el mensaje de error
                    lblMensajeError.setText("USUARIO O CONTRASEÑA INCORRECTOS");
                }
            }
        });
        btnIngresar.setBounds(433, 295, 172, 28);
        add(btnIngresar);
        
        JButton btnRegresar = new JButton("REGRESAR");
        btnRegresar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame marco = (JFrame) SwingUtilities.getWindowAncestor((Component) e.getSource());
                marco.setContentPane(new pantallaPrincipal());
                marco.validate();
            }
        });
        btnRegresar.setBounds(784, 334, 172, 28);
        add(btnRegresar);
        
        JButton btnRegistrar = new JButton("REGISTRARTE");
        btnRegistrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame marco = (JFrame) SwingUtilities.getWindowAncestor((Component) e.getSource());
                marco.setContentPane(new registrarUsuario());
                marco.validate();
            }
        });
        btnRegistrar.setBounds(433, 334, 172, 28);
        add(btnRegistrar);

        GradientPanel gradientPanel = new GradientPanel(Color.ORANGE, Color.BLUE);
        gradientPanel.setBounds(0, 0, 1280, 720);
        add(gradientPanel);  

    }
}

