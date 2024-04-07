package Controlador;
//librerias
import Modelo.*;
import Vista.*;
import DAO.*;
import Procesos.ProcesosImprimirCarnetMascota;
import Procesos.ProcesosImprimirTickerCita;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import javax.swing.JOptionPane;

public class ControladorImprimirTicketCita implements ActionListener{
    ImprimirTickerCita vista;
    CRUD_ReservarCita crud;
    
    public ControladorImprimirTicketCita(ImprimirTickerCita f10){
        vista=f10;
        vista.btnImprimir.addActionListener(this);
        Procesos.ProcesosImprimirTickerCita.Presentacion(f10);
        Inicio();
    }
    
    void Inicio(){
        crud= new CRUD_ReservarCita();
        crud.CargarCodigoTicket(vista.ticker1.lblCodigo);
        
        String codigo=vista.ticker1.lblCodigo.getText();
        crud.DatosTicket(codigo, vista.ticker1.lblFecha, vista.ticker1.lblHorarioEstablecido);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==vista.btnImprimir){
            PrinterJob job=PrinterJob.getPrinterJob();
            job.setPrintable(vista.ticker1);
            
            if(job.printDialog()){
                try{
                    job.print();
                }catch(PrinterException ex){
                    
                }
            }else{
                JOptionPane.showMessageDialog(null, "La impresion se cancelo");
            }
            ProcesosImprimirTickerCita.LimpiarEntradasCarnet(vista.ticker1);
        }//fin boton
        
    }//fin metodo
    
}//fin clase
