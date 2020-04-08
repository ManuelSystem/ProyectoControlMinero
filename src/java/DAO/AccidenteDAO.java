/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.AccidenteDTO;
import java.util.ArrayList;
import util.Database;

/**
 *
 * @author Manuel
 */
public class AccidenteDAO {

    public static ArrayList<String> validarSiExisteUnAccidente(String chasisVehicu) {
       ArrayList<String> dato = new ArrayList<>();
        try {

            String sql = "SELECT idAccidente FROM accidente WHERE chasisVehiculo='" + chasisVehicu + "'";
            dato = Database.getSQL(sql);

        } catch (Exception e) {
            System.err.println("SQL Error: " + e.getMessage());
        }

        return dato;
    
    }

    public static boolean agregarAccidente(AccidenteDTO acc) {
        String sql = "";
        try {
            sql = "INSERT INTO accidente (chasisVehiculo, cedulaConductor, nombreConductor, fechaRegistro, descripcion)"
                    + " VALUES('" + acc.getChasisVehiculo() + "','" + acc.getCedulaConductor() + "', '" + acc.getNombreConductor() + "','" + acc.getFechaAccidente()+ "','" + acc.getDescripcionAccidente()+ "')";
        } catch (Exception e) {
            System.err.println("SQL Error: " + e.getMessage());
        }
        System.out.println("guardando falla: " + sql);
        return Database.ejecutarActualizacionSQL(sql);
    }

    public static ArrayList<String> obtenerDatosAccidente() {
         ArrayList<String> dato = new ArrayList<>();
        try {

            String sql = "SELECT * FROM accidente";
            dato = Database.getSQL(sql);

        } catch (Exception e) {
            System.err.println("SQL Error: " + e.getMessage());
        }

        return dato;
    }

    public static ArrayList<String> obtenerDatosAccidente(String idAccidente) {
      ArrayList<String> dato = new ArrayList<>();
        try {

            String sql = "SELECT * FROM accidente WHERE idAccidente="+idAccidente+"";
            dato = Database.getSQL(sql);

        } catch (Exception e) {
            System.err.println("SQL Error: " + e.getMessage());
        }

        return dato;  
    }

    public static boolean atualizarAccidente(AccidenteDTO aci) {
    String sql = "";
        try {
            sql = "UPDATE accidente SET chasisVehiculo='"+aci.getChasisVehiculo()+"', cedulaConductor='"+aci.getCedulaConductor()+"', "
                    + "nombreConductor='"+aci.getNombreConductor()+"', fechaRegistro='"+aci.getFechaAccidente()+"', descripcion='"+aci.getDescripcionAccidente()+"'"
                    + "WHERE idAccidente="+aci.getIdAccidente()+"";
        } catch (Exception e) {
        }
        return Database.ejecutarActualizacionSQL(sql);     
    }

    public static boolean eliminarAccidente(String idAccidente) {
        String sql = "";
        try {
            sql = "DELETE FROM accidente WHERE idAccidente="+idAccidente+"";
        } catch (Exception e) {
             System.err.println("SQL Error Delete: " + e.getMessage());
        }
         System.out.print("no elimina accidente: "+sql);
        return Database.ejecutarActualizacionSQL(sql);
    }
    
}
