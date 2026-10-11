package br.com.github.lucasmlg1.cadastro_pets.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record EnderecoDTO(
        @NotBlank @Pattern(regexp = "\\d{8}", message = "O CEP deve ter 8 dígitos, sem hífen") String cep,
        @NotBlank @Size(max = 100) String logradouro,
        @NotBlank @Size(max = 10) String numero,
        @NotBlank @Size(max = 60) String bairro,
        @NotBlank @Size(max = 60) String cidade,
        @NotBlank @Pattern(regexp = "[A-Za-z]{2}", message = "A UF deve ter 2 letras") String uf) {
}