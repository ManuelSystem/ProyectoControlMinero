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
public class CargamentoDTO {
    private String idCargamento;
    private String Chasisvehiculo;
    private String conductor;
    private String materialMinero;
    private String patio;
    private String vehiculoVacio;
    private String vehiculoCargado;
    private String pesoNeto;
    private String fechaCargamento;

    public CargamentoDTO(String idCargamento, String Chasisvehiculo, String conductor, String materialMinero, String patio, String vehiculoVacio, String vehiculoCargado, String pesoNeto, String fechaCargamento) {
        this.idCargamento = idCargamento;
        this.Chasisvehiculo = Chasisvehiculo;
        this.conductor = conductor;
        this.materialMinero = materialMinero;
        this.patio = patio;
        this.vehiculoVacio = vehiculoVacio;
        this.vehiculoCargado = vehiculoCargado;
        this.pesoNeto = pesoNeto;
        this.fechaCargamento = fechaCargamento;
    }

    public CargamentoDTO(String Chasisvehiculo, String conductor, String materialMinero, String patio, String vehiculoVacio, String vehiculoCargado, String pesoNeto, String fechaCargamento) {
        this.Chasisvehiculo = Chasisvehiculo;
        this.conductor = conductor;
        this.materialMinero = materialMinero;
        this.patio = patio;
        this.vehiculoVacio = vehiculoVacio;
        this.vehiculoCargado = vehiculoCargado;
        this.pesoNeto = pesoNeto;
        this.fechaCargamento = fechaCargamento;
    }

    public String getIdCargamento() {
        return idCargamento;
    }

    public void setIdCargamento(String idCargamento) {
        this.idCargamento = idCargamento;
    }

    public String getChasisvehiculo() {
        return Chasisvehiculo;
    }

    public void setChasisvehiculo(String Chasisvehiculo) {
        this.Chasisvehiculo = Chasisvehiculo;
    }

    public String getConductor() {
        return conductor;
    }

    public void setConductor(String conductor) {
        this.conductor = conductor;
    }

    public String getMaterialMinero() {
        return materialMinero;
    }

    public void setMaterialMinero(String materialMinero) {
        this.materialMinero = materialMinero;
    }

    public String getPatio() {
        return patio;
    }

    public void setPatio(String patio) {
        this.patio = patio;
    }

    public String getVehiculoVacio() {
        return vehiculoVacio;
    }

    public void setVehiculoVacio(String vehiculoVacio) {
        this.vehiculoVacio = vehiculoVacio;
    }

    public String getVehiculoCargado() {
        return vehiculoCargado;
    }

    public void setVehiculoCargado(String vehiculoCargado) {
        this.vehiculoCargado = vehiculoCargado;
    }

    public String getPesoNeto() {
        return pesoNeto;
    }

    public void setPesoNeto(String pesoNeto) {
        this.pesoNeto = pesoNeto;
    }

    public String getFechaCargamento() {
        return fechaCargamento;
    }

    public void setFechaCargamento(String fechaCargamento) {
        this.fechaCargamento = fechaCargamento;
    }

   
    
    
}
