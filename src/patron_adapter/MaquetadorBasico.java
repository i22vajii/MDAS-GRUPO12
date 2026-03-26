package patron_adapter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MaquetadorBasico {
    
    // 1) Añadir texto, recibido como String, al final de un archivo
    public void anadirTexto(File archivo, String texto) throws IOException {
        // El parámetro 'true' en FileWriter indica que se añade al final
        try (FileWriter fw = new FileWriter(archivo, true)) {
            fw.write(texto + "\n");
        }
    }

    // 2) Extraer un párrafo de un archivo de texto, indicando la línea de inicio y fin
    public String extraerParrafo(File archivo, int lineaInicio, int lineaFin) throws IOException {
        StringBuilder parrafo = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            int lineaActual = 1;
            while ((linea = br.readLine()) != null) {
                if (lineaActual >= lineaInicio && lineaActual <= lineaFin) {
                    parrafo.append(linea).append("\n");
                }
                lineaActual++;
            }
        }
        return parrafo.toString();
    }

    // 3) Dividir un fichero de texto en dos, dando un número de línea para realizar el corte
    public void dividirFichero(File archivoOrigen, int lineaCorte, File archivoDestino1, File archivoDestino2) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(archivoOrigen))) {
            String linea;
            int lineaActual = 1;
            while ((linea = br.readLine()) != null) {
                if (lineaActual < lineaCorte) {
                    anadirTexto(archivoDestino1, linea);
                } else {
                    anadirTexto(archivoDestino2, linea);
                }
                lineaActual++;
            }
        }
    }
}