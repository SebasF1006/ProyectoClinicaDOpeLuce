package dao;

import DTO.CitaDoctorDTO;
import DTO.CitaPacienteDTO;
import entidades.Cita;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface DaoCita {
    List <Cita> citaSel();
    Cita citaGet(Integer id);
    List <Cita> citaPacienteSel(Integer id);
    List <CitaPacienteDTO> citaPacienteDTOSel(Integer id);
    List <Cita> citaDoctorSel(Integer id);
    List <CitaDoctorDTO> citaDoctorDTOSel(Integer id);
    String citaIns(Cita cita);
    List <Integer> idsDoctor(String tipo_cita,LocalTime hora, LocalDate fecha);
    List <Integer> idsNoDoctor(String tipo_cita,LocalTime hora, LocalDate fecha);
    List <Integer> idsDoctorS(String tipo_cita);
    String getMessage();
}
