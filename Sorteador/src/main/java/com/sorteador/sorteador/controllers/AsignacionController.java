package com.sorteador.sorteador.controllers;


import com.sorteador.sorteador.model.Asignacion;
import com.sorteador.sorteador.services.AsignacionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/asignacion")
public class AsignacionController {
    private final AsignacionService asignacionService;

    public AsignacionController(AsignacionService asignacionService) {
        this.asignacionService = asignacionService;
    }

    @GetMapping("/listar")
    public List<Asignacion> listarAsignacion(){
        return asignacionService.listarAsignaciones();
    }

    @GetMapping("/listar/${id}")
    public Object obtenerAsignacionId(@PathVariable int id, RedirectAttributes redirect){
        Optional<Asignacion> asignacionOptional = asignacionService.listarAsignacionId(id);
        if(asignacionOptional.isPresent()) {
            return asignacionService.listarAsignacionId(id);
        }else{
            redirect.addFlashAttribute("error", "El usuario con id " +
                    id +
                    " no existe en la base de datos!");

            return "redirect:/users";
        }
    }





}
