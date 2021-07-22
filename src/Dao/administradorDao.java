package Dao;
import Model.administrador;
import java.util.List;
public interface administradorDao {
    public List<administrador> list();   
    public administrador edit(String cedula);    
    public boolean save (administrador admin);  
    public boolean delete(String cedula);  
}