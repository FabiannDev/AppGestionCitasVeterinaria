package DAO;
//librerias
import java.sql.*;
import Formatos.Mensajes;

public class ConectarBD implements Parametros{
    Connection con;
    Statement st;
    ResultSet rs;
    PreparedStatement ps;
    ResultSetMetaData mdata;
    public ConectarBD(){
        try{
            Class.forName(DRIVER);
            con=DriverManager.getConnection(RUTA,USUARIO,CLAVE);
            st=con.createStatement();
        }catch(Exception e){
            Mensajes.M1("ERROR no se puede conectar a la BD..."+e);
        }
    }
}
