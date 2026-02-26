package patron_adapter;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface IMaquetadorAvanzado {
    
    // 1) Unir dos ficheros de texto, concatenando el texto de uno detrás del contenido del otro.
    void unirFicheros(File fichero1, File fichero2, File destino) throws IOException;

    // 2) Combinar el contenido de ambos ficheros de texto intercalando sus párrafos.
    // Usamos List<int[]> donde cada int[] tiene 2 elementos: [lineaInicio, lineaFin] del párrafo.
    void combinarIntercalado(File fichero1, File fichero2, List<int[]> parrafos1, List<int[]> parrafos2, File destino) throws IOException;

    // 3) Separar un fichero en varios, indicando los puntos de corte.
    // Recibe una lista de líneas de corte y una lista de archivos destino.
    void separarFicheroMultiple(File origen, List<Integer> lineasCorte, List<File> destinos) throws IOException;
    
}