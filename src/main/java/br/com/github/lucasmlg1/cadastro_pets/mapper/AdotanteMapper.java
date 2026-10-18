package br.com.github.lucasmlg1.cadastro_pets.mapper;

import br.com.github.lucasmlg1.cadastro_pets.dto.AdotanteCadastroDTO;
import br.com.github.lucasmlg1.cadastro_pets.dto.AdotanteResponseDTO;
import br.com.github.lucasmlg1.cadastro_pets.dto.ViaCepResponse;
import br.com.github.lucasmlg1.cadastro_pets.model.Adotante;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class AdotanteMapper {

    private final EnderecoMapper enderecoMapper;

    public Adotante toEntity(AdotanteCadastroDTO dto, ViaCepResponse via) {
        Adotante adotante = new Adotante();
        adotante.setNome(dto.nome());
        adotante.setEmail(dto.email());
        adotante.setTelefone(dto.telefone());
        adotante.setEndereco(enderecoMapper.toEntity(dto.endereco(), via));
        return adotante;
    }

    public void atualizarEntidade(Adotante adotante, AdotanteCadastroDTO dto, ViaCepResponse via) {
        adotante.setNome(dto.nome());
        adotante.setEmail(dto.email());
        adotante.setTelefone(dto.telefone());
        enderecoMapper.atualizarEntidade(adotante.getEndereco(), dto.endereco(), via);
    }

    public AdotanteResponseDTO toResponse(Adotante adotante) {
        return new AdotanteResponseDTO(
                adotante.getId(),
                adotante.getNome(),
                adotante.getEmail(),
                adotante.getTelefone(),
                enderecoMapper.toResponse(adotante.getEndereco()),
                adotante.getDataCadastro());
    }

}
