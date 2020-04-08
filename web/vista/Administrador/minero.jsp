<%-- 
    Document   : minero
    Created on : 26/02/2020, 05:23:00 PM
    Author     : Manuel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>Minero - Control Minero</title>

        <link href="../../lib/fontawesome/css/all.css" rel="stylesheet" type="text/css"/>
        <link href="../../lib/fontawesome/css/fontawesome.css" rel="stylesheet" type="text/css"/>
        <link href="../../lib/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="../../lib/bootstrap/css/dataTables.bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="../../css/dashboard.css" rel="stylesheet" type="text/css"/>
        <link href="../../css/DataTabla.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>



        <nav class="navbar navbar-inverse navbar-fixed-top">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar"  aria-controls="navbar"></
                        <span class="sr-only">
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">Control de Transporte Minero</a>

                </div>
                <div id="navbar" class="navbar-collapse collapse">
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="#"> <span class="glyphicon glyphicon-home" aria-hidden="true"></span> Inicio</a></li>
                        <li>
                            <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" >
                                <span class="glyphicon glyphicon-menu-hamburger" aria-hidden="true"></span> Opciones <span class="caret"></span>
                            </button>
                            <ul class="dropdown-menu">
                                <li><a href="perfilAdministrador.jsp">Perfil</a></li>
                                <li class="divider"></li>
                                <li><a href="#" data-toggle="modal" data-target="#myModalCerrar">Cerrar Sesión</a></li>
                            </ul>
                        </li>
                    </ul>

                </div>
            </div>
        </nav>

        <div class="container-fluid">
            <div class="row">
                <div class="col-sm-3 col-md-2 sidebar">

                    <div class="opcAdmin">
                        <div>
                            <img src="../../img/logo2.png" width="130" height="130" class="img-responsive" alt="Img1">

                        </div>
                        <span class="col-md-12 userNombre"></span>
                        <div class="iconOpcAdmin">
                            <a> <span class="glyphicon glyphicon-cog" aria-hidden="true"></span> </a>
                            <a> <span class="glyphicon glyphicon-off" aria-hidden="true"></span> </a> 
                        </div>

                    </div>

                    <ul class="nav nav-sidebar">
                         <li><a href="administrador.jsp"> <span class="glyphicon glyphicon-home" aria-hidden="true"></span> Inicio</a></li>
                        <li><a href="conductor.jsp"> <i class="fas fa-address-card"></i> Conductores </a></li>
                        <li><a href="vehiculo.jsp"> <i class="fas fa-truck-moving"></i> Vehículos</a></li>
                        <li><a href="accidente.jsp"> <i class="fas fa-car-crash"></i> Accidentes</a></li>
                        <li><a href="fallaMecanica.jsp"> <span class="glyphicon glyphicon-scale" aria-hidden="true"></span> Fallas Mecánicas</a></li>
                        <li><a href="patio.jsp"> <i class="fas fa-route"></i> Patios de Descargue</a></li>
                        <li><a href="materialMinero.jsp"> <i class="fas fa-mountain"></i> Material Minero</a></li>
                        <li><a href="cargamento.jsp"> <i class="fas fa-truck-loading"></i> Cargamentos</a></li>
                        <li class="active"><a href="minero.jsp"> <i class="fas fa-user-cog"></i> Minero</a></li>
                        <li><a href="produccionMinero.jsp"> <i class="fas fa-chart-line"></i> Producción de Mineros</a></li>
                        <li><a href="usuario.jsp"> <i class="fas fa-users"></i> Usuarios</a></li>
                    </ul>



                </div>
                <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
                    <h1 class="page-header">Módulo de Minero</h1>



                    <!-- Nav tabs -->
                    <ul class="nav nav-tabs" role="tablist">
                        <li role="presentation" class="active"><a href="#home" aria-controls="home" role="tab" data-toggle="tab">Tabla Minero</a></li>
                        <li role="presentation"><a href="#profile" aria-controls="profile" role="tab" data-toggle="tab">Actualizar Minero</a></li>

                    </ul>

                    <div role="tabpanel" class="tab-pane active" id="home">
                        <br>
                        <br>
                         <div class="row">
                            <div class="col-xs-6 col-md-4">
                                <button type="submit" class="btn btn-warning btn-lg">Agregar Minero</button>
                            </div>
                        </div>
                        <br>
                        <h4>Listado de Mineros </h4>
                        <br>
                        
                      

                        <table id="example" class="table table-striped table-bordered table-responsive" style="width:100%">
                            <thead>
                                <tr>
                                    <th>Numero Documento</th>
                                    <th>Nombre</th>
                                    <th>Email</th>
                                    <th>Cargo</th>
                                    <th>Editar</th>
                                    <th>Borrar</th>
                                </tr>
                            </thead>
                            <tbody>
                               
                            </tbody>
                        </table>
                    </div>


                </div>
            </div>

        </div>
