package com.moisegit.to_do_list.repository;


import com.moisegit.to_do_list.dto.AutorDto;
import com.moisegit.to_do_list.model.AutorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AutorRepository extends JpaRepository<AutorEntity, Integer> {
    Optional<AutorEntity> findByNome(String nome);
    Optional<AutorEntity> findByNacionalidade(String nacionalidade);
}
