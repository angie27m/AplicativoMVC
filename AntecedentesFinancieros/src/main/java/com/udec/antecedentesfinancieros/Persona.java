/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.antecedentesfinancieros;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Esta clase contiene los parámetros que tiene una persona
 *
 * @author Angie Manrique, Alisson Celeita
 */
public class Persona implements Serializable {

    public long cedula;
    public String nombre;
    public int edad;
    public String género;
    public List<Antecedente> antecedentes = new ArrayList();

    public Persona(long cedula, String nombre, int edad, String género, List<Antecedente> antecedentes) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.edad = edad;
        this.género = género;
        this.antecedentes = antecedentes;
    }

    public long getCedula() {
        return cedula;
    }

    public void setCedula(long cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getGénero() {
        return género;
    }

    public void setGénero(String género) {
        this.género = género;
    }

    public List<Antecedente> getAntecedentes() {
        return antecedentes;
    }

    public void setAntecedentes(List<Antecedente> antecedentes) {
        this.antecedentes = antecedentes;
    }

}
