package Dao;
import  Model.Producto;
import java.util.List;
public interface productoDAO {
    public List<Producto> list ();
    public Producto edit (int id);
    public boolean save (Producto producto);
    public boolean delete (int id);

}