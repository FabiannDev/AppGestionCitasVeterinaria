package DAO;
//librerias
import Formatos.*;
import Modelo.*;
import Vista.*;
import java.io.File;
import java.io.FileInputStream;

public class CRUD_VeterinariaEverpets extends ConectarBD{
    public CRUD_VeterinariaEverpets(){}
    frmVeterinariaEverpets vista;
    //metodo que inserta registros a la tabla
    public void InsertarVeterinaria(VeterinariaEverpets vet){
        vista=new frmVeterinariaEverpets();
        try{
            String rutaImagen = vet.getRuta();
            //preparando la consulta con parametros a travez de los simbolos de interrogante(?)
            ps=con.prepareStatement("insert into EMPRESA (RUC,Nombre,Telefono,Direccion,imagen,ruta)" +
                                    " values (?,?,?,?,?,?);");
            //FileInputStream archivofoto;
            //actualizando los parametros
            ps.setString(1, vet.getRUC());
            ps.setString(2, vet.getNombre());
            ps.setString(3, vet.getTelefono());
            ps.setString(4, vet.getDireccion());
            // Leer el archivo de imagen y establecerlo como un objeto BLOB
            File file = new File(rutaImagen);
            FileInputStream fis = new FileInputStream(file);
            ps.setBinaryStream(5, fis, (int) file.length()); // imagen

            ps.setString(6, rutaImagen); // Ruta del archivo
            //actualizamos y ejecutamos la consulta
            ps.executeUpdate();
            Mensajes.M1("Datos registrados correctamente");
        }catch(Exception e){
            Mensajes.M1("ERROR no se puede insertar la categoria..."+e);
        }
    }//fin metodo
    
    //metodo que recupera un registro de la tabla por medio del id
    public VeterinariaEverpets RecuperarDatos(){
        VeterinariaEverpets vet=null;
        try{
            rs=st.executeQuery("SELECT RUC,Nombre,Telefono,Direccion,imagen,ruta FROM EMPRESA");
            if(rs.next()){
                vet=new VeterinariaEverpets();
                vet.setRUC(rs.getString(1));
                vet.setNombre(rs.getString(2));
                vet.setTelefono(rs.getString(3));
                vet.setDireccion(rs.getString(4));
                
                // Leer la imagen como un arreglo de bytes
                byte[] imagenByte = rs.getBytes(5);
                vet.setImagen(imagenByte); // Guardar la imagen como un arreglo de bytes
                
                vet.setRuta(rs.getString(6));
            }
            con.close();
        }catch(Exception e){
            Mensajes.M1("ERROR no se puede recuperar el registro ..."+e);
        }
        return vet;
    }//fin metodo
    
    // Método para actualizar un registro en la tabla EMPRESA
    public void actualizarVeterinaria(VeterinariaEverpets vet) {
        try {
            // Preparar la consulta SQL de actualización
            ps = con.prepareStatement("UPDATE EMPRESA SET Nombre=?, Telefono=?, Direccion=?, imagen=?, ruta=? WHERE RUC=?");

            // Establecer los parámetros de la consulta SQL
            ps.setString(1, vet.getNombre());
            ps.setString(2, vet.getTelefono());
            ps.setString(3, vet.getDireccion());

            // Leer el archivo de imagen y establecerlo como un objeto BLOB
            File file = new File(vet.getRuta());
            FileInputStream fis = new FileInputStream(file);
            ps.setBinaryStream(4, fis, (int) file.length()); // imagen

            ps.setString(5, vet.getRuta()); // Ruta del archivo

            // RUC para identificar el registro que se va a actualizar
            ps.setString(6, vet.getRUC());

            // Ejecutar la consulta SQL de actualización
            ps.executeUpdate();

            Mensajes.M1("Datos actualizados correctamente");
        } catch (Exception e) {
            Mensajes.M1("ERROR: No se puede actualizar el registro... " + e.getMessage());
        }
    }//fin metodo
    
}//fin clase
