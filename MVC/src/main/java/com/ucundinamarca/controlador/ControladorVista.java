package com.ucundinamarca.controlador;

import com.ucundinamarca.modelo.Logica;
import com.ucundinamarca.mvc.Vista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 * Esta clase se encarga del control de los eventos de los componentes que se encuentran en la
 * vista
 *
 * @author Alisson Celeita, Angie Manrique
 */
public class ControladorVista implements ActionListener {

    //Esta variable crea un objeto tipo Vista
    Vista vista;
    //Variable que guarda los nombres que han sido ingresados
    String nombres;

    /**
     * Constructor de la clase, llama a los eventos de la vista
     *
     * @param vista variable que contiene el objeto tipo Vista
     */
    public ControladorVista(Vista vista) {
        this.vista = vista;
        vista.getGuardar().addActionListener(this);
        vista.getGuardar().setActionCommand("Guardar");
    }

    /**
     * Evento del botón encargado de guardar los nombres ingresados por el
     * usuario
     *
     * @param ae variable usada para llamar el evento del botón
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("Guardar")) {
            Logica logica = new Logica(vista.getNombre().getText());
            if (vista.getNombre().getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Ingrese un nombre para guardar");
            } else {
                nombres = logica.llenar(vista.getArea().getText());
                vista.getArea().setText(nombres);
                vista.getNombre().setText("");
            }
        }
    }
}
