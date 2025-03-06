package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar número de jugadores
        int numJugadores;
        while (true) {
            System.out.println("RULETA RUSA");
            System.out.print("Ingrese el número de jugadores (entre 2 y 6): ");

            try {
                numJugadores = Integer.parseInt(scanner.nextLine());

                // Validar rango de jugadores
                if (numJugadores >= 2 && numJugadores <= 6) {
                    break;
                } else {
                    System.out.println("El número de jugadores debe estar entre 2 y 6.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese un número válido.");
            }
        }

        // Crear lista con nombres de jugadores
        List<String> nombresJugadores = new ArrayList<>();

        // Solicitar nombres de jugadores
        for (int i = 0; i < numJugadores; i++) {
            while (true) {
                System.out.print("Ingrese el nombre del jugador " + (i + 1) + ": ");
                String nombre = scanner.nextLine().trim();

                // Validar que el nombre no esté vacío y sea único
                if (!nombre.isEmpty()) {
                    if (!nombresJugadores.contains(nombre)) {
                        nombresJugadores.add(nombre);
                        break;
                    } else {
                        System.out.println("Este nombre ya está en uso. Elija otro.");
                    }
                } else {
                    System.out.println("El nombre no puede estar vacío.");
                }
            }
        }

        // Crear instancia de RuletaRusa con los jugadores
        RuletaRusa ruletaRusa = new RuletaRusa(nombresJugadores);

        // Variables para control del juego
        boolean juegoActivo = true;

        System.out.println("\n¡Comienza el juego!");

        // Bucle principal del juego
        while (juegoActivo && ruletaRusa.quedanJugadores()) {
            // Obtener el próximo jugador
            RuletaRusa.Jugador proximoJuagador = ruletaRusa.getProximoJugador();
            System.out.println("\n Turno de: " + proximoJuagador.getNombre());
            System.out.print("Presiona Enter para disparar...");
            scanner.nextLine();

            // Disparar
            RuletaRusa.Jugador jugadorActual = ruletaRusa.disparar();

            // Verificar resultado
            if (jugadorActual.estaEliminado()) {
                System.out.println("¡BANG! " + jugadorActual.getNombre() + " ha sido eliminado.");
                System.out.println("La bala estaba en la recamara #" + ruletaRusa.getPosicionBala());
            } else {
                System.out.println("¡Click! " + jugadorActual.getNombre() + " sobrevive.");
            }

            // Verificar si queda un ganador
            if (!ruletaRusa.quedanJugadores()) {
                RuletaRusa.Jugador ganador = ruletaRusa.obtenerGanador();
                System.out.println("\n¡" + ganador.getNombre() + " es el GANADOR!");

                // Preguntar si quiere jugar de nuevo
                System.out.print("¿Quieres jugar de nuevo? (s/n): ");
                String respuesta = scanner.nextLine();

                if ("s".equalsIgnoreCase(respuesta)) {
                    ruletaRusa.reiniciarJuego();
                    juegoActivo = true;
                    System.out.println("\n¡Nuevo juego iniciado!");
                } else {
                    juegoActivo = false;
                }
            }
        }

        System.out.println("Fin del juego.");
        scanner.close();
    }
}