package prueba.logica;

import prueba.logica.controladores.CategoriaControlador;
import prueba.logica.controladores.HistorialControlador;
import prueba.logica.controladores.PreguntaControlador;
import prueba.logica.controladores.RespuestaControlador;
import prueba.logica.controladores.UsuarioControlador;
import prueba.logica.controladores.impl.CategoriaControladorImpl;
import prueba.logica.controladores.impl.HistorialControladorImpl;
import prueba.logica.controladores.impl.PreguntaControladorImpl;
import prueba.logica.controladores.impl.RespuestaControladorImpl;
import prueba.logica.controladores.impl.UsuarioControladorImpl;
import prueba.logica.entidades.Respuesta;

public class Fabrica {

    private static Fabrica instancia;

    public static Fabrica getInstance() {
        if (instancia == null) {
            instancia = new Fabrica();
        }
        return instancia;
    }

    //Obtener instancia de UsuarioControladorImpl
    public UsuarioControlador getUsuarioControladorImpl() {
        UsuarioControlador usr = new UsuarioControladorImpl();
        return usr;
    }

    public UsuarioControlador getUsuarioControlador() {
        return new UsuarioControladorImpl();
    }

    public CategoriaControlador getCategoriaControladorImpl() {
        CategoriaControlador cat = new CategoriaControladorImpl();
        return cat;
    }

    public CategoriaControlador getCategoriaControlador() {
        return new CategoriaControladorImpl();
    }

    public PreguntaControlador getPreguntaControladorImpl() {
        PreguntaControlador pre = new PreguntaControladorImpl();
        return pre;
    }

    public PreguntaControlador getPreguntaControlador() {
        return new PreguntaControladorImpl();
    }

    public RespuestaControlador getRespuestaControladorImpl() {
        RespuestaControlador respuesta = new RespuestaControladorImpl();
        return respuesta;
    }

    public RespuestaControlador getRespuestaControlador() {
        return new RespuestaControladorImpl();
    }
    
     public HistorialControlador getHistorialControladorImpl() {
        HistorialControlador respuesta = new HistorialControladorImpl();
        return respuesta;
    }

    public HistorialControlador getHistorialControlador() {
        return new HistorialControladorImpl();
    }

}
