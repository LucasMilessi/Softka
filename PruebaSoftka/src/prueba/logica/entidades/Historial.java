package prueba.logica.entidades;

public class Historial{
    
    private int puntaje;
    private Usuario IdUsuario;

    public Historial() {
    }

    public Historial(int puntaje, Usuario IdUsuario) {
        this.puntaje = puntaje;
        this.IdUsuario = IdUsuario;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public Usuario getIdUsuario() {
        return IdUsuario;
    }
    
    
    
    
}
