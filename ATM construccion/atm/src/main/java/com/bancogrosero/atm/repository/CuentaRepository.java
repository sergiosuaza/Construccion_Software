package com.bancogrosero.atm.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bancogrosero.atm.entity.Cliente;
import com.bancogrosero.atm.entity.Cuenta;


public interface CuentaRepository extends JpaRepository<Cuenta, Long>{
    Optional<Cuenta> findByNumero(String Numero);
    List<Cuenta> findByCliente(Cliente cliente);
    

}
