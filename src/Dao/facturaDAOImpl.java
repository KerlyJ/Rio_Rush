package Dao;

import Factory.conexion;
import Factory.FactoryConexion;
import Model.factura;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class facturaDAOImpl implements facturaDAO {
    conexion conn;

    public facturaDAOImpl() {
    }

    @Override
    public List<factura> list() {      // listado 
        this.conn = FactoryConexion.open(FactoryConexion.PGSQL); //inicializa conexion por defecto a PgSql

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM factura");  //construye la cadena de consulta
        
        List<factura> list = new ArrayList<>(); //list es la lista de facturas
        
        try{
            ResultSet rs = this.conn.query(sql.toString());  //ejecuta la consulta
            while (rs.next()){  //mientras haya registros en la tabla
                factura factura = new factura();  //variable factura de tipofacturao recibe un nuevo objeto factura
                factura.setId_factura(rs.getInt("Id_factura"));
                factura.setPrecio_final(rs.getInt("Precio_final"));
                factura.setCantidad(rs.getInt("Cantidad"));
                list.add(factura);  //añade el objeto temporal en la lista
            }
        } catch (Exception e) {
            
        } finally {
            this.conn.close();      //cierra la conexion
        }
        return list;    //devuelve la lista generada
    }  

    @Override
    public factura edit(int id) {
        this.conn = FactoryConexion.open(FactoryConexion.PGSQL);
        factura factura = new factura();        //declarar objeto factura que pertenece a clase factura
        
        StringBuilder sql = new StringBuilder();    //para almacenar la consulta e efectuar en la bd
        sql.append("SELECT * FROM factura WHERE factura = ").append(id);   //cadena de consulta
        
        try {
            ResultSet rs = this.conn.query(sql.toString());  //carga todos los registros que cumplen con la condicion del sql

            while (rs.next()){          //mientras haya registros cargados en el reseltset
                factura.setId_factura(rs.getInt("Id_factura"));
                factura.setPrecio_final(rs.getInt("Precio_final"));
                factura.setCantidad(rs.getInt("Cantidad"));
            }
        } catch (Exception e) {
            
        } finally {
            this.conn.close();          //cierra la conexion
        }
        return factura;             //devuelve el objeto creado
    }

    @Override
    public boolean save(factura factura) {
        this.conn = FactoryConexion.open(FactoryConexion.PGSQL);   
        boolean save = true;        //bandera para indicar si se almacenaron los cambios
        
        try {
            if (factura.getId_factura() == 0) {  //es cero cuando se esta ingresando un registro nuevo: ver inicializacion del atributo 
                StringBuilder sql = new StringBuilder();   //para crear la sentencia sql
                sql.append("INSERT INTO direccion (Precio_final, Cantidad ) VALUES ('").append(factura.getPrecio_final());
                sql.append("', '").append(factura.getCantidad());      //crear la cadena de conexion
                this.conn.execute(sql.toString());      //ejecuta la query
            } else {   //es un registro previamente existente: estamos actualizando
                StringBuilder sql = new StringBuilder();   //para crear la sentencia sql
                sql.append("UPDATE factura SET Precio_final = ").append(factura.getPrecio_final());
                sql.append(", Cantidad = ").append(factura.getCantidad());      //crear la cadena de conexion
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

        this.conn = FactoryConexion.open(FactoryConexion.PGSQL);    
        try{
            StringBuilder sql = new StringBuilder();   //para crear la sentencia sql
            sql.append("DELETE FROM direccion WHERE Id_factura = ").append(id);    //crea la sentencia de borrado
            this.conn.execute(sql.toString());              //ejecuta sentencia sql
            delete = true;
        } catch (Exception e) {
            
        } finally {
            this.conn.close();                  //cierra la conexion
        }
        return delete;                              //devuelve el valor de la bandera
    }
}