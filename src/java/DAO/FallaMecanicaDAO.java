/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.FallaMecanicaDTO;
import java.util.ArrayList;
import util.Database;

/**
 *
 * @author Manuel
 */
public class FallaMecanicaDAO {

    public static ArrayList<String> validarSiExisteFalla(String chasisVehi) {
        ArrayList<String> dato = new ArrayList<>();
        try {

            String sql = "SELECT idFalla FROM fallamecanica WHERE chasisVehiculo='" + chasisVehi + "'";
            dato = Database.getSQL(sql);

        } catch (Exception e) {
            System.err.println("SQL Error: " + e.getMessage());
        }

        return dato;
    }

    public static boolean agregarFalla(FallaMecanicaDTO f) {
        String sql = "";
        try {
            sql = "INSERT INTO fallamecanica (chasisVehiculo, nombreConductor, fechaRegistro, descripcion)"
                    + " VALUES('" + f.getChasisVehiculo() + "','" + f.getNombreConductor() + "','" + f.getFechaRgistro() + "','" + f.getDescripcionFalla() + "')";
        } catch (Exception e) {
            System.err.println("SQL Error: " + e.getMessage());
        }
        System.out.println("guardando falla: " + sql);
        return Database.ejecutarActualizacionSQL(sql);
    }

    public static ArrayList<String> obtenerDatosFalla() {

        ArrayList<String> dato = new ArrayList<>();
        try {

            String sql = "SELECT * FROM fallamecanica";
            dato = Database.getSQL(sql);

        } catch (Exception e) {
            System.err.println("SQL Error: " + e.getMessage());
        }

        return dato;
    }

    public static ArrayList<String> obtenerDatosFalla(String idFalla) {

        ArrayList<String> dato = new ArrayList<>();
        try {

            String sql = "SELECT * FROM fallamecanica WHERE idFalla=" + idFalla + "";
            dato = Database.getSQL(sql);

        } catch (Exception e) {
            System.err.println("SQL Error: " + e.getMessage());
        }
        return dato;
    }

    public static boolean actualizarFalla(FallaMecanicaDTO f) {
       String sql = "";
        try {
            sql = "UPDATE fallamecanica SET chasisVehiculo='"+f.getChasisVehiculo()+"', nombreConductor='"+f.getNombreConductor()+"', "
                    + "fechaRegistro='"+f.getFechaRgistro()+"', descripcion='"+f.getDescripcionFalla()+"' WHERE idFalla="+f.getIdFalla()+"";
        } catch (Exception e) {
            System.err.println("SQL Error: " + e.getMessage());
        }
        return Database.ejecutarActualizacionSQL(sql);
    }

    public static boolean eliminarFalla(String idFalla) {
    String sql = "";
        try {
            sql = "DELETE FROM fallamecanica WHERE idFalla="+idFalla+"";
        } catch (Exception e) {
             System.err.println("SQL Error: " + e.getMessage());
        }
        return Database.ejecutarActualizacionSQL(sql);
    }

}
