/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.antecedentesfinancieros;

/**
 *
 * @author angie
 */
public class TipoAntecedente {

    private String nombre;
    private String descripcion;
    private boolean valor;
    private int id;

    public TipoAntecedente(String nombre, String descripcion, boolean valor, int id) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.valor = valor;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean getValor() {
        return valor;
    }

    public void setValor(boolean valor) {
        this.valor = valor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
