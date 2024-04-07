package Modelo;
//librerias
import DAO.*;

public class TiposMascotas {
    private int idTipo;
    private String nombre;
    public TiposMascotas(){}

    public int getIdTipo()                  {return idTipo;}
    public void setIdTipo(int idTipo)       {this.idTipo = idTipo;}
    public String getNombre()               {return nombre;}
    public void setNombre(String nombre)    {this.nombre = nombre;}
    
    public Object[] RegistroTiposMascota(int numeracion){
        Object[] fila={numeracion,idTipo,nombre};
        return fila;
   }
    
}//fin clase
