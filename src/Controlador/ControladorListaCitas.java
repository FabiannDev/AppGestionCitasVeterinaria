package Controlador;
//librerias
import DAO.*;
import Formatos.*;
import Vista.*;
import Procesos.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorListaCitas implements ActionListener{
    FrmListaDeCitas vista;
    String consulta="select c.IdCita,p.Nombres,p.Apellidos,p.DNI,m.IdMascota,m.Nombre_mascota,s.NombreServicio,v.NombresVeterinario,c.FechaCita,t.hora,ec.TipoEstado" +
                   " from CITA c"+
                   " inner join propietario p on c.DNI=p.DNI"+
                   " inner join mascota m on c.IdMascota=m.IdMascota"+
                   " inner join servicios s on c.idServicios=s.idServicios"+
                   " inner join veterinario v on c.idVeterinario=v.idVeterinario"+
                   " inner join turno t on c.idTurno=t.idTurno"+
                   " inner join estado_cita ec on c.idEstado=ec.idEstado";
    CRUD_ReservarCita crud;

    public ControladorListaCitas(FrmListaDeCitas f4) {
        vista=f4;
        vista.btnTodos.addActionListener(this);
        vista.btnPendientes.addActionListener(this);
        vista.btnCancelados.addActionListener(this);
        vista.btnTerminados.addActionListener(this);
        vista.btnBuscar.addActionListener(this);
        ActualizarTabla(consulta);
        Procesos.ProcesosListaDeCitas.Presentacion(f4);
    }//fin constructor
    
    void ActualizarTabla(String query){
        crud = new CRUD_ReservarCita();
        crud.MostrarCategoriasEnTabla(vista.tblListaCitas, query);
        ManejadorTablas.FormatoTablaListarCitas(vista.tblListaCitas);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==vista.btnTodos){
            ActualizarTabla(consulta);
        }//fin boton
        
        if(e.getSource()==vista.btnPendientes){
            String query=consulta+" where c.idEstado=1;";
            ActualizarTabla(query);
        }//fin boton
        
        if(e.getSource()==vista.btnCancelados){
            String query=consulta+" where c.idEstado=3;";
            ActualizarTabla(query);
        }//fin boton
        
        if(e.getSource()==vista.btnTerminados){
            String query=consulta+" where c.idEstado=2;";
            ActualizarTabla(query);
        }//fin boton
        
        if(e.getSource()==vista.btnBuscar){
            String query=consulta+" where c.idMascota='"+vista.txtBuscar.getText()+"';";
            ActualizarTabla(query);
            ProcesosListaDeCitas.LimpiarEntradas(vista);
        }//fin boton
        
    }//fin metodo
    
}//fin clase
