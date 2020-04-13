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
public class PatioDTO {
    private String idPatio;
    private String departamento;
    private String municipio;
    private String nombrePatio;
    private String distanica;
    private String descripcion;

    public PatioDTO(String idPatio, String departamento, String municipio, String nombrePatio, String distanica, String descripcion) {
        this.idPatio = idPatio;
        this.departamento = departamento;
        this.municipio = municipio;
        this.nombrePatio = nombrePatio;
        this.distanica = distanica;
        this.descripcion = descripcion;
    }

    public PatioDTO(String departamento, String municipio, String nombrePatio, String distanica, String descripcion) {
        this.departamento = departamento;
        this.municipio = municipio;
        this.nombrePatio = nombrePatio;
        this.distanica = distanica;
        this.descripcion = descripcion;
    }

    public String getIdPatio() {
        return idPatio;
    }

    public void setIdPatio(String idPatio) {
        this.idPatio = idPatio;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getNombrePatio() {
        return nombrePatio;
    }

    public void setNombrePatio(String nombrePatio) {
        this.nombrePatio = nombrePatio;
    }

    public String getDistanica() {
        return distanica;
    }

    public void setDistanica(String distanica) {
        this.distanica = distanica;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}
