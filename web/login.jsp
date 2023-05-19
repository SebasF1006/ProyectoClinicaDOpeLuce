<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <title>Clinica Opeluce Login</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <!-- FONT AWESOME -->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.8/css/solid.css">
        <script src="https://use.fontawesome.com/releases/v5.0.7/js/all.js"></script>
        <link href="https://unpkg.com/ionicons@4.5.10-0/dist/css/ionicons.min.css" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css2?family=Mulish:wght@300&display=swap" rel="stylesheet">

        <!--========================================================== -->
        <!-- BOOTSTRAP -->
        <!--========================================================== -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF" crossorigin="anonymous"></script>

        <!--========================================================== -->
        <!-- ESTILO PROPIO -->
        <!--========================================================== -->

        <link href="css/estilo_signin.css" rel="stylesheet" type="text/css"/>
    </head>

    <body class="text-center">

        <main class="form-signin ">
            <form action="Login" method="POST">
                <img class="mb-4 " src="img/user3.png" alt="" width="90" height="80">
                <h1 class="h3 mb-3 fw-normal">Iniciar Sesión</h1>

                <div class="form-floating">
                    <label for="floatingInput">Correo:</label>
                    <input type="email" class="form-control" id="floatingInput" name="correo" placeholder="Correo">
                </div>
                <div class="form-floating">
                    <label for="floatingPassword">Contraseña:</label>
                    <input type="password" class="form-control" id="floatingPassword" name="pass" placeholder="Password">
                </div>

                <button class="w-100 btn btn-lg btn-primary mt-4" type="submit"><i class="fas fa-sign-in-alt"></i>  Ingresar</button>
                
                <a class="w-100 btn btn-lg btn-primary mt-4" type="button" href="#"><i class="fas fa-sign-in-alt"></i>  Registrate</a>
                <p class="mt-5 mb-3 text-muted">Opeluce &copy; 2022</p>
            </form>
             <c:if test="${message != null}"> 
                                <div class="p-3 pb-md-4 mx-auto text-center alert alert-primary w-50" role="alert">
                                    <button type="button" class="close" data-dismiss="alert">&times;</button>
                                        <h3>Se requiere</h3>
                                        ${message}
                                </div>
                                     </c:if> 
                                
        </main>
    </body>
</html>

