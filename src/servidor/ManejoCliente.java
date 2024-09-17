package servidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ManejoCliente implements Runnable {
	
	 private Socket socketCliente;
	 private Servidor servidor;
	 private PrintWriter salida;
	 private BufferedReader entrada;

	    public ManejoCliente(Socket socketCliente, Servidor servidor) {
	        this.socketCliente = socketCliente;
	        this.servidor = servidor;
	        try {
	            salida = new PrintWriter(socketCliente.getOutputStream(), true);
	            entrada = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    @Override
	    public void run() {
	        try {
	            String mensaje;
	            while ((mensaje = entrada.readLine()) != null) {
	                System.out.println("Mensaje recibido: " + mensaje);
	                procesarMensaje(mensaje);
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                socketCliente.close();
	                servidor.removerCliente(this);
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	    }

	    private void procesarMensaje(String mensaje) {
	        // Aquí procesarías los pedidos, por ejemplo, si el cliente envía un pedido.
	        // Simplemente devolvemos una respuesta.
	        salida.println("Servidor recibió: " + mensaje);
	    }

}
