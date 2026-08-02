package com.moisegit.biblioteca.repository;

import com.moisegit.biblioteca.model.EmprestimoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmprestimoRepository extends JpaRepository<EmprestimoEntity, Integer> {
    Optional<EmprestimoEntity> findByNumeroEmprestimo(String numeroEmprestimo);
    void deleteByNumeroEmprestimo(String numeroEmprestimo);
    boolean existsByNumeroEmprestimo(String numeroEmprestimo);
}
