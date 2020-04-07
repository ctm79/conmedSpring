/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.conmed.service;

import com.daw.conmed.domain.Analitica;
import java.util.List;

/**
 *
 * @author tron
 */
public interface AnaliticaService {
    
    public List<Analitica> listarAnaliticas();
    
    public void guardar(Analitica analitica);
    
    public void eliminar(Analitica analitica);
    
    public Analitica encontrarAnalitica(Analitica analitica);
    
}
