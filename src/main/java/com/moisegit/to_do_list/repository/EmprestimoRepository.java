package com.moisegit.to_do_list.repository;

import com.moisegit.to_do_list.model.EmprestimoEntity;
import com.moisegit.to_do_list.model.LeitorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmprestimoRepository extends JpaRepository<EmprestimoEntity, Integer> {
    Optional<EmprestimoEntity> findByLeitorEmail(String email);
}
