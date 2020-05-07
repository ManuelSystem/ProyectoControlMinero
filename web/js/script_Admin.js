/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {

    var valor = $("#obtInfo").val();
    var tipo2 = "'RegistroExitoso'";
    var tipo3 = "'ErrorRegistro'";
    var tipo4 = "'EliminadoExtitosamente'";
    var tipo5 = "'YaExiste'";
    var tipo6 = "'errorSistema'";
    var tipo7 = "'ActualizacionExitosa'";
    var tipo8 = "'MineroExistente'";

    if (valor == tipo2) {
        $("#RegistroExitoso").modal("show");
        setTimeout("$('#RegistroExitoso').modal('hide');", 3000);
    }
    if (valor == tipo3) {
        $("#ErrorRegistro").modal("show");
        setTimeout("$('#ErrorRegistro').modal('hide');", 3000);
    }
    if (valor == tipo6) {
        $("#errorSistema").modal("show");
        setTimeout("$('#errorSistema').modal('hide');", 3000);
    }
    if (valor == tipo4) {
        $("#EliminarExitoso").modal("show");
        setTimeout("$('#EliminarExitoso').modal('hide');", 3000);
    }
    if (valor == tipo5) {
        $("#YaExiste").modal("show");
        setTimeout("$('#YaExiste').modal('hide');", 3000);
    }
    if (valor == tipo7) {
        $("#ActualizacionExitosa").modal("show");
        setTimeout("$('#ActualizacionExitosa').modal('hide');", 3000);
    }
    if (valor == tipo8) {
        $("#MineroExistente").modal("show");
        setTimeout("$('#MineroExistente').modal('hide');", 3000);
    }


});

$(document).ready(function () {
    $('#example').DataTable({
        "bDeferRender": true,
        "sPaginationType": "full_numbers",
        "oLanguage": {
            "sProcessing": "Procesando...",
            "sLengthMenu": 'Mostrar <select>' +
                    '<option value="10">10</option>' +
                    '<option value="20">20</option>' +
                    '<option value="30">30</option>' +
                    '<option value="40">40</option>' +
                    '<option value="50">50</option>' +
                    '<option value="-1">All</option>' +
                    '</select> registros',
            "sZeroRecords": "No se encontraron resultados",
            "sEmptyTable": "Ningun dato disponible en esta tabla",
            "sInfo": "Mostrando del (_START_ al _END_) de un total de _TOTAL_ registros",
            "sInfoEmpty": "Mostrando del 0 al 0 de un total de 0 registros",
            "sInfoFiltered": "(filtrado de un total de _MAX_ registros)",
            "sInfoPostFix": "",
            "sSearch": "Buscar:",
            "sUrl": "",
            "sInfoThousands": ",",
            "sLoadingRecords": "Por favor espere - cargando...",
            "oPaginate": {
                "sFirst": "Primero",
                "sLast": "Ultimo",
                "sNext": "Siguiente",
                "sPrevious": "Anterior"
            },
            "oAria": {
                "sSortAscending": ": Activar para ordenar la columna de manera ascendente",
                "sSortDescending": ": Activar para ordenar la columna de manera descendente"
            }
        }
    });
});











