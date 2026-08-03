package com.moisegit.biblioteca.repository;


import com.moisegit.biblioteca.model.AutorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AutorRepository extends JpaRepository<AutorEntity, Integer> {
    Optional<AutorEntity> findByNome(String nome);
}
