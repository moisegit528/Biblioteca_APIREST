package com.moisegit.to_do_list.repository;

import com.moisegit.to_do_list.model.LeitorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LeitorRepository extends JpaRepository<LeitorEntity, Integer> {
    List<LeitorEntity> findByid(Integer id);
    List<LeitorEntity> findByEmail(String email);
}
