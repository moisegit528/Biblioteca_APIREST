package com.moisegit.to_do_list.dto;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class EmprestimoDto {

    private String emailLeitor;
    private String tituloLivro;
    private LocalDateTime dataEmprestimo;
    private LocalDateTime dataDevolucao;

}
