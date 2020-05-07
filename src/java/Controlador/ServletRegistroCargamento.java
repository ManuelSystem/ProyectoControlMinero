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
@WebServlet(name = "ServletRegistroCargamento", urlPatterns = {"/ServletRegistroCargamento"})
public class ServletRegistroCargamento extends HttpServlet {

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
            if (accion.equals("agregarCarga")) {
                agregarCarga(request, response);
            }if (accion.equals("actualizarCarga")){
                actualizarCarga(request, response);
            }if (accion.equals("eliminar")) {
                eliminarCargamento(request, response);
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

    private void agregarCarga(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();

        String vehiculo = request.getParameter("vehiculo");
        String conductor = request.getParameter("nombreConductor");
        String material = request.getParameter("material");
        String patio = request.getParameter("patio");
        String pesoVacio = request.getParameter("pvacio");
        String pesoCargado = request.getParameter("pcargado");
        String pesoNeto = request.getParameter("pneto");
        String fechaCargamento = request.getParameter("fechaRegistro");
        try {
            ArrayList<String> valida = validarSiExisteCargamento(pesoVacio);
            if (valida.isEmpty()) {
                boolean retorno = agregarCargamento(vehiculo, conductor, material, patio, pesoVacio, pesoCargado, pesoNeto, fechaCargamento);
                if (retorno == true) {
                    response.sendRedirect("vista/AuxiliarPatio/cargamento.jsp?mens='RegistroExitoso'");
                } else {
                    response.sendRedirect("vista/AuxiliarPatio/cargamento.jsp?mens='ErrorRegistro'");
                }
            } else {
                response.sendRedirect("vista/AuxiliarPatio/cargamento.jsp?mens='ErrorRegistro'");
            }
        } catch (Exception e) {
            out.println("Error en el servidor"+e);
        }

    }
    private void actualizarCarga(HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        
        String vehiculo = request.getParameter("vehiculo");
        String conductor = request.getParameter("conductor");
        String material = request.getParameter("material");
        String patio = request.getParameter("patio");
        String pesoVacio = request.getParameter("pvacioo");
        String pesoCargado = request.getParameter("pcargadoo");
        String pesoNeto = request.getParameter("pnetoo");
        String fechaCargamento = request.getParameter("fechaCarga");
         String idCargamento = request.getParameter("idCargamentoInput");
         try {
            boolean actualizar = actualizarCargamento(idCargamento, vehiculo, conductor, material, patio, pesoVacio, pesoCargado, pesoNeto, fechaCargamento);
        if (actualizar == true) {
                response.sendRedirect("vista/AuxiliarPatio/cargamento.jsp?mens='RegistroExitoso'");
            } else {
                response.sendRedirect("vista/AuxiliarPatio/editarDatosCargamento.jsp?mens='ErrorRegistro'");
            }
         } catch (Exception e) {
             out.println("Error en el servidor"+e);
        }
    }
     private void eliminarCargamento(HttpServletRequest request, HttpServletResponse response) 
     throws ServletException, IOException {
       response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        String idCargamento = request.getParameter("idCargamento");
        try {
            boolean eliminar = eliminarCarga(idCargamento);
            if (eliminar == true) {
                response.sendRedirect("vista/AuxiliarPatio/cargamento.jsp?mens='EliminadoExtitosamente'");
            } else {
                response.sendRedirect("vista/AuxiliarPatio/cargamento.jsp?mens='ErrorRegistro'");
            }
        } catch (Exception e) {
            out.println(e);
        }
     }

    private ArrayList<String> validarSiExisteCargamento(String pesoVacio) {
        ArrayList<String> dato;
        dato = faca.validarSiExisteCargamento(pesoVacio);
        return dato;
    }

    private boolean agregarCargamento(String vehiculo, String conductor, String material, String patio, String pesoVacio, String pesoCargado, String pesoNeto, String fechaCargamento) {
        return faca.agregarCargamento(vehiculo, conductor, material, patio, pesoVacio, pesoCargado, pesoNeto, fechaCargamento);
    }

    private boolean actualizarCargamento(String idCargamento, String vehiculo, String conductor, String material, String patio, String pesoVacio, String pesoCargado, String pesoNeto, String fechaCargamento) {
        return faca.actualizarCargamento(idCargamento, vehiculo, conductor, material, patio, pesoVacio, pesoCargado, pesoNeto, fechaCargamento);
    }

    private boolean eliminarCarga(String idCargamento) {
    return faca.eliminarCarga(idCargamento)    ;
    }

   

    
}
