/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.conmed.service;

import com.daw.conmed.domain.Historial;
import java.util.List;

/**
 *
 * @author tron
 */
public interface HistorialService {
    
    public List<Historial> listarHistorials();
    
    public void guardar(Historial historial);
    
    public void eliminar(Historial historial);
    
    public Historial encontrarHistorial(Historial historial);
    
}