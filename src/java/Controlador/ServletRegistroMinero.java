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
@WebServlet(name = "ServletRegistroMinero", urlPatterns = {"/ServletRegistroMinero"})
public class ServletRegistroMinero extends HttpServlet {

    Facade faca = new Facade();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String accion = request.getParameter("accion");
            if (accion.equals("agregarMine")) {
                RegistrarMinero(request, response);
            }
            if (accion.equals("actualizarMinero")) {
                actualizarMinero(request, response);
            }
            if (accion.equals("eliminar")) {
                eliminarMinero(request, response);
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

    private void RegistrarMinero(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        String tipoDocumento = request.getParameter("tipoDocumento");
        String numCedula = request.getParameter("numeroDocu");
        String telefono = request.getParameter("telefono");
        String nombres = request.getParameter("nombres");
        String apellidos = request.getParameter("apellidos");
        String direccion = request.getParameter("direccion");
        String edad = request.getParameter("edad");
        String fecha = request.getParameter("fechaRegistro");
        try {
            ArrayList<String> validar = validarSiExisteMinero(numCedula);
            if (validar.isEmpty()) {
                boolean retornoAgregar = agregarMinero(tipoDocumento, numCedula, telefono, nombres, apellidos, direccion,
                        edad, fecha);
                if (retornoAgregar == true) {
                    response.sendRedirect("vista/Administrador/minero.jsp?mens='RegistroExitoso'");
                } else {
                    response.sendRedirect("vista/Administrador/minero.jsp?mens='ErrorRegistro'");
                }
            } else {
                response.sendRedirect("vista/Administrador/minero.jsp?mens='MineroExistente'");
            }
        } catch (Exception e) {
            out.println(e);
        }

    }

    private void actualizarMinero(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        String tipoDocumento = request.getParameter("tipoDocumentoMine");
        String numCedula = request.getParameter("numeroCedula");
        String telefono = request.getParameter("telefonoMin");
        String nombres = request.getParameter("nombresMine");
        String apellidos = request.getParameter("apellidosMine");
        String direccion = request.getParameter("direccionMine");
        String edad = request.getParameter("edad");
        String fecha = request.getParameter("fecha");

        String idMinero = request.getParameter("idMineroInput");

        try {
            boolean retorno = actualizarMinero(idMinero, tipoDocumento, numCedula, telefono, nombres, apellidos, direccion,
                    edad, fecha);
            if (retorno == false) {
                response.sendRedirect("vista/Administrador/editarDatosMinero.jsp?mens='ErrorRegistro'");
            } else {
                response.sendRedirect("vista/Administrador/minero.jsp?mens='ActualizacionExitosa'");
            }
        } catch (Exception e) {
            out.println(e);
        }
    }

    private void eliminarMinero(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String idMinero = request.getParameter("idMinero");
        try {
            boolean retornoElimina = eliminarMinero(idMinero);
            if (retornoElimina == true) {
                response.sendRedirect("vista/Administrador/minero.jsp?mens='EliminadoExtitosamente'");
            } else {
                response.sendRedirect("vista/Administrador/minero.jsp?mens='ErrorRegistro'");
            }
        } catch (Exception e) {
            out.println(e);
        }
    }

    private ArrayList<String> validarSiExisteMinero(String numCedula) {
        ArrayList<String> dato;
        dato = faca.validarSiExisteMinero(numCedula);
        return dato;
    }

    private boolean agregarMinero(String tipoDocumento, String numCedula, String telefono, String nombres, String apellidos, String direccion, String edad, String fecha) {
        return faca.agregarMinero(tipoDocumento, numCedula, telefono, nombres, apellidos, direccion, edad, fecha);
    }

    private boolean actualizarMinero(String idMinero, String tipoDocumento, String numCedula, String telefono, String nombres, String apellidos, String direccion, String edad, String fecha) {
        return faca.actualizarMinero(idMinero, tipoDocumento, numCedula, telefono, nombres, apellidos, direccion, edad, fecha);
    }

    private boolean eliminarMinero(String idMinero) {
        return faca.eliminarMinero(idMinero);
    }

}
