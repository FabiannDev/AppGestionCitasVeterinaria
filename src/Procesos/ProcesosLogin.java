package Procesos;
//librerias
//librerias
import DAO.*;
import Modelo.*;
import Vista.*;

public class ProcesosLogin {
    public static void Presentacion(FrmLogin fl){
        fl.setVisible(true);
        fl.setLocationRelativeTo(null);
        fl.setTitle("Frm Login");
    }
    
    public static void LimpiarEntradas(FrmLogin fl){
        fl.txtContraseña.setText("");
        fl.txtNombre.setText("");
    }
    
}//fin clase
