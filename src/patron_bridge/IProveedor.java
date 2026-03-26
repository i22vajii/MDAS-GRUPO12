package patron_bridge;

import java.util.List;

public interface IProveedor {
    List<Producto> getProductos();
    List<Producto> buscar(String criterio);
}