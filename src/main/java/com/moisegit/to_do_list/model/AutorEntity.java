package com.moisegit.to_do_list.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity(name = "autor")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AutorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    String nome;

    @OneToMany(mappedBy = "autor")
    private Set<LivroEntity> livro = new HashSet<>();
}
