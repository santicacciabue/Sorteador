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
@Table(name = "aut_grupo")
public class Grupo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "orden_grupo")
    private int orden_grupo;

    @OneToMany
    @JoinColumn(name = "aut_categoria_id")
    private Categoria aut_categoria_id;

    @ManyToOne
    @JoinColumn(name = "aut_grupo_id", referencedColumnName = "id")
    private Grupo grupo;
}
