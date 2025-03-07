package com.example;
import java.util.Scanner;

public class CajeroGrosero {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double saldo = 100000; // Saldo inicial
        int opcion = 0; // Se inicializa para evitar el error

        do {
            mostrarMenu();
            
            if (!scanner.hasNextInt()) {
                System.out.println("Despierte pues dormido!! Eso no es una opcion");
                scanner.next(); // Limpia consola
                continue;
            }

            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir nueva línea para evitar problemas con next()

            switch (opcion) {
                case 1:
                    consultarSaldo(saldo);
                    break;
                case 2:
                    saldo = retirarDinero(scanner, saldo);
                    break;
                case 3:
                    saldo = depositarDinero(scanner, saldo);
                    break;
                case 4:
                    System.out.println("Como dijo Andrea, suerte Gono****. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Despierte pues dormido!! Eso no es una opcion");
            }
        } while (opcion != 4);

        scanner.close();
    }

    public static void mostrarMenu() {
        System.out.println("Bienvenido a su cajero Grosero");
        System.out.println("1. Consultar Chichigua");
        System.out.println("2. Retirar el billetico");
        System.out.println("3. Depositar billetico");
        System.out.println("4. Abrase del parche");
        System.out.println("Seleccione algo pues papito");
    }

    public static void consultarSaldo(double saldo) {
        System.out.println("Que chichigua, apenas tenes: $" + saldo);
    }

    public static double retirarDinero(Scanner scanner, double saldo) {
        System.out.println("Cuanta Chichigua vas a sacar?: ");
        
        if (!scanner.hasNextDouble()) {
            System.out.println("El monto ingresado no es válido.");
            scanner.next(); // Limpia consola
            return saldo;
        }

        double retiro = scanner.nextDouble();
        scanner.nextLine(); // Consumir nueva línea

        if (retiro <= 0) {
            System.out.println("El monto ingresado no es válido.");
        } else if (retiro > saldo) {
            System.out.println("No mrk, no le da. Su saldo actual es: $" + saldo);
        } else {
            saldo -= retiro;
            System.out.println("Despierte pues mrk. Su saldo es apenas $" + saldo);
        }
        return saldo;
    }

    public static double depositarDinero(Scanner scanner, double saldo) {
        System.out.println("Cuanta platica vas a consignar?: ");
        
        if (!scanner.hasNextDouble()) {
            System.out.println("Tan Guevon ese valor no se puede parcero.");
            scanner.next();
            return saldo;
        }

        double deposito = scanner.nextDouble();
        scanner.nextLine(); // Consumir nueva línea

        if (deposito <= 0) {
            System.out.println("Tan Guevon ese valor no se puede parcero.");
        } else {
            saldo += deposito;
            System.out.println("Consignacion exitosa mijito!! su nuevo saldo es: $" + saldo);
        }
        return saldo;
    }
}
