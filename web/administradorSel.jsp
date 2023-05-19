<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
        <script src="js/administrador.js" type="text/javascript"></script>
    </head>
    <body>
        <div class="d-flex">
            <div id="sidebar-container" class="bg-primary">
                <div class="logo">
                    <h4 class="text-light font-weight-bold">Opeluce</h4>
                </div>
                <div class="menu">
                    <!--a href="LoginAdministrador.jsp" class="d-block text-light p-3"><i class="icon ion-md-apps mr-2 lead"></i>Tablero</a-->
                    <a href="administrador.jsp" class="d-block text-light p-3"><i class="icon ion-md-person mr-2 lead"></i>Adminstradores</a>
                    <a href="doctor.jsp" class="d-block text-light p-3"><i class="icon ion-md-heart mr-2 lead"></i>Doctores</a>
                    <a href="paciente.jsp" class="d-block text-light p-3"><i class="icon ion-md-people mr-2 lead"></i>Pacientes</a>
                    <a href="cita.jsp" class="d-block text-light p-3"><i class="icon ion-md-calendar mr-2 lead"></i>Citas</a>
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
                                        ADMINISTRADOR
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
                            <h1 class="font-weight-bold mb-0">CATALOGO DE ADMINISTRADORES</h1>
                            <a class="btn btn-primary mt-4 mb-4" href="administradorIns.jsp"> Agregar Nuevo</a>
                            <!--button type="button" class="btn btn-primary" data-toggle="modal" data-target="#AgregarPaciente" data-whatever="@mdo">Agregar Nuevo</button-->

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
                                        <th class="text-center">ID</th>
                                        <th class="text-center">DNI</th>
                                        <th class="text-center">NOMBRES</th>
                                        <th class="text-center">APELLIDOS</th>
                                        <th class="text-center">TELEFONO</th>
                                        <th class="text-center">DIRECCION</th>
                                        <th class="text-center">EDAD</th>
                                        <th class="text-center">FECHA DE NACIMIENTO</th>
                                        <th class="text-center">CORREO</th>
                                        <th>
                                            <a href="#" class="text-light text-center" onclick="administradorUpd();">
                                                Editar
                                            </a>
                                            <!--button onclick="administradorUpd();" type="button" class="btn btn-primary" data-toggle="modal" data-target="#EditarAdministrador" data-whatever="@mdo">Editar</button-->
                                        </th>
                                        <th>
                                            <a href="#" class="text-light text-center" onclick="administradorDel();">
                                                Eliminar                         
                                            </a>
                                        </th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="f" items="${list}">
                                        <tr>
                                            <td class="text-center">${f.idadministrador}</td>
                                            <td class="text-center">${f.dni_administrador}</td>
                                            <td class="text-center">${f.nombres_administrador}</td>
                                            <td class="text-center">${f.apellidos_administrador}</td>
                                            <td class="text-center">${f.telefono_administrador}</td>
                                            <td class="text-center">${f.direccion_administrador}</td>
                                            <td class="text-center">${f.edad_administrador}</td>
                                            <td class="text-center">${f.fecha_nacimiento_administrador}</td>
                                            <td class="text-center">${f.correo_administrador}</td>
                                            <th class="text-center">
                                                <input class="align-items-center" type="radio" name="id_upd"
                                                       value="${f.idadministrador}"/>
                                            </th>
                                            <th>
                                                <input class="align-self-center" type="checkbox" name="id_del" 
                                                       value="${f.idadministrador}"/>
                                            </th>
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
