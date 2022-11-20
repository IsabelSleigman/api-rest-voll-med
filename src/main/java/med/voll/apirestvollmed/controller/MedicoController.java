package med.voll.apirestvollmed.controller;

import jakarta.validation.Valid;
import med.voll.apirestvollmed.medico.DadosCadastroMedico;
import med.voll.apirestvollmed.medico.Medico;
import med.voll.apirestvollmed.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @Transactional
    public String cadastrar(@RequestBody @Valid DadosCadastroMedico dados){
        repository.save(new Medico(dados));
        return "Cadastrado com sucesso!";
    }
}
