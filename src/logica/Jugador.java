package logica;

import java.io.Serializable;
//todavia queda lo de organizar preguntas por algo (no me acuerso si era vategoria y difici)

public class Jugador  implements Serializable{
    private String nombre;
    private String tipo;
    private String passwd;


    public Jugador(String nombre) {
        this.nombre = nombre;
        this.tipo = "default";
        this.passwd = "";
    }
    
    public Jugador(String nombre, String passwd) {
        this.nombre = nombre;
        this.tipo = "jugador";
        this.passwd = passwd;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return nombre+": tipo: "+tipo+", contraseña: "+passwd;
    }
    
    
}
