<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

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
                            <h1 class="mt-1"> Agregar Nuevo Administrador </h1>
                            <form action="Administrador" method="post"> 
                                <input type="hidden" name="accion" value="INS"/>    
                                <div class="row">
                                    <div class="col-lg-6 mt-4">
                                        DNI: 
                                        <input class="form-control" type="text" name="dni_administrador" value="${administrador.dni_administrador}"/>
                                        <br/>
                                        Nombre:
                                        <input class="form-control" type="text" name="nombres_administrador" value="${administrador.nombres_administrador}" />
                                        <br/>
                                        Apellido:
                                        <input class="form-control" type="text" name="apellidos_administrador" value="${administrador.apellidos_administrador}"/>
                                        <br/>
                                        Telefono:
                                        <input class="form-control" type="text" name="telefono_administrador" value="${administrador.telefono_administrador}"/>
                                        <br/>
                                    </div>
                                    <div class="col-lg-6 mt-4">
                                        Dirección:
                                        <input class="form-control" type="text" name="direccion_administrador" value="${administrador.direccion_administrador}"/>
                                        <br/>
                                        Fecha de nacimiento:
                                        <input class="form-control" type="date" name="fecha_nacimiento_administrador" value="${administrador.fecha_nacimiento_administrador}"/>
                                        <br/>
                                        Correo electronico:
                                        <input class="form-control" type="text" name="correo_administrador" value="${administrador.correo_administrador}"/>
                                        <br/>
                                        Contraseña:
                                        <input class="form-control" type="text" name="password_administrador" value="${administrador.password_administrador}"/>
                                        <br/>
                                    </div>
                                    <div class="col-lg-12">
                                        <button class="btn btn-primary" type="submit">Agregar</button> 
                                    </div>
                                </div>  
                            </form>         

                            <c:if test="${message != null}"> 
                                <div class="p-3 pb-md-4 mx-auto text-center alert alert-primary w-50" role="alert">
                                    <button type="button" class="close" data-dismiss="alert">&times;</button>
                                        <h3>Se requiere</h3>
                                        ${message}
                                </div>
                                     </c:if> 
                            </div>           
                        </div>
                    </section>
                </div>
            </div>
        </div>
    </body>
</html>
