package br.com.github.lucasmlg1.cadastro_pets.repository;

import br.com.github.lucasmlg1.cadastro_pets.model.Adotante;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AdotanteRepository extends JpaRepository<Adotante, UUID> {
    boolean existsByEmail(String email);
}

