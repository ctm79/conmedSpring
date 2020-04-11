/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.conmed.dao;

import com.daw.conmed.domain.Agenda;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author tron
 */
public interface AgendaDao extends CrudRepository<Agenda, Integer>{
    
}
