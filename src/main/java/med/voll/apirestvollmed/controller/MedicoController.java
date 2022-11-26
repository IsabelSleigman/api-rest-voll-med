package med.voll.apirestvollmed.controller;

import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import med.voll.apirestvollmed.medico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;


@RestController
@RequestMapping("medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    public MedicoController(MedicoRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public Page<DadosListagemMedico> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){
        return repository.findAllByAtivoTrue(paginacao).map(DadosListagemMedico::new);
    }
    @GetMapping("/{id}")
    public DadosMedico buscaPorId(@PathVariable Long id){
        return repository.findMedicoById(id);
    }
    @PostMapping
    @Transactional
    public String cadastrar(@RequestBody @Valid DadosCadastroMedico dados){
        repository.save(new Medico(dados));
        return "Cadastrado com sucesso!";
    }

    @PutMapping("/{id}")
    @Transactional
    public String atualizar(@PathVariable Long id, @RequestBody @Valid DadosAtualizacaoMedico dados){

        var medico = repository.getReferenceById(id);
        medico.atualizarInformacoes(dados);
        return "Atualizado com sucesso!";

    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){
        var medico = repository.getReferenceById(id);
        medico.desativar();
    }
}
