package br.com.github.lucasmlg1.cadastro_pets.exception;

public class EmailJaCadastradoException extends RuntimeException {
    public EmailJaCadastradoException(String email) {
        super("Já existe um adotante cadastrado com o email: " + email);
    }
}
