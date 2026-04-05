package patron_façade;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TransporteVuelo {
    private List<String> catalogo;

    public TransporteVuelo() {
        this.catalogo = new ArrayList<>();
        this.catalogo.add("Iberia: Barcelona -> Madrid");
        this.catalogo.add("Vueling: Bilbao -> Cordoba"); // Vuelo simulado
    }

    public List<String> buscarVuelos(String origen, String destino, Date f1, Date f2, int numPersonas) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("[Vuelos] Buscando trayectos aéreos de " + origen + " a " + destino + " (" + sdf.format(f1) + " - " + sdf.format(f2) + ")...");
        
        List<String> resultados = new ArrayList<>();
        for (String ruta : catalogo) {
            if (ruta.contains(origen) && ruta.contains(destino)) {
                resultados.add("Vuelo directo: " + ruta + " (Tarifa grupo: " + numPersonas + " pax)");
            }
        }
        return resultados;
    }
}