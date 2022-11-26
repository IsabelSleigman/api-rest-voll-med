package med.voll.apirestvollmed.paciente;

import jakarta.validation.Valid;
import med.voll.apirestvollmed.endereco.DadosEndereco;

public record DadosAtualizacaoPaciente(
        String nome,
        String telefone,
        @Valid DadosEndereco endereco
) {
}
