package Modelo;
//librerias
import DAO.*;

public class ServicioDeVeterinaria {
    private int idServicio;
    private int idTipoMascota;
    private String nombreServicio;
    private double precio;
    public ServicioDeVeterinaria(){}

    public int getIdServicio()                              {return idServicio;}
    public void setIdServicio(int idServicio)               {this.idServicio = idServicio;}
    public int getIdTipoMascota()                           {return idTipoMascota;}
    public void setIdTipoMascota(int idTipoMascota)         {this.idTipoMascota = idTipoMascota;}
    public String getNombreServicio()                       {return nombreServicio;}
    public void setNombreServicio(String nombreServicio)    {this.nombreServicio = nombreServicio;}
    public double getPrecio()                               {return precio;}
    public void setPrecio(double precio)                    {this.precio = precio;}
    
    public Object[] RegistroServiciosVeterinaria(int numeracion){
        
        AdministrarClaves ac = new AdministrarClaves();
        Object[] fila={numeracion,idServicio,nombreServicio,
                       ac.RecuperarNombre(ac.queryTipoMasc, idTipoMascota),precio};
        return fila;
   }
    
}//fin clase
