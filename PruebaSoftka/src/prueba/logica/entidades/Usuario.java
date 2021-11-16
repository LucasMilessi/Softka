package prueba.logica.entidades;


public class Usuario {
    
    private String nombre;
    private String apellido;
    private Long IdUsuario;
    private String nickname;
    private String clave;
    private Long puntos;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Long getPuntos() {
        return puntos;
    }

    public void setPuntos(Long puntos) {
        this.puntos = puntos;
    }

    public Usuario() {
    }

    public Usuario(String nombre, String apellido, String nickname, String clave) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.nickname = nickname;
        this.clave = clave;
        this.puntos = puntos;
    }

    public Usuario(Long IdUsuario, String nickname, Long puntos) {
        this.IdUsuario = IdUsuario;
        this.nickname = nickname;
        this.puntos = puntos;
    }
    
    

    public Usuario(String nombre, String apellido, Long IdUsuario, String nickname,String clave) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.IdUsuario = IdUsuario;
        this.nickname = nickname;
        this.clave = clave;
    }

    public Usuario(String nickname, String clave) {
        this.nickname = nickname;
        this.clave = clave;
    }
    

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public Long getIdUsuario() {
        return IdUsuario;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setIdUsuario(Long IdUsuario) {
        this.IdUsuario = IdUsuario;
    }

    public String getNickName() {
        return nickname;
    }

    public void setNickName(String nickName) {
        this.nickname = nickName;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    
    
    
    @Override
    public String toString() {
        return String.format("%s %s %s", nombre, apellido, nickname);
    }
    
    
    
    
    
}
