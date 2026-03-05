package patron_composite;

import java.util.ArrayList;
import java.util.List;

public class Espacio extends ContadorLogico {
    
    // Lista que almacena los hijos (pueden ser Aparatos o más Espacios)
    private List<ContadorLogico> elementos;

    public Espacio() {
        this.elementos = new ArrayList<>();
    }

    // Método para añadir un elemento a este espacio
    public void agregarElemento(ContadorLogico c) {
        this.elementos.add(c);
    }

    // Método para eliminar un elemento de este espacio
    public void eliminarElemento(ContadorLogico c) {
        this.elementos.remove(c);
    }

    @Override
    public double estimarConsumoGlobal() {
        double consumoTotal = 0;
        // La magia del patrón Composite: le pedimos a cada hijo su consumo y lo sumamos.
        // Si el hijo es un Aparato, devolverá su fórmula. Si es otro Espacio, sumará a sus propios hijos.
        for (ContadorLogico elemento : elementos) {
            consumoTotal += elemento.estimarConsumoGlobal();
        }
        return consumoTotal;
    }

    @Override
    public double calcularCosteTotal() {
        double costeTotal = 0;
        // Igual que el anterior, sumamos el coste de todos los elementos contenidos en este espacio
        for (ContadorLogico elemento : elementos) {
            costeTotal += elemento.calcularCosteTotal();
        }
        return costeTotal;
    }
}