

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
        <title>Administrador - Control Minero</title>

        <link href="../../lib/fontawesome/css/all.css" rel="stylesheet" type="text/css"/>
        <link href="../../lib/fontawesome/css/fontawesome.css" rel="stylesheet" type="text/css"/>
        <link href="../../lib/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="../../css/dashboard.css" rel="stylesheet" type="text/css"/>
        <link href="../../css/reportes.css" rel="stylesheet">

    </head>
    <body>
<%
            Facade faca = new Facade();
            if (request.getParameter("mens") != null) { %>
        <input type="text" name="obtInfo" id="obtInfo" value="<%out.println(request.getParameter("mens")); %>" style="visibility: hidden;"> <%
            }
        %>
          <%
            String cedula = (String)session.getAttribute("parametroCodigo");
            
            ArrayList<String> datoSesion = faca.obtenerDatosPersona(cedula);
            String dato = datoSesion.toString().replace("[", "").replace("]", "");
            String[] sesion = dato.split("/");
           
        %>


        <nav class="navbar navbar-inverse navbar-fixed-top">
            <div class="container-fluid">
                <div class="navbar-header">
                    
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
                        <span style="color: #fff;" class="col-md-12 userNombre"><%=sesion[4] %></span>
                        <div class="iconOpcAdmin">
                            <a> <span class="glyphicon glyphicon-cog" aria-hidden="true"></span> </a>
                            <a href="#" data-toggle="modal" data-target="#myModalCerrar"> <span class="glyphicon glyphicon-off" aria-hidden="true"></span> </a> 
                        </div>
                        
                    </div>

                    <ul class="nav nav-sidebar">
                         <li class="active"><a href="administrador.jsp"> <span class="glyphicon glyphicon-home" aria-hidden="true"></span> Inicio</a></li>
                        <li><a href="conductor.jsp"> <i class="fas fa-address-card"></i> Conductores </a></li>
                        <li><a href="vehiculo.jsp"> <i class="fas fa-truck-moving"></i> Vehículos</a></li>
                        <li><a href="accidente.jsp"> <i class="fas fa-car-crash"></i> Accidentes</a></li>
                        <li><a href="fallaMecanica.jsp"> <span class="glyphicon glyphicon-scale" aria-hidden="true"></span> Fallas Mecánicas</a></li>
                        <li><a href="patio.jsp"> <i class="fas fa-route"></i> Patios de Descargue</a></li>
                        <li><a href="materialMinero.jsp"> <i class="fas fa-mountain"></i> Material Minero</a></li>
                        <li><a href="cargamento.jsp"> <i class="fas fa-truck-loading"></i> Cargamentos</a></li>
                        <li><a href="minero.jsp"> <i class="fas fa-user-cog"></i> Minero</a></li>
                        <li><a href="produccionMinero.jsp"> <i class="fas fa-chart-line"></i> Producción de Mineros</a></li>
                        <li><a href="usuario.jsp"> <i class="fas fa-users"></i> Usuarios</a></li>
                    </ul>



                </div>
                <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
                    <h1 class="page-header">Inicio de Administrador</h1>

                    <h4 class="">Reportes</h4>
                    <div class="row">
                    <!-- Tgenerar reporte conductores -->
                    <div class="col-xs-12 col-sm-6 col-md-4">
                        <div class="image-flip" ontouchstart="this.classList.toggle('hover');">
                            <div class="mainflip">
                                <div class="frontside">
                                    <div class="card">
                                        <div class="card-body text-center">
                                            <p class="iconoP"><i class="fas fa-address-card" aria-hidden="true"></i></p>
                                            <h4 class="card-title">Reporte Conductores</h4>
                                            <br>
                                            <a href="#" class="btn btn-danger btn-sm"><i class="fa fa-plus"></i></a>
                                        </div>
                                    </div>
                                </div>
                                <div class="backside">
                                    <div class="card">
                                        <div class="card-body text-center mt-4">
                                            <br>
                                            <h4 class="card-title">Reporte Conductores</h4>
                                            <br>
                                            <p class="card-text">Descarga para saber cuántos conductores hay registrados junto con sus datos</p>
                                            <br>
                                            <a href="aggCita.jsp?tipoCita=Medicina General" title="Descargar" class="btn btn-danger" >Descargar</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- generar reporte vehículos -->
                    <div class="col-xs-12 col-sm-6 col-md-4">
                        <div class="image-flip" ontouchstart="this.classList.toggle('hover');">
                            <div class="mainflip">
                                <div class="frontside">
                                    <div class="card">
                                        <div class="card-body text-center">
                                            <p class="iconoP"><i class="fas fa-truck-moving" aria-hidden="true"></i></p>
                                            <h4 class="card-title">Reporte Vehículos</h4>
                                            <br>
                                            <a href="#" class="btn btn-danger btn-sm"><i class="fa fa-plus"></i></a>
                                        </div>
                                    </div>
                                </div>
                                <div class="backside">
                                    <div class="card">
                                        <div class="card-body text-center mt-4">
                                            <br>
                                            <h4 class="card-title">Reporte de Vehículos</h4>
                                            <br>
                                            <p class="card-text">Descarga para saber cuántos conductores hay registrados junto con sus datos</p>
                                            <br>
                                            <a href="aggCita.jsp?tipoCita=Medicina General" title="Descargar" class="btn btn-danger" >Descargar</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- Generar reportes accidentes -->
                    <div class="col-xs-12 col-sm-6 col-md-4">
                        <div class="image-flip" ontouchstart="this.classList.toggle('hover');">
                            <div class="mainflip">
                                <div class="frontside">
                                    <div class="card">
                                        <div class="card-body text-center">
                                            <p class="iconoP"><i class="fas fa-car-crash" aria-hidden="true"></i></p>
                                            <h4 class="card-title">Reporte Accidentes</h4>
                                            <br>
                                            <a href="#" class="btn btn-danger btn-sm"><i class="fa fa-plus"></i></a>
                                        </div>
                                    </div>
                                </div>
                                <div class="backside">
                                    <div class="card">
                                        <div class="card-body text-center mt-4">
                                            <br>
                                            <h4 class="card-title">Reporte de Accidentes</h4>
                                            <br>
                                            <p class="card-text">Descarga para saber cuántos conductores hay registrados junto con sus datos</p>
                                            <br>
                                            <a href="aggCita.jsp?tipoCita=Medicina General" title="Descargar" class="btn btn-danger" >Descargar</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                   
                    <!-- generar reportes fallas mecanicas -->
                    <div class="col-xs-12 col-sm-6 col-md-4">
                        <div class="image-flip" ontouchstart="this.classList.toggle('hover');">
                            <div class="mainflip">
                                <div class="frontside">
                                    <div class="card">
                                        <div class="card-body text-center">
                                            <p class="iconoP"><i class="glyphicon glyphicon-scale" aria-hidden="true"></i></p>
                                            <h4 class="card-title">Reporte de Fallas Mecánicas</h4>
                                            <br>
                                            <a href="#" class="btn btn-danger btn-sm"><i class="fa fa-plus"></i></a>
                                        </div>
                                    </div>
                                </div>
                                <div class="backside">
                                    <div class="card">
                                        <div class="card-body text-center mt-4">
                                            <br>
                                            <h4 class="card-title">Reporte Fallas Mecánicas</h4>
                                            <br>
                                            <p class="card-text">Descarga para saber cuántos conductores hay registrados junto con sus datos</p>
                                            <br>
                                            <a href="aggCita.jsp?tipoCita=Medicina General" title="Descargar" class="btn btn-danger" >Descargar</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- generar reportes patios de descargue -->
                    <div class="col-xs-12 col-sm-6 col-md-4">
                        <div class="image-flip" ontouchstart="this.classList.toggle('hover');">
                            <div class="mainflip">
                                <div class="frontside">
                                    <div class="card">
                                        <div class="card-body text-center">
                                            <p class="iconoP"><i class="fas fa-route" aria-hidden="true"></i></p>
                                            <h4 class="card-title">Reporte Patios de Descargue</h4>
                                            <br>
                                            <a href="#" class="btn btn-danger btn-sm"><i class="fa fa-plus"></i></a>
                                        </div>
                                    </div>
                                </div>
                                <div class="backside">
                                    <div class="card">
                                        <div class="card-body text-center mt-4">
                                            <br>
                                            <h4 class="card-title">Reporte de Patios de Descargue</h4>
                                            <br>
                                            <p class="card-text">Descarga para saber cuántos conductores hay registrados junto con sus datos</p>
                                            <br>
                                            <a href="aggCita.jsp?tipoCita=Medicina General" title="Descargar" class="btn btn-danger" >Descargar</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- generar reportes material minero -->
                    <div class="col-xs-12 col-sm-6 col-md-4">
                        <div class="image-flip" ontouchstart="this.classList.toggle('hover');">
                            <div class="mainflip">
                                <div class="frontside">
                                    <div class="card">
                                        <div class="card-body text-center">
                                            <p class="iconoP"><i class="fas fa-mountain" aria-hidden="true"></i></p>
                                            <h4 class="card-title">Reporte Material Minero</h4>
                                            <br>
                                            <a href="#" class="btn btn-danger btn-sm"><i class="fa fa-plus"></i></a>
                                        </div>
                                    </div>
                                </div>
                                <div class="backside">
                                    <div class="card">
                                        <div class="card-body text-center mt-4">
                                            <br>
                                            <h4 class="card-title">Reporte de Material Minero</h4>
                                            <br>
                                            <p class="card-text">Descarga para saber cuántos conductores hay registrados junto con sus datos</p>
                                            <br>
                                            <a href="aggCita.jsp?tipoCita=Medicina General" title="Descargar" class="btn btn-danger" >Descargar</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- generar reportes cargamentos -->
                    <div class="col-xs-12 col-sm-6 col-md-4">
                        <div class="image-flip" ontouchstart="this.classList.toggle('hover');">
                            <div class="mainflip">
                                <div class="frontside">
                                    <div class="card">
                                        <div class="card-body text-center">
                                            <p class="iconoP"><i class="fas fa-truck-loading" aria-hidden="true"></i></p>
                                            <h4 class="card-title">Reporte Cargamentos</h4>
                                            <br>
                                            <a href="#" class="btn btn-danger btn-sm"><i class="fa fa-plus"></i></a>
                                        </div>
                                    </div>
                                </div>
                                <div class="backside">
                                    <div class="card">
                                        <div class="card-body text-center mt-4">
                                            <br>
                                            <h4 class="card-title">Reporte de Cargamentos</h4>
                                            <br>
                                            <p class="card-text">Descarga para saber cuántos conductores hay registrados junto con sus datos</p>
                                            <br>
                                            <a href="aggCita.jsp?tipoCita=Medicina General" title="Descargar" class="btn btn-danger" >Descargar</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- generar reportes mineros -->
                    <div class="col-xs-12 col-sm-6 col-md-4">
                        <div class="image-flip" ontouchstart="this.classList.toggle('hover');">
                            <div class="mainflip">
                                <div class="frontside">
                                    <div class="card">
                                        <div class="card-body text-center">
                                            <p class="iconoP"><i class="fas fa-hard-hat" aria-hidden="true"></i></p>
                                            <h4 class="card-title">Reporte Mineros</h4>
                                            <br>
                                            <a href="#" class="btn btn-danger btn-sm"><i class="fa fa-plus"></i></a>
                                        </div>
                                    </div>
                                </div>
                                <div class="backside">
                                    <div class="card">
                                        <div class="card-body text-center mt-4">
                                            <br>
                                            <h4 class="card-title">Reporte de Mineros</h4>
                                            <br>
                                            <p class="card-text">Descarga para saber cuántos conductores hay registrados junto con sus datos</p>
                                            <br>
                                            <a href="aggCita.jsp?tipoCita=Medicina General" title="Descargar" class="btn btn-danger" >Descargar</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div> 
                    <!-- generar reportes produccion por mineros -->
                    <div class="col-xs-12 col-sm-6 col-md-4">
                        <div class="image-flip" ontouchstart="this.classList.toggle('hover');">
                            <div class="mainflip">
                                <div class="frontside">
                                    <div class="card">
                                        <div class="card-body text-center">
                                            <p class="iconoP"><i class="fas fa-chart-line" aria-hidden="true"></i></p>
                                            <h4 class="card-title">Reporte Producción por Mineros</h4>
                                            <br>
                                            <a href="#" class="btn btn-danger btn-sm"><i class="fa fa-plus"></i></a>
                                        </div>
                                    </div>
                                </div>
                                <div class="backside">
                                    <div class="card">
                                        <div class="card-body text-center mt-4">
                                            <br>
                                            <h4 class="card-title">Reporte de Producción por Mineros</h4>
                                            <br>
                                            <p class="card-text">Descarga para saber cuántos conductores hay registrados junto con sus datos</p>
                                            <br>
                                            <a href="aggCita.jsp?tipoCita=Medicina General" title="Descargar" class="btn btn-danger" >Descargar</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div> 
                    
                </div>

                   
            </div>

        </div>

        <script src="../../lib/jquery/jquery.min.js" type="text/javascript"></script>
        <script src="../../lib/fontawesome/js/all.js" type="text/javascript"></script>
        <script src="../../lib/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>

    </body>
</html>
