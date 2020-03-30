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
@WebServlet(name = "ServletRegistroAuxi", urlPatterns = {"/ServletRegistroAuxi"})
public class ServletRegistroAuxi extends HttpServlet {

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

            String accion = request.getParameter("accion");
            if (accion.equals("agregarUsu")) {
                RegistrarAux(request, response);
            }
            if (accion.equals("actualizarAuxiliar")) {
                ActualizarAuxi(request, response);
            }
            if(accion.equals("eliminar")){
                EliminarAuxi(request, response);
            }
        }catch(Exception e){
            
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

    private void RegistrarAux(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        String tipoDocumento = request.getParameter("TipoDocumentoUsu");
        String numCedula = request.getParameter("numeroCedulaUsu");
        String telefono = request.getParameter("telefonoUsu");
        String nombres = request.getParameter("NombresUsu");
        String apellidos = request.getParameter("ApellidosUsu");
        String email = request.getParameter("emailUsu");
        String direccion = request.getParameter("direccionUsu");
        String generoSexo = request.getParameter("TipoSexoUsu");
        String edad = request.getParameter("edadUsu");

        String descripcion = request.getParameter("DescripcionOperaUsu");
        String fecha = request.getParameter("fechaRegistro");

        try {
            boolean retorno = agregarPersona(tipoDocumento, numCedula, nombres, apellidos, telefono, email, direccion, generoSexo, edad);
            if (retorno == false) {
                response.sendRedirect("vista/Administrador/usuario.jsp?mens='ErrorRegistro'");
            } else {
                ArrayList<String> retornoIdPersona = buscarIdPersona(numCedula);
                String id = retornoIdPersona.toString().replace("[", "").replace("]", "").replace("/", "").replace(" ", "");

                //agg AuxiliarPatio
                boolean retornoAux = agregarUsuarioAuxi(descripcion, fecha, id);
                if (retornoAux == true) {
                    response.sendRedirect("vista/Administrador/usuario.jsp?mens='RegistroExitoso'");
                } else {
                    response.sendRedirect("vista/Administrador/usuario.jsp?mens='ErrorRegistro'");
                }
            }
        } catch (Exception ex) {
            out.println(ex);
        }
    }

    private void ActualizarAuxi(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        String tipoDocumento = request.getParameter("TipoDocumentoUsu");
        String numCedula = request.getParameter("numeroCedulaUsu");
        String telefono = request.getParameter("telefonoUsu");
        String nombres = request.getParameter("NombresUsu");
        String apellidos = request.getParameter("ApellidosUsu");
        String email = request.getParameter("emailUsu");
        String direccion = request.getParameter("direccionUsu");
        String generoSexo = request.getParameter("TipoSexoUsu");
        String edad = request.getParameter("edadUsu");
        String usuario =request.getParameter("usarioAuxi");
        String password =request.getParameter("passwordAuxi");
        
        String idPersona = request.getParameter("idPersonaInput");
        String descripcion = request.getParameter("DescripcionOperaUsu");
        String fechaRegistro = request.getParameter("fechaRegistro");
        
        System.out.println("este es el id persona: "+idPersona);

        try {
            boolean retorno = actualizarPersona(tipoDocumento,numCedula,nombres,apellidos,telefono,
                    email,direccion,generoSexo,edad, usuario, password, idPersona);
            
            if(retorno == false){
                response.sendRedirect("vista/Administrador/usuario.jsp?mens='ErrorRegistro'");
            }else{
                String id =request.getParameter("idAuxiInput");
                //agregar actualización de Auxiliar
                boolean retornoAuxi =actualizarAuxiliar(descripcion, fechaRegistro, id);
                
                if (retornoAuxi == true) {
                    response.sendRedirect("vista/Administrador/usuario.jsp?mens='RegistroExitoso'");
                } else {
                    response.sendRedirect("vista/Administrador/editarDatosAuxiliar.jsp?mens='ErrorRegistro'");
                    System.out.print(retornoAuxi);
                }
            }
        } catch (Exception ex){out.println(ex);} 
        
    }
     private void EliminarAuxi(HttpServletRequest request, HttpServletResponse response) 
     throws ServletException, IOException{
         
         String idPersona = request.getParameter("idPersona");
         String idAuxiliar = request.getParameter("idAuxiliar");
         
         boolean respuesta = eliminarAuxiliar(idAuxiliar);
         
         if(respuesta == true){
             boolean retor = eliminarPersona(idPersona);
             if(retor == true){
                 response.sendRedirect("vista/Administrador/usuario.jsp?mens='RegistroExitoso'");
             }
         }else{
                 response.sendRedirect("vista/Administrador/usuario.jsp?mens='ErrorRegistro'");
             }
      }

    private boolean agregarPersona(String tipoDocumento, String numCedula, String nombres, String apellidos, String telefono, String email, String direccion, String generoSexo, String edad) {
        return faca.agregarPersona(tipoDocumento, numCedula, nombres, apellidos, telefono, email, direccion, generoSexo, edad);
    }

    private ArrayList<String> buscarIdPersona(String cedula) {
        ArrayList<String> dato;
        dato = faca.buscarIdPersona(cedula);
        return dato;
    }

    private boolean agregarUsuarioAuxi(String descripcion, String fechaRegistro, String id) {
        return faca.agregarUsuarioAuxi(descripcion, fechaRegistro, id);
    }

    private boolean actualizarPersona(String tipoDocumento, String numCedula, String nombres, String apellidos, String telefono, String email, String direccion, String generoSexo, String edad,String usuario, String password, String idPersona) {
        return faca.actualizarPersona(tipoDocumento,numCedula,nombres,apellidos,telefono,email,direccion,generoSexo,edad,usuario, password,idPersona);
    }

    private boolean actualizarAuxiliar(String descripcion, String fechaRegistro, String id ) {
        return faca.actualizarAuxiliar(descripcion, fechaRegistro, id);
      }
    private boolean eliminarAuxiliar(String idAuxiliar){
        return faca.eliminarAuxiliar(idAuxiliar);
    }
   private boolean eliminarPersona(String idPersona){
       return faca.eliminarPersona(idPersona);
   }

}
