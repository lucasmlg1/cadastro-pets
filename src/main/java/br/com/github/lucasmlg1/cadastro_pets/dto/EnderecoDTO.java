package br.com.github.lucasmlg1.cadastro_pets.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record EnderecoDTO(
        @NotBlank(message = "O CEP é obrigatório")
        @Pattern(regexp = "\\d{8}", message = "O CEP deve ter 8 dígitos, sem hífen")
        String cep,

        @NotBlank(message = "O número é obrigatório")
        @Size(max = 10, message = "O número deve ter no máximo 10 caracteres")
        String numero) {
}