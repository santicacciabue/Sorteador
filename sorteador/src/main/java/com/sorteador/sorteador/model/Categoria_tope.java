package com.sorteador.sorteador.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table (name = "aut_categoria_tope")
public class Categoria_tope {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "cantidad_min")
    private int cantidad_min;

    @Column(name = "cantidad_max")
    private int cantidad_max;

    @Column(name = "es_autoridad")
    private boolean es_autoridad;

    @OneToMany
    @JoinColumn(name = "aut_categoria_id")
    private Categoria aut_categoria_id;

    
    
}
