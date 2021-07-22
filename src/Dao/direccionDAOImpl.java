package Dao;
import Factory.conexion;
import Factory.FactoryConexion;
import Model.direccion;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class direccionDAOImpl implements direccionDAO {
    conexion conn;

    public direccionDAOImpl() {
    }

    @Override
    public List<direccion> list() {      // listado desde la bd mysql
        this.conn = FactoryConexion.open(FactoryConexion.PGSQL); //inicializa conexion por defecto a PgSql

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM cuentaBancaria");  //construye la cadena de consulta
        
        List<direccion> list = new ArrayList<>(); //list es la lista de cuentas bancarias
        
        try{
            ResultSet rs = this.conn.query(sql.toString());  //ejecuta la consulta
            while (rs.next()){  //mientras haya registros en la tabla
                direccion direccion = new direccion();  //variable cuentabanco de tipo cuentabanco recibe un nuevo objeto cuentabanco
                direccion.setId_direccion(rs.getInt("Id_direccion"));
                direccion.setCalle_principal(rs.getString("Calle_principal"));
                direccion.setCalle_secundaria(rs.getString("Calle_secundaria"));
                direccion.setNumero_casa(rs.getString("Numero_casa"));
                direccion.setParroquia(rs.getString("Parroquia"));
                direccion.setReferencia(rs.getString("Referencia"));
                list.add(direccion);  //añade el objeto temporal en la lista
            }
        } catch (Exception e) {
            
        } finally {
            this.conn.close();      //cierra la conexion
        }
        return list;    //devuelve la lista generada
    }  

    @Override
    public direccion edit(int id) {
        this.conn = FactoryConexion.open(FactoryConexion.PGSQL);
        direccion direccion = new direccion();        //declarar objeto cuentabanco que pertenece a clase cuentabanco
        
        StringBuilder sql = new StringBuilder();    //para almacenar la consulta e efectuar en la bd
        sql.append("SELECT * FROM cuentaBancaria WHERE IdCuentaBancaria = ").append(id);   //cadena de consulta
        
        try {
            ResultSet rs = this.conn.query(sql.toString());  //carga todos los registros que cumplen con la condicion del sql

            while (rs.next()){          //mientras haya registros cargados en el reseltset
                direccion.setId_direccion(rs.getInt("Id_direccion"));
                direccion.setCalle_principal(rs.getString("Calle_principal"));
                direccion.setCalle_secundaria(rs.getString("Calle_secundaria"));
                direccion.setNumero_casa(rs.getString("Numero_casa"));
                direccion.setParroquia(rs.getString("Parroquia"));
                direccion.setReferencia(rs.getString("Referencia"));
            }
        } catch (Exception e) {
            
        } finally {
            this.conn.close();          //cierra la conexion
        }
        return direccion;             //devuelve el objeto creado
    }

    @Override
    public boolean save(direccion direccion) {
        this.conn = FactoryConexion.open(FactoryConexion.PGSQL);    //abrir la conexion con bd mysql
        boolean save = true;        //bandera para indicar si se almacenaron los cambios
        
        try {
            if (direccion.getId_direccion() == 0) {  //es cero cuando se esta ingresando un registro nuevo: ver inicializac'on del atributo 
                StringBuilder sql = new StringBuilder();   //para crear la sentencia sql
                sql.append("INSERT INTO direccion (Calle_princial, Calle_secundaria, Numero_casa, Parroquia, Referencia) VALUES ('").append(direccion.getCalle_principal());
                sql.append("', '").append(direccion.getCalle_secundaria());      //crear la cadena de conexion
                sql.append("', '").append(direccion.getNumero_casa());      //crear la cadena de conexion
                sql.append("', '").append(direccion.getParroquia());      //crear la cadena de conexion
                sql.append("', '").append(direccion.getReferencia()).append("')");      //crear la cadena de conexion
                this.conn.execute(sql.toString());      //ejecuta la query
            } else {   //es un registro previamente existente: estamos actualizando
                StringBuilder sql = new StringBuilder();   //para crear la sentencia sql
                sql.append("UPDATE direccion SET Calle_principal = ").append(direccion.getCalle_principal());
                sql.append(", Calle_secundaria = ").append(direccion.getCalle_secundaria());      //crear la cadena de conexion
                sql.append(", Numero_casa = ").append(direccion.getNumero_casa());      //crear la cadena de conexion
                sql.append(", Parroquia = ").append(direccion.getParroquia());      //crear la cadena de conexion
                sql.append(", Referencia = '").append(direccion.getReferencia()).append("' WHERE Id_direccion = ").append(direccion.getId_direccion());      //crear la cadena de conexion
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
            sql.append("DELETE FROM direccion WHERE Id_direccion = ").append(id);    //crea la sentencia de borrado
            this.conn.execute(sql.toString());              //ejecuta sentencia sql
            delete = true;
        } catch (Exception e) {
            
        } finally {
            this.conn.close();                  //cierra la conexion
        }
        return delete;                              //devuelve el valor de la bandera
    }
}