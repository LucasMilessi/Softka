package prueba.logica.controladores;

import java.util.List;
import prueba.logica.entidades.Categoria;

public interface CategoriaControlador {
    
    List<Categoria> getTodasLasCategorias();
    
    public Categoria getCategoriaAleatoria();

}
