package br.com.github.lucasmlg1.cadastro_pets.dto;

public record ViaCepResponse(String cep, String logradouro, String bairro, String localidade, String uf, Boolean erro) { }
