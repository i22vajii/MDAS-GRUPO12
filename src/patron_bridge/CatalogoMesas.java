package patron_bridge;

import java.util.ArrayList;
import java.util.List;

public class CatalogoMesas extends CatalogoAbstraccion {
    
    public List<Producto> buscarPorDimensiones(float largo, float ancho) {
        List<Producto> resultado = new ArrayList<>();
        for (IProveedor proveedor : implementaciones) {
            for (Producto p : proveedor.getProductos()) {
                // Comprobamos que sea una mesa y coincidan dimensiones
                if (p instanceof Mesa) {
                    Mesa m = (Mesa) p;
                    if (m.getLargo() == largo && m.getAncho() == ancho) {
                        resultado.add(m);
                    }
                }
            }
        }
        return resultado;
    }
}