/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.conmed.service;

import com.daw.conmed.domain.Imagen;
import java.util.List;

/**
 *
 * @author tron
 */
public interface ImagenService {
    
    public List<Imagen> listarImagens();
    
    public void guardar(Imagen imagen);
    
    public void eliminar(Imagen imagen);
    
    public Imagen encontrarImagen(Imagen imagen);
    
}