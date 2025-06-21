package com.jeanemirele.UBS.service;

import com.jeanemirele.UBS.domain.entity.Consulta;
import com.jeanemirele.UBS.domain.entity.Medico;
import com.jeanemirele.UBS.domain.entity.Paciente;
import com.jeanemirele.UBS.repositorys.ConsultaRepository;
import com.jeanemirele.UBS.repositorys.MedicoRepository;
import com.jeanemirele.UBS.repositorys.PacienteRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ConsultaService {

    private final ConsultaRepository consultaRepository;
    private final MedicoRepository medicoRepository;
    private final PacienteRepository pacienteRepository;

    public ConsultaService(ConsultaRepository consultaRepository, MedicoRepository medicoRepository, PacienteRepository pacienteRepository) {
        this.consultaRepository = consultaRepository;
        this.medicoRepository = medicoRepository;
        this.pacienteRepository = pacienteRepository;
    }

    public List<Consulta> findByMedico(long idMedico) {
        return consultaRepository.findByMedicoId(idMedico);
    }

    public Consulta agendarConsulta(long idMedico, long idPaciente, LocalDateTime data) {
      Medico medico = medicoRepository.findById(idMedico).orElseThrow(()->new RuntimeException("Medico não encontrado"));
      Paciente paciente = pacienteRepository.findById(idPaciente).orElseThrow(() -> new RuntimeException("Paciente não encontrado"));

      Consulta consulta = new Consulta();
      consulta.setMedico(medico);
      consulta.setPaciente(paciente);
      consulta.setData(data);
      consultaRepository.save(consulta);
      return consulta;
    }

    public void save (Consulta consulta) {
        consultaRepository.save(consulta);
    }

    public void delete(long id) {
        consultaRepository.deleteById(id);
    }

}
