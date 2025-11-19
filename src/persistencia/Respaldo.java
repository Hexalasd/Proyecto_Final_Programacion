package persistencia;

import persistencia.Excepciones;
import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class Respaldo {

   
    public void respaldar(String nomArch, Object objeto) throws Excepciones{
        try {
            FileOutputStream f = new FileOutputStream(nomArch);
            ObjectOutputStream o = new ObjectOutputStream(f);
            // Escribo el arreglo de alumnos o carrera en el archivo a través del flujo
            o.writeObject(objeto);
            o.close();
            f.close();
        } catch (IOException e) {
            throw new Excepciones(1);
        }
    }

    public Object recuperar(String nomArch) throws ClassNotFoundException, Excepciones {
        try {
            // Abro el archivo y creo un flujo de comunicación hacia él
            FileInputStream f = new FileInputStream(nomArch);
            ObjectInputStream o = new ObjectInputStream(f);
            // Leo el arreglo de alumnos o carreras desde el archivo a través del flujo
            Object elObjeto = o.readObject();
            o.close();
            f.close();
            return elObjeto;
        } catch (IOException e) {
            throw new Excepciones(2);
        }

    }

    public boolean existeArchivo(String nombreArchivo) {
        boolean existe = false;
        File archPrueba = new File(nombreArchivo);
        if (archPrueba.isFile()) {
            existe = true;
        } else {
            existe = false;
        }
        return existe;
    }

}
