package com.sorteador.sorteador.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sorteador.sorteador.model.Grupo;
import com.sorteador.sorteador.repositories.GrupoRepository;
import com.sorteador.sorteador.services.GrupoService;

@Service
public class GrupoServiceImpl implements GrupoService{
    private final GrupoRepository grupoRepository;

    public GrupoServiceImpl(GrupoRepository grupoRepository) {
        this.grupoRepository = grupoRepository;
    }

    
    @Transactional(readOnly = true)
    @Override
    public List<Grupo> listarGrupos(){
        return (List<Grupo>)this.grupoRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Grupo> listarGrupoId(int id){
        return this.grupoRepository.findById(id);
    }

    @Transactional
    @Override
    public Grupo agregarGrupo(Grupo grupo){
        return this.grupoRepository.save(grupo);
    }

    @Transactional
    @Override
    public Grupo modificarGrupo(int id, Grupo grupoModificado){
        Grupo grupoExistente = grupoRepository.findById(id).orElse(null);

        if(grupoExistente == null){
            throw new RuntimeException("El grupo con el id "+id+" no existe.");
        }

        grupoExistente.setNombre(grupoModificado.getNombre());
        grupoExistente.setOrden_grupo(grupoModificado.getOrden_grupo());

        return grupoRepository.save(grupoExistente);
    }
}
