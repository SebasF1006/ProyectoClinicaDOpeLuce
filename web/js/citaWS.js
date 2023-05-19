function citaGet() {
    $.ajax({
        url: "http://localhost:8081/WebServidor/web/cita/" + document.getElementById("idcitas").value,
        dataType: "json",
        type: "get",
        success: function (data) {
            var body = "<ul><li>ID: ";
                body += data.idcita;
                body += "</li><li>ID paciente: ";
                body += data.idpacientes;
                body += "</li><li>ID doctor: ";
                body += data.iddoctor;
                body += "</li><li>Tipo de cita: ";
                body += data.tipo_cita;
                body += "</li><li>costo de cita: ";
                body += data.costo_cita;
                body += "</li><li>fecha de cita: ";
                body += data.fecha_cita;
                body += "</li><li>hora de cita: ";
                body += data.hora_cita;

            body += "</li></ul>";
            $("#resultado").html(body);
        }
    });
}


function citaSel() {
    $.ajax({
        url: "http://localhost:8081/WebServidor/web/cita/",
        dataType: "json",
        type: "get",
        success: function (data) {
            var body = "<ul>";
            for (var i = 0; i < data.length; i++) {
                body += "<li>ID: ";
                body += data[i].idcita;
                body += "</li><li>ID paciente: ";
                body += data[i].idpacientes;
                body += "</li><li>ID doctor: ";
                body += data[i].iddoctor;
                body += "</li><li>Tipo de cita: ";
                body += data[i].tipo_cita;
                body += "</li><li>costo de cita: ";
                body += data[i].costo_cita;
                body += "</li><li>fecha de cita: ";
                body += data[i].fecha_cita;
                body += "</li><li>hora de cita: ";
                body += data[i].hora_cita;
            }
            body += "</ul>";
            $("#resultado").html(body);
        }
    });
}

function citaIns() {
    var cita = {
        idpacientes: $("#idpacientes").val(),
        iddoctor: $("#iddoctor").val(),
        tipo_cita: $("#tipo_cita").val(),
        costo_cita: $("#costo_cita").val(),
        fecha_cita: $("#fecha_cita").val(),
        hora_cita: $("#hora_cita").val()
    };
    $.ajax({
        url: "http://localhost:8081/WebServidor/web/cita/",
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
        data: JSON.stringify(cita)
    });
}

function citaDel() {
    $.ajax({
        url: "http://localhost:8081/WebServidor/web/cita/" + document.getElementById("idcitas").value,
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
