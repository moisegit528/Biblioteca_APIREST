package com.moisegit.to_do_list.service;

import com.moisegit.to_do_list.dto.EmprestimoDto;
import com.moisegit.to_do_list.exception.NotFoundException;
import com.moisegit.to_do_list.model.EmprestimoEntity;
import com.moisegit.to_do_list.model.LeitorEntity;
import com.moisegit.to_do_list.model.LivroEntity;
import com.moisegit.to_do_list.repository.EmprestimoRepository;
import com.moisegit.to_do_list.repository.LeitorRepository;
import com.moisegit.to_do_list.repository.LivroRepository;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
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

        emprestimoRepository.save(emprestimo);

        return EmprestimoDto.builder()
                .emailLeitor(emprestimo.getLeitor().getEmail())
                .dataEmprestimo(emprestimo.getDataEmprestimo())
                .dataDevolucao(emprestimo.getDataDevolucao())
                .tituloLivro(livro.getTitulo())
                .build();
    }

    public List<EmprestimoEntity> findAll() {
        return emprestimoRepository.findAll();
    }
    public EmprestimoEntity findByEmail(String email) {
        return emprestimoRepository.findByLeitorEmail(email)
                .orElseThrow(() -> new NotFoundException("Email não encontrado!"));
    }

    public EmprestimoDto atualizarEmprestimo(EmprestimoDto emprestimoDto) {
        EmprestimoEntity emprestimo = emprestimoRepository.findByLeitorEmail(emprestimoDto.getEmailLeitor())
                .orElseThrow(() -> new NotFoundException("Leitor não encontrado!"));

        emprestimoDto.setEmailLeitor(emprestimo.getLeitor().getEmail());
        emprestimoDto.setTituloLivro(emprestimoDto.getTituloLivro());
        emprestimoDto.setDataEmprestimo(emprestimoDto.getDataEmprestimo());
        emprestimoDto.setDataDevolucao(emprestimoDto.getDataDevolucao());

        EmprestimoEntity emprestimoAtualizado = emprestimoRepository.save(emprestimo);

        return EmprestimoDto.builder()
                .dataEmprestimo(emprestimoAtualizado.getDataEmprestimo())
                .dataDevolucao(emprestimoAtualizado.getDataDevolucao())
                .build();
    }
}
