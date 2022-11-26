package med.voll.apirestvollmed.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.apirestvollmed.paciente.*;
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

    @GetMapping
    public Page<DadosListagemPaciente> listar(@PageableDefault(page = 0, size = 10, sort = {"nome"}) Pageable paginacao ){
        return repository.findAllByAtivoTrue(paginacao).map(DadosListagemPaciente::new);
    }
    @GetMapping("/{id}")
    public DadosPaciente buscarPorId(@PathVariable Long id ){
        return repository.findPacienteById(id);
    }
    @PostMapping
    @Transactional
    public String cadastrar(@RequestBody @Valid DadosCadastroPaciente dados) {
        repository.save(new Paciente(dados));
        return "Cadastrado com sucesso!";
    }
    @PutMapping("/{id}")
    @Transactional
    public String atualizar(@PathVariable Long id,@RequestBody @Valid DadosAtualizacaoPaciente dados) {
        var paciente = repository.getReferenceById(id);
        paciente.atualizarInformacoes(dados);
        return "Atualizado com sucesso!";
    }
    @DeleteMapping("/{id}")
    @Transactional
    public void remover(@PathVariable Long id) {
        var paciente = repository.getReferenceById(id);
        paciente.inativar();
    }
}
