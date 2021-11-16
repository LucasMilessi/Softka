package prueba.logica.controladores.impl;

import prueba.exeptions.BaseDeDatosException;
import prueba.exeptions.PruebaModelException;
import prueba.logica.controladores.HistorialControlador;
import prueba.logica.entidades.Usuario;
import prueba.logica.servicios.HistorialServicio;
import prueba.logica.servicios.impl.HistorialServicioImpl;

public class HistorialControladorImpl implements HistorialControlador {

    private static HistorialControladorImpl instance;

    public HistorialControladorImpl() {
    }

    //Obtener la instancia
    public HistorialControladorImpl getInstance() {
        if (null == instance) {
            instance = new HistorialControladorImpl();
        }
        return instance;
    }

    private final HistorialServicio historialServicio = new HistorialServicioImpl().getInstance();

    @Override
    public void cargarHistorial(Usuario usuario) {
        try {
            Usuario user = (Usuario) usuario;
            historialServicio.cargarHistorial(usuario); //Llama a servicio y muetsra
        } catch (BaseDeDatosException ex) {
            throw new PruebaModelException(ex.getMessage(), ex.getCause());
        }
    }
}
