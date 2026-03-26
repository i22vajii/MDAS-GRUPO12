package patron_façade;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AgenciaViajesFacade {

    // Al ser una clase Utility, ponemos el constructor privado para evitar que se instancie.
    private AgenciaViajesFacade() {
    }

    // Método estático que el Cliente llamará directamente
    public static List<String> buscarViajeCompleto(Date fechaInicio, Date fechaFin, String origen, String destino, int numPersonas, String tipoActividad) {
        
        List<String> itinerarioCompleto = new ArrayList<>();
        itinerarioCompleto.add("=== OFERTA DE VIAJE PARA GRUPO (" + numPersonas + " pax): " + origen + " -> " + destino + " ===");

        // 1. Buscamos el Transporte
        SistemaTransporte transporte = new SistemaTransporte();
        itinerarioCompleto.addAll(transporte.buscarBilletes(origen, destino, fechaInicio, fechaFin, numPersonas));

        // 2. Buscamos el Alojamiento (solo le pasamos la ciudad de destino)
        SistemaAlojamiento alojamiento = new SistemaAlojamiento();
        itinerarioCompleto.addAll(alojamiento.buscarHoteles(destino, fechaInicio, fechaFin, numPersonas));

        // 3. Buscamos las Actividades (dependiendo del destino llamamos a una oficina u otra)
        itinerarioCompleto.add("--- Actividades recomendadas ---");
        
        if (destino.equalsIgnoreCase("Cordoba") || destino.equalsIgnoreCase("Córdoba")) {
            OficinaTurismoCordoba turismoCordoba = new OficinaTurismoCordoba();
            // Córdoba necesita saber el tipo de evento
            itinerarioCompleto.addAll(turismoCordoba.buscarPorTipoEvento(tipoActividad, fechaInicio));
            
        } else if (destino.equalsIgnoreCase("Madrid")) {
            OficinaTurismoMadrid turismoMadrid = new OficinaTurismoMadrid();
            // Madrid solo busca por fecha
            itinerarioCompleto.addAll(turismoMadrid.buscarPorSoloFecha(fechaInicio));
            
        } else {
            itinerarioCompleto.add("Lo sentimos, aún no tenemos acuerdos con la oficina de turismo de " + destino);
        }

        return itinerarioCompleto;
    }
}