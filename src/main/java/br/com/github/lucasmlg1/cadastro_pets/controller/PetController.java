package br.com.github.lucasmlg1.cadastro_pets.controller;


import br.com.github.lucasmlg1.cadastro_pets.dto.PetFiltroDTO;
import br.com.github.lucasmlg1.cadastro_pets.dto.PetRequestDTO;
import br.com.github.lucasmlg1.cadastro_pets.dto.PetResponseDTO;
import br.com.github.lucasmlg1.cadastro_pets.service.PetService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RestController
@RequestMapping("/api/pets")
@RequiredArgsConstructor

public class PetController {

    private final PetService service;

    @PostMapping
    public ResponseEntity<PetResponseDTO> salvarPet(@RequestBody @Valid PetRequestDTO petRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.cadastrarPet(petRequestDTO));
    }

    @GetMapping("/busca")
    public ResponseEntity<Page<PetResponseDTO>> listar(
            PetFiltroDTO filtro,
            @PageableDefault(size = 10, sort = "nome") Pageable pageable) {
        return ResponseEntity.ok(service.listar(filtro, pageable));
    }

    @PutMapping("/{id}/adotante/{adotanteId}")
    public ResponseEntity<PetResponseDTO> adotar(@PathVariable UUID id, @PathVariable UUID adotanteId) {
        return ResponseEntity.ok(service.adotar(id, adotanteId));
    }


    @GetMapping("/{id}")
    public ResponseEntity<PetResponseDTO> obterDetalhes(@PathVariable UUID id) {
        return ResponseEntity.ok(service.obterPetPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PetResponseDTO> alterar(@PathVariable UUID id,
                                                  @RequestBody @Valid PetRequestDTO dto) {
        return ResponseEntity.ok(service.alterar(id, dto));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCadastroPet(@PathVariable UUID id){
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
