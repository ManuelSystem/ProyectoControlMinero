/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FACADE;

import DAO.AuxiliarDAO;
import DAO.ConductorDAO;
import DAO.FallaMecanicaDAO;
import DAO.PersonaDAO;
import DTO.AuxiliarDTO;
import DTO.PersonaDTO;
import DTO.VehiculoDTO;
import DAO.VehiculoDAO;
import DTO.ConductorDTO;
import DTO.FallaMecanicaDTO;
import java.io.InputStream;
import java.util.ArrayList;

/**
 *
 * @author Manuel
 */
public class Facade {

    public ArrayList<String> iniciarSesion(String usuario, String clave) {
        PersonaDTO persona = new PersonaDTO(usuario, clave);
        return PersonaDAO.iniciarSesion(persona);
    }

    public boolean agregarPersona(String tipoDocumento, String numCedula, String nombres, String apellidos, String telefono, String email, String direccion, String generoSexo, String edad) {
        PersonaDTO a = new PersonaDTO(tipoDocumento, numCedula, nombres, apellidos, telefono, email, direccion, generoSexo, edad);
        return PersonaDAO.agregarPersona(a);
    }

    public ArrayList<String> obtenerDatosAuxiliar() {
        ArrayList<String> datos;
        datos = AuxiliarDAO.obtenerDatosAuxiliar();
        return datos;
    }

    public ArrayList<String> buscarIdPersona(String cedula) {
        ArrayList<String> dato;
        PersonaDTO p = new PersonaDTO(cedula);
        dato = PersonaDAO.buscarIdPersona(p);
        return dato;
    }

    public boolean agregarUsuarioAuxi(String descripcion, String fechaRegistro, String id) {
        AuxiliarDTO a = new AuxiliarDTO(id, descripcion, fechaRegistro);
        return AuxiliarDAO.agregarUsuarioAuxi(a);
    }

    public boolean actualizarPersona(String tipoDocumento, String numCedula, String nombres, String apellidos, String telefono, String email, String direccion, String generoSexo, String edad, String usuario, String password, String idPersona) {
        PersonaDTO a = new PersonaDTO(idPersona, tipoDocumento, numCedula, nombres, apellidos, telefono, email, direccion, generoSexo, edad, usuario, password);
        return PersonaDAO.actualizarPersona(a);
    }

    public boolean actualizarAuxiliar(String descripcion, String fechaRegistro, String id) {
        AuxiliarDTO a = new AuxiliarDTO(id, descripcion, fechaRegistro);
        return AuxiliarDAO.actualizarAuxi(a);
    }

    public ArrayList<String> obtenerDatosPersona(String cedula) {
        ArrayList<String> dato = new ArrayList<>();
        PersonaDTO persona = new PersonaDTO(cedula);
        persona = PersonaDAO.obtenerDatosPersona(persona);

        dato.add(persona.getIdPersona() + "/" + persona.getTipoDocumento() + "/" + persona.getCedulaPersona() + "/"
                + persona.getNombrePersona() + "/" + persona.getApellidoPersona() + "/" + persona.getTelefonoPersona() + "/"
                + persona.getCorreoPersona() + "/" + persona.getDireccionPersona() + "/" + persona.getSexoPersona() + "/" + persona.getEdad() + "/" + persona.getUsuario() + "/" + persona.getPassword()
                + "/" + persona.getRol());

        return dato;
    }

    public ArrayList<String> obtenerDatosAuxiliar(String idPersona, String idAuxiliar) {
        ArrayList<String> datos;
        datos = PersonaDAO.obtenerDatosAuxiliar(idPersona, idAuxiliar);
        return datos;
    }

    public boolean eliminarAuxiliar(String idAuxiliar) {
        AuxiliarDTO aux = new AuxiliarDTO(idAuxiliar);
        return AuxiliarDAO.eliminarAuxiliar(aux);
    }

    public boolean eliminarPersona(String idPersona) {
        PersonaDTO per = new PersonaDTO(idPersona);
        return PersonaDAO.eliminarPersona(per);
    }

    public boolean actualizarAdmin(String nombre, String apellido, String TipoDocumento, String cedula, String telefono, String email, String direccion, String sexo, String edad, String usuario, String contraseña, String idPersona) {
        PersonaDTO p = new PersonaDTO(idPersona, TipoDocumento, cedula, nombre, apellido, telefono, email, direccion, sexo, edad, usuario, contraseña);
        return PersonaDAO.actualizarAdmin(p);
    }

