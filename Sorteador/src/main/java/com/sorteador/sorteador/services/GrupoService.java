package com.sorteador.sorteador.services;

import java.util.List;
import java.util.Optional;

import com.sorteador.sorteador.model.Grupo;

public interface GrupoService {
    List<Grupo> listarGrupos();
    Optional<Grupo> listarGrupoId(int id);
    Grupo agregarGrupo(Grupo grupo);
    Grupo modificarGrupo(int id, Grupo grupoModificado);
}
