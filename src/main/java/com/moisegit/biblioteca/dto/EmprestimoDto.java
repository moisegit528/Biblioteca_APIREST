package com.moisegit.biblioteca.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmprestimoDto {

    private String emailLeitor;
    private String tituloLivro;
    private LocalDateTime dataEmprestimo;
    private LocalDateTime dataDevolucao;
    private String numeroEmprestimo;
}
