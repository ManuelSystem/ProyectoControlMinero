/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function(){
  
    var valor = $("#obtInfo").val();
    var tipo = "'Usuario Incorrecto'";
    var tipo2 = "'ErrorRegistro'";
    var tipo3 = "'RegistroExitoso'";
    
    if(valor == tipo){
        $("#errorUsuario").modal("show");
        setTimeout("$('#errorUsuario').modal('hide');", 3000);
    }
    if(valor == tipo2){
        $("#errorSistema").modal("show");
        setTimeout("$('#errorSistema').modal('hide');", 3000);
    }
    if(valor == tipo3){
        $("#RegistroExitoso").modal("show");
        setTimeout("$('#RegistroExitoso').modal('hide');", 9000);
    }

    
  
});


