package com.moisegit.biblioteca.repository;

import com.moisegit.biblioteca.model.LeitorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LeitorRepository extends JpaRepository<LeitorEntity, Integer> {
    Optional<LeitorEntity> findByid(Integer id);
    Optional<LeitorEntity> findByEmail(String email);
}
