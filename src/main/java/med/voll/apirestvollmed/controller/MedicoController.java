package med.voll.apirestvollmed.controller;

import jakarta.validation.Valid;
import med.voll.apirestvollmed.medico.DadosCadastroMedico;
import med.voll.apirestvollmed.medico.DadosListagemMedico;
import med.voll.apirestvollmed.medico.Medico;
import med.voll.apirestvollmed.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public List<DadosListagemMedico> listar(){
        return repository.findAll().stream().map(DadosListagemMedico::new).toList();
    }
}
