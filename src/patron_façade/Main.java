package patron_façade;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        // Formateador para entender la fecha que escriba el usuario
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        
        System.out.println("==================================================");
        System.out.println("   BIENVENIDO A LA AGENCIA DE VIAJES GRUPALES");
        System.out.println("==================================================");

        try {
            // 1. Pedimos las fechas de inicio y fin (Requisito a)
            System.out.print("Introduce la fecha de INICIO (dd/mm/aaaa): ");
            Date fechaIda = formatoFecha.parse(scanner.nextLine());
            
            System.out.print("Introduce la fecha de FIN (dd/mm/aaaa): ");
            Date fechaVuelta = formatoFecha.parse(scanner.nextLine());

            // 2. Pedimos origen y destino (Requisito a)
            System.out.print("Introduce la ciudad de ORIGEN: ");
            String origen = scanner.nextLine();

            System.out.print("Introduce la ciudad de DESTINO: ");
            String destino = scanner.nextLine();

            // 3. Pedimos los datos del grupo y actividad
            System.out.print("Introduce el número de personas para el grupo: ");
            int numPersonas = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            String tipoActividad = "";
            if (destino.equalsIgnoreCase("Cordoba") || destino.equalsIgnoreCase("Córdoba")) {
                System.out.print("Introduce el tipo de actividad cultural (ej. Cultural, Gastronómica): ");
                tipoActividad = scanner.nextLine();
            }

            System.out.println("\nProcesando su solicitud...\n");

            // Llamamos al Façade
            List<String> opcionesViaje = AgenciaViajesFacade.buscarViajeCompleto(
                fechaIda, fechaVuelta, origen, destino, numPersonas, tipoActividad
            );

            // Mostramos el resultado
            System.out.println("\n==================================================");
            System.out.println("            RESULTADOS DE SU BÚSQUEDA             ");
            System.out.println("==================================================");
            for (String opcion : opcionesViaje) {
                System.out.println(opcion);
            }

        } catch (ParseException e) {
            System.out.println("Error: El formato de la fecha es incorrecto. Debe ser dd/mm/aaaa.");
        } finally {
            scanner.close();
        }
    }
}