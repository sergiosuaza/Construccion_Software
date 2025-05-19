package cajero;

import java.util.Scanner;

/** esta clase contiene metodos estaticos 
 * para la interaccion con el usuario en el menu
 */

public class Utilidades {

    // se leee la opcion seleccionada por el usuario 

    public static Accion leerOpcion(Scanner scanner) {
        if (!scanner.hasNextInt()) {
            scanner.nextLine();
            return Accion.INVALIDA;
        }
        int opcion = scanner.nextInt();
        scanner.nextLine();

        switch (opcion) {
            case 1: return Accion.CONSULTAR;
            case 2: return Accion.RETIRAR;
            case 3: return Accion.DEPOSITAR;
            case 4: return Accion.SALIR;
            default: return Accion.INVALIDA;
        }
    }


    //lee el valor ingresado por usuario 

    public static double leerMonto(Scanner scanner) {
        if (!scanner.hasNextDouble()) {
            scanner.nextLine();
            return -1;
        }
        double monto = scanner.nextDouble();
        scanner.nextLine();
        return monto;
    }

    //mostrar el menu de interaccion con el usuario 

    public static void mostrarMenu() {
        System.out.println("Bienvenido a su cajero Grosero");
        System.out.println("1. Consultar Chichigua");
        System.out.println("2. Retirar el billetico");
        System.out.println("3. Depositar billetico");
        System.out.println("4. Abrase del parche");
        System.out.println("Seleccione algo pues papito");
    }
}
