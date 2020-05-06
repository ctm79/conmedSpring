/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.conmed.web;

import com.daw.conmed.domain.*;
import com.daw.conmed.service.*;
import com.daw.conmed.util.paginator.PageRender;
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
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
@Slf4j
public class ControllerInit {

    @Autowired
    private PacienteService pacienteService;

    public ControllerInit(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @GetMapping("/")
    public String inicio(Model model) {
        log.info("ejecutando el controlador Spring MVC");
        return "index";
    }

    @GetMapping("/listaPacientes")
////    public String pacientes(Model model, @RequestParam(name = "q", required = false) String query, @RequestParam(name = "page", defaultValue = "0") int page, Pageable pageable) {
    public String pacientes(Model model, @RequestParam(name = "page", defaultValue = "0") int page, Pageable pageable) {
        Pageable pageRequest = PageRequest.of(page, 10);
//
////        if (query == null) {
        Page<Paciente> pacientes = pacienteService.listarPacientesPagina(pageRequest);
        PageRender<Paciente> pageRender = new PageRender<Paciente>("/listaPacientes", pacientes);
        model.addAttribute("pacientes", pacientes);
        model.addAttribute("page", pageRender);
//
////        } else {
////
////            Page<Paciente> pacientes = pacienteService.buscadorPagina(pageRequest, query);
////            PageRender<Paciente> pageRender = new PageRender<Paciente>("/listaPacientes", pacientes);
////            model.addAttribute("pacientes", pacientes);
////            model.addAttribute("page", pageRender);
////        }
        log.info("ejecutando el controlador Spring MVC");
        return "pacientes/listaPacientes";
    }

    @GetMapping(value = "/cargar-pacientes/{term}", produces = {"application/json"})
    public @ResponseBody
    List<Paciente> cargarPacientes(@PathVariable String term) {
        return pacienteService.findByApellidos(term);
    }

//    @GetMapping("/listaPacientes")
//    public String pacientes(Model model, @RequestParam(name="q", required=false) String query, Pageable pageable){
//        
//        if (query==null){
//            Page<Paciente> pacientes = pacienteService.listarPacientesPagina(pageable);
//            model.addAttribute("pacientes", pacientes);
//        } else {
//            List<Paciente> pacientes = pacienteService.buscador(query);
//            model.addAttribute("pacientes", pacientes);
//                    
//        }
    //Page<Paciente> pacientes = (query==null) ? pacienteService.listarPacientesPagina(pageable) :  (Page)pacienteService.buscador(query);
    //Page<Paciente> pacientes = (query==null) ? pacienteService.listarPacientesPagina(pageable) : pacienteService.buscador(query);
    //List<Paciente> pacientes = pacienteService.listarPacientes();
    //model.addAttribute("pacientes", pacientes);
//        log.info("ejecutando el controlador Spring MVC");
//        return "pacientes/listaPacientes";
//    }
    /*
    @GetMapping("/listaPacientes")
    public String pacientes(Model model, @RequestParam(name="q", required=false) String query){
        List<Paciente> pacientes = (query==null) ? pacienteService.listarPacientes() : pacienteService.buscador(query);
        //List<Paciente> pacientes = pacienteService.listarPacientes();
        log.info("ejecutando el controlador Spring MVC");
        model.addAttribute("pacientes", pacientes);
        return "pacientes/listaPacientes";
    }
     */
    @GetMapping("/agregarPaciente")
    public String agregar(Paciente paciente) {
        return "pacientes/modificarPaciente";
    }

    @PostMapping("/guardarPaciente")
    public String guardar(@Valid Paciente paciente, Errors errors) {
        if (errors.hasErrors()) {
            return "pacientes/modificarPaciente";
        }
        pacienteService.guardar(paciente);
        return "redirect:/";
    }

    @GetMapping("/editarPaciente/{id_paciente}")
    public String editar(Paciente paciente, Model model) {
        paciente = pacienteService.encontrarPaciente(paciente);
        model.addAttribute("paciente", paciente);
        return "pacientes/modificarPaciente";
    }

    @GetMapping("/eliminarPaciente")
    public String eliminar(Paciente paciente) {
        pacienteService.eliminar(paciente);
        return "redirect:/";
    }

    @GetMapping("/verPaciente/{id_paciente}")
    public String verPaciente(Paciente paciente, Model model) {
        paciente = pacienteService.encontrarPaciente(paciente);
        log.info("ejecutando el controlador verPaciente");
        model.addAttribute("paciente", paciente);
        return "pacientes/verPaciente";
    }
}
