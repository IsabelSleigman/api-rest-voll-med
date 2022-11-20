package med.voll.apirestvollmed.medico;

import med.voll.apirestvollmed.endereco.DadosEndereco;

public record DadosCadastroMedico(String nome, String email, String crm, EspecialidadeEnum especialidade, DadosEndereco endereco) {
}
