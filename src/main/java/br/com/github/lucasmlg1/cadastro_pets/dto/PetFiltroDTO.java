package br.com.github.lucasmlg1.cadastro_pets.dto;

import br.com.github.lucasmlg1.cadastro_pets.model.SexoPet;
import br.com.github.lucasmlg1.cadastro_pets.model.TipoPet;

import java.math.BigDecimal;

public record PetFiltroDTO( String nome,
                            String raca,
                            TipoPet tipoPet,
                            SexoPet sexoPet,
                            Double idade,
                            BigDecimal peso
) {}