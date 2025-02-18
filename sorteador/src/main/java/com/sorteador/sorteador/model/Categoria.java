package com.sorteador.sorteador.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "aut_categoria")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "nombre")
    private String nombre;

    @Column(name = "ultima_asignacion_semana")
    private int ultima_asignacion_semana;

    @Column(name = "ultima_asignacion_fecha")
    private LocalDate ultima_asignacion_fecha;

    @Column(name = "semanas_a_planificar")
    private int semanas_a_planificar;
    
    @ManyToOne
    @JoinColumn(name = "aut_categoria_id", referencedColumnName = "id")
    private Categoria categoria;
}
