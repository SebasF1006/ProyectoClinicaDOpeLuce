package dao;

import DTO.CitaPacienteDTO;
import entidades.Paciente;
import java.util.List;

public interface DaoPaciente {
    List<Paciente> pacienteSel();
    Paciente pacienteGet(Integer id);
    String pacienteIns(Paciente paciente);
    String pacienteUpd(Paciente paciente);
    String pacienteDel(List<Integer> ids);
    Boolean pacienteLogin(String correo, String pass);
    Paciente pacienteGetLogin(String correo, String pass);
    String getMessage();
}
