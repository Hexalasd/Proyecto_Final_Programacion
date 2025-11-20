package logica;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import persistencia.Excepciones;
import persistencia.Respaldo;

//con singleton porque el sistema del juego es unico
public class Juego implements Serializable{
        private ArrayList <Jugador> jugadores;
        private ArrayList <Pregunta> preguntas;
        private ArrayList <Categoria> categorias;
        private static Juego JUEGO;

     private Juego() throws ClassNotFoundException, Excepciones {
        Respaldo archivos = new Respaldo();

        if (archivos.existeArchivo("Juego")) {
            Juego juegoRecuperado = (Juego) archivos.recuperar("Juego");
            this.jugadores = juegoRecuperado.jugadores;
            this.preguntas = juegoRecuperado.preguntas;
            this.categorias = juegoRecuperado.categorias;
        } else {
            jugadores = new ArrayList<Jugador>();
            preguntas = new ArrayList<Pregunta>();
            categorias = new ArrayList<Categoria>();
        }
    }

    public static Juego getInstance() throws ClassNotFoundException, Excepciones {
        if (JUEGO == null) {
            JUEGO = new Juego();
        }
        return JUEGO;
    }
    
    public void guardarColeccion() throws Excepciones {
        Respaldo archivos = new Respaldo();
        archivos.respaldar("Juego", this);
    }
    
    
    
     public ArrayList<Jugador> getListaJugadores() {
        Collections.sort(jugadores);
        return jugadores;
    }
     public ArrayList<Pregunta> getListaPreguntas() {
        Collections.sort(preguntas);
        return preguntas;
    }
     public ArrayList<Categoria> getListaCategorias() {
        Collections.sort(categorias);
        return categorias;
    }
     
 
        
    //agregar o borrar (modificar esta en cada clase)
    
    
    //PREGUNTAS
    public void addPregunta(String textoPregunta, String opcion1, String opcion2, String opcion3, String respuestaCorrecta, Categoria categoria){
        ArrayList<String> posiblesRespuestas = new ArrayList<>();
        posiblesRespuestas.add(opcion1);
        posiblesRespuestas.add(opcion2);
        posiblesRespuestas.add(opcion3);
        Pregunta pregunta = new Pregunta(textoPregunta, posiblesRespuestas, respuestaCorrecta, categoria);
        preguntas.add(pregunta);
    }  
    
    public void delPregunta(Pregunta pregunta){
        preguntas.remove(pregunta);
    }
    
    
    //VER EL CONTRUCTOR DE EL COSO ESTE QUE LO CAMBIE, NO NECESITA HERENCIA
    
    //JUGADORES
    public void addJugador(String nombre,String passwd){
        Jugador jugador = new Jugador( nombre, passwd);
        jugadores.add(jugador);
    }
    
    public void addJugador(String nombre){
        Jugador jugador = new Jugador( nombre);
        jugadores.add(jugador);
    }
    
    public void delJugador(Jugador jugador){
        jugadores.remove(jugador);
    }
    

    
    
    //CATEGORIAS
    
    public void addCategoria(String nombre, String descripcion){
        Categoria categoria = new Categoria(nombre, descripcion);
        categorias.add(categoria);
    }
   
    public void delCategoria(Categoria categoria){
        categorias.remove(categoria);
    }
    
    
    
    //GETTERS
    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public ArrayList<Pregunta> getPreguntas() {
        return preguntas;
    }

    public ArrayList<Categoria> getCategorias() {
        return categorias;
    } 
    
    
    public void addPregunta(Pregunta p){
        preguntas.add(p);
    }
    
    public void addCategoria(Categoria p){
        categorias.add(p);
    }
    
    public void addJugador(Jugador p){
        jugadores.add(p);
    }
    
    
      
}
