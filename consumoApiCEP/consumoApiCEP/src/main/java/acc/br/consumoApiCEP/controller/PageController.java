package acc.br.consumoApiCEP.controller;

import acc.br.consumoApiCEP.service.CepService;
import acc.br.consumoApiCEP.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @Autowired
    private CepService cepService;

    @Autowired
    private EnderecoRepository repository;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("enderecos", repository.findAll());
        return "index";
    }


    @GetMapping("/cep")
    public String buscarCep(String cep, Model model) {

        try {
            cepService.buscarESalvar(cep);
        } catch (Exception e) {
            model.addAttribute("erro", e.getMessage());
        }

        model.addAttribute("enderecos", repository.findAll());

        return "index";
    }
}
