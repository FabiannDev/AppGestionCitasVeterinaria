package Procesos;
//librerias
import Modelo.*;
import Vista.*;
import DAO.*;

public class ProcesosServiciosVeterinaria {
    public static void Presentacion(FrmServiciosVeterinaria f8){
        f8.setVisible(true);
        f8.txtID.setEnabled(false);
        f8.setTitle("Servicios de la Veterinaria");
        
        ActualizarCombos ac = new ActualizarCombos();
        ac.CargarCombox(f8.cbxTipoMascota, ac.conultaTipoMasc);
    }
    
    public static void Estado1(FrmServiciosVeterinaria f8){
        f8.btnRegistrar.setEnabled(true);
        f8.btnConsultar.setEnabled(true);
        f8.btnActualizar.setEnabled(false);
        f8.btnDeshabilitar.setEnabled(false);
    }
    
    public static void Estado2(FrmServiciosVeterinaria f8){
        f8.btnRegistrar.setEnabled(false);
        f8.btnConsultar.setEnabled(true);
        f8.btnActualizar.setEnabled(true);
        f8.btnDeshabilitar.setEnabled(true);
    }
    
    public static void LimpiarEntradas(FrmServiciosVeterinaria f8){
        f8.txtID.setText("");
        f8.txtNombre.setText("");
        f8.cbxTipoMascota.setSelectedIndex(0);
        f8.txtPrecio.setText("");
        f8.txtNombre.requestFocus();
    }
    
    //metodo que lee los datos de la clase ServiciosDeVeterinaria
    public static ServicioDeVeterinaria LeerDatos(FrmServiciosVeterinaria f8){
         ServicioDeVeterinaria cat =  new ServicioDeVeterinaria();
         
         cat.setNombreServicio(f8.txtNombre.getText());
         cat.setPrecio(Double.parseDouble(f8.txtPrecio.getText()));
         
         AdministrarClaves ac = new AdministrarClaves();
         cat.setIdTipoMascota(ac.RecuperarID(ac.consultaTipoMasc, f8.cbxTipoMascota.getSelectedItem().toString()));
         
         return cat;
     }
    
}//fin clase
