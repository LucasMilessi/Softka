package prueba.logica.servicios.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import prueba.exeptions.BaseDeDatosException;
import prueba.logica.entidades.Respuesta;
import prueba.logica.servicios.RespuestaServicio;
import prueba.persistencia.ConexionBD;

public class RespuestaServicioImpl implements RespuestaServicio {

    //====================== CONSULTAS PARA LA BASE DE DATOS =================//
    private final String respuestasPorIdPregunta = "SELECT R.contenido FROM respuesta R LEFT JOIN preguntas P ON R.IdRespuesta = P.IdPregunta WHERE R.IdPregunta = ?";
    private final String respuestasPorIdPreguntaAleatorio = "SELECT DISTINCT * FROM respuesta R LEFT JOIN preguntas P ON R.IdPregunta=P.IdPregunta WHERE R.IdPregunta = ? ORDER BY RAND() LIMIT 4";
    private final String respuestaCorrecta = "SELECT R.valor FROM respuesta R WHERE R.idRespuesta = ?";
    //====================== CONSULTAS PARA LA BASE DE DATOS =================//
    private static RespuestaServicioImpl respuestaPregunta;

    private ConexionBD conexion = new ConexionBD(); //OBTENER LA CONEXION A LA BASE DE DATOS

    public RespuestaServicioImpl() {
    }

//========== OBTENER LA INSTANCIA DE LA CLASE MEDIANTE UN GETTER =========//
    public RespuestaServicioImpl getInstance() {
        if (null == respuestaPregunta) {
            respuestaPregunta = new RespuestaServicioImpl();
        }
        return respuestaPregunta;
    }
//========== OBTENER LA INSTANCIA DE LA CLASE MEDIANTE UN GETTER =========//

    /*public List<Respuesta> getRespuestaPorIdPregunta(Long idPregunta, Long idRespuesta) {

        try {
            List<Respuesta> pregunta = new ArrayList<>();
            ResultSet rs;
            PreparedStatement sentencia = conexion.getConexion().prepareStatement(respuestasPorIdPregunta);
            sentencia.setLong(1, idPregunta);
            sentencia.setLong(2, idRespuesta);
            rs = sentencia.executeQuery();
            while (rs.next()) {
                pregunta.add(respuestasMapper(rs));
            }
            return pregunta;
        } catch (SQLException ex) {
            throw new BaseDeDatosException(String.format("Error SQL [%s]", ex.getMessage()));
        }

    }*/
    @Override
    public List<Respuesta> getRespuestaPorIdPreguntaAleatoria(Long idPregunta) {

        try {
            List<Respuesta> respuestas = new ArrayList<>();
            ResultSet rs;
            PreparedStatement sentencia = conexion.getConexion().prepareStatement(respuestasPorIdPreguntaAleatorio); 
            sentencia.setLong(1, idPregunta);
            rs = sentencia.executeQuery();
            while (rs.next()) {
                 respuestas.add(respuestasMapper(rs));
            }
            return respuestas;
        } catch (SQLException ex) {
            throw new BaseDeDatosException(String.format("Error SQL [%s]", ex.getMessage()));
        }

    }

    private Respuesta respuestasMapper(ResultSet rs) throws SQLException {
        return new Respuesta(rs.getString("contenido"),rs.getBoolean("tipo"));
    }

}
