/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.conmed.service;

import com.daw.conmed.dao.ImagenDao;
import com.daw.conmed.domain.Imagen;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

/**
 *       
 * @author tron
// */
@Service
public class ImagenServiceImp implements ImagenService {
    
    @Autowired
    private ImagenDao imagenDao;

    @Override
    @Transactional(readOnly = true)
    public List<Imagen> listarImagens() {
       return (List<Imagen>) imagenDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Imagen imagen) {
        imagenDao.save(imagen);
    }

    @Override
    @Transactional
    public void eliminar(Imagen imagen) {
        imagenDao.delete(imagen);
    }

    @Override
    @Transactional(readOnly = true)
    public Imagen encontrarImagen(Imagen imagen) {
        return imagenDao.findById(imagen.getN_hoja()).orElse(null);
    }  
}