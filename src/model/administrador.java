package Model;

public class administrador {
    private String Cedula_admin;
    private String Cedula_repartidor;
    private int Id_producto;
    private String RUC;
    private String Nombre_admin;
    private String Apellido_admin;
    private String Telefono_admin;
    private String Correo_Electronico_Admin;

    public administrador(){

    }
    public administrador(String cedula_admin, String cedula_repartidor, int id_producto, String ruc,
    String nombre_admin, String apellido_admin, String telefono_admin, String correo_Electronico_Admin){
         Cedula_admin =cedula_admin ;
         Cedula_repartidor = cedula_repartidor;
         Id_producto =id_producto;
         RUC = ruc;
         Nombre_admin = nombre_admin;
         Apellido_admin = apellido_admin;
         Telefono_admin = telefono_admin;
         Correo_Electronico_Admin = correo_Electronico_Admin;
    }
    public String getCedula_admin() {
        return Cedula_admin;
    }
    public void setCedula_admin(String cedula_admin) {
        Cedula_admin = cedula_admin;
    }
    public String getCedula_repartidor() {
        return Cedula_repartidor;
    }
    public void setCedula_repartidor(String cedula_repartidor) {
        Cedula_repartidor = cedula_repartidor;
    }
    public int getId_producto() {
        return Id_producto;
    }
    public void setId_producto(int id_producto) {
        Id_producto = id_producto;
    }
    public String getRUC() {
        return RUC;
    }
    public void setRUC(String rUC) {
        RUC = rUC;
    }
    public String getNombre_admin() {
        return Nombre_admin;
    }
    public void setNombre_admin(String nombre_admin) {
        Nombre_admin = nombre_admin;
    }
    public String getApellido_admin() {
        return Apellido_admin;
    }
    public void setApellido_admin(String apellido_admin) {
        Apellido_admin = apellido_admin;
    }
    public String getTelefono_admin() {
        return Telefono_admin;
    }
    public void setTelefono_admin(String telefono_admin) {
        Telefono_admin = telefono_admin;
    }
    public String getCorreo_Electronico_Admin() {
        return Correo_Electronico_Admin;
    }
    public void setCorreo_Electronico_Admin(String correo_Electronico_Admin) {
        Correo_Electronico_Admin = correo_Electronico_Admin;
    }
    
}