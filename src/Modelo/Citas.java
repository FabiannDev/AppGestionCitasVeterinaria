package Modelo;
//librerias
import DAO.*;
import java.util.Date;

public class Citas {
    private String idCita;
    private String dni;
    private String idMascota;
    private Date fecha;
    private int idTurno;
    private int idServicios;
    private String idVeterinario;
    private double precio;
    private String descripcion;
    private int idEstado;
    public Citas(){}

    public String getIdCita()                                   {return idCita;}
    public void setIdCita(String idCita)                        {this.idCita = idCita;}
    public String getDni()                                      {return dni;}
    public void setDni(String dni)                              {this.dni = dni;}
    public String getIdMascota()                                {return idMascota;}
    public void setIdMascota(String idMascota)                  {this.idMascota = idMascota;}
    public Date getFecha()                                      {return fecha;}
    public void setFecha(Date fecha)                            {this.fecha = fecha;}
    public int getIdTurno()                                     {return idTurno;}
    public void setIdTurno(int idTurno)                         {this.idTurno = idTurno;}
    public int getIdServicios()                                 {return idServicios;}
    public void setIdServicios(int idServicios)                 {this.idServicios = idServicios;}
    public String getIdVeterinario()                            {return idVeterinario;}
    public void setIdVeterinario(String idVeterinario)          {this.idVeterinario = idVeterinario;}
    public double getPrecio()                                   {return precio;}
    public void setPrecio(double precio)                        {this.precio = precio;}
    public String getDescripcion()                              {return descripcion;}
    public void setDescripcion(String descripcion)              {this.descripcion = descripcion;}
    public int getIdEstado()                                    {return idEstado;}
    public void setIdEstado(int idEstado)                       {this.idEstado = idEstado;}
    
    public Object[] RegistroCitas(int num){
        
        AdministrarClaves ac1=new AdministrarClaves();
        AdministrarClaves ac2=new AdministrarClaves();
        AdministrarClaves ac3=new AdministrarClaves();
        
        Object[] fila = {num,idCita,dni,idMascota,
                         ac1.RecuperarNombre(ac1.queryServicio, idServicios),
                         ac2.RecuperarID(ac2.consultaVeterina, idVeterinario),
                         fecha,
                         ac3.RecuperarNombre(ac3.queryTurno, idTurno),
                         precio};
        return fila;
    }
    
    public Object[] RegistroFechas(int num){
        
        AdministrarClaves ac1=new AdministrarClaves();
        
        Object[] fila = {num,idCita,fecha,
                         ac1.RecuperarNombre(ac1.queryTurno, idTurno),
                         idEstado};
        return fila;
    }
    
    
}//fin clase
