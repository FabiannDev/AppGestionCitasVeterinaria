package Controlador;
//librerias
import DAO.*;
import Vista.*;
import Procesos.*;
import Modelo.*;
import Formatos.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorServiciosVeterinaria implements ActionListener{
    FrmServiciosVeterinaria vista;
    CRUD_ServiciosVeterinaria crud;
    ServicioDeVeterinaria cat;

    public ControladorServiciosVeterinaria(FrmServiciosVeterinaria f8) {
        vista=f8;
        vista.btnRegistrar.addActionListener(this);
        vista.btnConsultar.addActionListener(this);
        vista.btnActualizar.addActionListener(this);
        vista.btnDeshabilitar.addActionListener(this);
        ActualizarForma();
        Procesos.ProcesosServiciosVeterinaria.Presentacion(f8);
    }//fin constructor
    
    void ActualizarForma(){
         crud = new CRUD_ServiciosVeterinaria();
         crud.MostrarCategoriasEnTabla(vista.tblServicioMascota);
         ProcesosServiciosVeterinaria.Estado1(vista);
         ProcesosServiciosVeterinaria.LimpiarEntradas(vista);
         ManejadorTablas.FormatoServicioVeterinaria(vista.tblServicioMascota);
     }//fin metodo
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==vista.btnRegistrar){
           cat=ProcesosServiciosVeterinaria.LeerDatos(vista);
           crud=new CRUD_ServiciosVeterinaria();
           crud.InsertarCategoria(cat);
           ActualizarForma();
       }
        
        if(e.getSource()==vista.btnConsultar){
           int idcat=Mensajes.M2("Ingrese el id de la categoria a buscar: ");
           crud=new CRUD_ServiciosVeterinaria();
           cat=crud.RecuperarCategoria(idcat);
           if(cat==null){
               Mensajes.M1("El id "+idcat+" no existe en la tabla categorias...");
           }else{
               vista.txtID.setText(Integer.toString(cat.getIdServicio()));
               vista.txtNombre.setText(cat.getNombreServicio());
               
               AdministrarClaves ac = new AdministrarClaves();
               vista.cbxTipoMascota.setSelectedItem(ac.RecuperarNombre(ac.queryTipoMasc, cat.getIdTipoMascota()));
               
               vista.txtPrecio.setText(Double.toString(cat.getPrecio()));
               vista.txtNombre.requestFocus();
               ProcesosServiciosVeterinaria.Estado2(vista);
           }
       }
        
        if(e.getSource()==vista.btnActualizar){
           cat=ProcesosServiciosVeterinaria.LeerDatos(vista);
           cat.setIdServicio(Integer.parseInt(vista.txtID.getText()));
           crud=new CRUD_ServiciosVeterinaria();
           crud.ActualizarCategoria(cat);
           ActualizarForma();
       }
        
        if(e.getSource()==vista.btnDeshabilitar){
           int respuesta=Mensajes.M3("confirma!!!", "¿Deseas eliminar el registro(0)...?");
           if(respuesta==0){
               int idcat=Integer.parseInt(vista.txtID.getText());
               crud=new CRUD_ServiciosVeterinaria();
               crud.InhabilitarCategoria(idcat);
               ActualizarForma();
           }
       }
        
    }//fin metodo
    
}//fin clase
