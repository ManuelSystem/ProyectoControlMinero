/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.PatioDTO;
import java.util.ArrayList;
import util.Database;

/**
 *
 * @author Manuel
 */
public class PatioDAO {

    public static ArrayList<String> validarSiExisteUnPatio(String nomPatio) {
        ArrayList<String> dato = new ArrayList<>();
        try {

            String sql = "SELECT idPatioFROM patiodescargue WHERE nombrePatio='" + nomPatio + "'";
            dato = Database.getSQL(sql);

        } catch (Exception e) {
            System.err.println("SQL Error: " + e.getMessage());
        }

        return dato;
    }

    public static boolean agregarPatioDescargue(PatioDTO pa) {
        String sql = "";
        try {
            sql = "INSERT INTO patiodescargue(departamento, municipio, nombrePatio, distanciaPatio, descrpcionPatio) VALUE"
                    + "('" + pa.getDepartamento() + "', '" + pa.getMunicipio() + "', '" + pa.getNombrePatio() + "', "
                    + "'" + pa.getDistanica() + "', '" + pa.getDescripcion() + "')";

        } catch (Exception e) {
            System.err.println("SQL Error: " + e.getMessage());
        }
        System.out.println("guardando patio: " + sql);
        return Database.ejecutarActualizacionSQL(sql);
    }

    public static ArrayList<String> obtenerDatosPatio() {

        ArrayList<String> dato = new ArrayList<>();
        try {

            String sql = "SELECT * FROM patiodescargue";
            dato = Database.getSQL(sql);

        } catch (Exception e) {
            System.err.println("SQL Error: " + e.getMessage());
        }

        return dato;
    }

    public static ArrayList<String> obtenerDatosPatio(String idPatio) {
        ArrayList<String> dato = new ArrayList<>();
        try {

            String sql = "SELECT * FROM patiodescargue WHERE idPatio=" + idPatio + "";
            dato = Database.getSQL(sql);

        } catch (Exception e) {
            System.err.println("SQL Error: " + e.getMessage());
        }

        return dato;
    }

    public static boolean actualizarPatio(PatioDTO pat) {
        String sql = "";
        try {
            sql = "UPDATE patiodescargue SET departamento='" + pat.getDepartamento() + "', municipio='" + pat.getMunicipio() + "',"
                    + "nombrePatio= '" + pat.getNombrePatio() + "', distanciaPatio= '" + pat.getDistanica() + "', descrpcionPatio= '" + pat.getDescripcion() + "'"
                    + "WHERE idPatio=" + pat.getIdPatio() + " ";
        } catch (Exception e) {
            System.err.println("SQL Error Update: " + e.getMessage());
        }
        return Database.ejecutarActualizacionSQL(sql);
    }

    public static boolean eliminarPatio(String idPatio) {
        String sql = "";
        try {
            sql = "DELETE FROM patiodescargue WHERE idPatio="+idPatio+"";
        } catch (Exception e) {
            System.err.println("SQL Error Delete: " + e.getMessage());
        }
        return Database.ejecutarActualizacionSQL(sql);
    }

}
