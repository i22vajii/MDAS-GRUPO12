package abstract_factory;

import java.util.ArrayList;
import java.util.List;

public abstract class Menu {
    // Usamos protected para que las clases hijas puedan acceder a la lista si lo necesitan
    protected List<Plato> platos;

    public Menu() {
        this.platos = new ArrayList<>();
    }

    public void asignarPlato(Plato plato) {
        this.platos.add(plato);
    }

    public List<Plato> obtenerPlatos() {
        return this.platos;
    }

    // Método abstracto: obligamos a que cada tipo de menú implemente cómo calcular su precio
    public abstract float calcularPrecio();
    
    // Un método extra para que luego podamos imprimir el menú por consola fácilmente
    public void mostrarMenu() {
        System.out.println("Platos del menú:");
        for (Plato plato : platos) {
            System.out.println(" - " + plato.toString());
        }
        System.out.println("Precio Total: " + calcularPrecio() + "€\n");
    }
}