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
public class FallaMecanicaDTO {

    private String idFalla;
    private String chasisVehiculo;
    private String nombreConductor;
    private String fechaRgistro;
    private String descripcionFalla;

    public FallaMecanicaDTO(String idFalla, String chasisVehiculo, String nombreConductor, String fechaRgistro, String descripcionFalla) {
        this.idFalla = idFalla;
        this.chasisVehiculo = chasisVehiculo;
        this.nombreConductor = nombreConductor;
        this.fechaRgistro = fechaRgistro;
        this.descripcionFalla = descripcionFalla;
    }

    public FallaMecanicaDTO(String chasisVehiculo, String nombreConductor, String fechaRgistro, String descripcionFalla) {
        this.chasisVehiculo = chasisVehiculo;
        this.nombreConductor = nombreConductor;
        this.fechaRgistro = fechaRgistro;
        this.descripcionFalla = descripcionFalla;
    }
    

    public String getIdFalla() {
        return idFalla;
    }

    public void setIdFalla(String idFalla) {
        this.idFalla = idFalla;
    }

    public String getChasisVehiculo() {
        return chasisVehiculo;
    }

    public void setChasisVehiculo(String chasisVehiculo) {
        this.chasisVehiculo = chasisVehiculo;
    }

    public String getNombreConductor() {
        return nombreConductor;
    }

    public void setNombreConductor(String nombreConductor) {
        this.nombreConductor = nombreConductor;
    }

    public String getFechaRgistro() {
        return fechaRgistro;
    }

    public void setFechaRgistro(String fechaRgistro) {
        this.fechaRgistro = fechaRgistro;
    }

    public String getDescripcionFalla() {
        return descripcionFalla;
    }

    public void setDescripcionFalla(String descripcionFalla) {
        this.descripcionFalla = descripcionFalla;
    }

    
}
