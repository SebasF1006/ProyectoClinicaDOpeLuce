package web.validator;

import dao.DaoAdministrador;
import dao.impl.DaoAdministradorImpl;
import entidades.Administrador;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeParseException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import util.DeString;

public class AdministradorValidator {

    private final HttpServletRequest request;
    private final DaoAdministrador daoAdministrador;

    public AdministradorValidator(HttpServletRequest request) {
        this.request = request;
        this.daoAdministrador = new DaoAdministradorImpl();
    }

    public String administradorSel() {
        String result = null;
        List<Administrador> list = daoAdministrador.administradorSel();
        if (list != null) {
            request.setAttribute("list", list);
        } else {
            result = daoAdministrador.getMessage();
        }
        return result;
    }

    public String administradorGet() {
        String result = null;
        Integer id = DeString.aInteger(request.getParameter("id"));
        Administrador administrador = daoAdministrador.administradorGet(id);
        if (administrador != null) {
            request.setAttribute("administrador", administrador);
        } else {
            result = daoAdministrador.getMessage();
        }
        return result;
    }

    public String administradorInsUpd(boolean upd) {

        StringBuilder result = new StringBuilder("<ul>");
        Integer idadministrador = DeString.aInteger(request.getParameter("idadministrador"));
        String dni = request.getParameter("dni_administrador");
        String nombres = request.getParameter("nombres_administrador");
        String apellidos = request.getParameter("apellidos_administrador");
        String telefono = request.getParameter("telefono_administrador");
        String direccion = request.getParameter("direccion_administrador");
        String correo = request.getParameter("correo_administrador");
        String password = request.getParameter("password_administrador");
        String aux = request.getParameter("fecha_nacimiento_administrador");
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
            result.append("<li>La edad mínima del administrador debe ser 20 años</li>");
        } else if (registromax.isAfter(fecha_nacimiento)) {
            result.append("<li>La edad máxima del administrador debe ser 80 años</li>");
        }

        Period edad_aux = (aux == null || aux.trim().length() == 0)
                ? null
                : Period.between(fecha_nacimiento, LocalDate.now());
        Integer edad = (aux == null || aux.trim().length() == 0)
                ? null
                : (Integer) edad_aux.getYears();

        if (upd && idadministrador == null) {
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
                    .append(" 3 a 50 caracteres</li>");
        } else if (Fnombre == null) {
            result.append("<li>El nombre no puede contener caracteres especiales")
                    .append(" (1+´]#¡?)</li>");
        }
        
        
        if (apellidos == null || apellidos.trim().length() == 0) {
            result.append("<li>Apellidos</li>");
        } else if (apellidos.trim().length() < 3 || apellidos.trim().length() > 50) {
            result.append("<li>La dimensión de los apellidos debe estar entre")
                    .append(" 3 a 50 caracteres</li>");
        } else if (Fapellidos == null) {
            result.append("<li>El apellido no puede contener caracteres especiales")
                    .append(" (1+´]#¡?)</li>");
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

        Administrador administrador = new Administrador();
        administrador.setIdadministrador(idadministrador);
        administrador.setDni_administrador(dni);
        administrador.setNombres_administrador(Fnombre);
        administrador.setApellidos_administrador(Fapellidos);
        administrador.setTelefono_administrador(telefono);
        administrador.setDireccion_administrador(direccion);
        administrador.setCorreo_administrador(correo);
        administrador.setPassword_administrador(password);
        administrador.setFecha_nacimiento_administrador(fecha_nacimiento);
        administrador.setEdad_administrador(edad);

        if (result.length() == 4) {
            String msg = upd
                    ? daoAdministrador.administradorUpd(administrador)
                    : daoAdministrador.administradorIns(administrador);
            if (msg != null) {
                result.append("<li>").append(msg).append("</li>");
            }
        }
        if (result.length() > 4) {
            request.setAttribute("administrador", administrador);
        }

        return result.length() == 4 ? null : result.append("</ul>").toString();
    }

    public String administradorDel() {
        List<Integer> ids = DeString.ids(request.getParameter("ids"));
        String result = (ids != null)
                ? daoAdministrador.administradorDel(ids)
                : "IDs incorrectos";
        return result;
    }

    public String FormatoString(String palabra){
        String stg="";
        char letrauno=' ';
        char c=' ';
        int aux=0;
        
        for (int i = 0; i < palabra.length(); i++) {
            letrauno=palabra.charAt(0);
            c=palabra.charAt(i);
            
            if (letrauno==' ') {
                return null;
            }else if (!Character.isLetter(c)) {
                if (c != ' ') {
                  return null;  
                }
                
            }
            
            if (i==0) {
                c=Character.toUpperCase(c);
            }
            if (i>=1) {
                c=Character.toLowerCase(c);
            }
            if (c==' ') {
                aux=(i+1);
            }
            if (aux==i) {
                c=Character.toUpperCase(c);
            }
            
            stg+=c;
        }
        
        return stg;
    }
    
}
