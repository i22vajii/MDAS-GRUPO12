package patron_bridge;

import java.util.ArrayList;
import java.util.List;

public class EmpresaA implements IProveedor {
    private List<Producto> productos = new ArrayList<>();

    // La Empresa A vende ÚNICAMENTE sofás
    public void addProducto(Producto p) {
        if (p instanceof Sofa) {
            productos.add(p);
        } else {
            System.err.println("Error: La Empresa A solo admite Sofás en su catálogo.");
        }
    }

    @Override
    public List<Producto> getProductos() {
        return productos;
    }

    @Override
    public List<Producto> buscar(String criterio) {
        List<Producto> resultado = new ArrayList<>();
        for (Producto p : productos) {
            if (p.getNombre().toLowerCase().contains(criterio.toLowerCase()) || 
                p.getMaterial().toLowerCase().contains(criterio.toLowerCase()) ||
                p.getColor().toLowerCase().contains(criterio.toLowerCase())) {
                resultado.add(p);
            }
        }
        return resultado;
    }
}