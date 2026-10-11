package br.com.github.lucasmlg1.cadastro_pets.exception;

import java.util.UUID;

public class AdotanteComPetsException extends RuntimeException {
    public AdotanteComPetsException(UUID id) {
        super("Não é possível remover o adotante " + id + " porque ele possui pets vinculados");
    }
}
