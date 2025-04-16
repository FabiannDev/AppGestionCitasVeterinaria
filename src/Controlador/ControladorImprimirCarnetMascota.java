package Controlador;
//librerias
import DAO.*;
import Formatos.*;
import Modelo.*;
import Vista.*;
import Procesos.*;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.awt.print.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;


public class ControladorImprimirCarnetMascota implements ActionListener{
    ImprimirCarnetMascota vista;
    CRUD_Mascotas crud;
    CRUD_Carnet crud2;
    CRUD_Propietarios crud1;
    Mascotas cat;
    Propietarios cat1;
    CarnetClass car;
    
    public ControladorImprimirCarnetMascota(ImprimirCarnetMascota f5) {
        vista=f5;
        vista.btnMostrarDatos.addActionListener(this);
        vista.btnSeleccionarImagen.addActionListener(this);
        vista.btnGenerarImprimir.addActionListener(this);
        vista.btnImprimir.addActionListener(this);
        Procesos.ProcesosImprimirCarnetMascota.Presentacion(f5);
        ProcesosImprimirCarnetMascota.BotonesAlIniciar(vista);
        
        //Deshabilitar boton de imprimir al inicio
        vista.btnGenerarImprimir.setEnabled(false);
    }//fin constructor
    
    void ActualizarForma(){
         crud = new CRUD_Mascotas();
         ProcesosImprimirCarnetMascota.LimpiarEntradas(vista);
         ProcesosImprimirCarnetMascota.LimpiarEntradasCarnet(vista.carnet1);
         //Deshabilitar boton de imprimir al inicio
         vista.btnGenerarImprimir.setEnabled(false);
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
                ImageIcon mIcono = new ImageIcon(mImage.getScaledInstance(vista.carnet1.lblImagenMascota.getWidth(), 
                        vista.carnet1.lblImagenMascota.getHeight(), Image.SCALE_SMOOTH));
                vista.carnet1.lblImagenMascota.setIcon(mIcono);
            }
       }//fin boton
        
        if(e.getSource()==vista.btnMostrarDatos){
           String id= vista.txtCodigo.getText();
           crud=new CRUD_Mascotas();
           cat=crud.DatosCarnetM(id, vista.carnet1.lblCodigo,vista.carnet1.lblDNI,vista.carnet1.lblMascota,
                   vista.carnet1.lblTipo,vista.carnet1.lblSexo);
           if(cat==null){
               Mensajes.M1("No existe ninguna mascota con el codigo "+cat);
           }else{
               AdministrarClaves ac = new AdministrarClaves();
               AdministrarClaves ac1 = new AdministrarClaves();
               
               vista.carnet1.lblCodigo.setText(cat.getIdMascota());
               vista.carnet1.lblMascota.setText(cat.getNombreM());
               
               vista.carnet1.lblDNI.setText(ac.RecuperarNombre(ac.queryDNI, cat.getpropietarioM()));
               vista.carnet1.lblTipo.setText(ac1.RecuperarNombre(ac1.queryTipoMasc, cat.getTipoM()));
               
               vista.carnet1.lblSexo.setText(cat.getSexoM());
               
               //Habilitar boton de imprimir al inicio
               vista.btnGenerarImprimir.setEnabled(true);
           }
           
           crud1=new CRUD_Propietarios();
           String dni=vista.carnet1.lblDNI.getText();
           cat1=crud1.DatosCatnetP(dni, vista.carnet1.lblDueño, vista.carnet1.lblDireccion, vista.carnet1.lblTelefono);
           vista.carnet1.lblDueño.setText(cat1.getNombres()+" "+cat1.getApellidos());
           vista.carnet1.lblDireccion.setText(cat1.getDireccion());
           vista.carnet1.lblTelefono.setText(cat1.getTelefono());
           vista.txtCodigo.requestFocus();
       
       }//fin boton
        
        if(e.getSource()==vista.btnGenerarImprimir){
            // Recuperar el ID de la mascota
            String idMascota = vista.txtCodigo.getText();

            // Recuperar la imagen del JLabel
            ImageIcon iconoImagen = (ImageIcon) vista.carnet1.lblImagenMascota.getIcon();
            byte[] imagenBytes = null;

            // Convertir la imagen a un arreglo de bytes
            if (iconoImagen != null) {
                Image image = iconoImagen.getImage();
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                try {
                    // Convertir a byte[]
                    BufferedImage bufferedImage = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_ARGB);
                    Graphics g = bufferedImage.createGraphics();
                    g.drawImage(image, 0, 0, null);
                    g.dispose();
                    ImageIO.write(bufferedImage, "png", baos);
                    imagenBytes = baos.toByteArray();
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Error al convertir la imagen: " + ex.getMessage());
                }
            }

            // Crear objeto Carnet
            car = new CarnetClass();
            car.setIdMascota(idMascota);
            car.setImagen(imagenBytes);

            // Insertar el carnet en la base de datos
            crud2 = new CRUD_Carnet();
            crud2.InsertarCarnet(car);
            
            //Metodo para imprimir
            PrinterJob job=PrinterJob.getPrinterJob();
            job.setPrintable(vista.carnet1);
            
            if(job.printDialog()){
                try{
                    job.print();
                    ActualizarForma();
                }catch(PrinterException ex){
                    
                }
            }else{
                JOptionPane.showMessageDialog(null, "La impresion se cancelo");
            }
            ProcesosImprimirCarnetMascota.LimpiarEntradas(vista);
            ProcesosImprimirCarnetMascota.LimpiarEntradasCarnet(vista.carnet1);
        }//fin boton
        
        if(e.getSource()==vista.btnImprimir){
            //Metodo para imprimir
            PrinterJob job=PrinterJob.getPrinterJob();
            job.setPrintable(vista.carnet1);
            
            if(job.printDialog()){
                try{
                    job.print();
                    ActualizarForma();
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
