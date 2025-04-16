package DAO;
//librerias
import Formatos.*;

public class AdministrarClaves extends ConectarBD{
    public String consultaTipoMasc="select t.idTipoMascota from TIPO_MASCOTA t where t.Nombre_TipoMascota=?;";
    public String consultaServicio="select s.idServicios from SERVICIOS s where s.NombreServicio=?;";
    public String consultaTurno="select t.idTurno from TURNO t where t.hora=?;";
    public String consultaRol="select r.idRol from ROL r where r.descripcion=?;";
    
    public AdministrarClaves(){}
    
    //metodo que recibe una consulta y parametro para retornar la id de un registro
    public int RecuperarID(String consulta,String nombre){
        int id=0;
        try{
            ps=con.prepareStatement(consulta);
            ps.setString(1, nombre);
            rs=ps.executeQuery();
            if(rs.next()){
                id=rs.getInt(1);
            }
        }catch(Exception e){
            Mensajes.M1("ERROR no se puede recuperar la id..."+e);
        }
        return id;
    }//fin metodo
    
    public String queryTipoMasc="select Nombre_TipoMascota from TIPO_MASCOTA where idTipoMascota=?;";
    public String queryServicio="select NombreServicio from SERVICIOS where idServicios=?;";
    public String queryTurno="select hora from TURNO where idTurno=?;";
    public String queryRol="select descripcion from ROL where idRol=?;";
    
    //metodo que recupera el nombre a traves de la id
    public String RecuperarNombre(String consulta, int id){
        String nombre=null;
        try{
            ps=con.prepareStatement(consulta);
            ps.setInt(1, id);
            rs=ps.executeQuery();
            if(rs.next()){
                nombre=rs.getString(1);
            }
            con.close();
        }catch(Exception ex){
            Mensajes.M1("ERROR no se puede recuperar el nombre... "+ex);
        }
        return nombre;
    }//fin metodo
    
    public String consultaVeterina="select v.idVeterinario from VETERINARIO v where v.NombresVeterinario=?;";
    public String consultaIddMasco="select m.idMascota from MASCOTA m where m.Nombre_mascota=?;";
    public String consultaNomVeter="select v.NombresVeterinario from VETERINARIO v where v.idVeterinario=?;";
    public String consultaNomMasco="select m.Nombre_mascota from MASCOTA m where m.idMascota=?;";
    
    //metodo que recibe una consulta y parametro para retornar la id de un registro
    public String RecuperarCodigo(String consulta,String nombre){
        String id=null;
        try{
            ps=con.prepareStatement(consulta);
            ps.setString(1, nombre);
            rs=ps.executeQuery();
            if(rs.next()){
                id=rs.getString(1);
            }
        }catch(Exception e){
            Mensajes.M1("ERROR no se puede recuperar la id..."+e);
        }
        return id;
    }//fin metodo
    
}//fin clase
