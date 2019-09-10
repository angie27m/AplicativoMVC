/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.antecedentesfinancieros;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Esta clase se encarga de realizar la gestión de los antecedentes financieros
 * de las personas
 *
 * @author Angie Manrique, Alisson Celeita
 */
public class Logica {

    /**
     * Lista que guarda la información de las personas
     */
    private List<Persona> listaPersonas = new ArrayList<>();
    private Scanner seleccione = new Scanner(System.in);
    /**
     * Lista que guarda los antecedentes financieros de cada persona
     */
    private List<Antecedente> listaAntecedentes = new ArrayList<>();
    /**
     * Variable que guarda la cedula de las personas
     */
    private long cedula;
    private String enter;
    /**
     * Lista que guarda los tipos de antecedentes que existen
     */
    List<TipoAntecedente> listatipos = new ArrayList<>();
    /**
     * Archivo que contiene la información de la persona
     */
    File perso = new File("Persona.txt");

    /**
     * Se encuentra el menú del programa con sus diferentes opciones
     */
    public Logica() {
        listaTipo();
        muestraContenido();
        String continuar = "S";
        do {
            System.out.println("--Gestión antedentes financieros--");
            System.out.println("1- Registrar nueva persona");//ya
            System.out.println("2- Editar datos persona");
            System.out.println("3- Agregar antecedente");//ya
            System.out.println("4- Visualización antecedentes persona");//ya
            System.out.println("5- Eliminar antecedente persona");//ya
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
                    System.out.println("--VISUALIZAR ANTECEDENTES--");
                    System.out.println("Digite el número de cédula de la persona que desea visualizar: ");
                    cedula = seleccione.nextLong();
                    enter = seleccione.nextLine();
                    visualizarAntecedentes(cedula);
                    break;
                case 5:
                    eliminarAntecedente();
                    break;
                default:
                    System.out.println("Error en la selección");
                    break;
            }
            System.out.println("Desea continuar s/n");
            continuar = seleccione.nextLine();
        } while (continuar.equalsIgnoreCase("s"));
        imprimir();
    }

    /**
     * Método que se encarga de registrar las personas
     */
    private void registroPersona() {
        listaAntecedentes = new ArrayList();
        System.out.println("--REGISTRO PERSONA--");
        System.out.println("Digite su cédula: ");
        cedula = seleccione.nextLong();
        enter = seleccione.nextLine();
        if (validarCedula(cedula) == true) {
            System.out.println("Ya hay una persona registrada con esta cédula");
        } else {
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
    }

    /**
     * Método que valida si la cédula ingresada ya se encuentra registrada
     *
     * @param cedula cédula ingresada por el usuario
     * @return cuando ya está regustrada retorna un true
     */
    public boolean validarCedula(long cedula) {
        try {
            FileInputStream document = new FileInputStream(perso);
            ObjectInputStream leer = new ObjectInputStream(document);
            listaPersonas = (ArrayList<Persona>) leer.readObject();
            for (Persona per : listaPersonas) {
                if (per.getCedula() == cedula) {
                    return true;
                }
            }
        } catch (Exception e) {
        }
        return false;

    }

    /**
     * Registra la información de los antecedentes
     */
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
            System.out.println("1. Pago impuestos");
            System.out.println("2. Pago intereses");
            System.out.println("3. Pago credito");
            System.out.println("4. Deuda credito");
            byte idTipo = seleccione.nextByte();
            enter = seleccione.nextLine();
            if (idTipo == 1 || idTipo == 2 || idTipo == 3 || idTipo == 4) {
                Antecedente antec = new Antecedente(fechita, descripcion, idTipo);
                listaAntecedentes.add(antec);
                System.out.println(listaAntecedentes.size());
                System.out.println("Desea ingresar más antecedentes s/n");
                antecedente = seleccione.nextLine();
            } else {
                System.out.println("Tipo de dato erroneo");
                break;
            }
        }
    }

    /**
     * Actualiza los datos de la persona
     */
    private void editarPersona() {
        System.out.println("--EDITAR PERSONA--");
        System.out.println("Digite el número de cédula de la persona que desea editar: ");
        cedula = seleccione.nextLong();
        enter = seleccione.nextLine();
        try {
            FileInputStream archivo = new FileInputStream(perso);
            ObjectInputStream leer = new ObjectInputStream(archivo);
            listaPersonas = (ArrayList<Persona>) leer.readObject();
            for (Persona per : listaPersonas) {
                if (per.cedula == cedula) {
                    System.out.println("Ingrese nuevo nombre: ");
                    per.setNombre(seleccione.nextLine());
                    System.out.println("Digite nueva edad: ");
                    per.setEdad(seleccione.nextInt());
                    enter = seleccione.nextLine();
                    System.out.println("Ingrese nuevo género: ");
                    per.setGénero(seleccione.nextLine());
                }
            }
            guardarPersonas(listaPersonas);
            System.out.println("Editado con exito");
        } catch (Exception e) {

        }

    }

    /**
     * Agrega nuevos antecedentes a una persona ya existente
     */
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
        //guardarAntecedentes(listaAntecedentes);
        guardarPersonas(listaPersonas);
    }

    /**
     * Imprime los antecedentes de una persona
     *
     * @param cedula variable que contiene el número de cédula de la persona
     */
    private void visualizarAntecedentes(long cedula) {
        int contador = 0;
        for (Persona per : listaPersonas) {
            if (per.cedula == cedula) {
                for (Antecedente ant : per.antecedentes) {
                    contador++;
                    System.out.println("----ANTECEDENTE # " + contador);
                    System.out.println("Fecha: " + (new SimpleDateFormat("dd-MM-yyyy").format(ant.getFecha())));
                    System.out.println("Descripcion: " + ant.getDescripcion());

                    for (TipoAntecedente tipo : listatipos) {
                        if (tipo.getId() == ant.getIdTipo()) {
                            System.out.println("--Tipo de antecedente-- " + "    Nombre: " + tipo.getNombre() + "       Descripción: " + tipo.getDescripcion());
                        }
                    }
                }
            }
        }
    }

    /**
     * Elimina los antecedentes que elija la persona
     */
    private void eliminarAntecedente() {
        System.out.println("--ELIMINAR ANTECEDENTE--");
        System.out.println("Digite el número de cédula de la persona a la que le desea eliminar un antecedente: ");
        cedula = seleccione.nextLong();
        enter = seleccione.nextLine();
        try {
            FileInputStream archivo = new FileInputStream(perso);
            ObjectInputStream leer = new ObjectInputStream(archivo);
            listaPersonas = (ArrayList<Persona>) leer.readObject();
            for (Persona per : listaPersonas) {
                if (per.cedula == cedula) {
                    visualizarAntecedentes(cedula);
                    System.out.println("Digite el numero del antecedente que desea eliminar");
                    int numero = seleccione.nextInt();
                    enter = seleccione.nextLine();
                    List<Antecedente> listaA = per.getAntecedentes();
                    listaA.remove(numero - 1);
                }
            }
            guardarPersonas(listaPersonas);
        } catch (Exception e) {

        }
    }

    /**
     * Método que imprime el listado personas registradas
     */
    private void imprimir() {
        System.out.println("--LISTADO PERSONAS--");
        muestraContenido();

    }

    /**
     * Agrega la lista de personas a un archivo
     *
     * @param personas listado de personas
     */
    private void guardarPersonas(List<Persona> personas) {
        try {
            ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(perso));
            salida.writeObject(personas);
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    /**
     * Hace la lectura del archivo y muestra la información de las personas
     */
    public void muestraContenido() {
        try {
            FileInputStream archivo = new FileInputStream(perso);
            ObjectInputStream leer = new ObjectInputStream(archivo);
            listaPersonas = (ArrayList<Persona>) leer.readObject();
            for (Persona per : listaPersonas) {
                System.out.println("Nombre: " + per.getNombre() + "     Cédula: "
                        + per.getCedula() + "      Edad:" + per.getEdad() + "     Género:" + per.getGénero());
                List<Antecedente> listaA = per.getAntecedentes();
                for (Antecedente ant : listaA) {
                    System.out.println("Fecha: " + (new SimpleDateFormat("yyyy-MM-dd").format(ant.getFecha())) + "      Descripción:" + ant.getDescripcion());
                    for (TipoAntecedente tipo : listatipos) {
                        if (tipo.getId() == ant.getIdTipo()) {
                            System.out.println("Tipo de antecedente: " + tipo.getNombre());
                        }
                    }
                }
            }
            leer.close();
        } catch (IOException | ClassNotFoundException e) {
            e.getStackTrace();
            System.out.println(e.getMessage());
        }
    }

    /**
     * Agrega los tipos de antecedentes
     */
    public void listaTipo() {
        listatipos.add(new TipoAntecedente("Pago impuestos", "Mora al pagar impuestos", false, 1));
        listatipos.add(new TipoAntecedente("Pago intereses", "Pago oportuno de los intereses", true, 2));
        listatipos.add(new TipoAntecedente("Pago credito", "Cuota positiva del credito", true, 3));
        listatipos.add(new TipoAntecedente("Deuda credito", "Retraso cuota credito bancario", false, 4));
    }
}
