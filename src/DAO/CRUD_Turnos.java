package DAO;
//librerias
import Formatos.*;
import Modelo.*;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

public class CRUD_Turnos extends ConectarBD{
    public CRUD_Turnos(){}
    
    //metodo que muestra en JTable los registros de las tablas categorias
    public void MostrarCategoriasEnTabla(JTable tabla){
        String[] Titulos={"Nro","ID","Hora","Duracion"};
        DefaultTableModel modelo=new DefaultTableModel(null,Titulos);
        tabla.setModel(modelo);
        Turno cat=new Turno();
        int cantreg=0;
        try{
            rs=st.executeQuery("select t.idTurno,t.hora,t.descripcion" +
                              " from TURNO t;");
            while(rs.next()){
                cantreg++;
                cat.setIdTurno(rs.getInt(1));
                cat.setHora(rs.getString(2));
                cat.setDesripcion(rs.getString(3));
                modelo.addRow(cat.RegistroTurno(cantreg));
            }//fin while
            con.close();
        }catch(Exception e){
            Mensajes.M1("ERROR no se pueden ver las categorias en el JTable..."+e);
        }
    }//fin metodo
    
    //metodo que inserta registros a la tabla
    public void InsertarCategoria(Turno cat){
        try{
            //preparando la consulta con parametros a travez de los simbolos de interrogante(?)
            ps=con.prepareStatement("insert into TURNO(hora,estado,descripcion)" +
                                    " values (?,1,?);");
            //actualizando los parametros
            ps.setString(1, cat.getHora());
            ps.setString(2, cat.getDesripcion());
            //actualizamos y ejecutamos la consulta
            ps.executeUpdate();
            Mensajes.M1("Datos registrados correctamente");
            con.close();
        }catch(Exception e){
            Mensajes.M1("ERROR no se puede insertar la categoria..."+e);
        }
    }//fin metodo
    
    //metodo que recupera un registro de la tabla por medio del id
    public Turno RecuperarCategoria(int idcat){
        Turno cat=null;
        try{
            rs=st.executeQuery("select t.idTurno,t.hora,t.descripcion"+
                              " from TURNO t" +
                              " where t.idTurno='"+idcat+"';");
            if(rs.next()){
                cat=new Turno();
                cat.setIdTurno(rs.getInt(1));
                cat.setHora(rs.getString(2));
                cat.setDesripcion(rs.getString(3));
            }
            con.close();
        }catch(Exception e){
            Mensajes.M1("ERROR no se puede recuperar el registro ..."+e);
        }
        return cat;
    }//fin metodo
    
    //metodo que actualiza un registro de categoria
    public void ActualizarCategoria(Turno cat){
        try{
            ps=con.prepareStatement("update TURNO t set t.hora=?,t.descripcion=? where t.idTurno=?;");
            ps.setString(1, cat.getHora());
            ps.setString(2, cat.getDesripcion());
            ps.setInt(3, cat.getIdTurno());
            ps.executeUpdate();
            Mensajes.M1("Registro actualizado correctamente");
            con.close();
        }catch(Exception e){
            Mensajes.M1("ERROR no se pudo actualizar la categoria..."+e);
        }
    }//fin metodo
    
    //metodo que elimina una categoria
    public void InhabilitarCategoria(int idcat){
        try{
            ps=con.prepareStatement("delete from TURNO where idTurno=?");
            ps.setInt(1, idcat);
            ps.executeUpdate();
            Mensajes.M1("Resgistro eliminado correctamente");
            con.close();
        }catch(Exception e){
            Mensajes.M1("ERROR no se puede eliminar el registro..."+e);
        }
    }//fin metodo
    
}//fin clase
