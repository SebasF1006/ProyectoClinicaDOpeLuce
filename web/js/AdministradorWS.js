function administradorGet() {
    $.ajax({
        url: "http://localhost:8081/WebServidor/web/administrador/" + document.getElementById("idadministrador").value,
        dataType: "json",
        type: "get",
        success: function (data) {
            var body = "<ul><li>ID: ";
                body += data.idadministrador;
                body += "</li><li>DNI: ";
                body += data.dni_administrador;
                body += "</li><li>Nombre: ";
                body += data.nombres_administrador;
                body += "</li><li>apellido: ";
                body += data.apellidos_administrador;
                body += "</li><li>telefono: ";
                body += data.telefono_administrador;
                body += "</li><li>direccion: ";
                body += data.direccion_administrador;
                body += "</li><li>correo: ";
                body += data.correo_administrador;
                body += "</li><li>contra: ";
                body += data.password_administrador;
                body += "</li><li>nacimiento: ";
                body += data.fecha_nacimiento_administrador;
                body += "</li><li>edad: ";
                body += data.edad_administrador;

            body += "</li></ul>";
            $("#resultado").html(body);
        }
    });
}


function administradorSel() {
    $.ajax({
        url: "http://localhost:8081/WebServidor/web/administrador/",
        dataType: "json",
        type: "get",
        success: function (data) {
            var body = "<ul>";
            for (var i = 0; i < data.length; i++) {
                body += "<li>ID: ";
                body += data[i].idadministrador;
                body += "</li><li>DNI: ";
                body += data[i].dni_administrador;
                body += "</li><li>Nombre: ";
                body += data[i].nombres_administrador;
                body += "</li><li>apellido: ";
                body += data[i].apellidos_administrador;
                body += "</li><li>telefono: ";
                body += data[i].telefono_administrador;
                body += "</li><li>direccion: ";
                body += data[i].direccion_administrador;
                body += "</li><li>correo: ";
                body += data[i].correo_administrador;
                body += "</li><li>contra: ";
                body += data[i].password_administrador;
                body += "</li><li>nacimiento: ";
                body += data[i].fecha_nacimiento_administrador;
                body += "</li><li>edad: ";
                body += data[i].edad_administrador;
                body += "</li>";
            }
            body += "</ul>";
            $("#resultado").html(body);
        }
    });
}

function administradorIns() {
    var admin = {
        dni_administrador: $("#dni_administrador").val(),
        nombres_administrador: $("#nombres_administrador").val(),
        apellidos_administrador: $("#apellidos_administrador").val(),
        especialidad_administrador: $("#especialidad_administrador").val(),
        telefono_administrador: $("#telefono_administrador").val(),
        direccion_administrador: $("#direccion_administrador").val(),
        correo_administrador: $("#correo_administrador").val(),
        password_administrador: $("#password_administrador").val(),
        fecha_nacimiento_administrador: $("#fecha_nacimiento_administrador").val(),
        edad_administrador: $("#edad_administrador").val()
        
    };
    $.ajax({
        url: "http://localhost:8081/WebServidor/web/administrador/",
        dataType: "text",
        type: "post",
        headers: {
            'Content-Type': 'application/json'
        },
        success: function (data) {
            var body;
            if (data === 'OK')
                body = "Agregado";
            else
                body = "Error: " + data;
            $("#resultado").html(body);
        },
        data: JSON.stringify(admin)
    });
}

function administradorUpd() {
    var administrador = {
        idadministrador: $("#idadministrador").val(),
        dni_administrador: $("#dni_administrador").val(),
        nombres_administrador: $("#nombres_administrador").val(),
        apellidos_administrador: $("#apellidos_administrador").val(),
        especialidad_administrador: $("#especialidad_administrador").val(),
        telefono_administrador: $("#telefono_administrador").val(),
        direccion_administrador: $("#direccion_administrador").val(),
        correo_administrador: $("#correo_administrador").val(),
        password_administrador: $("#password_administrador").val(),
        fecha_nacimiento_administrador: $("#fecha_nacimiento_administrador").val(),
        edad_administrador: $("#edad_administrador").val()
    };
    $.ajax({
        url: "http://localhost:8081/WebServidor/web/administrador/",
        dataType: "text",
        type: "put",
        headers: {
            'Content-Type': 'application/json'
        },
        success: function (data) {
            var body;
            if (data === 'OK')
                body = "Actualizado";
            else
                body = "Error: " + data;
            $("#resultado").html(body);
        },
        data: JSON.stringify(administrador)
    });
    
}

function administradorDel() {
    $.ajax({
        url: "http://localhost:8081/WebServidor/web/administrador/" + document.getElementById("idadministrador").value,
        dataType: "text",
        type: "delete",
        success: function (data) {
            var body;
            if (data === 'OK')
                body = "eliminado";
            else
                body = "Error: " + data;
            $("#resultado").html(body);
        }
    });
    
}


