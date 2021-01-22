package it.prova.provaprofili.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UtenteRegistrazioneDto {

    private String nome;
    private String cognome;
    private String email;
    private String password;
    private String passwordRepeat;

}
