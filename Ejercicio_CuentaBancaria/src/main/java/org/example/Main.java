package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Operaciones> cuentas = new ArrayList<>();

        System.out.println("¿Cuántas cuentas deseas crear?");
        int numCuentas = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numCuentas; i++) {
            System.out.println("\nIngrese los datos de la cuenta " + (i + 1));
            System.out.print("Titular: ");
            String titular = scanner.nextLine();
            System.out.print("Número de cuenta: ");
            int numeroCuenta = scanner.nextInt();
            System.out.print("Saldo inicial: ");
            double saldo = scanner.nextDouble();
            scanner.nextLine();

            Operaciones cuenta = new Operaciones(titular, saldo, numeroCuenta);
            cuentas.add(cuenta);
        }

        // Mostrar un estado inicial, luego de ingresar los datos de las n cuentas creadas.
        System.out.println("\n*** ESTADO INICIAL DE LAS CUENTAS ***");
        for (Operaciones cuenta : cuentas) {
            cuenta.mostrarInformacion();
        }

        while (true) {
            System.out.println("\n¿Qué deseas hacer?");
            System.out.println("1. Depositar dinero");
            System.out.println("2. Retirar dinero");
            System.out.println("3. Mostrar cuentas");
            System.out.println("4. Buscar cuentas por número");
            System.out.println("5. Salir");
            System.out.print("Opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    Operaciones.depositarDinero(cuentas, scanner);
                    break;
                case 2:
                    Operaciones.retirarDinero(cuentas, scanner);
                    break;
                case 3:
                    Operaciones.mostrarCuentas(cuentas);
                    break;
                case 4:
                    Operaciones.buscarCuentasPorNumero(cuentas, scanner);
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    return;
                default:
                    System.out.println("Opción inválida");
            }
        }
    }
}