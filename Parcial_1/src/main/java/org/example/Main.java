package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("*** SISTEMA DE CONTROL DE GASTOS TELEFÓNICOS ***");

        // Crear instancia de gastosTelefonicos
        gastosTelefonicos gastos = new gastosTelefonicos();

        int opcion;
        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    crearCabina(scanner, gastos);
                    break;
                case 2:
                    registrarLlamada(scanner, gastos);
                    break;
                case 3:
                    mostrarInformacionCabina(scanner, gastos);
                    break;
                case 4:
                    mostrarConsolidadoTotal(gastos);
                    break;
                case 5:
                    reiniciarCabina(scanner, gastos);
                    break;
                case 6:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }

            System.out.println(); // Separador

        } while (opcion != 6);

        scanner.close();
    }

    // mostrar el menú principal
    private static void mostrarMenu() {
        System.out.println("*** MENÚ PRINCIPAL ***");
        System.out.println("1. Crear cabina telefónica");
        System.out.println("2. Registrar llamada");
        System.out.println("3. Mostrar información de una cabina");
        System.out.println("4. Mostrar consolidado total");
        System.out.println("5. Reiniciar cabina");
        System.out.println("6. Salir");
        System.out.print("Ingrese una opción: ");
    }

    // para crear una cabina
    private static void crearCabina(Scanner scanner, gastosTelefonicos gastos) {
        System.out.print("Ingrese el nombre de la cabina: ");
        String nombre = scanner.nextLine();

        if (gastos.crearCabina(nombre)) {
            System.out.println("Cabina creada exitosamente.");
        } else {
            System.out.println("No se pudo crear la cabina.");
        }


    }

    // Método para registrar una llamada
    private static void registrarLlamada(Scanner scanner, gastosTelefonicos gastos) {
        if (gastos.getNumeroCabinas() == 0) {
            System.out.println("No hay cabinas disponibles. Debe crear al menos una cabina.");
            return;
        }

        // Mostrar cabinas disponibles
        System.out.println("Cabinas disponibles:");
        for (int i = 0; i < gastos.getNumeroCabinas(); i++) {
            System.out.println(i + ". " + gastos.getCabina(i).getNombre());
        }

        System.out.print("Seleccione una cabina (0-" + (gastos.getNumeroCabinas() - 1) + "): ");
        int indiceCabina = scanner.nextInt();

        if (indiceCabina < 0 || indiceCabina >= gastos.getNumeroCabinas()) {
            System.out.println("Cabina inválida.");
            return;
        }

        System.out.println("Tipos de llamada:");
        System.out.println("1. Llamada Local ($50/min)");
        System.out.println("2. Llamada Larga Distancia ($350/min)");
        System.out.println("3. Llamada Celular ($150/min)");
        System.out.print("Seleccione el tipo de llamada (1-3): ");
        int tipoLlamada = scanner.nextInt();

        System.out.print("Ingrese la duración de la llamada en minutos: ");
        int duracion = scanner.nextInt();

        if (gastos.registrarLlamada(indiceCabina, tipoLlamada, duracion)) {
            System.out.println("Llamada registrada exitosamente.");
        } else {
            System.out.println("No se pudo registrar la llamada. Verifique los datos.");
        }
    }

    //  mostrar información de una cabina
    private static void mostrarInformacionCabina(Scanner scanner, gastosTelefonicos gastos) {
        if (gastos.getNumeroCabinas() == 0) {
            System.out.println("No hay cabinas disponibles.");
            return;
        }

        // Mostrar cabinas disponibles
        System.out.println("Cabinas disponibles:");
        for (int i = 0; i < gastos.getNumeroCabinas(); i++) {
            System.out.println(i + ". " + gastos.getCabina(i).getNombre());
        }

        System.out.print("Seleccione una cabina (0-" + (gastos.getNumeroCabinas() - 1) + "): ");
        int indiceCabina = scanner.nextInt();

        if (indiceCabina < 0 || indiceCabina >= gastos.getNumeroCabinas()) {
            System.out.println("Cabina inválida.");
            return;
        }

        gastosTelefonicos.Cabina cabina = gastos.getCabina(indiceCabina);
        System.out.println("*** INFORMACIÓN DETALLADA ***");
        System.out.println(cabina.obtenerInformacionDetallada());
    }

    // Método para mostrar el consolidado total
    private static void mostrarConsolidadoTotal(gastosTelefonicos gastos) {
        if (gastos.getNumeroCabinas() == 0) {
            System.out.println("No hay cabinas disponibles.");
            return;
        }

        System.out.println("*** CONSOLIDADO TOTAL ***");
        System.out.println(gastos.obtenerConsolidadoTotal());
    }

    // Método para reiniciar una cabina
    private static void reiniciarCabina(Scanner scanner, gastosTelefonicos gastos) {
        if (gastos.getNumeroCabinas() == 0) {
            System.out.println("No hay cabinas disponibles.");
            return;
        }

        // Mostrar cabinas disponibles
        System.out.println("Cabinas disponibles:");
        for (int i = 0; i < gastos.getNumeroCabinas(); i++) {
            System.out.println(i + ". " + gastos.getCabina(i).getNombre());
        }

        // Mensajes de control
        System.out.print("Seleccione una cabina para reiniciar (0-" + (gastos.getNumeroCabinas() - 1) + "): ");
        int indiceCabina = scanner.nextInt();

        if (indiceCabina < 0 || indiceCabina >= gastos.getNumeroCabinas()) {
            System.out.println("Cabina inválida.");
            return;
        }

        if (gastos.reiniciarCabina(indiceCabina)) {
            System.out.println("Cabina reiniciada exitosamente.");
        } else {
            System.out.println("No se pudo reiniciar la cabina.");
        }
    }
}