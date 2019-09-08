/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.antecedentesfinancieros;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author angie
 */
public class Logica {

    public List<Persona> listaPersonas = new ArrayList<Persona>();

    public Logica() {

        int continuar = 0;
        do {
            System.out.println("--Gestión antedentes financieros--");
            System.out.println("1- Registrar nueva persona");
            System.out.println("2- Editar datos persona");
            System.out.println("3- Agregar antecedente");
            System.out.println("4- Visualización antecedentes persona");
            System.out.println("5- Eliminar antecedente persona");
            System.out.println("Elija una opción: ");
            Scanner seleccione = new Scanner(System.in);
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
            System.out.println("Desea continuar 1=si 0=no");
            Scanner decision = new Scanner(System.in);
            continuar = Integer.parseInt(decision.nextLine());
        } while (continuar == 1);
        imprimir();
    }

    private void registroPersona() {
        System.out.println("--REGISTRO PERSONA--");
        Scanner valores = new Scanner(System.in);
        System.out.println("Digite su cédula: ");
        long cedula = valores.nextLong();
        System.out.println("Ingrese su nombre: ");
        String nombre = valores.next();
        System.out.println("Digite su edad: ");
        int edad = valores.nextInt();
        System.out.println("Ingrese su género: ");
        String genero = valores.next();
        Persona p1 = new Persona(cedula, nombre, edad, genero);
        listaPersonas.add(p1);

    }

    private void editarPersona() {
        System.out.println("--EDITAR PERSONA--");
        System.out.println("");
    }

    private void agregarAntecedente() {
        System.out.println("--AGREGAR ANTECEDENTE--");
        System.out.println("Digite el número de cédula de la persona: ");
        Scanner scanner = new Scanner(System.in);
        long cedula = scanner.nextLong();
        for (int i = 0; i < listaPersonas.size(); i++) {
            
        }


    }

    private void visualizarAntecedentes() {
        System.out.println("--VISUALIZAR ANTECEDENTES--");
        System.out.println("Digite el número de cédula de la persona que desea visualizar: ");
        Scanner scanner = new Scanner(System.in);
        long cedula = scanner.nextLong();
    }

    private void eliminarAntecedente() {
        System.out.println("--ELIMINAR ANTECEDENTE--");
    }

    private void imprimir() {
        System.out.println("--LISTADO PERSONAS--");
        for (int i = 0; i < listaPersonas.size(); i++) {
            
        }
    }
}
