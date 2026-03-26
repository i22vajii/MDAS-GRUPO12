package patron_bridge;

import java.util.ArrayList;
import java.util.List;

public class CatalogoSofas extends CatalogoAbstraccion {
    
    public List<Producto> buscarPorNumeroPlazas(int plazas) {
        List<Producto> resultado = new ArrayList<>();
        for (IProveedor proveedor : implementaciones) {
            for (Producto p : proveedor.getProductos()) {
                // Comprobamos que sea un sofá y que coincidan las plazas
                if (p instanceof Sofa && ((Sofa) p).getPlazas() == plazas) {
                    resultado.add(p);
                }
            }
        }
        return resultado;
    }
}