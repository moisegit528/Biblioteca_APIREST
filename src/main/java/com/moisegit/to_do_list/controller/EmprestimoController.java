package com.moisegit.to_do_list.controller;

import com.moisegit.to_do_list.repository.EmprestimoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/emprestimo")
@RequiredArgsConstructor
public class EmprestimoController {

    private final EmprestimoRepository emprestimoRepository;



}
