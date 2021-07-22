package Dao;
import Model.repartidor;
import java.util.List;

public interface repartidorDao {
    public List<repartidor> list();    //prototipo metodo listar desde mysql
    public repartidor edit(String cedula);    //prototipo metodo editar desde mysql
    public boolean save (repartidor Repartidor);   //prototipo metodo guardar en mysql
    public boolean delete(String cedula);      //prototipo metodo borrar desde mysql
}