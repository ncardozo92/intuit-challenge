package com.ncardozo.intuitchallenge.controller;

import com.ncardozo.intuitchallenge.dto.PersonaDto;
import com.ncardozo.intuitchallenge.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class PersonaController {

    private static final String PATH = "/personas";

    @Autowired
    private PersonaService personaService;

    @GetMapping(PATH)
    public ResponseEntity<List<PersonaDto>> getPersonas(){
        return ResponseEntity.ok(personaService.getPersonas());
    }

    @GetMapping(PATH + "/{id}")
    public ResponseEntity<PersonaDto> getPersona(@PathVariable("id") Long id){
        return ResponseEntity.ok(personaService.getPersona(id));
    }

    @PostMapping(PATH)
    public ResponseEntity crearPersona(@RequestBody @Valid PersonaDto personaDto){
        personaService.crearPersona(personaDto);
        return ResponseEntity.ok().build();
    }

    @PutMapping(PATH + "/{id}")
    public ResponseEntity actualizarPersona(@PathVariable("id") Long id,@RequestBody @Valid PersonaDto personaDto){
        return ResponseEntity.ok(personaService.actualizarPersona(id, personaDto));
    }

    @GetMapping(PATH + "/search")
    public ResponseEntity<List<PersonaDto>> buscarPorCriterio(@RequestParam String criterio){
        return ResponseEntity.ok(personaService.buscarPorCriterio(criterio));
    }
}
