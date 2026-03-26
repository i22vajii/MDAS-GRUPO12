package patron_bridge;

public class Sofa extends Producto {
    private int plazas;

    public Sofa(String nombre, double precio, int unidades, String color, String material, int plazas) {
        super(nombre, precio, unidades, color, material);
        this.plazas = plazas;
    }

    public int getPlazas() { return plazas; }

    @Override
    public Producto clonar() {
        return new Sofa(getNombre(), getPrecio(), getUnidades(), getColor(), getMaterial(), this.plazas);
    }
}