/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.conmed.domain;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.*;
import lombok.Data;

/**
 *
 * @author CPR
 */
@Data
@Entity
@Table(name="cartas")
public class Carta implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer CODIGO;
    
    private String CONTENIDO;
    
    @JoinColumn(name="ID_PACIENTE", referencedColumnName = "id_paciente")
    @ManyToOne (cascade = CascadeType.ALL)
    private Paciente paciente;

}