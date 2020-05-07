/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.MineroDTO;
import java.util.ArrayList;
import util.Database;

/**
 *
 * @author Manuel
 */
public class MineroDAO {

    public static ArrayList<String> validarSiExisteMinero(String numCedula) {
        ArrayList<String> dato = new ArrayList<>();
        try {

            String sql = "SELECT idMinero FROM minero WHERE cedula='" + numCedula + "'";
            dato = Database.getSQL(sql);
        } catch (Exception e) {
            System.err.println("SQL Error: " + e.getMessage());
        }

        return dato;
    }

    public static boolean agregarMinero(MineroDTO m) {
        String sql = "";
        try {
            sql = "INSERT INTO minero (tipoDocumento, cedula, nombre, apellido, telefono, direccion, edad, fechaRegistro) VALUES ('" + m.getTipoDocumento() + "',"
                    + "'" + m.getNumeroDocu() + "', '" + m.getNombre() + "', '" + m.getApellido() + "', '" + m.getTelefono() + "', '" + m.getDireccion() + "',"
                    + "'" + m.getEdad() + "', '" + m.getFechaRegistro() + "')";

        } catch (Exception e) {
            System.err.println("SQL Error: " + e.getMessage());
        }
        return Database.ejecutarActualizacionSQL(sql);
    }

    public static ArrayList<String> obtenerDatosMinero() {
    ArrayList<String> datos = new ArrayList<>();
        try {
            String sql="SELECT * FROM minero";
            datos = Database.getSQL(sql);
        } catch (Exception e) {
            System.err.println("SQL Error: " + e.getMessage());
        }
        return datos;
    }

    public static ArrayList<String> obtenerValoresMinero() {
    ArrayList<String> datos = new ArrayList<String>();
        try {
            String sql = "SELECT COUNT(*) FROM minero";
            datos = Database.getSQL(sql);
            System.out.println(sql);
        } catch (Exception e) {
            System.err.println("SQL Error dao: " + e.getMessage());
        }

        return datos;    
    }

    public static ArrayList<String> obtenerDatosMinero(String idMinero) {
        ArrayList<String> datoss = new ArrayList<String>();
        try {
            String sql = "SELECT * FROM minero WHERE idMinero=" + idMinero + "";
            datoss = Database.getSQL(sql);
            System.out.println(sql);
        } catch (Exception e) {
            System.err.println("SQL Error dao: " + e.getMessage());
        }

        return datoss;
    }

    public static boolean actualizarMinero(MineroDTO mi) {
    String sql = "";
        try {
            sql = "UPDATE minero SET tipoDocumento='" + mi.getTipoDocumento() + "', cedula='" + mi.getNumeroDocu()+ "', "
                    + "nombre='" + mi.getNombre()+ "', apellido='" + mi.getApellido()+ "', telefono='" + mi.getTelefono()+ "', "
                    + "direccion='" + mi.getDireccion() + "', edad='" + mi.getEdad() + "',"
                    + "fechaRegistro='" + mi.getFechaRegistro()+ "' WHERE idMinero=" + mi.getIdMinero()+ "";
        } catch (Exception e) {
        }
        return Database.ejecutarActualizacionSQL(sql);    
    }

    public static boolean eliminarMinero(String idMinero) {
         String sql = "";
        try {
            sql = "DELETE FROM minero WHERE idMinero=" + idMinero + "";
        } catch (Exception e) {
            System.err.println("SQL Error Delete: " + e.getMessage());
        }
        System.out.print("no elimina mnero: " + sql);
        return Database.ejecutarActualizacionSQL(sql);
    }

}
