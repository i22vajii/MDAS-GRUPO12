package patron_façade;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SistemaAlojamiento {
    private List<String> catalogoHoteles;

    public SistemaAlojamiento() {
        this.catalogoHoteles = new ArrayList<>();
        
        this.catalogoHoteles.add("Hotel Centro 4* - Cordoba");
        this.catalogoHoteles.add("Hostal Plaza - Madrid");
    }

    public List<String> buscarHoteles(String ciudad, Date f1, Date f2, int numPersonas) {
        System.out.println("[Alojamiento] Buscando hoteles en " + ciudad + " para " + numPersonas + " personas...");
        
        List<String> resultados = new ArrayList<>();
       
        resultados.add("Hotel encontrado en " + ciudad + " con capacidad para " + numPersonas + " personas");
        
        return resultados;
    }
}