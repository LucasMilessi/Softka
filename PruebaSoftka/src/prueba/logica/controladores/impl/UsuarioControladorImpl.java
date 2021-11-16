package prueba.logica.controladores.impl;

import java.util.List;
import prueba.exeptions.BaseDeDatosException;
import prueba.exeptions.PruebaModelException;
import prueba.logica.HelperString;
import prueba.logica.controladores.UsuarioControlador;
import prueba.logica.entidades.Usuario;
import prueba.logica.servicios.UsuarioServicio;
import prueba.logica.servicios.impl.UsuarioServicioImpl;

public class UsuarioControladorImpl implements UsuarioControlador {

    private static UsuarioControladorImpl instance;

    public UsuarioControladorImpl() {
    }

    //Obtener la instancia
    public UsuarioControladorImpl getInstance() {
        if (null == instance) {
            instance = new UsuarioControladorImpl();
        }
        return instance;
    }

    //Obtener instancia de servicio usuario
    private final UsuarioServicio usuarioServicio = new UsuarioServicioImpl().getInstance();

    @Override
    public Usuario Logeo(String nickname, String clave) {
        try {
            return usuarioServicio.Logeo(nickname, clave);
        } catch (BaseDeDatosException ex) {
            throw new PruebaModelException(String.format("Error en base de datos [%s]", ex.getMessage()));
        }
    }

    @Override
    public void altaUsuario(Usuario usuario) {
        try {
            Usuario usr = (Usuario) usuario;
            validarParametrosUsuario(usr); //Verificar que los datos no esten vacios o nulos
            usuarioServicio.altaUsuario(usuario); //Llama a servicio y muetsra
        } catch (BaseDeDatosException ex) {
            throw new PruebaModelException(ex.getMessage(), ex.getCause());
        }
    }

    private void validarParametrosUsuario(Usuario usuario) {
        HelperString.stringNoVacio(usuario.getNombre(), "nombre");
        HelperString.stringNoVacio(usuario.getApellido(), "apellido");
    }
}
