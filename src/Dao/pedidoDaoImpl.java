package Dao;

import Factory.conexion;
import Factory.FactoryConexion;
import model.pedido;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class pedidoDaoImpl implements pedidoDAO {
    conexion conn;

    public pedidoDaoImpl() {
    }

    @Override
    public List<pedido> list() { // listado desde la bd mysql
        this.conn = FactoryConexion.open(FactoryConexion.PGSQL); // inicializa conexion por defecto a PgSql

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM pedido"); // construye la cadena de consulta

        List<pedido> list = new ArrayList<>(); // list es la lista de cuentas bancarias

        try {
            ResultSet rs = this.conn.query(sql.toString()); // ejecuta la consulta
            while (rs.next()) { // mientras haya registros en la tabla
                pedido pedido = new pedido(); // variable cuentabanco de tipo cuentabanco recibe un nuevo objeto
                                              // cuentabanco
                pedido.setId_pedido(rs.getInt("Id_pedido"));
                pedido.setId_direccion(rs.getInt("Id_direccion"));
                pedido.setCedula_repartidor(rs.getString("Cedula_repartidor"));
                pedido.setCedula_usuario(rs.getString("Cedula_usuario"));
                pedido.setFecha(rs.getDate("Fecha"));
                pedido.setHora(rs.getTime("Hora"));
                list.add(pedido); // añade el objeto temporal en la lista
            }
        } catch (Exception e) {

        } finally {
            this.conn.close(); // cierra la conexion
        }
        return list; // devuelve la lista generada
    }

    @Override
    public pedido edit(int id) {
        this.conn = FactoryConexion.open(FactoryConexion.PGSQL);
        pedido pedido = new pedido(); // declarar objeto cuentabanco que pertenece a clase cuentabanco

        StringBuilder sql = new StringBuilder(); // para almacenar la consulta e efectuar en la bd
        sql.append("SELECT * FROM direccion WHERE Id_direccion = ").append(id); // cadena de consulta

        try {
            ResultSet rs = this.conn.query(sql.toString()); // carga todos los registros que cumplen con la condicion
                                                            // del sql

            while (rs.next()) { // mientras haya registros cargados en el reseltset
                pedido.setId_pedido(rs.getInt("Id_pedido"));
                pedido.setId_direccion(rs.getInt("Id_direccion"));
                pedido.setCedula_repartidor(rs.getString("Cedula_repartidor"));
                pedido.setCedula_usuario(rs.getString("Cedula_usuario"));
                pedido.setFecha(rs.getDate("Fecha"));
                pedido.setHora(rs.getTime("Hora"));
            }
        } catch (Exception e) {

        } finally {
            this.conn.close(); // cierra la conexion
        }
        return pedido; // devuelve el objeto creado
    }

    @Override
    public boolean save(pedido pedido) {
        this.conn = FactoryConexion.open(FactoryConexion.PGSQL); // abrir la conexion con bd mysql
        boolean save = true; // bandera para indicar si se almacenaron los cambios

        try {
            if (pedido.getId_pedido() == 0) { // es cero cuando se esta ingresando un registro nuevo: ver inicializac'on
                                              // del atributo
                StringBuilder sql = new StringBuilder(); // para crear la sentencia sql
                sql.append(
                        "INSERT INTO pedido (Id_pedido, Id_Direccion, Cedula_repartidor, Cedula_usuario, Fecha, Hora) VALUES ('")
                        .append(pedido.getId_pedido());
                sql.append("', '").append(pedido.getId_pedido()); // crear la cadena de conexion
                sql.append("', '").append(pedido.getId_direccion()); // crear la cadena de conexion
                sql.append("', '").append(pedido.getCedula_repartidor()); // crear la cadena de conexion
                sql.append("', '").append(pedido.getFecha());
                sql.append("', '").append(pedido.getHora()).append("')"); // crear la cadena de conexion
                this.conn.execute(sql.toString()); // ejecuta la query
            } else { // es un registro previamente existente: estamos actualizando
                StringBuilder sql = new StringBuilder(); // para crear la sentencia sql
                sql.append("Id_pedido = ").append(pedido.getId_pedido());
                sql.append(", Id_Direccion = ").append(pedido.getId_direccion()); // crear la cadena de conexion
                sql.append(", Cedula Repartidor = ").append(pedido.getCedula_repartidor()); // crear la cadena de
                                                                                            // conexion
                sql.append(", Cedula Usuario = ").append(pedido.getCedula_usuario()); // crear la cadena de conexion
                sql.append(", Fecha = ").append(pedido.getFecha());
                sql.append(", Hora = '").append(pedido.getHora()).append("' WHERE Id_pedido = ")
                        .append(pedido.getId_pedido()); // crear la cadena de conexion
                this.conn.execute(sql.toString()); // ejecuta la query
            }
            save = true; // cambia estado de bandera
        } catch (Exception e) {

        } finally {
            this.conn.close(); // cerrar la conexion
        }
        return save;
    }

    @Override
    public boolean delete(int id) {
        boolean delete = false; // bandera que indica resultado de operacion

        this.conn = FactoryConexion.open(FactoryConexion.PGSQL); // abrir la conexion con bd mysql
        try {
            StringBuilder sql = new StringBuilder(); // para crear la sentencia sql
            sql.append("DELETE FROM pedido WHERE Id_pedido = ").append(id); // crea la sentencia de borrado
            this.conn.execute(sql.toString()); // ejecuta sentencia sql
            delete = true;
        } catch (Exception e) {

        } finally {
            this.conn.close(); // cierra la conexion
        }
        return delete; // devuelve el valor de la bandera
    }
}
