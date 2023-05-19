package test;

import dao.DaoPaciente;
import dao.impl.DaoPacienteImpl;
import entidades.Paciente;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TestPacienteGetLogin {

    public static void main(String[] args) {

        //TEST METODO pacienteGetLogin();
        Paciente paci;
        DaoPaciente dao = new DaoPacienteImpl();
        String correo ="augustos@gmail.com";
        String pass = "as43331047";
        try {
            paci = dao.pacienteGetLogin(correo, pass);
            System.out.println(paci.getNombres_paciente());
            System.out.println(paci.getIdpacientes());
        } catch (Exception e) {
            dao.getMessage();
        }

    }

}
