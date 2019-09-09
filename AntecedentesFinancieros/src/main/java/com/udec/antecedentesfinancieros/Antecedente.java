/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.antecedentesfinancieros;

import java.io.Serializable;
import java.util.Date;
/**
 *
 * @author angie
 */
public class Antecedente implements Serializable {

    private Date fecha;
    private String descripcion;
    private byte idTipo;

    public byte getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(byte idTipo) {
        this.idTipo = idTipo;
    }
    
    public Antecedente(Date fecha, String descripcion, byte idTipo) {
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.idTipo= idTipo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
