/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.conmed.web;

import com.daw.conmed.domain.*;
import com.daw.conmed.service.*;
import java.util.List;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
public class ControllerFactura {
    
    @Autowired
    private FacturaService facturaService;
    
    @GetMapping("/listaFacturas")
    public String facturas(Model model){
        List<Factura> facturas = facturaService.listarFacturas();
        log.info("ejecutando el controlador Spring MVC");
        model.addAttribute("facturas", facturas);
        return "facturas/listaFacturas";
    }
    
    @GetMapping("/agregarFactura")
    public String agregar(Factura factura){
        return "facturas/modificarFactura";
    }
    
    @PostMapping("/guardarFactura")
    public String guardar(@Valid Factura factura, Errors errors){
        if (errors.hasErrors()) {
            return "facturas/modificarFactura";
        }
        facturaService.guardar(factura);
        return "redirect:/";
    }
    
    @GetMapping("/editarFactura/{n_factura}")
    public String editar(Factura factura, Model model){
        factura = facturaService.encontrarFactura(factura);
        model.addAttribute("factura", factura);
        return "facturas/modificarFactura";
    }
    
    @GetMapping("/eliminarFactura")
    public String eliminar(Factura factura){
        facturaService.eliminar(factura);
        return "redirect:/";
    }
}
