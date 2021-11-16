package prueba.logica.controladores;

import java.util.List;
import prueba.logica.entidades.Usuario;

public interface UsuarioControlador {

    public Usuario Logeo(String nickname, String clave);

    public void altaUsuario(Usuario usuario);

}
