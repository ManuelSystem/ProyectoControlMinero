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
public class AuxiliarDTO {
    private String idAuxiliar;
    private String descripcion;
    private String fechaRegistro;

    public AuxiliarDTO(String idAuxiliar, String descripcion, String fechaRegistro) {
        this.idAuxiliar = idAuxiliar;
        this.descripcion = descripcion;
        this.fechaRegistro = fechaRegistro;
    }

    public AuxiliarDTO(String idAuxiliar) {
        this.idAuxiliar = idAuxiliar;
    }
    

    public String getIdAuxiliar() {
        return idAuxiliar;
    }

    public void setIdAuxiliar(String idAuxiliar) {
        this.idAuxiliar = idAuxiliar;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    
}
