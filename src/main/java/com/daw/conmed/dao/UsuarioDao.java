/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.conmed.dao;

import com.daw.conmed.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author tron
 */
public interface UsuarioDao extends JpaRepository<Usuario,Integer> {
    Usuario findByUsername(String Username);
}
