package med.voll.apirestvollmed.paciente;

public record DadosPaciente(String nome, String email,String telefone, String cpf) {
    public DadosPaciente(Paciente paciente) {
        this(paciente.getNome(), paciente.getEmail(), paciente.getTelefone(), paciente.getCpf());
    }
}