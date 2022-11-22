package med.voll.apirestvollmed.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.apirestvollmed.paciente.DadosCadastroPaciente;
import med.voll.apirestvollmed.paciente.DadosListagemPaciente;
import med.voll.apirestvollmed.paciente.Paciente;
import med.voll.apirestvollmed.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("pacientes")
public class PacienteController {
    @Autowired
    private PacienteRepository repository;

    @PostMapping
    @Transactional
    public String cadastrar(@RequestBody @Valid DadosCadastroPaciente dados) {
        repository.save(new Paciente(dados));
        return "Cadastrado com sucesso!";
    }
    @GetMapping
    public Page<DadosListagemPaciente> listar(@PageableDefault(page = 0, size = 10, sort = {"nome"}) Pageable paginacao ){
        return repository.findAll(paginacao).map(DadosListagemPaciente::new);
    }
}
