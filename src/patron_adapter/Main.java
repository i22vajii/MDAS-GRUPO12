package patron_adapter;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Iniciando prueba del Maquetador Avanzado (Patrón Adapter)...\n");

        IMaquetadorAvanzado maquetador = new AdaptadorMaquetacion();
        
        // 1. Definimos la ruta de la carpeta donde estarán los archivos
        // Asegúrate de que esta ruta coincide con la carpeta que has creado en VS Code
        String rutaBase = "src/patron_adapter/archivos_texto/"; 
        
        // (Opcional pero elegante) Si la carpeta no existe, le decimos a Java que la cree
        File directorio = new File(rutaBase);
        if (!directorio.exists()) {
            directorio.mkdirs();
        }

        // 2. Añadimos la ruta base a la creación de los archivos
        File f1 = new File(rutaBase + "fichero1.txt");
        File f2 = new File(rutaBase + "fichero2.txt");
        File destinoUnido = new File(rutaBase + "resultado_unido.txt");
        File destinoIntercalado = new File(rutaBase + "resultado_intercalado.txt");

        try {
            System.out.println("-> Ejecutando: Unir Ficheros...");
            maquetador.unirFicheros(f1, f2, destinoUnido);
            System.out.println("   OK! Revisa el archivo 'resultado_unido.txt' en la carpeta 'archivos_texto'");
            
            System.out.println("\n-> Ejecutando: Combinar Intercalado...");
            List<int[]> parrafosF1 = Arrays.asList(new int[]{1, 2}, new int[]{4, 5});
            List<int[]> parrafosF2 = Arrays.asList(new int[]{1, 3});
            
            maquetador.combinarIntercalado(f1, f2, parrafosF1, parrafosF2, destinoIntercalado);
            System.out.println("   OK! Revisa el archivo 'resultado_intercalado.txt' en la carpeta 'archivos_texto'");

            System.out.println("\n-> Ejecutando: Separar Fichero Múltiple...");
            System.out.println("Vamos a dividir el 'fichero1.txt' en 3 partes.");
            
            // 3. También añadimos la ruta base a los archivos de destino de las partes
            List<File> partes = Arrays.asList(
                new File(rutaBase + "parte1.txt"), 
                new File(rutaBase + "parte2.txt"), 
                new File(rutaBase + "parte3.txt")
            );
            
            List<Integer> lineasInicio = new java.util.ArrayList<>();
            
            for (int i = 0; i < partes.size(); i++) {
                if (i == 0) {
                    System.out.print("Indica la línea de INICIO para el fichero '" + partes.get(i).getName() + "' (suele ser la 1): ");
                } else {
                    System.out.print("Indica la línea de INICIO para el fichero '" + partes.get(i).getName() + "': ");
                }
                lineasInicio.add(scanner.nextInt());
            }
            
            maquetador.separarFicheroMultiple(f1, lineasInicio, partes);
            System.out.println("   OK! Revisa los archivos 'parte1.txt', 'parte2.txt' y 'parte3.txt' en la carpeta 'archivos_texto'");
            
            System.out.println("\n¡Todas las operaciones finalizaron con éxito y todo está ordenado!");

        } catch (IOException e) {
            System.err.println("ERROR de lectura/escritura: Asegúrate de haber creado 'fichero1.txt' y 'fichero2.txt' dentro de la carpeta 'archivos_texto'.");
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}