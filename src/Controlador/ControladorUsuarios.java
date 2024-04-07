package Controlador;
//librerias
import DAO.*;
import Formatos.*;
import Modelo.*;
import Procesos.*;
import Vista.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ControladorUsuarios implements ActionListener{
    FrmUsuarios vista;
    CRUD_Usuarios crud;
    Usuarios u;
    
    public ControladorUsuarios(FrmUsuarios f10) {
        vista=f10;
        vista.btnRegistrar.addActionListener(this);
        vista.btnActualizar.addActionListener(this);
        vista.btnConsultar.addActionListener(this);
        vista.btnExcel.addActionListener(this);
        ActualizarForma();
        Procesos.ProcesosUsuarios.Presentacion(f10);
    }//fin constructor
    
    void ActualizarForma(){
         crud = new CRUD_Usuarios();
         crud.MostrarUsuariosEnTabla(vista.tblUsuarios);
         ProcesosUsuarios.Estado1(vista);
         ProcesosUsuarios.LimpiarEntradas(vista);
         ManejadorTablas.FormatoTablaUsuarios(vista.tblUsuarios);
     }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==vista.btnRegistrar){
           u=ProcesosUsuarios.LeerDatos(vista);
           crud=new CRUD_Usuarios();
           crud.InsertarUsuario(u);
           ActualizarForma();
       }
        
        if(e.getSource()==vista.btnConsultar){
           String idcat=Mensajes.M4("Ingrese el id a buscar: ");
           crud=new CRUD_Usuarios();
           u=crud.RecuperarUsuario(idcat);
           if(u==null){
               Mensajes.M1("El id "+idcat+" no existe en la tabla categorias...");
           }else{
               vista.txtId.setText(Integer.toString(u.getIdUsuario()));
               vista.txtClave.setText(u.getClave());
               vista.txtApellidos.setText(u.getApellidos());
               vista.txtNombres.setText(u.getNombres());
               vista.txtCorreo.setText(u.getCorreo());
               
               AdministrarClaves ac = new AdministrarClaves();
               vista.cbxRol.setSelectedItem(ac.RecuperarNombre(ac.queryRol, u.getIdRol()));
               
               vista.spnEstado.setValue(u.getEsActivo());
               
               vista.txtClave.requestFocus();
               ProcesosUsuarios.Estado2(vista);
           }
       }
        
        if(e.getSource()==vista.btnActualizar){
           u=ProcesosUsuarios.LeerDatos(vista);
           u.setIdUsuario(Integer.parseInt(vista.txtId.getText()));
           crud=new CRUD_Usuarios();
           crud.ActualizarUsuario(u);
           ActualizarForma();
       }
        
        if(e.getSource()==vista.btnExcel){
            ExportarExcel obj;

            obj = new ExportarExcel();
            try {
                obj.exportarExcel(vista.tblUsuarios);
            } catch (IOException ex) {
                Logger.getLogger(ControladorUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            }
       }
        
        
    }//fin metodo
    
}//fin clase
