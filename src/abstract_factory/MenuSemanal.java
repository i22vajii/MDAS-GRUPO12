package abstract_factory;

public class MenuSemanal extends Menu {

    @Override
    public float calcularPrecio() {
        float total = 0;
        for (Plato plato : platos) {
            total += plato.getPrecio();
        }
        return total;
    }

    @Override
    public String toString() {
        return "=== Menú Semanal ===";
    }
}