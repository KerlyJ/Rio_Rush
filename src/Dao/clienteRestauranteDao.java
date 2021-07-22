package Dao;
import Model.clienteRestaurante;
import java.util.List;

public interface clienteRestauranteDao {
    public List<clienteRestaurante> list();   
    public clienteRestaurante edit(String ruc);    
    public boolean save (clienteRestaurante cliente);  
    public boolean delete(String ruc);  
}