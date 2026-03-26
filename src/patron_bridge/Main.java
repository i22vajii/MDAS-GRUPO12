package patron_bridge;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        
        // 1. Crear las empresas (Proveedores)
        EmpresaA empresaA = new EmpresaA(); // Especialista en sofás 
        EmpresaB empresaB = new EmpresaB(); // Especialista en mesas 
        EmpresaC empresaC = new EmpresaC(); // Vende de todo (mesas y sofás) 

        // 2. Crear los productos
        // Vamos a crear un sofá que venden tanto la Empresa A como la Empresa C para probar que el stock se suma
        Sofa sofaRelaxA = new Sofa("Sofá modelo Relax", 500.0, 10, "Gris", "Tela", 3);
        Sofa sofaRelaxC = new Sofa("Sofá modelo Relax", 550.0, 5, "Gris", "Tela", 3); // Mismo nombre, distinto precio/stock
        
        Sofa sofaChester = new Sofa("Sofá Chester", 800.0, 2, "Marrón", "Cuero", 2);
        
        Mesa mesaRoble = new Mesa("Mesa de Roble", 150.0, 20, "Marrón", "Madera", 1.5f, 0.8f);
        Mesa mesaCristal = new Mesa("Mesa de Cristal", 200.0, 8, "Transparente", "Cristal", 1.2f, 0.6f);

        // 3. Asignar los productos a las empresas
        empresaA.addProducto(sofaRelaxA);
        empresaA.addProducto(sofaChester);
        
        empresaB.addProducto(mesaRoble);
        
        empresaC.addProducto(sofaRelaxC);
        empresaC.addProducto(mesaCristal);

        // 4. Configurar los catálogos (El Patrón Bridge en acción)
        CatalogoSofas catalogoSofas = new CatalogoSofas();
        catalogoSofas.addProveedor(empresaA);
        catalogoSofas.addProveedor(empresaC); // Unimos los stocks de A y C para sofás

        CatalogoMesas catalogoMesas = new CatalogoMesas();
        catalogoMesas.addProveedor(empresaB);
        catalogoMesas.addProveedor(empresaC); // Unimos los stocks de B y C para mesas

        // 5. ¡Pruebas de funcionamiento!
        System.out.println("=== PRUEBA 1: STOCK DE SOFÁS ORDENADO POR UNIDADES (Agregando A y C) ===");
        // Debería sumar los 10 de A y los 5 de C para el "Sofá modelo Relax" -> Total 15
        List<Producto> sofasAgregados = catalogoSofas.obtenerStockOrdenadoUnidades();
        for (Producto p : sofasAgregados) {
            System.out.println(p.toString());
        }
        
        System.out.println("\n=== PRUEBA 2: STOCK DE MESAS ORDENADO POR PRECIO ===");
        List<Producto> mesasPrecio = catalogoMesas.obtenerStockOrdenadoPrecio();
        for (Producto p : mesasPrecio) {
            System.out.println(p.toString());
        }

        System.out.println("\n=== PRUEBA 3: BÚSQUEDA ESPECÍFICA DE SOFÁS DE 2 PLAZAS ===");
        List<Producto> sofas2Plazas = catalogoSofas.buscarPorNumeroPlazas(2);
        for (Producto p : sofas2Plazas) {
            System.out.println(p.toString());
        }
    }
}