package com.sorteador.sorteador.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "aut_rel_producto")
public class Rel_producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column (name = "nombre")
    private String nombre;

    @Column (name = "orden")
    private int orden;

    @OneToMany
    @JoinColumn(name = "aut_categoria_id")
    private Categoria aut_categoria_id;

    @ManyToOne
    @JoinColumn(name = "aut_rel_producto_id", referencedColumnName = "id")
    private Rel_producto rel_producto;
    
}
