package Modelo;
//librerias
import DAO.*;

public class Propietarios {
    private String DNI;
    private String nombres;
    private String apellidos;
    private String direccion;
    private String telefono;
    private String correo;
    public Propietarios(){}

    public String getDNI()                              {return DNI;}
    public void setDNI(String DNI)                      {this.DNI = DNI;}
    public String getNombres()                          {return nombres;}
    public void setNombres(String nombres)              {this.nombres = nombres;}
    public String getApellidos()                        {return apellidos;}
    public void setApellidos(String apellidos)          {this.apellidos = apellidos;}
    public String getDireccion()                        {return direccion;}
    public void setDireccion(String direccion)          {this.direccion = direccion;}
    public String getTelefono()                         {return telefono;}
    public void setTelefono(String telefono)            {this.telefono = telefono;}
    public String getCorreo()                           {return correo;}
    public void setCorreo(String correo)                {this.correo = correo;}
    
    public Object[] RegistroPropietarios(int numeracion){
        
        Object[] fila={numeracion,DNI,nombres,apellidos,direccion,
                       telefono,correo};
        return fila;
   }
    
}//fin clase