    public boolean agregarVehiculo(String marcaVehi, String modelo, String color, String chasis, String seguro, String tecnomecanica, String fechaRegis, InputStream inputStream) {
        VehiculoDTO v = new VehiculoDTO(marcaVehi, modelo, color, chasis, seguro, tecnomecanica, fechaRegis, inputStream);
        return VehiculoDAO.agregarVehiculo(v);
    }

    public ArrayList<String> validarSiExisteUnVehiculo(String chasis) {
        ArrayList<String> dato;
        dato = VehiculoDAO.validarSiExisteUnVehiculo(chasis);
        return dato;
    }

    public ArrayList<String> obtenerDatosVehiculo() {
        ArrayList<String> datos;
        datos = VehiculoDAO.obtenerDatosVehiculo();
        return datos;
    }

    public ArrayList<String> obtenerDatosVehiculo(String idVehiculo) {
        ArrayList<String> datos;
        datos = VehiculoDAO.obtenerDatosVehiculo(idVehiculo);
        return datos;
    }

    public boolean actualizarVehiculo(String marcaVehi, String modelo, String color, String chasis, String seguro, String tecnomecanica, String fechaRegis, String idVehiculo) {
        VehiculoDTO v = new VehiculoDTO(idVehiculo, marcaVehi, modelo, color, chasis, seguro, tecnomecanica, fechaRegis);
        return VehiculoDAO.actualizarVehiculo(v);
    }

    public boolean eliminarVehiculo(String iVehiculo) {
        return VehiculoDAO.eliminarVehiculo(iVehiculo);
    }

    public boolean agregarConductor(String tipoDocumento, String numCedula, String telefono, String nombres, String apellidos, String email, String direccion, String generoSexo, String edad, String licencia) {
        ConductorDTO c = new ConductorDTO(tipoDocumento, numCedula, nombres, apellidos, telefono, email, direccion, generoSexo, edad, licencia);
        return ConductorDAO.agregarConductor(c);
    }

    public ArrayList<String> obtenerDatosConductor() {
        ArrayList<String> datos;
        datos = ConductorDAO.obtenerDatosConductor();
        return datos;
    }

    public ArrayList<String> obtenerDatosConductor(String idConductor) {
        ArrayList<String> datos;
        datos = ConductorDAO.obtenerDatosConductor(idConductor);
        return datos;
    }

    public ArrayList<String> validarSiExisteUnConductor(String cedula) {
        ArrayList<String> dato;
        dato = ConductorDAO.validarSiExisteUnConductor(cedula);
        return dato;
    }

    public boolean actualizarConductor(String tipoDocumento, String numCedula, String telefono, String nombres, String apellidos, String email, String direccion, String generoSexo, String edad, String licencia, String idConductor) {
        ConductorDTO c = new ConductorDTO(idConductor, tipoDocumento, numCedula, nombres, apellidos, telefono, email, direccion, generoSexo, edad, licencia);
        return ConductorDAO.actualizarConductor(c);
    }

    public boolean eliminarConductor(String idConductor) {
        return ConductorDAO.eliminarConductor(idConductor);
    }

    public ArrayList<String> validarSiExisteFalla(String chasisVehi) {
        ArrayList<String> dato;
        dato = FallaMecanicaDAO.validarSiExisteFalla(chasisVehi);
        return dato;
    }

    public boolean agregarFalla(String chasisVehi, String conductor, String fechaRegistro, String descriFalla) {
        FallaMecanicaDTO f = new FallaMecanicaDTO(chasisVehi, conductor, fechaRegistro, descriFalla);
        return FallaMecanicaDAO.agregarFalla(f);
    }

    public ArrayList<String> obtenerDatosFalla() {
        ArrayList<String> datos;
        datos = FallaMecanicaDAO.obtenerDatosFalla();
        return datos;
    }

    public ArrayList<String> obtenerDatosFalla(String idFalla) {
        ArrayList<String> datos;
        datos = FallaMecanicaDAO.obtenerDatosFalla(idFalla);
        return datos;
    }

    public boolean actualizarFalla(String chasisVehi, String conductor, String fechaRegistro, String descriFalla, String idFalla) {
       FallaMecanicaDTO f = new FallaMecanicaDTO(idFalla, chasisVehi, conductor, fechaRegistro, descriFalla);
       return FallaMecanicaDAO.actualizarFalla(f);
    }

    public boolean eliminarFalla(String idFalla) {
    return FallaMecanicaDAO.eliminarFalla(idFalla);  
    }
}
