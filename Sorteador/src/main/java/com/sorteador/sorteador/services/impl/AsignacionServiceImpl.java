package com.sorteador.sorteador.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sorteador.sorteador.model.Asignacion;
import com.sorteador.sorteador.repositories.AsignacionRepository;
import com.sorteador.sorteador.services.AsignacionService;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AsignacionServiceImpl implements AsignacionService {
    private final AsignacionRepository asignacionRepository;

    public AsignacionServiceImpl (AsignacionRepository asignacionRepository){
        this.asignacionRepository = asignacionRepository;
    }
    @Transactional(readOnly = true)
    @Override
    public List<Asignacion> listarAsignaciones(){
        return (List<Asignacion>)this.asignacionRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Asignacion> listarAsignacionId (int id){
        return this.asignacionRepository.findById(id);
    }

    @Transactional
    @Override
    public Asignacion agregarAsignacion(Asignacion asignacion){
        return asignacionRepository.save(asignacion);
    }

    @Transactional
    @Override
    public Asignacion modificarAsignacion(int id, Asignacion asignacionModificada){
        Asignacion asignacionExistente = asignacionRepository.findById(id).orElse(null);

        if(asignacionExistente == null){
            throw new RuntimeException("La Asignacion con ID " + id + " no existe.");
        }

        asignacionExistente.setEstado(asignacionModificada.getEstado());

        return asignacionRepository.save(asignacionExistente);
    }

    @Transactional
    @Override
     public void borrarAsignacion(int id){
         asignacionRepository.deleteById(id);
     }
}
