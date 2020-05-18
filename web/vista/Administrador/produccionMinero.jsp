<%-- 
    Document   : produccionMinero
    Created on : 26/02/2020, 05:23:20 PM
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
        <title>Producción por Minero - Control Minero</title>

        <link href="../../lib/fontawesome/css/all.css" rel="stylesheet" type="text/css"/>
        <link href="../../lib/fontawesome/css/fontawesome.css" rel="stylesheet" type="text/css"/>
        <link href="../../lib/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="../../lib/bootstrap/css/dataTables.bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="../../css/dashboard.css" rel="stylesheet" type="text/css"/>
        <link href="../../css/DataTabla.css" rel="stylesheet" type="text/css"/>
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
            ArrayList<String> lista2 = faca.obtenerDatosMinero();

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
                        <li class="active"><a href="#"> <i class="fas fa-chart-line"></i> Producción de Mineros</a></li>
                        <li><a href="usuario.jsp"> <i class="fas fa-users"></i> Usuarios</a></li>
                    </ul>



                </div>
                <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
                    <h1 class="page-header">Módulo de Producción por Minero</h1>

                    <!-- Nav tabs -->
                    <ul class="nav nav-tabs" role="tablist">
                        <li role="presentation" class="active"><a href="#home" aria-controls="home" role="tab" data-toggle="tab">Administrador</a></li>
                    </ul>
                    <!-- Tab panes -->
                    <div class="tab-content">
                        <div role="tabpanel" class="tab-pane active" id="home">
                            <br>
                            <br>
                            <div class="row">
                                <div class="col-xs-6 col-md-4">
                                    <button type="submit" class="btn btn-warning btn-lg" href="#" data-toggle="modal" data-target="#myModal">Agregar Producción por Minero</button>
                                </div>
                            </div>
                            <h4>Listado de Producción por Mineros </h4>
                            <br>



                            <table id="example" class="table table-striped table-bordered table-responsive" style="width:100%">
                                <thead>
                                    <tr>
                                        <th>Nombre Minero</th>
                                        <th>Horario Turno</th>
                                        <th>Cantidad Producción</th>
                                        <th>Fecha de Producción</th>
                                        <th>Editar</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <%
                                        ArrayList<String> lista = faca.obtenerDatosProduccion();

                                        for (int i = 0; i < lista.size(); i++) {
                                            String dato1 = lista.get(i).toString();
                                            String[] dato2 = dato1.split("/");
                                    %>

                                    <tr>
                                        <td> <%=dato2[1]%> </td>
                                        <td> <%=dato2[2]%> </td>
                                        <td style="background-color: #82E0AA;"> <%=dato2[3]%> Toneladas</td>
                                        <td> <%=dato2[4]%> </td>
                                        <td><input type="button" class="btn btn-success" name="btnModificar" value="Editar" onclick="location.href = 'editarDatosProduccionMinero.jsp?idProduccion=<%=dato2[0]%>'"> </td>
                                    </tr>

                                    <% }%>
                                </tbody>
                            </table>
                            <div class="col-xs-6 col-md-4">

                                <p><a class="btn btn-info btn-lg" href="administrador.jsp" role="button"><i class="fas fa-chart-pie"></i>Ver Estadistica</a></p>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
        </div>

    </div>


    <!-- modal cerrar sesion -->
    <%@ include file="../HTML/modal_CerrarSesion.jsp" %> 
    <!-- modal Registro Exitoso -->
    <%@ include file="../HTML/modal_RegistroExitoso.jsp" %>
   
    <!-- modal Eliminado exitoso -->
    <%@ include file="../HTML/modal_EliminadoExitosamente.jsp" %>
    <!-- modal Error Registro-->
    <%@ include file="../HTML/modal_ErrorRegistro.jsp" %>

    <div class="modal fade" id="myModal" tabindex="-1" role="dialog">
        <div class="modal-dialog" role="document">
            <div class="modal-content">


                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h2 class="modal-title">Ventana de Registro</h2>
                </div>
                <div class="modal-body">

                    <div class="row">


                        <!-- cuadro de registro de la producción del minero-->
                        <form action="../../ServletRegistroProduccionMinero" class="form-horizontal" method="post">
                            <div id="Docente-Administrativo" class="marcoSeleccionado">
                                <br>
                                <h5> * Complete los campos para el Formulario: <span id="objRecivido"></span> </h5>

                                <div class="row">
                                    <div class="form-group">
                                        <label class="col-sm-5 control-label">Seleccione el nombre del Minero </label>
                                        <div class="col-lg-7">
                                            <select class="form-control"  name="nomMinero" required="">
                                                <option value="">seleccione cedula</option>
                                                <%
                                                    for (int i = 0; i < lista2.size(); i++) {
                                                        String dato1 = lista2.get(i).toString();
                                                        String dato22[] = dato1.split("/");
                                                %>
                                                <option><%=dato22[3]%></option>
                                                <% }%>
                                            </select>  
                                        </div>
                                    </div>

                                    <div class="form-group">

                                        <label class="col-sm-5 control-label">Horario de turno</label>

                                        <div class="col-lg-7">
                                            <select class="form-control"  name="turno" required="">
                                                <option value="">Seleccione</option>
                                                <option >Diurno</option>
                                                <option >Nocturno</option>
                                            </select> 
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <div class="col-lg-5">
                                            <input type="number" class="form-control" placeholder="Cantidad diaria de Produccion del minero en toneladas" 
                                                   name="cantProduccion" required="" minlength="1" maxlength="2">
                                        </div>
                                        <label  class="col-sm-3 control-label">Fecha de Registro:</label>
                                        <div class="col-lg-4">
                                            <input type="date" class="form-control"  name="fechaRegistro" required="">   
                                        </div>
                                    </div>
                                    <button type="submit" class="btn btn-primary" name="accion" value="agregarProMine">Registrar</button>
                                    <br/>
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
            <script src="../../js/script_Admin.js" type="text/javascript"></script>
            <script src="../../js/soloLetras.js" type="text/javascript"></script>
            </body>
            </html>

