package br.com.github.lucasmlg1.cadastro_pets.dto;


import java.time.LocalDateTime;
import java.util.UUID;

public record AdotanteResponseDTO(UUID id, String nome, String email, String telefone,
                                  EnderecoResponseDTO endereco, LocalDateTime dataCadastro) {}