package br.com.github.lucasmlg1.cadastro_pets.mapper;

import br.com.github.lucasmlg1.cadastro_pets.dto.EnderecoDTO;
import br.com.github.lucasmlg1.cadastro_pets.dto.EnderecoResponseDTO;
import br.com.github.lucasmlg1.cadastro_pets.model.Endereco;
import org.springframework.stereotype.Component;

@Component
public class EnderecoMapper {

    public Endereco toEntity(EnderecoDTO dto) {
        Endereco endereco = new Endereco();
        atualizarEntidade(endereco, dto);
        return endereco;
    }

    public void atualizarEntidade(Endereco endereco, EnderecoDTO dto) {
        endereco.setCep(dto.cep());
        endereco.setLogradouro(dto.logradouro());
        endereco.setNumero(dto.numero());
        endereco.setBairro(dto.bairro());
        endereco.setCidade(dto.cidade());
        endereco.setUf(dto.uf().toUpperCase());
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