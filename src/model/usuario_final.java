package Model;

public class usuario_final{
    private String Cedula_usuario;
    private int Id_direccion;
    private String Nombre_usuario;
    private String Apellido_usuario;
    private String Telefono_usuario;
    private String Correo_electronico_usuario;

    public usuario_final(){
    }

    public usuario_final(String cedula_usuario, int id_direccion, String nombre_usuario, 
                        String apellido_usuario, String telefono_usuario, String correo_electronico_usuario){
        cedula_usuario = Cedula_usuario;
        id_direccion = Id_direccion;
        nombre_usuario = Nombre_usuario;
        apellido_usuario = Apellido_usuario;
        telefono_usuario = Telefono_usuario;
        correo_electronico_usuario = Correo_electronico_usuario;
    }

    public String getCedula_usuario() {
        return Cedula_usuario;
    }

    public void setCedula_usuario(String cedula_usuario) {
        Cedula_usuario = cedula_usuario;
    }

    public int getId_direccion() {
        return Id_direccion;
    }

    public void setId_direccion(int id_direccion) {
        Id_direccion = id_direccion;
    }

    public String getNombre_usuario() {
        return Nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        Nombre_usuario = nombre_usuario;
    }

    public String getApellido_usuario() {
        return Apellido_usuario;
    }

    public void setApellido_usuario(String apellido_usuario) {
        Apellido_usuario = apellido_usuario;
    }

    public String getTelefono_usuario() {
        return Telefono_usuario;
    }

    public void setTelefono_usuario(String telefono_usuario) {
        Telefono_usuario = telefono_usuario;
    }

    public String getCorreo_electronico_usuario() {
        return Correo_electronico_usuario;
    }

    public void setCorreo_electronico_usuario(String correo_electronico_usuario) {
        Correo_electronico_usuario = correo_electronico_usuario;
    }
}