/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.conmed.service;

import com.daw.conmed.dao.CitaDao;
import com.daw.conmed.domain.Cita;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

/**
 *       
 * @author tron
 */
@Service
public class CitaServiceImp implements CitaService {
    
    @Autowired
    private CitaDao citaDao;

    @Override
    @Transactional(readOnly = true)
    public List<Cita> listarCitas() {
       return (List<Cita>) citaDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Cita cita) {
        citaDao.save(cita);
    }

    @Override
    @Transactional
    public void eliminar(Cita cita) {
        citaDao.delete(cita);
    }

    @Override
    @Transactional(readOnly = true)
    public Cita encontrarCita(Cita cita) {
        return citaDao.findById(cita.getId_cita()).orElse(null);
    }
    
}
