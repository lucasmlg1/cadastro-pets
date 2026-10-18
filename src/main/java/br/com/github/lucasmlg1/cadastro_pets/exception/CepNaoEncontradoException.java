package br.com.github.lucasmlg1.cadastro_pets.exception;

public class CepNaoEncontradoException extends RuntimeException {
    public CepNaoEncontradoException(String cep) {
        super("CEP não encontrado: " + cep);
    }
}
