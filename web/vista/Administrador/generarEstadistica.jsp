<%-- 
    Document   : generarEstadistica
    Created on : 2/05/2020, 08:46:20 AM
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
        <title>Administrador - Control Minero</title>

        <link href="../../lib/fontawesome/css/all.css" rel="stylesheet" type="text/css"/>
        <link href="../../lib/fontawesome/css/fontawesome.css" rel="stylesheet" type="text/css"/>
        <link href="../../lib/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="../../css/dashboard.css" rel="stylesheet" type="text/css"/>
        <link href="../../morris/morris.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%
            Facade faca = new Facade();
            if (request.getParameter("mens") != null) { %>
        <input type="text" name="obtInfo" id="obtInfo" value="<%out.println(request.getParameter("mens")); %>" style="visibility: hidden;"> <%
            }
        %>
        <%
            String cedula = (String) session.getAttribute("parametroCodigo");

            ArrayList<String> datoSesion = faca.obtenerDatosPersona(cedula);
            String dato = datoSesion.toString().replace("[", "").replace("]", "");
            String[] sesion = dato.split("/");

            ArrayList<String> conteoConductores = faca.obtenereValores();
            String conduc = conteoConductores.toString().replace("[", "").replace("]", "").replace("/", "");

            ArrayList<String> conteoVehiculo = faca.obtenerValoresVehi();
            String vehi = conteoVehiculo.toString().replace("[", "").replace("]", "").replace("/", "");

            ArrayList<String> conteoAccidente = faca.obtenerValoresAcci();
            String acci = conteoAccidente.toString().replace("[", "").replace("]", "").replace("/", "");

            ArrayList<String> conteofalla = faca.obtenerValoresFalla();
            String falla = conteofalla.toString().replace("[", "").replace("]", "").replace("/", "");
            
             ArrayList<String> conteoPatio = faca.obtenerValoresPatio();
            String patio = conteoPatio.toString().replace("[", "").replace("]", "").replace("/", "");
            
            ArrayList<String> conteoMinero = faca.obtenerValoresMinero();
            String minero = conteoMinero.toString().replace("[", "").replace("]", "").replace("/", "");
        %>


        <nav class="navbar navbar-inverse navbar-fixed-top">
            <div class="container-fluid">
                <div class="navbar-header">

                    <a class="navbar-brand" href="#">Control de Transporte Minero</a>

                </div>
                <div id="navbar" class="navbar-collapse collapse">
                    <ul class="nav navbar-nav navbar-right">
                        <li>
                            <a>
                                <span style="color: #000; font-family: sans-serif; font-size: 16px;" class="col-md-12"> Bienvenido!<span style="color:#fff"> <%=sesion[4]%></span></span>
                            </a>
                        </li>
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

        <div class="col-sm-12 ">
            <h1 class="page-header">Visualización de estadistica</h1>

            <h4 class="">A continuación podrá observar el número de registros que hay de cada módulo.</h4>
            <div class="row">
                <!-- Generar graficas -->
                <div id="chart"></div>
                <div class="col-xs-6 col-md-4">
                    <p><a class="btn btn-info btn-lg" href="administrador.jsp" role="button"><i class="fas fa-arrow-left"></i>Volver</a></p>
                </div>
                <div class="form-group">
                    <div class="col-md-1">
                        <input type="number" class="form-control" id="nuConductores" value="<%=conduc%>" style="visibility:hidden ">
                    </div>
                    <div class="col-md-1">
                        <input type="number" class="form-control" id="nuVehiculos" value="<%=vehi%>" style="visibility:hidden ">
                    </div>
                    <div class="col-md-1">
                        <input type="number" class="form-control" id="nuAccidentes" value="<%=acci%>" style="visibility:hidden ">
                    </div>
                    <div class="col-md-1">
                        <input type="number" class="form-control" id="nuFallas" value="<%=falla%>" style="visibility:hidden ">
                    </div>
                    <div class="col-md-1">
                        <input type="number" class="form-control" id="nuPatios" value="<%=patio%>" style="visibility:hidden ">
                    </div>
                    <div class="col-md-1">
                        <input type="number" class="form-control" id="nuMineros" value="<%=minero%>" style="visibility:hidden ">
                    </div>
                </div>
            </div>


        </div>
        <!-- modal cerrar sesion -->
        <%@ include file="../HTML/modal_CerrarSesion.jsp" %>

        <script src="../../lib/jquery/jquery.min.js" type="text/javascript"></script>
        <script src="../../lib/fontawesome/js/all.js" type="text/javascript"></script>
        <script src="../../lib/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.0/jquery.min.js"></script>
        <script src="http://cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script>
        <script src="../../morris/morris.min.js" type="text/javascript"></script>
        <script src="../../js/estadistica.js" type="text/javascript"></script>
    </body>
</html>
