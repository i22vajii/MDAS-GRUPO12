package patron_adapter;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class AdaptadorMaquetacion implements IMaquetadorAvanzado {
    
    // Aquí aplicamos la composición (la flecha 'delega' de nuestro diagrama)
    private MaquetadorBasico maquetadorBasico;

    public AdaptadorMaquetacion() {
        // Inicializamos el maquetador básico que usaremos por debajo
        this.maquetadorBasico = new MaquetadorBasico();
    }

    @Override
    public void unirFicheros(File f1, File f2, File destino) throws IOException {
        // Extraemos todo el contenido de f1 y f2 indicando un número de línea fin muy alto
        String contenidoF1 = maquetadorBasico.extraerParrafo(f1, 1, Integer.MAX_VALUE);
        String contenidoF2 = maquetadorBasico.extraerParrafo(f2, 1, Integer.MAX_VALUE);
        
        // Añadimos el texto concatenado al archivo de destino
        maquetadorBasico.anadirTexto(destino, contenidoF1);
        maquetadorBasico.anadirTexto(destino, contenidoF2);
    }

    @Override
    public void combinarIntercalado(File f1, File f2, List<int[]> parrafosF1, List<int[]> parrafosF2, File destino) throws IOException {
        // Buscamos cuál de las dos listas de párrafos es más larga para iterar hasta el final
        int maxLength = Math.max(parrafosF1.size(), parrafosF2.size());
        
        for (int i = 0; i < maxLength; i++) {
            // Si hay un párrafo disponible en f1, lo extraemos y añadimos al destino
            if (i < parrafosF1.size()) {
                int[] p1 = parrafosF1.get(i); // p1[0] es lineaInicio, p1[1] es lineaFin
                String textoF1 = maquetadorBasico.extraerParrafo(f1, p1[0], p1[1]);
                maquetadorBasico.anadirTexto(destino, textoF1);
            }
            // Si hay un párrafo disponible en f2, lo extraemos y añadimos al destino
            if (i < parrafosF2.size()) {
                int[] p2 = parrafosF2.get(i);
                String textoF2 = maquetadorBasico.extraerParrafo(f2, p2[0], p2[1]);
                maquetadorBasico.anadirTexto(destino, textoF2);
            }
        }
    }

    @Override
    public void separarFicheroMultiple(File origen, List<Integer> lineasInicio, List<File> destinos) throws IOException {
        File archivoTemp = origen;
        
        // Iteramos N-1 veces (para 3 archivos, hacemos 2 divisiones)
        // Empezamos en 1 porque la primera línea de inicio es para el primer archivo y no genera corte
        for (int i = 1; i < lineasInicio.size(); i++) {
            File parteActual = destinos.get(i - 1);
            File resto = new File("temp_resto_" + i + ".txt");
            
            // Calculamos el punto de corte para el maquetador básico de forma relativa
            int corteRelativo;
            if (i == 1) {
                corteRelativo = lineasInicio.get(i); 
            } else {
                corteRelativo = lineasInicio.get(i) - lineasInicio.get(i-1) + 1;
            }
            
            // Usamos la función básica de dividir en dos
            maquetadorBasico.dividirFichero(archivoTemp, corteRelativo, parteActual, resto);
            
            // Borramos el temporal anterior
            if (i > 1) {
                archivoTemp.delete();
            }
            archivoTemp = resto; 
        }
        
        // El último remanente va al último archivo de la lista
        String contenidoRestante = maquetadorBasico.extraerParrafo(archivoTemp, 1, Integer.MAX_VALUE);
        maquetadorBasico.anadirTexto(destinos.get(destinos.size() - 1), contenidoRestante);
        
        // Limpiamos el último archivo temporal sin borrar el original
        if (lineasInicio.size() > 1) {
            archivoTemp.delete();
        }
    }
}