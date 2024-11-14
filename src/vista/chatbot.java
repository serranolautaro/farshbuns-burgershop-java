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
	        respuestas.put("Hola", "Hola, soy FarshBot 🤖. ¿qué desea el dia de hoy?");
	        respuestas.put("Buenos dias", "Bienvenido a Farshbuns ¿qué desea hoy?");
	        
	        respuestas.put("Ofertas", "Lastimosamente no contamos con ofertas");
	        respuestas.put("Cupon", "Lastimosamente no contamos con cupones");
	        respuestas.put("promociones", "No contamos con promociones");
	        
	        respuestas.put("Donde están ubicados", "En estos momentos no contamos con local fisico.");
	        respuestas.put("ubicacion", "En estos momentos no contamos con local fisico.");
	        respuestas.put("Que metodos de pago aceptan", "Solo aceptamos tarjetas de debito o credito");
	        respuestas.put("métodos de pago", "Solo aceptamos tarjetas de debito o credito.");
	        
	        respuestas.put("Hamburguesas", "La lista de hamburguesas disponibles es: \n·Baconator \n·Cheese \n·Vegan ");
	        respuestas.put("Acompañantes", "La lista de acompañantes disponibles es: \n·Nuggets \n·Bastones de Muzzarella");
	        respuestas.put("papas", "La lista de acompañantes disponibles es: \\n·Nuggets \\n·Bastones de Muzzarella");
	        
	        respuestas.put("sugerencias", "Si me dices una palabra clave tal vez pueda ayudarte a decidir");
	        respuestas.put("recomendaciones", "Si me dices una palabra clave tal vez pueda ayudarte a decidir");
	        respuestas.put("recomendame", "Si me dices una palabra clave tal vez pueda ayudarte a decidir");
	        
	        respuestas.put("sano", "Si quieres una opcion saludable te recomiendo la Vegan");
	        respuestas.put("saludable", "Si quieres una opcion saludable te recomiendo la Vegan");
	        respuestas.put("carne", " Te recomiendo la Baconator");
	        respuestas.put("intermedio", "Te recomiendo la Cheese");
	        
	        respuestas.put("tiempo de entrega", "El tiempo de entrega estimado es de 30 a 40 minutos.");
	        respuestas.put("demora", "Nuestro tiempo de entrega estimado es de 30 a 40 minutos.");
	        
	        menuDiario = new HashMap<>();
		     menuDiario.put(DayOfWeek.MONDAY, "🌟 Lunes: Comienza la semana con nuestro BACONATOR\n acompañado de BASTONES de Muzzarella.");
		     menuDiario.put(DayOfWeek.TUESDAY, "🌟 Martes: Disfruta de una deliciosa CHEESE \ncon BASTONES de Muzzarella.");
		     menuDiario.put(DayOfWeek.WEDNESDAY, "🌟 Miercoles: Opta por una VEGAN \ncon BASTONES de Muzzarella.");
		     menuDiario.put(DayOfWeek.THURSDAY, "🌟 Jueves: Elige una CHEESE con NUGGETS.");
		     menuDiario.put(DayOfWeek.FRIDAY, "🌟 Viernes: ¡Nada mejor que un BACONATOR con NUGGETS!");
		     menuDiario.put(DayOfWeek.SATURDAY, "🌟 Sábado: Dale un toque diferente al fin de semana\n con nuestra VEGAN acompañada de NUGGETS.");
		     menuDiario.put(DayOfWeek.SUNDAY, "🌟 Domingo: Disfruta el día con un BACONATOR \ny BASTONES de Muzzarella.");
	        
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
        // Buscar si la pregunta coincide con una clave, sin importar mayúsculas y minúsculas
        for (String clave : respuestas.keySet()) {
            if (pregunta.equalsIgnoreCase(clave)) {
                return respuestas.get(clave);
            }
        }
        
        // Si la pregunta es "Menu del dia", devolver el menú correspondiente
        if (pregunta.equalsIgnoreCase("Menu del dia")) {
            return getMenuDelDia();
        }
        
        // Si no se encuentra la respuesta, devolver un mensaje por defecto
        return "Lo siento, no tengo la respuesta en este momento.";
    }
    
    private String getMenuDelDia() {
        DayOfWeek diaActual = LocalDate.now().getDayOfWeek();
        return menuDiario.getOrDefault(diaActual, "Menú no disponible para hoy.");
    }

}
