package logica;

import java.io.Serializable;
import java.util.ArrayList;

public class Pregunta implements Serializable, Comparable<Pregunta> {
    private String pregunta;
    private ArrayList<String> posiblesRespuestas;
    private String respuestaCorrecta;
    private Categoria categoria;

    public Pregunta(String pregunta, ArrayList<String> posiblesRespuestas, String respuestaCorrecta, Categoria categoria) {
        this.pregunta = pregunta;
        this.posiblesRespuestas = posiblesRespuestas;
        this.respuestaCorrecta = respuestaCorrecta;
        this.categoria = categoria;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public ArrayList<String> getPosiblesRespuestas() {
        return posiblesRespuestas;
    }

    public void setPosiblesRespuestas(ArrayList<String> posiblesRespuestas) {
        this.posiblesRespuestas = posiblesRespuestas;
    }

    public String getRespuestaCorrecta() {
        return respuestaCorrecta;
    }

    public void setRespuestaCorrecta(String respuestaCorrecta) {
        this.respuestaCorrecta = respuestaCorrecta;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Pregunta{" + "pregunta=" + pregunta + ", posiblesRespuestas=" + posiblesRespuestas + ", respuestaCorrecta=" + respuestaCorrecta + ", categoria=" + categoria + '}';
    }
    
    public int compareTo(Pregunta p) {
        //guardamos el resultado de la comparacoin cpor categoria ignorando mayusculas
        int compCategoria = this.getCategoria().getNombre().compareToIgnoreCase(p.getCategoria().getNombre());

        //si no son iguales se devuelve el resultado
        if (compCategoria != 0) {
            return compCategoria;
        }else{
            //si no, lo comparamos segun el texto de la pregunta (alfabeticamente) 
            return this.getPregunta().compareToIgnoreCase(p.getPregunta());

        }
    }
    
}
