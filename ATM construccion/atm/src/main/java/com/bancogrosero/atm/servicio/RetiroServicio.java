package com.bancogrosero.atm.servicio;

import org.springframework.stereotype.Service;

import com.bancogrosero.atm.entity.Cliente;
import com.bancogrosero.atm.entity.Cuenta;
import com.bancogrosero.atm.repository.ClienteRepository;
import com.bancogrosero.atm.repository.CuentaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class RetiroServicio {

    private final CuentaRepository cuentaRepository;
    private final ClienteRepository clienteRepository;
    private final MovimientoServicio movimientoService;

    public String realizarRetiro( String identificacion, String numeroCuenta, double monto){
        Cliente cliente = clienteRepository.findByIdentificacion(identificacion)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        Cuenta cuenta = cuentaRepository.findByNumero(numeroCuenta)
                .orElseThrow(() -> new RuntimeException("Cuenta no encontrada"));

        if (!cuenta.getCliente().equals(cliente)) {
            throw new RuntimeException("La cuenta no pertenece al cliente");
        }

        if(cliente.isBloqueado()){
            throw new RuntimeException("El cliente o su cuenta está bloqueada");
        }

        boolean exito = movimientoService.realizarRetiro(cuenta, monto);

        if (!exito) {
            throw new RuntimeException("Saldo insuficiente");
        }

        return "redirect:cajero/menu?mensaje=Retiro realizado con éxito";
    }

}
