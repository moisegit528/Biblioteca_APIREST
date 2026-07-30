package com.moisegit.to_do_list.repository;

import com.moisegit.to_do_list.model.AutorEntity;
import com.moisegit.to_do_list.model.LivroEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LivroRepository extends JpaRepository<LivroEntity, Integer> {
    Optional<LivroEntity> findBytitulo(String titulo);
    Optional<LivroEntity> findByautorId(Integer autorId);
}
