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
@Table(name = "aut_integrante")
public class Integrante {
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "legajo")
    private int legajo;

    @Column(name = "rol") // ENUM
    private String rol;

    @OneToMany
    @JoinColumn(name = "aut_grupo_id")
    private Grupo aut_grupo_id;

    @ManyToOne
    @JoinColumn(name = "aut_integrante_id", referencedColumnName = "id")
    private Integrante integrante;

    
}
