package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.DayOfWeek;
import java.util.HashMap;
import java.time.LocalDate;

public class chatbot extends JPanel {

	private static final long serialVersionUID = 1L;

	 private HashMap<String, String> respuestas;
	 HashMap<DayOfWeek, String> menuDiario;
	 private JTextArea chatArea;
	 private JTextField inputField;
	 private JButton sendButton;
	    
	public chatbot() {
		 respuestas = new HashMap<>();
	        respuestas.put("Hola", "Bienvenido a Farshbuns ¿qué desea hoy?");
	        respuestas.put("hola", "Bienvenido a Farshbuns ¿qué desea hoy?");
	        respuestas.put("Hamburguesas", "La lista de hamburguesas disponibles es: \n·Baconator \n·Cheese \n·Vegan ");
	        respuestas.put("Acompañantes", "La lista de acompañantes disponibles es: \\n·Nuggets \\n·Bastones de Muzzarella");
	        
	        menuDiario = new HashMap<>();
		     menuDiario.put(DayOfWeek.MONDAY, "Menú del lunes: Baconator junto a unos bastones de muzzarella.");
		     menuDiario.put(DayOfWeek.TUESDAY, "Menú del martes: Hamburguesa doble con queso, papas y bebida.");
		     menuDiario.put(DayOfWeek.WEDNESDAY, "Menú del miércoles: Hamburguesa vegetariana con papas y bebida.");
		     menuDiario.put(DayOfWeek.THURSDAY, "Menú del jueves: Hamburguesa de pollo con papas y bebida.");
		     menuDiario.put(DayOfWeek.FRIDAY, "Menú del viernes: Hamburguesa BBQ con papas y bebida.");
		     menuDiario.put(DayOfWeek.SATURDAY, "Menú del sábado: BACONATOR junto a NUGGETS.");
		     menuDiario.put(DayOfWeek.SUNDAY, "Menú del domingo: Combo familiar con hamburguesas y papas grandes.");
	        
	        // Configurar el área de chat
	        chatArea = new JTextArea(10, 30);
	        chatArea.setEditable(false);
	        chatArea.setLineWrap(true);
	        chatArea.setWrapStyleWord(true);
	        
	        // Configurar el campo de entrada
	        inputField = new JTextField(20);
	        sendButton = new JButton("Enviar");
	        
	        inputField.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                enviarPregunta();
	            }
	        });
	}
	
	private void enviarPregunta() {
        String pregunta = inputField.getText().trim();
        
        if (!pregunta.isEmpty()) {
            chatArea.append("--> " + pregunta + "\n");
            String respuesta = buscarRespuesta(pregunta);
            chatArea.append("*** " + respuesta + "\n\n");
            inputField.setText("");
        }
    }

    public String buscarRespuesta(String pregunta) {
    	if (pregunta.equalsIgnoreCase("Menu del dia")) {
            return getMenuDelDia();
        }
        return respuestas.getOrDefault(pregunta, "No sé, pregúntale al CoOwner, Francisco Masa.");
    }
    
    private String getMenuDelDia() {
        DayOfWeek diaActual = LocalDate.now().getDayOfWeek();
        return menuDiario.getOrDefault(diaActual, "Menú no disponible para hoy.");
    }

}
