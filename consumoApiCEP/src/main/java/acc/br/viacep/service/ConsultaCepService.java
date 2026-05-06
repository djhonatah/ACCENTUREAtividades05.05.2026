package acc.br.viacep.service;

import acc.br.viacep.model.Endereco;

public interface ConsultaCepService {
    Endereco consultarEPersistir(String codigoCep);
}
