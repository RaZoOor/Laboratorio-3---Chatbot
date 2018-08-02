/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatbot;

import java.util.ArrayList;

/**
 *
 * @author franciscog
 */
public class EstudianteParadigma {
    //Atributos
    String rut;
    String nombre;
    ArrayList<Float> notasCatedra;
    ArrayList<Float> notasLaboratorio;
    ArrayList<String> estadoAprobacion;
    
    //Constructor
    public EstudianteParadigma(String rut, String nombre)
    {
        this.rut                =  rut;
        this.nombre             =  nombre;
        this.notasCatedra       =  new ArrayList<>();
        this.notasLaboratorio   =  new ArrayList<>();
        this.estadoAprobacion   =  new ArrayList<>();
    }
    
    //Metodos
    public void agregarNotaCatedra(float nota)
    {
        notasCatedra.add(nota);
    }
    
    public void agregarNotaLaboratorio(float nota)
    {
        notasLaboratorio.add(nota);
    }
    
    public void mostrarNotasCatedra(ArrayList<Float> notas)
    {
        notas.forEach((nota) -> {
            System.out.println(nota);
        });
    }
    
    public void mostrarNotasLaboratorio(ArrayList<Float> notas)
    {
        notas.forEach((nota) -> {
            System.out.println(nota);
        });
    }
    
}
