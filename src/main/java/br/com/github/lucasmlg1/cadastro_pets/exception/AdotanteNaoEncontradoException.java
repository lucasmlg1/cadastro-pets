package br.com.github.lucasmlg1.cadastro_pets.exception;

import java.util.UUID;

public class AdotanteNaoEncontradoException extends RuntimeException {
    public AdotanteNaoEncontradoException(UUID id) {
        super("Adotante não encontrado: " + id);
    }
}
