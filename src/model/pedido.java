package model;

import java.sql.Date;
import java.sql.Time;

public class pedido {
    private int Id_pedido;
    private String Cedula_usuario;
    private int Id_direccion;
    private String Cedula_repartidor;
    private Date Fecha;
    private Time Hora;
   
    public pedido(){

    }
    
        public pedido(int id_pedido, String cedula_usuario, int id_direccion, 
        String cedula_repartidor, Date fecha, Time hora){
    
            Id_pedido = id_pedido;
            Cedula_repartidor = cedula_repartidor;
            Id_direccion = id_direccion;
            Cedula_usuario = cedula_usuario;
            Fecha = fecha;
            Hora = hora;
    
    }

        public int getId_pedido() {
            return Id_pedido;
        }

        public void setId_pedido(int id_pedido) {
            Id_pedido = id_pedido;
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

        public String getCedula_repartidor() {
            return Cedula_repartidor;
        }

        public void setCedula_repartidor(String cedula_repartidor) {
            Cedula_repartidor = cedula_repartidor;
        }

        public Date getFecha() {
            return Fecha;
        }

        public void setFecha(Date fecha) {
            Fecha = fecha;
        }

        public Time getHora() {
            return Hora;
        }

        public void setHora(Time hora) {
            Hora = hora;
        }

    

}
