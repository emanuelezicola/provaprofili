package it.prova.provaprofili.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

/**
 * DTO base che può essere ussato per scambiarsi le info tra FE e BE
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CommonUserDto {

    private Long id;
    private String nome;
    private String cognome;
    private String email;
    private LocalDate dataRegistrazione;
}
