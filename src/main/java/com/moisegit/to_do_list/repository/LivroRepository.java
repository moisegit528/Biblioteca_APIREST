package com.moisegit.to_do_list.repository;

import com.moisegit.to_do_list.model.AutorEntity;
import com.moisegit.to_do_list.model.LivroEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LivroRepository extends JpaRepository<LivroEntity, Integer> {
    List<LivroEntity> findBytitulo(String titulo);
    List<LivroEntity> findByautorId(Integer autorId);
}
