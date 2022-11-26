package med.voll.apirestvollmed.paciente;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.nio.channels.FileChannel;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    DadosPaciente findPacienteById(Long id);

    Page<Paciente> findAllByAtivoTrue(Pageable paginacao);
}
