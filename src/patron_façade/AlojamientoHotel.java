package patron_façade;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AlojamientoHotel {
    private List<String> catalogo;

    public AlojamientoHotel() {
        this.catalogo = new ArrayList<>();
        this.catalogo.add("Hotel Center 4* - Cordoba");
        this.catalogo.add("Hotel Gran Via 5* - Madrid");
    }

    public List<String> buscarHoteles(String ciudad, Date f1, Date f2, int numPersonas) {
        System.out.println("[Hoteles] Buscando habitaciones en " + ciudad + " para " + numPersonas + " personas...");
        List<String> resultados = new ArrayList<>();
        for (String hotel : catalogo) {
            if (hotel.contains(ciudad)) {
                resultados.add(hotel + " (Disponibilidad confirmada)");
            }
        }
        return resultados;
    }
}
