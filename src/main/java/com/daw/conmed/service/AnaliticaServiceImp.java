/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.conmed.service;

import com.daw.conmed.dao.AnaliticaDao;
import com.daw.conmed.domain.Analitica;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

/**
 *       
 * @author tron
 */
@Service
public class AnaliticaServiceImp implements AnaliticaService {
    
    @Autowired
    private AnaliticaDao analiticaDao;

    @Override
    @Transactional(readOnly = true)
    public List<Analitica> listarAnaliticas() {
       return (List<Analitica>) analiticaDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Analitica analitica) {
        analiticaDao.save(analitica);
    }

    @Override
    @Transactional
    public void eliminar(Analitica analitica) {
        analiticaDao.delete(analitica);
    }

    @Override
    @Transactional(readOnly = true)
    public Analitica encontrarAnalitica(Analitica analitica) {
        return analiticaDao.findById(analitica.getId_analitica()).orElse(null);
    }
    
}
