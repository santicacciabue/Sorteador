package com.sorteador.sorteador.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sorteador.sorteador.model.Grupo;
import com.sorteador.sorteador.services.GrupoService;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;





@RestController
@RequestMapping("/api/grupo")
public class GrupoController {
    private final GrupoService grupoService;

    public GrupoController(GrupoService grupoService) {
        this.grupoService = grupoService;
    }

    @GetMapping("/listar")
    public List<Grupo> listarGrupos() {
        return grupoService.listarGrupos();
    }

    @GetMapping("/listar/{id}")
    public Object listarGrupoId(@PathVariable Integer id, RedirectAttributes redirect) {
        Optional<Grupo> grupoOptional = grupoService.listarGrupoId(id);
        if(grupoOptional.isPresent()){
            return grupoService.listarGrupoId(id);
        }else{
            redirect.addFlashAttribute("error", "El grupo no se encuentra en la base de datos!");
            return "redirect:/api/grupo";
        }
    }

    @PostMapping("/agregar")
    public ResponseEntity<Grupo> agregarGrupo(@RequestBody Grupo grupo) {
        Grupo nuevoGrupo = grupoService.agregarGrupo(grupo);
        return new ResponseEntity<>(nuevoGrupo,HttpStatus.CREATED);
    }

    @PutMapping("/modificar/{id}")
    public ResponseEntity<?> modificarGrupo(@PathVariable Integer id, @RequestBody Grupo grupoModificado) {
        try {
            Grupo grupo = grupoService.modificarGrupo(id, grupoModificado);
            return ResponseEntity.ok(grupo);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: "+e.getMessage());
        }
    
    }
    
    
    
    
}
