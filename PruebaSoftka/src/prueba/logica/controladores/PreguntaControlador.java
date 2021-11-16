package prueba.logica.controladores;

import java.util.List;
import prueba.logica.entidades.Pregunta;

public interface PreguntaControlador {

    List<Pregunta> getTodasLasPreguntas();
    
    public List<Pregunta> getPreguntasPorIdCategoria(Long idCategoria, Long idPregunta);
    
    public Pregunta getPreguntaPorIdCategoria(Long idC, int nivel);
    
}
