package patron_façade;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SistemaTransporte {
    private List<String> listaRutas;

    public SistemaTransporte() {
        this.listaRutas = new ArrayList<>();
      
        this.listaRutas.add("Tren: Madrid - Cordoba");
        this.listaRutas.add("Vuelo: Barcelona - Cordoba");
        this.listaRutas.add("Autobus: Sevilla - Madrid");
    }

    public List<String> buscarBilletes(String origen, String destino, Date f1, Date f2, int numPersonas) {
        System.out.println("[Transporte] Buscando opciones de " + origen + " a " + destino + " para " + numPersonas + " personas...");
        
        List<String> resultados = new ArrayList<>();
       
        resultados.add("Billete disponible: " + origen + " -> " + destino + " (Apto para grupo de " + numPersonas + ")");
        
        return resultados;
    }
}