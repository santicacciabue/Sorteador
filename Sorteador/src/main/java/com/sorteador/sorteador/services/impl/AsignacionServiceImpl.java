package main.java.com.sorteador.sorteador.services.impl;

import java.util.Optional;

import com.sorteador.sorteador.model.Asignacion;
import com.sorteador.sorteador.repositories.AsignacionRepository;

@Service
public class AsignacionServiceImpl implements AsignacionService {
    private final AsignacionRepository asignacionRepository;

    public AsignacionServiceImpl (AsignacionRepository asignacionRepository){
        this.asignacionRepository = asignacionRepository;
    }

    public List<Asignacion> listarAsignaciones(){
        return (List<Asignacion>)this.asignacionRepository.findAll();
    }

    public Optional<Asignacion> listarAsignacionId (int id){
        return this.asignacionRepository.findById(id);
    }

    public Asignacion agregarAsignacion(Asignacion asignacion){
        return asignacionRepository.save(asignacion);
    }

    public Asignacion borrarAsignacion(int id){
        return asignacionRepository.deleteById(id);
    }
}
