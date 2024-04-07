package Procesos;
//librerias
import DAO.*;
import Vista.*;
import Modelo.*;

public class ProcesosVeterinarios {
    public static void Presentacion(FrmVeterinarios f7){
        f7.setVisible(true);
        f7.txtCodigo.setEnabled(false);
        f7.setTitle("Procesos Veterinarios");
        
        ActualizarCombos ac = new ActualizarCombos();
        ac.CargarCombox(f7.cbxTipoMascota, ac.conultaTipoMasc);
        ac.CargarCombox(f7.cbxServicio, ac.conultaServicio);
    }
    
    public static void Estado1(FrmVeterinarios f7){
        f7.btnRegistrar.setEnabled(true);
        f7.btnConsultar.setEnabled(true);
        f7.btnActualizar.setEnabled(false);
        f7.btnDeshabilitar.setEnabled(false);
    }
    
    public static void Estado2(FrmVeterinarios f7){
        f7.btnRegistrar.setEnabled(false);
        f7.btnConsultar.setEnabled(true);
        f7.btnActualizar.setEnabled(true);
        f7.btnDeshabilitar.setEnabled(true);
    }
    
    public static void LimpiarEntradas(FrmVeterinarios f7){
        f7.txtCodigo.setText("");
        f7.txtNombres.setText("");
        f7.txtApellidos.setText("");
        f7.cbxTipoMascota.setSelectedIndex(0);
        f7.cbxServicio.setSelectedIndex(0);
        f7.txtSueldo.setText("");
        f7.txtSueldo.requestFocus();
    }
    
    //metodo que lee los datos de la clase Veterinarios
    public static Veterinarios LeerDatos(FrmVeterinarios f7){
         Veterinarios cat =  new Veterinarios();
         
         cat.setNombre(f7.txtNombres.getText());
         cat.setApellido(f7.txtApellidos.getText());
         cat.setSueldo(Double.parseDouble(f7.txtSueldo.getText()));
         
         AdministrarClaves ac = new AdministrarClaves();
         cat.setIdTipoMascota(ac.RecuperarID(ac.consultaTipoMasc, f7.cbxTipoMascota.getSelectedItem().toString()));
         cat.setIdServicios(ac.RecuperarID(ac.consultaServicio, f7.cbxServicio.getSelectedItem().toString()));
         
         return cat;
     }
    
}//fin clase
