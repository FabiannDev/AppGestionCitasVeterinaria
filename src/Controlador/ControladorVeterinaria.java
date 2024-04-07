package Controlador;
//librerias
import DAO.*;
import Formatos.*;
import Modelo.*;
import Vista.*;
import Procesos.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;

public class ControladorVeterinaria implements ActionListener{
    frmVeterinariaEverpets vista;
    CRUD_VeterinariaEverpets crud;
    VeterinariaEverpets vet;
    
    
    public ControladorVeterinaria(frmVeterinariaEverpets f11) {
        vista=f11;
        vista.btnRegistrar.addActionListener(this);
        vista.btnMostrar.addActionListener(this);
        vista.btnActualizar.addActionListener(this);
        Procesos.ProcesosVeterinaria.Presentacion(f11);
    }//fin constructor

    void ActualizarForma(){
         ProcesosVeterinaria.LimpiarEntradas(vista);
     }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==vista.btnRegistrar){
           vet=ProcesosVeterinaria.LeerDatos(vista);
           crud=new CRUD_VeterinariaEverpets();
           crud.InsertarVeterinaria(vet);
           ActualizarForma();
       }
        
        if(e.getSource()==vista.btnMostrar){
           crud=new CRUD_VeterinariaEverpets();
           vet=crud.RecuperarDatos();
           if(vet==null){
               Mensajes.M1("Aun no se registran datos a la empresa...");
           }else{
               vista.txtRUC.setText(vet.getRUC());
               vista.txtNombre.setText(vet.getNombre());
               vista.txtTelefono.setText(vet.getTelefono());
               vista.txtDireccion.setText(vet.getDireccion());
               // Convertir el arreglo de bytes de la imagen a un ImageIcon
               ImageIcon imagenIcono = new ImageIcon(vet.getImagen());

               // Establecer el ImageIcon en el JLabel
               vista.jImagen.setIcon(imagenIcono);
               
               vista.jtxtBuscarImagen.setText(vet.getRuta());
           }
       }
        
        if(e.getSource()==vista.btnActualizar){
           vet=ProcesosVeterinaria.LeerDatos(vista);
           vet.setRUC(vista.txtRUC.getText());
           crud=new CRUD_VeterinariaEverpets();
           crud.actualizarVeterinaria(vet);
           ActualizarForma();
       }
        
    }//fin metodo
    
}//fin clase
