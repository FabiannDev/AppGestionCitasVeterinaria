package DAO;
//librerias
import Formatos.*;
import Modelo.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

public class CRUD_ReservarCita extends ConectarBD{
    public CRUD_ReservarCita(){}
    
    //metodo que muestra en JTable los registros de las tablas categorias
    public void MostrarCategoriasEnTablaTurno(JTable tabla, String fecha){
        String[] Titulos={"Nro","Codigo","Fecha","Turno","Estado"};
        DefaultTableModel modelo=new DefaultTableModel(null,Titulos);
        tabla.setModel(modelo);
        Citas cat=new Citas();
        int cantreg=0;
        try{
            rs=st.executeQuery("select c.idCita,c.FechaCita,c.idTurno,c.idEstado" +
                              " from CITA c"+
                              " where c.FechaCita='"+fecha+"';");
            while(rs.next()){
                cantreg++;
                cat.setIdCita(rs.getString(1));
                cat.setFecha(rs.getDate(2));
                cat.setIdTurno(rs.getInt(3));
                cat.setIdEstado(rs.getInt(4));
                modelo.addRow(cat.RegistroFechas(cantreg));
            }//fin while
            con.close();
        }catch(Exception e){
            Mensajes.M1("ERROR no se pueden ver las categorias en el JTable..."+e);
        }
    }//fin metodo
    
    //metodo que muestra en JTable los registros de las tablas categorias
    public void MostrarCategoriasEnTabla(JTable tabla, String consulta){
        String[] Titulos={"Nro","Cita","Propietario","DNI","Mascota","Nombre PET","Servicio","Veterinario","Fecha","Hora","Estado"};
        DefaultTableModel modelo=new DefaultTableModel(null,Titulos);
        tabla.setModel(modelo);
        ConsultarCita cat=new ConsultarCita();
        int cantreg=0;
        try{
            rs=st.executeQuery(consulta);
            while(rs.next()){
                cantreg++;
                cat.setIdCita(rs.getString(1));
                cat.setNombres(rs.getString(2));
                cat.setApellidos(rs.getString(3));
                cat.setDni(rs.getString(4));
                cat.setIdMascota(rs.getString(5));
                cat.setNombreM(rs.getString(6));
                cat.setNombreServicio(rs.getString(7));
                cat.setNombreV(rs.getString(8));
                cat.setFecha(rs.getDate(9));
                cat.setHora(rs.getString(10));
                cat.setTipoEstado(rs.getString(11));
                modelo.addRow(cat.RegistroCitas(cantreg));
            }//fin while
            con.close();
        }catch(Exception e){
            Mensajes.M1("ERROR no se pueden ver las categorias en el JTable..."+e);
        }
    }//fin metodo
    
     //metodo que inserta registros a la tabla
    public void InsertarCategoria(Citas cat){
        try{
            //preparando la consulta con parametros a travez de los simbolos de interrogante(?)
            ps=con.prepareStatement("insert into CITA (DNI,idMascota,FechaCita,idTurno,idServicios,idVeterinario,Precio,Descripcion,idEstado)" +
                                    " values(?,?,?,?,?,?,?,?,1);");
            //actualizando los parametros
            ps.setString(1, cat.getDni());
            ps.setString(2, cat.getIdMascota());
            
            SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
            ps.setString(3, df.format(cat.getFecha()));
            
            ps.setInt(4, cat.getIdTurno());
            ps.setInt(5, cat.getIdServicios());
            ps.setString(6, cat.getIdVeterinario());
            ps.setDouble(7, cat.getPrecio());
            ps.setString(8, cat.getDescripcion());
            //actualizamos y ejecutamos la consulta
            ps.executeUpdate();
            Mensajes.M1("Datos registrados correctamente");
            con.close();
        }catch(Exception e){
            Mensajes.M1("ERROR no se puede insertar la categoria..."+e);
        }
    }//fin metodo
    
    //metodo que recupera un registro de la tabla por medio del id
    public Citas RecuperarCategoria(String idcat){
        Citas cat=null;
        try{
            rs=st.executeQuery("select c.IdCita, c.DNI, c.idMascota, c.FechaCita, c.idTurno, c.idServicios, c.idVeterinario, c.Precio, c.Descripcion" +
                              " from CITA c" +
                              " where c.IdCita='"+idcat+"';");
            if(rs.next()){
                cat=new Citas();
                cat.setIdCita(rs.getString(1));
                cat.setDni(rs.getString(2));
                cat.setIdMascota(rs.getString(3));
                cat.setFecha(rs.getDate(4));
                cat.setIdTurno(rs.getInt(5));
                cat.setIdServicios(rs.getInt(6));
                cat.setIdVeterinario(rs.getString(7));
                cat.setPrecio(rs.getDouble(8));
                cat.setDescripcion(rs.getString(9));
            }
            con.close();
        }catch(Exception e){
            Mensajes.M1("ERROR no se puede recuperar el registro ..."+e);
        }
        return cat;
    }//fin metodo
    
