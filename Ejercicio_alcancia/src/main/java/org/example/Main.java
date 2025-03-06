package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Variables para almacenar la cantidad de monedas por denominación (contadores)
        int monedas_de_20 = 0;
        int monedas_de_50 = 0;
        int monedas_de_100 = 0;
        int monedas_de_200 = 0;
        int monedas_de_500 = 0;

        boolean alcancia_Rota = false;  // Indica si la alcancía se rompió

        int opcion = 0; // control de selección de opciones

        // Ciclo While principal del programa
        while (opcion != 5 && !alcancia_Rota) {
            // Menú de opciones
            System.out.println("\n--- MENU ALCANCIA ---");
            System.out.println("1. Agregar monedas");
            System.out.println("2. Contar monedas por denominación");
            System.out.println("3. Calcular total de dinero");
            System.out.println("4. Romper alcancía");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();

            // Opción 1: Agregar monedas a la alcancía
            if (opcion == 1 && !alcancia_Rota) {
                System.out.println("\nSeleccione denominación de moneda:");
                System.out.println("1. $20");
                System.out.println("2. $50");
                System.out.println("3. $100");
                System.out.println("4. $200");
                System.out.println("5. $500");
                System.out.print("Opción: ");

                int denominacion = scanner.nextInt();

                // Solicitar la cantidad de monedas a agregar por denominaciíon
                System.out.print("Ingrese la cantidad de monedas a agregar: ");
                int cantidad = scanner.nextInt();

                // Manejo de errores
                if (cantidad <= 0) {
                    System.out.println("La cantidad debe ser mayor a cero.");
                } else {
                    // Agregar las monedas según la denominación seleccionada
                    if (denominacion == 1) {
                        monedas_de_20 += cantidad;
                        System.out.println(cantidad + " moneda(s) de $20 agregada(s).");
                    } else if (denominacion == 2) {
                        monedas_de_50 += cantidad;
                        System.out.println(cantidad + " moneda(s) de $50 agregada(s).");
                    } else if (denominacion == 3) {
                        monedas_de_100 += cantidad;
                        System.out.println(cantidad + " moneda(s) de $100 agregada(s).");
                    } else if (denominacion == 4) {
                        monedas_de_200 += cantidad;
                        System.out.println(cantidad + " moneda(s) de $200 agregada(s).");
                    } else if (denominacion == 5) {
                        monedas_de_500 += cantidad;
                        System.out.println(cantidad + " moneda(s) de $500 agregada(s).");
                    } else {
                        System.out.println("Opción inválida.");
                    }
                }
            }
            // Opción 2: Contar monedas por denominación
            else if (opcion == 2 && !alcancia_Rota) {
                System.out.println("\n--- MONEDAS EN LA ALCANCIA ---");
                System.out.println("Monedas de $20: " + monedas_de_20);
                System.out.println("Monedas de $50: " + monedas_de_50);
                System.out.println("Monedas de $100: " + monedas_de_100);
                System.out.println("Monedas de $200: " + monedas_de_200);
                System.out.println("Monedas de $500: " + monedas_de_500);

                // Calcular y mostrar el total de monedas
                int totalMonedas = monedas_de_20 + monedas_de_50 + monedas_de_100 + monedas_de_200 + monedas_de_500;
                System.out.println("Total de monedas: " + totalMonedas);
            }
            // Opción 3: Calcular el total de dinero ahorrado
            else if (opcion == 3 && !alcancia_Rota) {
                // Calcular el valor total sumando el valor de cada tipo de moneda
                int total = (monedas_de_20 * 20) + (monedas_de_50 * 50) + (monedas_de_100 * 100) +
                           (monedas_de_200 * 200) + (monedas_de_500 * 500);
                System.out.println("\nTotal de dinero ahorrado: $" + total);
            }
            // Opción 4: Romper la alcancía y mostrar su contenido
            else if (opcion == 4) {
                System.out.println("\n¡ALCANCIA ROTA!");
                System.out.println("--- CONTENIDO VACIADO ---");
                System.out.println("Monedas de $20: " + monedas_de_20 + " = $" + (monedas_de_20 * 20));
                System.out.println("Monedas de $50: " + monedas_de_50 + " = $" + (monedas_de_50 * 50));
                System.out.println("Monedas de $100: " + monedas_de_100 + " = $" + (monedas_de_100 * 100));
                System.out.println("Monedas de $200: " + monedas_de_200 + " = $" + (monedas_de_200 * 200));
                System.out.println("Monedas de $500: " + monedas_de_500 + " = $" + (monedas_de_500 * 500));

                // Calcular y mostrar el total recuperado
                int total = (monedas_de_20 * 20) + (monedas_de_50 * 50) + (monedas_de_100 * 100) +
                           (monedas_de_200 * 200) + (monedas_de_500 * 500);
                System.out.println("Total recuperdado: $" + total); // cantidad total final

                // La alcancía está rota
                alcancia_Rota = true;
            }
            // Opción 5: Salir del programa
            else if (opcion == 5) {
                System.out.println("\nSaliendo del programa...");
            }
            // Mensaje cuando la alcancía está rota
            else if (alcancia_Rota) {
                System.out.println("\nLa alcancía está rota, no se pueden realizar más operaciones.");
            }
            // Manejo de erroes
            else {
                System.out.println("\nOpción inválida.");
            }
        }
        scanner.close();
    }
}