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
@WebServlet(name = "ServletRegistroAccidente", urlPatterns = {"/ServletRegistroAccidente"})
public class ServletRegistroAccidente extends HttpServlet {

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
            if (accion.equals("agregarAcci")) {
                RegistrarAccidente(request, response);
            }
            if (accion.equals("actualizarAcci")) {
                ActualizarAccidente(request, response);
            }
            if (accion.equals("eliminar")) {
                EliminarAccidente(request, response);
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

    private void RegistrarAccidente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();

        String chasisVehicu = request.getParameter("chasisVehiculo");
        String cedulaCondu = request.getParameter("Cedulaconductor");
        String nombreCondu = request.getParameter("Nomconductor");
        String fechaaccidente = request.getParameter("fechaRegistro");
        String descripcionAcci = request.getParameter("descripcionAccide");

        try {
            ArrayList<String> dato = validarSiExisteUnAccidente(chasisVehicu);
            if (dato.isEmpty()) {
                boolean retorno = agregarAccidente(chasisVehicu, cedulaCondu, nombreCondu, fechaaccidente, descripcionAcci);
                if (retorno == true) {
                    response.sendRedirect("vista/Administrador/accidente.jsp?mens='RegistroExitoso'");
                } else {
                    response.sendRedirect("vista/Administrador/accidente.jsp?mens='ErrorRegistro'");
                }
            } else {
                response.sendRedirect("vista/Administrador/accidente.jsp?mens='ErrorRegistro'");
            }
        } catch (Exception e) {
            out.println(e);
        }

    }

    private void ActualizarAccidente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();

        String chasisVehicu = request.getParameter("chasis");
        String cedulaCondu = request.getParameter("numeroCedulaCon");
        String nombreCondu = request.getParameter("NombresCon");
        String fechaaccidente = request.getParameter("fechaRegistro");
        String descripcionAcci = request.getParameter("descripcionAcci");

        String idAccidente = request.getParameter("idAccidenteInput");

        try {
            boolean retornoAci = atualizarAccidente(idAccidente, chasisVehicu, cedulaCondu, nombreCondu, fechaaccidente, descripcionAcci);
            if (retornoAci == true) {
                response.sendRedirect("vista/Administrador/accidente.jsp?mens='RegistroExitoso'");
            } else {
                response.sendRedirect("vista/Administrador/editarDatosAccidente.jsp?mens='ErrorRegistro'");
            }
        } catch (Exception e) {
            out.println(e);
        }

    }

    private void EliminarAccidente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();
        String idAccidente = request.getParameter("idAccidente");

        try {
            boolean elimina = eliminarAccidente(idAccidente);
            if (elimina == true) {
                response.sendRedirect("vista/Administrador/accidente.jsp?mens='EliminadoExtitosamente'");
            } else {
                response.sendRedirect("vista/Administrador/accidente.jsp?mens='ErrorRegistro'");
            }
        } catch (Exception e) {
            out.println(e);
        }

    }

    private ArrayList<String> validarSiExisteUnAccidente(String chasisVehicu) {
        ArrayList<String> dato;
        dato = faca.validarSiExisteUnAccidente(chasisVehicu);
        return dato;
    }

    private boolean agregarAccidente(String chasisVehicu, String cedulaCondu, String nombreCondu, String fechaaccidente, String descripcionAcci) {
        return faca.agregarAccidente(chasisVehicu, cedulaCondu, nombreCondu, fechaaccidente, descripcionAcci);
    }

    private boolean atualizarAccidente(String idAccidente, String chasisVehicu, String cedulaCondu, String nombreCondu, String fechaaccidente, String descripcionAcci) {
        return faca.atualizarAccidente(idAccidente, chasisVehicu, cedulaCondu, nombreCondu, fechaaccidente, descripcionAcci);
    }

    private boolean eliminarAccidente(String idAccidente) {
        return faca.eliminarAccidente(idAccidente);
    }

}
