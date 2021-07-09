package Dao;
import model.pedido;
import java.util.List;

public interface pedidoDao {
    public List<pedido> list();    //prototipo metodo listar 
    public pedido edit(int id);    //prototipo metodo editar 
    public boolean save (pedido Pedido);   //prototipo metodo guardar 
    public boolean delete(int id);      //prototipo metodo borrar 
}
