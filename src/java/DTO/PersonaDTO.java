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
public class PersonaDTO {
     private String idPersona;
    private String tipoDocumento;
    private String cedulaPersona;
    private String nombrePersona;
    private String apellidoPersona;
    private String telefonoPersona;
    private String correoPersona;
    private String direccionPersona;
    private String sexoPersona;
    private String edad;
    private String usuario, password, rol;

    public PersonaDTO(String idPersona, String tipoDocumento, String cedulaPersona, String nombrePersona, String apellidoPersona, String telefonoPersona, String correoPersona, String direccionPersona, String sexoPersona, String edad, String usuario, String password, String rol) {
        this.idPersona = idPersona;
        this.tipoDocumento = tipoDocumento;
        this.cedulaPersona = cedulaPersona;
        this.nombrePersona = nombrePersona;
        this.apellidoPersona = apellidoPersona;
        this.telefonoPersona = telefonoPersona;
        this.correoPersona = correoPersona;
        this.direccionPersona = direccionPersona;
        this.sexoPersona = sexoPersona;
        this.edad = edad;
        this.usuario = usuario;
        this.password = password;
        this.rol = rol;
    }
    public PersonaDTO(String idPersona) {
        this.idPersona = idPersona;
    }

    public PersonaDTO(String usuario, String password) {
        this.usuario = usuario;
        this.password = password;
    }

    

   

    public PersonaDTO(String tipoDocumento, String cedulaPersona, String nombrePersona, String apellidoPersona, String telefonoPersona, String correoPersona, String direccionPersona, String sexoPersona, String edad) {
        this.tipoDocumento = tipoDocumento;
        this.cedulaPersona = cedulaPersona;
        this.nombrePersona = nombrePersona;
        this.apellidoPersona = apellidoPersona;
        this.telefonoPersona = telefonoPersona;
        this.correoPersona = correoPersona;
        this.direccionPersona = direccionPersona;
        this.sexoPersona = sexoPersona;
        this.edad = edad;
    }

    public PersonaDTO(String idPersona, String tipoDocumento, String cedulaPersona, String nombrePersona, String apellidoPersona, String telefonoPersona, String correoPersona, String direccionPersona, String sexoPersona, String edad, String usuario, String password) {
        this.idPersona = idPersona;
        this.tipoDocumento = tipoDocumento;
        this.cedulaPersona = cedulaPersona;
        this.nombrePersona = nombrePersona;
        this.apellidoPersona = apellidoPersona;
        this.telefonoPersona = telefonoPersona;
        this.correoPersona = correoPersona;
        this.direccionPersona = direccionPersona;
        this.sexoPersona = sexoPersona;
        this.edad = edad;
        this.usuario = usuario;
        this.password = password;
    }


    public String getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(String idPersona) {
        this.idPersona = idPersona;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getCedulaPersona() {
        return cedulaPersona;
    }

    public void setCedulaPersona(String cedulaPersona) {
        this.cedulaPersona = cedulaPersona;
    }

    public String getNombrePersona() {
        return nombrePersona;
    }

    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

    public String getApellidoPersona() {
        return apellidoPersona;
    }

    public void setApellidoPersona(String apellidoPersona) {
        this.apellidoPersona = apellidoPersona;
    }

    public String getTelefonoPersona() {
        return telefonoPersona;
    }

    public void setTelefonoPersona(String telefonoPersona) {
        this.telefonoPersona = telefonoPersona;
    }

    public String getDireccionPersona() {
        return direccionPersona;
    }

    public void setDireccionPersona(String direccionPersona) {
        this.direccionPersona = direccionPersona;
    }

    public String getSexoPersona() {
        return sexoPersona;
    }

    public void setSexoPersona(String sexoPersona) {
        this.sexoPersona = sexoPersona;
    }

    public String getCorreoPersona() {
        return correoPersona;
    }

    public void setCorreoPersona(String correoPersona) {
        this.correoPersona = correoPersona;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
    
    
}
