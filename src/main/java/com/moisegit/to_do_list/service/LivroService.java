package com.moisegit.to_do_list.service;

import com.moisegit.to_do_list.dto.LivroDto;
import com.moisegit.to_do_list.exception.NotFoundException;
import com.moisegit.to_do_list.model.AutorEntity;
import com.moisegit.to_do_list.model.LivroEntity;
import com.moisegit.to_do_list.repository.AutorRepository;
import com.moisegit.to_do_list.repository.LivroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LivroService {

    private final LivroRepository livroRepository;
    private final AutorRepository autorRepository;

    // POST
    public void cadastrarLivro(LivroDto livroDto) {
        AutorEntity autor = autorRepository.findById(livroDto.getAutorId())
                        .orElseThrow(() -> new NotFoundException("Autor não encontrado!"));
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
    public List<LivroEntity> findBytitulo(String titulo) {
        return livroRepository.findBytitulo(titulo);
    }
    // GET - BUSCA POR AUTOR DO LIVRO
    public List<LivroEntity> findByautorId(Integer autorId) {
        return livroRepository.findByautorId(autorId);
    }
    // PUT - CADASTRO ERRADO, PRECISA SER CORRIGIDO
    public void atualizarLivro(LivroDto livroDto) {
        livroRepository.save(LivroEntity.builder()
                        .titulo(livroDto.getTitulo())
                        .genero(livroDto.getGenero())
                .build());
    }
    // DELETAR LIVRO
    public void deletarLivro(Integer id) {
        livroRepository.deleteById(id);
    }
}
