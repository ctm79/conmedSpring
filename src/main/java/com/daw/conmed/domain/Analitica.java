/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.conmed.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.*;
import javax.validation.constraints.*;
import lombok.Data;

/**
 *
 * @author tron
 */
@Data
@Entity
@Table(name="analiticas")
public class Analitica implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id_analitica;
    
    private Integer n_orden;
    private Timestamp fecha;
    private String descripcion;
    
    @JoinColumn(name="id_paciente", referencedColumnName = "id_paciente")
    @ManyToOne (cascade = CascadeType.ALL)
    private Paciente paciente;
    
}
