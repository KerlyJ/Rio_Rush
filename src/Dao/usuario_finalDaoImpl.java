package Dao;

import datalayer.conexion;
import Model.usuario_final;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class usuario_finalDaoImpl implements usuario_finalDao{
    conexion conn;
    
    public usuario_finalDaoImpl(){
    }

    @Override
    public List<usuario_final> list(){
        //conexion con = new conexion();
        conn.open();

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM usuario_final");

        List<usuario_final> list = new ArrayList<>();
        try{
            ResultSet rs = this.conn.query(sql.toString());  //ejecuta la consulta
            while (rs.next()){
                usuario_final usuario_final = new usuario_final();
                usuario_final.setCedula_usuario(rs.getString("Cedula_usuario"));
                usuario_final.setId_direccion(rs.getInt("Id_direccion"));
                usuario_final.setNombre_usuario(rs.getString("Nombre_usuario"));
                usuario_final.setApellido_usuario(rs.getString("Apellido_usuario"));
                usuario_final.setTelefono_usuario(rs.getString("Telefono_usuario"));
                usuario_final.setCorreo_electronico_usuario(rs.getString("Correo_electronico_usuario"));
                list.add(usuario_final);
            }
        }catch(Exception e){
        }finally{
            this.conn.close();
        }
        return list;
    }

    @Override
    public usuario_final edit(String cedula) {
        conn.open();
        usuario_final usuario_final = new usuario_final();        //declarar objeto cuentabanco que pertenece a clase cuentabanco
        
        StringBuilder sql = new StringBuilder();    //para almacenar la consulta e efectuar en la bd
        sql.append("SELECT * FROM usuario_final WHERE Cedula_usuario = ").append(cedula);   //cadena de consulta
        
        try {
            ResultSet rs = this.conn.query(sql.toString());  //carga todos los registros que cumplen con la condicion del sql

            while (rs.next()){          //mientras haya registros cargados en el reseltset
                usuario_final.setCedula_usuario(rs.getString("Cedula_usuario"));
                usuario_final.setId_direccion(rs.getInt("Id_direccion"));
                usuario_final.setNombre_usuario(rs.getString("Nombre_usuario"));
                usuario_final.setApellido_usuario(rs.getString("Apellido_usuario"));
                usuario_final.setTelefono_usuario(rs.getString("Telefono_usuario"));
                usuario_final.setCorreo_electronico_usuario(rs.getString("Correo_electronico_usuario"));
            }
        } catch (Exception e) {
            
        } finally {
            this.conn.close();          //cierra la conexion
        }
        return usuario_final;             //devuelve el objeto creado
    }

    @Override
    public boolean save(usuario_final usuario_final) {
        conn.open();   //abrir la conexion con bd mysql
        boolean save = true;        //bandera para indicar si se almacenaron los cambios
        
        try {
            if (usuario_final.getCedula_usuario() == "") {  //es cero cuando se esta ingresando un registro nuevo: ver inicializac'on del atributo 
                StringBuilder sql = new StringBuilder();   //para crear la sentencia sql
                sql.append("INSERT INTO usuario_final (Id_direccion, Nombre_usuario, Apellido_usuario, Telefono_usuario, Correo_electronico_usuario) VALUES ('").append(usuario_final.getNombre_usuario());
                sql.append("', '").append(usuario_final.getId_direccion());      //crear la cadena de conexion
                sql.append("', '").append(usuario_final.getApellido_usuario());      //crear la cadena de conexion
                sql.append("', '").append(usuario_final.getTelefono_usuario());
                sql.append("', '").append(usuario_final.getCorreo_electronico_usuario()).append("')");      //crear la cadena de conexion
                this.conn.execute(sql.toString());      //ejecuta la query
            } else {   //es un registro previamente existente: estamos actualizando
                StringBuilder sql = new StringBuilder();   //para crear la sentencia sql
                sql.append("UPDATE usuario_final SET Nombre_usuario = ").append(usuario_final.getNombre_usuario());
                sql.append(", Id_direccion = ").append(usuario_final.getId_direccion());      //crear la cadena de conexion
                sql.append(", Apellido_usuario = ").append(usuario_final.getApellido_usuario());      //crear la cadena de conexion
                sql.append(", Telefono_usuario = '").append(usuario_final.getTelefono_usuario());
                sql.append(", Correo_electronico_usuario = '").append(usuario_final.getCorreo_electronico_usuario()).append("' WHERE Cedula_usuario = ").append(usuario_final.getCedula_usuario());      //crear la cadena de conexion
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

        conn.open();    //abrir la conexion con bd mysql
        try{
            StringBuilder sql = new StringBuilder();   //para crear la sentencia sql
            sql.append("DELETE FROM usuario_final WHERE Cedula_usuario = ").append(cedula);    //crea la sentencia de borrado
            this.conn.execute(sql.toString());              //ejecuta sentencia sql
            delete = true;
        } catch (Exception e) {
            
        } finally {
            this.conn.close();                  //cierra la conexion
        }
        return delete;                              //devuelve el valor de la bandera
    }
}