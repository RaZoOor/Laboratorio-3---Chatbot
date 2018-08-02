/*
 * Laboratorio 3 Paradigmas de Programacion
 * Profesor Catedra: Daniel Gacitua
 * Alumno: Francisco Guajardo Villa / 19.005.801-8
 */
package chatbot;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 * Clase Main, clase principal que contiene la funcion main, la cual se encarga del
 * manejo de las interacciones entre el usuario y la entidad chatbot.
 * @author Francisco Guajardo Villa
 * @version 18.06.2018
 */
public class Main
{   
    /**
     * Funcion main encargada de manejar las interacciones 
     * @param args sin parametros adicionales 
     */
    public static void main(String[] args) 
    {
        String entradaTeclado;
        String timeStamp;
        String[] entrada;
        Scanner entradaScanner;
        ArrayList<Log> log;
        Log dialogo;
        
        System.out.println("Sistema > Hola y bienvenido, este chatbot te ayudara a registrar"
                + " una compra dentro de la tienda Xamer, especializada"
                + "\nen venta de videojuegos, peliculas y mangas /Para ayuda ejecute el comando !help");
        
        log = new ArrayList<>();
        boolean auxBoolean;
        auxBoolean = true;
        
        while(auxBoolean)
        {
            entradaScanner = new Scanner (System.in); //Creación de un objeto Scanner
            System.out.print("User > "); //Para diferenciar la entrada del user a la del chatbot
            entradaTeclado = entradaScanner.nextLine (); //Invocamos un método sobre un objeto Scanner
            entrada = entradaTeclado.split(" ");
            timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date());

            dialogo = new Log(timeStamp, "usuario", entradaTeclado);
            log.add(dialogo);

            if (entrada[0].toLowerCase().equals("!begindialog")) 
            {
                String saludoChatbot;
                Chatbot chatbot;
                timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date());
                int seed = Integer.parseInt(entrada[1]);
                chatbot = new Chatbot(seed);
                saludoChatbot = chatbot.getSaludo();
                System.out.print("Chatbot > " + saludoChatbot);
                
                dialogo = new Log(timeStamp, "chatbot", saludoChatbot);
                log.add(dialogo);
            }

            else if (entrada[0].toLowerCase().equals("!savelog")) 
            {
                String nombreArchivo;
                timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss").format(new Date());
                nombreArchivo = timeStamp + ".log";
                Utiles.crearArchivo(log, nombreArchivo);
            }
            
            else if (entrada[0].toLowerCase().equals("!loadlog")) 
            {
                //cargar un archivo
                ArrayList<Log> nuevoLog;
                nuevoLog = Utiles.leerArchivo(entrada[1]);
                log = nuevoLog;
            }
            
            else if (entrada[0].toLowerCase().equals("!help")) 
            {
                timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date());
                String aux;
                System.out.print("Sistema > ");
                aux = "La lista de comandos existentes en este programa de ayuda son los siguientes:\n"
                        + "*!beginDialog seed: Permite iniciar el chatbot con un valor semilla (seed) para su personalidad.\n"
                        + "*!endDialog: Termina la conversacion con el chatbot.\n"
                        + "*!saveLog: Guarda en un archivo de texto la conversacion realizada hasta el momento.\n"
                        + "*!loadLog nombreArchivo: Lee el archivo ingresado y carga la conversacion almacenada.\n"
                        + "*!rate notaChatbot: Evalua el chatbot con una nota entre 1 a 5.\n"
                        + "Estos son todos los comandos existentes, porfavor prosiga la conversacion.";
                System.out.println(aux);
                dialogo = new Log(timeStamp, "sistema", aux);
                log.add(dialogo);
            }
            
            else if (entrada[0].toLowerCase().equals("!enddialog")) 
            {
                auxBoolean = false;
                //despedida
            }
            
            else 
            {
                //esperar hasta que el usuario ingrese el comando deseado
            }
        }
    }
}
