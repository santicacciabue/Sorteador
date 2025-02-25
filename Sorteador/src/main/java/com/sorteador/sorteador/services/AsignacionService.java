package com.sorteador.sorteador.services;

import java.util.List;
import java.util.Optional;

import com.sorteador.sorteador.model.Asignacion;

public interface AsignacionService {
    List<Asignacion> listarAsignaciones();
    Optional<Asignacion> listarAsignacionId(int id);
    Asignacion agregarAsignacion(Asignacion asignacion);
    Asignacion modificarAsignacion(int id, Asignacion asignacionModificada);
    //void borrarAsignacion(int id);
}
