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
@WebServlet(name = "ServletRegistroFallaMecanica", urlPatterns = {"/ServletRegistroFallaMecanica"})
public class ServletRegistroFallaMecanica extends HttpServlet {

    Facade faca = new Facade();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String accion = request.getParameter("accion");

            if (accion.equals("agregarFalla")) {
                AgregarFalla(request, response);
            }
            if (accion.equals("actualizarFalla")){
                ActualizarFalla(request, response);
            }
            if (accion.equals("eliminar")){
                EliminarFalla(request, response);
            }
        } catch (Exception ex) {
            out.println(ex);
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

    private void AgregarFalla(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        String chasisVehi = request.getParameter("vehiculoFalla");
        String conductor = request.getParameter("conductorFalla");
        String fechaRegistro = request.getParameter("fechaRegistro");
        String descriFalla = request.getParameter("descripcionFalla");

        try {
            ArrayList<String> valida = validarSiExisteFalla(chasisVehi);
            if (valida.isEmpty()) {
                boolean almacenar = agregarFalla(chasisVehi, conductor, fechaRegistro, descriFalla);
                if (almacenar == true) {
                    response.sendRedirect("vista/Administrador/fallaMecanica.jsp?mens='RegistroExitoso'");
                } else {
                    response.sendRedirect("vista/Administrador/fallaMecanica.jsp?mens='ErrorRegistro'");
                }
            } else {
                response.sendRedirect("vista/Administrador/fallaMecanica.jsp?mens='ErrorRegistro'");
            }
        } catch (Exception e) {
            out.println(e);
        }
    }
    private void ActualizarFalla(HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        
        String chasisVehi = request.getParameter("vehiculoFalla");
        String conductor = request.getParameter("conductorFalla");
        String fechaRegistro = request.getParameter("fechaRegistro");
        String descriFalla = request.getParameter("descripcionFalla");
        String idFalla = request.getParameter("idFallaInput");
        
        try {
            boolean retor = actualizarFalla(chasisVehi, conductor, fechaRegistro, descriFalla, idFalla);
            if (retor == true) {
                response.sendRedirect("vista/Administrador/fallaMecanica.jsp?mens='RegistroExitoso'");
            }else{
                response.sendRedirect("vista/Administrador/editarDatosFallaMeca.jsp?mens='ErrorRegistro'");
            }
        } catch (Exception e) {
            out.println(e);
        }
    
    }
    private void EliminarFalla(HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String idFalla = request.getParameter("idFallaMecanica");
        try {
            boolean retorFa = eliminarFalla(idFalla);
            if (retorFa == true) {
                response.sendRedirect("vista/Administrador/fallaMecanica.jsp?mens='EliminarExitoso'");
            } else {
                response.sendRedirect("vista/Administrador/fallaMecanica.jsp?mens='ErrorRegistro'");
            }

        } catch (Exception e) {
        }
        }

    private ArrayList<String> validarSiExisteFalla(String chasisVehi) {
        ArrayList<String> dato;
        dato = faca.validarSiExisteFalla(chasisVehi);
        return dato;
    }

    private boolean agregarFalla(String chasisVehi, String conductor, String fechaRegistro, String descriFalla) {
        return faca.agregarFalla(chasisVehi, conductor, fechaRegistro, descriFalla);
    }

    private boolean actualizarFalla(String chasisVehi, String conductor, String fechaRegistro, String descriFalla, String idFalla) {
    return faca.actualizarFalla(chasisVehi, conductor, fechaRegistro, descriFalla, idFalla);
    }

    private boolean eliminarFalla(String idFalla) {
    return faca.eliminarFalla(idFalla);   
    }

    

    

}
