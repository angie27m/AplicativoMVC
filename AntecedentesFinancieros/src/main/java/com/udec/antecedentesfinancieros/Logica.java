/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.antecedentesfinancieros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author angie
 */
public class Logica {

    private List<Persona> listaPersonas = new ArrayList<>();
    private Scanner seleccione = new Scanner(System.in);
    private List<Antecedente> listaAntecedentes = new ArrayList<>();
    private long cedula;
    private String enter;

    public Logica() {
        String continuar = "S";
        do {
            System.out.println("--Gestión antedentes financieros--");
            System.out.println("1- Registrar nueva persona");
            System.out.println("2- Editar datos persona");
            System.out.println("3- Agregar antecedente");
            System.out.println("4- Visualización antecedentes persona");
            System.out.println("5- Eliminar antecedente persona");
            System.out.println("Elija una opción: ");
            int opcion = seleccione.nextInt();
            switch (opcion) {
                case 1:
                    registroPersona();
                    break;
                case 2:
                    editarPersona();
                    break;
                case 3:
                    agregarAntecedente();
                    break;
                case 4:
                    visualizarAntecedentes();
                    break;
                case 5:
                    eliminarAntecedente();
                    break;
            }
            System.out.println("Desea continuar s/n");
            continuar = seleccione.nextLine();
        } while (continuar.equalsIgnoreCase("s"));
        imprimir();
    }

    private void registroPersona() {

        System.out.println("--REGISTRO PERSONA--");
        System.out.println("Digite su cédula: ");
        cedula = seleccione.nextLong();
        enter = seleccione.nextLine();
        System.out.println("Ingrese su nombre: ");
        String nombre = seleccione.nextLine();
        System.out.println("Digite su edad: ");
        int edad = seleccione.nextInt();
        enter = seleccione.nextLine();
        System.out.println("Ingrese su género: ");
        String genero = seleccione.nextLine();
        llenarAntecedente();
        Persona p1 = new Persona(cedula, nombre, edad, genero, listaAntecedentes);
        listaPersonas.add(p1);
        guardarPersonas(listaPersonas);
    }

    private void llenarAntecedente() {
        String antecedente = "S";
        Date fechita = new Date();
        while (antecedente.equalsIgnoreCase("s")) {
            System.out.println("Información de los antecedentes");
            System.out.println("Fecha del antecedente (YYYY/MM/DD)");
            String fecha = seleccione.nextLine();
            SimpleDateFormat formato = new SimpleDateFormat("yyyy/mm/dd");
            try {
                fechita = formato.parse(fecha);
            } catch (ParseException ex) {
                Logger.getLogger(Logica.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("Descripción");
            String descripcion = seleccione.nextLine();
            System.out.println("Tipo de antecedente");
            byte idTipo = seleccione.nextByte();
            enter = seleccione.nextLine();
            Antecedente antec = new Antecedente(fechita, descripcion, idTipo);
            listaAntecedentes.add(antec);
            System.out.println("Desea ingresar mas antecedentes s/n");
            antecedente = seleccione.nextLine();
        }
    }

    private void editarPersona() {
        System.out.println("--EDITAR PERSONA--");
        System.out.println("Digite el número de cédula de la persona: ");
        cedula = seleccione.nextLong();
        enter = seleccione.nextLine();
        for (Persona per : listaPersonas) {
            if (per.cedula == cedula) {
            }
        }
    }

    private void agregarAntecedente() {
        System.out.println("--AGREGAR ANTECEDENTE--");
        System.out.println("Digite el número de cédula de la persona: ");
        cedula = seleccione.nextLong();
        enter = seleccione.nextLine();
        for (Persona per : listaPersonas) {
            if (per.cedula == cedula) {
                listaAntecedentes = new ArrayList<>();
                listaAntecedentes.addAll(per.antecedentes);
                llenarAntecedente();
                per.antecedentes = new ArrayList<>();
                per.antecedentes.addAll(listaAntecedentes);
            }
        }
        guardarPersonas(listaPersonas);
    }

    private void visualizarAntecedentes() {
        System.out.println("--VISUALIZAR ANTECEDENTES--");
        System.out.println("Digite el número de cédula de la persona que desea visualizar: ");
        cedula = seleccione.nextLong();
        enter = seleccione.nextLine();
        for (Persona per : listaPersonas) {
            if (per.cedula == cedula) {
                for (Antecedente ant : per.antecedentes) {
                    System.out.println("----ANTECEDENTES----");
                    System.out.println("Fecha: " + (new SimpleDateFormat("dd-MM-yyyy").format(ant.getFecha())));
                    System.out.println("Descripcion: " + ant.getDescripcion());
                }
            }
        }
    }

    private void eliminarAntecedente() {
        System.out.println("--ELIMINAR ANTECEDENTE--");
    }

    private void imprimir() {
        System.out.println("--LISTADO PERSONAS--");
        muestraContenido();
        /*for (int i = 0; i < listaPersonas.size(); i++) {

         }*/
    }

    private void guardarPersonas(List<Persona> personas) {
        try {
            File archivo = new File("personas.dat");
            FileWriter escribir= new FileWriter(archivo,true);
            escribir.write(listaPersonas.toString());
            escribir.close();
            System.out.println("Personas guardadas correctamente...");

        } catch (FileNotFoundException fnfe) {
            System.out.println("Error: El fichero no existe. ");
        } catch (IOException ioe) {
            System.out.println("Error: Fallo en la escritura en el fichero. ");
        }
    }

    public void muestraContenido() {
        try {
            File archivo = new File("personas.dat");
            FileReader lector = new FileReader(archivo);
            BufferedReader br = new BufferedReader(lector);
            String texto=br.readLine();
            System.out.println(texto);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Logica.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ioe) {
            System.out.println("Error: Fallo en la escritura en el fichero. ");
        }
    }

}
