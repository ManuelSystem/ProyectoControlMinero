/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.CargamentoDTO;
import java.util.ArrayList;
import util.Database;

/**
 *
 * @author Manuel
 */
public class CargamentoDAO {

    public static ArrayList<String> validarSiExisteCargamento(String pesoVacio) {
        ArrayList<String> dato = new ArrayList<>();
        try {

            String sql = "SELECT idCargamento FROM cargamento WHERE pesoVacio='" + pesoVacio + "'";
            dato = Database.getSQL(sql);

        } catch (Exception e) {
            System.err.println("SQL Error: " + e.getMessage());
        }

        return dato;
    }

    public static boolean agregarCargamento(CargamentoDTO car) {

        String sql = "";
        try {
            sql = "INSERT INTO cargamento (vehiculo, conductor, materialMinero, patio, pesoVacio, pesoCargado, pesoNeto, fechaCargamento)"
                    + " VALUES('" + car.getChasisvehiculo() + "', '" + car.getConductor() + "', '" + car.getMaterialMinero() + "',"
                    + "'" + car.getPatio() + "', '" + car.getVehiculoVacio() + "', '" + car.getVehiculoCargado() + "', '" + car.getPesoNeto() + "', '" + car.getFechaCargamento() + "')";
        } catch (Exception e) {
            System.err.println("SQL Error al guardar cargamento: " + e.getMessage());
        }
        return Database.ejecutarActualizacionSQL(sql);
    }

    public static ArrayList<String> obtenerDatosCargamentos() {
        ArrayList<String> dato = new ArrayList<>();
        try {
            String sql = "SELECT * FROM cargamento";
            dato = Database.getSQL(sql);
        } catch (Exception e) {
            System.err.println("SQL Error: " + e.getMessage());
        }
        return dato;
    }

    public static ArrayList<String> obtenerDatosCargamentos(String idCargamento) {
         ArrayList<String> dato = new ArrayList<>();
        try {
            String sql = "SELECT * FROM cargamento WHERE idCargamento="+idCargamento+"";
            dato = Database.getSQL(sql);
        } catch (Exception e) {
            System.err.println("SQL Error de devolver datos para editar: " + e.getMessage());
        }
        return dato;
    }

    public static boolean actualizarCargamento(CargamentoDTO carga) {
    String sql = "";
        try {
            sql = "UPDATE cargamento SET vehiculo='"+carga.getChasisvehiculo()+"', conductor='"+carga.getConductor()+"', "
   + "materialMinero='"+carga.getMaterialMinero()+"', patio='"+carga.getPatio()+"', pesoVacio='"+carga.getVehiculoVacio()+"' "
                    + ", pesoCargado='"+carga.getVehiculoCargado()+"', pesoNeto='"+carga.getPesoNeto()+"' "
                    + ", fechaCargamento='"+carga.getFechaCargamento()+"' WHERE idCargamento="+carga.getIdCargamento()+"";
        } catch (Exception e) {
            System.err.println("SQL Error: " + e.getMessage());
        }
        return Database.ejecutarActualizacionSQL(sql);
    }    

    public static boolean eliminarCarga(String idCargamento) {
    String sql = "";
        try {
            sql = "DELETE FROM cargamento WHERE idCargamento="+idCargamento+"";
        } catch (Exception e) {
             System.err.println("SQL Error: " + e.getMessage());
        }
        return Database.ejecutarActualizacionSQL(sql);    
    }

    public static ArrayList<String> obtenereTotalCargamento() {
    ArrayList<String> datos = new ArrayList<>();
        try {
            String sql = "SELECT SUM(pesoNeto) FROM cargamento";
            datos = Database.getSQL(sql);
        } catch (Exception e) {
            System.err.println("SQL Error total cargamentos: " + e.getMessage());
        }
        return datos;
    }
}
