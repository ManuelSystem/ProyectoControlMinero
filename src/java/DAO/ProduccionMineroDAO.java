/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.ProduccionMineroDTO;
import java.util.ArrayList;
import util.Database;

/**
 *
 * @author Manuel
 */
public class ProduccionMineroDAO {

    public static ArrayList<String> validarSiExisteProduccion(String produccion) {
        ArrayList<String> dato = new ArrayList<>();
        try {

            String sql = "SELECT idProduccion FROM produccionminero WHERE cantidadProduDiaria='" + produccion + "'";
            dato = Database.getSQL(sql);
        } catch (Exception e) {
            System.err.println("SQL Error: " + e.getMessage());
        }

        return dato;
    }

    public static boolean agregrarProduccion(ProduccionMineroDTO pm) {
        String sql = "";
        try {
            sql = "INSERT INTO produccionminero (nombreMinero, horarioTurno, cantidadProduDiaria, fechaRegistro) VALUES"
                    + "('" + pm.getNombreMinero() + "', '" + pm.getHorarioTurno() + "', '" + pm.getTotalProducido() + "', '" + pm.getFechaRgistro() + "')";
        } catch (Exception e) {
            System.err.println("SQL Error Insert produccionminero: " + e.getMessage());
        }
        return Database.ejecutarActualizacionSQL(sql);
    }

    public static ArrayList<String> obtenerDatosProduccion() {
        ArrayList<String> dato = new ArrayList<>();
        try {

            String sql = "SELECT * FROM produccionminero";
            dato = Database.getSQL(sql);
        } catch (Exception e) {
            System.err.println("SQL Error: " + e.getMessage());
        }

        return dato;
    }

    public static ArrayList<String> obtenerDatosProduccion(String idProduccion) {
        ArrayList<String> dato = new ArrayList<>();
        try {

            String sql = "SELECT * FROM produccionminero WHERE idProduccion='" + idProduccion + "'";
            dato = Database.getSQL(sql);
        } catch (Exception e) {
            System.err.println("SQL Error: " + e.getMessage());
        }

        return dato;
    }

    public static boolean actualizarProduccion(ProduccionMineroDTO p) {
    String sql ="";
        try {
            sql = "UPDATE produccionminero SET nombreMinero='"+p.getNombreMinero()+"', horarioTurno='"+p.getHorarioTurno()+"',"
                    + " cantidadProduDiaria='"+p.getTotalProducido()+"', fechaRegistro='"+p.getFechaRgistro()+"' WHERE idProduccion="+p.getIdProduccion()+"";
        } catch (Exception e) {
            System.err.println("SQL Error Update produccion: " + e.getMessage());
        }
        return Database.ejecutarActualizacionSQL(sql);
    }

    public static ArrayList<String> obtenereTotalProduccionMinero() {
         ArrayList<String> datos = new ArrayList<>();
        try {
            String sql = "SELECT SUM(cantidadProduDiaria) FROM produccionminero";
            datos = Database.getSQL(sql);
        } catch (Exception e) {
            System.err.println("SQL Error total produccion Minero: " + e.getMessage());
        }
        return datos;
    }
}