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
public class ProduccionMineroDTO {

    private String idProduccion;
    private String nombreMinero;
    private String horarioTurno;
    private String totalProducido;
    private String fechaRgistro;

    public ProduccionMineroDTO(String idProduccion, String nombreMinero, String horarioTurno, String totalProducido, String fechaRgistro) {
        this.idProduccion = idProduccion;
        this.nombreMinero = nombreMinero;
        this.horarioTurno = horarioTurno;
        this.totalProducido = totalProducido;
        this.fechaRgistro = fechaRgistro;
    }

    public ProduccionMineroDTO(String nombreMinero, String horarioTurno, String totalProducido, String fechaRgistro) {
        this.nombreMinero = nombreMinero;
        this.horarioTurno = horarioTurno;
        this.totalProducido = totalProducido;
        this.fechaRgistro = fechaRgistro;
    }

    public String getIdProduccion() {
        return idProduccion;
    }

    public void setIdProduccion(String idProduccion) {
        this.idProduccion = idProduccion;
    }

    public String getNombreMinero() {
        return nombreMinero;
    }

    public void setNombreMinero(String nombreMinero) {
        this.nombreMinero = nombreMinero;
    }

    public String getHorarioTurno() {
        return horarioTurno;
    }

    public void setHorarioTurno(String horarioTurno) {
        this.horarioTurno = horarioTurno;
    }

    public String getTotalProducido() {
        return totalProducido;
    }

    public void setTotalProducido(String totalProducido) {
        this.totalProducido = totalProducido;
    }

    public String getFechaRgistro() {
        return fechaRgistro;
    }

    public void setFechaRgistro(String fechaRgistro) {
        this.fechaRgistro = fechaRgistro;
    }

}
