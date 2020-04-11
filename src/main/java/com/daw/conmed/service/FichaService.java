/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.conmed.service;

import com.daw.conmed.domain.Ficha;
import java.util.List;

/**
 *
 * @author tron
 */
public interface FichaService {
    
    public List<Ficha> listarFichas();
    
    public void guardar(Ficha ficha);
    
    public void eliminar(Ficha ficha);
    
    public Ficha encontrarFicha(Ficha ficha);
    
}