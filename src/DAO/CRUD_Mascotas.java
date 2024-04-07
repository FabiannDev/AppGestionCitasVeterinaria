package DAO;
//librerias
import Formatos.*;
import Modelo.*;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

public class CRUD_Mascotas extends ConectarBD{
    public CRUD_Mascotas(){}
    
    //metodo que muestra en JTable los registros de las tablas categorias
    public void MostrarCategoriasEnTabla(JTable tabla){
        String[] Titulos={"Nro","Codigo","Nombre","Tipo","Sexo","Edad","Peso","DNI Propietario"};
        DefaultTableModel modelo=new DefaultTableModel(null,Titulos);
        tabla.setModel(modelo);
        Mascotas cat=new Mascotas();
        int cantreg=0;
        try{
            rs=st.executeQuery("select m.idMascota, m.Nombre_mascota, m.Sexo_mascota, m.TipoMascota, m.Edad_mascota, m.Peso_mascota, m.DNI" +
                              " from MASCOTA m;");
            while(rs.next()){
                cantreg++;
                cat.setIdMascota(rs.getString(1));
                cat.setNombreM(rs.getString(2));
                cat.setSexoM(rs.getString(3));
                cat.setTipoM(rs.getInt(4));
                cat.setEdadM(rs.getInt(5));
                cat.setPesoM(rs.getDouble(6));
                cat.setDniP(rs.getString(7));
                modelo.addRow(cat.RegistroMascotas(cantreg));
            }//fin while
            con.close();
        }catch(Exception e){
            Mensajes.M1("ERROR no se pueden ver las categorias en el JTable..."+e);
        }
    }//fin metodo
    
    //metodo que inserta registros a la tabla
    public void InsertarCategoria(Mascotas cat){
        try{
            //preparando la consulta con parametros a travez de los simbolos de interrogante(?)
            ps=con.prepareStatement("insert into MASCOTA (Nombre_mascota,Sexo_mascota,TipoMascota,Edad_mascota,Peso_mascota,DNI)" +
                                    " values (?,?,?,?,?,?);");
            //actualizando los parametros
            ps.setString(1, cat.getNombreM());
            ps.setString(2, cat.getSexoM());
            ps.setInt(3, cat.getTipoM());
            ps.setInt(4, cat.getEdadM());
            ps.setDouble(5, cat.getPesoM());
            ps.setString(6, cat.getDniP());
            //actualizamos y ejecutamos la consulta
            ps.executeUpdate();
            Mensajes.M1("Datos registrados correctamente");
            con.close();
        }catch(Exception e){
            Mensajes.M1("ERROR no se puede insertar la categoria..."+e);
        }
    }//fin metodo
    
    //metodo que recupera un registro de la tabla por medio del id
    public Mascotas RecuperarCategoria(String idcat){
        Mascotas cat=null;
        try{
            rs=st.executeQuery("select m.idMascota, m.Nombre_mascota, m.Sexo_mascota, m.TipoMascota, m.Edad_mascota, m.Peso_mascota, m.DNI"+
                              " from MASCOTA m" +
                              " where m.idMascota='"+idcat+"';");
            if(rs.next()){
                cat=new Mascotas();
                cat.setIdMascota(rs.getString(1));
                cat.setNombreM(rs.getString(2));
                cat.setSexoM(rs.getString(3));
                cat.setTipoM(rs.getInt(4));
                cat.setEdadM(rs.getInt(5));
                cat.setPesoM(rs.getDouble(6));
                cat.setDniP(rs.getString(7));
            }
            con.close();
        }catch(Exception e){
            Mensajes.M1("ERROR no se puede recuperar el registro ..."+e);
        }
        return cat;
    }//fin metodo
    
    //metodo que actualiza un registro de categoria
    public void ActualizarCategoria(Mascotas cat){
        try{
            ps=con.prepareStatement("update MASCOTA m set m.Nombre_mascota=?, m.Sexo_mascota=?, m.TipoMascota=?, m.Edad_mascota=?, m.Peso_mascota=?, m.DNI=? where m.idMascota=?;");
            ps.setString(1, cat.getNombreM());
            ps.setString(2, cat.getSexoM());
            ps.setInt(3, cat.getTipoM());
            ps.setInt(4, cat.getEdadM());
            ps.setDouble(5, cat.getPesoM());
            ps.setString(6, cat.getDniP());
            ps.setString(7, cat.getIdMascota());
            ps.executeUpdate();
            Mensajes.M1("Registro actualizado correctamente");
            con.close();
        }catch(Exception e){
            Mensajes.M1("ERROR no se pudo actualizar la categoria..."+e);
        }
    }//fin metodo
    
    //metodo que recupera el dueño al label
    public Mascotas DatosCarnetM(String idcat, JLabel e1, JLabel e2, JLabel e3, JLabel e4, JLabel e5){
        Mascotas cat=null;
        try{
            rs=st.executeQuery("select m.IdMascota,m.DNI,m.Nombre_mascota,m.TipoMascota,m.Sexo_mascota"+
                              " from MASCOTA m" +
                              " where m.IdMascota='"+idcat+"';");
            if(rs.next()){
                cat=new Mascotas();
                cat.setIdMascota(rs.getString(1));
                cat.setDniP(rs.getString(2));
                cat.setNombreM(rs.getString(3));
                cat.setTipoM(rs.getInt(4));
                cat.setSexoM(rs.getString(5));
            }
            con.close();
        }catch(Exception e){
            Mensajes.M1("ERROR no se puede recuperar el registro ..."+e);
        }
        return cat;
    }//fin metodo
    
}//fin clase
