/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.PersonaDTO;
import java.util.ArrayList;
import util.Database;

/**
 *
 * @author Manuel
 */
public class PersonaDAO {

    public static ArrayList<String> iniciarSesion(PersonaDTO persona) {
     ArrayList<String> dato = new ArrayList<>();
     String sql="";
        try {
              sql="SELECT * FROM persona, rol WHERE persona.idRol=rol.idRol AND persona.usuario='"+persona.getUsuario()+"'"
                     + " AND persona.passwordd='"+persona.getPassword()+"'";
             dato=Database.getSQL(sql);
        } catch (Exception e) {
            System.out.println("Falló consulta de usuario, iniciar sesión"+e);
        }
        return dato;
    }

    public static boolean agregarPersona(PersonaDTO a) {
    String sql = "";
        try {
            sql = "INSERT INTO persona (tipoDocumento,cedulaPersona,nombrePersona,apellidoPersona,TelefonoPersona,email,"
                    + "direccionPersona,sexoPersona,edad,usuario,passwordd,idRol) "
                    + "VALUES('"+a.getTipoDocumento()+"', '"+a.getCedulaPersona()+"', '"+a.getNombrePersona()+"', "
                    + "'"+a.getApellidoPersona()+"', '"+a.getTelefonoPersona()+"', '"+a.getCorreoPersona()+"', "
                    + "'"+a.getDireccionPersona()+"', '"+a.getSexoPersona()+"', "
                    + "'"+a.getEdad()+"', '"+a.getCedulaPersona()+"', '"+a.getCedulaPersona()+"', 2)";
        } catch (Exception e) {
             System.out.println("Falló el agregar usuario"+e);
        }
        return Database.ejecutarActualizacionSQL(sql);
    }

    public static ArrayList<String> buscarIdPersona(PersonaDTO p) {
    String sql = "";
        ArrayList<String> dato = new ArrayList<>();
        try {
            sql = "SELECT idPersona FROM persona WHERE cedulaPersona='"+p.getIdPersona()+"'";
            dato = Database.getSQL(sql);
        } catch (Exception e) {
        }
        return dato;
    }

    public static boolean actualizarPersona(PersonaDTO a) {
     String sql = "";
        try {
            sql = "UPDATE persona SET tipoDocumento='"+a.getTipoDocumento()+"', cedulaPersona='"+a.getCedulaPersona()+"', "
                    + "nombrePersona='"+a.getNombrePersona()+"', apellidoPersona='"+a.getApellidoPersona()+"', "
                    + "TelefonoPersona='"+a.getTelefonoPersona()+"', email='"+a.getCorreoPersona()+"', "
                    + "direccionPersona='"+a.getDireccionPersona()+"',  "
                    + "sexoPersona='"+a.getSexoPersona()+"', edad='"+a.getEdad()+"', "
                    + "usuario='"+a.getUsuario()+"', passwordd='"+a.getPassword()+"' WHERE idPersona="+a.getIdPersona()+"";
        } catch (Exception e) {
            System.err.println(e);
        }
        System.out.println("actualiza persona: "+sql);
        return Database.ejecutarActualizacionSQL(sql); 
    }

    public static PersonaDTO obtenerDatosPersona(PersonaDTO persona) {
     ArrayList<String> dato;
        try {
       
            String sql = "SELECT * FROM persona WHERE cedulaPersona='"+persona.getIdPersona()+"'";
            dato=Database.getSQL(sql);
            
            String separado = dato.toString();
        
            String[] pars = separado.split("/");
            
            persona.setIdPersona(pars[0].replace("[", ""));
            persona.setTipoDocumento(pars[1]);
            persona.setCedulaPersona(pars[2]);
            persona.setNombrePersona(pars[3]);
            persona.setApellidoPersona(pars[4]);
            persona.setTelefonoPersona(pars[5]);
            persona.setCorreoPersona(pars[6]);
            persona.setDireccionPersona(pars[7]);
            persona.setSexoPersona(pars[8]);
            persona.setEdad(pars[9]);
            persona.setUsuario(pars[10]);
            persona.setPassword(pars[11]);
            persona.setRol(pars[12]);
            
        } catch (Exception e) {
            System.err.println("SQL Error: " + e.getMessage());
        }

        return persona;
    }

    public static ArrayList<String> obtenerDatosAuxiliar(String idPersona, String idAuxiliar) {
      ArrayList<String> dato = new ArrayList<>();
        try {
       
            String sql = "SELECT * FROM persona, auxiliar WHERE auxiliar.idPersona=persona.idPersona "
                    + "AND persona.idRol=2 AND persona.idPersona="+idPersona+" AND auxiliar.idAuxiliar="+idAuxiliar+"";
            dato=Database.getSQL(sql);
            
        } catch (Exception e) {
            System.err.println("SQL Error: " + e.getMessage());
        }

        return dato; 
    }

    public static boolean eliminarPersona(PersonaDTO per) {
    String sql="";
        try {
            sql="DELETE FROM persona WHERE idPersona="+per.getIdPersona()+"";
        } catch (Exception e) {
           
        }
         
        return Database.ejecutarActualizacionSQL(sql);
       
    }

    public static boolean actualizarAdmin(PersonaDTO p) {
        String sql = "";
        try {
            sql = "UPDATE persona SET tipoDocumento='"+p.getTipoDocumento()+"', cedulaPersona='"+p.getCedulaPersona()+"', "
                    + "nombrePersona='"+p.getNombrePersona()+"', apellidoPersona='"+p.getApellidoPersona()+"', "
                    + "TelefonoPersona='"+p.getTelefonoPersona()+"', email='"+p.getCorreoPersona()+"', "
                    + "direccionPersona='"+p.getDireccionPersona()+"', "
                    + "sexoPersona='"+p.getSexoPersona()+"', edad='"+p.getEdad()+"', "
                    + "usuario='"+p.getUsuario()+"', passwordd='"+p.getPassword()+"' WHERE idPersona="+p.getIdPersona()+"";
        } catch (Exception e) {
        }
        System.out.println("datos admin:"+sql);
        return Database.ejecutarActualizacionSQL(sql);
    }

}
