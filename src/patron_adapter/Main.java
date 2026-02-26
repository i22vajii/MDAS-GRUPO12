package patron_adapter;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        System.out.println("Iniciando prueba del Maquetador Avanzado (Patrón Adapter)...\n");

        // 1. Instanciamos el adaptador pero lo guardamos en una variable de la interfaz
        IMaquetadorAvanzado maquetador = new AdaptadorMaquetacion();
        
        // 2. Definimos los archivos de origen (que tendremos que crear físicamente en el proyecto)
        File f1 = new File("fichero1.txt");
        File f2 = new File("fichero2.txt");
        
        // 3. Definimos los archivos de destino donde se guardarán los resultados
        File destinoUnido = new File("resultado_unido.txt");
        File destinoIntercalado = new File("resultado_intercalado.txt");

        try {
            // --- PRUEBA 1: UNIR FICHEROS ---
            System.out.println("-> Ejecutando: Unir Ficheros...");
            maquetador.unirFicheros(f1, f2, destinoUnido);
            System.out.println("   OK! Revisa el archivo 'resultado_unido.txt'");
            
            // --- PRUEBA 2: COMBINAR INTERCALADO ---
            System.out.println("\n-> Ejecutando: Combinar Intercalado...");
            // Queremos el párrafo de las líneas 1 a 2 de f1, y de 4 a 5 de f1
            List<int[]> parrafosF1 = Arrays.asList(new int[]{1, 2}, new int[]{4, 5});
            // Queremos el párrafo de las líneas 1 a 3 de f2
            List<int[]> parrafosF2 = Arrays.asList(new int[]{1, 3});
            
            maquetador.combinarIntercalado(f1, f2, parrafosF1, parrafosF2, destinoIntercalado);
            System.out.println("   OK! Revisa el archivo 'resultado_intercalado.txt'");

            // --- PRUEBA 3: SEPARAR EN MÚLTIPLES FICHEROS ---
           // --- PRUEBA 3: SEPARAR EN MÚLTIPLES FICHEROS ---
            System.out.println("\n-> Ejecutando: Separar Fichero Múltiple...");
            System.out.println("Vamos a dividir el archivo 'resultado_unido.txt' en 3 partes.");
            
            List<File> partes = Arrays.asList(
                new File("parte1.txt"), 
                new File("parte2.txt"), 
                new File("parte3.txt")
            );
            
            // Aquí guardaremos la línea de inicio de CADA archivo
            List<Integer> lineasInicio = new java.util.ArrayList<>();
            
            for (int i = 0; i < partes.size(); i++) {
                if (i == 0) {
                    System.out.print("Indica la línea de INICIO para el fichero '" + partes.get(i).getName() + "' (suele ser la 1): ");
                } else {
                    System.out.print("Indica la línea de INICIO para el fichero '" + partes.get(i).getName() + "': ");
                }
                lineasInicio.add(scanner.nextInt());
            }
            
            maquetador.separarFicheroMultiple(destinoUnido, lineasInicio, partes);
            System.out.println("   OK! Revisa los archivos 'parte1.txt', 'parte2.txt' y 'parte3.txt'");
            
            System.out.println("\n¡Todas las operaciones finalizaron con éxito!"
                
            );
            
            
            maquetador.separarFicheroMultiple(destinoUnido, cortes, partes);
            System.out.println("   OK! Revisa los archivos 'parte1.txt', 'parte2.txt' y 'parte3.txt'");
            
            System.out.println("\n¡Todas las operaciones finalizaron con éxito!");

        } catch (IOException e) {
            System.err.println("ERROR de lectura/escritura: Asegúrate de haber creado 'fichero1.txt' y 'fichero2.txt' en la raíz del proyecto.");
            e.printStackTrace();
        }
    }
}