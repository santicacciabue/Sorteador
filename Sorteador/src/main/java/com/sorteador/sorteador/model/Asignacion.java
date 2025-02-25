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
@Table(name = "aut_asignacion")
public class Asignacion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "estado")
    private boolean estado;

    public boolean getEstado() {
        return this.estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @ManyToOne
    @JoinColumn(name = "aut_grupo_id")
    private Grupo aut_grupo_id;

    @ManyToOne
    @JoinColumn(name = "aut_sorteo_id")
    private Sorteo aut_sorteo_id;

    @OneToMany(mappedBy = "aut_asignacion_id")
    private Asignacion asignacion;
}
