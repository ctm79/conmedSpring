/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.conmed.service;

import com.daw.conmed.dao.FichaDao;
import com.daw.conmed.domain.Ficha;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

/**
 *       
 * @author tron
// */
@Service
public class FichaServiceImp implements FichaService {
    
    @Autowired
    private FichaDao fichaDao;

    @Override
    @Transactional(readOnly = true)
    public List<Ficha> listarFichas() {
       return (List<Ficha>) fichaDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Ficha ficha) {
        fichaDao.save(ficha);
    }

    @Override
    @Transactional
    public void eliminar(Ficha ficha) {
        fichaDao.delete(ficha);
    }

    @Override
    @Transactional(readOnly = true)
    public Ficha encontrarFicha(Ficha ficha) {
        return fichaDao.findById(ficha.getN_hoja()).orElse(null);
    }
     
}
