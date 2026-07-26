package com.moisegit.to_do_list.service;

import com.moisegit.to_do_list.dto.AutorDto;
import com.moisegit.to_do_list.exception.NotFoundException;
import com.moisegit.to_do_list.model.AutorEntity;
import com.moisegit.to_do_list.repository.AutorRepository;
import lombok.*;
import org.springframework.data.crossstore.ChangeSetPersister;
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
    public List<AutorDto> findByNome(String nome) {
        return autorRepository.findByNome(nome);
    }
    // GET
    public List<AutorDto> findByNacionalidade(String nacionalidade) {
        return autorRepository.findByNacionalidade(nacionalidade);
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
