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
 * @author CPR
 */
@Data
@Entity
@Table(name="citas")
public class Cita implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id_cita;
    
    private Date fecha;
    private Time hora;
    private String texto;
    
    @JoinColumn(name="id_paciente", referencedColumnName = "id_paciente")
    @ManyToOne (cascade = CascadeType.ALL)
    private Paciente paciente;

}