package Principal;
//libreria
import Vista.*;
import Controlador.*;

public class Main {
    public static FrmDueñosdeMascota f1;
    public static ControladorDueñosDeMascota controlf1;
    
    public static FrmLogin fl;
    public static ControladorLogin controlL;
    
     public static void main(String[] args) {
       
       fl=new FrmLogin();
       controlL=new ControladorLogin(fl);
       
    }
}//fin clase
