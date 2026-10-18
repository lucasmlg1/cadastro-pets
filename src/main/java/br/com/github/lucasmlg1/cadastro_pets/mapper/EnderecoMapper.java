package br.com.github.lucasmlg1.cadastro_pets.mapper;

import br.com.github.lucasmlg1.cadastro_pets.dto.EnderecoDTO;
import br.com.github.lucasmlg1.cadastro_pets.dto.EnderecoResponseDTO;
import br.com.github.lucasmlg1.cadastro_pets.dto.ViaCepResponse;
import br.com.github.lucasmlg1.cadastro_pets.model.Endereco;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class EnderecoMapper {

    public Endereco toEntity(EnderecoDTO dto, ViaCepResponse via) {
        Endereco endereco = new Endereco();
        atualizarEntidade(endereco, dto, via);
        return endereco;
    }

    public void atualizarEntidade(Endereco endereco, EnderecoDTO dto, ViaCepResponse via) {
        endereco.setCep(dto.cep());
        endereco.setNumero(dto.numero());
        endereco.setLogradouro(Objects.requireNonNullElse(via.logradouro(), ""));
        endereco.setBairro(Objects.requireNonNullElse(via.bairro(), ""));
        endereco.setCidade(via.localidade());
        endereco.setUf(via.uf());
    }

    public EnderecoResponseDTO toResponse(Endereco endereco) {
        return new EnderecoResponseDTO(
                endereco.getCep(),
                endereco.getLogradouro(),
                endereco.getNumero(),
                endereco.getBairro(),
                endereco.getCidade(),
                endereco.getUf());
    }
}