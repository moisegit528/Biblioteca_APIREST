package com.moisegit.to_do_list.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity(name = "emprestimo")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EmprestimoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @CreationTimestamp
    private LocalDateTime dataEmprestimo;
    @CreationTimestamp
    private LocalDateTime dataDevolucao;

    @ManyToOne
    @JoinColumn(name = "leitor_id")
    private LeitorEntity leitor;

}
