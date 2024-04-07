package Procesos;
//librerias
import DAO.*;
import Modelo.*;
import Vista.*;

public class ProcesosDueñosMascotas {
    public static void Presentacion(FrmDueñosdeMascota f1){
        f1.setVisible(true);
        f1.setTitle("Frm Dueños Mascota");
    }
    
    public static void Estado1(FrmDueñosdeMascota f1){
        f1.btnRegistrar.setEnabled(true);
        f1.btnConsultar.setEnabled(true);
        f1.btnActualizar.setEnabled(false);
    }
    
    public static void Estado2(FrmDueñosdeMascota f1){
        f1.btnRegistrar.setEnabled(false);
        f1.btnConsultar.setEnabled(true);
        f1.btnActualizar.setEnabled(true);
    }
    
    public static void LimpiarEntradas(FrmDueñosdeMascota f1){
        f1.txtDNI.setText("");
        f1.txtNombres.setText("");
        f1.txtApellidos.setText("");
        f1.txtDireccion.setText("");
        f1.txtTelefono.setText("");
        f1.txtCorreo.setText("");
        f1.txtDNI.requestFocus();
    }
    
    //metodo que lee los datos de la clase Propietarios
    public static Propietarios LeerDatos(FrmDueñosdeMascota f1){
         Propietarios cat =  new Propietarios();
         
         cat.setDNI(f1.txtDNI.getText());
         cat.setNombres(f1.txtNombres.getText());
         cat.setApellidos(f1.txtApellidos.getText());
         cat.setDireccion(f1.txtDireccion.getText());
         cat.setTelefono(f1.txtTelefono.getText());
         cat.setCorreo(f1.txtCorreo.getText());
         
         return cat;
     }
    
}//fin clase
