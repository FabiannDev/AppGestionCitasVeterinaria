package Modelo;
//librerias
import DAO.*;

public class Usuarios {
    private int idUsuario;
    private String apellidos;
    private String nombres;
    private String correo;
    private String clave;
    private int idRol;
    private int esActivo;
    public Usuarios(){}

    public int getIdUsuario()                       {return idUsuario;}
    public void setIdUsuario(int idUsuario)         {this.idUsuario = idUsuario;}
    public String getApellidos()                    {return apellidos;}
    public void setApellidos(String apellidos)      {this.apellidos = apellidos;}
    public String getNombres()                      {return nombres;}
    public void setNombres(String nombres)          {this.nombres = nombres;}
    public String getCorreo()                       {return correo;}
    public void setCorreo(String correo)            {this.correo = correo;}
    public String getClave()                        {return clave;}
    public void setClave(String clave)              {this.clave = clave;}
    public int getIdRol()                           {return idRol;}
    public void setIdRol(int idRol)                 {this.idRol = idRol;}
    public int getEsActivo()                        {return esActivo;}
    public void setEsActivo(int esActivo)           {this.esActivo = esActivo;}
    
    public String EstadoActiDesa(int esActivo){
        String estado=null;
        if(esActivo==0)         {estado="Inactivo";}
        else if(esActivo==1)    {estado="Activo";}
        return estado;
    }//fin metodo
    
    public Object[] RegistroUsuarios(int num){
        AdministrarClaves ac = new AdministrarClaves();
        Object[] fila = {num,idUsuario,apellidos,nombres,correo,clave,
            ac.RecuperarNombre(ac.queryRol, idRol),
            EstadoActiDesa(esActivo)};
        return fila;
    }//fin funcion
    
    
}//fin clase
