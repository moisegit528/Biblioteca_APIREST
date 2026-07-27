package com.moisegit.to_do_list.controller;

import com.moisegit.to_do_list.dto.AutorDto;
import com.moisegit.to_do_list.model.AutorEntity;
import com.moisegit.to_do_list.repository.AutorRepository;
import com.moisegit.to_do_list.service.AutorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autor")
@RequiredArgsConstructor
public class AutorController {

    private final AutorRepository autorRepository;
    private final AutorService autorService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createAutor(@RequestBody AutorDto autorDto) {
        autorService.cadastrarAutor(autorDto);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<AutorEntity> findAll() {
        return autorRepository.findAll();
    }

    @GetMapping("/nome/{nome}")
    @ResponseStatus(HttpStatus.OK)
    public List<AutorEntity> findByNome(@PathVariable String nome) {
        return autorService.findByNome(nome);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void atualizarAutor(@PathVariable Integer id, @RequestBody AutorDto autorDto) {
        autorService.atualizarAutor(autorDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteAutor(@PathVariable Integer id) {
        autorRepository.deleteById(id);
    }
}
