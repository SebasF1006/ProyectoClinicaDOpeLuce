package test;

import dao.DaoDoctor;
import dao.impl.DaoDoctorImpl;
import entidades.Doctor;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TestDoctorGetLogin {

    public static void main(String[] args) {

        //TEST METODO doctorGet();
        Doctor paci;
        DaoDoctor dao = new DaoDoctorImpl();
        String correo ="hgghgh@gmail.com";
        String pass = "saf54653";
        try {
            paci = dao.doctorGetLogin(correo, pass);
            System.out.println(paci.getNombres_doctor());
            System.out.println(paci.getIddoctor());
        } catch (Exception e) {
            dao.getMessage();
        }

    }

}
