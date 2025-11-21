package logica;

import java.util.ArrayList;

public class PartidaLogica {
    
    private ArrayList<Jugador> jugadores;
    private String categotia;
    private int rondas;

    public PartidaLogica(ArrayList<Jugador> jugadores, String categotia, int rondas) {
        this.jugadores = jugadores;
        this.categotia = categotia;
        this.rondas = rondas;
    }
    public PartidaLogica() {

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
