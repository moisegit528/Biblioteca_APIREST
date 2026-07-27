package com.moisegit.to_do_list.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
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
    @NotBlank
    String nome;
    @NotBlank
    String nacionalidade;
    @NotBlank
    String biografia;

    @OneToMany(mappedBy = "autor")
    @JsonIgnore
    private Set<LivroEntity> livro = new HashSet<>();
}
