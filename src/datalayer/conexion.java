package datalayer;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class conexion {  //clase abstracta para cadenas de conexion a distintas bd
   protected String[] params;
   protected Connection connection;  //objeto de conexion
   
   abstract Connection open();    //metodo abstracto para devolver la conexión creada
   
   public ResultSet query(String query){ //metodo para recibir un query y ejecutar
       Statement st;        //objeto para ejecutar las querys
       ResultSet rs = null;  //tabla para contener los datos que se generen. Incia con Null
       
       try{
           st = connection.createStatement();
           rs = st.executeQuery(query);     //ejecutar la query
       } catch (SQLException e){
           e.printStackTrace();
       }
       return rs;           //devuelve el resultSet
   }
   
   public boolean execute(String query){ //metodo para ejecutar query
       Statement st;        //objeto para ejecutar las querys
       boolean save = true;  //bandera indicadora de exito en la ejecución
       
       try{
           st = connection.createStatement();
           st.executeUpdate(query);     //ejecutar la query
       } catch (SQLException e){
           save = false;
           e.printStackTrace();
       }
       return save;           //devuelve bandera
   }
   
   public boolean close(){     //metodo para cerrar la conexion
       boolean ok = true;
       
       try{
           connection.close();  //cierra la conexion
       } catch (Exception e) {
           ok = false;          //cambia bandera
           e.printStackTrace(); //error
       }
       return ok;           //devuelve bandera indicadora de cierre bd
   }
}