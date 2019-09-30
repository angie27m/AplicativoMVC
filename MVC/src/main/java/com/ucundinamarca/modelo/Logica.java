package com.ucundinamarca.modelo;

/**
 * Clase que contiene la lógica del programa
 *
 * @author Alisson Celeita, Angie Manrique
 */
public class Logica {

    //Variable que guarda todos los nombres ingresados por el usuario
    private String nombres = " ";
    //Variable que guarda el nombre que ingresa el usuario
    private String nombre;

    /**
     * Constructor de la clase, recibe el nombre enviado desde el controlador de
     * la vista
     *
     * @param nombre variable que guarda el nombre
     */
    public Logica(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método encargado de llenar el área de texto con los nombres que han sido
     * ingresados
     *
     * @param nom contiene el texto actual del área
     * @return devuelve todos los nombres ingresados
     */
    public String llenar(String nom) {
        nombres = nom + nombre + " ";
        return nombres;
    }
}
