package prueba.logica.controladores.impl;

import java.util.List;
import prueba.exeptions.BaseDeDatosException;
import prueba.exeptions.PruebaModelException;
import prueba.logica.controladores.RespuestaControlador;
import prueba.logica.entidades.Respuesta;
import prueba.logica.servicios.RespuestaServicio;
import prueba.logica.servicios.impl.RespuestaServicioImpl;

public class RespuestaControladorImpl implements RespuestaControlador {

    private static RespuestaControladorImpl instance;

    public RespuestaControladorImpl() {
    }

    //Obtener la instancia
    public RespuestaControladorImpl getInstance() {
        if (null == instance) {
            instance = new RespuestaControladorImpl();
        }
        return instance;
    }

    private final RespuestaServicio respuestaServicio = new RespuestaServicioImpl().getInstance();

    /*@Override
    public List<Respuesta> getRespuestaPorIdPregunta(Long idPregunta, Long idRespuesta) {
        return respuestaServicio.getRespuestaPorIdPregunta(idPregunta, idRespuesta);
    }*/
    @Override
    public List<Respuesta> getRespuestaPorIdPreguntaAleatoria(Long idPregunta) {
        try {
            return respuestaServicio.getRespuestaPorIdPreguntaAleatoria(idPregunta);
        } catch (BaseDeDatosException ex) {
            throw new PruebaModelException(String.format("Error en base de datos [%s]", ex.getMessage()));
        }
    }

}
