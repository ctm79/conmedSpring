/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.conmed.service;

import com.daw.conmed.dao.RecetaDao;
import com.daw.conmed.domain.Receta;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

/**
 *       
 * @author tron
 */
@Service
public class RecetaServiceImp implements RecetaService {
    
    @Autowired
    private RecetaDao recetaDao;

    @Override
    @Transactional(readOnly = true)
    public List<Receta> listarRecetas() {
       return (List<Receta>) recetaDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Receta receta) {
        recetaDao.save(receta);
    }

    @Override
    @Transactional
    public void eliminar(Receta receta) {
        recetaDao.delete(receta);
    }

    @Override
    @Transactional(readOnly = true)
    public Receta encontrarReceta(Receta receta) {
        return recetaDao.findById(receta.getCodigo()).orElse(null);
    }
    
}
