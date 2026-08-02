package com.moisegit.biblioteca.service;

import com.moisegit.biblioteca.dto.EmprestimoDto;
import com.moisegit.biblioteca.exception.NotFoundException;
import com.moisegit.biblioteca.model.EmprestimoEntity;
import com.moisegit.biblioteca.model.LeitorEntity;
import com.moisegit.biblioteca.model.LivroEntity;
import com.moisegit.biblioteca.repository.EmprestimoRepository;
import com.moisegit.biblioteca.repository.LeitorRepository;
import com.moisegit.biblioteca.repository.LivroRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class EmprestimoService {

    private final EmprestimoRepository emprestimoRepository;
    private final LeitorRepository leitorRepository;
    private final LivroRepository livroRepository;

    // CRIANDO EMPRÉSTIMO
    public EmprestimoDto realizarEmprestimo(EmprestimoDto emprestimoDto) {
        LeitorEntity leitor = leitorRepository.findByEmail(emprestimoDto.getEmailLeitor())
                .orElseThrow(() -> new NotFoundException("Leitor não encontrado!"));
        LivroEntity livro = livroRepository.findBytitulo(emprestimoDto.getTituloLivro())
                .orElseThrow(() -> new NotFoundException("Livro não encontrado!"));

        Set<LivroEntity> livros = new HashSet<>();
        livros.add(livro);

        EmprestimoEntity emprestimo = EmprestimoEntity.builder()
                .leitor(leitor)
                .livro(livros)
                .build();

        emprestimo.setDataDevolucao(LocalDateTime.now().plusDays(7));
        emprestimo.setNumeroEmprestimo(String.valueOf((System.currentTimeMillis() % 10000)));

        emprestimoRepository.save(emprestimo);

        return EmprestimoDto.builder()
                .emailLeitor(emprestimo.getLeitor().getEmail())
                .dataEmprestimo(emprestimo.getDataEmprestimo())
                .dataDevolucao(emprestimo.getDataDevolucao())
                .tituloLivro(livro.getTitulo())
                .numeroEmprestimo(emprestimo.getNumeroEmprestimo())
                .build();
    }
    // GET - lista todos os empréstimos.
    public List<EmprestimoEntity> findAll() {
        return emprestimoRepository.findAll();
    }
    // GET - buscando empréstimo pela numeração "numero do emprestimo".
    public EmprestimoEntity findByNumeroEmprestimo(String numeroEmprestimo) {
        return emprestimoRepository.findByNumeroEmprestimo(numeroEmprestimo)
                .orElseThrow(() -> new NotFoundException("Nenhum empréstimo encontrado!"));
    }
    // PUT - Renovar empréstimo "7 dias".
    public EmprestimoDto atualizarEmprestimo(String numeroEmprestimo) {
        EmprestimoEntity emprestimo = emprestimoRepository.findByNumeroEmprestimo(numeroEmprestimo)
                .orElseThrow(() -> new NotFoundException("Nenhum empréstimo encontrado!"));

        emprestimo.setDataDevolucao(LocalDateTime.now().plusDays(7));

        EmprestimoEntity emprestimoAtualizado = emprestimoRepository.save(emprestimo);

        return EmprestimoDto.builder()
                .dataEmprestimo(emprestimoAtualizado.getDataEmprestimo())
                .dataDevolucao(emprestimoAtualizado.getDataDevolucao())
                .numeroEmprestimo(emprestimoAtualizado.getNumeroEmprestimo())
                .build();
    }
    // DELETE - deletando empréstimos
    @Transactional
    public void deleteByNumeroEmprestimo(String numeroEmprestimo) {
        if (!emprestimoRepository.existsByNumeroEmprestimo(numeroEmprestimo)) {
            throw new NotFoundException("Empréstimo não encontrado!");
        }
        emprestimoRepository.deleteByNumeroEmprestimo(numeroEmprestimo);
    }

}
