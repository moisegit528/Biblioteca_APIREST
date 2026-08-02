package com.moisegit.biblioteca.dto;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class AutorDto {

    private Integer autorId;
    private String nome;
    private String nacionalidade;
    private String biografia;
}
