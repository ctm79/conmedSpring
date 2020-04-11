/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.conmed.domain;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.sql.Timestamp;
import lombok.Data;

/**
 *
 * @author CPR
 */
@Data
@Entity
@Table(name="ficha")
public class Ficha implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer n_hoja;
    
    private Timestamp fecha;
    private Float peso;
    private Float cintura;
    private Float muslo;
    private Float altura;
    private String tension;
    private String apetito;
    private String deposiciones;
    private String diur;
    private String esclerosis;
    private String peelin;
    private String anotaciones;
    
    @JoinColumn(name="id_paciente", referencedColumnName = "id_paciente")
    @ManyToOne (cascade = CascadeType.ALL)
    private Paciente paciente;

}