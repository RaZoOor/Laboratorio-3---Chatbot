/*
 * Laboratorio 3 Paradigmas de Programacion
 * Profesor Catedra: Daniel Gacitua
 * Alumno: Francisco Guajardo Villa / 19.005.801-8
 */

package chatbot;

import java.util.ArrayList;

/**
 * Clase Chatbot que contiene la IA chatbot
 * @author Francisco Guajardo Villa
 */
public class Chatbot 
{
    
    String saludo;
    String despedida;
    
    public Chatbot(int seed)
    {
        if (seed == 1)
        {
            saludo = "Hola\n";
            despedida = "";
        }
        
        else if (seed == 2)
        {
            saludo = "Hola Qlao\n";
            despedida = "";
        }
    }
    
    public String getSaludo()
    {
        return saludo;
    }
    
}
