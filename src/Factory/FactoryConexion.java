package Factory;

public class FactoryConexion {

    public static final int PGSQL = 1;

    public static String[] configPGSQL = {"<baseDeDatos>", "<usuario>", "<contraseña>"};  //configurar conexion: nombre bd, usr, clave

    
    //metodo que devuelve un objeto tipo coneectionDb (la primera clase)
    public static conexion open(int tipoBd){   //parametro indica si se conecta con MyQsl o PgSql
        switch(tipoBd){         //pasra determinar tipo de base de datos a laque se debe conectar        
            case FactoryConexion.PGSQL:     //abrir bd postgresql
                return new PostgreSQLConexionFactory(configPGSQL);
            default:        //si no se indica a q bd se conecta, devuelve nulo
                return null;
        }
    }
}