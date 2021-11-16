package prueba.logica.entidades;

public class Pregunta {

    private Long idPregunta;
    private String contenido;
    private int nivel;
    private int puntos;

    public Pregunta() {
    }

    public Pregunta(String contenido) {
        this.contenido = contenido;
    }

    public Pregunta(Long idPregunta, String contenido, int puntos) {
        this.idPregunta = idPregunta;
        this.contenido = contenido;
        this.puntos = puntos;
    }
    

    public Pregunta(Long idPregunta, String contenido) {
        this.idPregunta = idPregunta;
        this.contenido = contenido;
    }
    

    public Pregunta(String contenido, Long idPregunta, int nivel) {
        this.idPregunta = idPregunta;
        this.contenido = contenido;
        this.nivel = nivel;
    }

    public Long getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(Long IdPregunta) {
        this.idPregunta = IdPregunta;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    @Override
    public String toString() {
        return String.format("%s (%s) (%s)", contenido, idPregunta,puntos);
    }

}
