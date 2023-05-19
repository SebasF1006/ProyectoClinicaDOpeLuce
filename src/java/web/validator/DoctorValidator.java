package web.validator;

import dao.DaoDoctor;
import dao.impl.DaoDoctorImpl;
import entidades.Doctor;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeParseException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import util.DeString;

public class DoctorValidator {

    private final HttpServletRequest request;
    private final DaoDoctor daoDoctor;

    public DoctorValidator(HttpServletRequest request) {
        this.request = request;
        this.daoDoctor = new DaoDoctorImpl();
    }

    public String doctorSel() {
        String result = null;
        List<Doctor> list = daoDoctor.doctorSel();
        if (list != null) {
            request.setAttribute("list", list);
        } else {
            result = daoDoctor.getMessage();
        }
        return result;
    }

    public String doctorGet() {
        String result = null;
        Integer id = DeString.aInteger(request.getParameter("id"));
        Doctor doctor = daoDoctor.doctorGet(id);
        if (doctor != null) {
            request.setAttribute("doctor", doctor);
        } else {
            result = daoDoctor.getMessage();
        }
        return result;
    }

    public String doctorInsUpd(boolean upd) {

        StringBuilder result = new StringBuilder("<ul>");
        Integer iddoctor = DeString.aInteger(request.getParameter("iddoctor"));
        String dni = request.getParameter("dni_doctor");
        String nombres = request.getParameter("nombres_doctor");
        String apellidos = request.getParameter("apellidos_doctor");
        String especialidad = request.getParameter("especialidad_doctor");
        String telefono = request.getParameter("telefono_doctor");
        String direccion = request.getParameter("direccion_doctor");
        String correo = request.getParameter("correo_doctor");
        String password = request.getParameter("password_doctor");
        String aux = request.getParameter("fecha_nacimiento_doctor");
        LocalDate fecha_nacimiento = (aux == null || aux.trim().length() == 0)
                ? null
                : LocalDate.parse(aux);
        LocalDate hoy = LocalDate.now();
        LocalDate registromin = hoy.plusYears(-20);
        LocalDate registromax = hoy.plusYears(-81);
        
        String Fnombre = FormatoString(nombres);
        String Fapellidos = FormatoString(apellidos);

        if (fecha_nacimiento == null) {
            result.append("<li>Fecha de nacimiento</li>");
        } else if (hoy.isBefore(fecha_nacimiento)) {
            result.append("<li>La fecha de nacimiento no puede ser una fecha futura</li>");
        } else if (registromin.isBefore(fecha_nacimiento)) {
            result.append("<li>La edad mínima del doctor debe ser 20 años</li>");
        } else if (registromax.isAfter(fecha_nacimiento)) {
            result.append("<li>La edad máxima del doctor debe ser 80 años</li>");
        }

        Period edad_aux = (aux == null || aux.trim().length() == 0)
                ? null
                : Period.between(fecha_nacimiento, LocalDate.now());
        Integer edad = (aux == null || aux.trim().length() == 0)
                ? null
                : (Integer) edad_aux.getYears();
        
        if (upd && iddoctor == null) {
            result.append("<li>Id</li>");
        }
        if (dni == null || dni.trim().length() == 0) {
            result.append("<li>DNI</li>");
        } else if (dni.trim().length() > 8) {
            result.append("<li>La dimensión del DNI debe tener")
                    .append(" 8 caracteres</li>");
        }
        if (nombres == null || nombres.trim().length() == 0) {
            result.append("<li>Nombre</li>");
        } else if (nombres.trim().length() < 3 || nombres.trim().length() > 50) {
            result.append("<li>La dimensión del nombre debe estar entre")
                    .append("3 a 50 caracteres</li>");
        } else if (Fnombre == null) {
            result.append("<li>El nombre no puede contener caracteres especiales")
                    .append(" (1+´]#¡?)</li>");
        }
        
        
        if (apellidos == null || apellidos.trim().length() == 0) {
            result.append("<li>Apellidos</li>");
        } else if (apellidos.trim().length() < 3 || apellidos.trim().length() > 50) {
            result.append("<li>La dimensión de los apellidos debe estar entre")
                    .append("3 a 50 caracteres</li>");
        } else if (Fapellidos == null) {
            result.append("<li>El apellido no puede contener caracteres especiales")
                    .append(" (1+´]#¡?)</li>");
        }
        
        
        if (especialidad == null || especialidad.trim().length() == 0) {
            result.append("<li>Especialidad</li>");
        } else if (especialidad.trim().length() < 3 || especialidad.trim().length() > 50) {
            result.append("<li>La dimensión de la especialidad debe estar entre")
                    .append("3 a 50 caracteres</li>");
        }
        if (direccion == null || direccion.trim().length() == 0) {
            result.append("<li>Dirección</li>");
        }
        if (telefono == null || telefono.trim().length() == 0) {
            result.append("<li>Telefono</li>");
        } else if (telefono.trim().length() > 9) {
            result.append("<li>La dimensión del Telefono debe tener")
                    .append(" hasta 9 caracteres</li>");
        }
        if (correo == null || correo.trim().length() == 0) {
            result.append("<li>Correo</li>");
        }
        if (password == null || password.trim().length() == 0) {
            result.append("<li>Contraseña</li>");
        }

        Doctor doctor = new Doctor();
        doctor.setIddoctor(iddoctor);
        doctor.setDni_doctor(dni);
        doctor.setNombres_doctor(Fnombre);
        doctor.setApellidos_doctor(Fapellidos);
        doctor.setEspecialidad_doctor(especialidad);
        doctor.setTelefono_doctor(telefono);
        doctor.setDireccion_doctor(direccion);
        doctor.setCorreo_doctor(correo);
        doctor.setPassword_doctor(password);
        doctor.setFecha_nacimiento_doctor(fecha_nacimiento);
        doctor.setEdad_doctor(edad);

        if (result.length() == 4) {
            String msg = upd
                    ? daoDoctor.doctorUpd(doctor)
                    : daoDoctor.doctorIns(doctor);
            if (msg != null) {
                result.append("<li>").append(msg).append("</li>");
            }
        }
        if (result.length() > 4) {
            request.setAttribute("doctor", doctor);
        }

        return result.length() == 4 ? null : result.append("</ul>").toString();
    }

    public String doctorDel() {
        List<Integer> ids = DeString.ids(request.getParameter("ids"));
        String result = (ids != null)
                ? daoDoctor.doctorDel(ids)
                : "IDs incorrectos";
        return result;
    }

    public String FormatoString(String palabra) {
        String stg = "";
        char letrauno = ' ';
        char c = ' ';
        int aux = 0;

        for (int i = 0; i < palabra.length(); i++) {
            letrauno = palabra.charAt(0);
            c = palabra.charAt(i);

            if (letrauno == ' ') {
                return null;
            } else if (!Character.isLetter(c)) {
                if (c != ' ') {
                    return null;
                }

            }

            if (i == 0) {
                c = Character.toUpperCase(c);
            }
            if (i >= 1) {
                c = Character.toLowerCase(c);
            }
            if (c == ' ') {
                aux = (i + 1);
            }
            if (aux == i) {
                c = Character.toUpperCase(c);
            }

            stg += c;
        }

        return stg;
    }
}
