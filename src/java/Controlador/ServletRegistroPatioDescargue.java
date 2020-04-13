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
@WebServlet(name = "ServletRegistroPatioDescargue", urlPatterns = {"/ServletRegistroPatioDescargue"})
public class ServletRegistroPatioDescargue extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            String accion = request.getParameter("accion");
            if (accion.equals("agregarPatio")) {
                agregarPatio(request, response);
            }
            if (accion.equals("actualizarPatio")) {
                actualizarPatio(request, response);
            }
            if (accion.equals("eliminar")) {
                eliminarPatio(request, response);
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

    private void agregarPatio(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();
        String departamento = request.getParameter("nombreDepartamento");
        String municipio = request.getParameter("nombreMunicipio");
        String nomPatio = request.getParameter("nombrePatio");
        String distancia = request.getParameter("distancia");
        String descripcion = request.getParameter("descripcionPatio");
        try {
            ArrayList<String> validar = validarSiExisteUnPatio(nomPatio);
            if (validar.isEmpty()) {
                boolean retorno = agregarPatioDescargue(departamento, municipio, nomPatio, distancia, descripcion);
                if (retorno == true) {
                    response.sendRedirect("vista/Administrador/patio.jsp?mens='RegistroExitoso'");
                } else {
                    response.sendRedirect("vista/Administrador/patio.jsp?mens='ErrorRegistro'");
                }
            } else {
                response.sendRedirect("vista/Administrador/patio.jsp?mens='ErrorRegistro'");
            }
        } catch (Exception e) {
            out.println(e);
        }
    }

    private void actualizarPatio(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();
        String departamento = request.getParameter("departamento");
        String municipio = request.getParameter("municipio");
        String nomPatio = request.getParameter("nombrePatio");
        String distancia = request.getParameter("distancia");
        String descripcion = request.getParameter("descripcionPatio");

        String idPatio = request.getParameter("idPatioInput");
        try {
            boolean retorno = actualizarPatio(idPatio, departamento, municipio, nomPatio, distancia, descripcion);
            if (retorno == true) {
                response.sendRedirect("vista/Administrador/patio.jsp?mens='RegistroExitoso'");
            } else {
                response.sendRedirect("vista/Administrador/editarDatosPatio.jsp?mens='ErrorRegistro'");
            }

        } catch (Exception e) {
            out.println(e);
        }

    }

    private void eliminarPatio(HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        
        String idPatio = request.getParameter("idPatio");
        try {
            boolean retorno = eliminarPatio(idPatio);
            if(retorno == true) {
                response.sendRedirect("vista/Administrador/patio.jsp?mens='EliminadoExtitosamente'");
            }else{
                response.sendRedirect("vista/Administrador/patio.jsp?mens='ErrorRegistro'");
            }
        } catch (Exception e) {
            out.println(e);
        }
    }

    private ArrayList<String> validarSiExisteUnPatio(String nomPatio) {
        ArrayList<String> dato;
        dato = faca.validarSiExisteUnPatio(nomPatio);
        return dato;
    }

    private boolean agregarPatioDescargue(String departamento, String municipio, String nomPatio, String distancia, String descripcion) {
        return faca.agregarPatioDescargue(departamento, municipio, nomPatio, distancia, descripcion);
    }

    private boolean actualizarPatio(String idPatio, String departamento, String municipio, String nomPatio, String distancia, String descripcion) {
        return faca.actualizarPatio(idPatio, departamento, municipio, nomPatio, distancia, descripcion);
    }

    private boolean eliminarPatio(String idPatio) {
    return faca.eliminarPatio(idPatio);
    }

}
