package prueba.logica.servicios;

import java.util.List;
import prueba.logica.entidades.Categoria;

public interface CategoriaServicio {
    
    public List<Categoria> getTodasLasCategorias();
    
    public Categoria getCategoriaAleatoria();

}
