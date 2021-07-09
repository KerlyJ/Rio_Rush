package Dao;
import Model.direccion;
import java.util.List;

public interface direccionDAO {
    public List<direccion> list();    //prototipo metodo listar
    public direccion edit(int id);    //prototipo metodo editar 
    public boolean save (direccion Direccion);   //prototipo metodo guardar 
    public boolean delete(int id);      //prototipo metodo borrar 
}
