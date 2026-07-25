package com.moisegit.to_do_list.repository;

import com.moisegit.to_do_list.model.LivroEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<LivroEntity, Integer> {
}
