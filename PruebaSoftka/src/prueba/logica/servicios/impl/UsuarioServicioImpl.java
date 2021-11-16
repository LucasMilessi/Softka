package prueba.logica.servicios.impl;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.NoSuchElementException;
import prueba.exeptions.BaseDeDatosException;
import prueba.exeptions.PruebaModelException;
import prueba.logica.entidades.Usuario;
import prueba.logica.servicios.UsuarioServicio;
import prueba.persistencia.ConexionBD;

public class UsuarioServicioImpl implements UsuarioServicio {

//====================== CONSULTAS PARA LA BASE DE DATOS =================//
    private final String seleccionarUsuario = "SELECT * FROM usuarios u WHERE u.nickname = ? AND u.clave = ?";
    private final String nuevoUsuario = "INSERT INTO usuarios(nombre, apellido, nickname, clave) VALUES (?, ?, ?, ?)";

//====================== CONSULTAS PARA LA BASE DE DATOS =================//
    private static UsuarioServicioImpl servicioUsuario;

    private ConexionBD conexion = new ConexionBD(); //OBTENER LA CONEXION A LA BASE DE DATOS

    public UsuarioServicioImpl() {
    }

//========== OBTENER LA INSTANCIA DE LA CLASE MEDIANTE UN GETTER =========//
    public UsuarioServicioImpl getInstance() {
        if (null == servicioUsuario) {
            servicioUsuario = new UsuarioServicioImpl();
        }
        return servicioUsuario;
    }
//========== OBTENER LA INSTANCIA DE LA CLASE MEDIANTE UN GETTER =========//

//================== OBTENER LA LISTA DE TODOS LOS USUARIOS ==============//
    @Override
    public Usuario Logeo(String nickname, String clave) {
        try {
            PreparedStatement sentencia = conexion.getConexion().prepareStatement(seleccionarUsuario);
            sentencia.setString(1, nickname);
            sentencia.setString(2, clave);
            ResultSet rs = sentencia.executeQuery();
            while (rs.next()) {
                return usuarioMapper(rs);
            }
            throw new NoSuchElementException(String.format("Usuario no encontrado", nickname));
        } catch (SQLException e) {
            throw new BaseDeDatosException(e.getMessage(), e.getCause());
        }

    }
    //================== OBTENER LA LISTA DE TODOS LOS USUARIOS ==============//

    @Override
    public void altaUsuario(Usuario usuario) {
        try {
            PreparedStatement sentencia = conexion.getConexion().prepareStatement(nuevoUsuario);
            sentencia.setString(1, usuario.getNombre());
            sentencia.setString(2, usuario.getApellido());
            sentencia.setString(3, usuario.getNickName());
            sentencia.setString(4, usuario.getClave());
            sentencia.executeUpdate();

        } catch (MySQLIntegrityConstraintViolationException ex) {
            throw new PruebaModelException(String.format("Ya existe un usuario con el nickname [%s]", usuario.getNickName()));
        } catch (SQLException ex) {
            throw new BaseDeDatosException(String.format("Error SQL [%s]", ex.getMessage()), ex.getCause());
        }
    }
    //============================= ALTA USUARIO=============================//

    //========================= DEVUELVE EL ESPECTADOR =======================//
    private Usuario usuarioMapper(ResultSet rs) throws SQLException {
        return new Usuario(rs.getString("nickname"), rs.getString("clave"), rs.getString("nombre"), rs.getString("apellido"));
    }

}
