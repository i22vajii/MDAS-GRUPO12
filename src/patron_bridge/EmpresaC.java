package patron_bridge;

import java.util.ArrayList;
import java.util.List;

public class EmpresaC implements IProveedor {
    private List<Producto> productos = new ArrayList<>();

    // La Empresa C vende tanto mesas como sofás, acepta cualquier Producto
    public void addProducto(Producto p) {
        productos.add(p);
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