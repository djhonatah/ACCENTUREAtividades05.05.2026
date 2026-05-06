package com.accenture.consumo.interfaces;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.accenture.consumo.model.Endereco;

@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
public interface CepService {

    @GetMapping("/{cep}/json/")
    Endereco buscaEnderecoPorCep(@PathVariable("cep") String cep);
}
