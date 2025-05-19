package com.bancogrosero.atm.entity;


import java.util.List;

import jakarta.persistence.CascadeType; 
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String identificacion;
    private String pin;
    private boolean bloqueado;
    private int intentosFallidos;
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Cuenta> cuenta;

    //metodos que se necesitan para intentos    
    public int getIntentos(){
        return this.intentosFallidos;
    }

    public void setIntentos(int intentos){
        this.intentosFallidos = intentos;
    }
 
    public void incrementarIntentos(){
        this.intentosFallidos++;
    }

    public void reiniciarIntentos(){
        this.intentosFallidos = 0;
    }


}
