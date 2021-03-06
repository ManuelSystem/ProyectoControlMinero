<%-- 
    Document   : editarDatosAuxiliar
    Created on : 10/03/2020, 06:19:32 PM
    Author     : Manuel
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="FACADE.Facade"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>Editar Usuario - Control Minero</title>

        <link href="../../lib/fontawesome/css/all.css" rel="stylesheet" type="text/css"/>
        <link href="../../lib/fontawesome/css/fontawesome.css" rel="stylesheet" type="text/css"/>
        <link href="../../lib/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="../../css/dashboard.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
       <%
            Facade faca = new Facade();
            String cedula = (String)session.getAttribute("parametroCodigo");
            String idPersona = request.getParameter("idPersona");
            String idAuxiliar = request.getParameter("idAuxiliar");
            
            ArrayList<String> datoSesion = faca.obtenerDatosPersona(cedula);
            String dato = datoSesion.toString().replace("[", "").replace("]", "");
            String[] sesion = dato.split("/");
            
            ArrayList<String> datosAuxi = faca.obtenerDatosAuxiliar(idPersona, idAuxiliar);
            String dtAu= datosAuxi.toString().replace("[", "").replace("]", "");
            String[] auxi = dtAu.split("/");
        %>
        
        <%
            if (request.getParameter("mens") != null) { %>
                <input type="text" name="obtInfo" id="obtInfo" value="<%out.println(request.getParameter("mens")); %>" style="visibility: hidden"> <%
            }
        %>


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
                        <span style="color: #ffb900; font-family: sans-serif; font-size: 16px;" class="col-md-12"> Bienvenido!</span>
                        <span style="color: #fff;" class="col-md-12 userNombre"><%=sesion[4]%></span>
                        <div class="iconOpcAdmin">
                            <a href="#" data-toggle="modal" data-target="#myModalCerrar"> <span class="glyphicon glyphicon-off" aria-hidden="true"></span> </a> 
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
                        <li><a href="minero.jsp"> <i class="fas fa-user-cog"></i> Minero</a></li>
                        <li><a href="produccionMinero.jsp"> <i class="fas fa-chart-line"></i> Producción de Mineros</a></li>
                        <li class="active"><a href="usuario.jsp"> <i class="fas fa-users"></i> Usuarios</a></li>
                    </ul>

                </div>
                <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

                    <ol class="breadcrumb">
                        <li><a href="administrador.jsp">Inicio</a></li>
                        <li >Listado usuario Auxiliar</li>
                        <li class="active">Editar Auxiliar</li>
                    </ol>

                    <h1 class="page-header">Actualización del Auxiliar</h1>

                    <h4 class="">Datos del Auxiliar de Patio Seleccionado:</h4>

                    <div class="row contenedorForms">
                        <form action="../../ServletRegistroAuxi" method="post">

                            <div class="form-row">
                                <div class="form-group col-md-6">
                                    <label for="">Nombres</label>
                                    <input type="text" class="form-control" name="NombresUsu" placeholder="Tu Nombre" value="<%=auxi[3] %>" required="">
                                </div>
                                <div class="form-group col-md-6">
                                    <label for="">Apellidos</label>
                                    <input type="text" class="form-control" name="ApellidosUsu" placeholder="Tu Apellido" value="<%=auxi[4] %>" required="">
                                </div>
                            </div>

                            <div class="form-row">
                                 <div class="form-group col-md-6">
                                            <label for="">Tipo Documento</label>
                                            <input type="text" class="form-control" name="TipoDocumentoUsu" value="<%=auxi[1] %>" required="" readonly="">
                                        </div>
                                <div class="form-group col-md-6">
                                    <label for="">N° Documento</label>
                                    <input type="text" class="form-control" name="numeroCedulaUsu" placeholder="Tu Nombre" value="<%=auxi[2] %>" required="" readonly="">
                                </div>
                            </div>

                            <div class="form-row">
                                <div class="form-group col-md-3">
                                    <label for="">Telefono</label>
                                    <input type="text" class="form-control" name="telefonoUsu" placeholder="Tu Telefono" value="<%=auxi[5] %>" required="">
                                </div>
                                <div class="form-group col-md-4">
                                    <label for="">Correo Electronico</label>
                                    <input type="email" class="form-control" name="emailUsu" placeholder="Tu Cooreo Electronico" value="<%=auxi[6] %>" required="">
                                </div>
                                <div class="form-group col-md-5">
                                    <label for="">Dirección Casa</label>
                                    <input type="text" class="form-control" name="direccionUsu" placeholder="Tu Direccion" value="<%=auxi[7] %>" required="">
                                </div>
                            </div>

                            <div class="form-row">
                                <div class="form-group col-md-4">
                                    <label for="">Sexo</label>
                                    <input type="text" class="form-control"  name="TipoSexoUsu"  value="<%=auxi[8] %>" required="">
                                        
                                </div>
                                <div class="form-group col-md-4">
                                    <label for="">Edad</label>
                                    <input type="number" class="form-control" placeholder="Edad" name="edadUsu" min="1" max="120" value="<%=auxi[9] %>"required="">
                                </div>
                                <div class="form-group col-md-4">
                                    <label for="">Fecha Registro</label>
                                    <input type="date" class="form-control" placeholder="" name="fechaRegistro" value="<%=auxi[15] %>" required="">
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="form-group col-md-6">
                                    <label for="">Usuario</label>
                                    <input type="text" class="form-control" name="usarioAuxi" placeholder="Tu Usuario" value="<%=auxi[10] %>"required="">
                                </div>
                                <div class="form-group col-md-6">
                                    <label for="">Contraseña</label>
                                    <input type="text" class="form-control" name="passwordAuxi" placeholder="Tu password" value="<%=auxi[11] %>" required="">
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="form-group col-md-12">
                                    <label for="">Descripción:</label>
                                    <input type="text" class="form-control" placeholder="Breve Descripción de Operación" name="DescripcionOperaUsu" value="<%=auxi[14] %>"required="">
                                </div>
                            </div>
                            <input type="text" class="form-control" name="idPersonaInput" value="<%=idPersona %>" style="visibility:hidden ">
                            <input type="text" class="form-control" value="<%=idAuxiliar %>" name="idAuxiInput" required="" style="visibility:hidden">
                            <button type="submit" class="btn btn-primary" name="accion" value="actualizarAuxiliar">Actualizar Auxiliar</button>
                        </form>

                    </div>

                </div>
            </div>
        </div>
    <!-- modal cerrar sesion -->
    <%@ include file="../HTML/modal_CerrarSesion.jsp" %> 
    <%@ include file="../HTML/modal_ErrorRegistro.jsp" %> 
    <!-- modal Registro exitoso -->
    <%@ include file="../HTML/modal_RegistroExitoso.jsp" %> 
    <!-- modal Registro exitoso -->
    <%@ include file="../HTML/modal_ActualizacionExitosa.jsp" %> 


    <script src="../../lib/fontawesome/js/all.js" type="text/javascript"></script>
    <script src="../../lib/jquery/jquery-3.3.1.js" type="text/javascript"></script>
    <script src="../../lib/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="../../js/script_Admin.js" type="text/javascript"></script>
</body>
</html>