package prueba.logica.controladores.impl;

import java.util.List;
import prueba.exeptions.BaseDeDatosException;
import prueba.exeptions.PruebaModelException;
import prueba.logica.controladores.PreguntaControlador;
import prueba.logica.entidades.Pregunta;
import prueba.logica.servicios.PreguntaServicio;
import prueba.logica.servicios.impl.PreguntaServicioImpl;

public class PreguntaControladorImpl implements PreguntaControlador {

    private static PreguntaControladorImpl instance;

    public PreguntaControladorImpl() {
    }

    //Obtener la instancia
    public PreguntaControladorImpl getInstance() {
        if (null == instance) {
            instance = new PreguntaControladorImpl();
        }
        return instance;
    }

    //Obtener instancia de servicio usuario
    private final PreguntaServicio preguntaServicio = new PreguntaServicioImpl().getInstance();

    @Override
    public List<Pregunta> getPreguntasPorIdCategoria(Long idCategoria, Long idPregunta) {
        try {
            return preguntaServicio.getPreguntasPorIdCategoria(idCategoria,idPregunta);
        } catch (BaseDeDatosException ex) {
            throw new PruebaModelException(String.format("Error en base de datos [%s]", ex.getMessage()));
        }
    }

    @Override
    public List<Pregunta> getTodasLasPreguntas() {
        try {
            return preguntaServicio.getTodasLasPreguntas();
        } catch (BaseDeDatosException ex) {
            throw new PruebaModelException(String.format("Error en base de datos [%s]", ex.getMessage()));
        }
    }

    @Override
    public Pregunta getPreguntaPorIdCategoria(Long idC, int nivel) {
        return preguntaServicio.getPreguntaPorIdCategoria(idC,nivel);
        
    }
    
    

}
