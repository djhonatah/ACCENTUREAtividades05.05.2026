package com.accenture.consumo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.consumo.interfaces.CepService;
import com.accenture.consumo.interfaces.EnderecoRepository;
import com.accenture.consumo.model.Endereco;

@RestController
@CrossOrigin(origins = "*")
public class CepRestController {

	private final CepService cepService;
	private final EnderecoRepository enderecoRepository;

	public CepRestController(CepService cepService, EnderecoRepository enderecoRepository) {
		this.cepService = cepService;
		this.enderecoRepository = enderecoRepository;
	}

	@GetMapping("/api/{cep}")
	public ResponseEntity<Endereco> buscarCep(@PathVariable String cep) {
		Endereco endereco = cepService.buscaEnderecoPorCep(cep);

		if (endereco != null && endereco.getCep() != null) {
			enderecoRepository.save(endereco);
			return ResponseEntity.ok(endereco);
		}

		return ResponseEntity.notFound().build();
	}

}
