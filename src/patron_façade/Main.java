package patron_façade;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("==================================================");
        System.out.println("   BIENVENIDO A LA AGENCIA DE VIAJES GRUPALES");
        System.out.println("==================================================");

        
        Date fechaIda = new Date(); 
        Date fechaVuelta = new Date(); 

        System.out.print("Introduce la ciudad de ORIGEN: ");
        String origen = scanner.nextLine();

        System.out.print("Introduce la ciudad de DESTINO (ej. Cordoba, Madrid): ");
        String destino = scanner.nextLine();

        System.out.print("Introduce el número de personas para el grupo: ");
        int numPersonas = scanner.nextInt();
        scanner.nextLine(); 

        String tipoActividad = "";
        
        if (destino.equalsIgnoreCase("Cordoba") || destino.equalsIgnoreCase("Córdoba")) {
            System.out.print("Introduce el tipo de actividad cultural que buscáis (ej. Cultural, Gastronómica, Histórica): ");
            tipoActividad = scanner.nextLine();
        }

        System.out.println("\nProcesando su solicitud...\n");

        // Llamamos al Façade pasándole todo lo que el usuario ha escrito
        List<String> opcionesViaje = AgenciaViajesFacade.buscarViajeCompleto(
            fechaIda, fechaVuelta, origen, destino, numPersonas, tipoActividad
        );

        // Mostramos el resultado final
        System.out.println("\n==================================================");
        System.out.println("            RESULTADOS DE SU BÚSQUEDA             ");
        System.out.println("==================================================");
        for (String opcion : opcionesViaje) {
            System.out.println(opcion);
        }

        scanner.close();
    }
}