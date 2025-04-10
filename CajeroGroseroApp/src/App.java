import java.util.Scanner;


// se importan las clases que estan el el paquete de cajero
import cajero.*;

public class App {

    public static void main(String[] args) {


        // Creamos un objeto Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);

        //Primero validamos el PIN antes de iniciar
        if (!pinAutenticador.autenticar(scanner)) {
            scanner.close();
            return; // No pasa la autenticación, se termina el programa
        }

         // Si el PIN fue correcto, creamos un cliente con saldo inicial de $100,000
        Cliente cliente = new Cliente(100000);

        // Creamos el objeto cajeroGrosero, que manejará las operaciones del cajero
        cajeroGrosero cajero = new cajeroGrosero(cliente);

        // Iniciamos el menú y funcionalidades del cajero
        cajero.iniciar();

        scanner.close();
    }
}

