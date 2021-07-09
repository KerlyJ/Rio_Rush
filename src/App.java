import datalayer.conexion;

public class App {
    public static void main(String[] args) throws Exception {
        conexion con = new conexion();
        con.open();
        System.out.println("Hello, World!");

    }
}
