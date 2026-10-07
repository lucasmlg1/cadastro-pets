package br.com.github.lucasmlg1.cadastro_pets.controller;


import br.com.github.lucasmlg1.cadastro_pets.dto.PetRequestDTO;
import br.com.github.lucasmlg1.cadastro_pets.dto.PetResponseDTO;
import br.com.github.lucasmlg1.cadastro_pets.service.PetService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("api/pets")
@AllArgsConstructor

public class PetController {

    private final PetService service;

    @PostMapping
    public ResponseEntity<PetResponseDTO> salvarPet(@RequestBody @Valid PetRequestDTO petRequestDTO) {
       PetResponseDTO petResponseDTO = service.cadastrarPet(petRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(petResponseDTO);
    }
}
