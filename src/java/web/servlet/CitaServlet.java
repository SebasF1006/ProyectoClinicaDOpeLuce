package web.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import web.validator.CitaValidator;

@WebServlet(name = "CitaServlet", urlPatterns = {"/Cita"})
public class CitaServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String accion = request.getParameter("accion");
        accion = (accion == null) ? "" : accion;
        String result = null;
        String target = "citaPacienteSel.jsp";

        CitaValidator validator = new CitaValidator(request);

        switch (accion) {
            case "SEL":
                result = validator.citaGet2();
                break;
            case "SEL2":
                result = validator.citaSel();
                target = "citaSel.jsp";
                break;
            case "INS":
                result = validator.citaInsUpd(false);
                String id = validator.idPac.toString();
                //"Administrador?accion=SEL"
                target = result == null ? "Cita?accion=SEL&id=" + id : "citaPacienteIns.jsp";
                break;
            /*case "DEL":
                result = validator.citaDel();
                target = "cita.jsp";
                break;*/
            case "GET":
                result = validator.citaGet2();
                target = "citaPacienteIns.jsp";
                break;
            /*case "UPD":
                result = validator.citaInsUpd(true);
                target = result == null ? "cita.jsp" : "citaUpd.jsp";
                break;*/
            case "":
                result = "Solicitud requerida";
                break;
            default:
                result = "Solicitud no reconocida";
        }

        if (result != null) {
            request.setAttribute("message", result);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher(target);
        dispatcher.forward(request, response);
    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
