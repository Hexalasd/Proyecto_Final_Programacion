package logica;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Jugador  implements Serializable, Comparable<Jugador>{
    private String nombre;
    private String tipo;
    private String passwd;
    //map es como un array que guarda datos de a varios, no de a uno. El primero es el clave, categoria en este caso. No es una clase
    //no se puede crear (no existe = new Map<>())
    private Map<String, Integer> puntajes;
    private String categoria = "General";


    public Jugador(String nombre) {
        this.nombre = nombre;
        this.tipo = "sistema";
        this.passwd = "";
        //hash map es la implementacion de map
        puntajes = new HashMap<>();
    }
    
    public Jugador(String nombre, String passwd) {
        this.nombre = nombre;
        this.tipo = "jugador";
        this.passwd = passwd;
    }
    
    public void sumarPunto(Categoria c){
    String nombre = c.getNombre();
    //si no existe lo crea y pone el puntaje en 0
    puntajes.putIfAbsent(nombre, 0);
    //actualiza el putnjate
    puntajes.put(nombre, puntajes.get(nombre) + 1);
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
    
     public String getCategoria() {
        return this.categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return nombre+": tipo: "+tipo+", contrasena: "+passwd;
    }
   
    public int compareTo(Jugador j) {
        if (this.tipo.compareTo(j.tipo) != 0){
            return j.getTipo().compareTo(this.getTipo());
        }else{
            if(categoria.equals("General")){
                return this.sumarPuntaje().compareTo(j.sumarPuntaje());    
            }
        }
        return this.getPuntajes().get(categoria).compareTo(j.getPuntajes().get(categoria));
    }
    
    public Integer sumarPuntaje(){
        Integer suma = 0;
            for (Integer valor : puntajes.values()) {
            suma += valor;
        }    
        return suma;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public Map<String, Integer> getPuntajes() {
        return puntajes;
    }

    public void setPuntajes(Map<String, Integer> puntajes) {
        this.puntajes = puntajes;
    }   
}
