package prueba.logica.servicios.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import prueba.exeptions.BaseDeDatosException;
import prueba.logica.entidades.Pregunta;
import prueba.logica.servicios.PreguntaServicio;
import prueba.persistencia.ConexionBD;

public class PreguntaServicioImpl implements PreguntaServicio {

    //====================== CONSULTAS PARA LA BASE DE DATOS =================//
    private final String todasLasPreguntas = "SELECT * FROM pregunta";
    private final String preguntasPorIdCat = "SELECT * FROM preguntas P LEFT JOIN categoria C ON P.IdCategoria = C.IdCategoria WHERE P.IdCategoria = ? AND P.Nivel = ?";

    //====================== CONSULTAS PARA LA BASE DE DATOS =================//
    private static PreguntaServicioImpl servicioPregunta;

    private ConexionBD conexion = new ConexionBD(); //OBTENER LA CONEXION A LA BASE DE DATOS

    public PreguntaServicioImpl() {
    }

//========== OBTENER LA INSTANCIA DE LA CLASE MEDIANTE UN GETTER =========//
    public PreguntaServicioImpl getInstance() {
        if (null == servicioPregunta) {
            servicioPregunta = new PreguntaServicioImpl();
        }
        return servicioPregunta;
    }
//========== OBTENER LA INSTANCIA DE LA CLASE MEDIANTE UN GETTER =========//

    //==================== OBTENER TODOS LOS ESPECTACULOS=========//
    @Override
    public List<Pregunta> getTodasLasPreguntas() {
        List<Pregunta> pregunta = new ArrayList<>();
        try {
            PreparedStatement sentencia = conexion.getConexion().prepareStatement(todasLasPreguntas);
            ResultSet rs = sentencia.executeQuery();
            while (rs.next()) {
                pregunta.add(preguntasMapper(rs));
            }

        } catch (SQLException ex) {
            Logger.getLogger(PreguntaServicioImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pregunta;

    }
    //==================== OBTENER TODOS LOS ESPECTACULOS=========//

    @Override
    public List<Pregunta> getPreguntasPorIdCategoria(Long idCategoria, Long idPregunta) {

        try {
            List<Pregunta> pregunta = new ArrayList<>();
            ResultSet rs;
            PreparedStatement sentencia = conexion.getConexion().prepareStatement(preguntasPorIdCat);
            sentencia.setLong(1, idCategoria);
            sentencia.setLong(2, idPregunta);
            rs = sentencia.executeQuery();
            while (rs.next()) {
                pregunta.add(preguntasMapper(rs));
            }
            return pregunta;
        } catch (SQLException ex) {
            throw new BaseDeDatosException(String.format("Error SQL [%s]", ex.getMessage()));
        }

    }

    @Override
    public Pregunta getPreguntaPorIdCategoria(Long idC, int nivel) {
        try {
            PreparedStatement sentencia = conexion.getConexion().prepareStatement(preguntasPorIdCat);
            sentencia.setLong(1, idC);
            sentencia.setInt(2, nivel);
            ResultSet rs = sentencia.executeQuery();
            while (rs.next()) {
                return preguntasMapper(rs);
            }
            return null;
        } catch (SQLException ex) {
            throw new BaseDeDatosException(ex.getMessage(), ex.getCause());
        }
    }

    private Pregunta preguntasMapper(ResultSet rs) throws SQLException {
        return new Pregunta(rs.getLong("IdPregunta"), rs.getString("contenido"),rs.getInt("puntos"));
    }

}
