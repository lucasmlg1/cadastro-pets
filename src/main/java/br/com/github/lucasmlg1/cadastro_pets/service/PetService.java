package br.com.github.lucasmlg1.cadastro_pets.service;

import br.com.github.lucasmlg1.cadastro_pets.dto.PetFiltroDTO;
import br.com.github.lucasmlg1.cadastro_pets.dto.PetRequestDTO;
import br.com.github.lucasmlg1.cadastro_pets.dto.PetResponseDTO;
import br.com.github.lucasmlg1.cadastro_pets.exception.AdotanteNaoEncontradoException;
import br.com.github.lucasmlg1.cadastro_pets.exception.PetJaAdotadoException;
import br.com.github.lucasmlg1.cadastro_pets.exception.PetNaoEncontradoException;
import br.com.github.lucasmlg1.cadastro_pets.mapper.PetMapper;
import br.com.github.lucasmlg1.cadastro_pets.model.Adotante;
import br.com.github.lucasmlg1.cadastro_pets.model.Pet;
import br.com.github.lucasmlg1.cadastro_pets.repository.AdotanteRepository;
import br.com.github.lucasmlg1.cadastro_pets.repository.PetRepository;
import br.com.github.lucasmlg1.cadastro_pets.repository.specification.PetSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PetService {

    private final PetMapper mapper;
    private final PetRepository repository;
    private final AdotanteRepository adotanteRepository;



    @Transactional
    public PetResponseDTO adotar(UUID petId, UUID adotanteId) {
        Pet pet = buscarOuFalhar(petId);
        if (pet.getAdotante() != null) {
            throw new PetJaAdotadoException(petId);
        }
        Adotante adotante = adotanteRepository.findById(adotanteId)
                .orElseThrow(() -> new AdotanteNaoEncontradoException(adotanteId));
        pet.setAdotante(adotante);
        return mapper.toResponse(pet);
    }

    @Transactional(readOnly = true)
    public Page<PetResponseDTO> listar(PetFiltroDTO f, Pageable pageable) {
        return repository.findAll(PetSpecification.comFiltros(f), pageable)
                .map(mapper::toResponse);
    }

    @Transactional
    public PetResponseDTO cadastrarPet(PetRequestDTO dto){
        Pet entitys = mapper.toEntity(dto);
        Pet save = repository.saveAndFlush(entitys);
        return mapper.toResponse(save);
    }

    @Transactional(readOnly = true)
    public PetResponseDTO obterPetPorId(UUID id){
        return mapper.toResponse(buscarOuFalhar(id));
    }

    @Transactional
    public PetResponseDTO alterar(UUID id, PetRequestDTO dto){
        Pet pet = buscarOuFalhar(id);
        mapper.atualizarEntidade(pet, dto);
        return mapper.toResponse(pet);
    }

    @Transactional
    public void deletar(UUID id) {
        if (!repository.existsById(id)) {
            throw new PetNaoEncontradoException(id);
        }
        repository.deleteById(id);
    }


    private Pet buscarOuFalhar(UUID id){
        return repository.findById(id).orElseThrow(() -> new PetNaoEncontradoException(id));
    }

}
