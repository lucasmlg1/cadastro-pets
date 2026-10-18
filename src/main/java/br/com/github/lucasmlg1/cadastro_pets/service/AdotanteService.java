package br.com.github.lucasmlg1.cadastro_pets.service;

import br.com.github.lucasmlg1.cadastro_pets.dto.AdotanteCadastroDTO;
import br.com.github.lucasmlg1.cadastro_pets.dto.AdotanteResponseDTO;
import br.com.github.lucasmlg1.cadastro_pets.dto.ViaCepResponse;
import br.com.github.lucasmlg1.cadastro_pets.exception.*;
import br.com.github.lucasmlg1.cadastro_pets.mapper.AdotanteMapper;
import br.com.github.lucasmlg1.cadastro_pets.model.Adotante;
import br.com.github.lucasmlg1.cadastro_pets.repository.AdotanteRepository;
import br.com.github.lucasmlg1.cadastro_pets.repository.PetRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AdotanteService {

    private final AdotanteRepository repository;
    private final AdotanteMapper mapper;
    private final PetRepository petRepository;
    private final CepService cepService;

    @Transactional
    public void deletar(UUID id){
        Adotante adotante = buscarOuFalhar(id);
        if (petRepository.existsByAdotanteId(id)){
            throw new AdotanteComPetsException(id);
        }
        repository.delete(adotante);
    }

    @Transactional(readOnly = true)
    public Page<AdotanteResponseDTO> listar(Pageable pageable) {
        return repository.findAll(pageable).map(mapper::toResponse);
    }

    @Transactional
    public AdotanteResponseDTO atualizar(UUID id, AdotanteCadastroDTO dto) {
        Adotante adotante = buscarOuFalhar(id);
        String novoEmail = normalizar(dto.email());
        if (!novoEmail.equals(adotante.getEmail()) && repository.existsByEmail(novoEmail)) {
            throw new EmailJaCadastradoException(novoEmail);
        }
        ViaCepResponse via = cepService.consultar(dto.endereco().cep());
        mapper.atualizarEntidade(adotante, dto, via);
        adotante.setEmail(novoEmail);
        return mapper.toResponse(adotante);
    }

    @Transactional(readOnly = true)
    public AdotanteResponseDTO getAdotante(UUID id){
        Adotante adotante = buscarOuFalhar(id);
        return mapper.toResponse(adotante);
    }

    private String normalizar(String email) {
        return email.trim().toLowerCase();
    }

    @Transactional
    public AdotanteResponseDTO cadastrar(AdotanteCadastroDTO dto) {
        String email = normalizar(dto.email());
        if (repository.existsByEmail(email)) {
            throw new EmailJaCadastradoException(email);
        }
        ViaCepResponse via = cepService.consultar(dto.endereco().cep());
        Adotante adotante = mapper.toEntity(dto, via);
        adotante.setEmail(email);
        return mapper.toResponse(repository.saveAndFlush(adotante));
    }

    private Adotante buscarOuFalhar(UUID id) {
        return repository.findById(id).orElseThrow(() -> new AdotanteNaoEncontradoException(id));
    }



}
