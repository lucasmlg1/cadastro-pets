package br.com.github.lucasmlg1.cadastro_pets.service;

import br.com.github.lucasmlg1.cadastro_pets.client.ViaCepClient;
import br.com.github.lucasmlg1.cadastro_pets.dto.ViaCepResponse;
import br.com.github.lucasmlg1.cadastro_pets.exception.CepNaoEncontradoException;
import br.com.github.lucasmlg1.cadastro_pets.exception.CepServicoIndisponivelException;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CepService {

    private final ViaCepClient client;

    public ViaCepResponse consultar(String cep) {
        ViaCepResponse resposta;
        try {
            resposta = client.buscarPorCep(cep);
        } catch (FeignException e) {
            log.error("Falha ao consultar o ViaCEP para o CEP {}", cep, e);
            throw new CepServicoIndisponivelException();
        }
        if (resposta == null || Boolean.TRUE.equals(resposta.erro())) {
            throw new CepNaoEncontradoException(cep);
        }
        return resposta;
    }
}