function pacienteGet() {
    $.ajax({
        url: "http://localhost:8081/WebServidor/web/paciente/" + document.getElementById("idpacientes").value,
        dataType: "json",
        type: "get",
        success: function (data) {
            var body = "<ul><li>ID: ";
                body += data.idpacientes;
                body += "</li><li>DNI: ";
                body += data.dni_paciente;
                body += "</li><li>Nombre: ";
                body += data.nombres_paciente;
                body += "</li><li>apellido: ";
                body += data.apellidos_paciente;
                body += "</li><li>telefono: ";
                body += data.telefono_paciente;
                body += "</li><li>direccion: ";
                body += data.direccion_paciente;
                body += "</li><li>correo: ";
                body += data.correo_paciente;
                body += "</li><li>contra: ";
                body += data.password_paciente;
                body += "</li><li>nacimiento: ";
                body += data.fecha_nacimiento_paciente;
                body += "</li><li>edad: ";
                body += data.edad_paciente;

            body += "</li></ul>";
            $("#resultado").html(body);
        }
    });
}


function pacienteSel() {
    $.ajax({
        url: "http://localhost:8081/WebServidor/web/paciente/",
        dataType: "json",
        type: "get",
        success: function (data) {
            var body = "<ul>";
            for (var i = 0; i < data.length; i++) {
                body += "<li>ID: ";
                body += data[i].idpacientes;
                body += "</li><li>DNI: ";
                body += data[i].dni_paciente;
                body += "</li><li>Nombre: ";
                body += data[i].nombres_paciente;
                body += "</li><li>apellido: ";
                body += data[i].apellidos_paciente;
                body += "</li><li>telefono: ";
                body += data[i].telefono_paciente;
                body += "</li><li>direccion: ";
                body += data[i].direccion_paciente;
                body += "</li><li>correo: ";
                body += data[i].correo_paciente;
                body += "</li><li>contra: ";
                body += data[i].password_paciente;
                body += "</li><li>nacimiento: ";
                body += data[i].fecha_nacimiento_paciente;
                body += "</li><li>edad: ";
                body += data[i].edad_paciente;
                body += "</li>";
            }
            body += "</ul>";
            $("#resultado").html(body);
        }
    });
}

function pacienteIns() {
    var pac = {
        dni_paciente: $("#dni_paciente").val(),
        nombres_paciente: $("#nombres_paciente").val(),
        apellidos_paciente: $("#apellidos_paciente").val(),
        especialidad_paciente: $("#especialidad_paciente").val(),
        telefono_paciente: $("#telefono_paciente").val(),
        direccion_paciente: $("#direccion_paciente").val(),
        correo_paciente: $("#correo_paciente").val(),
        password_paciente: $("#password_paciente").val(),
        fecha_nacimiento_paciente: $("#fecha_nacimiento_paciente").val(),
        edad_paciente: $("#edad_paciente").val()
        
    };
    $.ajax({
        url: "http://localhost:8081/WebServidor/web/paciente/",
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
        data: JSON.stringify(pac)
    });
}

function pacienteUpd() {
    var paciente = {
        idpaciente: $("#idpacientes").val(),
        dni_paciente: $("#dni_paciente").val(),
        nombres_paciente: $("#nombres_paciente").val(),
        apellidos_paciente: $("#apellidos_paciente").val(),
        especialidad_paciente: $("#especialidad_paciente").val(),
        telefono_paciente: $("#telefono_paciente").val(),
        direccion_paciente: $("#direccion_paciente").val(),
        correo_paciente: $("#correo_paciente").val(),
        password_paciente: $("#password_paciente").val(),
        fecha_nacimiento_paciente: $("#fecha_nacimiento_paciente").val(),
        edad_paciente: $("#edad_paciente").val()
    };
    $.ajax({
        url: "http://localhost:8081/WebServidor/web/paciente/",
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
        data: JSON.stringify(paciente)
    });
    
}

function pacienteDel() {
    $.ajax({
        url: "http://localhost:8081/WebServidor/web/paciente/" + document.getElementById("idpacientes").value,
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


