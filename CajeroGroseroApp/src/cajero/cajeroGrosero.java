package cajero;

import java.util.Scanner;

/**
 * Clase principal que representa al Cajero 
 * Esta clase se encarga de mostrar el menú, recibir las opciones del usuario
 * y realizar las operaciones bancarias correspondientes como consultar, retirar
 * y depositar dinero.
 */

public class cajeroGrosero {
    private Cliente cliente;
    private Scanner scanner;


    // metodo contructor del cajero

    public cajeroGrosero(Cliente cliente) {
        this.cliente = cliente;
        this.scanner = new Scanner(System.in);
    }

    /**
     * Método principal que arranca la interacción con el usuario.
     * Muestra el menú y ejecuta las acciones según la opción elegida.
     */

    public void iniciar() {
        Accion accion;

        // Ciclo principal del cajero: sigue mostrando el menú hasta que el usuario decida salir

        do {
            Utilidades.mostrarMenu();
            accion = Utilidades.leerOpcion(scanner);

            // estos condicionales ejecutan la accion que corresponda 

            switch (accion) {
                case CONSULTAR:
                    System.out.println("Que chichigua, apenas tenes: $" + cliente.getSaldo());
                    break;
                case RETIRAR:
                    retirar();
                    break;
                case DEPOSITAR:
                    depositar();
                    break;
                case SALIR:
                    System.out.println("Como dijo Andrea, suerte Gono****. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Despierte pues dormido!! Eso no es una opcion");
            }

        } while (accion != Accion.SALIR);
    }

    /**
     * Método privado que se encarga de retirar dinero del saldo del cliente.
     * Verifica que el monto sea válido y que haya suficiente dinero.
     */

    private void retirar() {
        System.out.println("Cuanta Chichigua vas a sacar?: ");
        double monto = Utilidades.leerMonto(scanner);

        if (monto <= 0) {
            System.out.println("El monto ingresado no es válido.");
        } else if (!cliente.retirar(monto)) {
            System.out.println("No mrk, no le da. Su saldo actual es: $" + cliente.getSaldo());
        } else {
            System.out.println("Despierte pues mrk. Su saldo es apenas $" + cliente.getSaldo());
        }
    }

    /**
     * Método privado que se encarga de depositar dinero en la cuenta del cliente.
     * Verifica que el monto sea mayor a 0.
     */

    private void depositar() {
        System.out.println("Cuanta platica vas a consignar?: ");
        double monto = Utilidades.leerMonto(scanner);

        if (monto <= 0) {
            System.out.println("Tan Guevon ese valor no se puede parcero.");
        } else {
            cliente.depositar(monto);
            System.out.println("Consignacion exitosa mijito!! su nuevo saldo es: $" + cliente.getSaldo());
        }
    }
}

