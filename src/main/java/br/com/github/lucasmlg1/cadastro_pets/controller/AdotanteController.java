package br.com.github.lucasmlg1.cadastro_pets.controller;

import br.com.github.lucasmlg1.cadastro_pets.dto.AdotanteCadastroDTO;
import br.com.github.lucasmlg1.cadastro_pets.dto.AdotanteResponseDTO;
import br.com.github.lucasmlg1.cadastro_pets.service.AdotanteService;
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
@RequiredArgsConstructor
@RequestMapping("/api/adotantes")
public class AdotanteController {

    private final AdotanteService service;

    @PostMapping()
    public ResponseEntity<AdotanteResponseDTO> cadastrar(@RequestBody @Valid AdotanteCadastroDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.cadastrar(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AdotanteResponseDTO> atualizar(@PathVariable UUID id, @RequestBody @Valid AdotanteCadastroDTO dto ){
        return ResponseEntity.ok().body(service.atualizar(id, dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdotanteResponseDTO> getAdotante(@PathVariable UUID id){
        return ResponseEntity.ok(service.getAdotante(id));
    }

    @GetMapping
    public ResponseEntity<Page<AdotanteResponseDTO>> listar(
            @PageableDefault(size = 10, sort = "nome") Pageable pageable) {
        return ResponseEntity.ok(service.listar(pageable));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAdotante(@PathVariable UUID id){
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }


}
