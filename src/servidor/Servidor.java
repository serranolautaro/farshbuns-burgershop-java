package servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Servidor {
	private static final int PUERTO = 12345; // Puerto para la conexión
    private List<ManejoCliente> clientesConectados = new ArrayList<>();

    public static void main(String[] args) {
        new Servidor().iniciar();
    }

    public void iniciar() {
        try (ServerSocket servidor = new ServerSocket(PUERTO)) {
            System.out.println("Servidor de hamburguesería iniciado. Esperando conexiones...");
            while (true) {
                Socket socketCliente = servidor.accept(); // Acepta conexión del cliente
                System.out.println("Cliente conectado desde " + socketCliente.getInetAddress());
                ManejoCliente manejador = new ManejoCliente(socketCliente, this);
                clientesConectados.add(manejador); // Agrega el cliente a la lista
                new Thread(manejador).start(); // Inicia el hilo que maneja al cliente
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void removerCliente(ManejoCliente cliente) {
        clientesConectados.remove(cliente);
        System.out.println("Cliente desconectado.");
    }
}
