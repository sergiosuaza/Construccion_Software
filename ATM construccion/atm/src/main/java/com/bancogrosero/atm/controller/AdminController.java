package com.bancogrosero.atm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping ;

import com.bancogrosero.atm.entity.Cliente;
import com.bancogrosero.atm.servicio.ClienteServicio;
import com.bancogrosero.atm.servicio.CuentaServicio;

import lombok.RequiredArgsConstructor;



@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {

    private final ClienteServicio clienteServicio;
    private final CuentaServicio cuentaServicio;

    @GetMapping
    public String adminHome(){
        return "admin/index";
    }

    @GetMapping("/crear-cliente")
    public String mostrarFormularioCliente(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "admin/crear-cliente";
    }

    @PostMapping("/crear-cliente")
    public String crearCliente(@ModelAttribute Cliente cliente) {
        clienteServicio.crearCliente(cliente);      
        return "redirect:/admin";
    }
    
    
    

}