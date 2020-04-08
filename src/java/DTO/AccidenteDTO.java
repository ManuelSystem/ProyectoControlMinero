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
public class AccidenteDTO {
    private String idAccidente;
    private String chasisVehiculo;
    private String cedulaConductor;
    private String nombreConductor;
    private String fechaAccidente;
    private String descripcionAccidente;

    public AccidenteDTO(String idAccidente, String chasisVehiculo, String cedulaConductor, String nombreConductor, String fechaAccidente, String descripcionAccidente) {
        this.idAccidente = idAccidente;
        this.chasisVehiculo = chasisVehiculo;
        this.cedulaConductor = cedulaConductor;
        this.nombreConductor = nombreConductor;
        this.fechaAccidente = fechaAccidente;
        this.descripcionAccidente = descripcionAccidente;
    }

    public AccidenteDTO(String chasisVehiculo, String cedulaConductor, String nombreConductor, String fechaAccidente, String descripcionAccidente) {
        this.chasisVehiculo = chasisVehiculo;
        this.cedulaConductor = cedulaConductor;
        this.nombreConductor = nombreConductor;
        this.fechaAccidente = fechaAccidente;
        this.descripcionAccidente = descripcionAccidente;
    }
    
    public String getIdAccidente() {
        return idAccidente;
    }

    public void setIdAccidente(String idAccidente) {
        this.idAccidente = idAccidente;
    }

    public String getChasisVehiculo() {
        return chasisVehiculo;
    }

    public void setChasisVehiculo(String chasisVehiculo) {
        this.chasisVehiculo = chasisVehiculo;
    }

    public String getCedulaConductor() {
        return cedulaConductor;
    }

    public void setCedulaConductor(String cedulaConductor) {
        this.cedulaConductor = cedulaConductor;
    }

    public String getNombreConductor() {
        return nombreConductor;
    }

    public void setNombreConductor(String nombreConductor) {
        this.nombreConductor = nombreConductor;
    }

    public String getFechaAccidente() {
        return fechaAccidente;
    }

    public void setFechaAccidente(String fechaAccidente) {
        this.fechaAccidente = fechaAccidente;
    }

    public String getDescripcionAccidente() {
        return descripcionAccidente;
    }

    public void setDescripcionAccidente(String descripcionAccidente) {
        this.descripcionAccidente = descripcionAccidente;
    }
    
    
}