<div class="modal fade" id="myModal" tabindex="-1" role="dialog">
            <div class="modal-dialog" role="document">
                <div class="modal-content">


                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h2 class="modal-title">Ventana de Registro</h2>
                    </div>
                    <div class="modal-body">

                        <div class="row">


                            <!-- cuadro de registro del Usuario-->
                            <form action="Servlet_LoginRegistrar" class="form-horizontal" method="post">
                                <div id="Docente-Administrativo" class="marcoSeleccionado">
                                    <br>
                                    <h5> * Rellene Los Campos para el Formulario: <span id="objRecivido"></span> </h5>

                                    <div class="row">

                                        <input type="text" name="tipoUsuario2" id="objRecivido2" value="" style="visibility: hidden;">
                                        <div class="form-group">
                                            <label  class="col-sm-4 control-label">Tipo Documento:</label>
                                            <div class="col-lg-8">
                                                <select class="form-control"  name="TipoDocumentoUsu" required="">
                                                    <option value="">Seleccione</option>
                                                    <option >Cedula de Ciudadania</option>
                                                    <option >Documento de Ciudadano Extranjero</option>
                                                    <option >Permiso Especial de Permanencia</option>
                                                </select>
                                            </div>

                                        </div>

                                        <div class="form-group">
                                            <div class="col-lg-6">
                                                <input type="text" class="form-control" placeholder="Numero de Documento" name="numeroCedulaUsu" required="">
                                            </div>
                                            <div class="col-lg-6">
                                                <input type="text" class="form-control" placeholder="Telefono" name="telefonoUsu" required="">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-lg-6">
                                                <input type="text" class="form-control" name="NombresUsu" placeholder="Nombres" required="">
                                            </div>
                                            <div class="col-lg-6">
                                                <input type="text" class="form-control" name="ApellidosUsu" placeholder="Apellidos" required="">
                                            </div>
                                        </div>


                                        <div class="form-group">
                                            <div class="col-lg-12">
                                                <input type="email" class="form-control" placeholder="Correo Electronico" name="emailUsu" required="">
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <div class="col-lg-12">
                                                <input type="text" class="form-control" placeholder="Direccón" name="direccionUsu" required="">
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <div class="col-lg-6">
                                                <select class="form-control"  name="TipoSexoUsu" required="">
                                                    <option value="">Tipo Genero</option>
                                                    <option >Femenino</option>
                                                    <option >Masculino</option>
                                                </select>
                                            </div>
                                            <div class="col-lg-6">
                                                <input type="number" class="form-control" placeholder="Edad" name="edadUsu" min="1" max="120" required="">
                                            </div>
                                        </div>

                                        <div class="form-group">

                                            <div class="col-lg-12">
                                                <input type="text" class="form-control" placeholder="Digite su Cargo" name="cargoUsu" required="">
                                            </div>
                                        </div>


                                        <button type="submit" class="btn btn-primary" name="accion" value="agregarUsu">Registrar</button>
                                    </div>

                                </div>
                            </form>  
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>

                            </div>
                        </div><!-- /.modal-content -->
                    </div><!-- /.modal-dialog -->
                </div><!-- /.modal -->

        <script src="../../lib/fontawesome/js/all.js" type="text/javascript"></script>
        <script src="../../lib/jquery/jquery-3.3.1.js" type="text/javascript"></script>
        <script src="../../lib/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
        <script src="../../lib/bootstrap/js/dataTables.bootstrap.min.js" type="text/javascript"></script>
        <script src="../../lib/bootstrap/js/jquery.dataTables.min.js" type="text/javascript"></script>
        <script src="../../js/tabla.js" type="text/javascript"></script>
    </body>
</html>


