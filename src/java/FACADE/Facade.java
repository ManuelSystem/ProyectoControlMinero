/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FACADE;

import DAO.AccidenteDAO;
import DAO.AuxiliarDAO;
import DAO.CargamentoDAO;
import DAO.ConductorDAO;
import DAO.FallaMecanicaDAO;
import DAO.MaterialMineroDAO;
import DAO.MineroDAO;
import DAO.PatioDAO;
import DAO.PersonaDAO;
import DAO.ProduccionMineroDAO;
import DTO.AuxiliarDTO;
import DTO.PersonaDTO;
import DTO.VehiculoDTO;
import DAO.VehiculoDAO;
import DTO.AccidenteDTO;
import DTO.CargamentoDTO;
import DTO.ConductorDTO;
import DTO.FallaMecanicaDTO;
import DTO.MaterialMineroDTO;
import DTO.MineroDTO;
import DTO.PatioDTO;
import DTO.ProduccionMineroDTO;
import java.util.ArrayList;

/**
 *
 * @author Manuel
 */
public class Facade {

    public ArrayList<String> iniciarSesion(String usuario, String clave) {
        ArrayList<String> datos = new ArrayList<>();
        try {
            PersonaDTO persona = new PersonaDTO(usuario, clave);
            datos = PersonaDAO.iniciarSesion(persona);
        } catch (Exception e) {
        }
        return datos;
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

    public boolean agregarVehiculo(String marcaVehi, String modelo, String color, String chasis, String seguro, String tecnomecanica, String fechaRegis, String imagen) {
        VehiculoDTO v = new VehiculoDTO(marcaVehi, modelo, color, chasis, seguro, tecnomecanica, fechaRegis, imagen);
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

    public ArrayList<String> validarSiExisteFalla(String fechaRegistro) {
        ArrayList<String> dato;
        dato = FallaMecanicaDAO.validarSiExisteFalla(fechaRegistro);
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

    public ArrayList<String> validarSiExisteUnAccidente(String fechaaccidente) {
        ArrayList<String> dato;
        dato = AccidenteDAO.validarSiExisteUnAccidente(fechaaccidente);
        return dato;
    }

    public boolean agregarAccidente(String chasisVehicu, String cedulaCondu, String fechaaccidente, String descripcionAcci) {
        AccidenteDTO acc = new AccidenteDTO(chasisVehicu, cedulaCondu, fechaaccidente, descripcionAcci);
        return AccidenteDAO.agregarAccidente(acc);
    }

    public ArrayList<String> obtenerDatosAccidente() {
        ArrayList<String> dato;
        dato = AccidenteDAO.obtenerDatosAccidente();
        return dato;
    }

    public ArrayList<String> obtenerDatosAccidente(String idAccidente) {
        ArrayList<String> datos;
        datos = AccidenteDAO.obtenerDatosAccidente(idAccidente);
        return datos;
    }

    public boolean atualizarAccidente(String idAccidente, String chasisVehicu, String cedulaCondu, String fechaaccidente, String descripcionAcci) {
        AccidenteDTO aci = new AccidenteDTO(idAccidente, chasisVehicu, cedulaCondu, fechaaccidente, descripcionAcci);
        return AccidenteDAO.atualizarAccidente(aci);
    }


    public ArrayList<String> validarSiExisteMaterial(String nombreMaterial) {
        ArrayList<String> dato;
        dato = MaterialMineroDAO.validarSiExisteMaterial(nombreMaterial);
        return dato;
    }

    public boolean agregarMaterial(String tipoMaterial, String nombreMaterial, String descripcion) {
        MaterialMineroDTO ma = new MaterialMineroDTO(tipoMaterial, nombreMaterial, descripcion);
        return MaterialMineroDAO.agregarMaterial(ma);
    }

    public ArrayList<String> obtenerDatosMaterial() {
        ArrayList<String> dato;
        dato = MaterialMineroDAO.obtenerDatosMaterial();
        return dato;
    }

    public ArrayList<String> obtenerDatosMaterial(String idMaterial) {
        ArrayList<String> datos;
        datos = MaterialMineroDAO.obtenerDatosMaterial(idMaterial);
        return datos;
    }

    public boolean actualizarMaterial(String idMaterial, String tipoMaterial, String nombreMaterial, String descripcion) {
        MaterialMineroDTO ma = new MaterialMineroDTO(idMaterial, tipoMaterial, nombreMaterial, descripcion);
        return MaterialMineroDAO.actualizarMaterial(ma);
    }

    public boolean eliminarMaterial(String idMaterial) {
        return MaterialMineroDAO.eliminarMaterial(idMaterial);
    }

    public ArrayList<String> validarSiExisteUnPatio(String nomPatio) {
        ArrayList<String> dato;
        dato = PatioDAO.validarSiExisteUnPatio(nomPatio);
        return dato;
    }

    public boolean agregarPatioDescargue(String departamento, String municipio, String nomPatio, String distancia, String descripcion) {
        PatioDTO pa = new PatioDTO(departamento, municipio, nomPatio, distancia, descripcion);
        return PatioDAO.agregarPatioDescargue(pa);
    }

    public ArrayList<String> obtenerDatosPatio() {
        ArrayList<String> dato;
        dato = PatioDAO.obtenerDatosPatio();
        return dato;
    }

    public ArrayList<String> obtenerDatosPatio(String idPatio) {
        ArrayList<String> dato;
        dato = PatioDAO.obtenerDatosPatio(idPatio);
        return dato;
    }

    public boolean actualizarPatio(String idPatio, String departamento, String municipio, String nomPatio, String distancia, String descripcion) {
        PatioDTO pat = new PatioDTO(idPatio, departamento, municipio, nomPatio, distancia, descripcion);
        return PatioDAO.actualizarPatio(pat);
    }

    public boolean eliminarPatio(String idPatio) {
        return PatioDAO.eliminarPatio(idPatio);
    }

    public ArrayList<String> validarSiExisteCargamento(String pesoVacio) {
        ArrayList<String> dato;
        dato = CargamentoDAO.validarSiExisteCargamento(pesoVacio);
        return dato;
    }

    public boolean agregarCargamento(String vehiculo, String conductor, String material, String patio, String pesoVacio, String pesoCargado, String pesoNeto, String fechaCargamento) {
        CargamentoDTO car = new CargamentoDTO(vehiculo, conductor, material, patio, pesoVacio, pesoCargado, pesoNeto, fechaCargamento);
        return CargamentoDAO.agregarCargamento(car);
    }

    public ArrayList<String> obtenerDatosCargamentos() {
        ArrayList<String> dato;
        dato = CargamentoDAO.obtenerDatosCargamentos();
        return dato;
    }

    public ArrayList<String> obtenerDatosCargamentos(String idCargamento) {
        ArrayList<String> dato;
        dato = CargamentoDAO.obtenerDatosCargamentos(idCargamento);
        return dato;
    }

    public boolean actualizarCargamento(String idCargamento, String vehiculo, String conductor, String material, String patio, String pesoVacio, String pesoCargado, String pesoNeto, String fechaCargamento) {
        CargamentoDTO carga = new CargamentoDTO(idCargamento, vehiculo, conductor, material, patio, pesoVacio, pesoCargado, pesoNeto, fechaCargamento);
        return CargamentoDAO.actualizarCargamento(carga);
    }

    public boolean eliminarCarga(String idCargamento) {
        return CargamentoDAO.eliminarCarga(idCargamento);
    }

    public ArrayList<String> obtenereValores() {
        ArrayList<String> datos;
        datos = ConductorDAO.obtenereValores();
        return datos;
    }

    public ArrayList<String> obtenerValoresVehi() {
        ArrayList<String> datos;
        datos = VehiculoDAO.obtenerValoresVehi();
        return datos;
    }

    public ArrayList<String> obtenerValoresAcci() {
        ArrayList<String> datos;
        datos = AccidenteDAO.obtenerValoresAcci();
        return datos;
    }

    public ArrayList<String> obtenerValoresFalla() {
        ArrayList<String> datoss;
        datoss = FallaMecanicaDAO.obtenerValoresFalla();
        return datoss;
    }

    public ArrayList<String> obtenerValoresPatio() {
        ArrayList<String> datoss;
        datoss = PatioDAO.obtenerValoresPatio();
        return datoss;
    }

    public ArrayList<String> obtenerValoresMinero() {
        ArrayList<String> dates;
        dates = MineroDAO.obtenerValoresMinero();
        return dates;
    }

    public ArrayList<String> validarSiExisteMinero(String numCedula) {
        ArrayList<String> dato;
        dato = MineroDAO.validarSiExisteMinero(numCedula);
        return dato;
    }

    public boolean agregarMinero(String tipoDocumento, String numCedula, String telefono, String nombres, String apellidos, String direccion, String edad, String fecha) {
        boolean dato = true;
        try {
            MineroDTO m = new MineroDTO(tipoDocumento, numCedula, nombres, apellidos, telefono, direccion, edad, fecha);
            dato = MineroDAO.agregarMinero(m);
        } catch (Exception e) {
        }
        return dato;

    }

    public ArrayList<String> obtenerDatosMinero() {
        ArrayList<String> dato;
        dato = MineroDAO.obtenerDatosMinero();
        return dato;
    }

    public ArrayList<String> obtenerDatosMinero(String idMinero) {
        ArrayList<String> dato;
        dato = MineroDAO.obtenerDatosMinero(idMinero);
        return dato;
    }

    public boolean actualizarMinero(String idMinero, String tipoDocumento, String numCedula, String telefono, String nombres, String apellidos, String direccion, String edad, String fecha) {
        MineroDTO mi = new MineroDTO(idMinero, tipoDocumento, numCedula, nombres, apellidos, telefono, direccion, edad, fecha);
        return MineroDAO.actualizarMinero(mi);
    }

    public boolean eliminarMinero(String idMinero) {
        return MineroDAO.eliminarMinero(idMinero);
    }

    public ArrayList<String> validarSiExisteProduccion(String produccion) {
        ArrayList<String> dato;
        dato = ProduccionMineroDAO.validarSiExisteProduccion(produccion);
        return dato;
    }

    public boolean agregrarProduccion(String nombreMine, String turno, String produccion, String fechaRegistro) {
        ProduccionMineroDTO pm = new ProduccionMineroDTO(nombreMine, turno, produccion, fechaRegistro);
        return ProduccionMineroDAO.agregrarProduccion(pm);
    }
    public ArrayList<String> obtenerDatosProduccion() {
        ArrayList<String> dato;
        dato = ProduccionMineroDAO.obtenerDatosProduccion();
        return dato;
    }
    public ArrayList<String> obtenerDatosProduccion(String idProduccion) {
        ArrayList<String> datos;
        datos = ProduccionMineroDAO.obtenerDatosProduccion(idProduccion);
        return datos;
    }

    public boolean actualizarProduccion(String idProduccion, String nombreMine, String turno, String produccion, String fechaRegistro) {
        ProduccionMineroDTO p = new ProduccionMineroDTO(idProduccion, nombreMine, turno, produccion, fechaRegistro);
        return ProduccionMineroDAO.actualizarProduccion(p);
    }
    public ArrayList<String> obtenereTotalCargamento() {
        ArrayList<String> dates;
        dates = CargamentoDAO.obtenereTotalCargamento();
        return dates;
    }
    public ArrayList<String> obtenereTotalProduccionMinero() {
        ArrayList<String> dates;
        dates = ProduccionMineroDAO.obtenereTotalProduccionMinero();
        return dates;
    }
}
