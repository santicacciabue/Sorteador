package com.sorteador.sorteador.model;

import java.time.LocalDate;

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
@Table(name = "aut_sorteo")
public class Sorteo {
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "fecha")
    private LocalDate fecha;

    @Column(name = "confirmado")
    private boolean confirmado;

    @Column(name = "dia_descriptivo")
    private String dia_descriptivo;

    @OneToMany
    @JoinColumn(name = "aut_rel_producto_id")
    private Rel_producto aut_rel_producto_id;

    @ManyToOne
    @JoinColumn(name = "aut_sorteo_id",referencedColumnName = "id")
    private Sorteo sorteo;
}
