/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author Manuel
 */
public class MineroDTO {
    private String idMinero;
    private String tipoDocumento;
    private String numeroDocu;
    private String nombre;
    private String apellido;
    private String telefono;
    private String direccion;
    private String edad;
    private String fechaRegistro;

    public MineroDTO(String idMinero, String tipoDocumento, String numeroDocu, String nombre, String apellido, String telefono, String direccion, String edad, String fechaRegistro) {
        this.idMinero = idMinero;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocu = numeroDocu;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.direccion = direccion;
        this.edad = edad;
        this.fechaRegistro = fechaRegistro;
    }

    public MineroDTO(String tipoDocumento, String numeroDocu, String nombre, String apellido, String telefono, String direccion, String edad, String fechaRegistro) {
        this.tipoDocumento = tipoDocumento;
        this.numeroDocu = numeroDocu;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.direccion = direccion;
        this.edad = edad;
        this.fechaRegistro = fechaRegistro;
    }

    public String getIdMinero() {
        return idMinero;
    }

    public void setIdMinero(String idMinero) {
        this.idMinero = idMinero;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumeroDocu() {
        return numeroDocu;
    }

    public void setNumeroDocu(String numeroDocu) {
        this.numeroDocu = numeroDocu;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    
    
    
}
