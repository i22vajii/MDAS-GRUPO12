package patron_façade;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OficinaTurismoCordoba {
    
    public List<String> buscarPorTipoEvento(String tipo, Date fechaInicio) {
        System.out.println("[Turismo Córdoba] Buscando eventos de tipo '" + tipo + "' para la fecha " + fechaInicio + "...");
        
        List<String> actividades = new ArrayList<>();
        // Simulamos la búsqueda
        if (tipo != null && !tipo.isEmpty()) {
            actividades.add("Visita guiada Mezquita-Catedral (Tipo: " + tipo + ")");
            actividades.add("Ruta de los Patios Cordobeses (Tipo: " + tipo + ")");
        } else {
            actividades.add("Paseo libre por la Judería");
        }
        
        return actividades;
    }
}