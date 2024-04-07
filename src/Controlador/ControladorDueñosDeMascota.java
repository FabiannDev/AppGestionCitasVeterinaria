package Controlador;
//librerias
import Vista.*;
import Formatos.*;
import Procesos.*;
import Modelo.*;
import DAO.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorDueñosDeMascota implements ActionListener{
    FrmDueñosdeMascota vista;
    CRUD_Propietarios crud;
    Propietarios cat;

    public ControladorDueñosDeMascota(FrmDueñosdeMascota f1) {
        vista=f1;
        vista.btnRegistrar.addActionListener(this);
        vista.btnActualizar.addActionListener(this);
        vista.btnConsultar.addActionListener(this);
        ActualizarForma();
        Procesos.ProcesosDueñosMascotas.Presentacion(f1);
    }//fin constructor
    
    void ActualizarForma(){
         crud = new CRUD_Propietarios();
         crud.MostrarCategoriasEnTabla(vista.tblPropietarios);
         ProcesosDueñosMascotas.Estado1(vista);
         ProcesosDueñosMascotas.LimpiarEntradas(vista);
         ManejadorTablas.FormatoTablaDueños(vista.tblPropietarios);
     }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==vista.btnRegistrar){
           cat=ProcesosDueñosMascotas.LeerDatos(vista);
           crud=new CRUD_Propietarios();
           crud.InsertarCategoria(cat);
           ActualizarForma();
       }
        
        if(e.getSource()==vista.btnConsultar){
           String idcat=Mensajes.M4("Ingrese el DNI a buscar: ");
           crud=new CRUD_Propietarios();
           cat=crud.RecuperarCategoria(idcat);
           if(cat==null){
               Mensajes.M1("El DNI "+idcat+" no existe en la tabla categorias...");
           }else{
               vista.txtDNI.setText(cat.getDNI());
               vista.txtNombres.setText(cat.getNombres());
               vista.txtApellidos.setText(cat.getApellidos());
               vista.txtDireccion.setText(cat.getDireccion());
               vista.txtTelefono.setText(cat.getTelefono());
               vista.txtCorreo.setText(cat.getCorreo());
               vista.txtDNI.requestFocus();
               ProcesosDueñosMascotas.Estado2(vista);
           }
       }
        
        if(e.getSource()==vista.btnActualizar){
           cat=ProcesosDueñosMascotas.LeerDatos(vista);
           crud=new CRUD_Propietarios();
           crud.ActualizarCategoria(cat);
           ActualizarForma();
       }
        
    }//fin metodo
    
}//fin clase
