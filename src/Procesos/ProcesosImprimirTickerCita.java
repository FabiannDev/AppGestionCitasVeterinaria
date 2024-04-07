package Procesos;
//librerias
import Vista.*;

public class ProcesosImprimirTickerCita {
    public static void Presentacion(ImprimirTickerCita f10){
        f10.setVisible(true);
    }
    
    public static void LimpiarEntradasCarnet(Ticker f10){
        f10.lblCodigo.setText("");
        f10.lblFecha.setText("");
        f10.lblHorarioEstablecido.setText("");
    }
    
}//fin clase
