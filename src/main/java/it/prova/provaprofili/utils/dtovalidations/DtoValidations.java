package it.prova.provaprofili.utils.dtovalidations;

import it.prova.provaprofili.dto.UtenteRegistrazioneDto;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class DtoValidations {

    /**
     * Metodo che controlla se l'utente che si deve registrare è valido oppure no
     * @param utenteRegistrazioneDto L'utente da registrare
     * @return una mappa contenente degli errori se l'oggetto in input non soddisfa i requisiti, null se li soddisfa
     */
    public static Map<String, String> checkRegistrazione(UtenteRegistrazioneDto utenteRegistrazioneDto) {

        //la mappa contiene la chiave che indica il campo che non soddisfa i requisiti ed un valore che indica per quale
        //motivo il requisito non è soddisfatto. In questo modo si possono collegare queste info al FE per illuminare i
        //campi che non soddisfano il requisito.
        Map<String, String> errori = new LinkedHashMap<>();

        //Controllo se l'utente è null. Se si non ha senso fare le altre validazioni
        if (Objects.isNull(utenteRegistrazioneDto)) {
            errori.put("utente", "I dati dell'utente sono incorretti");
            return errori;
        }

        if (Objects.isNull(utenteRegistrazioneDto.getEmail())) {
            errori.put("email", "Il campo email è obbligatorio");
        }

        //TODO controlli regex per controllare email valida.

        if (Objects.isNull(utenteRegistrazioneDto.getPassword())) {
            errori.put("password", "Il campo password è obbligatorio");
        }

        //TODO controlli regex su password per lunghezza minima, caratteri minuscoli, maiuscoli, speciali e numeri

        if (Objects.isNull(utenteRegistrazioneDto.getPasswordRepeat()) || !utenteRegistrazioneDto.getPassword().equals(utenteRegistrazioneDto.getPasswordRepeat())) {
            errori.put("confermaPassword", "La password di conferma non coincide con la password inserita");
        }

        return errori.size() > 0 ? errori : null;

    }

}
