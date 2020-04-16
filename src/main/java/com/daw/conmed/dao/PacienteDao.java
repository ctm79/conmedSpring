/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.conmed.dao;

import com.daw.conmed.domain.Paciente;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author tron
 */
//public interface PacienteDao extends CrudRepository<Paciente, Integer>{
public interface PacienteDao extends JpaRepository<Paciente, Integer>{
    
    //List<Paciente> findByNombreContainsIgnoreCaseOrEmailContainsIgnoreCaseOrApellidosContainsIgnoreCase(String nombre, String email, String apellidos);
    List<Paciente> findByNombreContainsIgnoreCaseOrApellidosContainsIgnoreCase(String nombre , String apellidos);
    Page<Paciente> findByNombreContainsIgnoreCase(String nombre , Pageable pageable);
	
    
}
