package com.moisegit.to_do_list.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity(name = "autor")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class AutorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    String nome;
    String nacionalidade;
    String biografia;

    @OneToMany(mappedBy = "autor")
    private Set<LivroEntity> livro = new HashSet<>();
}
