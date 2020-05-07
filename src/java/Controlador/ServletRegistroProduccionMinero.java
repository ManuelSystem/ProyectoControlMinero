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
@WebServlet(name = "ServletRegistroProduccionMinero", urlPatterns = {"/ServletRegistroProduccionMinero"})
public class ServletRegistroProduccionMinero extends HttpServlet {

    Facade faca = new Facade();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String accion = request.getParameter("accion");
            if (accion.equals("agregarProMine")) {
                registrarProduccion(request, response);
            }
            if (accion.equals("actualizarProduccion")) {
                actualizarProduccion(request, response);
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

    private void registrarProduccion(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        String nombreMine = request.getParameter("nomMinero");
        String turno = request.getParameter("turno");
        String produccion = request.getParameter("cantProduccion");
        String fechaRegistro = request.getParameter("fechaRegistro");
        try {
            ArrayList<String> validar = validarSiExisteProduccion(produccion);
            if (validar.isEmpty()) {
                boolean agrega = agregrarProduccion(nombreMine, turno, produccion, fechaRegistro);
                if (agrega == true) {
                    response.sendRedirect("vista/Administrador/produccionMinero.jsp?mens='RegistroExitoso'");
                } else {
                    response.sendRedirect("vista/Administrador/produccionMinero.jsp?mens='ErrorRegistro'");
                }
            } else {
                response.sendRedirect("vista/Administrador/produccionMinero.jsp?mens='ProduccionExistente'");
            }
        } catch (Exception e) {
            out.println(e);
        }

    }

    private void actualizarProduccion(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        String nombreMine = request.getParameter("nombresMine");
        String turno = request.getParameter("turno");
        String produccion = request.getParameter("cantProduccion");
        String fechaRegistro = request.getParameter("fecha");
        String idProduccion = request.getParameter("idProduccionInput");
        try {
            boolean retorno = actualizarProduccion(idProduccion, nombreMine, turno, produccion, fechaRegistro);
            if (retorno == true) {
                response.sendRedirect("vista/Administrador/produccionMinero.jsp?mens='RegistroExitoso'");
            } else {
                response.sendRedirect("vista/Administrador/editarDatosProduccionMinero.jsp?mens='ErrorRegistro'");
            }
        } catch (Exception e) {
            out.println(e);
        }
    }

    private ArrayList<String> validarSiExisteProduccion(String produccion) {
        ArrayList<String> dato;
        dato = faca.validarSiExisteProduccion(produccion);
        return dato;
    }

    private boolean agregrarProduccion(String nombreMine, String turno, String produccion, String fechaRegistro) {
        return faca.agregrarProduccion(nombreMine, turno, produccion, fechaRegistro);
    }

    private boolean actualizarProduccion(String idProduccion, String nombreMine, String turno, String produccion, String fechaRegistro) {
        return faca.actualizarProduccion(idProduccion, nombreMine, turno, produccion, fechaRegistro);
    }

}
