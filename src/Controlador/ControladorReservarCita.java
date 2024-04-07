package Controlador;
//librerias
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Modelo.*;
import Vista.*;
import Procesos.*;
import DAO.*;
import Formatos.ManejadorTablas;
import Formatos.Mensajes;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ControladorReservarCita implements ActionListener{
    ReservarCita vista;
    Citas cat;
    Propietarios cat1;
    CRUD_ReservarCita crud;
    CRUD_Propietarios crud1;
    public ControladorReservarCita(ReservarCita f3) {
        vista=f3;
        vista.btnBuscarDatos.addActionListener(this);
        vista.btnCargarVeterinario.addActionListener(this);
        vista.btnConsultarFecha.addActionListener(this);
        vista.btnReservarCita.addActionListener(this);
        vista.btnReprogramar.addActionListener(this);
        vista.btnConsultarCita.addActionListener(this);
        vista.btnCancelarCita.addActionListener(this);
        vista.btnFinalizarCIta.addActionListener(this);
        ActualizarForma();
        Procesos.ProcesosReservarCita.Presentacion(f3);
    }//fin constructor
    
    void ActualizarForma(){
        ProcesosReservarCita.LimpiarEntradas(vista);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==vista.btnBuscarDatos){
           String dni= vista.txtDNI.getText();
           
           vista.cbxMascota.removeAllItems();
           
           crud1=new CRUD_Propietarios();
           cat1=crud1.RecuperarNombre(dni, vista.lblDueño);
           if(cat1==null){
               Mensajes.M1("El nombre "+cat1+" no existe en la tabla categorias...");
           }else{
               vista.lblDueño.setText(cat1.getNombres()+" "+cat1.getApellidos());
               
               vista.txtDNI.requestFocus();
           }
           ActualizarCombos ac = new ActualizarCombos();
           ac.CargarComboxMascotaDNI2(vista.cbxMascota, dni);
       }//fin boton
        
        if(e.getSource()==vista.btnCargarVeterinario){
            String nombre=vista.cbxServicio.getSelectedItem().toString();
            ActualizarCombos ac = new ActualizarCombos();
            ac.CargarComboxVeterinario(vista.cbxVeterinario, nombre);
        }//fin boton
        
        if(e.getSource()==vista.btnConsultarFecha){
            SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
            Date fecha =vista.jdchFecha.getDate();
            String fech=df.format(fecha);
            crud=new CRUD_ReservarCita();
            crud.MostrarCategoriasEnTablaTurno(vista.tblTurnosFecha, fech);
            ManejadorTablas.FormatoTablaFechas(vista.tblTurnosFecha);
        }//fin boton
        
        if(e.getSource()==vista.btnReservarCita){
            cat=ProcesosReservarCita.LeerDatos(vista);
            crud=new CRUD_ReservarCita();
            crud.InsertarCategoria(cat);
            
            ImprimirTickerCita f10=new ImprimirTickerCita();
            ControladorImprimirTicketCita control0=new ControladorImprimirTicketCita(f10);
            vista.jdpnContenedor.add(f10);
            
            ActualizarForma();
        }//fin boton
        
        if(e.getSource()==vista.btnConsultarCita){
           String idcat=Mensajes.M4("Ingrese el nombre a buscar: ");
           crud=new CRUD_ReservarCita();
           cat=crud.RecuperarCategoria(idcat);
           if(cat==null){
               Mensajes.M1("El codigo "+idcat+" no existe en la tabla categorias...");
           }else{
               vista.txtCodigo.setText(cat.getIdCita());
               vista.txtDNI.setText(cat.getDni());
               vista.txaDescripcion.setText(cat.getDescripcion());
               
               AdministrarClaves ac = new AdministrarClaves();
               AdministrarClaves ac1 = new AdministrarClaves();
               AdministrarClaves ac2 = new AdministrarClaves();
               AdministrarClaves ac3 = new AdministrarClaves();
               //ponemos añadir item pq al iniciar estos combox no tienen items
               vista.cbxMascota.addItem(ac.RecuperarCodigo(ac.consultaNomMasco, cat.getIdMascota()));
               vista.cbxServicio.addItem(ac1.RecuperarNombre(ac1.queryServicio, cat.getIdServicios()));
               vista.cbxVeterinario.addItem(ac2.RecuperarCodigo(ac2.consultaNomVeter, cat.getIdVeterinario()));
               //este combo si tiene los items en td momento
               vista.cbxTurno.setSelectedItem(ac3.RecuperarNombre(ac3.queryTurno, cat.getIdTurno()));
               
               vista.jdchFecha.setDate(cat.getFecha());
               
               vista.txtPrecio.setText(Double.toString(cat.getPrecio()));
               ProcesosReservarCita.Estado3(vista);
           }
        }//fin boton
        
        if(e.getSource()==vista.btnCancelarCita){
            cat.setIdCita(vista.txtCodigo.getText());
            crud=new CRUD_ReservarCita();
            crud.CancelarCita(cat);
            ActualizarForma();
        }//fin boton
        
        if(e.getSource()==vista.btnReprogramar){
            cat.setFecha(vista.jdchFecha.getDate());
            AdministrarClaves ac=new AdministrarClaves();
            cat.setIdTurno(ac.RecuperarID(ac.consultaTurno, vista.cbxTurno.getSelectedItem().toString()));
            crud=new CRUD_ReservarCita();
            crud.ReprogramarCita(cat);
        }//fin boton
        
        if(e.getSource()==vista.btnFinalizarCIta){
            cat.setIdCita(vista.txtCodigo.getText());
            crud=new CRUD_ReservarCita();
            crud.TerminarCita(cat);
            
            ImprimirReciboDeCita f11=new ImprimirReciboDeCita();
            vista.jdpnContenedor.add(f11);
            
            f11.reciboCita1.lblCodigo.setText(vista.txtCodigo.getText());
            ControladorImprimirReciboCita control1=new ControladorImprimirReciboCita(f11);
            ActualizarForma();
        }//fin boton
        
    }//fin metodo
    
}//fin clase
