/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.conmed.service;

import com.daw.conmed.domain.Paciente;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author tron
 */
public interface PacienteService {
    
    public List<Paciente> listarPacientes();
    
    public void guardar(Paciente paciente);
    
    public void eliminar(Paciente paciente);
    
    public Paciente encontrarPaciente(Paciente paciente);
    
    public List<Paciente> buscador(String cadena);
    
    public Page<Paciente> listarPacientesPagina(Pageable pageable);
    
    public Page<Paciente> buscadorPagina(Pageable pageable, String cadena);
}
