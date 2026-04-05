package patron_façade;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AgenciaViajesFacade {

    private AgenciaViajesFacade() { }

    public static List<String> buscarViajeCompleto(Date fechaInicio, Date fechaFin, String origen, String destino, int numPersonas, String tipoActividad) {
        
        List<String> itinerarioCompleto = new ArrayList<>();
        itinerarioCompleto.add("=== OFERTA DE VIAJE (" + numPersonas + " pax): " + origen + " -> " + destino + " ===");

        // 1. Sistemas de Transporte
        TransporteTren trenes = new TransporteTren();
        itinerarioCompleto.addAll(trenes.buscarTrenes(origen, destino, fechaInicio, fechaFin, numPersonas));
        
        TransporteVuelo vuelos = new TransporteVuelo();
        itinerarioCompleto.addAll(vuelos.buscarVuelos(origen, destino, fechaInicio, fechaFin, numPersonas));

        // 2. Sistemas de Alojamiento
        AlojamientoHotel hoteles = new AlojamientoHotel();
        itinerarioCompleto.addAll(hoteles.buscarHoteles(destino, fechaInicio, fechaFin, numPersonas));
        
        AlojamientoApartamento apartamentos = new AlojamientoApartamento();
        itinerarioCompleto.addAll(apartamentos.buscarApartamentos(destino, fechaInicio, fechaFin, numPersonas));

        // 3. Oficinas de Turismo
        itinerarioCompleto.add("--- Actividades recomendadas ---");
        
        if (destino.equalsIgnoreCase("Cordoba") || destino.equalsIgnoreCase("Córdoba")) {
            OficinaTurismoCordoba turismoCordoba = new OficinaTurismoCordoba();
            itinerarioCompleto.addAll(turismoCordoba.buscarPorTipoEvento(tipoActividad, fechaInicio));
            
        } else if (destino.equalsIgnoreCase("Madrid")) {
            OficinaTurismoMadrid turismoMadrid = new OficinaTurismoMadrid();
            itinerarioCompleto.addAll(turismoMadrid.buscarPorSoloFecha(fechaInicio));
            
        } else {
            itinerarioCompleto.add("Sin acuerdos con la oficina de turismo de " + destino);
        }

        return itinerarioCompleto;
    }
}