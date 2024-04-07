package Controlador;
//librerias
import DAO.*;
import Formatos.*;
import Modelo.*;
import Vista.*;
import Procesos.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import javax.swing.JOptionPane;

public class ControladorImprimirReciboCita implements ActionListener{
    ImprimirReciboDeCita vista;
    CRUD_ReservarCita crud;
    
    public ControladorImprimirReciboCita(ImprimirReciboDeCita f11){
        vista=f11;
        vista.btnImprimir.addActionListener(this);
        Procesos.ProcesosImprimirReciboDeCita.Presentacion(f11);
        Inicio();
    }
    
    void Inicio(){
        crud= new CRUD_ReservarCita();
        
        String id=vista.reciboCita1.lblCodigo.getText();
        crud.DatosRecibo(id, vista.reciboCita1.lblNombres, vista.reciboCita1.lblDNI, vista.reciboCita1.lblCodMascota, vista.reciboCita1.lblMascota, vista.reciboCita1.lblServicio, vista.reciboCita1.lblVeterinario, vista.reciboCita1.lblFecha, vista.reciboCita1.lblHora, vista.reciboCita1.lblPrecio);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==vista.btnImprimir){
            PrinterJob job=PrinterJob.getPrinterJob();
            job.setPrintable(vista.reciboCita1);
            
            if(job.printDialog()){
                try{
                    job.print();
                }catch(PrinterException ex){
                    
                }
            }else{
                JOptionPane.showMessageDialog(null, "La impresion se cancelo");
            }
            ProcesosImprimirReciboDeCita.LimpiarEntradasRecibo(vista.reciboCita1);
        }//fin boton
        
    }//fin metodo
    
}//fin clase
