/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import FACADE.Facade;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Manuel
 */
@WebServlet(name = "ServletRegistroConductor", urlPatterns = {"/ServletRegistroConductor"})
public class ServletRegistroConductor extends HttpServlet {

    Facade faca = new Facade();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String accion = request.getParameter("accion");
            if (accion.equals("agregarCon")) {
                RegistrarConduc(request, response);
            }
            if (accion.equals("actualizarConductor")) {
                AcualizarConductor(request, response);
            }
            if (accion.equals("eliminar")) {
                EliminarConductor(request, response);
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void RegistrarConduc(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        String tipoDocumento = request.getParameter("TipoDocumentoCon");
        String numCedula = request.getParameter("numeroCedulaCon");
        String telefono = request.getParameter("telefonoCon");
        String nombres = request.getParameter("NombresCon");
        String apellidos = request.getParameter("ApellidosCon");
        String email = request.getParameter("emailCon");
        String direccion = request.getParameter("direccionCon");
        String generoSexo = request.getParameter("TipoSexoCon");
        String edad = request.getParameter("edadCon");
        String licencia = request.getParameter("licenciaEstado");

        try {
            ArrayList<String> dato = validarSiExisteUnConductor(numCedula);
            if (dato.isEmpty()) {
                boolean retorno = agregarConductor(tipoDocumento, numCedula, telefono, nombres, apellidos, email, direccion,
                        generoSexo, edad, licencia);
                if (retorno == true) {
                    response.sendRedirect("vista/Administrador/conductor.jsp?mens='RegistroExitoso'");
                } else {
                    response.sendRedirect("vista/Administrador/conductor.jsp?mens='ErrorRegistro'");
                }
            } else {
                response.sendRedirect("vista/Administrador/conductor.jsp?mens='ErrorRegistro'");
            }

        } catch (Exception e) {
            out.println(e);
        }
    }

    private void AcualizarConductor(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        
        String tipoDocumento = request.getParameter("TipoDocumentoCon");
        String numCedula = request.getParameter("numeroCedulaCon");
        String telefono = request.getParameter("telefonoCon");
        String nombres = request.getParameter("NombresCon");
        String apellidos = request.getParameter("ApellidosCon");
        String email = request.getParameter("emailCon");
        String direccion = request.getParameter("direccionCon");
        String generoSexo = request.getParameter("TipoSexoCon");
        String edad = request.getParameter("edadCon");
        String licencia = request.getParameter("licenciaEstado");

        String idConductor = request.getParameter("idConductorInput");
        try {
            boolean retorConductor = actualizarConductor(tipoDocumento, numCedula, telefono, nombres, apellidos, email, direccion,
                    generoSexo, edad, licencia, idConductor);
            if (retorConductor == false) {
                response.sendRedirect("vista/Administrador/editarDatosConductor.jsp?mens='ErrorRegistro'");
            } else {
                response.sendRedirect("vista/Administrador/conductor.jsp?mens='actualizacionExitosa'");
            }
        } catch (Exception e) {
        }
    }

    private void EliminarConductor(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idConductor = request.getParameter("idConductor");
        
        try {
             boolean elimi = eliminarConductor(idConductor);
        if (elimi == true) {
            response.sendRedirect("vista/Administrador/conductor.jsp?mens='EliminadoExtitosamente'");
        } else {
            response.sendRedirect("vista/Administrador/conductor.jsp?mens='ErrorRegistro'");
        }
        } catch (Exception e) {
        }
    }

    private ArrayList<String> validarSiExisteUnConductor(String cedula) {
        ArrayList<String> dato;
        dato = faca.validarSiExisteUnConductor(cedula);
        return dato;
    }

    private boolean agregarConductor(String tipoDocumento, String numCedula, String telefono, String nombres, String apellidos, String email, String direccion, String generoSexo, String edad, String licencia) {
        return faca.agregarConductor(tipoDocumento, numCedula, telefono, nombres, apellidos, email, direccion, generoSexo, edad, licencia);
    }

    private boolean actualizarConductor(String tipoDocumento, String numCedula, String telefono, String nombres, String apellidos, String email, String direccion, String generoSexo, String edad, String licencia, String idConductor) {
        return faca.actualizarConductor(tipoDocumento, numCedula, telefono, nombres, apellidos, email, direccion,
                generoSexo, edad, licencia, idConductor);
    }

    private boolean eliminarConductor(String idConductor) {
       return faca.eliminarConductor(idConductor);
    }

}
