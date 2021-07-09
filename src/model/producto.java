package model;

public class producto {
    private int idProducto;
    private String ruc ;
    private String descripcion;
    private  double  precioUnitario;
    public producto(int idProducto, String ruc, String descripcion, double precioUnitario) {
        this.idProducto = idProducto;
        this.ruc = ruc;
        this.descripcion = descripcion;
        this.precioUnitario = precioUnitario;
    }
    public int getIdProducto() {
        return idProducto;
    }
    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }
    public String getRuc() {
        return ruc;
    }
    public void setRuc(String ruc) {
        this.ruc = ruc;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public double getPrecioUnitario() {
        return precioUnitario;
    }
    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }
    

    
}
