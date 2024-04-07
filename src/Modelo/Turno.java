package Modelo;
//librerias
import DAO.*;
import java.util.*;

public class Turno {
    private int idTurno;
    private String hora;
    private int estado;
    private String desripcion;
    public Turno(){}

    public int getIdTurno()                         {return idTurno;}
    public void setIdTurno(int idTurno)             {this.idTurno = idTurno;}
    public String getHora()                           {return hora;}
    public void setHora(String hora)                  {this.hora = hora;}
    public int getEstado()                          {return estado;}
    public void setEstado(int estado)               {this.estado = estado;}
    public String getDesripcion()                   {return desripcion;}
    public void setDesripcion(String desripcion)    {this.desripcion = desripcion;}
    
    public Object[] RegistroTurno(int numeracion){
        
        Object[] fila={numeracion,idTurno,hora,desripcion};
        return fila;
   }
    
}//fin clase
