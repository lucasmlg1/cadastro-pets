package br.com.github.lucasmlg1.cadastro_pets.dto;

public record EnderecoResponseDTO(String cep, String logradouro, String numero,
                                  String bairro, String cidade, String uf) {}