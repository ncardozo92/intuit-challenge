package com.ncardozo.intuitchallenge.service;

import com.ncardozo.intuitchallenge.dto.PersonaDto;
import com.ncardozo.intuitchallenge.entity.Persona;
import com.ncardozo.intuitchallenge.exception.ApiException;
import com.ncardozo.intuitchallenge.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    private static final String PERSONA_NO_ENCONTRADA = "Persona no encontrada";

    public List<PersonaDto> getPersonas(){
        return personaRepository.findAll()
                .stream().map(this::toDto)
                .collect(Collectors.toList());
    }

    public PersonaDto getPersona(Long id){
        Persona persona = personaRepository.findById(id)
                .orElseThrow(() -> new ApiException(PERSONA_NO_ENCONTRADA, 404));

        return toDto(persona);
    }



    public void crearPersona(PersonaDto personaDto) {
        Persona persona = toEntity(personaDto);
        personaRepository.save(persona);
    }

    public PersonaDto actualizarPersona(Long id, PersonaDto dto) {

        Persona persona = personaRepository.findById(id)
                .orElseThrow(() -> new ApiException(PERSONA_NO_ENCONTRADA, 404));

        persona.setNombres(dto.getNombres());
        persona.setApellidos(dto.getApellidos());
        persona.setCuit(dto.getCuit());
        persona.setDireccion(dto.getDireccion());
        persona.setEmail(dto.getEmail());
        persona.setTelefono(dto.getTelefono());
        persona.setFechaNacimiento(dto.getFechaNacimiento());

        return toDto(personaRepository.save(persona));
    }

    public List<PersonaDto> buscarPorCriterio(String criterio){
        List<Persona> personas = personaRepository.findByNombres(criterio);

        return personas.stream().map(this::toDto).collect(Collectors.toList());
    }

    public PersonaDto toDto(Persona p){
        PersonaDto dto = new PersonaDto();

        dto.setId(p.getId());
        dto.setNombres(p.getNombres());
        dto.setApellidos(p.getApellidos());
        dto.setFechaNacimiento(p.getFechaNacimiento());
        dto.setCuit(p.getCuit());
        dto.setDireccion(p.getDireccion());
        dto.setEmail(p.getEmail());
        dto.setTelefono(p.getTelefono());

        return dto;
    }

    private Persona toEntity(PersonaDto dto) {
        Persona p = new Persona();

        p.setId(dto.getId());
        p.setNombres(dto.getNombres());
        p.setApellidos(dto.getApellidos());
        p.setFechaNacimiento(dto.getFechaNacimiento());
        p.setCuit(dto.getCuit());
        p.setDireccion(dto.getDireccion());
        p.setEmail(dto.getEmail());
        p.setTelefono(dto.getTelefono());

        return p;
    }

}
