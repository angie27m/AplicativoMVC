package com.ucundinamarca.mvc;

import com.ucundinamarca.controlador.ControladorVista;

/**
 * Esta clase ejecuta el programa.
 *
 * @author Angie Manrique, Alisson Celeita
 *
 */
public class Main {

    public static void main(String args[]) {
        Vista vista = new Vista();
        ControladorVista controlador = new ControladorVista(vista);
    }
}
