/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.VehiculoDTO;
import java.sql.Blob;
import java.util.ArrayList;
import util.Database;

/**
 *
 * @author Manuel
 */
public class VehiculoDAO {

    public static boolean agregarVehiculo(VehiculoDTO v) {
         String sql = "";
        try {
            sql = "INSERT INTO vehiculo (marcaVehiculo, modeloVehiculo, colorVehiculo, chasisVehiculo, seguroVehiculo, tecnomecanicaVehi, fechaRegistro, imagenVehi)"
                    + " VALUES('"+v.getMarcaVehi()+ "','"+v.getModeloVehi()+"','"+v.getColorVehi()+"','"+v.getChasisVehi()+"', "
                    + "'"+v.getSeguroVehi()+"','"+v.getTecnomecaVehi()+"','"+v.getFechaRegistroV()+"','"+v.getImgVehi()+"')";
        } catch (Exception e) {
            System.err.println("SQL Error: " + e.getMessage());
        }
        System.out.println("guardando vehiculo: "+sql);
        return Database.ejecutarActualizacionSQL(sql);
    }


    public static ArrayList<String> obtenerDatosVehiculo() {
       ArrayList<String> dato = new ArrayList<>();
        try {
       
            String sql = "SELECT * FROM vehiculo";
            dato=Database.getSQL(sql);
            
        } catch (Exception e) {
            System.err.println("SQL Error: " + e.getMessage());
        }

        return dato; 
    }

    public static ArrayList<String> validarSiExisteUnVehiculo(String chasis) {
     ArrayList<String> dato = new ArrayList<>();
        try {
       
            String sql = "SELECT idVehiculo FROM vehiculo WHERE chasisVehiculo='"+chasis+"'";
            dato=Database.getSQL(sql);
            
        } catch (Exception e) {
            System.err.println("SQL Error: " + e.getMessage());
        }

        return dato;      
    }

    public static ArrayList<String> obtenerDatosVehiculo(String idVehiculo) {
      ArrayList<String> dato = new ArrayList<>();
        try {
       
            String sql = "SELECT * FROM vehiculo WHERE idVehiculo="+idVehiculo+"";
            dato=Database.getSQL(sql);
            
        } catch (Exception e) {
            System.err.println("SQL Error: " + e.getMessage());
        }
        return dato;
    }

    public static boolean actualizarVehiculo(VehiculoDTO v) {
        String sql = "";
        try {
            sql = "UPDATE vehiculo SET marcaVehiculo='"+v.getMarcaVehi()+"', modeloVehiculo='"+v.getModeloVehi()+"', "
                    + "colorVehiculo='"+v.getColorVehi()+"', chasisVehiculo='"+v.getChasisVehi()+"', seguroVehiculo='"+v.getSeguroVehi()+"', "
                    + "tecnomecanicaVehi='"+v.getTecnomecaVehi()+"', fechaRegistro='"+v.getFechaRegistroV()+"' WHERE idVehiculo="+v.getIdVehiculo()+"";
        } catch (Exception e) {
        }
        return Database.ejecutarActualizacionSQL(sql); 
    }

    public static boolean eliminarVehiculo(String iVehiculo) {
       String sql = "";
        try {
            sql = "DELETE FROM vehiculo WHERE idVehiculo="+iVehiculo+"";
        } catch (Exception e) {
             System.err.println("SQL Error Delete: " + e.getMessage());
        }
         System.out.print("no elimina vehiculo: "+sql);
        return Database.ejecutarActualizacionSQL(sql);
    }

    public static ArrayList<String> obtenerValoresVehi() {
        ArrayList<String> datos = new ArrayList<String>();
        
        try {
            String sql = "SELECT COUNT(*) FROM vehiculo";
            datos = Database.getSQL(sql);
            System.out.println(sql);
        } catch (Exception e) {
            System.err.println("SQL Error dao: " + e.getMessage());
        }
        
        return datos;
    }

    
}
