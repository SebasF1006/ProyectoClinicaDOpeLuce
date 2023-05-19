package dao.impl;

import dao.DaoAdministrador;
import entidades.Administrador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import util.ConexionBD;

public class DaoAdministradorImpl implements DaoAdministrador {

    private final ConexionBD conectaDb;
    private String mensaje;

    public DaoAdministradorImpl() {
        this.conectaDb = new ConexionBD();
    }

    /**
     * Selecciona todos los administradores de la base de datos
     *
     * @param -
     * @return Lista de Administradores
     */
    @Override
    public List<Administrador> administradorSel() {
        List<Administrador> list = null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("idadministrador,")
                .append("dni_administrador,")
                .append("nombres_administrador,")
                .append("apellidos_administrador,")
                .append("telefono_administrador,")
                .append("direccion_administrador,")
                .append("correo_administrador,")
                .append("password_administrador,")
                .append("fecha_nacimiento_administrador,")
                .append("edad_administrador")
                .append(" FROM administrador");
        try ( Connection cn = conectaDb.conexionDB()) {
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ResultSet rs = ps.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
                Administrador administrador = new Administrador();
                administrador.setIdadministrador(rs.getInt(1));
                administrador.setDni_administrador(rs.getString(2));
                administrador.setNombres_administrador(rs.getString(3));
                administrador.setApellidos_administrador(rs.getString(4));
                administrador.setTelefono_administrador(rs.getString(5));
                administrador.setDireccion_administrador(rs.getString(6));
                administrador.setCorreo_administrador(rs.getString(7));
                administrador.setPassword_administrador(rs.getString(8));
                administrador.setFecha_nacimiento_administrador(LocalDate.parse(rs.getString(9)));
                administrador.setEdad_administrador(rs.getInt(10));
                list.add(administrador);
            }
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return list;
    }

