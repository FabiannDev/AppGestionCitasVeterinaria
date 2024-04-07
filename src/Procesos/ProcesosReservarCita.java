package Procesos;
//librerias
import DAO.*;
import Vista.*;
import Modelo.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class ProcesosReservarCita {
    public static void Presentacion(ReservarCita f3){
        f3.setVisible(true);
        f3.txtCodigo.setEditable(false);
        f3.txtPrecio.setEditable(false);
        f3.setTitle("Reservar una cita");
        
        ActualizarCombos ac = new ActualizarCombos();
        ac.CargarCombox(f3.cbxTurno, ac.conultaTurno);
    }
    
    public static void Estado1(ReservarCita f3){
        f3.btnReservarCita.setEnabled(true);
        f3.btnConsultarFecha.setEnabled(true);
        f3.btnCancelarCita.setEnabled(false);
        f3.btnReprogramar.setEnabled(false);
        f3.btnFinalizarCIta.setEnabled(true);
    }
    
    public static void Estado2(ReservarCita f3){
        f3.btnReservarCita.setEnabled(false);
        f3.btnConsultarFecha.setEnabled(false);
        f3.btnCancelarCita.setEnabled(true);
        f3.btnReprogramar.setEnabled(true);
        f3.btnFinalizarCIta.setEnabled(true);
    }
    
    public static void Estado3(ReservarCita f3){
        f3.btnBuscarDatos.setEnabled(false);
        f3.btnCargarVeterinario.setEnabled(false);
        f3.txtDNI.setEditable(false);
        f3.txaDescripcion.setEditable(false);
        f3.cbxMascota.setEnabled(false);
        f3.cbxServicio.setEnabled(false);
        f3.cbxVeterinario.setEnabled(false);
    }
    
    public static void LimpiarEntradas(ReservarCita f3){
        f3.txtCodigo.setText("");
        f3.txtDNI.setText("");
        f3.lblDueño.setText("");
        f3.cbxMascota.removeAllItems();
        f3.cbxServicio.removeAllItems();
        f3.cbxVeterinario.removeAllItems();
        f3.cbxTurno.setSelectedIndex(0);
        f3.txtPrecio.setText("");
        Calendar cal=new GregorianCalendar();
        f3.jdchFecha.setCalendar(cal);
        f3.txaDescripcion.setText("");
        f3.txtDNI.requestFocus();
    }
    
    //metodo que lee los datos de la clase Veterinarios
    public static Citas LeerDatos(ReservarCita f3){
         Citas cat =  new Citas();
         
         cat.setDni(f3.txtDNI.getText());
         cat.setDescripcion(f3.txaDescripcion.getText());
         cat.setPrecio(Double.parseDouble(f3.txtPrecio.getText()));
         
         AdministrarClaves ac = new AdministrarClaves();
         cat.setIdServicios(ac.RecuperarID(ac.consultaServicio, f3.cbxServicio.getSelectedItem().toString()));
         cat.setIdMascota(ac.RecuperarCodigo(ac.consultaIddMasco, f3.cbxMascota.getSelectedItem().toString()));
         cat.setIdVeterinario(ac.RecuperarCodigo(ac.consultaVeterina, f3.cbxVeterinario.getSelectedItem().toString()));
         cat.setIdTurno(ac.RecuperarID(ac.consultaTurno, f3.cbxTurno.getSelectedItem().toString()));
         
         cat.setFecha(f3.jdchFecha.getDate());
         
         return cat;
     }
    
}//fin clase
