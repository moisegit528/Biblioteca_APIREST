package com.moisegit.biblioteca.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

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
