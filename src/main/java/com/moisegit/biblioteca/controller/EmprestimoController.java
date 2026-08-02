package com.moisegit.biblioteca.controller;

import com.moisegit.biblioteca.dto.EmprestimoDto;
import com.moisegit.biblioteca.model.EmprestimoEntity;
import com.moisegit.biblioteca.repository.EmprestimoRepository;
import com.moisegit.biblioteca.service.EmprestimoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emprestimo")
@RequiredArgsConstructor
public class EmprestimoController {

    private final EmprestimoService emprestimoService;
    private final EmprestimoRepository emprestimoRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public EmprestimoDto realizarEmprestimo(@RequestBody EmprestimoDto emprestimoDto) {
        return emprestimoService.realizarEmprestimo(emprestimoDto);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<EmprestimoEntity>  findAll() {
        return emprestimoService.findAll();
    }

    @GetMapping("/{numeroEmprestimo}")
    @ResponseStatus(HttpStatus.OK)
    public EmprestimoEntity findByNumeroEmprestimo(@PathVariable String numeroEmprestimo) {
        return emprestimoService.findByNumeroEmprestimo(numeroEmprestimo);
    }

    @PutMapping("/renovar/{numeroEmprestimo}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public EmprestimoDto atualizarEmprestimo(@PathVariable String numeroEmprestimo) {
        return emprestimoService.atualizarEmprestimo(numeroEmprestimo);
    }

    @DeleteMapping("/delete/{numeroEmprestimo}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteByNumeroEmprestimo(@PathVariable String numeroEmprestimo) {
        emprestimoService.deleteByNumeroEmprestimo(numeroEmprestimo);
    }
}
