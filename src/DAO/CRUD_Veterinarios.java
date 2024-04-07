package DAO;
//librerias
import Formatos.*;
import Modelo.*;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

public class CRUD_Veterinarios extends ConectarBD{
    public CRUD_Veterinarios(){}
    
    //metodo que muestra en JTable los registros de las tablas categorias
    public void MostrarCategoriasEnTabla(JTable tabla){
        String[] Titulos={"Nro","Codigo","Nombres","Apellidos","Sueldo","Atencion","Servicio"};
        DefaultTableModel modelo=new DefaultTableModel(null,Titulos);
        tabla.setModel(modelo);
        Veterinarios cat=new Veterinarios();
        int cantreg=0;
        try{
            rs=st.executeQuery("select v.idVeterinario, v.NombresVeterinario, v.ApellidosVeterinario, v.Sueldo, v.idTipoMascota, v.idServicios" +
                              " from VETERINARIO v;");
            while(rs.next()){
                cantreg++;
                cat.setIdVeterinario(rs.getString(1));
                cat.setNombre(rs.getString(2));
                cat.setApellido(rs.getString(3));
                cat.setSueldo(rs.getDouble(4));
                cat.setIdTipoMascota(rs.getInt(5));
                cat.setIdServicios(rs.getInt(6));
                modelo.addRow(cat.RegistroVeterinarios(cantreg));
            }//fin while
            con.close();
        }catch(Exception e){
            Mensajes.M1("ERROR no se pueden ver las categorias en el JTable..."+e);
        }
    }//fin metodo
    
    //metodo que inserta registros a la tabla
    public void InsertarCategoria(Veterinarios cat){
        try{
            //preparando la consulta con parametros a travez de los simbolos de interrogante(?)
            ps=con.prepareStatement("insert into VETERINARIO (NombresVeterinario,ApellidosVeterinario,Sueldo,estado,idTipoMascota,idServicios)" +
                                    " values (?,?,?,1,?,?);");
            //actualizando los parametros
            ps.setString(1, cat.getNombre());
            ps.setString(2, cat.getApellido());
            ps.setDouble(3, cat.getSueldo());
            ps.setInt(4, cat.getIdTipoMascota());
            ps.setInt(5, cat.getIdServicios());
            //actualizamos y ejecutamos la consulta
            ps.executeUpdate();
            Mensajes.M1("Datos registrados correctamente");
            con.close();
        }catch(Exception e){
            Mensajes.M1("ERROR no se puede insertar la categoria..."+e);
        }
    }//fin metodo
    
    //metodo que recupera un registro de la tabla por medio del id
    public Veterinarios RecuperarCategoria(String idcat){
        Veterinarios cat=null;
        try{
            rs=st.executeQuery("select v.idVeterinario,v.NombresVeterinario,v.ApellidosVeterinario,v.Sueldo,v.idTipoMascota,v.idServicios"+
                              " from VETERINARIO v" +
                              " where v.idVeterinario='"+idcat+"';");
            if(rs.next()){
                cat=new Veterinarios();
                cat.setIdVeterinario(rs.getString(1));
                cat.setNombre(rs.getString(2));
                cat.setApellido(rs.getString(3));
                cat.setSueldo(rs.getDouble(4));
                cat.setIdTipoMascota(rs.getInt(5));
                cat.setIdServicios(rs.getInt(6));
            }
            con.close();
        }catch(Exception e){
            Mensajes.M1("ERROR no se puede recuperar el registro ..."+e);
        }
        return cat;
    }//fin metodo
    
    //metodo que actualiza un registro de categoria
    public void ActualizarCategoria(Veterinarios cat){
        try{
            ps=con.prepareStatement("update VETERINARIO v set v.NombresVeterinario=?, v.ApellidosVeterinario=?, v.Sueldo=?, v.idTipoMascota=? ,v.idServicios=? where v.idVeterinario=?;");
            ps.setString(1, cat.getNombre());
            ps.setString(2, cat.getApellido());
            ps.setDouble(3, cat.getSueldo());
            ps.setInt(4, cat.getIdTipoMascota());
            ps.setInt(5, cat.getIdServicios());
            ps.setString(6, cat.getIdVeterinario());
            ps.executeUpdate();
            Mensajes.M1("Registro actualizado correctamente");
            con.close();
        }catch(Exception e){
            Mensajes.M1("ERROR no se pudo actualizar la categoria..."+e);
        }
    }//fin metodo
    
    //metodo que elimina una categoria
    public void InhabilitarCategoria(String idcat){
        try{
            ps=con.prepareStatement("delete from VETERINARIO where idVeterinario=?");
            ps.setString(1, idcat);
            ps.executeUpdate();
            Mensajes.M1("Resgistro eliminado correctamente");
            con.close();
        }catch(Exception e){
            Mensajes.M1("ERROR no se puede eliminar el registro..."+e);
        }
    }//fin metodo
    
}//fin clase
