package acc.br.viacep.model;

import jakarta.persistence.*;

@Entity
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cep;
    private String logradouro;
    private String bairro;
    private String localidade;
    private String uf;

    public Endereco() {}

    public Long getId() { return id; }

    public String getCep() { return cep; }
    public void setCep(String novoCep) { this.cep = novoCep; }

    public String getLogradouro() { return logradouro; }
    public void setLogradouro(String novoLogradouro) { this.logradouro = novoLogradouro; }

    public String getBairro() { return bairro; }
    public void setBairro(String novoBairro) { this.bairro = novoBairro; }

    public String getLocalidade() { return localidade; }
    public void setLocalidade(String novaLocalidade) { this.localidade = novaLocalidade; }

    public String getUf() { return uf; }
    public void setUf(String novaUf) { this.uf = novaUf; }
}