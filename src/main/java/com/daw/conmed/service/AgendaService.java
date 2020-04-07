/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.conmed.service;

import com.daw.conmed.domain.Agenda;
import java.util.List;

/**
 *
 * @author tron
 */
public interface AgendaService {
    
    public List<Agenda> listarAgendas();
    
    public void guardar(Agenda agenda);
    
    public void eliminar(Agenda agenda);
    
    public Agenda encontrarAgenda(Agenda agenda);
    
}
