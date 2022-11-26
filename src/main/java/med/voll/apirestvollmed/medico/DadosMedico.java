package med.voll.apirestvollmed.medico;

public record DadosMedico(String nome, String email, String crm, EspecialidadeEnum especialidade, String telefone, Boolean ativo) {

    public DadosMedico(Medico medico){
        this(medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade(), medico.getTelefone(), medico.getAtivo());
    }
}
