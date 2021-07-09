package model;

public class repartidor{
    private String Cedula_repartidor;
    private String Nombre_repartidor;
    private String Apellido_repartidor;
    private String Telefono_repartidor;
    private String Correo_electronico_repartidor;
    private String Placa_vehiculo;
    private String Tipo_vehiculo;
    private int Calificacion;

    public repartidor(){
    }

    public repartidor(String cedula_repartidor, String nombre_repartidor, String apellido_repartidor, 
                        String telefono_repartidor, String correo_electronico_repartidor, String placa_vehiculo,
                        String tipo_vehiculo, int calificacion){
        Cedula_repartidor = cedula_repartidor;
        Nombre_repartidor = nombre_repartidor;
        Apellido_repartidor = apellido_repartidor;
        Telefono_repartidor = telefono_repartidor;
        Correo_electronico_repartidor = correo_electronico_repartidor;
        Placa_vehiculo = placa_vehiculo;
        Tipo_vehiculo = tipo_vehiculo;
        Calificacion = calificacion;
    }

    public String getCedula_repartidor() {
        return Cedula_repartidor;
    }

    public void setCedula_repartidor(String cedula_repartidor) {
        Cedula_repartidor = cedula_repartidor;
    }

    public String getNombre_repartidor() {
        return Nombre_repartidor;
    }

    public void setNombre_repartidor(String nombre_repartidor) {
        Nombre_repartidor = nombre_repartidor;
    }

    public String getApellido_repartidor() {
        return Apellido_repartidor;
    }

    public void setApellido_repartidor(String apellido_repartidor) {
        Apellido_repartidor = apellido_repartidor;
    }

    public String getTelefono_repartidor() {
        return Telefono_repartidor;
    }

    public void setTelefono_repartidor(String telefono_repartidor) {
        Telefono_repartidor = telefono_repartidor;
    }

    public String getCorreo_electronico_repartidor() {
        return Correo_electronico_repartidor;
    }

    public void setCorreo_electronico_repartidor(String correo_electronico_repartidor) {
        Correo_electronico_repartidor = correo_electronico_repartidor;
    }

    public String getPlaca_vehiculo() {
        return Placa_vehiculo;
    }

    public void setPlaca_vehiculo(String placa_vehiculo) {
        Placa_vehiculo = placa_vehiculo;
    }

    public String getTipo_vehiculo() {
        return Tipo_vehiculo;
    }

    public void setTipo_vehiculo(String tipo_vehiculo) {
        Tipo_vehiculo = tipo_vehiculo;
    }

    public int getCalificacion() {
        return Calificacion;
    }

    public void setCalificacion(int calificacion) {
        Calificacion = calificacion;
    }
}