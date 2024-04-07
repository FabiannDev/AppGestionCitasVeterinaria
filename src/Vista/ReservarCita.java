/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Vista;
import java.awt.event.ItemEvent;
import DAO.*;
import Modelo.Mascotas;

public class ReservarCita extends javax.swing.JInternalFrame {
    ActualizarCombos ac=new ActualizarCombos();
    /**
     * Creates new form ReservarCita1
     */
    public ReservarCita() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jdpnContenedor = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        txtCodigo = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        lblDueño = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaDescripcion = new javax.swing.JTextArea();
        cbxMascota = new javax.swing.JComboBox<>();
        btnBuscarDatos = new javax.swing.JButton();
        txtDNI = new javax.swing.JTextField();
        btnReservarCita = new javax.swing.JButton();
        btnConsultarCita = new javax.swing.JButton();
        btnCancelarCita = new javax.swing.JButton();
        btnReprogramar = new javax.swing.JButton();
        btnFinalizarCIta = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cbxServicio = new javax.swing.JComboBox<>();
        txtPrecio = new javax.swing.JTextField();
        cbxVeterinario = new javax.swing.JComboBox<>();
        btnCargarVeterinario = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cbxTurno = new javax.swing.JComboBox<>();
        btnConsultarFecha = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblTurnosFecha = new javax.swing.JTable();
        jdchFecha = new com.toedter.calendar.JDateChooser();

        setClosable(true);

