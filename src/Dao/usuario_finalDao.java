package Dao;
import model.usuario_final;
import java.util.List;

public interface usuario_finalDao {
    public List<usuario_final> list();    //prototipo metodo listar desde mysql
    public usuario_final edit(String cedula);    //prototipo metodo editar desde mysql
    public boolean save (usuario_final usuariofinal);   //prototipo metodo guardar en mysql
    public boolean delete(String cedula);      //prototipo metodo borrar desde mysql
}