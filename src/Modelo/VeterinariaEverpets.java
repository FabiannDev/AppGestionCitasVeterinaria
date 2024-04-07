package Modelo;
//librerias
public class VeterinariaEverpets {
    private String RUC;
    private String nombre;
    private String telefono;
    private String direccion;
    private String ruta;
    private byte[] imagen;
    public VeterinariaEverpets(){}

    public String getRUC()                      {return RUC;}
    public void setRUC(String RUC)              {this.RUC = RUC;}
    public String getNombre()                   {return nombre;}
    public void setNombre(String nombre)        {this.nombre = nombre;}
    public String getTelefono()                 {return telefono;}
    public void setTelefono(String telefono)    {this.telefono = telefono;}
    public String getDireccion()                {return direccion;}
    public void setDireccion(String direccion)  {this.direccion = direccion;}
    public byte[] getImagen()                   {return imagen;}
    public void setImagen(byte[] imagen)        {this.imagen = imagen;}
    public String getRuta()                     {return ruta;}
    public void setRuta(String ruta)            {this.ruta = ruta;}
    
    
}//fin clase
