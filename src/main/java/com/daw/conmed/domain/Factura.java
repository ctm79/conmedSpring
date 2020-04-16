/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.conmed.domain;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.*;
import javax.validation.constraints.*;
import lombok.Data;

/**
 *
 * @author CPR
 */
@Data
@Entity
@Table(name="facturas")
public class Factura implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer n_factura;
    
    private String localidad;
    private Float importe;
    private Date fecha;
    private Date vencimiento;
    private String concepto;
    private String doctor;
    private String n_colegiado;
    private String direccion;
    private String poblacion;
    private String dni1;
    private String cod_fiscal;
    private Integer n_hoja;
    private String dni;
    private String nombre;
    private String direccion2;
    private String cp2;
    private String poblacion2;
    
    @JoinColumn(name="id_paciente", referencedColumnName = "id_paciente")     
    @ManyToOne (cascade = CascadeType.ALL)
    private Paciente paciente;

}