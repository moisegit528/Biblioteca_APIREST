package com.moisegit.biblioteca.service;

import com.moisegit.biblioteca.dto.AutorDto;
import com.moisegit.biblioteca.exception.NotFoundException;
import com.moisegit.biblioteca.model.AutorEntity;
import com.moisegit.biblioteca.repository.AutorRepository;
import lombok.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AutorService {

    private final AutorRepository autorRepository;

    // POST
    public void cadastrarAutor(AutorDto autorDto) {
        autorRepository.save(AutorEntity.builder()
                        .nome(autorDto.getNome())
                .nacionalidade(autorDto.getNacionalidade())
                .biografia(autorDto.getBiografia())
                .build());
    }

    // GET
    public List<AutorEntity> findAll() {
        return autorRepository.findAll();
    }
    // GET
    public AutorEntity findByNome(String nome) throws NotFoundException {
        return autorRepository.findByNome(nome)
                .orElseThrow(() -> new NotFoundException("Autor não encontrado"));
    }

    // PUT
    public AutorDto atualizarAutor(AutorDto autorDto) {
        AutorEntity autor = autorRepository.findById(autorDto.getAutorId())
                .orElseThrow(() -> new NotFoundException("Autor não encontrado!"));
        autor .setNome(autorDto.getNome());
        autor.setNacionalidade(autorDto.getNacionalidade());
        autor.setBiografia(autorDto.getBiografia());
        AutorEntity autorAtualizado = autorRepository.save(autor);

        return AutorDto.builder()
                .nome(autorAtualizado.getNome())
                .nacionalidade(autorAtualizado.getNacionalidade())
                .biografia(autorAtualizado.getBiografia())
                .build();
    }

    // DELETE
    void deletarAutor(Integer id) {
        autorRepository.deleteById(id);
    }

}
