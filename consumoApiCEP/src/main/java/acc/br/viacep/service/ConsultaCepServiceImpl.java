package acc.br.viacep.service;

import acc.br.viacep.model.Endereco;
import acc.br.viacep.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ConsultaCepServiceImpl implements ConsultaCepService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Override
    public Endereco consultarEPersistir(String codigoCep) {

        if (codigoCep == null || !codigoCep.matches("\\d{8}")) {
            throw new RuntimeException("CEP inválido! Digite 8 números (apenas números).");
        }

        String urlConsulta = "https://viacep.com.br/ws/" + codigoCep + "/json/";

        RestTemplate clienteHttp = new RestTemplate();

        try {
            Endereco enderecoObtido = clienteHttp.getForObject(urlConsulta, Endereco.class);

            if (enderecoObtido == null || enderecoObtido.getCep() == null) {
                throw new RuntimeException("CEP não encontrado!");
            }

            return enderecoRepository.save(enderecoObtido);

        } catch (Exception ex) {
            throw new RuntimeException("Erro ao buscar CEP!");
        }
    }
}
