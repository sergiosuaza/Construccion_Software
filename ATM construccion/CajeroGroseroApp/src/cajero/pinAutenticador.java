package cajero;

import java.util.Scanner;

/**
 * Clase que se encarga de autenticar al usuario mediante un PIN.
 * Si el usuario se equivoca 3 veces, se le bloquea el acceso.
 */

public class pinAutenticador {
    private static final int PIN_CORRECTO = 1234;
    private static final int INTENTOS_MAXIMOS = 3;

    public static boolean autenticar(Scanner scanner) {
        int intentos = 0;

        while (intentos < INTENTOS_MAXIMOS) {
            System.out.print("Ingrese su PIN: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Eso no es un número, burro.");
                scanner.next(); // limpiar entrada
                intentos++;
                continue;
            }

            int pinIngresado = scanner.nextInt();
            scanner.nextLine();

            // Verifica si el PIN ingresado es el correcto

            if (pinIngresado == PIN_CORRECTO) {
                System.out.println("Acceso concedido, bien pueda pues mi papacho.");
                return true;
            } else {
                intentos++;
                int restantes = INTENTOS_MAXIMOS - intentos;
                System.out.println("PIN incorrecto. Pilas pues bobo, Le quedan " + restantes + " intentos.");
            }
        }

         // Si se pasa del numero de intentos, se bloqueara la cuenta

        System.out.println("¡Se pasó de guevón! Se bloqueó la cuenta.");
        return false;
    }
}
