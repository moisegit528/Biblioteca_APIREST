package com.moisegit.to_do_list.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "leitor")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class LeitorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank
    private String nome;
    @NotBlank
    private String email;

    @CreationTimestamp
    private LocalDateTime dataCadastro;

    @OneToMany(mappedBy = "leitor")
    private Set<EmprestimoEntity> emprestimo = new HashSet<>();

}
