/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import FACADE.Facade;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Manuel
 */
@WebServlet(name = "ServletAdministrador", urlPatterns = {"/ServletAdministrador"})
public class ServletAdministrador extends HttpServlet {
    Facade faca = new Facade();
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String accion = request.getParameter("accion");
            
            if(accion.equals("ActualizarAdministrador")){
                ActualizarAdministrador(request, response);
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

    private void ActualizarAdministrador(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        
         String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String TipoDocumento = request.getParameter("TipoDocumentoAdmin");
        String cedula = request.getParameter("cedula");
        String telefono = request.getParameter("telefono");
        String email = request.getParameter("email");
        String direccion = request.getParameter("direccion");
        String sexo = request.getParameter("TipoSexoAdmin");
        String edad = request.getParameter("edad");
        String usuario = request.getParameter("user");
        String contraseña = request.getParameter("password");
        String idPersona = request.getParameter("idPersonaInput");
        try {
            boolean retorno = actualizarAdmin(nombre, apellido, TipoDocumento, cedula, telefono, email, direccion, 
                sexo, edad, usuario, contraseña, idPersona);
             if(retorno == false){
               
               response.sendRedirect("vista/Administrador/perfilAdministrador.jsp?mens='ErrorRegistro'");
               
           }else{
               
               response.sendRedirect("vista/Administrador/administrador.jsp?mens='RegistroExitoso'");
               
           }
        } catch (Exception e) {
            out.println(e);
        }
        
     }

    private boolean actualizarAdmin(String nombre, String apellido, String TipoDocumento, String cedula, String telefono, String email, String direccion, String sexo, String edad, String usuario, String contraseña, String idPersona) {
    return   faca.actualizarAdmin(nombre, apellido, TipoDocumento, cedula, telefono, email, direccion, sexo, edad, usuario, contraseña, idPersona);
    }

}
