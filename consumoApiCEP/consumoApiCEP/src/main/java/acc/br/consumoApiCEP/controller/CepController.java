package acc.br.consumoApiCEP.controller;

import acc.br.consumoApiCEP.service.CepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cep")
public class CepController {

    @Autowired
    private CepService service;

    @GetMapping("/cep")
    public String buscarCep(@RequestParam String cep) {

        service.buscarESalvar(cep);

        return "redirect:/";
    }
}
