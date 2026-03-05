package patron_composite;

public class Main {
    public static void main(String[] args) {
        
        // 1. Crear el contenedor principal (El Campus)
        Campus campus = new Campus();

        // 2. Crear un Edificio y añadirlo al Campus
        Edificio aulario = new Edificio();
        campus.agregarElemento(aulario);

        // 3. Crear Salas y añadirlas al Edificio
        Sala aula1 = new Sala();
        Sala aula2 = new Sala();
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
        System.out.println("Consumo global Aula 1 (Proyector + Ordenador): " + aula1.estimarConsumoGlobal() + " W");
        System.out.println("Consumo global Aula 2 (Aire Acondicionado): " + aula2.estimarConsumoGlobal() + " W");
        
        // El edificio sumará el Aula 1 + Aula 2 + Máquina Expendedora automáticamente
        System.out.println("Consumo global del Edificio Aulario: " + aulario.estimarConsumoGlobal() + " W");
        
        System.out.println("\n--- Gasto Total del Campus ---");
        // El campus le preguntará al edificio, el edificio a las salas y a la máquina, y las salas a los aparatos
        System.out.println("Consumo Total Estimado del Campus: " + campus.estimarConsumoGlobal() + " W");
        System.out.println("Coste Total Estimado del Campus: " + campus.calcularCosteTotal() + " €");
    }
}