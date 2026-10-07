package br.com.github.lucasmlg1.cadastro_pets.mapper;


import br.com.github.lucasmlg1.cadastro_pets.dto.PetRequestDTO;
import br.com.github.lucasmlg1.cadastro_pets.dto.PetResponseDTO;
import br.com.github.lucasmlg1.cadastro_pets.model.Pet;
import org.springframework.stereotype.Component;

@Component
public class PetMapper {
     public Pet toEntity(PetRequestDTO dto){
        Pet pet = new Pet();
        pet.setIdade(dto.idade());
        pet.setNome(dto.nome());
        pet.setPeso(dto.peso());
        pet.setRaca(dto.raca());
        pet.setSexoPet(dto.sexoPet());
        pet.setTipoPet(dto.tipoPet());
        return pet;
    }

     public PetResponseDTO toResponse(Pet pet){
        return new PetResponseDTO(pet.getId(), pet.getNome(),
                pet.getTipoPet(),
                pet.getSexoPet(),
                pet.getPeso(),
                pet.getRaca(),
                pet.getIdade(),
                pet.getDataCadastro());
    }
}