        jdpnContenedor.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DATOS DE LA MASCOTA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtCodigo.setBorder(javax.swing.BorderFactory.createTitledBorder("CODIGO"));
        jPanel1.add(txtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 153, 50));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DATOS DEL CLIENTE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblDueño.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel2.add(lblDueño, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 230, 20));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Dueño: ");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 60, -1));

        jLabel1.setText("Descripcion");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        jLabel3.setText("Seleccione su Mascota:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        txaDescripcion.setColumns(20);
        txaDescripcion.setRows(5);
        txaDescripcion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane1.setViewportView(txaDescripcion);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, 230, -1));

        cbxMascota.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-------------------------" }));
        cbxMascota.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cbxMascota.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxMascotaItemStateChanged(evt);
            }
        });
        jPanel2.add(cbxMascota, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 162, 220, 50));

        btnBuscarDatos.setBackground(new java.awt.Color(204, 204, 204));
        btnBuscarDatos.setText("BUSCAR DATOS...");
        jPanel2.add(btnBuscarDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, 150, -1));

        txtDNI.setBorder(javax.swing.BorderFactory.createTitledBorder("DNI PROPIETARIO"));
        jPanel2.add(txtDNI, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 130, 50));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 314, 380));

        btnReservarCita.setBackground(new java.awt.Color(0, 102, 102));
        btnReservarCita.setForeground(new java.awt.Color(255, 255, 255));
        btnReservarCita.setText("RESERVAR CITA");
        jPanel1.add(btnReservarCita, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 497, 134, 40));

        btnConsultarCita.setBackground(new java.awt.Color(0, 102, 102));
        btnConsultarCita.setForeground(new java.awt.Color(255, 255, 255));
        btnConsultarCita.setText("CONSULTAR");
        jPanel1.add(btnConsultarCita, new org.netbeans.lib.awtextra.AbsoluteConstraints(198, 497, 134, 40));

        btnCancelarCita.setBackground(new java.awt.Color(0, 102, 102));
        btnCancelarCita.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelarCita.setText("CANCELAR CITA");
        jPanel1.add(btnCancelarCita, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 497, 134, 40));

        btnReprogramar.setBackground(new java.awt.Color(0, 102, 102));
        btnReprogramar.setForeground(new java.awt.Color(255, 255, 255));
        btnReprogramar.setText("REPROGRAMAR CITA");
        jPanel1.add(btnReprogramar, new org.netbeans.lib.awtextra.AbsoluteConstraints(502, 497, 260, 40));

        btnFinalizarCIta.setBackground(new java.awt.Color(0, 102, 102));
        btnFinalizarCIta.setForeground(new java.awt.Color(255, 255, 255));
        btnFinalizarCIta.setText("FINALIZAR CITA");
        jPanel1.add(btnFinalizarCIta, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 500, 134, 40));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DATOS DE SERVICIOS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setText("Seleccione un Veterinario*");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        jLabel6.setText("Seleccione un servicio*");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 31, -1, -1));

        cbxServicio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-------------------------" }));
        cbxServicio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.add(cbxServicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 220, 40));

        txtPrecio.setEditable(false);
        txtPrecio.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtPrecio.setBorder(javax.swing.BorderFactory.createTitledBorder("PRECIO ./S"));
        jPanel3.add(txtPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 130, 160, 60));

        cbxVeterinario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-------------------------" }));
        cbxVeterinario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cbxVeterinario.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxVeterinarioItemStateChanged(evt);
            }
        });
        jPanel3.add(cbxVeterinario, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 220, 40));

        btnCargarVeterinario.setBackground(new java.awt.Color(204, 204, 204));
        btnCargarVeterinario.setText("CARGAR VETERINARIO...");
        jPanel3.add(btnCargarVeterinario, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 70, -1, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(363, 31, 580, 214));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DATOS DE LA FECHA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setText("Seleccione un Turno*");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        jLabel7.setText("Seleccione la Fecha*");
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 31, -1, -1));

        cbxTurno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "------------------" }));
        cbxTurno.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.add(cbxTurno, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 130, 40));

        btnConsultarFecha.setBackground(new java.awt.Color(204, 204, 204));
        btnConsultarFecha.setText("CONSULTAR...");
        jPanel4.add(btnConsultarFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 20, -1, -1));

        tblTurnosFecha.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tblTurnosFecha);

        jPanel4.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 60, 310, 140));

        jdchFecha.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.add(jdchFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 130, 40));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(363, 252, 580, 232));

        jdpnContenedor.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jdpnContenedorLayout = new javax.swing.GroupLayout(jdpnContenedor);
        jdpnContenedor.setLayout(jdpnContenedorLayout);
        jdpnContenedorLayout.setHorizontalGroup(
            jdpnContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jdpnContenedorLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 972, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jdpnContenedorLayout.setVerticalGroup(
            jdpnContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jdpnContenedorLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 560, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jdpnContenedor)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jdpnContenedor)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbxMascotaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxMascotaItemStateChanged
        // TODO add your handling code here:
        ac.CargarComboxServicio2(cbxServicio,cbxMascota);
    }//GEN-LAST:event_cbxMascotaItemStateChanged

    private void cbxVeterinarioItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxVeterinarioItemStateChanged
        // TODO add your handling code here:
        ac.CargarPrecio(cbxVeterinario, txtPrecio);
    }//GEN-LAST:event_cbxVeterinarioItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnBuscarDatos;
    public javax.swing.JButton btnCancelarCita;
    public javax.swing.JButton btnCargarVeterinario;
    public javax.swing.JButton btnConsultarCita;
    public javax.swing.JButton btnConsultarFecha;
    public javax.swing.JButton btnFinalizarCIta;
    public javax.swing.JButton btnReprogramar;
    public javax.swing.JButton btnReservarCita;
    public javax.swing.JComboBox<String> cbxMascota;
    public javax.swing.JComboBox<String> cbxServicio;
    public javax.swing.JComboBox<String> cbxTurno;
    public javax.swing.JComboBox<String> cbxVeterinario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public com.toedter.calendar.JDateChooser jdchFecha;
    public javax.swing.JDesktopPane jdpnContenedor;
    public javax.swing.JLabel lblDueño;
    public javax.swing.JTable tblTurnosFecha;
    public javax.swing.JTextArea txaDescripcion;
    public javax.swing.JTextField txtCodigo;
    public javax.swing.JTextField txtDNI;
    public javax.swing.JTextField txtPrecio;
    // End of variables declaration//GEN-END:variables
}
