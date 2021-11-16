package prueba.logica.servicios;

import java.util.List;
import prueba.logica.entidades.Respuesta;

public interface RespuestaServicio {
    
    //public List<Respuesta> getRespuestaPorIdPregunta(Long idPregunta, Long idRespuesta);
    
    public List<Respuesta> getRespuestaPorIdPreguntaAleatoria(Long idPregunta);
    

}
