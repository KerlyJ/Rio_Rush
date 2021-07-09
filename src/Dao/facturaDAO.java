package Dao;
import Model.factura;
import java.util.List;

public interface facturaDAO {
    public List<factura> list();    //prototipo metodo listar
    public factura edit(int id);    //prototipo metodo editar 
    public boolean save (factura Factura);   //prototipo metodo guardar 
    public boolean delete(int id);      //prototipo metodo borrar 
}
