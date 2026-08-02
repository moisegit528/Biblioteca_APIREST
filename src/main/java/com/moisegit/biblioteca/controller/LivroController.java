package com.moisegit.biblioteca.controller;

import com.moisegit.biblioteca.dto.LivroDto;
import com.moisegit.biblioteca.model.LivroEntity;
import com.moisegit.biblioteca.repository.AutorRepository;
import com.moisegit.biblioteca.repository.LivroRepository;
import com.moisegit.biblioteca.service.AutorService;
import com.moisegit.biblioteca.service.LivroService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livro")
@RequiredArgsConstructor
public class LivroController {

    private final LivroRepository livroRepository;
    private final AutorRepository autorRepository;
    private final LivroService livroService;
    private final AutorService autorService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void cadastrarLivro(@RequestBody LivroDto livroDto) {
        livroService.cadastrarLivro(livroDto);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<LivroEntity> findAll() {
        return livroRepository.findAll();
    }

    @GetMapping("/titulo/{titulo}")
    @ResponseStatus(HttpStatus.OK)
    public LivroEntity findBytitulo(@PathVariable String titulo){
        return livroService.findBytitulo(titulo);
    }

    @GetMapping("/id/{autorId}")
    @ResponseStatus(HttpStatus.OK)
    public LivroEntity findByautorId(@PathVariable Integer autorId){
        return livroService.findByautorId(autorId);
    }

    @PutMapping("/idlivro/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void atualizarLivro(@PathVariable Integer id, @RequestBody LivroDto livroDto) {
        livroService.atualizarLivro(id, livroDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deletarLivro(@PathVariable Integer id){
        livroService.deletarLivro(id);
    }
}
