package br.com.github.lucasmlg1.cadastro_pets.exception;

import java.util.UUID;

public class PetJaAdotadoException extends RuntimeException {
    public PetJaAdotadoException(UUID id) {
        super("O pet " + id + " já foi adotado");
    }
}