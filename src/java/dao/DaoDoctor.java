package dao;

import entidades.Doctor;
import java.util.List;

public interface DaoDoctor {
    List <Doctor> doctorSel();
    Doctor doctorGet(Integer id);
    String doctorIns(Doctor doctor);
    String doctorUpd(Doctor doctor);
    String doctorDel(List<Integer> ids);
    Boolean doctorLogin(String correo, String pass);
    Doctor doctorGetLogin(String correo, String pass);
    String getMessage();
}
