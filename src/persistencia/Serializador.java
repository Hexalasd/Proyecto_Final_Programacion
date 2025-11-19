package persistencia;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author Luis Eduardo Fagúndez Clase que permite serializar objetos, trabaja
 * con los objetos: ObjectInputStream: Para leer los archivos que fueron creados
 * anteriormente ObjectOutputStream: Para escribir objetos en un archivo
 */
public class Serializador {

    private ObjectInputStream lectorDeObjetos;
    private ObjectOutputStream escritorDeObjetos;

    /**
     * @author Luis Eduardo Fagúndez
     * @param obj
     * @param archivo
     * @throws FileNotFoundException
     * @throws IOException Este método permite serializar un objeto a un
     * archivo, la idea del método es pasarle el objeto que va a serializar y
     * hacer un getNombre al objeto para crear un archivo con el nombre del
     * usuario, ejemplo: ser.writeObject(eduardin, eduardin.getNombre());
     */
    public void writeObject(Object obj, String archivo) throws FileNotFoundException, IOException {
        escritorDeObjetos = new ObjectOutputStream(new FileOutputStream(archivo));
        escritorDeObjetos.writeObject(obj);
        escritorDeObjetos.close();
    }

    /**
     * @author Luis Eduardo Fagúndez
     * @param archivo
     * @return rtn (objeto que estaba serializado)
     * @throws FileNotFoundException
     * @throws IOException
     * @throws ClassNotFoundException Este método permite cargar un archivo
     * serializado y transformarlo en un objeto, es importante saber que usuario
     * se va a cargar porque archivo lleva el nombre de cada usuario
     */
    public Object readObject(String archivo) throws FileNotFoundException, IOException, ClassNotFoundException {
        Object rtn = null;
        lectorDeObjetos = new ObjectInputStream(new FileInputStream(archivo));
        rtn = lectorDeObjetos.readObject();
        lectorDeObjetos.close();
        return rtn;
    }

    /**
     * author Fabian y Luis comprueba si un archivo existe para crear Jugador.
     *
     * @param nombreArchivo
     * @return
     */
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

    /**
     * @Author Luis E. Fagúndez
     * @param nombreArchivo Este método se encarga de borrar un archivo que se
     * le pasa por parámetro usa el método existeArchivo(String archivo) para
     * comprobar si el archivo previamente fue creado.
     */
    public void borrarArchivo(String nombreArchivo) {
        boolean existe = existeArchivo(nombreArchivo);
        if (existe) {
            File archPrueba = new File(nombreArchivo);
            archPrueba.delete();
        }
    }

    /*
    public File[] retornarUsuarios() {
        File directorio = new File(ruta);
        File[] listaUsuarios = null;
        if (directorio.exists()) {
            if (directorio.isDirectory()) {
                listaUsuarios = directorio.listFiles();
                return listaUsuarios;
            }
        }
        return listaUsuarios;
    }*/
}
