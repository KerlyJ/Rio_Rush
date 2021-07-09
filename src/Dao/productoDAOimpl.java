package Dao;
import Factory.conexion;
import Factory.FactoryConexion;
import Model.Producto;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class productoDAOimpl implements productoDAO {
    conexion conn;

    public productoDAOimpl() {
    }

    @Override
    public List<Producto> list() {      // listado desde la bd mysql
        this.conn = FactoryConexion.open(FactoryConexion.PGSQL); //inicializa conexion por defecto a PgSql

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM producto");  //construye la cadena de consulta
        
        List<Producto> list = new ArrayList<>(); //list es la lista de cuentas bancarias
        
        try{
            ResultSet rs = this.conn.query(sql.toString());  //ejecuta la consulta
            while (rs.next()){  //mientras haya registros en la tabla
                Producto producto = new producto();  //variable cuentabanco de tipo cuentabanco recibe un nuevo objeto cuentabanco
                producto.setIdProducto(rs.getInt("id_producto"));
                producto.setRuc(rs.getString("ruc"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setPrecioUnitario(rs.getInt("precio_unitario"));
                list.add(producto);  //añade el objeto temporal en la lista
            }
        } catch (Exception e) {
            
        } finally {
            this.conn.close();      //cierra la conexion
        }
        return list;    //devuelve la lista generada
    }  

    @Override
    public Producto edit(int id) {
        this.conn = FactoryConexion.open(FactoryConexion.PGSQL);
        Producto producto = new producto();        //declarar objeto cuentabanco que pertenece a clase cuentabanco
        
        StringBuilder sql = new StringBuilder();    //para almacenar la consulta e efectuar en la bd
        sql.append("SELECT * FROM producto WHERE id_producto = ").append(id);   //cadena de consulta
        
        try {
            ResultSet rs = this.conn.query(sql.toString());  //carga todos los registros que cumplen con la condicion del sql

            while (rs.next()){          //mientras haya registros cargados en el reseltset
                producto.setIdProducto(rs.getInt("id_producto"));
                producto.setRuc(rs.getString("ruc"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setPrecioUnitario(rs.getInt("precio_unitario"));

            }
        } catch (Exception e) {
            
        } finally {
            this.conn.close();          //cierra la conexion
        }
        return producto;             //devuelve el objeto creado
    }

    @Override
    public boolean save(Producto producto) {
        this.conn = FactoryConexion.open(FactoryConexion.PGSQL);    //abrir la conexion con bd mysql
        boolean save = true;        //bandera para indicar si se almacenaron los cambios
        
        try {
            if (producto.getIdProducto() == 0) {  //es cero cuando se esta ingresando un registro nuevo: ver inicializac'on del atributo 
                StringBuilder sql = new StringBuilder();   //para crear la sentencia sql
                sql.append("INSERT INTO producto (id_producto,ruc, descripcion,precio_unitario) VALUES ('");
                sql.append("', '").append(producto.getRuc());      //crear la cadena de conexion
                sql.append("', '").append(producto.getDescripcion());      //crear la cadena de conexion
                sql.append("', '").append(producto.getPrecioUnitario());      //crear la cadena de conexion
                this.conn.execute(sql.toString());      //ejecuta la query
            } else {   //es un registro previamente existente: estamos actualizando
                StringBuilder sql = new StringBuilder();   //para crear la sentencia sql
                sql.append("UPDATE producto SET Calle_principal = ");
                sql.append(" ruc = ").append(producto.getRuc());      //crear la cadena de conexion
                sql.append(", descripcion = ").append(producto.getDescripcion());      //crear la cadena de conexion
                sql.append(", precio_unitario = ").append(producto.getPrecioUnitario()).append("' WHERE id_producto = ").append(producto.getIdProducto());      //crear la cadena de conexion
      //crear la cadena de conexion
                this.conn.execute(sql.toString());      //ejecuta la query
            }
            save = true;                                //cambia estado de bandera
        } catch(Exception e){
            
        } finally {
            this.conn.close();      //cerrar la conexion
        }
        return save; 
    }

    @Override
    public boolean delete(int id) {
        boolean delete = false;                     //bandera que indica resultado de operacion

        this.conn = FactoryConexion.open(FactoryConexion.PGSQL);    //abrir la conexion con bd mysql
        try{
            StringBuilder sql = new StringBuilder();   //para crear la sentencia sql
            sql.append("DELETE FROM producto WHERE Id_producto = ").append(id);    //crea la sentencia de borrado
            this.conn.execute(sql.toString());              //ejecuta sentencia sql
            delete = true;
        } catch (Exception e) {
            
        } finally {
            this.conn.close();                  //cierra la conexion
        }
        return delete;                              //devuelve el valor de la bandera
    }

    
}