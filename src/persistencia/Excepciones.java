package persistencia;

public class Excepciones extends Exception {

    private int modo;

    public Excepciones(int modo) {
        this.modo = modo;  
    }

    /**
     * @author Agustin
     * Proporciona mensajes según los catch generados 
     * en los métodos involucrados con el editor de cartas
     * @return 
     */
    public String darMensaje() {
        String mensaje = null;
        switch (modo) {
            case 1:
                mensaje = "Error al respaldar";
                break;
            case 2:
                mensaje = "Error al recuperar";
                break;
            case 3:
                mensaje = "no hay datos a recuperar";
                break;
            case 8:
                mensaje = "Error al respaldar";
                break;
            case 9:
                mensaje = "Error al recuperar";
                break;
            case 10:
                mensaje = "No hay datos a recuperar";
                break;
            case 11:
                mensaje = "No se puede cargar la imagen";
                break;

        }
        return modo + ": " + mensaje;
    }

}