    //metodo que actualiza un registro de categoria
    public void TerminarCita(Citas cat){
        try{
            ps=con.prepareStatement("update CITA set idEstado=2 where IdCita=?;");
            ps.setString(1, cat.getIdCita());
            ps.executeUpdate();
            Mensajes.M1("Registro actualizado correctamente");
            con.close();
        }catch(Exception e){
            Mensajes.M1("ERROR no se pudo actualizar la categoria..."+e);
        }
    }//fin metodo
    
    //metodo que actualiza un registro de categoria
    public void CancelarCita(Citas cat){
        try{
            ps=con.prepareStatement("update CITA set idEstado=3 where IdCita=?;");
            ps.setString(1, cat.getIdCita());
            ps.executeUpdate();
            Mensajes.M1("Registro actualizado correctamente");
            con.close();
        }catch(Exception e){
            Mensajes.M1("ERROR no se pudo actualizar la categoria..."+e);
        }
    }//fin metodo
    
    //metodo que actualiza un registro de categoria
    public void ReprogramarCita(Citas cat){
        try{
            ps=con.prepareStatement("update CITA c set c.FechaCita=?, c.idTurno=? where c.IdCita=?;");
            SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
            ps.setString(1, df.format(cat.getFecha()));
            ps.setInt(2, cat.getIdTurno());
            ps.setString(3, cat.getIdCita());
            ps.executeUpdate();
            Mensajes.M1("Registro actualizado correctamente");
            con.close();
        }catch(Exception e){
            Mensajes.M1("ERROR no se pudo actualizar la categoria..."+e);
        }
    }//fin metodo
    
    //metodo que muestra codigo en ticket
    public void CargarCodigoTicket(JLabel codigo){
        try{
            rs=st.executeQuery("select max(IdCita) as IdCita from CITA;");
            if(rs.next()){
                String c=rs.getString("IdCita");
                codigo.setText(c);
            }
        }catch(Exception ex){
            Mensajes.M1("ERROR no se puede ..."+ex);
        }
    }//fin metodo
    
    //metodo que muestra datos en ticket
    public void DatosTicket(String Codigo, JLabel j1, JLabel j2){
        try{
            rs=st.executeQuery("select c.FechaCita, t.hora"+
                              " from CITA c"+
                              " inner join TURNO t on c.idTurno=t.idTurno"+
                              " where c.IdCita='"+Codigo+"';");
            while(rs.next()){
                Date f=rs.getDate("c.FechaCita");
                String h=rs.getString("t.hora");
                j1.setText(f.toString());
                j2.setText(h);
            }//fin while
            con.close();
        }catch(Exception e){
            Mensajes.M1("ERROR no se pueden ver las categorias en el JTable..."+e);
        }
    }//fin metodo
    
    //metodo que recupera el dueño al label
    public void DatosRecibo(String idCi, JLabel e1, JLabel e2, JLabel e3, JLabel e4, JLabel e5, JLabel e6, JLabel e7, JLabel e8, JLabel e9){
        try{
            rs=st.executeQuery("select p.Nombres, p.Apellidos, p.DNI, m.idMascota, m.Nombre_mascota, s.NombreServicio, v.NombresVeterinario, v.ApellidosVeterinario, c.FechaCita, t.hora, c.Precio"+
                              " from CITA c" +
                              " inner join propietario p on c.DNI=p.DNI"+
                              " inner join mascota m on c.IdMascota=m.IdMascota"+
                              " inner join servicios s on c.idServicios=s.idServicios"+
                              " inner join veterinario v on c.idVeterinario=v.idVeterinario"+
                              " inner join TURNO t on c.idTurno=t.idTurno"+
                              " where c.IdCita='"+idCi+"';");
            while(rs.next()){
                String Nombres=rs.getString("p.Nombres");
                String Apellidos=rs.getString("p.Apellidos");
                String dni=rs.getString("p.DNI");
                String idMacota=rs.getString("m.idMascota");
                String NombreM=rs.getString("m.Nombre_mascota");
                String NombreS=rs.getString("s.NombreServicio");
                String NombreV=rs.getString("v.NombresVeterinario");
                String ApellidosV=rs.getString("v.ApellidosVeterinario");
                Date fecha=rs.getDate("c.FechaCita");
                String hora=rs.getString("t.hora");
                Double precio=rs.getDouble("c.Precio");
                e1.setText(Nombres+" "+Apellidos);
                e2.setText(dni);
                e3.setText(idMacota);
                e4.setText(NombreM);
                e5.setText(NombreS);
                e6.setText(NombreV+" "+ApellidosV);
                e7.setText(fecha.toString());
                e8.setText(hora);
                e9.setText(precio.toString());
            }
            con.close();
        }catch(Exception e){
            Mensajes.M1("ERROR no se puede recuperar el registro ..."+e);
        }
    }//fin metodo
    
}//fin clase
