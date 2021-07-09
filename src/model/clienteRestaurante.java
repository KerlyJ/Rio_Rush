package Model;

public class clienteRestaurante {
    private String RUC;
    private String Nombre_restaurante;
    private String Propietario;
    private String Direccion_restaurante;
    private String Telefono_restaurante;
    private String Correo_electronico_restaurante;
    private int Calificacion;

    public clienteRestaurante(){

    }

    public clienteRestaurante(String ruc, String nombre_restaurante, String propietario, String direccion_restaurante,
    String telefono_restaurante, String correo_electronico_restaurante, int calificacion){
        RUC=ruc;
        Nombre_restaurante = nombre_restaurante;
        Propietario = propietario;
        Direccion_restaurante = direccion_restaurante;
        Telefono_restaurante = telefono_restaurante ;
        Correo_electronico_restaurante = correo_electronico_restaurante;
        Calificacion = calificacion;
    }

    public String getRUC() {
        return RUC;
    }

    public void setRUC(String rUC) {
        RUC = rUC;
    }

    public String getNombre_restaurante() {
        return Nombre_restaurante;
    }

    public void setNombre_restaurante(String nombre_restaurante) {
        Nombre_restaurante = nombre_restaurante;
    }

    public String getPropietario() {
        return Propietario;
    }

    public void setPropietario(String propietario) {
        Propietario = propietario;
    }

    public String getDireccion_restaurante() {
        return Direccion_restaurante;
    }

    public void setDireccion_restaurante(String direccion_restaurante) {
        Direccion_restaurante = direccion_restaurante;
    }

    public String getTelefono_restaurante() {
        return Telefono_restaurante;
    }

    public void setTelefono_restaurante(String telefono_restaurante) {
        Telefono_restaurante = telefono_restaurante;
    }

    public String getCorreo_electronico_restaurante() {
        return Correo_electronico_restaurante;
    }

    public void setCorreo_electronico_restaurante(String correo_electronico_restaurante) {
        Correo_electronico_restaurante = correo_electronico_restaurante;
    }

    public int getCalificacion() {
        return Calificacion;
    }

    public void setCalificacion(int calificacion) {
        Calificacion = calificacion;
    }
    
}
