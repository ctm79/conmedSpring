/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.conmed.service;

import com.daw.conmed.dao.CartaDao;
import com.daw.conmed.domain.Carta;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

/**
 *       
 * @author tron
// */
@Service
public class CartaServiceImp implements CartaService {
    
    @Autowired
    private CartaDao cartaDao;

    @Override
    @Transactional(readOnly = true)
    public List<Carta> listarCartas() {
       return (List<Carta>) cartaDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Carta carta) {
        cartaDao.save(carta);
    }

    @Override
    @Transactional
    public void eliminar(Carta carta) {
        cartaDao.delete(carta);
    }

    @Override
    @Transactional(readOnly = true)
    public Carta encontrarCarta(Carta carta) {
        return cartaDao.findById(carta.getCODIGO()).orElse(null);
    }
     
}
