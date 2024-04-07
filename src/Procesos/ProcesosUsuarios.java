package Procesos;
//librerias
import DAO.*;
import Modelo.*;
import Vista.*;


public class ProcesosUsuarios {
    public static void Presentacion(FrmUsuarios f10){
        f10.setVisible(true);
        f10.txtId.setEnabled(false);
        f10.setTitle("Frm De Usuarios");
        
        ActualizarCombos ac = new ActualizarCombos();
        ac.CargarCombox(f10.cbxRol, ac.conultaRol);
        
    }
    
    public static void Estado1(FrmUsuarios f10){
        f10.btnRegistrar.setEnabled(true);
        f10.btnConsultar.setEnabled(true);
        f10.btnActualizar.setEnabled(false);
    }
    
    public static void Estado2(FrmUsuarios f10){
        f10.btnRegistrar.setEnabled(false);
        f10.btnConsultar.setEnabled(true);
        f10.btnActualizar.setEnabled(true);
    }
    
    public static void LimpiarEntradas(FrmUsuarios f10){
        f10.txtId.setText("");
        f10.txtClave.setText("");
        f10.txtCorreo.setText("");
        f10.cbxRol.setSelectedIndex(0);
        f10.spnEstado.setValue(0);
        f10.txtNombres.setText("");
        f10.txtApellidos.setText("");
        f10.txtClave.requestFocus();
    }
    
    //metodo que lee los datos de la clase Veterinarios
    public static Usuarios LeerDatos(FrmUsuarios f10){
         Usuarios u =  new Usuarios();
         
         u.setNombres(f10.txtNombres.getText());
         u.setApellidos(f10.txtApellidos.getText());
         u.setClave(f10.txtClave.getText());
         u.setCorreo(f10.txtCorreo.getText());
         
         u.setEsActivo(Integer.parseInt(f10.spnEstado.getValue().toString()));
         
         AdministrarClaves ac = new AdministrarClaves();
         u.setIdRol(ac.RecuperarID(ac.consultaRol, f10.cbxRol.getSelectedItem().toString()));
         
         
         return u;
     }//fin metodo
    
}//fin clase
