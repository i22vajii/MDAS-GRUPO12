package patron_adapter;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface IMaquetadorAvanzado {
    
    // 1) Unir dos ficheros de texto, concatenando el texto de uno detrás del contenido del otro.
    void unirFicheros(File fichero1, File fichero2, File destino) throws IOException;

    // 2) Combinar el contenido de ambos ficheros de texto intercalando sus párrafos.
    void combinarIntercalado(File fichero1, File fichero2, List<int[]> parrafos1, List<int[]> parrafos2, File destino) throws IOException;

    // 3) Separar un fichero en varios, indicando los puntos de corte.
    void separarFicheroMultiple(File origen, List<Integer> lineasCorte, List<File> destinos) throws IOException;
    
}