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
@Table(name="analitica base")
public class Analitica_base implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column (name = "CODIGO GRUPO")
    private Integer CODIGO_GRUPO;
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column (name = "CODIGO SUBGRUPO")
    private Integer CODIGO_SUBGRUPO;
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column (name = "CODIGO PRUEBA")
    private Integer CODIGO_PRUEBA;

    private String GRUPO;
    private String SUBGRUPO;
    private String PRUEBA;
    private String UNIDADES;
    private String REFERENCIA;



}