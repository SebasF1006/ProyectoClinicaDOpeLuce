package dao;

import entidades.Administrador;
import java.util.List;

public interface DaoAdministrador {
    List <Administrador> administradorSel();
    Administrador administradorGet(Integer id);
    String administradorIns(Administrador administrador);
    String administradorUpd(Administrador administrador);
    String administradorDel(List<Integer> ids);
    Boolean administradorLogin(String correo, String pass);
    String getMessage();
}
