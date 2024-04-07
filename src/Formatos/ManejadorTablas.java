
package Formatos;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
public class ManejadorTablas {
    
    //Metodo que especifica un ancho de las columnas de tabla    
    public static void AnchoColumnas(JTable t, int numcolumna,int ancho) {
        TableColumn column;
        column = t.getColumnModel().getColumn(numcolumna);
        column.setPreferredWidth(ancho);       
    }
    
    //metodo que justifica los datos de una columna
   public static void JustificarCelda(JTable t,int numcolumna){
       DefaultTableCellRenderer modelocentrar = new DefaultTableCellRenderer();
       modelocentrar.setHorizontalAlignment(SwingConstants.CENTER);
       t.getColumnModel().getColumn(numcolumna).setCellRenderer(modelocentrar);       
   }
   
   //metodo que la da formato a la JTable 
   public static void FormatoTablaCategorias(JTable tabla){
       AnchoColumnas(tabla,0,100);
       JustificarCelda(tabla,0);
       AnchoColumnas(tabla,1,100);
       JustificarCelda(tabla,1);
       AnchoColumnas(tabla,2,250);     
   }
   
   //metodo que la da formato a la JTable 
   public static void FormatoTablaVeterinarios(JTable tabla){
       AnchoColumnas(tabla,0,80);
       JustificarCelda(tabla,0);
       AnchoColumnas(tabla,1,150);
       JustificarCelda(tabla,1);
       AnchoColumnas(tabla,2,260);
       AnchoColumnas(tabla,3,260);
       AnchoColumnas(tabla,4,200);
       JustificarCelda(tabla,4);
       AnchoColumnas(tabla,5,200);
       JustificarCelda(tabla,5);
       AnchoColumnas(tabla,6,300);
       JustificarCelda(tabla,6);
   }
   
   //metodo que la da formato a la JTable 
   public static void FormatoServicioVeterinaria(JTable tabla){
       AnchoColumnas(tabla,0,70);
       JustificarCelda(tabla,0);
       AnchoColumnas(tabla,1,70);
       JustificarCelda(tabla,1);
       AnchoColumnas(tabla,2,260);
       AnchoColumnas(tabla,3,120);
       JustificarCelda(tabla,3);
       AnchoColumnas(tabla,4,100);
       JustificarCelda(tabla,4);
   }
   
   //metodo que la da formato a la JTable 
   public static void FormatoTablaSacarCitas(JTable tabla){
       AnchoColumnas(tabla,0,80);
       JustificarCelda(tabla,0);
       AnchoColumnas(tabla,1,80);
       JustificarCelda(tabla,1);
       AnchoColumnas(tabla,2,180);
       AnchoColumnas(tabla,3,180);
       AnchoColumnas(tabla,4,200);
       AnchoColumnas(tabla,5,200);
       AnchoColumnas(tabla,6,140);
       JustificarCelda(tabla,6);
       AnchoColumnas(tabla,7,180);
       JustificarCelda(tabla,7);
   }
   
   //metodo que la da formato a la JTable 
   public static void FormatoTablaTurnos(JTable tabla){
       AnchoColumnas(tabla,0,80);
       JustificarCelda(tabla,0);
       AnchoColumnas(tabla,1,80);
       JustificarCelda(tabla,1);
       AnchoColumnas(tabla,2,200);
       JustificarCelda(tabla,2);
       AnchoColumnas(tabla,3,250);
       JustificarCelda(tabla,3);
   }
   
   //metodo que la da formato a la JTable 
   public static void FormatoTablaFechas(JTable tabla){
       AnchoColumnas(tabla,0,40);
       JustificarCelda(tabla,0);
       AnchoColumnas(tabla,1,90);
       JustificarCelda(tabla,1);
       AnchoColumnas(tabla,2,90);
       JustificarCelda(tabla,2);
       AnchoColumnas(tabla,3,90);
       JustificarCelda(tabla,3);
       AnchoColumnas(tabla,4,90);
       JustificarCelda(tabla,4);
   }
   
   //metodo que la da formato a la JTable 
   public static void FormatoTablaDueños(JTable tabla){
       AnchoColumnas(tabla,0,80);
       JustificarCelda(tabla,0);
       AnchoColumnas(tabla,1,150);
       JustificarCelda(tabla,1);
       AnchoColumnas(tabla,2,260);
       AnchoColumnas(tabla,3,260);
       AnchoColumnas(tabla,4,220);
       JustificarCelda(tabla, 4);
       AnchoColumnas(tabla,5,180);
       JustificarCelda(tabla,5);
       AnchoColumnas(tabla,6,300);
       JustificarCelda(tabla,6);
   }
   
   //metodo que la da formato a la JTable 
   public static void FormatoTablaUsuarios(JTable tabla){
       AnchoColumnas(tabla,0,40);
       JustificarCelda(tabla,0);
       AnchoColumnas(tabla,1,50);
       JustificarCelda(tabla,1);
       AnchoColumnas(tabla,2,100);
       AnchoColumnas(tabla,3,100);
       AnchoColumnas(tabla,4,200);
       JustificarCelda(tabla, 4);
       AnchoColumnas(tabla,5,80);
       JustificarCelda(tabla,5);
       AnchoColumnas(tabla,6,100);
       JustificarCelda(tabla,6);
       AnchoColumnas(tabla,7,100);
       JustificarCelda(tabla,7);
   }
   
   //metodo que la da formato a la JTable 
   public static void FormatoTablaMascotas(JTable tabla){
       AnchoColumnas(tabla,0,80);
       JustificarCelda(tabla,0);
       AnchoColumnas(tabla,1,150);
       JustificarCelda(tabla,1);
       AnchoColumnas(tabla,2,200);
       JustificarCelda(tabla,2);
       AnchoColumnas(tabla,3,150);
       JustificarCelda(tabla,3);
       AnchoColumnas(tabla,4,90);
       JustificarCelda(tabla,4);
       AnchoColumnas(tabla,5,90);
       JustificarCelda(tabla,5);
       AnchoColumnas(tabla,6,90);
       JustificarCelda(tabla,6);
       AnchoColumnas(tabla,7,150);
       JustificarCelda(tabla,7);
   }
   
   //metodo que la da formato a la JTable 
   public static void FormatoTablaListarCitas(JTable tabla){
       AnchoColumnas(tabla,0,80);
       JustificarCelda(tabla,0);
       AnchoColumnas(tabla,1,150);
       JustificarCelda(tabla,1);
       AnchoColumnas(tabla,2,340);
       AnchoColumnas(tabla,3,160);
       JustificarCelda(tabla,3);
       AnchoColumnas(tabla,4,160);
       JustificarCelda(tabla,4);
       AnchoColumnas(tabla,5,180);
       JustificarCelda(tabla, 5);
       AnchoColumnas(tabla,6,250);
       AnchoColumnas(tabla,7,180);
       JustificarCelda(tabla,7);
       AnchoColumnas(tabla,8,150);
       JustificarCelda(tabla,8);
       AnchoColumnas(tabla,9,150);
       JustificarCelda(tabla,9);
       AnchoColumnas(tabla,10,150);
       JustificarCelda(tabla,10);
   }
   
}//fin clase
