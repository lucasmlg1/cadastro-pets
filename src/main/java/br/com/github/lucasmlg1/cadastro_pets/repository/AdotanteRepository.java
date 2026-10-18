package br.com.github.lucasmlg1.cadastro_pets.repository;

import br.com.github.lucasmlg1.cadastro_pets.model.Adotante;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AdotanteRepository extends JpaRepository<Adotante, UUID> {
    boolean existsByEmail(String email);

    @Override
    @EntityGraph(attributePaths = "endereco")
    Page<Adotante> findAll(Pageable pageable);
}

