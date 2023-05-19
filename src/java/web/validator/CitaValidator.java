package web.validator;

import DTO.CitaPacienteDTO;
import dao.DaoCita;
import dao.DaoPaciente;
import dao.impl.DaoCitaImpl;
import dao.impl.DaoPacienteImpl;
import entidades.Cita;
import entidades.Paciente;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeParseException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import util.DeString;
import java.util.ArrayList;

public class CitaValidator {

    private final HttpServletRequest request;
    private final DaoCita daoCita;
    private final DaoPaciente daoPaciente;
    public Integer idPac=0;

    public CitaValidator(HttpServletRequest request) {
        this.request = request;
        this.daoCita = new DaoCitaImpl();
        this.daoPaciente = new DaoPacienteImpl();
    }

    public String citaSel() {
        String result = null;
        List<Cita> list = daoCita.citaSel();
        if (list != null) {
            request.setAttribute("list", list);
        } else {
            result = daoCita.getMessage();
        }
        return result;
    }

    public String citaGet() {
        String result = null;
        Integer id = DeString.aInteger(request.getParameter("id"));
        Cita cita = daoCita.citaGet(id);
        if (cita != null) {
            request.setAttribute("cita", cita);
        } else {
            result = daoCita.getMessage();
        }
        return result;
    }

    public String citaGet2() {
        String result = null;
        Integer id = DeString.aInteger(request.getParameter("id"));
        Paciente paciente = daoPaciente.pacienteGet(id);
        List<CitaPacienteDTO> list = daoCita.citaPacienteDTOSel(paciente.getIdpacientes());
        if (id != null) {
            request.setAttribute("id", id);
            request.setAttribute("idPaciente", paciente.getIdpacientes());
            request.setAttribute("NombrePaciente", paciente.getNombres_paciente());
            request.setAttribute("ApellidosPaciente", paciente.getApellidos_paciente());
            request.setAttribute("list", list);
            request.setAttribute("paciente", paciente);
        } else {
            result = daoCita.getMessage();
        }
        return result;
    }

    public String citaParameter() {
        String result = null;
        Integer idpacientes = DeString.aInteger(request.getParameter("idpacientes"));
        if (idpacientes != null) {
            request.setAttribute("idpacientes", idpacientes);
        } else {
            result = daoCita.getMessage();
        }
        return result;
    }

    public String citaInsUpd(boolean upd) {

        StringBuilder result = new StringBuilder("<ul>");
        Integer idcita = DeString.aInteger(request.getParameter("idcita"));
        Integer idpacientes = DeString.aInteger(request.getParameter("id"));
        String tipo_Cita = request.getParameter("tipo_cita").toString();
        Double costo = 90d;
        if (tipo_Cita.equalsIgnoreCase("Consulta General")) {
            costo = 70d;
        } else if (tipo_Cita.equalsIgnoreCase("Consulta Pediatrica")) {
            costo = 80d;
        } else {
            costo = 100d;
        }

        boolean seguir = true;
        Cita cita = new Cita();
        List<Integer> listaTD = null;
        List<Integer> listaND = null;
        List<Integer> listaAux = null;
        LocalDate fecha = LocalDate.now().plusDays(4);
        LocalTime hora = LocalTime.parse("08:00:00");
        LocalTime horaInicial = LocalTime.parse("08:00:00");
        LocalTime horaAlmuerzo = LocalTime.parse("13:00:00");
        LocalTime horaFinal = LocalTime.parse("22:00:00");
        Integer iddoctor = null;
        
        if (tipo_Cita == null || tipo_Cita.trim().length() == 0) {
            result.append("<li>INGRESE EL TIPO DE CITA</li>");
        }

        if (result.length() == 4) {

            String msg = null;
            while (seguir) {
                String dia = fecha.getDayOfWeek().toString();
                if (dia.equals("SUNDAY")) {
                    fecha = fecha.plusDays(1);
                }
                try {
                    listaND = daoCita.idsNoDoctor(tipo_Cita, hora, fecha);
                    listaTD = daoCita.idsDoctorS(tipo_Cita);
                    listaAux = new ArrayList();
                    Integer c = 0;
                    if (listaND.size() == 0) {
                        iddoctor = NumMenor(listaTD);
                    } else if (listaND.size() > 0) {
                        for (int i = 0; i < listaTD.size(); i++) {
                            for (int j = 0; j < listaND.size(); j++) {
                                if (listaTD.get(i) != listaND.get(j)) {
                                    c++;
                                }
                            }
                            if (c == listaND.size()) {
                                listaAux.add(listaTD.get(i));
                            }
                            c = 0;
                        }
                        iddoctor = NumMenor(listaAux);
                    } else if (listaND.size() == listaTD.size()) {
                        iddoctor = -1;
                    }

                    if (iddoctor != -1) {

                        cita.setIdpacientes(idpacientes);
                        cita.setIddoctor(iddoctor);
                        cita.setTipo_cita(tipo_Cita);
                        cita.setCosto_cita(costo);
                        cita.setHora_cita(hora);
                        cita.setFecha_cita(fecha);
                        try {
                            msg = daoCita.citaIns(cita);
                            System.out.println("CITA REGISTRADA");
                            seguir = false;
                        } catch (Exception e) {
                            daoCita.getMessage();
                        }

                    } else {
                        hora = hora.plusHours(1);
                        if (hora == horaAlmuerzo) {
                            hora = hora.plusHours(1);
                        } else if (hora == horaFinal) {
                            hora = horaInicial;
                            fecha = fecha.plusDays(1);
                        }
                    }
                } catch (Exception e) {
                    daoCita.getMessage();
                }

            }
            //String msg = daoCita.citaIns(cita);
            /*String msg = upd
                    ? daoCita.citaUpd(cita)
                    : daoCita.citaIns(cita);*/

            /*request.setAttribute("id", idpacientes);
            request.setAttribute("idPaciente", paciente.getIdpacientes());
            request.setAttribute("NombrePaciente", paciente.getNombres_paciente());
            request.setAttribute("ApellidosPaciente", paciente.getApellidos_paciente());
            request.setAttribute("list", list);
            request.setAttribute("paciente", paciente);*/
            idPac = idpacientes;
            if (msg != null) {
                result.append("<li>").append(msg).append("</li>");
            }
        }
        
        if (result.length() > 4) {
            request.setAttribute("cita", cita);
        }

        return result.length() == 4 ? null : result.append("</ul>").toString();

    }

    /*
    public String citaDel() {
        List<Integer> ids = DeString.ids(request.getParameter("ids"));
        String result = (ids != null)
                ? daoCita.citaDel(ids)
                : "IDs incorrectos";
        return result;
    }*/
    public Integer NumMenor(List<Integer> lista) {
        Integer numMenor = 10000;
        if (lista.size() == 0) {
            numMenor = -1;
        } else {
            for (int i = 0; i < lista.size(); i++) {
                if (lista.get(i) < numMenor) {
                    numMenor = lista.get(i);
                }
            }
        }

        return numMenor;

    }
}
