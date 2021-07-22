package Model;

public class factura {
    private int Id_factura;
    private double Precio_final;
    private int Cantidad;


    public factura(int id_factura, double precio_final, int cantidad) 
    {
        Id_factura = id_factura;
        Precio_final = precio_final;
        Cantidad = cantidad;      
    }

    public factura(){
    }

    public int getId_factura() {
        return Id_factura;
    }


    public void setId_factura(int id_factura) {
        Id_factura = id_factura;
    }


    public double getPrecio_final() {
        return Precio_final;
    }


    public void setPrecio_final(double precio_final) {
        Precio_final = precio_final;
    }

    public int getCantidad() {
        return Cantidad;
    }


    public void setCantidad(int cantidad) {
        Cantidad = cantidad;
    }
   
}