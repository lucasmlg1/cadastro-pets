package br.com.github.lucasmlg1.cadastro_pets.exception;

public class CepServicoIndisponivelException extends RuntimeException {
    public CepServicoIndisponivelException() {
        super("Serviço de consulta de CEP indisponível no momento");
    }
}