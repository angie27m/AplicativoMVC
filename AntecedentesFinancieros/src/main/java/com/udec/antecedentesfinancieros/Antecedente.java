/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.antecedentesfinancieros;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author angie
 */
public class Antecedente {

    private Date fecha;
    private String descripcion;
    private List<TipoAntecedente> tipoAntecedente = new ArrayList();

    public Antecedente(Date fecha, String descripcion) {
        this.fecha = fecha;
        this.descripcion = descripcion;
    }

    public List<TipoAntecedente> getTipoAntecedente() {
        return tipoAntecedente;
    }

    public void setTipoAntecedente(List<TipoAntecedente> tipoAntecedente) {
        this.tipoAntecedente = tipoAntecedente;
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
