package patron_composite;

import java.util.ArrayList;
import java.util.List;

public class Espacio extends ContadorLogico {
    
    private String nombre; // Añadimos un nombre para saber qué espacio es
    private List<ContadorLogico> elementos;

    // Modificamos el constructor para pedir el nombre
    public Espacio(String nombre) {
        this.nombre = nombre;
        this.elementos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void agregarElemento(ContadorLogico c) {
        this.elementos.add(c);
    }

    public void eliminarElemento(ContadorLogico c) {
        this.elementos.remove(c);
    }

    @Override
    public double estimarConsumoGlobal() {
        double consumoTotal = 0;
        for (ContadorLogico elemento : elementos) {
            consumoTotal += elemento.estimarConsumoGlobal();
        }
        return consumoTotal;
    }

    @Override
    public double calcularCosteTotal() {
        double costeTotal = 0;
        for (ContadorLogico elemento : elementos) {
            costeTotal += elemento.calcularCosteTotal();
        }
        return costeTotal;
    }
}