package Modelo;
//librerias
import DAO.*;
import java.util.Date;

public class ConsultarCita {
    private String idCita;
    private String Nombres;
    private String Apellidos;
    private String dni;
    private String idMascota;
    private String nombreM;
    private String NombreServicio;
    private String nombreV;
    private Date Fecha;
    private String Hora;
    private String TipoEstado;
    public ConsultarCita(){}

    public String getIdCita()                                   {return idCita;}
    public void setIdCita(String idCita)                        {this.idCita = idCita;}
    public String getNombres()                                  {return Nombres;}
    public void setNombres(String Nombres)                      {this.Nombres = Nombres;}
    public String getApellidos()                                {return Apellidos;}
    public void setApellidos(String Apellidos)                  {this.Apellidos = Apellidos;}
    public String getDni()                                      {return dni;}
    public void setDni(String dni)                              {this.dni = dni;}
    public String getIdMascota()                                {return idMascota;}
    public void setIdMascota(String idMascota)                  {this.idMascota = idMascota;}
    public String getNombreM()                                  {return nombreM;}
    public void setNombreM(String nombreM)                      {this.nombreM = nombreM;}
    public String getNombreServicio()                           {return NombreServicio;}
    public void setNombreServicio(String NombreServicio)        {this.NombreServicio = NombreServicio;}
    public String getNombreV()                                  {return nombreV;}
    public void setNombreV(String nombreV)                      {this.nombreV = nombreV;}
    public Date getFecha()                                      {return Fecha;}
    public void setFecha(Date Fecha)                            {this.Fecha = Fecha;}
    public String getHora()                                     {return Hora;}
    public void setHora(String Hora)                            {this.Hora = Hora;}
    public String getTipoEstado()                               {return TipoEstado;}
    public void setTipoEstado(String TipoEstado)                {this.TipoEstado = TipoEstado;}
    
    public Object[] RegistroCitas(int num){
        
        Object[] fila = {num,idCita,Nombres+" "+Apellidos,dni,idMascota,nombreM,
                         NombreServicio,nombreV,Fecha,Hora,TipoEstado};
        return fila;
    }
    
}//fin clase
