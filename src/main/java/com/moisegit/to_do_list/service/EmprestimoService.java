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

@Service
@RequiredArgsConstructor
public class EmprestimoService {

    private final EmprestimoRepository emprestimoRepository;
    private final LeitorRepository leitorRepository;
    private final LivroRepository livroRepository;

    public void realizarEmprestimo(EmprestimoDto emprestimoDto) {
        LeitorEntity leitor = leitorRepository.findByEmail(emprestimoDto.getEmailLeitor())
                .orElseThrow(() -> new NotFoundException("Leitor não encontrado!"));
        LivroEntity livro = livroRepository.findBytitulo(emprestimoDto.getTituloLivro())
                .orElseThrow(() -> new NotFoundException("Livro não encontrado!"));

        leitor = EmprestimoEntity.builder()
                .leitor(emprestimoDto.getEmailLeitor())
                .livro(emprestimoDto.getTituloLivro())
                .build();
    }
}
