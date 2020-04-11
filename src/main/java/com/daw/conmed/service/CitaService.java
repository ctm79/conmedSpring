/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.conmed.service;

import com.daw.conmed.domain.Cita;
import java.util.List;

/**
 *
 * @author tron
 */
public interface CitaService {
    
    public List<Cita> listarCitas();
    
    public void guardar(Cita cita);
    
    public void eliminar(Cita cita);
    
    public Cita encontrarCita(Cita cita);
    
}
