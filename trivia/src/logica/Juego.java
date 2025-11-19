package logica;

import java.util.ArrayList;
//con singleton porque el sisema del juego es unico
public class Juego {
        private ArrayList <Jugador> jugadores;
        private ArrayList <Pregunta> preguntas;
        private ArrayList <Categoria> categorias;
        private static Juego juego;

   //constructor privado
    private Juego(ArrayList<Jugador> jugadores, ArrayList<Pregunta> preguntas, ArrayList<Categoria> categorias) {
        this.jugadores = jugadores;
        this.preguntas = preguntas;
        this.categorias = categorias;
    }
    
    //singleton
    public static Juego getSingletonInstance(ArrayList<Jugador> jugadores, ArrayList<Pregunta> preguntas, ArrayList<Categoria> categorias){
        if (juego == null){
            Juego juego = new Juego(jugadores, preguntas, categorias);
        }
        
        return juego;
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
    
    
    
    
    //JUGADORES
    public void addJugador(String nombre, String tipo, String passwd){
        Jregistrado jugador = new Jregistrado( nombre, tipo, passwd);
        jugadores.add(jugador);
    }
    
    public void addJugador(String nombre, String tipo){
        Jsistema jugador = new Jsistema( nombre, tipo);
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
      
}
