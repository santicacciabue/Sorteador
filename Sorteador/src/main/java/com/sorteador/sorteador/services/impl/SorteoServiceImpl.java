package com.sorteador.sorteador.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sorteador.sorteador.model.Rel_producto;
import com.sorteador.sorteador.model.Sorteo;
import com.sorteador.sorteador.repositories.SorteoRepository;
import com.sorteador.sorteador.services.Rel_productoService;
import com.sorteador.sorteador.services.SorteoService;


@Service
public class SorteoServiceImpl implements SorteoService{
    private final SorteoRepository sorteoRepository;
    private final Rel_productoService rel_productoService;


    public SorteoServiceImpl(SorteoRepository sorteoRepository, Rel_productoService rel_productoService) {
        this.sorteoRepository = sorteoRepository;
        this.rel_productoService = rel_productoService;
    }


    @Transactional(readOnly = true)
    @Override
    public List<Sorteo> listarSorteos(){
        return (List<Sorteo>)this.sorteoRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Sorteo> listarSorteoId(int id){
        return this.sorteoRepository.findById(id);
    }

    
    

}
