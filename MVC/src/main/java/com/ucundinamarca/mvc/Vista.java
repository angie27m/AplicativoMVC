/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucundinamarca.mvc;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * Esta clase se encarga de la creación de los componentes gráficos
 * @author Alisson Celeita, Angie Manrique
 */
public class Vista extends JFrame {

    //Área de texto que guarda los nombres
    private JTextArea Area;
    //Botón encargado de guardar la información ingresada
    private JButton Guardar;
    //Deslizador dentro del área de texto
    private JScrollPane Panel;
    //Cuadro de texto que recibe los nombres
    private JTextField nombre;

    /**
     * Método para obtener el área de texto
     *
     * @return área de texto
     */
    public JTextArea getArea() {
        return Area;
    }

    /**
     * Método para ingresarle información al área de texto
     *
     * @param Area
     */
    public void setArea(JTextArea Area) {
        this.Area = Area;
    }

    /**
     * Método para obtener el botón guardar
     *
     * @return botón
     */
    public JButton getGuardar() {
        return Guardar;
    }

    /**
     * Método para acceder y darle valor al botón
     *
     * @param Guardar
     */
    public void setGuardar(JButton Guardar) {
        this.Guardar = Guardar;
    }

    /**
     * Método para obtener el deslizador
     *
     * @return
     */
    public JScrollPane getPanel() {
        return Panel;
    }

    /**
     * Método para acceder y darle valor al deslizador
     *
     * @param Panel
     */
    public void setPanel(JScrollPane Panel) {
        this.Panel = Panel;
    }

    /**
     * Método para obtener el cuadro de texto
     *
     * @return
     */
    public JTextField getNombre() {
        return nombre;
    }

    /**
     * Método para acceder y darle valor al cuadro de texto
     *
     * @param nombre
     */
    public void setNombre(JTextField nombre) {
        this.nombre = nombre;
    }

    /**
     * Contructor de la clase Vista
     */
    public Vista() {
        initComponent();
        this.setVisible(true);
    }

    /**
     * Método encargado de inicializar los componentes gráficos de la vista
     */
    public void initComponent() {
        this.setSize(550, 450);
        nombre = new JTextField();
        Guardar = new JButton();
        Panel = new JScrollPane();
        Area = new JTextArea();

        Area.enable(false);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        nombre.setText("");

        Guardar.setText("Guardar");

        Area.setColumns(20);
        Area.setRows(5);
        Panel.setViewportView(Area);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(Panel, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                        .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(Guardar)))
                        .addContainerGap(55, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Guardar))
                        .addGap(18, 18, 18)
                        .addComponent(Panel, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(28, Short.MAX_VALUE))
        );
    }
}
