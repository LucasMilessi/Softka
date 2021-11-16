package prueba.logica.controladores;

import java.util.List;
import prueba.logica.entidades.Respuesta;

public interface RespuestaControlador {

    //public List<Respuesta> getRespuestaPorIdPregunta(Long idPregunta, Long idRespuesta);
    
     public List<Respuesta> getRespuestaPorIdPreguntaAleatoria(Long idPregunta);
}
