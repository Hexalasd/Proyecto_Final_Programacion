package logica;

//VER COMO HACER LO DE LA LSITA DE JUGADORES

import java.io.Serializable;
import java.util.ArrayList;

public class Categoria implements Serializable{
    private String nombre;
    private String descripcion;
    private ArrayList<Jugador> jugadores;
    private ArrayList<Double> puntaje;
    
    public Categoria(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
