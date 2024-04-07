package Procesos;
//librerias
import Vista.*;
import Modelo.*;
import DAO.*;

public class ProcesosTiposMascota {
    public static void Presentacion(FrmTiposMascota f9){
        f9.setVisible(true);
        f9.txtID.setEnabled(false);
        f9.setTitle("Tipos de Mascota");
    }
    
    public static void Estado1(FrmTiposMascota f9){
        f9.btnRegistrar.setEnabled(true);
        f9.btnConsultar.setEnabled(true);
        f9.btnActualizar.setEnabled(false);
        f9.btnDeshabilitar.setEnabled(false);
    }
    
    public static void Estado2(FrmTiposMascota f9){
        f9.btnRegistrar.setEnabled(false);
        f9.btnConsultar.setEnabled(true);
        f9.btnActualizar.setEnabled(true);
        f9.btnDeshabilitar.setEnabled(true);
    }
    
    public static void LimpiarEntradas(FrmTiposMascota f9){
        f9.txtNombre.setText("");
        f9.txtID.setText("");
        f9.requestFocus();
    }
    
    //metodo que lee los datos de la clase TipoMascota
    public static TiposMascotas LeerDatos(FrmTiposMascota f9){
         TiposMascotas cat =  new TiposMascotas();
         
         cat.setNombre(f9.txtNombre.getText());
         
         return cat;
     }
    
}//fin clase
