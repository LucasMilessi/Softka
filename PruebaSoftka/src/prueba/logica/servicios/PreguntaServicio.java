package prueba.logica.servicios;

import java.sql.SQLException;
import java.util.List;
import prueba.logica.entidades.Pregunta;

public interface PreguntaServicio {

    
    public List<Pregunta> getTodasLasPreguntas();
    
    public List<Pregunta> getPreguntasPorIdCategoria(Long idCategoria, Long idPregunta);
    
    public Pregunta getPreguntaPorIdCategoria(Long idC, int nivel);
}
