/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.conmed.service;

import com.daw.conmed.domain.Receta;
import java.util.List;

/**
 *
 * @author tron
 */
public interface RecetaService {
    
    public List<Receta> listarRecetas();
    
    public void guardar(Receta receta);
    
    public void eliminar(Receta receta);
    
    public Receta encontrarReceta(Receta receta);
    
}
