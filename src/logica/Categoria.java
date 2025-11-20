package logica;

//VER COMO HACER LO DE LA LSITA DE JUGADORES

import java.io.Serializable;
import java.util.ArrayList;

public class Categoria implements Serializable, Comparable<Categoria>{
    private String nombre;
    private String descripcion;
    
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
    
    public int compareTo(Categoria c) {
        return this.getNombre().compareTo(c.getNombre());
    }

    @Override
    public String toString() {
        return "Categoria{" + "nombre=" + nombre + ", descripcion=" + descripcion + '}';
    }
    
    
}
