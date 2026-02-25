package abstract_factory;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FactoriaAbstracta factoria = null;
        Menu pedido = null;

        System.out.println("=== BIENVENIDO AL SISTEMA DE PEDIDOS ===");
        System.out.println("1. Consumir en el restaurante");
        System.out.println("2. Pedido para llevar (+2% precio, semanal sin postre)");
        System.out.print("¿Cómo desea su pedido? (1 o 2): ");
        
        int opcionLugar = scanner.nextInt();

        // 1. Elegimos la familia de productos (La Factoría)
        if (opcionLugar == 1) {
            factoria = new FactoriaRestaurante();
        } else if (opcionLugar == 2) {
            factoria = new FactoriaParaLlevar();
        } else {
            System.out.println("Opción no válida. Saliendo del sistema...");
            scanner.close();
            return;
        }

        System.out.println("\n¿Qué tipo de menú desea?");
        System.out.println("1. Menú Semanal (Incluye 1º, 2º y postre en restaurante)");
        System.out.println("2. Menú de Temporada (Plato único especial)");
        System.out.print("Elija una opción (1 o 2): ");
        
        int opcionMenu = scanner.nextInt();

        // 2. Elegimos el producto concreto a fabricar
        if (opcionMenu == 1) {
            System.out.println("\n¿Qué acompañamiento desea para su 2º plato?");
            System.out.println("1. Patatas");
            System.out.println("2. Ensalada");
            System.out.print("Elija una opción (1 o 2): ");
            int opAcomp = scanner.nextInt();
            
            TipoAcompanamiento acompanamiento = (opAcomp == 1) ? TipoAcompanamiento.PATATAS : TipoAcompanamiento.ENSALADA;
            
            // Fabricamos el menú semanal pasándole el acompañamiento elegido
            pedido = factoria.crearMenuSemanal(acompanamiento);
            
        } else if (opcionMenu == 2) {
            // Fabricamos el menú de temporada (no lleva acompañamiento a elegir)
            pedido = factoria.crearMenuTemporada();
        } else {
            System.out.println("Opción no válida. Saliendo del sistema...");
            scanner.close();
            return;
        }

        // 3. Mostramos el resultado final
        System.out.println("\n=== RESUMEN DE SU PEDIDO ===");
        System.out.println(pedido.toString());
        pedido.mostrarMenu();

        scanner.close();
    }
}