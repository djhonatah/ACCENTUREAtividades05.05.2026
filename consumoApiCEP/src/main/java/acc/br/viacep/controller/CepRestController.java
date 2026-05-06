package acc.br.viacep.controller;

import acc.br.viacep.service.ConsultaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cep")
public class CepRestController {

    @Autowired
    private ConsultaCepService cepService;

    @GetMapping("/cep")
    public String consultarCep(@RequestParam String cep) {

        cepService.consultarEPersistir(cep);

        return "redirect:/";
    }
}
