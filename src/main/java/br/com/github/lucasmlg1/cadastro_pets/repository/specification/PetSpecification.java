package br.com.github.lucasmlg1.cadastro_pets.repository.specification;

import br.com.github.lucasmlg1.cadastro_pets.dto.PetFiltroDTO;
import br.com.github.lucasmlg1.cadastro_pets.model.Pet;
import br.com.github.lucasmlg1.cadastro_pets.model.SexoPet;
import br.com.github.lucasmlg1.cadastro_pets.model.TipoPet;
import org.springframework.data.jpa.domain.Specification;

import java.math.BigDecimal;

public class PetSpecification {


    private PetSpecification()
    {}

    public static Specification<Pet> comFiltros(PetFiltroDTO f) {
        return Specification
                .where(nomeContem(f.nome()))
                .and(racaContem(f.raca()))
                .and(tipoIgual(f.tipoPet()))
                .and(sexoIgual(f.sexoPet()))
                .and(idadeIgual(f.idade()))
                .and(pesoIgual(f.peso()));
    }

    private static Specification<Pet> nomeContem(String nome) {
        return (root, query, cb) -> (nome == null || nome.isBlank())
                ? null
                : cb.like(cb.lower(root.get("nome")), "%" + nome.trim().toLowerCase() + "%");
    }

    private static Specification<Pet> racaContem(String raca) {
        return (root, query, cb) -> (raca == null || raca.isBlank())
                ? null
                : cb.like(cb.lower(root.get("raca")), "%" + raca.trim().toLowerCase() + "%");
    }

    private static Specification<Pet> tipoIgual(TipoPet tipo) {
        return (root, query, cb) -> tipo == null ? null : cb.equal(root.get("tipoPet"), tipo);
    }

    private static Specification<Pet> sexoIgual(SexoPet sexo) {
        return (root, query, cb) -> sexo == null ? null : cb.equal(root.get("sexoPet"), sexo);
    }


    private static Specification<Pet> idadeIgual(Double idade) {
        return (root, query, cb) -> idade == null ? null : cb.equal(root.get("idade"), idade);
    }

    private static Specification<Pet> pesoIgual(BigDecimal peso) {
        return (root, query, cb) -> peso == null ? null : cb.equal(root.get("peso"), peso);
    }


 }
