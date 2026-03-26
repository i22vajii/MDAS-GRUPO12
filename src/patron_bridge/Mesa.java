package patron_bridge;

public class Mesa extends Producto {
    private float largo;
    private float ancho;

    public Mesa(String nombre, double precio, int unidades, String color, String material, float largo, float ancho) {
        super(nombre, precio, unidades, color, material);
        this.largo = largo;
        this.ancho = ancho;
    }

    public float getLargo() { return largo; }
    public float getAncho() { return ancho; }

    @Override
    public Producto clonar() {
        return new Mesa(getNombre(), getPrecio(), getUnidades(), getColor(), getMaterial(), this.largo, this.ancho);
    }
}