package com.sorteador.sorteador.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;

import com.sorteador.sorteador.model.Rel_producto;
import com.sorteador.sorteador.repositories.Rel_productoRepository;
import com.sorteador.sorteador.services.Rel_productoService;



public class Rel_productoServiceImpl implements Rel_productoService {

    private final Rel_productoRepository rel_productoRepository;

    public Rel_productoServiceImpl(Rel_productoRepository rel_productoRepository) {
        this.rel_productoRepository = rel_productoRepository;
    }
    
    @Transactional(readOnly = true)
    @Override
    public List<Rel_producto> listarProductos(){
        return (List<Rel_producto>)this.rel_productoRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Rel_producto> listarProductoId(int id){
        return this.rel_productoRepository.findById(id);
    }

    
}
