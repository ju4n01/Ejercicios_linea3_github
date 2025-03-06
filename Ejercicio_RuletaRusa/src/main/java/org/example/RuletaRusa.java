package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RuletaRusa {
    private List<Integer> tambor;
    private int bala;
    private int posicionActual;
    private Random random;
    private List<Jugador> jugadores;

    // Constructor
    public RuletaRusa(List<String> nombresJugadores) {
        // Inicializar el tambor con posiciones de 0 a 5
        tambor = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            tambor.add(i);
        }

        // Inicializar generador de números aleatorios
        random = new Random();

        // Asignar posición aleatoria de la bala
        bala = random.nextInt(6);

        // Establecer posición inicial del tambor
        posicionActual = 0;

        // Crear lista de jugadores
        jugadores = new ArrayList<>();
        for (String nombre : nombresJugadores) {
            jugadores.add(new Jugador(nombre));
        }
    }

    // MÉTODOS
    // Método para disparar
    public Jugador disparar() {
        // Obtener el primer jugador no eliminado
        Jugador jugadorActual = null;
        int indiceJugadorActual = -1;

        for (int i = 0; i < jugadores.size(); i++) {
            if (!jugadores.get(i).estaEliminado()) {
                jugadorActual = jugadores.get(i);
                indiceJugadorActual = i;
                break;
            }
        }

        if (jugadorActual == null) {
            return null; // No deberíamos llegar aquí si quedanJugadores() es verdadero
        }

        // Verificar si la posición actual coincide con la posición de la bala
        boolean resultado = posicionActual == bala;

        if (resultado) {
            // Jugador pierde
            jugadorActual.setEliminado(true);
        } else {
            // Reorganizar la lista para que el siguiente jugador no eliminado sea el próximo
            if (indiceJugadorActual != -1) {
                // Mover este jugador al final
                Jugador temp = jugadores.remove(indiceJugadorActual);
                jugadores.add(temp);
            }
        }

        // Avanzar la posición del tambor
        posicionActual = (posicionActual + 1) % 6;

        return jugadorActual;
    }

    // Método para reiniciar el juego
    public void reiniciarJuego() {
        // Limpiar y volver a crear el tambor
        tambor.clear();
        for (int i = 0; i < 6; i++) {
            tambor.add(i);
        }

        // Nueva posición aleatoria para la bala
        bala = random.nextInt(6);

        // Reiniciar posición actual
        posicionActual = 0;

        // Reiniciar estado de los jugadores
        for (Jugador jugador : jugadores) {
            jugador.setEliminado(false);
        }
    }

    // Método para verificar si queda más de un jugador
    public boolean quedanJugadores() {
        int jugadoresActivos = 0;
        for (Jugador jugador : jugadores) {
            if (!jugador.estaEliminado()) {
                jugadoresActivos++;
            }
        }
        return jugadoresActivos > 1;
    }

     // Método para obtener el próximo jugador
    public Jugador getProximoJugador() {
        // Obtener el primer jugador de la lista que no esté eliminado
        for (Jugador jugador : jugadores) {
            if (!jugador.estaEliminado()) {
                return jugador;
            }
        }
        return null;
    }

    // Método para obtener el ganador
    public Jugador obtenerGanador() {
        for (Jugador jugador : jugadores) {
            if (!jugador.estaEliminado()) {
                return jugador;
            }
        }
        return null;
    }

    // Getters
    public int getPosicionBala() {
        return bala;
    }

    public int getPosicionActual() {
        return posicionActual;
    }

    // Clase interna para representar a los jugadores
    public static class Jugador {
        private String nombre;
        private boolean eliminado;

        public Jugador(String nombre) {
            this.nombre = nombre;
            this.eliminado = false;
        }

        public String getNombre() {
            return nombre;
        }

        public boolean estaEliminado() {
            return eliminado;
        }

        public void setEliminado(boolean eliminado) {
            this.eliminado = eliminado;
        }
    }
}