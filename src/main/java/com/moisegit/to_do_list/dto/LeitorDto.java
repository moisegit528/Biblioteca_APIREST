package com.moisegit.to_do_list.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class LeitorDto {

    @NotBlank
    private String nome;
    @NotBlank
    private String email;

}
