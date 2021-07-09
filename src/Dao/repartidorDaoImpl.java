package Dao;

import datalayer.conexion;
import model.repartidor;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class repartidorDaoImpl implements repartidorDao {
    conexion conn;

    public repartidorDaoImpl() {
    }

    @Override
    public List<repartidor> list() {
        // conexion con = new conexion();
        conn.open();

        final StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM repartidor");

        final List<repartidor> list = new ArrayList<>();
        try {
            final ResultSet rs = this.conn.query(sql.toString()); // ejecuta la consulta
            while (rs.next()) {
                final repartidor repartidor = new repartidor();
                repartidor.setCedula_repartidor(rs.getString("Cedula_repartidor"));
                repartidor.setNombre_repartidor(rs.getString("Nombre_repartidor"));
                repartidor.setApellido_repartidor(rs.getString("Apellido_repartidor"));
                repartidor.setTelefono_repartidor(rs.getString("Telefono_repartidor"));
                repartidor.setCorreo_electronico_repartidor(rs.getString("Correo_electronico_repartidor"));
                repartidor.setPlaca_vehiculo(rs.getString("Placa_vehiculo"));
                repartidor.setTipo_vehiculo(rs.getString("Tipo_vehiculo"));
                repartidor.setCalificacion(rs.getInt("Calificacion"));
                list.add(repartidor);
            }
        } catch (final Exception e) {
        } finally {
            this.conn.close();
        }
        return list;
    }

    @Override
    public repartidor edit(final String cedula) {
        conn.open();
        final repartidor repartidor = new repartidor(); // declarar objeto cuentabanco que pertenece a clase cuentabanco

        final StringBuilder sql = new StringBuilder(); // para almacenar la consulta e efectuar en la bd
        sql.append("SELECT * FROM repartidor WHERE Cedula_repartidor = ").append(cedula); // cadena de consulta

        try {
            final ResultSet rs = this.conn.query(sql.toString()); // carga todos los registros que cumplen con la
                                                                  // condicion del sql

            while (rs.next()) { // mientras haya registros cargados en el reseltset
                repartidor.setCedula_repartidor(rs.getString("Cedula_repartidor"));
                repartidor.setNombre_repartidor(rs.getString("Nombre_repartidor"));
                repartidor.setApellido_repartidor(rs.getString("Apellido_repartidor"));
                repartidor.setTelefono_repartidor(rs.getString("Telefono_repartidor"));
                repartidor.setCorreo_electronico_repartidor(rs.getString("Correo_electronico_repartidor"));
                repartidor.setPlaca_vehiculo(rs.getString("Placa_vehiculo"));
                repartidor.setTipo_vehiculo(rs.getString("Tipo_vehiculo"));
                repartidor.setCalificacion(rs.getInt("Calificacion"));
            }
        } catch (final Exception e) {

        } finally {
            this.conn.close(); // cierra la conexion
        }
        return repartidor; // devuelve el objeto creado
    }

    @Override
    public boolean save(final repartidor repartidor) {
        conn.open(); // abrir la conexion con bd mysql
        boolean save = true; // bandera para indicar si se almacenaron los cambios

        try {
            if (repartidor.getCedula_repartidor() == "") { // es cero cuando se esta ingresando un registro nuevo: ver
                                                           // inicializac'on del atributo
                final StringBuilder sql = new StringBuilder(); // para crear la sentencia sql
                sql.append(
                        "INSERT INTO repartidor (Nombre_repartidor, Apellido_repartidor, Telefono_repartidor, Correo_electronico_repartidor, Placa_vehiculo, Tipo_vehiculo, Calificacion) VALUES ('")
                        .append(repartidor.getNombre_repartidor());
                sql.append("', '").append(repartidor.getApellido_repartidor()); // crear la cadena de conexion
                sql.append("', '").append(repartidor.getTelefono_repartidor()); // crear la cadena de conexion
                sql.append("', '").append(repartidor.getCorreo_electronico_repartidor());
                sql.append("', '").append(repartidor.getPlaca_vehiculo());
                sql.append("', '").append(repartidor.getTipo_vehiculo());
                sql.append("', '").append(repartidor.getCalificacion()).append("')"); // crear la cadena de conexion
                this.conn.execute(sql.toString()); // ejecuta la query
            } else { // es un registro previamente existente: estamos actualizando
                final StringBuilder sql = new StringBuilder(); // para crear la sentencia sql
                sql.append("UPDATE repartidor SET Nombre_repartidor = ").append(repartidor.getNombre_repartidor());
                sql.append(", Apellido_repartidor = ").append(repartidor.getApellido_repartidor()); // crear la cadena
                                                                                                    // de conexion
                sql.append(", Telefono_repartidor = ").append(repartidor.getTelefono_repartidor()); // crear la cadena
                                                                                                    // de conexion
                sql.append(", Correo_electronico_repartidor = '").append(repartidor.getCorreo_electronico_repartidor());
                sql.append(", Placa_vehiculo = '").append(repartidor.getPlaca_vehiculo());
                sql.append(", Tipo_vehiculo = '").append(repartidor.getTipo_vehiculo());
                sql.append(", Calificacion = '").append(repartidor.getCalificacion())
                        .append("' WHERE Cedula_repartidor = ").append(repartidor.getCedula_repartidor()); // crear la
                                                                                                           // cadena de
                                                                                                           // conexion
                this.conn.execute(sql.toString()); // ejecuta la query
            }
            save = true; // cambia estado de bandera
        } catch (final Exception e) {

        } finally {
            this.conn.close(); // cerrar la conexion
        }
        return save;
    }

    @Override
    public boolean delete(final String cedula) {
        boolean delete = false; // bandera que indica resultado de operacion

        conn.open(); // abrir la conexion con bd mysql
        try {
            final StringBuilder sql = new StringBuilder(); // para crear la sentencia sql
            sql.append("DELETE FROM repartidor WHERE Cedula_repartidor = ").append(cedula); // crea la sentencia de
                                                                                            // borrado
            this.conn.execute(sql.toString()); // ejecuta sentencia sql
            delete = true;
        } catch (final Exception e) {
            
        } finally {
            this.conn.close();                  //cierra la conexion
        }
        return delete;                              //devuelve el valor de la bandera
    }
}