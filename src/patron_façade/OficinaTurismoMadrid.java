package patron_façade;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OficinaTurismoMadrid {

    public List<String> buscarPorSoloFecha(Date fecha) {
        System.out.println("[Turismo Madrid] Buscando cualquier actividad disponible para la fecha " + fecha + "...");
        
        List<String> actividades = new ArrayList<>();
        // Simulamos la búsqueda
        actividades.add("Entrada Museo del Prado");
        actividades.add("Musical en Gran Vía");
        
        return actividades;
    }
}