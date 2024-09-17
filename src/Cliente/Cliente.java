package Cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    private static final String SERVIDOR = "localhost"; // Dirección del servidor (puede ser una IP externa)
    private static final int PUERTO = 12345; // Puerto del servidor

    public static void main(String[] args) {
        try (Socket socket = new Socket(SERVIDOR, PUERTO);
             PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             Scanner scanner = new Scanner(System.in)) {

            System.out.println("Conectado al servidor de hamburguesería");

            String mensaje;
            while (true) {
                System.out.print("Ingrese el pedido o mensaje para el servidor: ");
                mensaje = scanner.nextLine();
                salida.println(mensaje);

                // Recibe la respuesta del servidor
                String respuesta = entrada.readLine();
                System.out.println("Respuesta del servidor: " + respuesta);

                // Si el cliente escribe "salir", termina la conexión
                if (mensaje.equalsIgnoreCase("salir")) {
                    break;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
