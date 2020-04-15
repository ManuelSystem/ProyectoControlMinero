/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.io.InputStream;

/**
 *
 * @author Manuel
 */
public class VehiculoDTO {
    private String idVehiculo;
    private String marcaVehi;
    private String modeloVehi;
    private String colorVehi;
    private String chasisVehi;
    private String seguroVehi;
    private String tecnomecaVehi;
    private String fechaRegistroV;
    private String imgVehi;

    public VehiculoDTO(String marcaVehi, String modeloVehi, String colorVehi, String chasisVehi, String seguroVehi, String tecnomecaVehi, String fechaRegistroV, String imgVehi) {
        this.marcaVehi = marcaVehi;
        this.modeloVehi = modeloVehi;
        this.colorVehi = colorVehi;
        this.chasisVehi = chasisVehi;
        this.seguroVehi = seguroVehi;
        this.tecnomecaVehi = tecnomecaVehi;
        this.fechaRegistroV = fechaRegistroV;
        this.imgVehi = imgVehi;
    }

   


    public VehiculoDTO() {
      }

    public String getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(String idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public String getMarcaVehi() {
        return marcaVehi;
    }

    public void setMarcaVehi(String marcaVehi) {
        this.marcaVehi = marcaVehi;
    }

    public String getModeloVehi() {
        return modeloVehi;
    }

    public void setModeloVehi(String modeloVehi) {
        this.modeloVehi = modeloVehi;
    }

    public String getColorVehi() {
        return colorVehi;
    }

    public void setColorVehi(String colorVehi) {
        this.colorVehi = colorVehi;
    }

    public String getChasisVehi() {
        return chasisVehi;
    }

    public void setChasisVehi(String chasisVehi) {
        this.chasisVehi = chasisVehi;
    }

    public String getSeguroVehi() {
        return seguroVehi;
    }

    public void setSeguroVehi(String seguroVehi) {
        this.seguroVehi = seguroVehi;
    }

    public String getTecnomecaVehi() {
        return tecnomecaVehi;
    }

    public void setTecnomecaVehi(String tecnomecaVehi) {
        this.tecnomecaVehi = tecnomecaVehi;
    }

    public String getFechaRegistroV() {
        return fechaRegistroV;
    }

    public void setFechaRegistroV(String fechaRegistroV) {
        this.fechaRegistroV = fechaRegistroV;
    }

    public String getImgVehi() {
        return imgVehi;
    }

    public void setImgVehi(String imgVehi) {
        this.imgVehi = imgVehi;
    }
    

   
    
}
