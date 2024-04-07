package Procesos;
//librerias
//librerias
import DAO.*;
import Formatos.*;
import Modelo.*;
import Vista.*;
import Vista.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class ProcesosVeterinaria {
    public static void Presentacion(frmVeterinariaEverpets f11){
        f11.setVisible(true);
        f11.setTitle("Frm De Nuestra Empresa");
        //f11.jtxtBuscarImagen.setVisible(false);
    }
    
    public static void LimpiarEntradas(frmVeterinariaEverpets f11){
        f11.txtRUC.setText("");
        f11.txtNombre.setText("");
        f11.txtTelefono.setText("");
        f11.txtDireccion.setText("");
        f11.jtxtBuscarImagen.setText("");
        f11.txtRUC.requestFocus();
    }
    
    //metodo que lee los datos de la clase Veterinarios
    public static VeterinariaEverpets LeerDatos(frmVeterinariaEverpets f11){
         VeterinariaEverpets vet =  new VeterinariaEverpets();
         
         vet.setRUC(f11.txtRUC.getText());
         vet.setNombre(f11.txtNombre.getText());
         vet.setTelefono(f11.txtTelefono.getText());
         vet.setDireccion(f11.txtDireccion.getText());
         String rutaImagen = f11.jtxtBuscarImagen.getText();
         byte[] imagenBytes = leerImagenComoBytes(rutaImagen);
         vet.setImagen(imagenBytes);
         vet.setRuta(f11.jtxtBuscarImagen.getText());
         
         return vet;
     }
    
    // Método para leer un archivo de imagen y convertirlo en un arreglo de bytes
    private static byte[] leerImagenComoBytes(String rutaImagen) {
        byte[] imagenBytes = null;
        try {
            File archivo = new File(rutaImagen);
            imagenBytes = Files.readAllBytes(archivo.toPath());
        } catch (IOException e) {
            e.printStackTrace();
            Mensajes.M1("Error al leer la imagen como bytes: " + e.getMessage());
        }
        return imagenBytes;
    }
}//fin clase
