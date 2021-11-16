package prueba.logica.entidades;

public class Respuesta {

    private Long IdRespuesta;
    private String contenido;
    private boolean tipo;

    public Respuesta(String contenido) {
        this.contenido = contenido;
    }

    public Respuesta(Long IdRespuesta, boolean tipo) {
        this.IdRespuesta = IdRespuesta;
        this.tipo = tipo;

    }

    public Respuesta(String contenido, boolean tipo) {
        this.contenido = contenido;
        this.tipo = tipo;
    }
    

    public Respuesta(Long IdRespuesta, String contenido) {
        this.IdRespuesta = IdRespuesta;
        this.contenido = contenido;
    }

    public Respuesta() {
    }

    public Long getIdRespuesta() {
        return IdRespuesta;
    }

    public void setIdRespuesta(Long IdRespuesta) {
        this.IdRespuesta = IdRespuesta;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public boolean getTipo() {
        return tipo;
    }

    public void setTipo(boolean valor) {
        this.tipo = valor;
    }

    @Override
    public String toString() {
        return String.format("%s %s", contenido, tipo);
    }

}
