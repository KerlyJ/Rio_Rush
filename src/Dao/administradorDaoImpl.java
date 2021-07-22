package Dao;
import Model.administrador;
import Factory.FactoryConexion;
import Factory.conexion;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class administradorDaoImpl implements administradorDao{
    conexion conn;
    public administradorDaoImpl(){
    }

 @Override
 public List<administrador> list() {      // listado desde la bd mysql
    this.conn = FactoryConexion.open(FactoryConexion.PGSQL); //inicializa conexion por defecto a PgSql

    StringBuilder sql = new StringBuilder();
    sql.append("SELECT * FROM administrador");  //construye la cadena de consulta
    
    List<administrador> list = new ArrayList<>(); //list es la lista de cuentas bancarias
    
    try{
        ResultSet rs = this.conn.query(sql.toString());  //ejecuta la consulta
        while (rs.next()){  //mientras haya registros en la tabla
            administrador administrador = new administrador();  //variable cuentabanco de tipo cuentabanco recibe un nuevo objeto cuentabanco
            administrador.setCedula_admin(rs.getString("cedula_administrador"));
            administrador.setCedula_repartidor(rs.getString("cedula_repartidor"));
            administrador.setId_producto(rs.getInt("id_producto"));
            administrador.setRUC(rs.getString("ruc"));
            administrador.setNombre_admin(rs.getString("nombre_administrador"));
            administrador.setApellido_admin(rs.getString("apellido_administrador"));
            administrador.setTelefono_admin(rs.getString("telefono_administrador"));
            administrador.setCorreo_Electronico_Admin(rs.getString("corre_electronico_administrador"));
            list.add(administrador);  //añade el objeto temporal en la lista
        }
    } catch (Exception e) {
        
    } finally {
        this.conn.close();      //cierra la conexion
    }
    return list;    //devuelve la lista generada
}  

@Override
public administrador edit(String cedula) {
    this.conn = FactoryConexion.open(FactoryConexion.PGSQL);
    administrador administrador = new administrador();        //declarar objeto cuentabanco que pertenece a clase cuentabanco
    
    StringBuilder sql = new StringBuilder();    //para almacenar la consulta e efectuar en la bd
    sql.append("SELECT * FROM administrador WHERE cedula_administrador = ").append(cedula);   //cadena de consulta
    
    try {
        ResultSet rs = this.conn.query(sql.toString());  //carga todos los registros que cumplen con la condicion del sql

        while (rs.next()){          //mientras haya registros cargados en el reseltset
            administrador.setCedula_admin(rs.getString("cedula_administrador"));
            administrador.setCedula_repartidor(rs.getString("cedula_repartidor"));
            administrador.setId_producto(rs.getInt("id_producto"));
            administrador.setRUC(rs.getString("ruc"));
            administrador.setNombre_admin(rs.getString("nombre_administrador"));
            administrador.setApellido_admin(rs.getString("apellido_administrador"));
            administrador.setTelefono_admin(rs.getString("telefono_administrador"));
            administrador.setCorreo_Electronico_Admin(rs.getString("corre_electronico_administrador"));
        }
    } catch (Exception e) {
        
    } finally {
        this.conn.close();          //cierra la conexion
    }
    return administrador;             //devuelve el objeto creado
}

@Override
public boolean save(administrador administrador) {
    this.conn = FactoryConexion.open(FactoryConexion.PGSQL);    //abrir la conexion con bd mysql
    boolean save = true;        //bandera para indicar si se almacenaron los cambios
    
    try {
        if (administrador.getCedula_admin() == null) {  //es cero cuando se esta ingresando un registro nuevo: ver inicializac'on del atributo 
            StringBuilder sql = new StringBuilder();   //para crear la sentencia sql
            sql.append("INSERT INTO administrador (cedula_administrador, cedula_repartidor, id_producto, ruc, nombre_administrador, apellido_administrador, telefono_administrador, corre_electronico_administrador) VALUES ('").append(administrador.getCedula_admin());
            sql.append("', '").append(administrador.getCedula_admin());      //crear la cadena de conexion
            sql.append("', '").append(administrador.getCedula_repartidor());      //crear la cadena de conexion
            sql.append("', '").append(administrador.getId_producto());      //crear la cadena de conexion
            sql.append("', '").append(administrador.getRUC());      //crear la cadena de conexion
            sql.append("', '").append(administrador.getNombre_admin());      //crear la cadena de conexion
            sql.append("', '").append(administrador.getApellido_admin());      //crear la cadena de conexion
            sql.append("', '").append(administrador.getTelefono_admin());      //crear la cadena de conexion
            sql.append("', '").append(administrador.getCorreo_Electronico_Admin()).append("')");      //crear la cadena de conexion
            this.conn.execute(sql.toString());      //ejecuta la query
        } else {   //es un registro previamente existente: estamos actualizando
            StringBuilder sql = new StringBuilder();   //para crear la sentencia sql
            sql.append("UPDATE administrador SET nombre_administrador = ").append(administrador.getNombre_admin());
            sql.append("UPDATE administrador SET apellido_administrador = ").append(administrador.getApellido_admin());
            sql.append("UPDATE administrador SET telefono_administrador = ").append(administrador.getTelefono_admin());
            sql.append("UPDATE administrador SET corre_electronico_administrador = ").append(administrador.getCorreo_Electronico_Admin());
            sql.append(", cedula_administrador = ").append(administrador.getCedula_admin());      //crear la cadena de conexion
            sql.append(", cedula_repartidor = ").append(administrador.getCedula_repartidor());      //crear la cadena de conexion
            sql.append(", id_producto = ").append(administrador.getId_producto());      //crear la cadena de conexion
            sql.append(", ruc = '").append(administrador.getRUC()).append("' WHERE cedula_administrador = ").append(administrador.getCedula_admin());      //crear la cadena de conexion
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
public boolean delete(String cedula) {
    boolean delete = false;                     //bandera que indica resultado de operacion

    this.conn = FactoryConexion.open(FactoryConexion.PGSQL);    //abrir la conexion con bd mysql
    try{
        StringBuilder sql = new StringBuilder();   //para crear la sentencia sql
        sql.append("DELETE FROM administrador WHERE cedula_administrador = ").append(cedula);    //crea la sentencia de borrado
        this.conn.execute(sql.toString());              //ejecuta sentencia sql
        delete = true;
    } catch (Exception e) {
        
    } finally {
        this.conn.close();                  //cierra la conexion
    }
    return delete;                              //devuelve el valor de la bandera
}    

}