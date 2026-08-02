package com.moisegit.biblioteca.model;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "emprestimo")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class EmprestimoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @CreationTimestamp
    private LocalDateTime dataEmprestimo;
    private LocalDateTime dataDevolucao;
    @Column(name = "numero_emprestimo", nullable = false)
    private String numeroEmprestimo = String.valueOf((System.currentTimeMillis() % 10000));

    @ManyToOne
    @JoinColumn(name = "leitor_id")
    private LeitorEntity leitor;

    @ManyToMany
    @JoinTable(name = "emprestimo_livro",
    joinColumns = @JoinColumn(name = "emprestimo_id"),
            inverseJoinColumns = @JoinColumn(name = "livro_id"))
    private Set<LivroEntity> livro = new HashSet<>();
}
