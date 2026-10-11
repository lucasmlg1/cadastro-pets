package br.com.github.lucasmlg1.cadastro_pets.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record AdotanteCadastroDTO(
        @NotBlank(message = "O nome é obrigatório") @Size(max = 80) String nome,
        @NotBlank(message = "O email é obrigatório") @Email @Size(max = 100) String email,
        @NotBlank(message = "O telefone é obrigatório") @Size(max = 15) String telefone,
        @NotNull(message = "O endereço é obrigatório") @Valid EnderecoDTO endereco) {
}
