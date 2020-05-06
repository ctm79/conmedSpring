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
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author tron
 */
//public interface PacienteDao extends CrudRepository<Paciente, Integer>{
//public interface PacienteDao extends JpaRepository<Paciente, Integer>{
public interface PacienteDao extends PagingAndSortingRepository<Paciente, Integer> {
    
    	@Query("select p from Paciente p where p.apellidos like %?1%")
	public List<Paciente> findByApellidos(String term);

	public List<Paciente> findByApellidosLikeIgnoreCase(String term);

    //List<Paciente> findByNombreContainsIgnoreCaseOrEmailContainsIgnoreCaseOrApellidosContainsIgnoreCase(String nombre, String email, String apellidos);
//    List<Paciente> findByNombreContainsIgnoreCaseOrApellidosContainsIgnoreCase(String nombre, String apellidos);
//    Page<Paciente> findByNombreContainsIgnoreCase(String nombre, Pageable pageable);

}
