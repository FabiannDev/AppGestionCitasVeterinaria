package Procesos;
//librerias
import DAO.*;
import Modelo.*;
import Vista.*;

public class ProcesosTurnosCita {
    public static void Presentacion(FrmTurnosCita f6){
        f6.setVisible(true);
        f6.txtID.setEnabled(false);
        f6.setTitle("Turnos de Cita");
    }
    
    public static void Estado1(FrmTurnosCita f6){
        f6.btnRegistrar.setEnabled(true);
        f6.btnConsultar.setEnabled(true);
        f6.btnActualizar.setEnabled(false);
        f6.btnDeshabilitar.setEnabled(false);
    }
    
    public static void Estado2(FrmTurnosCita f6){
        f6.btnRegistrar.setEnabled(false);
        f6.btnConsultar.setEnabled(true);
        f6.btnActualizar.setEnabled(true);
        f6.btnDeshabilitar.setEnabled(true);
    }
    
    public static void LimpiarEntradas(FrmTurnosCita f6){
        f6.txtID.setText("");
        f6.txtTurno.setText("");
        f6.txtDuracion.setText("");
        f6.txtTurno.requestFocus();
    }
    
    //metodo que lee los datos de la clase Veterinarios
    public static Turno LeerDatos(FrmTurnosCita f6){
         Turno cat =  new Turno();
         
         cat.setHora(f6.txtTurno.getText());
         cat.setDesripcion(f6.txtDuracion.getText());
         
         return cat;
     }
    
}//fin clase
