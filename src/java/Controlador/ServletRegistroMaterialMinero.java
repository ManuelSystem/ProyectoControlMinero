/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import FACADE.Facade;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
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
@WebServlet(name = "ServletRegistroMaterialMinero", urlPatterns = {"/ServletRegistroMaterialMinero"})
public class ServletRegistroMaterialMinero extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    Facade faca = new Facade();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String accion = request.getParameter("accion");
            if (accion.equals("agregarMaterial")) {
                agregarMaterial(request, response);
            }
            if (accion.equals("actualizarMaterial")) {
                actualizarMaterial(request, response);
            }
            if (accion.equals("eliminar")) {
                eliminarMaterial(request, response);
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

    private void agregarMaterial(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();

        String tipoMaterial = request.getParameter("tipoMaterial");
        String nombreMaterial = request.getParameter("nombreMaterial");
        String descripcion = request.getParameter("descripcionMaterial");
        try {
            ArrayList<String> valida = validarSiExisteMaterial(nombreMaterial);
            if (valida.isEmpty()) {
                boolean retorno = agregarMaterial(tipoMaterial, nombreMaterial, descripcion);
                if (retorno == true) {
                    response.sendRedirect("vista/Administrador/materialMinero.jsp?mens='RegistroExitoso'");
                } else {
                    response.sendRedirect("vista/Administrador/materialMinero.jsp?mens='ErrorRegistro'");
                }
            } else {
                response.sendRedirect("vista/Administrador/materialMinero.jsp?mens='ErrorRegistro'");
            }
        } catch (Exception e) {
            out.println(e);
        }
    }

    private void actualizarMaterial(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        String tipoMaterial = request.getParameter("tipoMaterial");
        String nombreMaterial = request.getParameter("nombreMaterial");
        String descripcion = request.getParameter("descripcionMaterial");
        String idMaterial = request.getParameter("idMaterialInput");

        try {
            boolean actualizar = actualizarMaterial(idMaterial, tipoMaterial, nombreMaterial, descripcion);
            if (actualizar == true) {
                response.sendRedirect("vista/Administrador/materialMinero.jsp?mens='RegistroExitoso'");
            } else {
                response.sendRedirect("vista/Administrador/editarDatosMaterial.jsp?mens='ErrorRegistro'");
            }
        } catch (Exception e) {
            out.println(e);
        }

    }

    private void eliminarMaterial(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        String idMaterial = request.getParameter("idMaterial");
        try {
            boolean eliminar = eliminarMaterial(idMaterial);
            if (eliminar == true) {
                response.sendRedirect("vista/Administrador/materialMinero.jsp?mens='EliminadoExtitosamente'");
            } else {
                response.sendRedirect("vista/Administrador/accidente.jsp?mens='ErrorRegistro'");
            }
        } catch (Exception e) {
            out.println(e);
        }

    }

    private ArrayList<String> validarSiExisteMaterial(String nombreMaterial) {
        ArrayList<String> dato;
        dato = faca.validarSiExisteMaterial(nombreMaterial);
        return dato;
    }

    private boolean agregarMaterial(String tipoMaterial, String nombreMaterial, String descripcion) {
        return faca.agregarMaterial(tipoMaterial, nombreMaterial, descripcion);
    }

    private boolean actualizarMaterial(String idMaterial, String tipoMaterial, String nombreMaterial, String descripcion) {
        return faca.actualizarMaterial(idMaterial, tipoMaterial, nombreMaterial, descripcion);
    }

    private boolean eliminarMaterial(String idMaterial) {
        return faca.eliminarMaterial(idMaterial);
    }

}
