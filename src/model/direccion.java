package Model;


public class direccion {
    private int Id_direccion;
    private String Calle_principal;
    private String Calle_secundaria;
    private String Numero_casa;
    private String Parroquia;
    private String Referencia;

    public direccion(int id_direccion, String calle_principal,  String calle_secundaria, String numero_casa, String parroquia, String referencia) 
    {
        Id_direccion = id_direccion;
        Calle_principal = calle_principal;
        Calle_secundaria =  calle_secundaria;
        Numero_casa = numero_casa;
        Parroquia = parroquia;
        Referencia = referencia;    
    }

    public direccion() {
    }

    public int getId_direccion() {
        return Id_direccion;
    }

    public void setId_direccion(int id_direccion) {
        Id_direccion = id_direccion;
    }

    public String getCalle_principal() {
        return Calle_principal;
    }

    public void setCalle_principal(String calle_principal) {
        Calle_principal = calle_principal;
    }

    public String getCalle_secundaria() {
        return Calle_secundaria;
    }

    public void setCalle_secundaria(String calle_secundaria) {
        Calle_secundaria = calle_secundaria;
    }

    public String getNumero_casa() {
        return Numero_casa;
    }

    public void setNumero_casa(String numero_casa) {
        Numero_casa = numero_casa;
    }

    public String getParroquia() {
        return Parroquia;
    }

    public void setParroquia(String parroquia) {
        Parroquia = parroquia;
    }

    public String getReferencia() {
        return Referencia;
    }

    public void setReferencia(String referencia) {
        Referencia = referencia;
    }

}