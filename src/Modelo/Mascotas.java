package Modelo;
//librerias
import DAO.*;

public class Mascotas {
    private String idMascota;
    private String nombreM;
    private String sexoM;
    private int tipoM;
    private int edadM;
    private double pesoM;
    private String dniP;
    public Mascotas(){}

    public String getIdMascota()                        {return idMascota;}
    public void setIdMascota(String idMascota)          {this.idMascota = idMascota;}
    public String getNombreM()                          {return nombreM;}
    public void setNombreM(String nombreM)              {this.nombreM = nombreM;}
    public String getSexoM()                            {return sexoM;}
    public void setSexoM(String sexoM)                  {this.sexoM = sexoM;}
    public int getTipoM()                               {return tipoM;}
    public void setTipoM(int tipoM)                     {this.tipoM = tipoM;}
    public int getEdadM()                               {return edadM;}
    public void setEdadM(int edadM)                     {this.edadM = edadM;}
    public double getPesoM()                            {return pesoM;}
    public void setPesoM(double pesoM)                  {this.pesoM = pesoM;}
    public String getDniP()                             {return dniP;}
    public void setDniP(String dniP)                    {this.dniP = dniP;}
    
    public Object[] RegistroMascotas(int numeracion){
        
        AdministrarClaves ac = new AdministrarClaves();
        
        Object[] fila={numeracion,idMascota,nombreM,
                       ac.RecuperarNombre(ac.queryTipoMasc, tipoM),
                       sexoM,edadM,pesoM,dniP};
        return fila;
   }
    
}//fin clase
