package com.moisegit.to_do_list.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity(name = "livro")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class LivroEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank
    private String titulo;
    @NotBlank
    private String genero;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    private AutorEntity autor;
}
