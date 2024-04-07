package DAO;
//librerias
import Formatos.*;
import Modelo.*;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

public class CRUD_ServiciosVeterinaria extends ConectarBD{
    public CRUD_ServiciosVeterinaria(){}
    
    //metodo que muestra en JTable los registros de las tablas categorias
    public void MostrarCategoriasEnTabla(JTable tabla){
        String[] Titulos={"Nro","ID","Nombre Servicio","Tipo Mascota","Precio"};
        DefaultTableModel modelo=new DefaultTableModel(null,Titulos);
        tabla.setModel(modelo);
        ServicioDeVeterinaria cat=new ServicioDeVeterinaria();
        int cantreg=0;
        try{
            rs=st.executeQuery("select s.idServicios, s.NombreServicio,s.TipoMascota,s.precioServicio" +
                              " from SERVICIOS s;");
            while(rs.next()){
                cantreg++;
                cat.setIdServicio(rs.getInt(1));
                cat.setNombreServicio(rs.getString(2));
                cat.setIdTipoMascota(rs.getInt(3));
                cat.setPrecio(rs.getDouble(4));
                modelo.addRow(cat.RegistroServiciosVeterinaria(cantreg));
            }//fin while
            con.close();
        }catch(Exception e){
            Mensajes.M1("ERROR no se pueden ver las categorias en el JTable..."+e);
        }
    }//fin metodo
    
    //metodo que inserta registros a la tabla
    public void InsertarCategoria(ServicioDeVeterinaria cat){
        try{
            //preparando la consulta con parametros a travez de los simbolos de interrogante(?)
            ps=con.prepareStatement("insert into SERVICIOS (NombreServicio,TipoMascota,precioServicio)" +
                                    " values (?,?,?);");
            //actualizando los parametros
            ps.setString(1, cat.getNombreServicio());
            ps.setInt(2, cat.getIdTipoMascota());
            ps.setDouble(3, cat.getPrecio());
            //actualizamos y ejecutamos la consulta
            ps.executeUpdate();
            Mensajes.M1("Datos registrados correctamente");
            con.close();
        }catch(Exception e){
            Mensajes.M1("ERROR no se puede insertar la categoria..."+e);
        }
    }//fin metodo
    
    //metodo que recupera un registro de la tabla por medio del id
    public ServicioDeVeterinaria RecuperarCategoria(int idcat){
        ServicioDeVeterinaria cat=null;
        try{
            rs=st.executeQuery("select s.idServicios, s.NombreServicio, s.TipoMascota, s.precioServicio" +
                              " from SERVICIOS s" +
                              " where s.idServicios="+idcat+";");
            if(rs.next()){
                cat=new ServicioDeVeterinaria();
                cat.setIdServicio(rs.getInt(1));
                cat.setNombreServicio(rs.getString(2));
                cat.setIdTipoMascota(rs.getInt(3));
                cat.setPrecio(rs.getDouble(4));
            }
            con.close();
        }catch(Exception e){
            Mensajes.M1("ERROR no se puede recuperar el registro de medicinas..."+e);
        }
        return cat;
    }//fin metodo
    
    //metodo que actualiza un registro de categoria
    public void ActualizarCategoria(ServicioDeVeterinaria cat){
        try{
            ps=con.prepareStatement("update SERVICIOS s set s.NombreServicio=?, s.TipoMascota=?, s.precioServicio=? where s.idServicios=?;");
            ps.setString(1, cat.getNombreServicio());
            ps.setInt(2, cat.getIdTipoMascota());
            ps.setDouble(3, cat.getPrecio());
            ps.setInt(4, cat.getIdServicio());
            ps.executeUpdate();
            Mensajes.M1("Registro actualizado correctamente");
            con.close();
        }catch(Exception e){
            Mensajes.M1("ERROR no se pudo actualizar la categoria..."+e);
        }
    }//fin metodo
    
    //metodo que inhabilita una categoria
    public void InhabilitarCategoria(int idcat){
        try{
            ps=con.prepareStatement("delete from SERVICIOS where idServicios=?");
            ps.setInt(1, idcat);
            ps.executeUpdate();
            Mensajes.M1("Resgistro eliminado correctamente");
            con.close();
        }catch(Exception e){
            Mensajes.M1("ERROR no se puede eliminar el registro..."+e);
        }
    }//fin metodo
    
}//fin clase
