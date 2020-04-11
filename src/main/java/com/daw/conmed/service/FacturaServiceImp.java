/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.conmed.service;

import com.daw.conmed.dao.FacturaDao;
import com.daw.conmed.domain.Factura;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

/**
 *       
 * @author tron
// */
@Service
public class FacturaServiceImp implements FacturaService {
    
    @Autowired
    private FacturaDao facturaDao;

    @Override
    @Transactional(readOnly = true)
    public List<Factura> listarFacturas() {
       return (List<Factura>) facturaDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Factura factura) {
        facturaDao.save(factura);
    }

    @Override
    @Transactional
    public void eliminar(Factura factura) {
        facturaDao.delete(factura);
    }

    @Override
    @Transactional(readOnly = true)
    public Factura encontrarFactura(Factura factura) {
        return facturaDao.findById(factura.getN_factura()).orElse(null);
    }
     
}
