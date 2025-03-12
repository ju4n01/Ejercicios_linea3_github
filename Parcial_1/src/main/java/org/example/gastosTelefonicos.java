package org.example;

import java.util.ArrayList;
import java.util.List;

public class gastosTelefonicos {
    // Constantes para las tarifas boolean no da error!
    private static final double TARIFA_LOCAL = 50.0;
    private static final double TARIFA_LARGA_DISTANCIA = 350.0;
    private static final double TARIFA_CELULAR = 150.0;
    
    // Lista para almacenar las cabinas
    private List<Cabina> cabinas;
    
    // Constructor
    public gastosTelefonicos() {
        cabinas = new ArrayList<>();
    }
    
    // Método para crear una cabina
    public boolean crearCabina(String nombre) {
        cabinas.add(new Cabina(nombre));
        return true;
    }
    
    // Método para obtener una cabina por su índice
    public Cabina getCabina(int indice) {
        if (indice >= 0 && indice < cabinas.size()) {
            return cabinas.get(indice);
        }
        return null;
    }
    
    // Método para obtener el número de cabinas
    public int getNumeroCabinas() {
        return cabinas.size();
    }
    
    // Método para registrar una llamada
    public boolean registrarLlamada(int indiceCabina, int tipoLlamada, int duracionMinutos) {
        if (indiceCabina >= 0 && indiceCabina < cabinas.size()) {
            Cabina cabina = cabinas.get(indiceCabina);
            
            switch (tipoLlamada) {
                case 1: // Llamada local
                    cabina.agregarLlamada(duracionMinutos, duracionMinutos * TARIFA_LOCAL);
                    return true;
                case 2: // Llamada larga distancia
                    cabina.agregarLlamada(duracionMinutos, duracionMinutos * TARIFA_LARGA_DISTANCIA);
                    return true;
                case 3: // Llamada celular
                    cabina.agregarLlamada(duracionMinutos, duracionMinutos * TARIFA_CELULAR);
                    return true;
                default:
                    return false;
            }
        }
        return false;
    }
    
    // Método para reiniciar una cabina
    public boolean reiniciarCabina(int indiceCabina) {
        if (indiceCabina >= 0 && indiceCabina < cabinas.size()) {
            cabinas.get(indiceCabina).reiniciar();
            return true;
        }
        return false;
    }
    
    // Método para obtener información consolidada de todas las cabinas
    public String obtenerConsolidadoTotal() {
        int totalLlamadas = 0;
        int totalMinutos = 0;
        double costoTotal = 0.0;
        
        for (Cabina cabina : cabinas) {
            totalLlamadas += cabina.getNumeroLlamadas();
            totalMinutos += cabina.getDuracionTotal();
            costoTotal += cabina.getCostoTotal();
        }
        
        return "CONSOLIDADO TOTAL:\n" +
               "Número total de llamadas: " + totalLlamadas + "\n" +
               "Duración total en minutos: " + totalMinutos + "\n" +
               "Costo total en pesos: $" + costoTotal;
    }
    
    // Clase interna para representar una cabina
    public class Cabina {
        private String nombre;
        private int numeroLlamadas;
        private int duracionTotal;
        private double costoTotal;
        
        // Constructor
        public Cabina(String nombre) {
            this.nombre = nombre;
            reiniciar();
        }
        
        // Getters
        public String getNombre() {
            return nombre;
        }
        
        public int getNumeroLlamadas() {
            return numeroLlamadas;
        }
        
        public int getDuracionTotal() {
            return duracionTotal;
        }
        
        public double getCostoTotal() {
            return costoTotal;
        }
        
        // Método para agregar una llamada
        public void agregarLlamada(int duracion, double costo) {
            numeroLlamadas++;
            duracionTotal += duracion;
            costoTotal += costo;
        }
        
        // Método para reiniciar la cabina
        public void reiniciar() {
            numeroLlamadas = 0;
            duracionTotal = 0;
            costoTotal = 0.0;
        }
        
        // Método para obtener información detallada de la cabina
        public String obtenerInformacionDetallada() {
            return "Cabina: " + nombre + "\n" +
                   "Número de llamadas: " + numeroLlamadas + "\n" +
                   "Duración total en minutos: " + duracionTotal + "\n" +
                   "Costo total en pesos: $" + costoTotal;
        }
    }
}