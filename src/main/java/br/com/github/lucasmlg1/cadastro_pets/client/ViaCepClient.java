package br.com.github.lucasmlg1.cadastro_pets.client;

import br.com.github.lucasmlg1.cadastro_pets.dto.ViaCepResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
public interface ViaCepClient {

    @GetMapping("/{cep}/json/")
    ViaCepResponse buscarPorCep(@PathVariable("cep") String cep);
}