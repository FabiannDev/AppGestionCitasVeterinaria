package Controlador;
//librerias
import DAO.CRUD_TiposMascotas;
import Formatos.ManejadorTablas;
import Formatos.Mensajes;
import Modelo.*;
import Vista.*;
import Procesos.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorTiposMascota implements ActionListener{
    FrmTiposMascota vista;
    CRUD_TiposMascotas crud;
    TiposMascotas cat;
    
    public ControladorTiposMascota(FrmTiposMascota f9) {
        vista=f9;
        vista.btnRegistrar.addActionListener(this);
        vista.btnActualizar.addActionListener(this);
        vista.btnConsultar.addActionListener(this);
        vista.btnDeshabilitar.addActionListener(this);
        ActualizarForma();
        Procesos.ProcesosTiposMascota.Presentacion(f9);
    }//fin constructor
    
    void ActualizarForma(){
         crud = new CRUD_TiposMascotas();
         crud.MostrarCategoriasEnTabla(vista.tblTiposMascota);
         ProcesosTiposMascota.Estado1(vista);
         ProcesosTiposMascota.LimpiarEntradas(vista);
         ManejadorTablas.FormatoTablaCategorias(vista.tblTiposMascota);
     }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==vista.btnRegistrar){
           cat=ProcesosTiposMascota.LeerDatos(vista);
           crud=new CRUD_TiposMascotas();
           crud.InsertarCategoria(cat);
           ActualizarForma();
       }
        
        if(e.getSource()==vista.btnConsultar){
           int idcat=Mensajes.M2("Ingrese el id de la categoria a buscar: ");
           crud=new CRUD_TiposMascotas();
           cat=crud.RecuperarCategoria(idcat);
           if(cat==null){
               Mensajes.M1("El id "+idcat+" no existe en la tabla categorias...");
           }else{
               vista.txtID.setText(Integer.toString(cat.getIdTipo()));
               vista.txtNombre.setText(cat.getNombre());
               vista.txtNombre.requestFocus();
               ProcesosTiposMascota.Estado2(vista);
           }
       }
        
        if(e.getSource()==vista.btnActualizar){
           cat=ProcesosTiposMascota.LeerDatos(vista);
           cat.setIdTipo(Integer.parseInt(vista.txtID.getText()));
           crud=new CRUD_TiposMascotas();
           crud.ActualizarCategoria(cat);
           ActualizarForma();
       }
        
        if(e.getSource()==vista.btnDeshabilitar){
           int respuesta=Mensajes.M3("confirma!!!", "¿Deseas eliminar el registro(0)...?");
           if(respuesta==0){
               int idcat=Integer.parseInt(vista.txtID.getText());
               crud=new CRUD_TiposMascotas();
               crud.InhabilitarCategoria(idcat);
               ActualizarForma();
           }
       }
        
    }//fin metodo
    
}//fin clase
