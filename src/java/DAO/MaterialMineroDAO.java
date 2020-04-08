/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.MaterialMineroDTO;
import java.util.ArrayList;
import util.Database;

/**
 *
 * @author Manuel
 */
public class MaterialMineroDAO {

    public static ArrayList<String> validarSiExisteMaterial(String nombreMaterial) {
    ArrayList<String> dato = new ArrayList<>();
        try {

            String sql = "SELECT idMaterial FROM materialminero WHERE nombreMaterial='" + nombreMaterial + "'";
            dato = Database.getSQL(sql);

        } catch (Exception e) {
            System.err.println("SQL Error: " + e.getMessage());
        }

        return dato;    
    }

    public static boolean agregarMaterial(MaterialMineroDTO ma) {
    String sql= "";
        try {
            sql = "INSERT INTO materialminero(tipoMaterial, nombreMaterial, descrpcion) VALUE"
                    + "('" + ma.getTipoMaterial() + "', '" + ma.getNombreMaterial() + "', '" + ma.getDescripcion() + "')";
            
        } catch (Exception e) {
            System.err.println("SQL Error: " + e.getMessage());
        }
        System.out.println("guardando material: " + sql);
        return Database.ejecutarActualizacionSQL(sql);
    }

    public static ArrayList<String> obtenerDatosMaterial() {
        ArrayList<String> dato = new ArrayList<>();
        try {

            String sql = "SELECT * FROM materialminero";
            dato = Database.getSQL(sql);

        } catch (Exception e) {
            System.err.println("SQL Error: " + e.getMessage());
        }

        return dato;
    }

    public static ArrayList<String> obtenerDatosMaterial(String idMaterial) {
        ArrayList<String> dato = new ArrayList<>();
        try {

            String sql = "SELECT * FROM materialminero WHERE idMaterial="+idMaterial+"";
            dato = Database.getSQL(sql);

        } catch (Exception e) {
            System.err.println("SQL Error: " + e.getMessage());
        }

        return dato;
    
    }

    public static boolean actualizarMaterial(MaterialMineroDTO ma) {
        String sql = "";
        try {
            sql = "UPDATE materialminero SET tipoMaterial='"+ma.getTipoMaterial()+"', nombreMaterial='"+ma.getNombreMaterial()+"', "
                    + "descrpcion='"+ma.getDescripcion()+"' WHERE idMaterial="+ma.getIdMaterial()+"";
        } catch (Exception e) {
            System.err.println("SQL Error: " + e.getMessage());
        }
        return Database.ejecutarActualizacionSQL(sql);
    }

    public static boolean eliminarMaterial(String idMaterial) {
        String sql = "";
        try {
            sql = "DELETE FROM materialminero WHERE idMaterial="+idMaterial+" ";
            
        } catch (Exception e) {
            System.err.println("SQL Error: " + e.getMessage());
        }
        return Database.ejecutarActualizacionSQL(sql);
    }
    
}
