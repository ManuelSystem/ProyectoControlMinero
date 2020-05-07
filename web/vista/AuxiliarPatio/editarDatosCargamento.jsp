<%-- 
    Document   : editarDatosCargamento
    Created on : 23/04/2020, 07:04:18 PM
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
        <title>Editar Cargamento - Control Minero</title>

        <link href="../../lib/fontawesome/css/all.css" rel="stylesheet" type="text/css"/>
        <link href="../../lib/fontawesome/css/fontawesome.css" rel="stylesheet" type="text/css"/>
        <link href="../../lib/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="../../css/dashboard.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <script type="text/javascript">
            /* Funcion de total cargamento. */
            function PesoCargamento() {
                try {
                    var a = parseFloat(document.cargamento.pvacioo.value),
                            b = parseFloat(document.cargamento.pcargadoo.value);
                    document.cargamento.pnetoo.value = b - a;
                } catch (e) {
                }
            }


        </script>
        <%
            Facade faca = new Facade();
            String cedula = (String) session.getAttribute("parametroCodigo");
            String idCargamento = request.getParameter("idCargamento");

            ArrayList<String> datoSesion = faca.obtenerDatosPersona(cedula);
            String dato = datoSesion.toString().replace("[", "").replace("]", "");
            String[] sesion = dato.split("/");

            ArrayList<String> datosCarga = faca.obtenerDatosCargamentos(idCargamento);
            String dtAc = datosCarga.toString().replace("[", "").replace("]", "");
            String[] carga = dtAc.split("/");
            System.out.println("aqui tengo todos los datos" + datosCarga);

        %>

        <%            if (request.getParameter("mens") != null) { %>
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
                            <a> <span class="glyphicon glyphicon-cog" aria-hidden="true"></span> </a>
                            <a href="#" data-toggle="modal" data-target="#myModalCerrar"> <span class="glyphicon glyphicon-off" aria-hidden="true"></span> </a> 
                        </div>

                    </div>

                    <ul class="nav nav-sidebar">
                        <li class="active"><a href="cargamento.jsp"> <i class="fas fa-truck-loading"></i> Cargamentos</a></li>
                    </ul>

                </div>
                <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

                    <ol class="breadcrumb">
                        <li><a href="administrador.jsp">Inicio</a></li>
                        <li >Listado de Cargamentos</li>
                        <li class="active">Editar Cargamento</li>
                    </ol>

                    <h1 class="page-header">Actualización de Cargamento</h1>

                    <div class="row contenedorForms">

                        <form action="../../ServletRegistroCargamento" method="post" name="cargamento">
                            <div class="form-row">
                                <div class="form-group col-md-6">
                                    <label for="">Placa del vehículo</label>
                                    <input type="text" class="form-control" name="vehiculo"  value="<%=carga[1]%>" required="" readonly="">
                                </div>
                                <div class="form-group col-md-6">
                                    <label for="">Nombre del Conductor</label>
                                    <input type="text" class="form-control" name="conductor"  value="<%=carga[2]%>" required="" readonly="">
                                </div>
                            </div>

                            <div class="form-row">
                                <div class="form-group col-md-4">
                                    <label for="">Nombre del Material Minero</label>
                                    <input type="text" class="form-control" name="material"  value="<%=carga[3]%>" required="" readonly="">
                                </div>
                                <div class="form-group col-md-4">
                                    <label for="">Nombre del patio de Descargue</label>
                                    <input type="text" class="form-control" name="patio"  value="<%=carga[4]%>" required="" readonly="">
                                </div>
                                <div class="form-group col-md-4">
                                    <label for="">Fecha de Cargamento</label>
                                    <input type="date" class="form-control" name="fechaCarga"  value="<%=carga[8]%>" required="" >
                                </div>

                            </div>
                                <div class="form-row">
                                <div class="form-group col-md-4">
                                    <label for="">Peso del vehículo vacío</label>
                                    <input type="number" class="form-control" name="pvacioo"  value="<%=carga[5]%>" required="" 
                                          step="any" onchange="PesoCargamento();" onkeyup="PesoCargamento();">
                                </div>
                                <div class="form-group col-md-4">
                                    <label for="">peso del vehículo con carga</label>
                                    <input type="number" class="form-control" name="pcargadoo"  value="<%=carga[6]%>" required="" 
                                           step="any" onchange="PesoCargamento();" onkeyup="PesoCargamento();">
                                </div>
                                <div class="form-group col-md-4">
                                    <label for="">Peso Neto del cargamento</label>
                                    <input type="number" class="form-control" name="pnetoo"  value="<%=carga[7]%>" required="" 
                                         step="any"  readonly="">
                                </div>

                            </div>

                            <input type="text" class="form-control" name="idCargamentoInput" value="<%=idCargamento%>" style="visibility:hidden ">
                            <button type="submit" class="btn btn-primary" name="accion" value="actualizarCarga">Actualizar Cargamento</button>
                        </form>

                    </div>

                </div>
            </div>
        </div>

        <!-- modal Registro actualziado exitoso -->
        <%@ include file="../HTML/modal_ActualizacionExitosa.jsp" %> 
        <!-- modal cerrar sesion -->
        <%@ include file="../HTML/modal_CerrarSesion.jsp" %> 
        <!-- modal error registro-->
        <%@ include file="../HTML/modal_ErrorRegistro.jsp" %> 
        <script src="../../lib/fontawesome/js/all.js" type="text/javascript"></script>
        <script src="../../lib/jquery/jquery-3.3.1.js" type="text/javascript"></script>
        <script src="../../lib/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
        <script src="../../js/script_Admin.js" type="text/javascript"></script>
    </body>
</html>
