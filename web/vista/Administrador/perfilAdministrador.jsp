<%-- 
    Document   : administrador
    Created on : 15/03/2020, 04:43:36 PM
    Author     : manuel
--%>


<%@page import="FACADE.Facade"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>Administrador - Control de Transporte Minero</title>

        <link href="../../lib/fontawesome/css/all.css" rel="stylesheet" type="text/css"/>
        <link href="../../lib/fontawesome/css/fontawesome.css" rel="stylesheet" type="text/css"/>
        <link href="../../lib/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="../../css/dashboard.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%
            Facade faca = new Facade();
            String cedula = (String)session.getAttribute("parametroCodigo");
            ArrayList<String> datoSesion = faca.obtenerDatosPersona(cedula);
            String dato = datoSesion.toString().replace("[", "").replace("]", "");
            String[] sesion = dato.split("/");
        %>
        
        <%
            if (request.getParameter("mens") != null) { %>
                <input type="text" name="obtInfo" id="obtInfo" value="<%out.println(request.getParameter("mens")); %>" style="visibility: hidden"> <%
            }
        %>

        <nav class="navbar navbar-inverse navbar-fixed-top">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button onclick="" type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"  aria-controls="navbar">
                        <span class="sronly">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">Perfil del Administrador</a>

                </div>
                <div id="navbar" class="navbar-collapse collapse">
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="administrador.jsp"> <span class="glyphicon glyphicon-home" aria-hidden="true"></span> Inicio</a></li>
                        <li>
                            <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" >
                                <span class="glyphicon glyphicon-menu-hamburger" aria-hidden="true"></span> Opciones <span class="caret"></span>
                            </button>
                            <ul class="dropdown-menu">
                                <li><a href="#">Perfil</a></li>
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
                            <img src="../../img/userProfile.png" alt="userProf"/>
                        </div>
                        <span style="color: #ffb900; font-family: sans-serif; font-size: 16px;" class="col-md-12"> Bienvenido!</span>
                        <span style="color: #fff;" class="col-md-12 userNombre"><%=sesion[4]%></span>
                        <div class="iconOpcAdmin">
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
                        <li ><a href="minero.jsp"> <i class="fas fa-user-cog"></i> Minero</a></li>
                        <li><a href="produccionMinero.jsp"> <i class="fas fa-chart-line"></i> Producción de Mineros</a></li>
                        <li><a href="usuario.jsp"> <i class="fas fa-users"></i> Usuarios</a></li>
                    </ul>



                </div>
                <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
                    <h1 class="page-header">Perfil</h1>

                    <h4 class="">Estos sus Datos Personales:</h4>

                    <div class="row contenedorForms">

                        <form action="../../ServletAdministrador" method="post">
                            <div class="form-row">
                                <div class="form-group col-md-6">
                                    <label >Nombres</label>
                                    <input type="text" class="form-control" name="nombre" value="<%=sesion[3]%>" required="">
                                </div>
                                <div class="form-group col-md-6">
                                    <label >Apellidos</label>
                                    <input type="text" class="form-control" name="apellido" value="<%=sesion[4]%>" required="">
                                </div>
                            </div>

                            <div class="form-row">
                                <div class="form-group col-md-6">
                                    <label >Tipo Documento</label>
                                    <select class="form-control"  name="TipoDocumentoAdmin" required="">
                                        <option value="<%=sesion[1]%>">Seleccione</option>
                                        <option >Cedula de Ciudadania</option>
                                        <option >Documento de Ciudadano Extranjero</option>
                                        <option >Permiso Especial de Permanencia</option>
                                    </select>
                                </div>
                                <div class="form-group col-md-6">
                                    <label >N° Documento</label>
                                    <input type="text"  class="form-control" name="cedula" value="<%=sesion[2]%>" required="">
                                </div>
                            </div>

                            <div class="form-row">
                                <div class="form-group col-md-4">
                                    <label >Correo Electronico</label>
                                    <input type="email" class="form-control" name="email" value="<%=sesion[6]%>" required="">
                                </div>
                                <div class="form-group col-md-3">
                                    <label >Telefono</label>
                                    <input type="text" class="form-control" name="telefono" value="<%=sesion[5]%>" required="">
                                </div>
                                <div class="form-group col-md-5">
                                    <label >Dirección</label>
                                    <input type="text" class="form-control" name="direccion" value="<%=sesion[7]%>" required="">
                                </div>
                            </div>

                            <div class="form-row">
                                <div class="form-group col-md-3">
                                    <label >Sexo</label>
                                    <select class="form-control" name="TipoSexoAdmin" required="">
                                        <option value="<%=sesion[8]%>">Tipo Genero</option>
                                        <option >Femenino</option>
                                        <option >Masculino</option>
                                    </select>
                                </div>
                                <di class="form-group col-md-3">
                                    <label >Edad</label>
                                    <input type="number" class="form-control" name="edad" value="<%=sesion[9]%>" required="">
                                </di>
                                <div class="form-group col-md-3">
                                    <label >Usuario</label>
                                    <input type="text" class="form-control" name="user" value="<%=sesion[10]%>" required="">
                                </div>
                                <div class="form-group col-md-3">
                                    <label >Contraseña</label>
                                    <input type="text" class="form-control" name="password" value="<%=sesion[11]%>" required="">
                                </div>
                            </div>

                            <input type="text" class="col-md-12" name="idPersonaInput" value="<%=sesion[0]%>" style="visibility: hidden">
                            <button type="submit" class="btn btn-primary" name="accion" value="ActualizarAdministrador">Actualizar Datos</button>
                        </form>

                    </div>

                </div>
            </div>
        </div>
        <!-- modal cerrar sesion -->
        <%@ include file="../HTML/modal_CerrarSesion.jsp"%> 

        <%@ include file="../HTML/modal_Error.jsp"%> 

        <div class="modal fade" id="RegistroExitoso" tabindex="-1" role="dialog">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-body modalErrorUsuario">

                        <div class="row">

                            <div class="iconModalErrorUsuario">
                                <span class="glyphicon glyphicon-ok" aria-hidden="true"></span>
                            </div>
                            <p>¡Exito! - Registro completado</p>

                        </div>

                    </div>
                </div><!-- /.modal-content -->
            </div><!-- /.modal-dialog -->
        </div><!-- /.modal -->

        <script src="../../lib/jquery/jquery.min.js" type="text/javascript"></script>
        <script src="../../lib/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
        <script src="../../lib/bootstrap/js/npm.js" type="text/javascript"></script>
        <script src="../../js/script_Admin.js" type="text/javascript"></script>
    </body>
</html>
