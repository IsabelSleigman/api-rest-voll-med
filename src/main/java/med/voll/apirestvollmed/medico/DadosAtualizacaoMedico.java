package med.voll.apirestvollmed.medico;

import jakarta.validation.constraints.NotNull;
import med.voll.apirestvollmed.endereco.DadosEndereco;

public record DadosAtualizacaoMedico(
        String nome,
        String telefone,
        DadosEndereco endereco) {
}
