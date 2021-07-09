package Dao;
import  model.producto;
import java.util.List;
public interface productoDAO {
    public List<producto> list ();
    public producto edit (int id);
    public boolean save (producto producto);
    public boolean delete (int id);

}