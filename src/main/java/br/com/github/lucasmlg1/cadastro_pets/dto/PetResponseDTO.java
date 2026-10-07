package br.com.github.lucasmlg1.cadastro_pets.dto;

import br.com.github.lucasmlg1.cadastro_pets.model.SexoPet;
import br.com.github.lucasmlg1.cadastro_pets.model.TipoPet;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record PetResponseDTO(
        UUID id,
         String nome,
        TipoPet tipoPet,
        SexoPet sexoPet,
        BigDecimal peso,
        String raca,
        Double idade,
        LocalDateTime dataCadastro ) {
}
