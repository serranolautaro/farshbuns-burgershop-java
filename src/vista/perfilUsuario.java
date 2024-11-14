package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelos.Usuario;
import dao.UsuarioDAO;

public class perfilUsuario extends JPanel {

    private static final long serialVersionUID = 1L;

    public perfilUsuario(Usuario usuario) {
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
		
        JLabel lblTitulo = new JLabel("Perfil de Usuario");
        lblTitulo.setForeground(new Color(255, 255, 255));
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 21));
        lblTitulo.setBounds(425, 191, 194, 27);
        add(lblTitulo);
        
        JLabel lblNombreUsuario = new JLabel("Nombre de usuario: " + usuario.getNombre_usuario());
        lblNombreUsuario.setForeground(new Color(255, 255, 255));
        lblNombreUsuario.setBounds(425, 229, 300, 25);
        add(lblNombreUsuario);

        // Botón para eliminar cuenta
        JButton btnEliminarCuenta = new JButton("Eliminar Cuenta");
        btnEliminarCuenta.setBounds(425, 265, 150, 30);
        add(btnEliminarCuenta);

        // Acción del botón para eliminar cuenta
        btnEliminarCuenta.addActionListener(e -> {
            int confirmacion = JOptionPane.showConfirmDialog(
                this,
                "¿Estás seguro de que deseas eliminar la cuenta?",
                "Confirmar Eliminación",
                JOptionPane.YES_NO_OPTION
            );

            if (confirmacion == JOptionPane.YES_OPTION) {
                UsuarioDAO usuarioDAO = new UsuarioDAO();
                usuarioDAO.eliminarUsuario(usuario);  // Asume que UsuarioDAO tiene un método para eliminar
                JOptionPane.showMessageDialog(this, "Cuenta eliminada con éxito.");
                
                // Vuelve a la pantalla de inicio de sesión
                JFrame marco = (JFrame) SwingUtilities.getWindowAncestor(this);
                marco.setContentPane(new inicioSesion());
                marco.validate();
            }
        });
    }
}
