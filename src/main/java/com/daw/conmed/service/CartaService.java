/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.conmed.service;

import com.daw.conmed.domain.Carta;
import java.util.List;

/**
 *
 * @author tron
 */
public interface CartaService {
    
    public List<Carta> listarCartas();
    
    public void guardar(Carta carta);
    
    public void eliminar(Carta carta);
    
    public Carta encontrarCarta(Carta carta);
    
}