package com.sorteador.sorteador.services.impl;



import com.sorteador.sorteador.model.Categoria_tope;
import com.sorteador.sorteador.repositories.Categoria_topeRepository;
import com.sorteador.sorteador.services.Categoria_topeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class Categoria_topeServiceImpl implements Categoria_topeService {
    private final Categoria_topeRepository categoriaTopeRepository;
    public Categoria_topeServiceImpl(Categoria_topeRepository categoriaTopeRepository){
        this.categoriaTopeRepository = categoriaTopeRepository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Categoria_tope> listarCategoria_tope(){
        return (List<Categoria_tope>)this.categoriaTopeRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Categoria_tope> listarCategoria_topeId(int id){
        return this.categoriaTopeRepository.findById(id);
    }

    @Transactional
    @Override
    public Categoria_tope agregarCategoria_tope(Categoria_tope categoria_tope){
        if(categoria_tope == null || categoria_tope.getAut_categoria_id()==null){
            throw new RuntimeException("La Categoria no puede ser nula");
        }

        return categoriaTopeRepository.save(categoria_tope);
    }

    @Transactional
    @Override
    public Categoria_tope modificarCategoria_tope(int id, Categoria_tope categoria_topeModificada){
        Categoria_tope categoriaTopeExistente = categoriaTopeRepository.findById(id).orElse(null);

        if(categoriaTopeExistente == null){
            throw new RuntimeException("La categoria con ID " + id + " no existe.");
        }
        categoriaTopeExistente.setCantidad_max(categoria_topeModificada.getCantidad_max());
        categoriaTopeExistente.setCantidad_min(categoria_topeModificada.getCantidad_min());
        categoriaTopeExistente.setEs_autoridad(categoria_topeModificada.getEs_autoridad());

        return categoriaTopeRepository.save(categoriaTopeExistente);
    }
}














