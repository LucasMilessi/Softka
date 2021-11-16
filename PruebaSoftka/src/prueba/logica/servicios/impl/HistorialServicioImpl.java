
package prueba.logica.servicios.impl;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import prueba.exeptions.BaseDeDatosException;
import prueba.exeptions.PruebaModelException;
import prueba.logica.entidades.Usuario;
import prueba.logica.servicios.HistorialServicio;
import prueba.persistencia.ConexionBD;


public class HistorialServicioImpl implements HistorialServicio {
    
    //====================== CONSULTAS PARA LA BASE DE DATOS =================//
    private final String cargarHistorial = "INSERT INTO historial(nickname, idUsuario, puntaje) VALUES (?, ?, ?)";
    //====================== CONSULTAS PARA LA BASE DE DATOS =================//
    private static HistorialServicioImpl historialPregunta;

    private ConexionBD conexion = new ConexionBD(); //OBTENER LA CONEXION A LA BASE DE DATOS

    public HistorialServicioImpl() {
    }

//========== OBTENER LA INSTANCIA DE LA CLASE MEDIANTE UN GETTER =========//
    public HistorialServicioImpl getInstance() {
        if (null == historialPregunta) {
            historialPregunta = new HistorialServicioImpl();
        }
        return historialPregunta;
    }
//========== OBTENER LA INSTANCIA DE LA CLASE MEDIANTE UN GETTER =========//
    
     public void cargarHistorial(Usuario usuario) {
        try {
            PreparedStatement sentencia = conexion.getConexion().prepareStatement(cargarHistorial);
            sentencia.setString(1, usuario.getNickName());
            sentencia.setString(2, usuario.getIdUsuario().toString());
            sentencia.setString(3, usuario.getPuntos().toString());
            sentencia.executeUpdate();

        } catch (MySQLIntegrityConstraintViolationException ex) {
            throw new PruebaModelException(String.format("Ya existe un usuario con el nickname [%s]", usuario.getNickName()));
        } catch (SQLException ex) {
            throw new BaseDeDatosException(String.format("Error SQL [%s]", ex.getMessage()), ex.getCause());
        }
    }
    
    
    
}
