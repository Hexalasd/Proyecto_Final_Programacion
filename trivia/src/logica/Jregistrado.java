package logica;

public class Jregistrado extends Jugador{
    private String passwd;

    public Jregistrado(String nombre, String tipo, String passwd) {
        super(nombre, tipo);
        this.passwd = passwd;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    @Override
    public String toString() {
        return super.toString()+", contrasena: "+passwd;
    }
    
    
}
