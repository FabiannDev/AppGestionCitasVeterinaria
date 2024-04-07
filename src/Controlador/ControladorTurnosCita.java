package Controlador;
//librerias
import DAO.*;
import Formatos.*;
import Modelo.*;
import Vista.*;
import Procesos.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorTurnosCita implements ActionListener{
    FrmTurnosCita vista;
    CRUD_Turnos crud;
    Turno cat;
    
    public ControladorTurnosCita(FrmTurnosCita f6) {
        vista=f6;
        vista.btnRegistrar.addActionListener(this);
        vista.btnActualizar.addActionListener(this);
        vista.btnConsultar.addActionListener(this);
        vista.btnDeshabilitar.addActionListener(this);
        ActualizarForma();
        Procesos.ProcesosTurnosCita.Presentacion(f6);
    }//fin constructor
    
    void ActualizarForma(){
         crud = new CRUD_Turnos();
         crud.MostrarCategoriasEnTabla(vista.tblTurnos);
         ProcesosTurnosCita.Estado1(vista);
         ProcesosTurnosCita.LimpiarEntradas(vista);
         ManejadorTablas.FormatoTablaTurnos(vista.tblTurnos);
     }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
       if(e.getSource()==vista.btnRegistrar){
           cat=ProcesosTurnosCita.LeerDatos(vista);
           crud=new CRUD_Turnos();
           crud.InsertarCategoria(cat);
           ActualizarForma();
       }
       
       if(e.getSource()==vista.btnConsultar){
           int idcat=Mensajes.M2("Ingrese el id a buscar: ");
           crud=new CRUD_Turnos();
           cat=crud.RecuperarCategoria(idcat);
           if(cat==null){
               Mensajes.M1("El id "+idcat+" no existe en la tabla categorias...");
           }else{
               vista.txtID.setText(Integer.toString(cat.getIdTurno()));
               vista.txtTurno.setText(cat.getHora());
               vista.txtDuracion.setText(cat.getDesripcion());
               vista.txtTurno.requestFocus();
               ProcesosTurnosCita.Estado2(vista);
           }
       }
       
       if(e.getSource()==vista.btnActualizar){
           cat=ProcesosTurnosCita.LeerDatos(vista);
           cat.setIdTurno(Integer.parseInt(vista.txtID.getText()));
           crud=new CRUD_Turnos();
           crud.ActualizarCategoria(cat);
           ActualizarForma();
       }
       
       if(e.getSource()==vista.btnDeshabilitar){
           int respuesta=Mensajes.M3("confirma!!!", "¿Deseas eliminar el registro(0)...?");
           if(respuesta==0){
               int idcat=Integer.parseInt(vista.txtID.getText());
               crud=new CRUD_Turnos();
               crud.InhabilitarCategoria(idcat);
               ActualizarForma();
           }
       }
       
    }//fin metodo
    
}//fin clase
