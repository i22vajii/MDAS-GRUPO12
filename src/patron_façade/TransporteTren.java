package patron_façade;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TransporteTren {
    private List<String> catalogo;

    public TransporteTren() {
        this.catalogo = new ArrayList<>();
        this.catalogo.add("AVE: Madrid -> Cordoba");
        this.catalogo.add("Alvia: Sevilla -> Madrid");
    }

    public List<String> buscarTrenes(String origen, String destino, Date f1, Date f2, int numPersonas) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("[Trenes] Buscando billetes de " + origen + " a " + destino + " (" + sdf.format(f1) + " - " + sdf.format(f2) + ")...");
        
        List<String> resultados = new ArrayList<>();
        for (String ruta : catalogo) {
            if (ruta.contains(origen) && ruta.contains(destino)) {
                resultados.add("Tren encontrado: " + ruta + " (Asientos juntos para " + numPersonas + " pax)");
            }
        }
        return resultados;
    }
}