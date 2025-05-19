package com.bancogrosero.atm.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.bancogrosero.atm.entity.Cuenta;
import com.bancogrosero.atm.entity.Movimiento;

public interface MovimientoRepository extends JpaRepository<Movimiento, Long>{

    List<Movimiento> findByCuenta(Cuenta cuenta);
    List<Movimiento> findByCuenta_NumeroOrderByFechaDesc(String numerocuenta);
    

}
