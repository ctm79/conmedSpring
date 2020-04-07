/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.conmed.service;

import com.daw.conmed.dao.AgendaDao;
import com.daw.conmed.domain.Agenda;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

/**
 *       
 * @author tron
 */
@Service
public class AgendaServiceImp implements AgendaService {
    
    @Autowired
    private AgendaDao agendaDao;

    @Override
    @Transactional(readOnly = true)
    public List<Agenda> listarAgendas() {
       return (List<Agenda>) agendaDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Agenda agenda) {
        agendaDao.save(agenda);
    }

    @Override
    @Transactional
    public void eliminar(Agenda agenda) {
        agendaDao.delete(agenda);
    }

    @Override
    @Transactional(readOnly = true)
    public Agenda encontrarAgenda(Agenda agenda) {
        return agendaDao.findById(agenda.getId_agenda()).orElse(null);
    }
    
}
