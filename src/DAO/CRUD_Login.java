package DAO;
//librerias
import Formatos.*;
import Modelo.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CRUD_Login extends ConectarBD{
    public CRUD_Login(){}
    
    public Usuarios login(String usuario, String clave){
        String sql="SELECT * FROM USUARIOS WHERE nombres='"+usuario+"' and clave='"+clave+"'";
        Usuarios u = new Usuarios();
        int cant=0;
        try {
            st=con.createStatement();
            rs=st.executeQuery(sql);
            if(rs.next()){
                cant++;
                Mensajes.M1("bienvenido(a) "+usuario);
                u.setIdUsuario(rs.getInt(1));
                u.setApellidos(rs.getString(2));
                u.setNombres(rs.getString(3));
                u.setCorreo(rs.getString(4));
                u.setClave(rs.getString(5));
                u.setIdRol(rs.getInt(6));
                u.setEsActivo(rs.getInt(7));
                u.RegistroUsuarios(cant);
            }
        } catch (Exception e) {
            Mensajes.M1("Error ");
        }
        return u;
    }//fin metodo
    
}//fin clase
