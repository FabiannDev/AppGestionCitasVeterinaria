package Modelo;
//librerias
import DAO.*;

public class Veterinarios {
    private String idVeterinario;
    private String nombre;
    private String apellido;
    private double sueldo;
    private int estado;
    private int idTipoMascota;
    private int idServicios;
    public Veterinarios(){}

    public String getIdVeterinario()                        {return idVeterinario;}
    public void setIdVeterinario(String idVeterinario)      {this.idVeterinario = idVeterinario;}
    public String getNombre()                               {return nombre;}
    public void setNombre(String nombre)                    {this.nombre = nombre;}
    public String getApellido()                             {return apellido;}
    public void setApellido(String apellido)                {this.apellido = apellido;}
    public double getSueldo()                               {return sueldo;}
    public void setSueldo(double sueldo)                    {this.sueldo = sueldo;}
    public int getEstado()                                  {return estado;}
    public void setEstado(int estado)                       {this.estado = estado;}
    public int getIdTipoMascota()                           {return idTipoMascota;}
    public void setIdTipoMascota(int idTipoMascota)         {this.idTipoMascota = idTipoMascota;}
    public int getIdServicios()                             {return idServicios;}
    public void setIdServicios(int idServicios)             {this.idServicios = idServicios;}
    
    public Object[] RegistroVeterinarios(int numeracion){
        
        AdministrarClaves ac = new AdministrarClaves();
        AdministrarClaves ac1 = new AdministrarClaves();
        
        Object[] fila={numeracion,idVeterinario,nombre,apellido,sueldo,
                       ac.RecuperarNombre(ac.queryTipoMasc, idTipoMascota),
                       ac1.RecuperarNombre(ac1.queryServicio, idServicios)};
        return fila;
   }
    
}//fin clase
