package com.sorteador.sorteador.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table (name = "aut_categoria_tope")
public class Categoria_tope {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    public int getId() {
        return id;
    }

    @Column(name = "cantidad_min")
    private int cantidad_min;

    public int getCantidad_min() {
        return this.cantidad_min;
    }

    public void setCantidad_min(int cantidad_min) {
        this.cantidad_min = cantidad_min;
    }

    @Column(name = "cantidad_max")
    private int cantidad_max;

    public int getCantidad_max() {
        return this.cantidad_max;
    }

    public void setCantidad_max(int cantidad_max) {
        this.cantidad_max = cantidad_max;
    }

    @Column(name = "es_autoridad")
    private boolean es_autoridad;

    public boolean getEs_autoridad() {
        return this.es_autoridad;
    }

    public void setEs_autoridad(boolean es_autoridad) {
        this.es_autoridad = es_autoridad;
    }

    @ManyToOne
    @JoinColumn(name = "aut_categoria_id")
    private Categoria aut_categoria_id;

    public void setAut_categoria_id(Categoria aut_categoria_id) {
        this.aut_categoria_id = aut_categoria_id;
    }

    public Categoria getAut_categoria_id() {
        return aut_categoria_id;
    }

    
    
}
