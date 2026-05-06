package acc.br.consumoApiCEP.service;

import acc.br.consumoApiCEP.model.Endereco;
import acc.br.consumoApiCEP.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CepServiceImpl implements CepService {

    @Autowired
    private EnderecoRepository repository;

    @Override
    public Endereco buscarESalvar(String cep) {

        if (cep == null || !cep.matches("\\d{8}")) {
            throw new RuntimeException("CEP inválido! Digite 8 números (apenas números).");
        }

        String url = "https://viacep.com.br/ws/" + cep + "/json/";

        RestTemplate restTemplate = new RestTemplate();

        try {
            Endereco endereco = restTemplate.getForObject(url, Endereco.class);

            if (endereco == null || endereco.getCep() == null) {
                throw new RuntimeException("CEP não encontrado!");
            }

            return repository.save(endereco);

        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar CEP!");
        }
    }
}
