package Controlador;
//librerias
import DAO.*;
import Formatos.*;
import Modelo.*;
import Vista.*;
import Procesos.*;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import javax.swing.*;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;


public class ControladorImprimirCarnetMascota implements ActionListener{
    ImprimirCarnetMascota vista;
    CRUD_Mascotas crud;
    CRUD_Propietarios crud1;
    Mascotas cat;
    Propietarios cat1;
    
    public ControladorImprimirCarnetMascota(ImprimirCarnetMascota f5) {
        vista=f5;
        vista.btnMostrarDatos.addActionListener(this);
        vista.btnSeleccionarImagen.addActionListener(this);
        vista.btnImprimir.addActionListener(this);
        Procesos.ProcesosImprimirCarnetMascota.Presentacion(f5);
    }//fin constructor
    
    void ActualizarForma(){
         crud = new CRUD_Mascotas();
         ProcesosImprimirCarnetMascota.LimpiarEntradas(vista);
         ProcesosImprimirCarnetMascota.LimpiarEntradasCarnet(vista.carnet1);
     }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==vista.btnSeleccionarImagen){
            //metodo para seleccionar imagen del equipo y ponerlo en un lbl 
            String Ruta="";
            
            JFileChooser jFileChooser = new JFileChooser();
            FileNameExtensionFilter filtrado = new FileNameExtensionFilter("JPG, PNG & GIF", "jpg","png","gif");
            jFileChooser.setFileFilter(filtrado);
            
            int respuesta=jFileChooser.showOpenDialog(vista);
            
            if(respuesta==JFileChooser.APPROVE_OPTION){
                Ruta=jFileChooser.getSelectedFile().getPath();
                
                Image mImage = new ImageIcon(Ruta).getImage();
                ImageIcon mIcono = new ImageIcon(mImage.getScaledInstance(vista.carnet1.lblImagenMascota.getWidth(), vista.carnet1.lblImagenMascota.getHeight(), Image.SCALE_SMOOTH));
                vista.carnet1.lblImagenMascota.setIcon(mIcono);
            }
       }//fin boton
        
        if(e.getSource()==vista.btnMostrarDatos){
           String id= vista.txtCodigo.getText();
           crud=new CRUD_Mascotas();
           cat=crud.DatosCarnetM(id, vista.carnet1.lblCodigo,vista.carnet1.lblDNI,vista.carnet1.lblMascota,vista.carnet1.lblTipo,vista.carnet1.lblSexo);
           if(cat==null){
               Mensajes.M1("No existe ninguna mascota con el codigo "+cat);
           }else{
               vista.carnet1.lblCodigo.setText(cat.getIdMascota());
               vista.carnet1.lblDNI.setText(cat.getDniP());
               vista.carnet1.lblMascota.setText(cat.getNombreM());
               
               AdministrarClaves ac = new AdministrarClaves();
               vista.carnet1.lblTipo.setText(ac.RecuperarNombre(ac.queryTipoMasc, cat.getTipoM()));
               
               vista.carnet1.lblSexo.setText(cat.getSexoM());
           }
           
           crud1=new CRUD_Propietarios();
           String dni=vista.carnet1.lblDNI.getText();
           cat1=crud1.DatosCatnetP(dni, vista.carnet1.lblDueño, vista.carnet1.lblDireccion, vista.carnet1.lblTelefono);
           vista.carnet1.lblDueño.setText(cat1.getNombres()+" "+cat1.getApellidos());
           vista.carnet1.lblDireccion.setText(cat1.getDireccion());
           vista.carnet1.lblTelefono.setText(cat1.getTelefono());
           vista.txtCodigo.requestFocus();
       
       }//fin boton
        
        if(e.getSource()==vista.btnImprimir){
            PrinterJob job=PrinterJob.getPrinterJob();
            job.setPrintable(vista.carnet1);
            
            if(job.printDialog()){
                try{
                    job.print();
                }catch(PrinterException ex){
                    
                }
            }else{
                JOptionPane.showMessageDialog(null, "La impresion se cancelo");
            }
            ProcesosImprimirCarnetMascota.LimpiarEntradas(vista);
            ProcesosImprimirCarnetMascota.LimpiarEntradasCarnet(vista.carnet1);
        }//fin boton
        
        
    }//fin metodo
    
}//fin clase
