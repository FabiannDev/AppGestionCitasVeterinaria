package DAO;
//librerias
import javax.swing.JComboBox;
import Formatos.*;
import Modelo.*;
import java.awt.event.ItemEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ActualizarCombos extends ConectarBD{
    public String conultaTipoMasc="select t.Nombre_TipoMascota" +
                                 " from TIPO_MASCOTA t" +
                                 " order by 1;";
    
    public String conultaTurno="select t.hora" +
                              " from TURNO t" +
                              " order by 1;";
    
    public String conultaServicio="select distinct s.NombreServicio" +
                                 " from SERVICIOS s" +
                                 " order by 1;";
    
    public String conultaRol="select distinct r.descripcion" +
                                 " from roles r" +
                                 " order by 1;";
   
    
    public ActualizarCombos(){}
    
    public void CargarCombox(JComboBox combo,String consulta){
        try{
            rs=st.executeQuery(consulta);
            while(rs.next()){
                combo.addItem(rs.getString(1));
            }
        }catch(Exception ex){
            Mensajes.M1("ERROR no se puede cargar el combo..."+ex);
        }
    }//fin metodo
    
    public void CargarComboxMedicinaPorMascota(JComboBox combo,int idMascota){
        try{
            rs=st.executeQuery("select m.nombre_medicina" +
                               " from Medicinas m" +
                               " where indicador='A'"+
                               " and m.id_tipomascota="+idMascota+";");
            while(rs.next()){
                combo.addItem(rs.getString(1));
            }
        }catch(Exception ex){
            Mensajes.M1("ERROR no se puede cargar el combo..."+ex);
        }
    }//fin metodo
    
    /*public void CargarComboxServicio(JComboBox combo,int idTipoMascota){
        combo.removeAllItems();
        try{
            rs=st.executeQuery("select s.idServicios,s.NombreServicio" +
                               " from SERVICIOS s" +
                               " where s.TipoMascota="+idTipoMascota+";");
            while(rs.next()){
                //lo que va en el combox
                combo.addItem(rs.getInt(1)+" "+rs.getString(2));
            }
        }catch(Exception ex){
            Mensajes.M1("ERROR no se puede cargar el combo..."+ex);
        }
    }//fin metodo*/
    
    public void CargarComboxServicio1(JComboBox combo,int idTipoMascota){
        combo.removeAllItems();
        try{
            rs=st.executeQuery("select s.NombreServicio" +
                               " from SERVICIOS s" +
                               " where s.TipoMascota="+idTipoMascota+";");
            while(rs.next()){
                //lo que va en el combox
                combo.addItem(rs.getString(1));
            }
        }catch(Exception ex){
            Mensajes.M1("ERROR no se puede cargar el combo..."+ex);
        }
    }//fin metodo
    
    public void CargarComboxServicio2(JComboBox combo, JComboBox c1){
        combo.removeAllItems();
        String nombre;
        nombre=(String)c1.getSelectedItem();
        try{
            rs=st.executeQuery("select m.TipoMascota" +
                               " from MASCOTA m" +
                               " where m.Nombre_mascota='"+nombre+"';");
            while(rs.next()){
                //lo que va en el combox
                CargarComboxServicio1(combo, rs.getInt(1));
            }
        }catch(Exception ex){
            Mensajes.M1("ERROR no se puede cargar el combo..."+ex);
        }
    }//fin metodo
    
    /*public void CargarComboxMascotaDNI(JComboBox combo, String DNI){
        try{
            rs=st.executeQuery("select m.IdMascota, m.Nombre_mascota, m.TipoMascota" +
                               " from MASCOTA m" +
                               " where m.DNI="+DNI+
                               " order by 1;");
            
            while(rs.next()){
                //lo que va en el combox
                combo.addItem(rs.getString(1)+" Nombre: "+rs.getString(2)+" "+rs.getInt(3));
            }
        }catch(Exception ex){
            Mensajes.M1("ERROR no se puede cargar el combo..."+ex);
        }
    }//fin metodo*/
    
    public void CargarComboxMascotaDNI2(JComboBox combo, String DNI){
        try{
            rs=st.executeQuery(" select m.Nombre_mascota" +
                               " from MASCOTA m" +
                               " where m.DNI="+DNI+
                               " order by 1;");
            
            while(rs.next()){
                //lo que va en el combox
                AdministrarClaves ad=new AdministrarClaves();
                combo.addItem(rs.getString(1));
            }
        }catch(Exception ex){
            Mensajes.M1("ERROR no se puede cargar el combo..."+ex);
        }
    }//fin metodo
    
    public void CargarComboxVeterinario(JComboBox combo,String servicio){
        combo.removeAllItems();
        try{
            rs=st.executeQuery("select s.idServicios" +
                               " from SERVICIOS s" +
                               " where s.NombreServicio='"+servicio+"';");
            while(rs.next()){
                //lo que va en el combox
                CargarComboxVeterinario2(combo, rs.getInt(1));
            }
        }catch(Exception ex){
            Mensajes.M1("ERROR no se puede cargar el combo..."+ex);
        }
    }//fin metodo
    
    public void CargarComboxVeterinario2(JComboBox combo, int id){
        try{
            rs=st.executeQuery("select v.NombresVeterinario" +
                               " from VETERINARIO v" +
                               " where v.idServicios='"+id+"';");
            while(rs.next()){
                //lo que va en el combox
                combo.addItem(rs.getString(1));
            }
        }catch(Exception ex){
            Mensajes.M1("ERROR no se puede cargar el combo..."+ex);
        }
    }//fin metodo
    
    public void CargarPrecio(JComboBox combo,JTextField precio){
        precio.setText("");
        String nombre;
        nombre=(String)combo.getSelectedItem();
        AdministrarClaves ad=new AdministrarClaves();
        String codigo=ad.RecuperarCodigo(ad.consultaVeterina, nombre);
        try{
            rs=st.executeQuery("select v.Sueldo" +
                               " from VETERINARIO v" +
                               " where v.idVeterinario='"+codigo+"';");
            while(rs.next()){
                //lo que va en el combox
                precio.setText(Double.toString(rs.getDouble(1)));
            }
        }catch(Exception ex){
            Mensajes.M1("ERROR no se puede cargar el combo..."+ex);
        }
    }//fin metodo
    
}//fin clase
