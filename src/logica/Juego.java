package logica;

import java.io.Serializable;
import java.util.ArrayList;
//con singleton porque el sisema del juego es unico
public class Juego implements Serializable{
        private ArrayList <Jugador> jugadores;
        private ArrayList <Pregunta> preguntas;
        private ArrayList <Categoria> categorias;
        private static Juego JUEGO;

       /*
        TIENE UN ERROR PORQUE EL CONSTRUCTOR ESTA COMO COMENTARIO, NO TOQUES!!!!!!!!!!!!!!!!!!!!
  parece qe se implementa distinto esto con la persistencia
   //constructor privado
    private Juego(ArrayList<Jugador> jugadores, ArrayList<Pregunta> preguntas, ArrayList<Categoria> categorias) {
        this.jugadores = jugadores;
        this.preguntas = preguntas;
        this.categorias = categorias;
    }
    */
    //singleton
    public static Juego getSingletonInstance(ArrayList<Jugador> jugadores, ArrayList<Pregunta> preguntas, ArrayList<Categoria> categorias){
        if (JUEGO == null){
            Juego JUEGO = new Juego(jugadores, preguntas, categorias);
        }
        return JUEGO;
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
      
}
