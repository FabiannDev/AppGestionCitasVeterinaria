package Procesos;
//librerias
import DAO.*;
import Modelo.*;
import Vista.*;

public class ProcesosDeMascotas {
    public static void Presentacion(FrmDeMascotas f2){
        f2.setVisible(true);
        f2.txtCodigo.setEnabled(false);
        f2.setTitle("Frm De Mascota");
        
        ActualizarCombos ac = new ActualizarCombos();
        ac.CargarCombox(f2.cbxTipoMascota, ac.conultaTipoMasc);
    }
    
    public static void Estado1(FrmDeMascotas f2){
        f2.btnRegistrar.setEnabled(true);
        f2.btnConsultar.setEnabled(true);
        f2.btnActualizar.setEnabled(false);
    }
    
    public static void Estado2(FrmDeMascotas f2){
        f2.btnRegistrar.setEnabled(false);
        f2.btnConsultar.setEnabled(true);
        f2.btnActualizar.setEnabled(true);
    }
    
    public static void LimpiarEntradas(FrmDeMascotas f2){
        f2.txtCodigo.setText("");
        f2.txtNombre.setText("");
        f2.txtPeso.setText("");
        f2.cbxTipoMascota.setSelectedIndex(0);
        f2.cbxSexoMascota.setSelectedIndex(0);
        f2.spnEdad.setValue(0);
        f2.txtDNIpropietario.setText("");
        f2.lblDueño.setText("");
        f2.txtNombre.requestFocus();
    }
    
    //metodo que lee los datos de la clase Veterinarios
    public static Mascotas LeerDatos(FrmDeMascotas f2){
         Mascotas cat =  new Mascotas();
         
         cat.setNombreM(f2.txtNombre.getText());
         cat.setPesoM(Double.parseDouble(f2.txtPeso.getText()));
         cat.setDniP(f2.txtDNIpropietario.getText());
         
         cat.setSexoM(f2.cbxSexoMascota.getSelectedItem().toString());
         
         cat.setEdadM(Integer.parseInt(f2.spnEdad.getValue().toString()));
         
         AdministrarClaves ac = new AdministrarClaves();
         cat.setTipoM(ac.RecuperarID(ac.consultaTipoMasc, f2.cbxTipoMascota.getSelectedItem().toString()));
         
         
         return cat;
     }//fin metodo
    
}//fin clase
