package com.moisegit.to_do_list.controller;

import com.moisegit.to_do_list.dto.EmprestimoDto;
import com.moisegit.to_do_list.model.EmprestimoEntity;
import com.moisegit.to_do_list.repository.EmprestimoRepository;
import com.moisegit.to_do_list.service.EmprestimoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emprestimo")
@RequiredArgsConstructor
public class EmprestimoController {

    private final EmprestimoService emprestimoService;

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

    @GetMapping("/{email}")
    @ResponseStatus(HttpStatus.OK)
    public EmprestimoEntity findByLeitorEmail(@PathVariable String email) {
        return emprestimoService.findByLeitorEmail(email);
    }


}
