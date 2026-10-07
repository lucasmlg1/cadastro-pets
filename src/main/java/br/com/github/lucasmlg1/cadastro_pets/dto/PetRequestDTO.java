package br.com.github.lucasmlg1.cadastro_pets.dto;

import br.com.github.lucasmlg1.cadastro_pets.model.SexoPet;
import br.com.github.lucasmlg1.cadastro_pets.model.TipoPet;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public record PetRequestDTO(@NotBlank @Pattern(regexp = "^[\\p{L}\\s]+$", message = "O campo deve conter apenas letras e espaços, sem caracteres especiais.")
                            String nome,
                            @NotNull(message = "O tipo do Pet é obrigatório!") TipoPet tipoPet,
                            @NotNull(message = "O sexo do Pet é obrigatório!") SexoPet sexoPet,
                            @DecimalMin(value = "0.5", message = "O mínimo do peso é de 0.5kg!") @DecimalMax(value = "60", message = "O máximo do peso é de 60kg!") @NotNull BigDecimal peso,
                            @NotBlank(message = "Campo de raça é obrigatório! ") @Pattern(regexp = "^[\\p{L}\\s-]+$", message = "O campo deve conter apenas letras e espaços, sem caracteres especiais.")
                            String raca,
                            @DecimalMin("0") @DecimalMax(value = "20", message = "A idade máxima é de 20 anos!")
                            @NotNull(message = "Idade não foi informada.") Double idade) {
}
