package dao.impl;

import DTO.CitaDoctorDTO;
import DTO.CitaPacienteDTO;
import dao.DaoCita;
import entidades.Cita;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import util.ConexionBD;

public class DaoCitaImpl implements DaoCita {

    private final ConexionBD conectaDb;
    private String mensaje;

    public DaoCitaImpl() {
        this.conectaDb = new ConexionBD();
    }

    /**
     * Insetar citas a la base de datos
     *
     * @param cita Cita cita
     * @return El mensaje correspondiente y datos insertados a la base de datos
     */
    @Override
    public String citaIns(Cita cita) {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO cita( ")
                .append("idpacientes,")
                .append("iddoctor,")
                .append("tipo_cita,")
                .append("costo_cita,")
                .append("fecha_cita,")
                .append("hora_cita")
                .append(") VALUES (?,?,?,?,?,?) ");
        try ( Connection cn = conectaDb.conexionDB()) {
            PreparedStatement ps = cn.prepareStatement(sql.toString());//Ingresa la informacion recibida a la base de datos 
            ps.setInt(1, cita.getIdpacientes());
            ps.setInt(2, cita.getIddoctor());
            ps.setString(3, cita.getTipo_cita());
            ps.setDouble(4, cita.getCosto_cita());
            ps.setString(5, cita.getFecha_cita().toString());
            ps.setString(6, cita.getHora_cita().toString());
            int ctos = ps.executeUpdate();//Contador de la cantidad de datos ingresados
            if (ctos == 0) {
                mensaje = "cero filas insertadas";//Si no se ingresan datos nos mandara el mensaje de "cero filas insertadas"
            }
        } catch (SQLException e) {
            mensaje = e.getMessage();
        }
        return mensaje;//retorna el mensaje 
    }

    /**
     * Te devuelve una lista de Integer id de doctor donde coincidan el tipo de
     * cita ingresado y no coincida la hora y fecha ingresadas
     *
     * @param tipo_cita String tipo_cita Tipo de cita del paciente
     * @param hora LocalTime hora Hora de la cita
     * @param fecha LocalDate fecha Fecha de la cita
     * @return Lista de Integer ids
     */
    @Override
    public List<Integer> idsDoctor(String tipo_cita, LocalTime hora, LocalDate fecha) {
        List<Integer> list = null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("iddoctor")
                .append(" FROM cita")
                .append(" WHERE tipo_cita = ? AND")
                .append(" fecha_cita!= ? OR")
                .append(" hora_cita!= ? ");
        try ( Connection cn = conectaDb.conexionDB()) {
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ps.setString(1, tipo_cita);
            ps.setString(2, fecha.toString());
            ps.setString(3, hora.toString());

            try ( ResultSet rs = ps.executeQuery()) {
                list = new ArrayList<>();
                while (rs.next()) {
                    Integer id = (Integer) rs.getInt(1);
                    list.add(id);
                }
            } catch (SQLException e) {
                mensaje = e.getMessage();
            }

        } catch (Exception e) {
            mensaje = e.getMessage();
        }

        return list;
    }

    /**
     * Te devuelve una lista de Integer id de doctor donde coincidan el tipo de
     * cita, la hora y fecha ingresados
     *
     * @param tipo_cita String tipo_cita Tipo de cita del paciente
     * @param hora LocalTime hora Hora de la cita
     * @param fecha LocalDate fecha Fecha de la cita
     * @return Lista de Integer ids
     */
    @Override
    public List<Integer> idsNoDoctor(String tipo_cita, LocalTime hora, LocalDate fecha) {
        List<Integer> list = null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("iddoctor")
                .append(" FROM cita")
                .append(" WHERE tipo_cita = ? AND")
                .append(" fecha_cita= ? AND")
                .append(" hora_cita= ? ");
        try ( Connection cn = conectaDb.conexionDB()) {
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ps.setString(1, tipo_cita);
            ps.setString(2, fecha.toString());
            ps.setString(3, hora.toString());

            try ( ResultSet rs = ps.executeQuery()) {
                list = new ArrayList<>();
                while (rs.next()) {
                    Integer id = (Integer) rs.getInt(1);
                    list.add(id);
                }
            } catch (SQLException e) {
                mensaje = e.getMessage();
            }

        } catch (Exception e) {
            mensaje = e.getMessage();
        }

        return list;
    }

    /**
     * Te devuelve una lista de Integer id de doctor donde coincidan el tipo de
     * cita
     *
     * @param tipo_cita String tipo_cita Tipo de cita del paciente
     * @return
     */
    @Override
    public List<Integer> idsDoctorS(String tipo_cita) {
        List<Integer> list = null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("iddoctor")
                .append(" FROM doctor")
                .append(" WHERE especialidad_doctor = ? ");
        try ( Connection cn = conectaDb.conexionDB()) {
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ps.setString(1, tipo_cita);

            try ( ResultSet rs = ps.executeQuery()) {
                list = new ArrayList<>();
                while (rs.next()) {
                    Integer id = (Integer) rs.getInt(1);
                    list.add(id);
                }
            } catch (SQLException e) {
                mensaje = e.getMessage();
            }

        } catch (Exception e) {
            mensaje = e.getMessage();
        }

        return list;
    }

    /**
     * Selecciona todos las citas de la base de datos
     *
     * @param -
     * @return Lista de citas
     */
    @Override
    public List<Cita> citaSel() {
        List<Cita> list = null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("idcita,")
                .append("idpacientes,")
                .append("iddoctor,")
                .append("tipo_cita,")
                .append("costo_cita,")
                .append("fecha_cita,")
                .append("hora_cita")
                .append(" FROM cita");
        try ( Connection cn = conectaDb.conexionDB()) {
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ResultSet rs = ps.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
                Cita cita = new Cita();
                cita.setIdcita(rs.getInt(1));
                cita.setIdpacientes(rs.getInt(2));
                cita.setIddoctor(rs.getInt(3));
                cita.setTipo_cita(rs.getString(4));
                cita.setCosto_cita(rs.getDouble(5));
                cita.setFecha_cita(LocalDate.parse(rs.getString(6)));
                cita.setHora_cita(LocalTime.parse(rs.getString(7)));
                list.add(cita);
            }
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return list;
    }

    /**
     * Buscar los datos de una cita en especifico usando el id de la cita en la
     * base de datos
     *
     * @param id Int id identificador de cita
     * @return Variable de tipo Cita
     */
    @Override
    public Cita citaGet(Integer id) {
        Cita cita = new Cita();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("idcita,")
                .append("idpacientes,")
                .append("iddoctor,")
                .append("tipo_cita,")
                .append("costo_cita,")
                .append("fecha_cita,")
                .append("hora_cita")
                .append(" FROM cita WHERE idcita = ?");// Selecciona todos los datos que coincidan con el id solicitado
        try ( Connection cn = conectaDb.conexionDB()) {
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ps.setInt(1, id);
            try ( ResultSet rs = ps.executeQuery()) { //Llama a todos los elementos seleccionados y los transforma en Strings
                if (rs.next()) {
                    cita.setIdcita(rs.getInt(1));
                    cita.setIdpacientes(rs.getInt(2));
                    cita.setIddoctor(rs.getInt(3));
                    cita.setTipo_cita(rs.getString(4));
                    cita.setCosto_cita(rs.getDouble(5));
                    cita.setFecha_cita(LocalDate.parse(rs.getString(6)));
                    cita.setHora_cita(LocalTime.parse(rs.getString(7)));
                } else {
                    cita = null; // En caso no encuentre el id solicitado se considerará que el cita no existe
                }
            } catch (SQLException e) {
                mensaje = e.getMessage();
            }
        } catch (SQLException e) {
            mensaje = e.getMessage();
        }
        return cita;
    }

    /**
     * Selecciona todos las citas de la base de datos donde el id del paciente
     * sea el id del parametro ingresado
     *
     * @param id Integer id Id del paciente
     * @return Lista de Citas
     */
    @Override
    public List<Cita> citaPacienteSel(Integer id) {
        List<Cita> list = null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("idcita,")
                .append("idpacientes,")
                .append("iddoctor,")
                .append("tipo_cita,")
                .append("costo_cita,")
                .append("fecha_cita,")
                .append("hora_cita")
                .append(" FROM cita where idpacientes = ?");
        try ( Connection cn = conectaDb.conexionDB()) {
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
                Cita cita = new Cita();
                cita.setIdcita(rs.getInt(1));
                cita.setIdpacientes(rs.getInt(2));
                cita.setIddoctor(rs.getInt(3));
                cita.setTipo_cita(rs.getString(4));
                cita.setCosto_cita(rs.getDouble(5));
                cita.setFecha_cita(LocalDate.parse(rs.getString(6)));
                cita.setHora_cita(LocalTime.parse(rs.getString(7)));
                list.add(cita);
            }
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return list;
    }

    /**
     * Selecciona todos las citas de la base de datos donde el id del doctor sea
     * el id del parametro ingresado
     *
     * @param id Integer id Id del doctor
     * @return Lista de Citas
     */
    @Override
    public List<Cita> citaDoctorSel(Integer id) {
        List<Cita> list = null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("idcita,")
                .append("idpacientes,")
                .append("iddoctor,")
                .append("tipo_cita,")
                .append("costo_cita,")
                .append("fecha_cita,")
                .append("hora_cita")
                .append(" FROM cita where iddoctor = ?");
        try ( Connection cn = conectaDb.conexionDB()) {
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
                Cita cita = new Cita();
                cita.setIdcita(rs.getInt(1));
                cita.setIdpacientes(rs.getInt(2));
                cita.setIddoctor(rs.getInt(3));
                cita.setTipo_cita(rs.getString(4));
                cita.setCosto_cita(rs.getDouble(5));
                cita.setFecha_cita(LocalDate.parse(rs.getString(6)));
                cita.setHora_cita(LocalTime.parse(rs.getString(7)));
                list.add(cita);
            }
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return list;
    }

    /**
     * Selecciona todos lod datos de la vista citaPaciente_view de la base de
     * datos donde el id del paciente sea el id del parametro ingresado
     *
     * @param id Integer id Id del paciente
     * @return Lista de CitaPacienteDTO
     */
    @Override
    public List<CitaPacienteDTO> citaPacienteDTOSel(Integer id) {
        List<CitaPacienteDTO> list = null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("idcita,")
                .append("ndoctor,")
                .append("tipo_cita,")
                .append("costo_cita,")
                .append("fecha_cita,")
                .append("hora_cita")
                .append(" FROM citaPaciente_view where idpacientes = ?")
                .append(" ORDER BY idcita");
        try ( Connection cn = conectaDb.conexionDB()) {
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
                CitaPacienteDTO cita = new CitaPacienteDTO();
                cita.setIdcita(rs.getInt(1));
                cita.setDoctor(rs.getString(2));
                cita.setTipo_cita(rs.getString(3));
                cita.setCosto_cita(rs.getDouble(4));
                cita.setFecha_cita(LocalDate.parse(rs.getString(5)));
                cita.setHora_cita(LocalTime.parse(rs.getString(6)));
                list.add(cita);
            }
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return list;
    }

    /**
     * Selecciona todos lod datos de la vista citaDoctor_view de la base de
     * datos donde el id del doctor sea el id del parametro ingresado
     *
     * @param id Integer id Id del doctor
     * @return Lista de CitaDoctorDTO
     */
    @Override
    public List<CitaDoctorDTO> citaDoctorDTOSel(Integer id) {
        List<CitaDoctorDTO> list = null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("idcita,")
                .append("npaciente,")
                .append("tipo_cita,")
                .append("costo_cita,")
                .append("fecha_cita,")
                .append("hora_cita")
                .append(" FROM citaDoctor_view where iddoctor = ?")
                .append(" ORDER BY idcita");
        try ( Connection cn = conectaDb.conexionDB()) {
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
                CitaDoctorDTO cita = new CitaDoctorDTO();
                cita.setIdcita(rs.getInt(1));
                cita.setPaciente(rs.getString(2));
                cita.setTipo_cita(rs.getString(3));
                cita.setCosto_cita(rs.getDouble(4));
                cita.setFecha_cita(LocalDate.parse(rs.getString(5)));
                cita.setHora_cita(LocalTime.parse(rs.getString(6)));
                list.add(cita);
            }
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return list;
    }

    /**
     * Retorna el mensaje
     *
     * @param -
     * @return Mesaje
     */
    @Override
    public String getMessage() {
        return mensaje;
    }

}
