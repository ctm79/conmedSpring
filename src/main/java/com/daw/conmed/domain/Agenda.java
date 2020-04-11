/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.conmed.domain;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import javax.persistence.*;
import javax.validation.constraints.*;
import lombok.Data;

/**
 *
 * @author tron
 */
@Data
@Entity
@Table(name="agenda")
public class Agenda implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id_agenda;
    
    private Date fecha;
    private Time hora;
    private String contenido;
    
    @JoinColumn(name="id_cita", referencedColumnName = "id_cita")
    @ManyToOne (cascade = CascadeType.ALL)
    private Cita cita;
    

}
