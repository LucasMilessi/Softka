package prueba.logica.servicios;

import java.util.List;
import prueba.logica.entidades.Usuario;

public interface UsuarioServicio {

    public Usuario Logeo(String nickname, String clave);

    public void altaUsuario(Usuario usuario);
}
