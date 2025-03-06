package org.example;

import java.util.List;
import java.util.Scanner;

public class Operaciones {

    private String titular;
    private double saldo;
    private int numeroCuentas;

    // Constructores existentes (sin cambios)
    public Operaciones() {
        this.titular = "";
        this.saldo = 0.0;
        this.numeroCuentas = 0;
    }

    public Operaciones(String titular, double saldo, int numeroCuentas) {
        this.titular = titular;
        this.saldo = saldo;
        this.numeroCuentas = numeroCuentas;
    }

    // Getters y setters existentes (sin cambios)
    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public int getNumeroCuentas() {
        return numeroCuentas;
    }

    public void setNumeroCuentas(int numeroCuentas) {
        this.numeroCuentas = numeroCuentas;
    }

    // Métodos existentes (sin cambios)
    public void depositar(double cantidad) {
        if (cantidad > 0) {
            this.saldo += cantidad;
            System.out.println("Se ha depositado $" + cantidad + " en la cuenta de " + this.titular);
        } else {
            System.out.println("La cantidad a depositar debe ser mayor que 0");
        }
    }

    public boolean retirar(double cantidad) {
        if (cantidad > 0 && this.saldo >= cantidad) {
            this.saldo -= cantidad;
            System.out.println("Se ha retirado $" + cantidad + " de la cuenta de " + this.titular);
            return true;
        } else {
            System.out.println("No se puede retirar $" + cantidad + ". Saldo insuficiente o cantidad inválida");
            return false;
        }
    }

    public void mostrarInformacion() {
        System.out.println("Información de la cuenta bancaria:");
        System.out.println("Titular: " + this.titular);
        System.out.println("Número de cuenta: " + this.numeroCuentas);
        System.out.println("Saldo actual: $" + this.saldo);
        System.out.println("=======================================");
    }

    public String obtenerResumen() {
        return "Resumen de cuenta - Titular: " + this.titular + ", Cuenta: " + this.numeroCuentas + ", Saldo: $" + this.saldo;
    }

    // Nuevos métodos agregados desde la clase Main
    public static void depositarDinero(List<Operaciones> cuentas, Scanner scanner) {
        System.out.print("Ingrese el número de cuenta donde depositar: ");
        int numeroCuenta = scanner.nextInt();
        scanner.nextLine();

        for (Operaciones cuenta : cuentas) {
            if (cuenta.getNumeroCuentas() == numeroCuenta) {
                System.out.print("Ingrese la cantidad a depositar: ");
                double cantidad = scanner.nextDouble();
                scanner.nextLine();
                cuenta.depositar(cantidad);
                return;
            }
        }
        System.out.println("Cuenta no encontrada");
    }

    public static void retirarDinero(List<Operaciones> cuentas, Scanner scanner) {
        System.out.print("Ingrese el número de cuenta desde donde retirar: ");
        int numeroCuenta = scanner.nextInt();
        scanner.nextLine();

        for (Operaciones cuenta : cuentas) {
            if (cuenta.getNumeroCuentas() == numeroCuenta) {
                System.out.print("Ingrese la cantidad a retirar: ");
                double cantidad = scanner.nextDouble();
                scanner.nextLine();
                cuenta.retirar(cantidad);
                return;
            }
        }
        System.out.println("Cuenta no encontrada");
    }

    public static void mostrarCuentas(List<Operaciones> cuentas) {
        System.out.println("\n*** ESTADO ACTUAL DE LAS CUENTAS ***");
        for (Operaciones cuenta : cuentas) {
            cuenta.mostrarInformacion();
        }
    }

    public static void buscarCuentasPorNumero(List<Operaciones> cuentas, Scanner scanner) {
        System.out.println("Ingrese el número de cuenta a buscar: ");
        int numeroCuenta = scanner.nextInt();
        scanner.nextLine();

        boolean cuentaEncontrada = false;
        for (Operaciones cuenta : cuentas) {
            if (cuenta.getNumeroCuentas() == numeroCuenta) {
                System.out.println("*** Cuenta encontrada ***");
                cuenta.mostrarInformacion();
                cuentaEncontrada = true;
                break;
            }
        }

        if (!cuentaEncontrada) {
            System.out.println("Cuenta no encontrada con el número: " + numeroCuenta);
        }
    }

    @Override
    public String toString() {
        return "Operaciones{" +
                "titular='" + titular + '\'' +
                ", saldo=" + saldo +
                ", numeroCuentas=" + numeroCuentas +
                '}';
    }
}