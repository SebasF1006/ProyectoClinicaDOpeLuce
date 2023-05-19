function doctorGet() {
    $.ajax({
        url: "http://localhost:8081/WebServidor/web/doctor/" + document.getElementById("iddoctor").value,
        dataType: "json",
        type: "get",
        success: function (data) {
            var body = "<ul><li>ID: ";
                body += data.iddoctor;
                body += "</li><li>DNI: ";
                body += data.dni_doctor;
                body += "</li><li>Nombre: ";
                body += data.nombres_doctor;
                body += "</li><li>apellido: ";
                body += data.apellidos_doctor;
                body += "</li><li>especialidad: ";
                body += data.especialidad_doctor;
                body += "</li><li>telefono: ";
                body += data.telefono_doctor;
                body += "</li><li>direccion: ";
                body += data.direccion_doctor;
                body += "</li><li>correo: ";
                body += data.correo_doctor;
                body += "</li><li>contra: ";
                body += data.password_doctor;
                body += "</li><li>nacimiento: ";
                body += data.fecha_nacimiento_doctor;
                body += "</li><li>edad: ";
                body += data.edad_doctor;

            body += "</li></ul>";
            $("#resultado").html(body);
        }
    });
}


function doctorSel() {
    $.ajax({
        url: "http://localhost:8081/WebServidor/web/doctor/",
        dataType: "json",
        type: "get",
        success: function (data) {
            var body = "<ul>";
            for (var i = 0; i < data.length; i++) {
                body += "<li>ID: ";
                body += data[i].iddoctor;
                body += "</li><li>DNI: ";
                body += data[i].dni_doctor;
                body += "</li><li>Nombre: ";
                body += data[i].nombres_doctor;
                body += "</li><li>apellido: ";
                body += data[i].apellidos_doctor;
                body += "</li><li>especialidad: ";
                body += data[i].especialidad_doctor;
                body += "</li><li>telefono: ";
                body += data[i].telefono_doctor;
                body += "</li><li>direccion: ";
                body += data[i].direccion_doctor;
                body += "</li><li>correo: ";
                body += data[i].correo_doctor;
                body += "</li><li>contra: ";
                body += data[i].password_doctor;
                body += "</li><li>nacimiento: ";
                body += data[i].fecha_nacimiento_doctor;
                body += "</li><li>edad: ";
                body += data[i].edad_doctor;
                body += "</li>";
            }
            body += "</ul>";
            $("#resultado").html(body);
        }
    });
}

function doctorIns() {
    var doctor = {
        dni_doctor: $("#dni_doctor").val(),
        nombres_doctor: $("#nombres_doctor").val(),
        apellidos_doctor: $("#apellidos_doctor").val(),
        especialidad_doctor: $("#especialidad_doctor").val(),
        telefono_doctor: $("#telefono_doctor").val(),
        direccion_doctor: $("#direccion_doctor").val(),
        correo_doctor: $("#correo_doctor").val(),
        password_doctor: $("#password_doctor").val(),
        fecha_nacimiento_doctor: $("#fecha_nacimiento_doctor").val(),
        edad_doctor: $("#edad_doctor").val()
        
    };
    $.ajax({
        url: "http://localhost:8081/WebServidor/web/doctor/",
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
        data: JSON.stringify(doctor)
    });
}

function doctorUpd() {
    var doctor = {
        iddoctor: $("#iddoctor").val(),
        dni_doctor: $("#dni_doctor").val(),
        nombres_doctor: $("#nombres_doctor").val(),
        apellidos_doctor: $("#apellidos_doctor").val(),
        especialidad_doctor: $("#especialidad_doctor").val(),
        telefono_doctor: $("#telefono_doctor").val(),
        direccion_doctor: $("#direccion_doctor").val(),
        correo_doctor: $("#correo_doctor").val(),
        password_doctor: $("#password_doctor").val(),
        fecha_nacimiento_doctor: $("#fecha_nacimiento_doctor").val(),
        edad_doctor: $("#edad_doctor").val()
    };
    $.ajax({
        url: "http://localhost:8081/WebServidor/web/doctor/",
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
        data: JSON.stringify(doctor)
    });
    
}

function doctorDel() {
    $.ajax({
        url: "http://localhost:8081/WebServidor/web/doctor/" + document.getElementById("iddoctor").value,
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