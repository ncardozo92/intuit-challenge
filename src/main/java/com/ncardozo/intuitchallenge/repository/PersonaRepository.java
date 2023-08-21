package com.ncardozo.intuitchallenge.repository;

import com.ncardozo.intuitchallenge.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {

    @Query("SELECT p FROM Persona p WHERE p.nombres LIKE %?1%")
    List<Persona> findByNombres(String criterio);
}
