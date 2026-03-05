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
        limpiarFicheroDestino(destino);
        // Extraemos todo el contenido de f1 y f2 indicando un número de línea fin muy alto
        String contenidoF1 = maquetadorBasico.extraerParrafo(f1, 1, Integer.MAX_VALUE);
        String contenidoF2 = maquetadorBasico.extraerParrafo(f2, 1, Integer.MAX_VALUE);
        
        // Añadimos el texto concatenado al archivo de destino
        maquetadorBasico.anadirTexto(destino, contenidoF1);
        maquetadorBasico.anadirTexto(destino, contenidoF2);
    }

    @Override
    public void combinarIntercalado(File f1, File f2, List<int[]> parrafosF1, List<int[]> parrafosF2, File destino) throws IOException {
        limpiarFicheroDestino(destino);
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
        
        for (int i = 0; i < lineasInicio.size(); i++) {
            File destinoActual = destinos.get(i);
            
            // Reutilizamos el método que creamos antes para que no se acumule texto si ejecutamos varias veces
            limpiarFicheroDestino(destinoActual); 
            
            int inicio = lineasInicio.get(i);
            int fin;
            
            // Si no es el último archivo, el fin es justo la línea anterior al siguiente corte
            if (i < lineasInicio.size() - 1) {
                fin = lineasInicio.get(i + 1) - 1; 
            } else {
                // Si es el último archivo, leemos hasta el infinito (el final del archivo)
                fin = Integer.MAX_VALUE; 
            }
            
            // Extraemos exactamente el "párrafo" (bloque de líneas) que nos interesa
            String contenido = maquetadorBasico.extraerParrafo(origen, inicio, fin);
            
            // Y lo inyectamos en su archivo correspondiente
            maquetadorBasico.anadirTexto(destinoActual, contenido);
        }
    }
    private void limpiarFicheroDestino(File archivo) {
        if (archivo.exists()) {
            archivo.delete();
        }
    }
}