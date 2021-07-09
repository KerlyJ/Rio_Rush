package Dao;
import Model.clienteRestaurante;
import Factory.FactoryConexion;

import Factory.conexion;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class clienteRestauranteDaoImpl implements clienteRestauranteDao {
    conexion conn;
    public clienteRestauranteDaoImpl(){
    }

 @Override
 public List<clienteRestaurante> list() {      // listado desde la bd mysql
    this.conn = FactoryConexion.open(FactoryConexion.PGSQL); //inicializa conexion por defecto a PgSql

    StringBuilder sql = new StringBuilder();
    sql.append("SELECT * FROM administrador");  //construye la cadena de consulta
    
    List<clienteRestaurante> list = new ArrayList<>(); //list es la lista de cuentas bancarias
    
    try{
        ResultSet rs = this.conn.query(sql.toString());  //ejecuta la consulta
        while (rs.next()){  //mientras haya registros en la tabla
            clienteRestaurante clienteRestaurante = new clienteRestaurante();  //variable cuentabanco de tipo cuentabanco recibe un nuevo objeto cuentabanco
            clienteRestaurante.setRUC(rs.getString("cedula_administrador"));
            clienteRestaurante.setNombre_restaurante(rs.getString("cedula_repartidor"));
            clienteRestaurante.setPropietario(rs.getString("id_producto"));
            clienteRestaurante.setDireccion_restaurante(rs.getString("ruc"));
            clienteRestaurante.setTelefono_restaurante(rs.getString("nombre_administrador"));
            clienteRestaurante.setCorreo_electronico_restaurante(rs.getString("apellido_administrador"));
            clienteRestaurante.setCalificacion(rs.getInt("telefono_administrador"));
            list.add(clienteRestaurante);  //añade el objeto temporal en la lista
        }
    } catch (Exception e) {
        
    } finally {
        this.conn.close();      //cierra la conexion
    }
    return list;    //devuelve la lista generada
}  

@Override
public clienteRestaurante edit(String ruc) {
    this.conn = FactoryConexion.open(FactoryConexion.PGSQL);
    clienteRestaurante clienteRestaurante = new clienteRestaurante();        //declarar objeto cuentabanco que pertenece a clase cuentabanco
    
    StringBuilder sql = new StringBuilder();    //para almacenar la consulta e efectuar en la bd
    sql.append("SELECT * FROM cliente_restaurante WHERE ruc = ").append(ruc);   //cadena de consulta
    
    try {
        ResultSet rs = this.conn.query(sql.toString());  //carga todos los registros que cumplen con la condicion del sql

        while (rs.next()){          //mientras haya registros cargados en el reseltset
            clienteRestaurante.setRUC(rs.getString("cedula_administrador"));
            clienteRestaurante.setNombre_restaurante(rs.getString("cedula_repartidor"));
            clienteRestaurante.setPropietario(rs.getString("propietario"));
            clienteRestaurante.setDireccion_restaurante(rs.getString("direccion_restaurante"));
            clienteRestaurante.setTelefono_restaurante(rs.getString("telefono_restaurante"));
            clienteRestaurante.setCorreo_electronico_restaurante(rs.getString("correo_electronico_restaurante"));
            clienteRestaurante.setCalificacion(rs.getInt("calificacion"));
            
        }
    } catch (Exception e) {
        
    } finally {
        this.conn.close();          //cierra la conexion
    }
    return clienteRestaurante;             //devuelve el objeto creado
}

@Override
public boolean save(clienteRestaurante clienteRestaurante) {
    this.conn = FactoryConexion.open(FactoryConexion.PGSQL);    //abrir la conexion con bd mysql
    boolean save = true;        //bandera para indicar si se almacenaron los cambios
    
    try {
        if (clienteRestaurante.getRUC() == null) {  //es cero cuando se esta ingresando un registro nuevo: ver inicializac'on del atributo 
            StringBuilder sql = new StringBuilder();   //para crear la sentencia sql
            sql.append("INSERT INTO cliente_restaurante (ruc, nombre_restaurante, propietario, direccion_restaurante, telefono_restaurante, correo_electronico_restaurante, calificacion) VALUES ('").append(clienteRestaurante.getRUC());
            sql.append("', '").append(clienteRestaurante.getRUC());      //crear la cadena de conexion
            sql.append("', '").append(clienteRestaurante.getNombre_restaurante());      //crear la cadena de conexion
            sql.append("', '").append(clienteRestaurante.getPropietario());      //crear la cadena de conexion
            sql.append("', '").append(clienteRestaurante.getDireccion_restaurante());      //crear la cadena de conexion
            sql.append("', '").append(clienteRestaurante.getTelefono_restaurante());      //crear la cadena de conexion
            sql.append("', '").append(clienteRestaurante.getCorreo_electronico_restaurante());      //crear la cadena de conexion
            sql.append("', '").append(clienteRestaurante.getCalificacion()).append("')");      //crear la cadena de conexion
            this.conn.execute(sql.toString());      //ejecuta la query
        } else {   //es un registro previamente existente: estamos actualizando
            StringBuilder sql = new StringBuilder();   //para crear la sentencia sql
            sql.append("UPDATE cliente_restaurante SET nombre_restaurante = ").append(clienteRestaurante.getNombre_restaurante());
            sql.append("UPDATE cliente_restaurante SET propietario = ").append(clienteRestaurante.getPropietario());
            sql.append("UPDATE cliente_restaurante SET direccion_restaurante = ").append(clienteRestaurante.getDireccion_restaurante());
            sql.append("UPDATE cliente_restaurante SET telefono_restaurante = ").append(clienteRestaurante.getTelefono_restaurante());
            sql.append("UPDATE cliente_restaurante SET correo_electronico_restaurante = ").append(clienteRestaurante.getCorreo_electronico_restaurante());
            sql.append(", ruc = ").append(clienteRestaurante.getRUC());      //crear la cadena de conexion
            sql.append(", calificacion = '").append(clienteRestaurante.getCalificacion()).append("' WHERE ruc = ").append(clienteRestaurante.getRUC());      //crear la cadena de conexion
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
public boolean delete(String ruc) {
    boolean delete = false;                     //bandera que indica resultado de operacion

    this.conn = FactoryConexion.open(FactoryConexion.PGSQL);    //abrir la conexion con bd mysql
    try{
        StringBuilder sql = new StringBuilder();   //para crear la sentencia sql
        sql.append("DELETE FROM cliente_restaurante WHERE ruc = ").append(ruc);    //crea la sentencia de borrado
        this.conn.execute(sql.toString());              //ejecuta sentencia sql
        delete = true;
    } catch (Exception e) {
        
    } finally {
        this.conn.close();                  //cierra la conexion
    }
    return delete;                              //devuelve el valor de la bandera
}    
}
