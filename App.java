package com.example;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //variable y constantes
        final int PIN_CORRECTO = 1234;
        double saldo = 50000;
        int intentos = 0;
        boolean cuentaBloqueada = false;


        //Autenticacion segun intentos
        while (intentos < 3) {
            System.out.println("ingrese su PIN: ");
            int pinIngresado = scanner.nextInt();


            if (pinIngresado == PIN_CORRECTO) {
                System.out.println("Bienvenido Pichurria");    
                break;   
            }
            else {
                intentos ++;
                System.out.println("PIN incorrecto. Pilas pues marica!! Intento: " + intentos);
            }

            if (intentos == 3) {
                //cuentaBloqueada = true;
                System.out.println("Don chimbo... cuenta Bloqueada: ");
                scanner.close();
                return;
            }
        }

        //Si la cuenta esta bloqueada fnalizara el programa

        if (cuentaBloqueada) {
            scanner.close();
            return;
        }

        //Menu de cajero

        int opcion;
        do{
            System.out.println("Bienvenido a su cajero Grosero");
            System.out.println("1. Consultar Chichigua");
            System.out.println("2. Retirar el billetico");
            System.out.println("3. Depositar billetico");
            System.out.println("4. Abrase del parche");
            System.out.println("Seleccione algo pues papito");
            opcion = scanner.nextInt();

            //Manejo de opciones

            switch (opcion) {
                case 1:
                    System.out.println("que chichigiua, apenas tenes: $" + saldo);
                    break;
                case 2:
                    System.out.println("Cuanta Chichiuga vas a sacar?: ");
                    double retiro = scanner.nextDouble();

                    if (retiro <= 0) {
                        System.out.println("El monto ingresado no es válido.");
                    } else if (retiro > saldo) {
                        System.out.println("No mrk, no le da. Su saldo actual es: $" + saldo);
                    } else {
                        saldo -= retiro;
                        System.out.println("Despierte pues mrk. Su saldo es apenas" + saldo);
                    }
                    break;
                
                case 3:
                    System.out.println("Cuanta platica vas a consignar? :");
                    double deposito = scanner.nextDouble();

                    if (deposito <= 0) {
                        System.out.println("Tan Guevon ese valor no se puede parcero. ");
                    } 
                    
                    else {
                        saldo += deposito;
                        System.out.println("Consignacion exitosa mijito!! su nuevo saldo es: " + saldo);
                    }
                break;

                case 4:
                System.out.println("Como dijo andrea, suerte Gono****. ¡Hasta luego!");
                scanner.close();  // Cerrar scanner antes de salir
                return;
                
                default:
                    System.out.println("Despierte pues dormido!! Eso no es una opcion");                  
            }

        } while (opcion!=4);
        scanner.close();
        
    }    
}
