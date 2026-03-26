package patron_façade;

import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        
        System.out.println("=== BIENVENIDO A LA AGENCIA DE VIAJES GRUPALES ===");

        // Creamos unas fechas simuladas para la prueba (usamos la fecha actual)
        Date fechaIda = new Date(); 
        Date fechaVuelta = new Date(); 

        // --- CASO DE USO 1: Viaje a Córdoba ---
        System.out.println("\n>>> CLIENTE: Quiero un viaje de Madrid a Córdoba para 4 personas, con actividades culturales.");
        
        // Llamamos al Façade con todos los datos en una sola línea
        List<String> viajeCordoba = AgenciaViajesFacade.buscarViajeCompleto(
            fechaIda, fechaVuelta, "Madrid", "Cordoba", 4, "Cultural"
        );

        // Mostramos el resultado
        System.out.println("--- RESULTADOS DEL VIAJE A CÓRDOBA ---");
        for (String opcion : viajeCordoba) {
            System.out.println(" -> " + opcion);
        }

        System.out.println("\n--------------------------------------------------\n");

        // --- CASO DE USO 2: Viaje a Madrid ---
        System.out.println(">>> CLIENTE: Quiero un viaje de Sevilla a Madrid para 2 personas (sin especificar tipo de actividad).");
        
        // Llamamos al Façade de nuevo. Como Madrid no usa el "tipoActividad", le pasamos una cadena vacía o null.
        List<String> viajeMadrid = AgenciaViajesFacade.buscarViajeCompleto(
            fechaIda, fechaVuelta, "Sevilla", "Madrid", 2, ""
        );

        // Mostramos el resultado
        System.out.println("--- RESULTADOS DEL VIAJE A MADRID ---");
        for (String opcion : viajeMadrid) {
            System.out.println(" -> " + opcion);
        }
    }
}