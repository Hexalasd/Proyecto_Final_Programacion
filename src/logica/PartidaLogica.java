package logica;

import java.util.ArrayList;

public class PartidaLogica {
    
    private ArrayList<Jugador> jugadores;
    private ArrayList<Pregunta> preguntas;
    private int[] puntos = new int[4];
    private String categotia;
    private int rondas;
    private int cantPartidas;

    public PartidaLogica(ArrayList<Jugador> jugadores, ArrayList<Pregunta> preguntas, String categotia, int rondas) {
        this.jugadores = jugadores;
        this.categotia = categotia;
        this.rondas = rondas;
    }
    public PartidaLogica() {

    }

    public ArrayList<Pregunta> getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(ArrayList<Pregunta> preguntas) {
        this.preguntas = preguntas;
    }

    public int getCantPartidas() {
        return cantPartidas;
    }

    public void setCantPartidas(int cantPartidas) {
        this.cantPartidas = cantPartidas;
    }

    public int[] getPuntos() {
        return puntos;
    }

    public void setPuntos(int[] puntos) {
        this.puntos = puntos;
    }

    
    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(ArrayList<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public String getCategotia() {
        return categotia;
    }

    public void setCategotia(String categotia) {
        this.categotia = categotia;
    }

    public int getRondas() {
        return rondas;
    }

    public void setRondas(int rondas) {
        this.rondas = rondas;
    }
    
    
}
