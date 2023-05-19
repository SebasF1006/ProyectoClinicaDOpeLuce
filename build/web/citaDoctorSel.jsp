<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>OPELUCE</title>

        <link href="https://unpkg.com/ionicons@4.5.10-0/dist/css/ionicons.min.css" rel="stylesheet">

        <!-- BOOTSTRAP -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF" crossorigin="anonymous"></script>
        <!-- ESTILO PROPIO -->
        <link href="css/estilo_intranet.css" rel="stylesheet" type="text/css"/>
        <script src="js/cita.js" type="text/javascript"></script>

    </head>
    <body>
        <div class="d-flex">
            <div id="sidebar-container" class="bg-primary">
                <div class="logo">
                    <h4 class="text-light font-weight-bold">Opeluce</h4>
                </div>
                <div class="menu">
                    <!--a href="#" class="d-block text-light p-3"><i class="icon ion-md-apps mr-2 lead"></i>Tablero</a-->
                    <a href="#" class="d-block text-light p-3"><i class="icon ion-md-calendar mr-2 lead"></i>Mis Citas</a>
                    <a href="index.html" class="d-block text-light p-3"><i class="icon ion-md-settings mr-2 lead"></i>Cerrar Sesión</a>
                </div>
            </div>
            <div class="w-100">
                <nav class="navbar navbar-expand-lg navbar-light bg-light border-bottom">
                    <div class="container">
                        <button class="navbar-toggler" type="button" data-toggle="collapse" 
                                data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" 
                                aria-expanded="false" aria-label="Toggle navigation">
                            <span class="navbar-toggler-icon"></span>
                        </button>
                        <!--form class="form-inline my-2 my-lg-0">
                          <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                          <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                        </form-->
                        <div class="collapse navbar-collapse" id="navbarSupportedContent">
                            <ul class="navbar-nav ml-auto">
                                <li class="nav-item dropdown">
                                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" 
                                       data-toggle="dropdown" aria-expanded="false">
                                        ${NombreDoctor} ${ApellidosDoctor}
                                    </a>
                                    <!--div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                        <a class="dropdown-item" href="#">Perfil </a>
                                        <div class="dropdown-divider"></div>
                                        <a class="dropdown-item" href="index.html">Cerrar Sesión</a>
                                    </div-->
                                </li>
                            </ul>
                        </div>
                    </div>
                </nav>
                <div id="content">
                    <section class="py-3">
                        <div class="container">
                            <h1 class="font-weight-bold mb-0">MIS CITAS</h1>
                            <!--a class="btn btn-primary" href="pacienteIns.jsp"> Agregar Nuevo</a--> 
                            <!--button type="button" class="btn btn-primary" data-toggle="modal" data-target="#AgregarPaciente" data-whatever="@mdo">Agregar Nuevo</button>

                            <!--div class="row py-3">
                            <form class="form-inline col-lg-6">
                              <input class="form-control mr-sm-2" type="search" placeholder="Nombre" aria-label="Search">
                              <button class="btn btn-warning my-2 my-sm-0" type="submit">Buscar</button>
                            </form>
                            <form class="form-inline col-lg-6">
                              <input class="form-control mr-sm-2" type="search" placeholder="N° doc" aria-label="Search">
                              <button class="btn btn-warning my-2 my-sm-0" type="submit">Buscar</button>
                            </form>
                            </div-->
                            <br class="py-3">

                            <table class="table table-bordered">
                                <thead>
                                    <tr class="color-title">
                                        <th class="text-center">IDCITA</th>
                                        <th class="text-center">PACIENTE</th>
                                        <th class="text-center">TIPO DE CITA</th>
                                        <th class="text-center">COSTO DE CITA</th>
                                        <th class="text-center">FECHA DE CITA</th>
                                        <th class="text-center">HORA DE CITA</th>
                                        <!--th>
                                            <a  class="text-light text-center" onclick="citaDel();">
                                                Eliminar                         
                                            </a>
                                        </th-->
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="f" items="${list}">
                                        <tr>
                                            <td class="text-center">${f.idcita}</td>
                                            <td class="text-center">${f.paciente}</td>
                                            <td class="text-center">${f.tipo_cita}</td>
                                            <td class="text-center">${f.costo_cita}</td>
                                            <td class="text-center">${f.fecha_cita}</td>
                                            <td class="text-center">${f.hora_cita}</td>
                                            <!--th>
                                                <input type="checkbox" name="id_del" 
                                                       value=""/>
                                            </th-->
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </section>
                </div>
            </div>
        </div>
    </body>
</html>
