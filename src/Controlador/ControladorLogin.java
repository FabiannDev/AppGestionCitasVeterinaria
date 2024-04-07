package Controlador;
//librerias
import DAO.*;
import Formatos.*;
import Modelo.*;
import Vista.*;
import Procesos.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

public class ControladorLogin implements ActionListener{
    FrmLogin vista;
    CRUD_Login crud = new CRUD_Login();
    FormularioMenu fm;
    ControladorMenu controlfm;
    Usuarios u;
    
    public ControladorLogin(FrmLogin fl) {
        vista=fl;
        vista.btnLogin.addActionListener(this);
        vista.btnCancelar.addActionListener(this);
        vista.txtNombre.addActionListener(this); // Agrega ActionListener a txtNombre
        vista.txtContraseña.addActionListener(this); // Agrega ActionListener a txtContraseña
        ActualizarForma();
        Procesos.ProcesosLogin.Presentacion(fl);
    }//fin constructor
    
    void ActualizarForma(){
         ProcesosLogin.LimpiarEntradas(vista);
     }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == vista.btnLogin || e.getSource() == vista.txtNombre || e.getSource() == vista.txtContraseña) {
            login();
        }//fin boton
        
        
        if(e.getSource()==vista.btnCancelar){
           this.vista.dispose();
        }//fin boton
        
        
    }//fin metodo
    
    private void login() {
        String usuario = vista.txtNombre.getText();
        String clave = String.valueOf(vista.txtContraseña.getPassword()); 
        if (usuario.equals("") || clave.equals("")) {
            JOptionPane.showMessageDialog(null, "Los campos están vacíos");
        } else {
            u = crud.login(usuario, clave);
            if (u.getNombres() != null) {
                fm = new FormularioMenu();
                switch (u.getIdRol()) {
                    case 2: 
                        fm.mitemTurnosCita.setEnabled(false);
                        fm.mitemTurnosCita.setVisible(false);
                        fm.mitemMantenimientoServicioMascotas.setEnabled(false);
                        fm.mitemMantenimientoServicioMascotas.setVisible(false);
                        fm.jAdministracion.setEnabled(false);
                        fm.jAdministracion.setVisible(false);
                        break;
                    case 3:
                        fm.jMenuConfiguracion.setEnabled(false);
                        fm.jMenuConfiguracion.setVisible(false);
                        fm.jAdministracion.setEnabled(false);
                        fm.jAdministracion.setVisible(false);
                        break;
                }
                controlfm = new ControladorMenu(fm);
                vista.dispose();
            } else {
                Mensajes.M1("Datos incorrectos");
                ProcesosLogin.LimpiarEntradas(vista);
            }
        }
    }//fin metodo
    
    
}//fin clase
