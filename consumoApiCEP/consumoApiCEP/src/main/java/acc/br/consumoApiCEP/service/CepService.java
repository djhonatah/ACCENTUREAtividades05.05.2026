package acc.br.consumoApiCEP.service;

import acc.br.consumoApiCEP.model.Endereco;

public interface CepService {
    Endereco buscarESalvar(String cep);
}
