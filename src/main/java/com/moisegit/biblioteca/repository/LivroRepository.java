package com.moisegit.biblioteca.repository;

import com.moisegit.biblioteca.model.LivroEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LivroRepository extends JpaRepository<LivroEntity, Integer> {
    Optional<LivroEntity> findBytitulo(String titulo);
    Optional<LivroEntity> findByautorId(Integer autorId);
}
