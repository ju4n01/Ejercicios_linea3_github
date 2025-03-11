package org.example;
import java.util.ArrayList;
import java.util.Scanner;

public class Producto {
    // Atributos
    private String codigo;
    private String nombre;
    private double precio;
    private int cantidadStock;
    private double porcentajeDescuento = 0.02;
    private double procentajeAumento = 0.06;

    // CONTRUCTOR
    //Crear producto
    public Producto(String codigo, String nombre, double precio, int cantidadStock) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidadStock = cantidadStock;
    }

    // Getters - Setters
    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidadStock() {
        return cantidadStock;
    }

    public void setCantidadStock(int cantidadStock) {
        this.cantidadStock = cantidadStock;
    }

    // MÉTODOS

    // 2. Vender producto: reduce la cantidad de Stock si no hay suficiente cant
    public boolean venderProducto(int cantidad) {
        if (cantidadStock >= cantidad) {
            cantidadStock -= cantidad;
            return true;
        } else {
            System.out.println("No hay suficiente stock disponible para " + nombre);
            return false;
        }
    }

    // 3. Reponer stock: Aumenta la cantidad de stock, cuando llega Nueva mercancía
    public void reponerStock(int cantidad) {
        cantidadStock += cantidad;
    }

    // 4. Aplicar descuento: reduce el precio del producto en un porcentaje dado (2%)
    public void aplicarDescuento(double porcentajeDescuento) {
        precio = precio - (precio * porcentajeDescuento / 100);
    }

    // 5. Mostrar información: Imprime  los detalles del producto (NO toString)
    public void mostrarInformacion() {
        System.out.println("Código: " + codigo);
        System.out.println("Nombre: " + nombre);
        System.out.println("Precio: $" + precio);
        System.out.println("Stock: " + cantidadStock + " unidades");
    }

    // 6. Aumentar precio: Incrementa el precio en un porcentaje dado (6%)
    public void aumentarPrecio(double procentajeAumento) {
        precio = precio + (precio * procentajeAumento / 100);
    }

    // 7. Calcular valor total en inventario: Multiplica la cantidad en stock por el precio del producto
    public double calcularValorTotalInventario() {
        return precio * cantidadStock;
    }
}