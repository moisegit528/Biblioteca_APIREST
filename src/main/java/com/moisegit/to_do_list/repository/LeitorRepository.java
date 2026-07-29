package com.moisegit.to_do_list.repository;

import com.moisegit.to_do_list.model.LeitorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LeitorRepository extends JpaRepository<LeitorEntity, Integer> {
    Optional<LeitorEntity> findByid(Integer id);
    Optional<LeitorEntity> findByEmail(String email);
}
