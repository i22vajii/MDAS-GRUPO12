package patron_bridge;

public abstract class Producto {
    private String nombre;
    private double precio;
    private int unidades;
    private String color;
    private String material;

    public Producto(String nombre, double precio, int unidades, String color, String material) {
        this.nombre = nombre;
        this.precio = precio;
        this.unidades = unidades;
        this.color = color;
        this.material = material;
    }

    // Método abstracto para poder duplicar el producto al sumar stocks
    public abstract Producto clonar();

    // Getters y Setters
    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }
    public int getUnidades() { return unidades; }
    public void setUnidades(int unidades) { this.unidades = unidades; }
    public String getColor() { return color; }
    public String getMaterial() { return material; }

    @Override
    public String toString() {
        return nombre + " | Precio: " + precio + "€ | Stock: " + unidades + " | Material: " + material;
    }
}