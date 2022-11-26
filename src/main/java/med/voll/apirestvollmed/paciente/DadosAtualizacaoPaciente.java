package med.voll.apirestvollmed.paciente;

import jakarta.validation.Valid;
import med.voll.apirestvollmed.endereco.DadosEndereco;

public record DadosAtualizacaoPaciente(
        Long id,
        String nome,
        String telefone,
        @Valid DadosEndereco endereco
) {
}
