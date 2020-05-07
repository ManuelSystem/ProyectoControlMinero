/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.ConductorDTO;
import java.util.ArrayList;
import util.Database;

/**
 *
 * @author Manuel
 */
public class ConductorDAO {

    public static ArrayList<String> validarSiExisteUnConductor(String cedula) {
        ArrayList<String> dato = new ArrayList<>();
        try {
            String sql = "SELECT idConductor FROM conductor WHERE numeroCedula='" + cedula + "'";
            dato = Database.getSQL(sql);
        } catch (Exception e) {
            System.err.println("SQL Error: " + e.getMessage());
        }
        return dato;
    }

    public static boolean agregarConductor(ConductorDTO c) {
        String sql = "";
        try {
            sql = "INSERT INTO conductor (tipoDocumento,numeroCedula,nombre,apellido,telefono,corrreo,"
                    + "direccion,sexo,edad,licencia) "
                    + "VALUES('" + c.getTipoDocumento() + "', '" + c.getNumeroDocumento() + "', '" + c.getNombres() + "', "
                    + "'" + c.getApellidos() + "', '" + c.getTelefono() + "', '" + c.getCorreo() + "', "
                    + "'" + c.getDireccion() + "', '" + c.getSexo() + "', "
                    + "'" + c.getEdad() + "', '" + c.getLicencia() + "')";
        } catch (Exception e) {
            System.err.println("SQL Error: " + e.getMessage());
        }
        return Database.ejecutarActualizacionSQL(sql);
    }

    public static ArrayList<String> obtenerDatosConductor() {
        ArrayList<String> datos = new ArrayList<>();
        try {

            String sql = "SELECT * FROM conductor";
            datos = Database.getSQL(sql);

        } catch (Exception e) {
            System.err.println("SQL Error: " + e.getMessage());
        }

        return datos;
    }

    public static boolean actualizarConductor(ConductorDTO c) {
        String sql = "";
        try {
            sql = "UPDATE conductor SET tipoDocumento='" + c.getTipoDocumento() + "', numeroCedula='" + c.getNumeroDocumento() + "', "
                    + "nombre='" + c.getNombres() + "', apellido='" + c.getApellidos() + "', telefono='" + c.getTelefono() + "', "
                    + "corrreo='" + c.getCorreo() + "', direccion='" + c.getDireccion() + "', sexo='" + c.getSexo() + "', edad='" + c.getEdad() + "',"
                    + "licencia='" + c.getLicencia() + "' WHERE idConductor=" + c.getIdConductor() + "";
        } catch (Exception e) {
        }
        return Database.ejecutarActualizacionSQL(sql);
    }

    public static ArrayList<String> obtenerDatosConductor(String idConductor) {

        ArrayList<String> datos = new ArrayList<>();
        try {

            String sql = "SELECT * FROM conductor WHERE idConductor=" + idConductor + "";
            datos = Database.getSQL(sql);

        } catch (Exception e) {
            System.err.println("SQL Error: " + e.getMessage());
        }

        return datos;
    }

    public static boolean eliminarConductor(String idConductor) {
        String sql = "";
        try {
            sql = "DELETE FROM conductor WHERE idConductor=" + idConductor + "";
        } catch (Exception e) {
            System.err.println("SQL Error Delete: " + e.getMessage());
        }
        System.out.print("no elimina conductor: " + sql);
        return Database.ejecutarActualizacionSQL(sql);
    }

    public static ArrayList<String> obtenereValores() {

        ArrayList<String> datos = new ArrayList<String>();

        try {
            String sql = "SELECT COUNT(*) FROM conductor";
            datos = Database.getSQL(sql);
            System.out.println(sql);
        } catch (Exception e) {
            System.err.println("SQL Error dao: " + e.getMessage());
        }

        return datos;
    }

}
