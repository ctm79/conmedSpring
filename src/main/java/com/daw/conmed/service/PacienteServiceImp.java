/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.conmed.service;

import com.daw.conmed.dao.PacienteDao;
import com.daw.conmed.domain.Paciente;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

/**
 *       
 * @author tron
 */
@Service
public class PacienteServiceImp implements PacienteService {
    
    @Autowired
    private PacienteDao pacienteDao;

    @Override
    @Transactional(readOnly = true)
    public List<Paciente> listarPacientes() {
       return (List<Paciente>) pacienteDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Paciente paciente) {
        pacienteDao.save(paciente);
    }

    @Override
    @Transactional
    public void eliminar(Paciente paciente) {
        pacienteDao.delete(paciente);
    }

    @Override
    @Transactional(readOnly = true)
    public Paciente encontrarPaciente(Paciente paciente) {
        return pacienteDao.findById(paciente.getId_paciente()).orElse(null);
    }
    
    /*
    @Override
    @Transactional (readOnly = true)
    public List<Paciente> buscador (String cadena) {
        return pacienteDao.findByNombreContainsIgnoreCaseOrEmailContainsIgnoreCaseOrTelefonoContainsIgnoreCase(cadena, cadena, cadena);
    }
    */
    
    @Override
    @Transactional (readOnly = true)
    public List<Paciente> buscador (String cadena) {
        return pacienteDao.findByNombreContainsIgnoreCaseOrApellidosContainsIgnoreCase(cadena, cadena);
    }
    
    
    @Override
    @Transactional(readOnly = true)
    public Page<Paciente> listarPacientesPagina(Pageable pageable) {
       return (Page<Paciente>) pacienteDao.findAll(pageable);
    } 
    
    @Override
    @Transactional (readOnly = true)
    public Page<Paciente> buscadorPagina (Pageable pageable, String cadena) {
        return (Page<Paciente>) pacienteDao.findByNombreContainsIgnoreCase(cadena, pageable);
    }
    
}
