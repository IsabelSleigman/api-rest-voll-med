package med.voll.apirestvollmed.controller;

import med.voll.apirestvollmed.medico.DadosCadastroMedico;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    @PostMapping
    public String cadastrar(@RequestBody DadosCadastroMedico dados){

        System.out.println(dados);
        return "Cadastrado com sucesso!";
    }
}
