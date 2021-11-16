package prueba.logica.servicios.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import prueba.exeptions.BaseDeDatosException;
import prueba.logica.entidades.Categoria;
import prueba.logica.servicios.CategoriaServicio;
import prueba.persistencia.ConexionBD;

public class CategoriaServicioImpl implements CategoriaServicio {
    
    //====================== CONSULTAS PARA LA BASE DE DATOS =================//
    private final String todasLasCategorias = "SELECT * FROM categoria"; 
    private final String categoriaAleatoria = "SELECT IdCategoria FROM categoria ORDER BY RAND() LIMIT 1";
    //====================== CONSULTAS PARA LA BASE DE DATOS =================//
    private static CategoriaServicioImpl servicioCategoria;

    private ConexionBD conexion = new ConexionBD(); //OBTENER LA CONEXION A LA BASE DE DATOS

    public CategoriaServicioImpl() {
    }

//========== OBTENER LA INSTANCIA DE LA CLASE MEDIANTE UN GETTER =========//
    public CategoriaServicioImpl getInstance() {
        if (null == servicioCategoria) {
           servicioCategoria = new CategoriaServicioImpl();
        }
        return servicioCategoria;
    }
//========== OBTENER LA INSTANCIA DE LA CLASE MEDIANTE UN GETTER =========//
    
    //================== OBTENER LA LISTA DE TODOS LOS USUARIOS ==============//
    @Override
    public List<Categoria> getTodasLasCategorias() {
        List<Categoria> categoria = new ArrayList<>();
        try {
            PreparedStatement sentencia = conexion.getConexion().prepareStatement(todasLasCategorias);
            ResultSet rs = sentencia.executeQuery();
            while (rs.next()) {
                categoria.add(categoriaMapper(rs));
            }
        } catch (SQLException e) {
            throw new BaseDeDatosException(e.getMessage(), e.getCause());
        }
        return categoria;
    }
    //================== OBTENER LA LISTA DE TODOS LOS USUARIOS ==============//
    
    @Override
    public Categoria getCategoriaAleatoria() {
        try {
            PreparedStatement sentencia = conexion.getConexion().prepareStatement(categoriaAleatoria);
            ResultSet rs = sentencia.executeQuery();
            while (rs.next()) {
                return categoriaMapper(rs);
            }
            return null;
        } catch (SQLException ex) {
            throw new BaseDeDatosException(ex.getMessage(), ex.getCause());
        }
    }
    
    private Categoria categoriaMapper(ResultSet rs) throws SQLException {
        return new Categoria(rs.getLong("IdCategoria"));
    
    }
    
}
