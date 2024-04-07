package DAO;
//librerias
import Formatos.*;
import Modelo.*;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

public class CRUD_TiposMascotas extends ConectarBD{
    public CRUD_TiposMascotas(){}
    
    //metodo que muestra en JTable los registros de las tablas categorias
    public void MostrarCategoriasEnTabla(JTable tabla){
        String[] Titulos={"Nro","ID","Nombre Tipo"};
        DefaultTableModel modelo=new DefaultTableModel(null,Titulos);
        tabla.setModel(modelo);
        TiposMascotas cat=new TiposMascotas();
        int cantreg=0;
        try{
            rs=st.executeQuery("select t.idTipoMascota, t.Nombre_TipoMascota" +
                              " from TIPO_MASCOTA t;");
            while(rs.next()){
                cantreg++;
                cat.setIdTipo(rs.getInt(1));
                cat.setNombre(rs.getString(2));
                modelo.addRow(cat.RegistroTiposMascota(cantreg));
            }//fin while
            con.close();
        }catch(Exception e){
            Mensajes.M1("ERROR no se pueden ver las categorias en el JTable..."+e);
        }
    }//fin metodo
    
    //metodo que inserta registros a la tabla
    public void InsertarCategoria(TiposMascotas cat){
        try{
            //preparando la consulta con parametros a travez de los simbolos de interrogante(?)
            ps=con.prepareStatement("insert into TIPO_MASCOTA (Nombre_TipoMascota)" +
                                    " values (?);");
            //actualizando los parametros
            ps.setString(1, cat.getNombre());
            //actualizamos y ejecutamos la consulta
            ps.executeUpdate();
            Mensajes.M1("Datos registrados correctamente");
            con.close();
        }catch(Exception e){
            Mensajes.M1("ERROR no se puede insertar la categoria..."+e);
        }
    }//fin metodo
    
    //metodo que recupera un registro de la tabla por medio del id
    public TiposMascotas RecuperarCategoria(int idcat){
        TiposMascotas cat=null;
        try{
            rs=st.executeQuery("select t.idTipoMascota, t.Nombre_TipoMascota" +
                              " from TIPO_MASCOTA t" +
                              " where t.idTipoMascota="+idcat+";");
            if(rs.next()){
                cat=new TiposMascotas();
                cat.setIdTipo(rs.getInt(1));
                cat.setNombre(rs.getString(2));
            }
            con.close();
        }catch(Exception e){
            Mensajes.M1("ERROR no se puede recuperar el registro de medicinas..."+e);
        }
        return cat;
    }//fin metodo
    
    //metodo que actualiza un registro de categoria
    public void ActualizarCategoria(TiposMascotas cat){
        try{
            ps=con.prepareStatement("update TIPO_MASCOTA t set t.Nombre_TipoMascota=? where t.idTipoMascota=?;");
            ps.setString(1, cat.getNombre());
            ps.setInt(2, cat.getIdTipo());
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
            ps=con.prepareStatement("delete from TIPO_MASCOTA where idTipoMascota=?");
            ps.setInt(1, idcat);
            ps.executeUpdate();
            Mensajes.M1("Resgistro eliminado correctamente");
            con.close();
        }catch(Exception e){
            Mensajes.M1("ERROR no se puede eliminar el registro..."+e);
        }
    }//fin metodo
    
}//fin clase
