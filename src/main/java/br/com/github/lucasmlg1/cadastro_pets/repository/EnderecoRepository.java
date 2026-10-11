package br.com.github.lucasmlg1.cadastro_pets.repository;

import br.com.github.lucasmlg1.cadastro_pets.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EnderecoRepository extends JpaRepository<Endereco, UUID> {

}
