package Procesos;
//librerias
import Vista.*;

public class ProcesosListaDeCitas {
    public static void Presentacion(FrmListaDeCitas f4){
        f4.setVisible(true);
        f4.setTitle("Listar Citas");
    }
    
    public static void LimpiarEntradas(FrmListaDeCitas f4){
        f4.txtBuscar.setText("");
        f4.txtBuscar.requestFocus();
    }
    
}//fin clase
