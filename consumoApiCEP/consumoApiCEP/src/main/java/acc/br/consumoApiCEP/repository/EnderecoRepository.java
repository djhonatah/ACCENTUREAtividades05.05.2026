package acc.br.consumoApiCEP.repository;

import acc.br.consumoApiCEP.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}
