package test;

import dao.DaoAdministrador;
import dao.impl.DaoAdministradorImpl;
import entidades.Administrador;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TestAdministradorLogin {

    public static void main(String[] args) {

        //TEST METODO administradorLogin()
        Boolean rspta = null;
        String correo = "fassfafsa";
        String pass = "fsafsasfa21";
        DaoAdministrador dao = new DaoAdministradorImpl();
        try {
            rspta = dao.administradorLogin(correo, pass);
            System.out.println(rspta);
        } catch (Exception e) {
            dao.getMessage();
        }
        
    }

}
