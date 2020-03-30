<%-- 
    Document   : index
    Created on : 22/02/2020, 11:44:57 AM
    Author     : Manuel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=0.4">
        <title>Control de Minas</title>

        <!-- estilos css -->
        <link href="lib/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css"/> 
        <link href="css/estilos.css" rel="stylesheet" type="text/css"/>

    </head>
    <body>

        <div class="main">
            <%
                 if (request.getParameter("mens") != null) { %>
            <input type="text" name="obtInfo" id="obtInfo" value="<%out.println(request.getParameter("mens")); %>" style="visibility: hidden"> <%
                }
            %>
            <div class="container-fluid">

                <div class="row">

                    <div class="col-md-6">

                        <div class="formulario">
                            <h2>Iniciar Sesión</h2>
                            <form method="post" id="" action="Servelet_login">
                                <div class="form-group">

                                    <div class="row">
                                        <div class="col-md-2">
                                            <span class="glyphicon glyphicon-user" aria-hidden="true"></span>
                                        </div>
                                        <div class="col-md-10">
                                            <input type="text" class="form-control" name="user" placeholder="Usuario">
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">

                                    <div class="row">
                                        <div class="col-md-2">
                                            <span class="glyphicon glyphicon-lock" aria-hidden="true"></span>
                                        </div>
                                        <div class="col-md-10">
                                            <input type="password" class="form-control" name="password" placeholder="password">
                                        </div>
                                    </div>
                                </div>

                                <button type="submit" class="btn btn-warning btn-lg" name="accion" value="login">Ingresar</button>
                            </form>
                        </div>

                    </div>

                    <div class="col-md-6 ">
                        <div class="image center-block">
                            <img src="img/logo.png" class="img-responsive center-block imgLogo">
                        </div>
                    </div>

                </div>

            </div>

        </div>
        <div class="modal fade" id="errorUsuario" tabindex="-1" role="dialog">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-body modalErrorUsuario">

                        <div class="row">

                            <div class="iconModalErrorUsuario">
                                <span class="glyphicon glyphicon-remove-circle" aria-hidden="true"></span>
                            </div>
                            <p>¡ERROR! - Este Usuario No Existe o No Se Encuentra Registrado</p>

                        </div>

                    </div>
                </div><!-- /.modal-content -->
            </div><!-- /.modal-dialog -->
        </div><!-- /.modal -->
        <div class="modal fade" id="errorSistema" tabindex="-1" role="dialog">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-body modalErrorUsuario">

                        <div class="row">

                            <div class="iconModalErrorUsuario">
                                <span class="glyphicon glyphicon-remove-circle" aria-hidden="true"></span>
                            </div>
                            <p>¡ERROR! - Hubo algun error en el sistema</p>

                        </div>

                    </div>
                </div><!-- /.modal-content -->
            </div><!-- /.modal-dialog -->
        </div><!-- /.modal -->

        <script src="lib/jquery/jquery.min.js" type="text/javascript"></script>
        <script src="lib/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
        <script src="js/script.js" type="text/javascript"></script>
    </body>
</html>