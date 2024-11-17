package poop11;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Clase principal POOP11
 * Este programa realiza las siguientes tareas:
 * - Crea objetos de la clase Alumno y los almacena en una lista.
 * - Escribe los datos de los alumnos en archivos de texto y CSV.
 * - Lee y muestra los datos almacenados en dichos archivos.
 * - Usa la clase StringTokenizer para procesar datos específicos.
 * 
 * Es una implementación práctica del manejo de archivos y uso de listas.
 * 
 * @author bueno
 */
public class POOP11 {
    public static void main(String[] args) {
        // Creación de objetos Alumno
        System.out.println("#############");
        Alumno alumno1 = new Alumno("Sergio Leonardo", "Guerrero", "Aguilar", 321232137, 19, 3);
        Alumno alumno2 = new Alumno("Nestor", "Bueno", "Perez", 321229054, 18, 3);
        Alumno alumno3 = new Alumno("Eric", "Soto", "Bolaños", 432123456, 18, 3);
        Alumno alumno4 = new Alumno("Ricardo", "Lopez", "Aguilar", 321232137, 19, 3);
        Alumno alumno5 = new Alumno("Emanuel", "Perez", "Sanchez", 321232137, 19, 3);
        Alumno alumno6 = new Alumno("Paola", "Mendoza", "Gutierrez", 321232137, 18, 2);
        Alumno alumno7 = new Alumno("Jose Manuel", "Reyes", "Perez", 321232137, 20, 3);
        Alumno alumno8 = new Alumno("Irving Migel", "Dominguez", "Echeverria", 321232137, 19, 3);
        Alumno alumno9 = new Alumno("Yahir", "Mendoza", "Mendoza", 321232137, 19, 3);
        Alumno alumno10 = new Alumno("Yael", "Pastrana", "Sanchez", 321232137, 19, 3);

        // Almacenamiento de alumnos en una lista
        ArrayList<Alumno> lista = new ArrayList<>();
        lista.add(alumno1);
        lista.add(alumno2);
        lista.add(alumno3);
        lista.add(alumno4);
        lista.add(alumno5);
        lista.add(alumno6);
        lista.add(alumno7);
        lista.add(alumno8);
        lista.add(alumno9);
        lista.add(alumno10);

        // Escritura de la lista en un archivo de texto
        escribirListaEnArchivo(lista, "lista.txt");

        // Lectura y visualización del archivo lista.txt
        leerYMostrarArchivo("lista.txt");

        // Uso de StringTokenizer para mostrar datos específicos
        String alumnoParseado1 = "Sergio Leonardo, Guerrero, Aguilar, 321232137, 19, 3";
        System.out.println("Tokens del alumno 1:");
        procesarConStringTokenizer(alumnoParseado1);

        // Escritura de la lista en formato CSV
        escribirListaEnCSV(lista, "alumnos.csv");

        // Lectura y visualización del archivo alumnos.csv
        leerYMostrarArchivo("alumnos.csv");
    }

    /**
     * Escribe una lista de objetos Alumno en un archivo de texto.
     * 
     * @param lista   la lista de alumnos a escribir
     * @param nombreArchivo el nombre del archivo donde se escribirá la lista
     */
    private static void escribirListaEnArchivo(ArrayList<Alumno> lista, String nombreArchivo) {
        try (FileWriter fw = new FileWriter(nombreArchivo);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter salida = new PrintWriter(bw)) {

            for (Alumno alumno : lista) {
                salida.println(alumno); // Usa el método toString() de Alumno
            }
            System.out.println("Lista escrita en el archivo " + nombreArchivo);
        } catch (IOException ex) {
            System.out.println("Error al escribir en " + nombreArchivo + ": " + ex.getMessage());
        }
    }

    /**
     * Lee un archivo línea por línea y muestra su contenido en consola.
     * 
     * @param nombreArchivo el nombre del archivo a leer
     */
    private static void leerYMostrarArchivo(String nombreArchivo) {
        try (FileReader fr = new FileReader(nombreArchivo);
             BufferedReader br = new BufferedReader(fr)) {

            System.out.println("Contenido del archivo " + nombreArchivo + ":");
            String linea = br.readLine();
            while (linea != null) {
                System.out.println(linea);
                linea = br.readLine();
            }
        } catch (IOException ex) {
            System.out.println("Error al leer " + nombreArchivo + ": " + ex.getMessage());
        }
    }

    /**
     * Procesa una cadena de texto con datos de un alumno usando StringTokenizer.
     * Muestra cada token en una nueva línea.
     * 
     * @param cadena la cadena a procesar
     */
    private static void procesarConStringTokenizer(String cadena) {
        StringTokenizer tokenizador = new StringTokenizer(cadena, ",");
        while (tokenizador.hasMoreTokens()) {
            System.out.println(tokenizador.nextToken().trim());
        }
    }

    /**
     * Escribe una lista de objetos Alumno en un archivo en formato CSV.
     * 
     * @param lista   la lista de alumnos a escribir
     * @param nombreArchivo el nombre del archivo donde se escribirá la lista
     */
    private static void escribirListaEnCSV(ArrayList<Alumno> lista, String nombreArchivo) {
        try (FileWriter fw = new FileWriter(nombreArchivo);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter salida = new PrintWriter(bw)) {

            for (Alumno alumno : lista) {
                salida.println(alumno.toCSV()); // Usa el método toCSV() de Alumno
            }
            System.out.println("Lista escrita en formato CSV en el archivo " + nombreArchivo);
        } catch (IOException ex) {
            System.out.println("Error al escribir en " + nombreArchivo + ": " + ex.getMessage());
        }
    }
}

