package med.voll.apirestvollmed.paciente;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    DadosPaciente findPacienteById(Long id);
}
