package com.moisegit.biblioteca.service;

import com.moisegit.biblioteca.dto.LivroDto;
import com.moisegit.biblioteca.exception.NotFoundException;
import com.moisegit.biblioteca.model.AutorEntity;
import com.moisegit.biblioteca.model.LivroEntity;
import com.moisegit.biblioteca.repository.AutorRepository;
import com.moisegit.biblioteca.repository.LivroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LivroService {

    private final LivroRepository livroRepository;
    private final AutorRepository autorRepository;

    // POST - Para cadastrar é preciso ter um autor desse livro.
    //  Primeiro ocorre a busca do autor, só depois pode ser cadastrado o livro daquele autor.
    public void cadastrarLivro(LivroDto livroDto) {
        AutorEntity autor = autorRepository.findById(livroDto.getAutorId())
                        .orElseThrow(() -> new NotFoundException("Autor do livro não encontrado, " +
                                "não é possível cadastrar esse livro, ao autor solicitado!"));
        livroRepository.save(LivroEntity.builder()
                        .titulo(livroDto.getTitulo())
                        .genero(livroDto.getGenero())
                        .autor(autor)
                .build());
    }
    //GET - LISTA TODOS OS LIVROS
    public List<LivroEntity> findAll() {
        return livroRepository.findAll();
    }
    // GET - BUSCA POR TÍTULO DO LIVRO
    public LivroEntity findBytitulo(String titulo) {
        return livroRepository.findBytitulo(titulo)
                .orElseThrow(() -> new NotFoundException("Livro não encontrado"));
    }
    // GET - BUSCA POR AUTOR DO LIVRO
    public LivroEntity findByautorId(Integer autorId) {
        return livroRepository.findByautorId(autorId)
                .orElseThrow(() -> new NotFoundException("Livro não encontrado"));
    }
    // PUT - CADASTRO ERRADO, PRECISA SER CORRIGIDO
    public void atualizarLivro(Integer id, LivroDto livroDto) {
        livroRepository.save(LivroEntity.builder()
                        .id(id)
                        .titulo(livroDto.getTitulo())
                        .genero(livroDto.getGenero())
                        .autor(AutorEntity.builder().id(livroDto.getAutorId()).build())
                .build());
    }
    // DELETAR LIVRO
    public void deletarLivro(Integer id) {
        livroRepository.deleteById(id);
    }
}
