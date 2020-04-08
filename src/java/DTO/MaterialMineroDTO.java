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
public class MaterialMineroDTO {
    
    private String idMaterial;
    private String tipoMaterial;
    private String nombreMaterial;
    private String descripcion;

    public MaterialMineroDTO(String idMaterial, String tipoMaterial, String nombreMaterial, String descripcion) {
        this.idMaterial = idMaterial;
        this.tipoMaterial = tipoMaterial;
        this.nombreMaterial = nombreMaterial;
        this.descripcion = descripcion;
    }

    public MaterialMineroDTO(String tipoMaterial, String nombreMaterial, String descripcion) {
        this.tipoMaterial = tipoMaterial;
        this.nombreMaterial = nombreMaterial;
        this.descripcion = descripcion;
    }

    public String getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(String idMaterial) {
        this.idMaterial = idMaterial;
    }

    public String getTipoMaterial() {
        return tipoMaterial;
    }

    public void setTipoMaterial(String tipoMaterial) {
        this.tipoMaterial = tipoMaterial;
    }

    public String getNombreMaterial() {
        return nombreMaterial;
    }

    public void setNombreMaterial(String nombreMaterial) {
        this.nombreMaterial = nombreMaterial;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}
