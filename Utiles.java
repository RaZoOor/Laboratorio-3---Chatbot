/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatbot;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author franciscog
 */
public class Utiles 
{

    public static void crearArchivo(ArrayList<Log> log, String nombreArchivo)
    {
        FileWriter fichero = null;
        PrintWriter pw;

        try {
            fichero = new FileWriter(nombreArchivo);
            pw = new PrintWriter(fichero);
            
            for(int i = 0; i < log.size(); i++)
            {
                Log dialogo = log.get(i);
                
                String fecha = dialogo.getDate();
                String user = dialogo.getTransmitter();
                String msg = dialogo.getMessage();
                
                pw.println(fecha + " | " + user + "> " + msg);
            }

        } catch (Exception e) {
            System.out.println("Error al crear archivo de salida");
            
        } finally {
            try {
            // para asegurarnos que se cierra el fichero.
                if (null != fichero)
                    fichero.close();
            } catch (Exception e2) {
                System.out.println("Error al cerrar fichero");
            }
        }  
    }
    
    public static ArrayList<Log> leerArchivo(String file)
    {
        ArrayList<Log> nuevoLog;
        nuevoLog = new ArrayList<>();
        
        return nuevoLog;
    }
        
}
    
