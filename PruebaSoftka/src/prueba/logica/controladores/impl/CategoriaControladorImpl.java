package prueba.logica.controladores.impl;

import java.util.List;
import prueba.exeptions.BaseDeDatosException;
import prueba.exeptions.PruebaModelException;
import prueba.logica.controladores.CategoriaControlador;
import prueba.logica.entidades.Categoria;
import prueba.logica.servicios.CategoriaServicio;
import prueba.logica.servicios.impl.CategoriaServicioImpl;

public class CategoriaControladorImpl implements CategoriaControlador {

    private static CategoriaControladorImpl instance;

    public CategoriaControladorImpl() {
    }

    //Obtener la instancia
    public CategoriaControladorImpl getInstance() {
        if (null == instance) {
            instance = new CategoriaControladorImpl();
        }
        return instance;
    }

    //Obtener instancia de servicio usuario
    private final CategoriaServicio categoriaServicio = new CategoriaServicioImpl().getInstance();
    
    @Override
    public List<Categoria> getTodasLasCategorias() {
        try {
            return categoriaServicio.getTodasLasCategorias();
        } catch (BaseDeDatosException ex) {
            throw new PruebaModelException(String.format("Error en base de datos [%s]", ex.getMessage()));
        }
    }
    
    public Categoria getCategoriaAleatoria(){
        try {
            return categoriaServicio.getCategoriaAleatoria();
        } catch (BaseDeDatosException ex) {
            throw new PruebaModelException(String.format("Error en base de datos [%s]", ex.getMessage()));
        }
        
    }


}
