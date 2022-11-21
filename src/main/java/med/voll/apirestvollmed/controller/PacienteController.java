package med.voll.apirestvollmed.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.apirestvollmed.paciente.DadosCadastroPaciente;
import med.voll.apirestvollmed.paciente.Paciente;
import med.voll.apirestvollmed.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
