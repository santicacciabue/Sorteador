package com.sorteador.sorteador.model;

import java.util.List;

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

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Column(name = "legajo")
    private int legajo;

    public int getLegajo() {
        return this.legajo;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }

    @Column(name = "rol") // ENUM
    private String rol;

    public String getRol() {
        return this.rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    @ManyToOne
    @JoinColumn(name = "aut_grupo_id")
    private Grupo aut_grupo_id;

    @OneToMany(mappedBy = "aut_integrante_reemplazo_id")
    private List<Solicitud_reemplazo> solicitudReemplazoList;

    @OneToMany(mappedBy = "aut_integrante_solicitante_id")
    private List<Solicitud_reemplazo> solicitudSolicitanteList;
    
}
