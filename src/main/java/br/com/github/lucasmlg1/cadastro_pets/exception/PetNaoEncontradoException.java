package br.com.github.lucasmlg1.cadastro_pets.exception;

import java.util.UUID;

public class PetNaoEncontradoException extends RuntimeException {
    public PetNaoEncontradoException(UUID id) {
        super("Pet não encontrado: " + id);
    }

}
