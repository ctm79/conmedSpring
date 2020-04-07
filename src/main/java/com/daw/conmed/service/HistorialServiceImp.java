/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.conmed.service;

import com.daw.conmed.dao.HistorialDao;
import com.daw.conmed.domain.Historial;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

/**
 *       
 * @author tron
// */
@Service
public class HistorialServiceImp implements HistorialService {
    
    @Autowired
    private HistorialDao historialDao;

    @Override
    @Transactional(readOnly = true)
    public List<Historial> listarHistorials() {
       return (List<Historial>) historialDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Historial historial) {
        historialDao.save(historial);
    }

    @Override
    @Transactional
    public void eliminar(Historial historial) {
        historialDao.delete(historial);
    }

    @Override
    @Transactional(readOnly = true)
    public Historial encontrarHistorial(Historial historial) {
        return historialDao.findById(historial.getN_hoja()).orElse(null);
    }
     
}
