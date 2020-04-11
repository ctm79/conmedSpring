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
@Table(name="historial")
public class Historial implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer n_hoja;
    
    private Date ultima_act;
    private String motivos;
    @Column (name = "tratamiento Adoptado")
    private String tratamiento_Adoptado;
    private String resultados;
    private String informacion_pasada;
    @Column (name = "molestias anteriores")
    private String molestias_anteriores;
    private String empezaron;
    private String modo_comienzo;
    private String desencadenantes;
    private String motempeoran_conivos;
    private String mejoran_con;
    private String muscular;
    private String oseo;
    private String cardiovascular;
    private String habito_renal;
    private String urologico;
    private String ginecologico;
    private String gastrointestinal;
    private String respiratorio;
    private String sentidos;
    private String equilibrio;
    private String neurologico;
    private String dermatitis;
    private String boca;
    private String enfermedades;
    private String intervenciones;
    private String accidentes;
    private String alergias;
    private String madre;
    private String padre;
    private String conyuge;
    private String abuelos;
    private String hermanos;
    private String hijos;
    private String tios_carnales;
    private String posicion;
    private String ligero_profundo;
    private String hiper_hiposomia;
    private String dia;
    private String dificultaddormirse;
    @Column (name = "despertar _frecuente")
    private String despertar_frecuente;
    private String despertar_temprano;
    private String dificultad_levantarse;
    private String periocidad;
    @Column (name = "normal-aum-dism")
    private String normal_aum_dism;
    private String Pesadillas;
    private String Contenidos;
    @Column (name = "Normal-aum-dis")
    private String Normal_aum_dis;
    private String dispaneuremia;
    private String impotencia;
    private String frigidez;
    private String masturbacion;
    private String reaccion_frente_pareja;
    private String promiscuidad;
    private String frecuencia;
    private String violencia_sexual;
    private String experiencias;
    private String temor_embarazo;
    private String metodo_anticonceptivo;
    private String deseo_hijos;
    @Column (name = "sexualidad _placer")
    private String sexualidad_placer;
    private String memoria;
    private String concentracion;
    private String rencor;
    private String anticipacon;
    private String critico;
    private String meticuloso;
    private String contradictorio;
    private String dictatorial;
    private String descontento;
    private String sustos;
    private String sobresaltos;
    private String prisa;
    private String indiferencia;
    private String irritable;
    private String celoso;
    private String locuaz;
    private String orientacion;
    private String opacidad;
    private String recuerdos_pasados;
    private String mejor_con_ocup;
    private String ofensa_facil;
    private String peor_momento_dia;
    private String otras;
    
    @JoinColumn(name="n_hoja", referencedColumnName = "id_paciente")
    @OneToOne (cascade = CascadeType.ALL)
    private Paciente paciente;

}