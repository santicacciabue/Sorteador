package com.sorteador.sorteador.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "aut_solicitud_reemplazo")
public class Solicitud_reemplazo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "fecha_solicitud")
    private LocalDate fecha_solicitud;

    @Column(name = "sol_estado")  //Enum
    private String sol_estado;

    @OneToMany
    @JoinColumn(name = "aut_integrante_id")
    private Integrante aut_integrante_solicitante_id;

    @OneToMany
    @JoinColumn(name = "aut_integrante_id")
    private Integrante aut_integrante_reemplazo_id;

    @OneToMany
    @JoinColumn(name = "aut_asignacion_id")
    private Asignacion aut_asignacion_solicitante_id;

    @OneToMany
    @JoinColumn(name = "aut_asignacion_id")
    private Asignacion aut_asignacion_reemplazo_id;

}
