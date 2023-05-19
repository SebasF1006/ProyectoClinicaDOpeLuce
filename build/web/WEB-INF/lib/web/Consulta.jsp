

<%@page import="java.sql.*"%>

    
<%
    Class.forName("com.mysql.jdbc.Driver");
    Connection miConexionCN = DriverManager.getConnection("jdbc:mysql://localhost/BDSDSem6","root","");
    Statement declararObjetoBdST = miConexionCN.createStatement();
    ResultSet datosObtenidosRS = declararObjetoBdST.executeQuery("SELECT * FROM alumno");
    
    
while (datosObtenidosRS.next()) {
        out.println(datosObtenidosRS.getString("codigo"));
        out.println(datosObtenidosRS.getString("nombres"));
        out.println(datosObtenidosRS.getString("apellidos"));
        out.println("<br>");
    }
    
    datosObtenidosRS.close();
    declararObjetoBdST.close();
    miConexionCN.close();
%>
