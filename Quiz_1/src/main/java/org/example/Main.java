package org.example;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Producto> listaProductos = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean salir = false;

        while (!salir) {
            System.out.println("\n*** MENÚ DE GESTIÓN DE PRODUCTOS ***");
            System.out.println("1. Crear producto");
            System.out.println("2. Vender producto");
            System.out.println("3. Reponer stock");
            System.out.println("4. Aplicar descuento (2%)");
            System.out.println("5. Mostrar información de un producto");
            System.out.println("6. Aumentar precio (6%)");
            System.out.println("7. Calcular valor total de inventario");
            System.out.println("8. Eliminar producto");
            System.out.println("9. Mostrar todos los productos");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    crearProducto();
                    break;
                case 2:
                    venderProducto();
                    break;
                case 3:
                    reponerStock();
                    break;
                case 4:
                    aplicarDescuento();
                    break;
                case 5:
                    mostrarInformacion();
                    break;
                case 6:
                    aumentarPrecio();
                    break;
                case 7:
                    calcularValorTotalInventario();
                    break;
                case 8:
                    eliminarProducto();
                    break;
                case 9:
                    mostrarTodosLosProductos();
                    break;
                case 0:
                    salir = true;
                    System.out.println("¡Hasta pronto!");
                    break;
                default:
                    System.out.println("Opción no válida, intente de nuevo.");
            }
        }

        scanner.close();
    }

    // 1. Crear un producto
    private static void crearProducto() {
        System.out.println("\n*** CREAR PRODUCTO ***");
        System.out.print("Ingrese el código del producto: ");
        String codigo = scanner.nextLine();

        // Verificar si el código ya existe
        for (Producto p : listaProductos) {
            if (p.getCodigo().equals(codigo)) {
                System.out.println("Error: Ya existe un producto con ese código.");
                return;
            }
        }

        System.out.print("Ingrese el nombre del producto: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese el precio del producto: ");
        double precio = scanner.nextDouble();

        System.out.print("Ingrese la cantidad en stock: ");
        int stock = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer

        Producto nuevoProducto = new Producto(codigo, nombre, precio, stock);
        listaProductos.add(nuevoProducto);

        System.out.println("Producto creado con éxito.");
    }

    // 2.Vender un producto
    private static void venderProducto() {
        System.out.println("\n*** VENDER PRODUCTO ***");
        Producto producto = buscarProductoPorCodigo();

        if (producto != null) {
            System.out.print("Ingrese la cantidad a vender: ");
            int cantidad = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            if (producto.venderProducto(cantidad)) {
                System.out.println("Venta realizada con éxito.");
            }
        }
    }

    // 3. Reponer stock
    private static void reponerStock() {
        System.out.println("\n*** REPONER STOCK ***");
        Producto producto = buscarProductoPorCodigo();

        if (producto != null) {
            System.out.print("Ingrese la cantidad a reponer: ");
            int cantidad = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            producto.reponerStock(cantidad);
            System.out.println("Stock repuesto con éxito.");
        }
    }

    // 4. Aplicar descuento
    private static void aplicarDescuento() {
        System.out.println("\n*** APLICAR DESCUENTO (2%) ***");
        Producto producto = buscarProductoPorCodigo();

        if (producto != null) {
            producto.aplicarDescuento(2); // Descuento fijo del 2%
            System.out.println("Descuento aplicado con éxito.");
        }
    }

    // 5. Mstrar información
    private static void mostrarInformacion() {
        System.out.println("\n*** MOSTRAR INFORMACIÓN ***");
        Producto producto = buscarProductoPorCodigo();

        if (producto != null) {
            producto.mostrarInformacion();
        }
    }

    // 6. Aumentar precio
    private static void aumentarPrecio() {
        System.out.println("\n*** AUMENTAR PRECIO (6%) ***");
        Producto producto = buscarProductoPorCodigo();

        if (producto != null) {
            producto.aumentarPrecio(6); // Aumento fijo del 6%
            System.out.println("Precio aumentado con éxito.");
        }
    }

    // 7. Calcular valor total en inventario
    private static void calcularValorTotalInventario() {
        System.out.println("\n*** VALOR TOTAL EN INVENTARIO ***");

        if (listaProductos.isEmpty()) {
            System.out.println("No hay porductos en el inventario.");
            return;
        }

        double valorTotal = 0;
        for (Producto p : listaProductos) {
            double valorProducto = p.calcularValorTotalInventario();
            valorTotal += valorProducto;

            System.out.println(p.getNombre() + ": $" + valorProducto);
        }

        System.out.println("---------------------------------");
        System.out.println("VALOR TOTAL DEL INVENTARIO: $" + valorTotal);
    }

    // 8. Eliminar un producto
    private static void eliminarProducto() {
        System.out.println("\n*** ELIMINAR PRODUCTO ***");
        System.out.print("Ingrese el código del producto a eliminar: ");
        String codigo = scanner.nextLine();

        for (int i = 0; i < listaProductos.size(); i++) {
            if (listaProductos.get(i).getCodigo().equals(codigo)) {
                listaProductos.remove(i);
                System.out.println("Producto eliminado con éxito.");
                return;
            }
        }

        System.out.println("No se encontró un producto con ese código :(.");
    }

    // Buscar un producto por código
    private static Producto buscarProductoPorCodigo() {
        System.out.print("Ingrese el código del producto: ");
        String codigo = scanner.nextLine();

        for (Producto p : listaProductos) {
            if (p.getCodigo().equals(codigo)) {
                return p;
            }
        }

        System.out.println("No se encontró un producto con ese código :( .");
        return null;
    }

    // Mostrar todos los productos
    private static void mostrarTodosLosProductos() {
        System.out.println("\n*** LISTA DE PRODUCTOS ***");

        if (listaProductos.isEmpty()) {
            System.out.println("No hay productos en el inventario :( .");
            return;
        }

        for (Producto p : listaProductos) {
            System.out.println("---------------------------------");
            p.mostrarInformacion();
        }
    }
}