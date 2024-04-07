package DAO;
//librerias
import Formatos.*;
import Modelo.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CRUD_Usuarios extends ConectarBD{
    public CRUD_Usuarios(){}
    //metodo que muestra en JTable los registros de las tablas categorias
    public void MostrarUsuariosEnTabla(JTable tabla){
        String[] Titulos={"Nro","Codigo","Apellidos","Nombres","Correo","Clave","ROl","Estado"};
        DefaultTableModel modelo=new DefaultTableModel(null,Titulos);
        tabla.setModel(modelo);
        Usuarios u=new Usuarios();
        int cantreg=0;
        try{
            rs=st.executeQuery("select u.idUsuario,u.apellidos,u.nombres,u.correo,u.clave,u.idRol,u.esActivo" +
                              " from usuarios u;");
            while(rs.next()){
                cantreg++;
                u.setIdUsuario(rs.getInt(1));
                u.setApellidos(rs.getString(2));
                u.setNombres(rs.getString(3));
                u.setCorreo(rs.getString(4));
                u.setClave(rs.getString(5));
                u.setIdRol(rs.getInt(6));
                u.setEsActivo(rs.getInt(7));
                modelo.addRow(u.RegistroUsuarios(cantreg));
            }//fin while
            con.close();
        }catch(Exception e){
            Mensajes.M1("ERROR no se pueden ver los usuarios en el JTable..."+e);
        }
    }//fin metodo
    
    //metodo que inserta registros a la tabla
    public void InsertarUsuario(Usuarios u){
        try{
            //preparando la consulta con parametros a travez de los simbolos de interrogante(?)
            ps=con.prepareStatement("insert into USUARIOS (apellidos,nombres,correo,clave,idRol,esActivo)" +
                                    " values (?,?,?,?,?,?);");
            //actualizando los parametros
            ps.setString(1, u.getApellidos());
            ps.setString(2, u.getNombres());
            ps.setString(3, u.getCorreo());
            ps.setString(4, u.getClave());
            ps.setInt(5, u.getIdRol());
            ps.setInt(6, u.getEsActivo());
            //actualizamos y ejecutamos la consulta
            ps.executeUpdate();
            Mensajes.M1("Datos registrados correctamente");
            con.close();
        }catch(Exception e){
            Mensajes.M1("ERROR no se puede insertar el usuario..."+e);
        }
    }//fin metodo
    
    //metodo que recupera un registro de la tabla por medio del id
    public Usuarios RecuperarUsuario(String idU){
        Usuarios u=null;
        try{
            rs=st.executeQuery("select u.idUsuario,u.apellidos,u.nombres,u.correo,u.clave,u.idRol,u.esActivo"+
                              " from USUARIOS u" +
                              " where u.idUsuario='"+idU+"';");
            if(rs.next()){
                u=new Usuarios();
                u.setIdUsuario(rs.getInt(1));
                u.setApellidos(rs.getString(2));
                u.setNombres(rs.getString(3));
                u.setCorreo(rs.getString(4));
                u.setClave(rs.getString(5));
                u.setIdRol(rs.getInt(6));
                u.setEsActivo(rs.getInt(7));
            }
            con.close();
        }catch(Exception e){
            Mensajes.M1("ERROR no se puede recuperar el registro ..."+e);
        }
        return u;
    }//fin metodo
    
    //metodo que actualiza un registro de categoria
    public void ActualizarUsuario(Usuarios u){
        try{
            ps=con.prepareStatement("update USUARIOS u set u.apellidos=?,u.nombres=?,u.correo=?,u.clave=?,u.idRol=?,u.esActivo=? where u.idUsuario=?;");
            ps.setString(1, u.getApellidos());
            ps.setString(2, u.getNombres());
            ps.setString(3, u.getCorreo());
            ps.setString(4, u.getClave());
            ps.setInt(5, u.getIdRol());
            ps.setInt(6, u.getEsActivo());
            ps.setInt(7, u.getIdUsuario());
            ps.executeUpdate();
            Mensajes.M1("Registro actualizado correctamente");
            con.close();
        }catch(Exception e){
            Mensajes.M1("ERROR no se pudo actualizar el usuario..."+e);
        }
    }//fin metodo
    
}//fin clase
