/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.AuxiliarDTO;
import DTO.PersonaDTO;
import java.util.ArrayList;
import util.Database;

/**
 *
 * @author Manuel
 */
public class AuxiliarDAO {

    public static boolean agregarUsuarioAuxi(AuxiliarDTO a) {
        String sql = "";
        try {
            sql = "INSERT INTO auxiliar (DescripcionOperacion, fechaRegistro, idPersona)"
                    + " VALUES('"+a.getDescripcion() + "','" + a.getFechaRegistro() + "', " + a.getIdAuxiliar() + ")";
        } catch (Exception e) {
        }
        return Database.ejecutarActualizacionSQL(sql);
    }

    public static ArrayList<String> obtenerDatosAuxiliar() {
        ArrayList<String> datos = new ArrayList<>();
        try {

            String sql = "SELECT * FROM persona, auxiliar WHERE auxiliar.idPersona=persona.idPersona AND persona.idRol=2";
            datos = Database.getSQL(sql);

        } catch (Exception e) {
            System.err.println("SQL Error: " + e.getMessage());
        }

        return datos;

    }

    public static boolean actualizarAuxi(AuxiliarDTO a) {

        String sql = "";
        try {
            sql = "UPDATE auxiliar SET DescripcionOperacion='" +a.getDescripcion()+ "', fechaRegistro='" +a.getFechaRegistro() +"'"
                    + " WHERE idAuxiliar="+a.getIdAuxiliar()+"";
        } catch (Exception e) {
        }
        System.out.println("error actualiza auxi: "+sql);
        return Database.ejecutarActualizacionSQL(sql);
    }

    public static boolean eliminarAuxiliar(AuxiliarDTO aux) {
    String sql="";
        try {
            sql="DELETE FROM auxiliar WHERE idAuxiliar="+aux.getIdAuxiliar()+"";
        } catch (Exception e) {
            System.err.println("SQL Error Delete: " + e.getMessage());
        }
       
         return Database.ejecutarActualizacionSQL(sql);
    }

  

}
