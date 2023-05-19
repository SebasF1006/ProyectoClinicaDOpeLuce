package test;

import dao.DaoDoctor;
import dao.impl.DaoDoctorImpl;
import entidades.Doctor;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TestDoctorLogin {

    public static void main(String[] args) {

        //TEST METODO doctorLogin()
        Boolean rspta = null;
        String correo = "hgghgh@gmail.com";
        String pass = "saf54653";
        DaoDoctor dao = new DaoDoctorImpl();
        try {
            rspta = dao.doctorLogin(correo, pass);
            System.out.println(rspta);
        } catch (Exception e) {
            dao.getMessage();
        }
        
    }

}
