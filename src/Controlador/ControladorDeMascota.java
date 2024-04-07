package Controlador;
//librerias
import DAO.*;
import Formatos.*;
import Modelo.*;
import Vista.*;
import Procesos.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorDeMascota implements ActionListener{
    FrmDeMascotas vista;
    CRUD_Mascotas crud;
    CRUD_Propietarios crud1;
    Mascotas cat;
    Propietarios cat1;

    public ControladorDeMascota(FrmDeMascotas f2) {
        vista=f2;
        vista.btnRegistrar.addActionListener(this);
        vista.btnActualizar.addActionListener(this);
        vista.btnConsultar.addActionListener(this);
        vista.btnBuscar.addActionListener(this);
        ActualizarForma();
        Procesos.ProcesosDeMascotas.Presentacion(f2);
    }//fin constructor
    
    void ActualizarForma(){
         crud = new CRUD_Mascotas();
         crud.MostrarCategoriasEnTabla(vista.tblMascotas);
         ProcesosDeMascotas.Estado1(vista);
         ProcesosDeMascotas.LimpiarEntradas(vista);
         ManejadorTablas.FormatoTablaMascotas(vista.tblMascotas);
     }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==vista.btnRegistrar){
           cat=ProcesosDeMascotas.LeerDatos(vista);
           crud=new CRUD_Mascotas();
           crud.InsertarCategoria(cat);
           ActualizarForma();
       }
        
        if(e.getSource()==vista.btnConsultar){
           String idcat=Mensajes.M4("Ingrese el id a buscar: ");
           crud=new CRUD_Mascotas();
           cat=crud.RecuperarCategoria(idcat);
           if(cat==null){
               Mensajes.M1("El id "+idcat+" no existe en la tabla categorias...");
           }else{
               vista.txtCodigo.setText(cat.getIdMascota());
               vista.txtNombre.setText(cat.getNombreM());
               vista.txtPeso.setText(Double.toString(cat.getPesoM()));
               vista.txtDNIpropietario.setText(cat.getDniP());
               
               vista.cbxSexoMascota.setSelectedItem(cat.getSexoM());
               
               AdministrarClaves ac = new AdministrarClaves();
               vista.cbxTipoMascota.setSelectedItem(ac.RecuperarNombre(ac.queryTipoMasc, cat.getTipoM()));
               
               vista.spnEdad.setValue(cat.getEdadM());
               
               vista.txtNombre.requestFocus();
               ProcesosDeMascotas.Estado2(vista);
           }
       }
        
        if(e.getSource()==vista.btnActualizar){
           cat=ProcesosDeMascotas.LeerDatos(vista);
           cat.setIdMascota(vista.txtCodigo.getText());
           crud=new CRUD_Mascotas();
           crud.ActualizarCategoria(cat);
           ActualizarForma();
       }
        
        
        if(e.getSource()==vista.btnBuscar){
           String dni= vista.txtDNIpropietario.getText();
           crud1=new CRUD_Propietarios();
           cat1=crud1.RecuperarNombre(dni, vista.lblDueño);
           if(cat1==null){
               Mensajes.M1("El nombre "+cat1+" no existe en la tabla categorias...");
           }else{
               vista.lblDueño.setText(cat1.getNombres()+" "+cat1.getApellidos());
               vista.txtDNIpropietario.requestFocus();
           }
       }
        
    }//fin metodo
    
}//fin clase
