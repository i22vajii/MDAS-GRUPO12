package patron_façade;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AlojamientoApartamento {
    private List<String> catalogo;

    public AlojamientoApartamento() {
        this.catalogo = new ArrayList<>();
        this.catalogo.add("Apartamento Centro Histórico - Cordoba");
        this.catalogo.add("Loft Sol - Madrid");
    }

    public List<String> buscarApartamentos(String ciudad, Date f1, Date f2, int numPersonas) {
        System.out.println("[Apartamentos] Buscando apartamentos completos en " + ciudad + " para grupo de " + numPersonas + "...");
        List<String> resultados = new ArrayList<>();
        for (String apto : catalogo) {
            if (apto.contains(ciudad)) {
                resultados.add(apto + " (Capacidad suficiente)");
            }
        }
        return resultados;
    }
}