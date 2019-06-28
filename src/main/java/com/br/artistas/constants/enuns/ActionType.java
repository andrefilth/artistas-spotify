package com.br.artistas.constants.enuns;

import com.br.artistas.exceptions.ArtistaInvalidInputException;
import com.fasterxml.jackson.annotation.JsonCreator;

public enum ActionType {
    CREATE,
    AUTHORIZE,
    CAPTURE,
    CANCEL,
    REFUND,
    MIGRATION,
    RELEASE;

    @JsonCreator
    static ActionType of(String value) {
        try {
            return valueOf(value);

        } catch (Exception e) {
            throw new ArtistaInvalidInputException("action_type_parse_error", "Os ActionType válidos são: ["
                    + CREATE + "," + AUTHORIZE + ", " + CAPTURE + ", " + CANCEL + ", " +  ", " + RELEASE + "]");
        }
    }
}
