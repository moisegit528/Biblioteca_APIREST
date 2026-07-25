package com.moisegit.to_do_list.repository;


import com.moisegit.to_do_list.dto.AutorDto;
import com.moisegit.to_do_list.model.AutorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AutorRepository extends JpaRepository<AutorEntity, Integer> {
    List<AutorDto> findByNome(String nome);
    List<AutorDto> findByNacionalidade(String nacionalidade);
}
