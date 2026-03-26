package patron_composite;

public class Main {
    public static void main(String[] args) {
        
        // 1. Crear el contenedor principal (El Campus) usando la clase Espacio
        Espacio campus = new Espacio("Campus Principal");

        // 2. Crear un Edificio y añadirlo al Campus
        Espacio aulario = new Espacio("Edificio Aulario");
        campus.agregarElemento(aulario);

        // 3. Crear Salas y añadirlas al Edificio
        Espacio aula1 = new Espacio("Aula 1");
        Espacio aula2 = new Espacio("Aula 2");
        aulario.agregarElemento(aula1);
        aulario.agregarElemento(aula2);

        // 4. Crear Aparatos Eléctricos (consumo por hora, horas de uso estimado)
        AparatoElectrico proyector = new AparatoElectrico(150.0, 4.0); 
        AparatoElectrico ordenador = new AparatoElectrico(250.0, 5.0); 
        AparatoElectrico aireAcondicionado = new AparatoElectrico(2000.0, 6.0); 

        // 5. Asignar los aparatos a sus salas correspondientes (Hojas dentro de Compuestos)
        aula1.agregarElemento(proyector);
        aula1.agregarElemento(ordenador);
        aula2.agregarElemento(aireAcondicionado);

        // 6. Añadir un aparato directamente a un edificio (fuera de las salas, como pide el PDF)
        AparatoElectrico maquinaExpendedora = new AparatoElectrico(400.0, 24.0); 
        aulario.agregarElemento(maquinaExpendedora);

        // --- PRUEBAS Y RESULTADOS ---
        System.out.println("=== SISTEMA DE CONTROL DE GASTO ENERGÉTICO ===");
        
        System.out.println("\n--- Desglose por Espacios ---");
        System.out.println("Consumo global " + aula1.getNombre() + ": " + aula1.estimarConsumoGlobal() + " W");
        System.out.println("Consumo global " + aula2.getNombre() + ": " + aula2.estimarConsumoGlobal() + " W");
        
        System.out.println("Consumo global " + aulario.getNombre() + " (Aulas + Máquina): " + aulario.estimarConsumoGlobal() + " W");
        
        System.out.println("\n--- Gasto Total ---");
        System.out.println("Consumo Total Estimado del " + campus.getNombre() + ": " + campus.estimarConsumoGlobal() + " W");
        System.out.println("Coste Total Estimado del " + campus.getNombre() + ": " + campus.calcularCosteTotal() + " €");
    }
}