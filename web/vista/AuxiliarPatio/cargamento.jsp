<%-- 
    Document   : cargamento
    Created on : 23/04/2020, 06:57:14 PM
    Author     : Manuel
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="FACADE.Facade"%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>Cargamento - Control Minero</title>

        <link href="../../lib/fontawesome/css/all.css" rel="stylesheet" type="text/css"/>
        <link href="../../lib/fontawesome/css/fontawesome.css" rel="stylesheet" type="text/css"/>
        <link href="../../lib/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="../../lib/bootstrap/css/dataTables.bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="../../css/dashboard.css" rel="stylesheet" type="text/css"/>
        <link href="../../css/DataTabla.css" rel="stylesheet" type="text/css"/>


    </head>
    <body>
        <script type="text/javascript">
            /* Funcion de total cargamento. */
            function RestarAutomatico() {
                try {
                    var a = parseFloat(document.cargamento.pvacio.value),
                            b = parseFloat(document.cargamento.pcargado.value);
                    document.cargamento.pneto.value = b - a;
                } catch (e) {
                }
            }


        </script>
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

            ArrayList<String> lista2 = faca.obtenerDatosConductor();
            ArrayList<String> listas = faca.obtenerDatosMaterial();
            ArrayList<String> listaPatios = faca.obtenerDatosPatio();
            String[] dato22;
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
                            <a href="#" data-toggle="modal" data-target="#myModalCerrar"><span class="glyphicon glyphicon-off" aria-hidden="true"></span> </a> 
                        </div>

                    </div>

                    <ul class="nav nav-sidebar">
                        <li class="active"><a href="#"> <i class="fas fa-truck-loading"></i> Cargamentos</a></li>
                    </ul>

                </div>
                <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
                    <h1 class="page-header">Módulo de Cargamentos</h1>

                    <!-- Nav tabs -->
                    <ul class="nav nav-tabs" role="tablist">
                        <li role="presentation" class="active"><a href="#home" aria-controls="home" role="tab" data-toggle="tab">Auxiliar de Patio</a></li>
                    </ul>
                    <!-- Tab panes -->
                    <div class="tab-content">
                        <div role="tabpanel" class="tab-pane active" id="home">
                            <br>
                            <br>
                            <div class="row">
                                <div class="col-xs-6 col-md-4">
                                    <button type="submit" class="btn btn-warning btn-lg" href="#" data-toggle="modal" data-target="#myModal">Agregar Cargamento</button>
                                </div>
                            </div>
                            <h4>Listado de Cargamentos </h4>
                            <br>
                            <table id="example" class="table table-striped table-bordered table-responsive" style="width:100%">
                                <thead>
                                    <tr>
                                        <th>Vehículo</th>
                                        <th>Conductor</th>
                                        <th>Patio</th>
                                        <th>Peso del vehículo Vacio</th>
                                        <th>Peso del vehículo Cargado</th>
                                        <th>Cargamento Neto</th>
                                        <th>Fecha de Cargamento</th>
                                        <th>Editar</th>
                                        <th>Borrar</th>
                                    </tr>
                                </thead>
                                <tbody>

                                    <%
                                        ArrayList<String> lista = faca.obtenerDatosCargamentos();

                                        for (int i = 0; i < lista.size(); i++) {
                                            String dato1 = lista.get(i).toString();
                                            String[] dato2 = dato1.split("/");
                                    %>

                                    <tr>
                                        <td> <%=dato2[1]%> </td>
                                        <td> <%=dato2[2]%> </td>
                                        <td> <%=dato2[4]%> </td>
                                        <td> <%=dato2[5]%> Toneladas</td>
                                        <td> <%=dato2[6]%> Toneladas</td>
                                        <td style="background-color: #82E0AA;"> <%=dato2[7]%> Toneladas</td>
                                        <td> <%=dato2[8]%> </td>
                                        <td><input type="button" class="btn btn-success" name="btnModificar" value="Editar" onclick="location.href = 'editarDatosCargamento.jsp?idCargamento=<%=dato2[0]%>'"> </td>
                                        <td><input type="button" class="btn btn-danger" name="btnEliminar" value="Eliminar" onclick="location.href = '../../ServletRegistroCargamento?idCargamento=<%=dato2[0]%>&&accion=eliminar'"> </td>
                                    </tr>

                                    <% }%>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>
    <!-- modal Eliminado exitoso -->
    <%@ include file="../HTML/modal_EliminadoExitosamente.jsp" %>
    <!-- modal cerrar sesion -->
    <%@ include file="../HTML/modal_CerrarSesion.jsp" %>
    <!-- modal Registro Exitoso -->
    <%@ include file="../HTML/modal_RegistroExitoso.jsp" %>

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


                        <!-- cuadro de registro del Usuario-->
                        <form action="../../ServletRegistroCargamento" class="form-horizontal" name="cargamento" method="post">
                            <div >
                                <br>
                                <h5> * Rellene Los Campos para el Formulario: <span id="objRecivido"></span> </h5>

                                <div class="row">
                                    <div class="form-group">

                                        <label class="col-sm-5 control-label">Seleccione Vehículo</label>

                                        <div class="col-lg-7">
                                            <select class="form-control"  name="vehiculo" required="">
                                                <option value="">seleccione placa del vehículo</option>
                                                <%
                                                    ArrayList<String> listaa = faca.obtenerDatosVehiculo();
                                                    for (int i = 0; i < listaa.size(); i++) {
                                                        String dato1 = listaa.get(i).toString();
                                                        String[] datoo = dato1.split("/");
                                                %>
                                                <option><%=datoo[4]%></option>
                                                <% }%>
                                            </select>  
                                        </div>
                                    </div>
                                    <div class="form-group">

                                        <label class="col-sm-5 control-label">Seleccione el conductor </label>

                                        <div class="col-lg-7">
                                            <select class="form-control"  name="nombreConductor" required="">
                                                <option value="">seleccione conductor</option>
                                                <%
                                                    for (int i = 0; i < lista2.size(); i++) {
                                                        String dato1 = lista2.get(i).toString();
                                                        dato22 = dato1.split("/");
                                                %>
                                                <option><%=dato22[3]%>  <%=dato22[4]%></option>
                                                <% }%>
                                            </select>  
                                        </div>
                                    </div>
                                    <div class="form-group">

                                        <label class="col-sm-5 control-label">Seleccione el nombre del Material Minero </label>

                                        <div class="col-lg-7">
                                            <select class="form-control"  name="material"  required="">
                                                <option value="">seleccione material minero</option>
                                                <%
                                                    for (int i = 0; i < listas.size(); i++) {
                                                        String dato11 = listas.get(i).toString();
                                                        dato22 = dato11.split("/");

                                                %>
                                                <option><%=dato22[2]%></option>
                                                <% }%>
                                            </select>  
                                        </div>
                                    </div>
                                    <div class="form-group">

                                        <label class="col-sm-5 control-label">Seleccione el nombre del Patio </label>

                                        <div class="col-lg-7">
                                            <select class="form-control"  name="patio"  required="">
                                                <option value="">seleccione Patio</option>
                                                <%
                                                    for (int i = 0; i < listaPatios.size(); i++) {
                                                        String datoP = listaPatios.get(i).toString();
                                                        dato22 = datoP.split("/");

                                                %>
                                                <option><%=dato22[2]%></option>
                                                <% }%>
                                            </select>  
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label  class="col-sm-5 control-label">Peso del Vehículo vacío</label>
                                        <div class="col-lg-7">
                                            <input type="number" class="form-control cargamento" placeholder="Digite el respectivo peso." name="pvacio" 
                                                   value="0" step="any"  aria-describedby="basic-addon2" required="" onchange="RestarAutomatico();" onkeyup="RestarAutomatico();"/>
                                            <span class="input-group-addon" id="basic-addon2">Tonelada</span>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label  class="col-sm-5 control-label">Peso del Vehículo Cargado</label>
                                        <div class="col-lg-7">
                                            <input type="number" class="form-control cargamento" placeholder="Digite el respectivo peso." name="pcargado" 
                                                     value="0"  step="any"  aria-describedby="basic-addon2" required="" onchange="RestarAutomatico();" onkeyup="RestarAutomatico();"/>
                                            <span class="input-group-addon" id="basic-addon2">Tonelada</span>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label  class="col-sm-5 control-label">Peso neto del Cargamento es:</label>
                                        <div class="col-lg-7">
                                            <input type="number" class="form-control cargamento" placeholder="Peso total." name="pneto" 
                                                   value="0" step="any" readonly=""  aria-describedby="basic-addon2" required=""  />
                                            <span class="input-group-addon" id="basic-addon2">Tonelada</span>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label  class="col-sm-5 control-label">Fecha del Cargamento</label>
                                        <div class="col-lg-7">
                                            <input type="date" class="form-control"  name="fechaRegistro" required="">   
                                        </div>
                                    </div>

                                    <button type="submit" class="btn btn-primary" name="accion" value="agregarCarga">Registrar</button>
                                    <br>
                                </div>
                                <br>
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
            </body>
            </html>