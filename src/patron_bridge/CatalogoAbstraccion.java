package patron_bridge;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class CatalogoAbstraccion {
    
    protected List<IProveedor> implementaciones = new ArrayList<>();

    public void addProveedor(IProveedor p) {
        implementaciones.add(p);
    }

    public List<Producto> buscarGeneral(String criterio) {
        List<Producto> resultado = new ArrayList<>();
        for (IProveedor proveedor : implementaciones) {
            resultado.addAll(proveedor.buscar(criterio));
        }
        return resultado;
    }

    // a) Lista ordenada por precio (de menor a mayor)
    public List<Producto> obtenerStockOrdenadoPrecio() {
        List<Producto> resultado = new ArrayList<>();
        for (IProveedor proveedor : implementaciones) {
            for (Producto p : proveedor.getProductos()) {
                if (p.getUnidades() > 0) { // Omitir los que no tienen stock
                    resultado.add(p);
                }
            }
        }
        // Ordenar de menor a mayor precio
        resultado.sort(Comparator.comparingDouble(Producto::getPrecio));
        return resultado;
    }

    // b) Lista ordenada por unidades agregando repetidos de varias empresas
    public List<Producto> obtenerStockOrdenadoUnidades() {
        Map<String, Producto> consolidados = new HashMap<>();

        for (IProveedor proveedor : implementaciones) {
            for (Producto p : proveedor.getProductos()) {
                if (p.getUnidades() > 0) { // Omitir los que no tienen stock
                    if (consolidados.containsKey(p.getNombre())) {
                        // Si ya lo tenemos de otra empresa, sumamos las unidades al clon
                        Producto existente = consolidados.get(p.getNombre());
                        existente.setUnidades(existente.getUnidades() + p.getUnidades());
                    } else {
                        // Si es nuevo, guardamos un clon para no alterar el stock original de la empresa
                        consolidados.put(p.getNombre(), p.clonar());
                    }
                }
            }
        }

        List<Producto> resultado = new ArrayList<>(consolidados.values());
        // Ordenar por unidades de mayor a menor (descendente)
        resultado.sort((p1, p2) -> Integer.compare(p2.getUnidades(), p1.getUnidades()));
        return resultado;
    }
}