package prueba.logica.entidades;

public class Categoria {

    private Long IdCategoria;
    private String Nombre;

    public Categoria() {
    }

    public Categoria(Long IdCategoria, String Nombre) {
        this.IdCategoria = IdCategoria;
        this.Nombre = Nombre;
    }

    public Categoria(Long IdCategoria) {
        this.IdCategoria = IdCategoria;
    }

    public void setIdCategoria(Long IdCategoria) {
        this.IdCategoria = IdCategoria;
    }

    public Long getIdCategoria() {
        return IdCategoria;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    @Override
    public String toString() {
        return String.format("%s", IdCategoria);
    }

}