    /**
     * Buscar los datos de un administrador en especifico usando el id del
     * administrador en la base de datos
     *
     * @param id Int id identificador de administrador
     * @return Variable de tipo Administrador
     */
    @Override
    public Administrador administradorGet(Integer id) {
        Administrador administrador = new Administrador();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("idadministrador,")
                .append("dni_administrador,")
                .append("nombres_administrador,")
                .append("apellidos_administrador,")
                .append("telefono_administrador,")
                .append("direccion_administrador,")
                .append("correo_administrador,")
                .append("password_administrador,")
                .append("fecha_nacimiento_administrador,")
                .append("edad_administrador")
                .append(" FROM administrador WHERE idadministrador = ?");
        try ( Connection cn = conectaDb.conexionDB()) {
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ps.setInt(1, id);
            try ( ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    administrador.setIdadministrador(rs.getInt(1));
                    administrador.setDni_administrador(rs.getString(2));
                    administrador.setNombres_administrador(rs.getString(3));
                    administrador.setApellidos_administrador(rs.getString(4));
                    administrador.setTelefono_administrador(rs.getString(5));
                    administrador.setDireccion_administrador(rs.getString(6));
                    administrador.setCorreo_administrador(rs.getString(7));
                    administrador.setPassword_administrador(rs.getString(8));
                    administrador.setFecha_nacimiento_administrador(LocalDate.parse(rs.getString(9)));
                    administrador.setEdad_administrador(rs.getInt(10));
                } else {
                    administrador = null;
                }
            } catch (SQLException e) {
                mensaje = e.getMessage();
            }
        } catch (SQLException e) {
            mensaje = e.getMessage();
        }
        return administrador;
    }

    /**
     * Insetar administradores a la base de datos
     *
     * @param administrador Administrador administrador
     * @return El mensaje correspondiente y datos insertados a la base de datos
     */
    @Override
    public String administradorIns(Administrador administrador) {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO administrador( ")
                .append("dni_administrador,")
                .append("nombres_administrador,")
                .append("apellidos_administrador,")
                .append("telefono_administrador,")
                .append("direccion_administrador,")
                .append("correo_administrador,")
                .append("password_administrador,")
                .append("fecha_nacimiento_administrador,")
                .append("edad_administrador")
                .append(") VALUES (?,?,?,?,?,?,?,?,?) ");
        try ( Connection cn = conectaDb.conexionDB()) {
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ps.setString(1, administrador.getDni_administrador());
            ps.setString(2, administrador.getNombres_administrador());
            ps.setString(3, administrador.getApellidos_administrador());
            ps.setString(4, administrador.getTelefono_administrador());
            ps.setString(5, administrador.getDireccion_administrador());
            ps.setString(6, administrador.getCorreo_administrador());
            ps.setString(7, administrador.getPassword_administrador());
            ps.setString(8, administrador.getFecha_nacimiento_administrador().toString());
            ps.setInt(9, administrador.getEdad_administrador());
            int ctos = ps.executeUpdate();
            if (ctos == 0) {
                mensaje = "cero filas insertadas";
            }
        } catch (SQLException e) {
            mensaje = e.getMessage();
        }
        return mensaje;
    }

    /**
     * Actualizar la informacion de administradores en la base de datos
     *
     * @param administrador
     * @return El mensaje correspondiente y datos modificados del administrador
     * en especifico
     */
    @Override
    public String administradorUpd(Administrador administrador) {
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE administrador SET ")
                .append("dni_administrador = ?,")
                .append("nombres_administrador = ?,")
                .append("apellidos_administrador = ?,")
                .append("telefono_administrador = ?,")
                .append("direccion_administrador = ?,")
                .append("correo_administrador = ?,")
                .append("password_administrador = ?,")
                .append("fecha_nacimiento_administrador = ?,")
                .append("edad_administrador = ? ")
                .append("WHERE idadministrador = ?  ");
        try ( Connection cn = conectaDb.conexionDB()) {
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ps.setString(1, administrador.getDni_administrador());
            ps.setString(2, administrador.getNombres_administrador());
            ps.setString(3, administrador.getApellidos_administrador());
            ps.setString(4, administrador.getTelefono_administrador());
            ps.setString(5, administrador.getDireccion_administrador());
            ps.setString(6, administrador.getCorreo_administrador());
            ps.setString(7, administrador.getPassword_administrador());
            ps.setString(8, administrador.getFecha_nacimiento_administrador().toString());
            ps.setInt(9, administrador.getEdad_administrador());
            ps.setInt(10, administrador.getIdadministrador());
            int ctos = ps.executeUpdate();
            if (ctos == 0) {
                mensaje = "No se pudo actualizar";
            }
        } catch (SQLException e) {
            mensaje = e.getMessage();
        }
        return mensaje;
    }

    /**
     * Borrar administradores de la base de datos siendo buscados por el id del
     * administrador
     *
     * @param ids List Integer ids Lista de Identificador de administrador
     * @return El mensaje correspondiente y elimina los administradores de la
     * base de datos
     */
    @Override
    public String administradorDel(List<Integer> ids) {
        StringBuilder sql = new StringBuilder();
        sql.append("DELETE FROM administrador WHERE ")
                .append("idadministrador = ? ");
        try ( Connection cn = conectaDb.conexionDB()) {
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            cn.setAutoCommit(false);
            boolean ok = true;
            for (int id = 0; id < ids.size(); id++) {
                ps.setInt(1, ids.get(id));
                int ctos = ps.executeUpdate();
                if (ctos == 0) {
                    ok = false;
                    mensaje = "ID: " + ids.get(id) + " no existe";
                }
            }
            if (ok) {
                cn.commit();
            } else {
                cn.rollback();
            }
            cn.setAutoCommit(true);
        } catch (SQLException e) {
            mensaje = e.getMessage();
        }
        return mensaje;
    }

    /**
     * Retorna true si el usuario y contraseña existen o retona false si el
     * usuario y contraseña no existen
     *
     * @param correo String correo Correo del administrador
     * @param pass String pass Contrseña del administrador
     * @return Varible de tipo Boolean
     */
    @Override
    public Boolean administradorLogin(String correo, String pass) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("correo_administrador,")
                .append("password_administrador")
                .append(" FROM administrador");
        try ( Connection cn = conectaDb.conexionDB()) {
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String correoDB = rs.getString(1);
                String passBD = rs.getString(2);
                if (correoDB.equals(correo) && passBD.equals(pass)) {
                    return true;
                }
            }
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return null;
    }

    /**
     * Retorna el mensaje
     *
     * @param -
     * @return Mensaje
     */
    @Override
    public String getMessage() {
        return mensaje;
    }

}
