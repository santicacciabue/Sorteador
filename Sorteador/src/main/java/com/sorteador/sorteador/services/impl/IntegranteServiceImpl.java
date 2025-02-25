package com.sorteador.sorteador.services.impl;
import org.springframework.stereotype.Service;

import com.sorteador.sorteador.repositories.IntegranteRepository;
import com.sorteador.sorteador.services.IntegranteService;

@Service
public class IntegranteServiceImpl implements IntegranteService {
    private final IntegranteRepository integranteRepository;

    public IntegranteServiceImpl(IntegranteRepository integranteRepository) {
        this.integranteRepository = integranteRepository;
    }

}
