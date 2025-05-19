package cajero;

/** En esta clase tenemos el saldo y la cantidad de dinero que mueve el 
 * cliente, permite consultar, depositar o retirar dinero
*/
public class Cliente {
    private double saldo; // saldo del cliente 


    // este es el metodo contrsuctor para el saldo del cliente 

    public Cliente(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    // con este metodo se consulta el saldo del cliente

    public double getSaldo() {
        return saldo;
    }

    // en este metodo es para depositar dinero en la cuenta del cliente     

    public void depositar(double cantidad) {
        saldo += cantidad;
    }


    // metodo para retirar dinero de la cuenta

    public boolean retirar(double cantidad) {
        if (cantidad <= 0 || cantidad > saldo) {
            return false;
        }
        saldo -= cantidad;
        return true;
    }
}
