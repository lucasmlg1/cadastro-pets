package br.com.github.lucasmlg1.cadastro_pets.exception;

import org.springframework.http.HttpStatus;

import java.util.List;

public record ErroResposta(int status, String message, List<ErroCampo> errors) {

    public static ErroResposta respostaRequisicaoInvalida(String mensagem){
        return new ErroResposta(HttpStatus.BAD_REQUEST.value(), mensagem, List.of());
    }

    public static ErroResposta respostaConflito(String mensagem){
        return new ErroResposta(HttpStatus.CONFLICT.value(), mensagem, List.of());
    }
}
