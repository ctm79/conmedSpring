/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.conmed.service;

import com.daw.conmed.domain.Factura;
import java.util.List;

/**
 *
 * @author tron
 */
public interface FacturaService {
    
    public List<Factura> listarFacturas();
    
    public void guardar(Factura factura);
    
    public void eliminar(Factura factura);
    
    public Factura encontrarFactura(Factura factura);
    
}