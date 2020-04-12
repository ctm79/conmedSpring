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
public class ControllerInit {
    
    @Autowired
    private PacienteService pacienteService;
    
       
    @GetMapping("/")
    public String inicio(Model model){
        log.info("ejecutando el controlador Spring MVC");
        return "index";
    }
    
    @GetMapping("/pacientes")
    public String pacientes(Model model, @RequestParam(name="q", required=false) String query){
        List<Paciente> pacientes = (query==null) ? pacienteService.listarPacientes() : pacienteService.buscador(query);
        //List<Paciente> pacientes = pacienteService.listarPacientes();
        log.info("ejecutando el controlador Spring MVC");
        model.addAttribute("pacientes", pacientes);
        return "pacientes";
    }
    
    @GetMapping("/agregarPaciente")
    public String agregar(Paciente paciente){
        return "modificarPaciente";
    }
    
    @PostMapping("/guardarPaciente")
    public String guardar(@Valid Paciente paciente, Errors errors){
        if (errors.hasErrors()) {
            return "modificarPaciente";
        }
        pacienteService.guardar(paciente);
        return "redirect:/";
    }
    
    @GetMapping("/editarPaciente/{id_paciente}")
    public String editar(Paciente paciente, Model model){
        paciente = pacienteService.encontrarPaciente(paciente);
        model.addAttribute("paciente", paciente);
        return "modificarPaciente";
    }
    
    @GetMapping("/eliminarPaciente")
    public String eliminar(Paciente paciente){
        pacienteService.eliminar(paciente);
        return "redirect:/";
    }
}
