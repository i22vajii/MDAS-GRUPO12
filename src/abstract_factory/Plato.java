package abstract_factory;

public class Plato {
    private String nombre;
    private float precio;
    private TipoPlato tipo;
    private TipoAcompanamiento acompanamiento;

    // Constructor
    public Plato(String nombre, float precio, TipoPlato tipo, TipoAcompanamiento acompanamiento) {
        this.nombre = nombre;
        this.precio = precio;
        this.tipo = tipo;
        this.acompanamiento = acompanamiento;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public TipoPlato getTipo() {
        return tipo;
    }

    public TipoAcompanamiento getAcompanamiento() {
        return acompanamiento;
    }

    public void asignarPrecio(float precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        String texto = nombre + " (" + precio + "€)";
        if (acompanamiento != TipoAcompanamiento.NINGUNO) {
            texto += " con " + acompanamiento.toString().toLowerCase();
        }
        return texto;
    }
}