package acc.br.viacep.controller;

import acc.br.viacep.service.ConsultaCepService;
import acc.br.viacep.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ConsultaViewController {

    @Autowired
    private ConsultaCepService servicoCep;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @GetMapping("/")
    public String exibirPaginaInicial(Model modelo) {
        modelo.addAttribute("enderecos", enderecoRepository.findAll());
        return "index";
    }


    @GetMapping("/cep")
    public String processarConsultaCep(String cep, Model modelo) {

        try {
            servicoCep.consultarEPersistir(cep);
        } catch (Exception ex) {
            modelo.addAttribute("erro", ex.getMessage());
        }

        modelo.addAttribute("enderecos", enderecoRepository.findAll());

        return "index";
    }
}
