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
 * @author tron
 */
@Data
@Entity
@Table(name="pacientes")
public class Paciente implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id_paciente;
    @NotEmpty
    private String nombre;
    private String apellidos; 
    private String ocupacion; 
    private String direccion; 
    private String cod_postal;
    private String poblacion; 
    private String provincia; 
    private String pais;
    private String tlf1;
    private String tlf2;
    private String email;
    private String web;
    private String estado_civil;
    private String fecha_nacimiento;
    private String lugar_nacimiento;
    private String n_hijos;
    private String fecha_alta;
    private String recomendado_por;
    private String motivo_consulta; 
    
}
