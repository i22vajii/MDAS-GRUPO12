package patron_bridge;

import java.util.ArrayList;
import java.util.List;

public abstract class EmpresaBase implements IProveedor {
    // La lista de productos que almacena la empresa
    protected List<Producto> productos = new ArrayList<>();

    // Método extra para poder meterle productos a la empresa desde el Main
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
            // Busca si coincide con el nombre, material o color
            if (p.getNombre().toLowerCase().contains(criterio.toLowerCase()) || 
                p.getMaterial().toLowerCase().contains(criterio.toLowerCase()) ||
                p.getColor().toLowerCase().contains(criterio.toLowerCase())) {
                resultado.add(p);
            }
        }
        return resultado;
    }
}