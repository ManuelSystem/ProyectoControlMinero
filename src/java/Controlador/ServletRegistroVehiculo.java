/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import FACADE.Facade;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.nio.file.Files;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author Manuel
 */
@MultipartConfig
@WebServlet(name = "ServletRegistroVehiculo", urlPatterns = {"/ServletRegistroVehiculo"})
public class ServletRegistroVehiculo extends HttpServlet {

    Facade faca = new Facade();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String accion = request.getParameter("accion");
            if (accion.equals("agregarVehiculo")) {
                RegistrarVehiculo(request, response);
            }
            if (accion.equals("actualizarVehiculo")) {
                ActualizaVehiculo(request, response);
            }
            if (accion.equals("eliminar")) {
                EliminarVehiculo(request, response);
            }
        }catch(Exception e){
            out.println(e);
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

    private void RegistrarVehiculo(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");;
        PrintWriter out = response.getWriter();

        String marcaVehi = request.getParameter("marcaVeh");
        String modelo = request.getParameter("añoVeh");
        String color = request.getParameter("colorVeh");
        String chasis = request.getParameter("numeChasis");
        String seguro = request.getParameter("seguroVeh");
        String tecnomecanica = request.getParameter("tecnomecanicoVeh");
        String fechaRegis = request.getParameter("fechaRegistro");
        
        
        Part part = request.getPart("imgfile");
        String myStorageFolder = "/img/vehiculos";
        String getImageFolderPath = request.getServletContext().getRealPath(myStorageFolder);
        String ruta = getImageFolderPath.replace("\\build", "");
        System.out.print(ruta);
        
        File carpetaDestino = new File(ruta);
        String imagen = part.getSubmittedFileName();
        File archivoDestino = new File(carpetaDestino, part.getSubmittedFileName());
        InputStream inputStream = part.getInputStream();
        Files.copy(inputStream, archivoDestino.toPath());

        try {
            ArrayList<String> dato = validarSiExisteUnVehiculo(chasis);
            if (dato.isEmpty()) {
                boolean retorno = agregarVehiculo(marcaVehi, modelo, color, chasis, seguro, tecnomecanica, fechaRegis, imagen);
                if (retorno == true) {
                    response.sendRedirect("vista/Administrador/vehiculo.jsp?mens='RegistroExitoso'");
                } else {
                    response.sendRedirect("vista/Administrador/vehiculo.jsp?mens='ErrorRegistro'");
                }
            } else {
                response.sendRedirect("vista/Administrador/vehiculo.jsp?mens='ErrorRegistro'");
            }

        } catch (Exception ex) {
            out.println(ex);
        }

    }
   

    private void ActualizaVehiculo(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        String marcaVehi = request.getParameter("marcaVeh");
        String modelo = request.getParameter("añoVeh");
        String color = request.getParameter("colorVeh");
        String chasis = request.getParameter("numeChasis");
        String seguro = request.getParameter("seguroVeh");
        String tecnomecanica = request.getParameter("tecnomecanicoVeh");
        String fechaRegis = request.getParameter("fechaRegistro");

        String idVehiculo = request.getParameter("idVehiculoInput");
        try {
            boolean retorVehiculo = actualizarVehiculo(marcaVehi, modelo, color, chasis, seguro, tecnomecanica, fechaRegis, idVehiculo);
            if (retorVehiculo == false) {
                response.sendRedirect("vista/Administrador/editarDatosVehiculo.jsp?mens='ErrorRegistro'");
            } else {
                response.sendRedirect("vista/Administrador/vehiculo.jsp?mens='RegistroExitoso'");
            }
        } catch (Exception ex) {
            out.println(ex);
        }
    }

    private void EliminarVehiculo(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String iVehiculo = request.getParameter("idVehiculo");
        try {
            boolean retorVe = eliminarVehiculo(iVehiculo);
            if (retorVe == true) {
                response.sendRedirect("vista/Administrador/vehiculo.jsp?mens='EliminarExitoso'");
            } else {
                response.sendRedirect("vista/Administrador/vehiculo.jsp?mens='ErrorRegistro'");
            }

        } catch (Exception e) {
        }
    }

    private boolean agregarVehiculo(String marcaVehi, String modelo, String color, String chasis, String seguro, String tecnomecanica, String fechaRegis, String imagen) {
        return faca.agregarVehiculo(marcaVehi, modelo, color, chasis, seguro, tecnomecanica, fechaRegis, imagen);
    }

    private ArrayList<String> validarSiExisteUnVehiculo(String chasis) {
        ArrayList<String> dato;
        dato = faca.validarSiExisteUnVehiculo(chasis);
        return dato;
    }

    private boolean actualizarVehiculo(String marcaVehi, String modelo, String color, String chasis, String seguro, String tecnomecanica, String fechaRegis, String idVehiculo) {
        return faca.actualizarVehiculo(marcaVehi, modelo, color, chasis, seguro, tecnomecanica, fechaRegis, idVehiculo);
    }

    private boolean eliminarVehiculo(String iVehiculo) {
        return faca.eliminarVehiculo(iVehiculo);
    }

}
