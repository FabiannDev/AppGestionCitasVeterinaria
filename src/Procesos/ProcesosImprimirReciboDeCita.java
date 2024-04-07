package Procesos;
//librerias
import Vista.*;

public class ProcesosImprimirReciboDeCita {
    public static void Presentacion(ImprimirReciboDeCita f11){
        f11.setVisible(true);
    }
    
    public static void LimpiarEntradasRecibo(ReciboCita f11){
        f11.lblCodigo.setText("");
        f11.lblNombres.setText("");
        f11.lblDNI.setText("");
        f11.lblCodMascota.setText("");
        f11.lblMascota.setText("");
        f11.lblServicio.setText("");
        f11.lblVeterinario.setText("");
        f11.lblFecha.setText("");
        f11.lblHora.setText("");
        f11.lblPrecio.setText("");
    }
    
}//fin clase
