
package com.mycompany.practica7diu;

import java.awt.Dimension;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.ScrollPaneConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.opencv.core.Core;


/**
 *
 * @author marti
 */
public class Practica7 extends javax.swing.JFrame {

    JScrollBar barraV;
    JScrollBar barraH;
    private JFileChooser jf =  new JFileChooser();
    private File fichero;
    private AnalizadorRGB analizador;
    private int [] max, min, average;
    
    class barListener implements AdjustmentListener{ // Para capturar eventos Scrollbar

        @Override
        public void adjustmentValueChanged(AdjustmentEvent e) {
            if(lienzo2.getMatImage()!=null){
                 
                Dimension dim;
                if(panelScroll.getViewport().getExtentSize().height>=lienzo2.getHeight()
                  && panelScroll.getViewport().getExtentSize().width>=lienzo2.getWidth()){
                    dim = new Dimension(lienzo2.getWidth(), lienzo2.getHeight());
                }else if(panelScroll.getViewport().getExtentSize().height>=lienzo2.getHeight()){
                    dim = new Dimension(panelScroll.getViewport().getExtentSize().width, lienzo2.getHeight());
                }else if(panelScroll.getViewport().getExtentSize().width>=lienzo2.getWidth()){
                    dim = new Dimension(lienzo2.getWidth(), panelScroll.getViewport().getExtentSize().height);
                }else{
                    dim = panelScroll.getViewport().getExtentSize();
                }
                
                try{
                    analizador.calculaEstadisticas(lienzo2.getMatImage()
                    ,panelScroll.getViewport().getViewPosition()
                    ,dim);
                }catch(Exception exc){
                    
                }
                
                
                max = analizador.getMaximo();
                min = analizador.getMinimo();
                average = analizador.getPromedio();

                maxRojoField.setText(max[2]+"");
                minRojoField.setText(min[2]+"");
                medRojoField.setText(average[2]+"");

                maxVerdeField.setText(max[1]+"");
                minVerdeField.setText(min[1]+"");
                medVerdeField.setText(average[1]+"");

                maxAzulField.setText(max[0]+"");
                minAzulField.setText(min[0]+"");
                medAzulField.setText(average[0]+"");
            }
        }
        
    }
    public Practica7() {
        initComponents();
        nu.pattern.OpenCV.loadShared();
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        barraV=panelScroll.getVerticalScrollBar();
        barraH=panelScroll.getHorizontalScrollBar();
        barraV.addAdjustmentListener(new barListener());
        barraH.addAdjustmentListener(new barListener());
        
        analizador=new AnalizadorRGB();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelScroll = new javax.swing.JScrollPane();
        lienzo2 = new com.mycompany.practica7diu.Lienzo();
        rojoPanel = new javax.swing.JPanel();
        rojoLabel = new javax.swing.JLabel();
        maxRojoField = new javax.swing.JTextField();
        maxRojoLabel = new javax.swing.JLabel();
        medRojoLabel = new javax.swing.JLabel();
        medRojoField = new javax.swing.JTextField();
        minRojoField = new javax.swing.JTextField();
        minRojoLabel = new javax.swing.JLabel();
        verdePanel = new javax.swing.JPanel();
        verdeLabel = new javax.swing.JLabel();
        maxVerdeField = new javax.swing.JTextField();
        maxVerdeLabel = new javax.swing.JLabel();
        medVerdeLabel = new javax.swing.JLabel();
        medVerdeField = new javax.swing.JTextField();
        minVerdeField = new javax.swing.JTextField();
        minVerdeLabel = new javax.swing.JLabel();
        azulPanel = new javax.swing.JPanel();
        azulaLabel = new javax.swing.JLabel();
        maxAzulField = new javax.swing.JTextField();
        maxAzulLabel = new javax.swing.JLabel();
        medAzulLabel = new javax.swing.JLabel();
        medAzulField = new javax.swing.JTextField();
        minAzulField = new javax.swing.JTextField();
        minAzulLabel = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        archivoMenu = new javax.swing.JMenu();
        abrirItem = new javax.swing.JMenuItem();
        cerrarItem = new javax.swing.JMenuItem();
        ayudaMenu = new javax.swing.JMenu();
        infoItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout lienzo2Layout = new javax.swing.GroupLayout(lienzo2);
        lienzo2.setLayout(lienzo2Layout);
        lienzo2Layout.setHorizontalGroup(
            lienzo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 653, Short.MAX_VALUE)
        );
        lienzo2Layout.setVerticalGroup(
            lienzo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 344, Short.MAX_VALUE)
        );

        panelScroll.setViewportView(lienzo2);

        rojoLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        rojoLabel.setText("Rojo");

        maxRojoField.setEditable(false);

        maxRojoLabel.setText("Máximo");

        medRojoLabel.setText("Promedio");

        medRojoField.setEditable(false);

        minRojoField.setEditable(false);

        minRojoLabel.setText("Mínimo");

        javax.swing.GroupLayout rojoPanelLayout = new javax.swing.GroupLayout(rojoPanel);
        rojoPanel.setLayout(rojoPanelLayout);
        rojoPanelLayout.setHorizontalGroup(
            rojoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rojoPanelLayout.createSequentialGroup()
                .addComponent(rojoLabel)
                .addGap(0, 117, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rojoPanelLayout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(rojoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(rojoPanelLayout.createSequentialGroup()
                        .addComponent(medRojoLabel)
                        .addGap(10, 10, 10))
                    .addGroup(rojoPanelLayout.createSequentialGroup()
                        .addGroup(rojoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(maxRojoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(minRojoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(rojoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(minRojoField, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
                    .addComponent(medRojoField)
                    .addComponent(maxRojoField))
                .addContainerGap())
        );
        rojoPanelLayout.setVerticalGroup(
            rojoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rojoPanelLayout.createSequentialGroup()
                .addComponent(rojoLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(rojoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(maxRojoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(maxRojoLabel))
                .addGap(7, 7, 7)
                .addGroup(rojoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(medRojoLabel)
                    .addComponent(medRojoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(rojoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(minRojoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(minRojoLabel)))
        );

        verdeLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        verdeLabel.setText("Verde");

        maxVerdeField.setEditable(false);

        maxVerdeLabel.setText("Máximo");

        medVerdeLabel.setText("Promedio");

        medVerdeField.setEditable(false);

        minVerdeField.setEditable(false);

        minVerdeLabel.setText("Mínimo");

        javax.swing.GroupLayout verdePanelLayout = new javax.swing.GroupLayout(verdePanel);
        verdePanel.setLayout(verdePanelLayout);
        verdePanelLayout.setHorizontalGroup(
            verdePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(verdePanelLayout.createSequentialGroup()
                .addComponent(verdeLabel)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, verdePanelLayout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(verdePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(verdePanelLayout.createSequentialGroup()
                        .addComponent(medVerdeLabel)
                        .addGap(10, 10, 10))
                    .addGroup(verdePanelLayout.createSequentialGroup()
                        .addGroup(verdePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(maxVerdeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                            .addComponent(minVerdeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(verdePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(minVerdeField, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
                    .addComponent(medVerdeField)
                    .addComponent(maxVerdeField))
                .addContainerGap())
        );
        verdePanelLayout.setVerticalGroup(
            verdePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(verdePanelLayout.createSequentialGroup()
                .addComponent(verdeLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(verdePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(maxVerdeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(maxVerdeLabel))
                .addGap(7, 7, 7)
                .addGroup(verdePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(medVerdeLabel)
                    .addComponent(medVerdeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(verdePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(minVerdeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(minVerdeLabel)))
        );

        azulaLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        azulaLabel.setText("Azul");

        maxAzulField.setEditable(false);

        maxAzulLabel.setText("Máximo");

        medAzulLabel.setText("Promedio");

        medAzulField.setEditable(false);

        minAzulField.setEditable(false);

        minAzulLabel.setText("Mínimo");

        javax.swing.GroupLayout azulPanelLayout = new javax.swing.GroupLayout(azulPanel);
        azulPanel.setLayout(azulPanelLayout);
        azulPanelLayout.setHorizontalGroup(
            azulPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(azulPanelLayout.createSequentialGroup()
                .addComponent(azulaLabel)
                .addGap(0, 117, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, azulPanelLayout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(azulPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(azulPanelLayout.createSequentialGroup()
                        .addComponent(medAzulLabel)
                        .addGap(10, 10, 10))
                    .addGroup(azulPanelLayout.createSequentialGroup()
                        .addGroup(azulPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(maxAzulLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(minAzulLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(azulPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(minAzulField, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
                    .addComponent(medAzulField)
                    .addComponent(maxAzulField))
                .addContainerGap())
        );
        azulPanelLayout.setVerticalGroup(
            azulPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(azulPanelLayout.createSequentialGroup()
                .addComponent(azulaLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(azulPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(maxAzulField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(maxAzulLabel))
                .addGap(7, 7, 7)
                .addGroup(azulPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(medAzulLabel)
                    .addComponent(medAzulField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(azulPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(minAzulField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(minAzulLabel)))
        );

        archivoMenu.setText("Archivo");

        abrirItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        abrirItem.setText("Abrir Imagen");
        abrirItem.setToolTipText("Abrir imagen para analizar RGB");
        abrirItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrirItemActionPerformed(evt);
            }
        });
        archivoMenu.add(abrirItem);

        cerrarItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.SHIFT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        cerrarItem.setText("Cerrar...");
        cerrarItem.setToolTipText("Cerrar Aplicación");
        cerrarItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerrarItemActionPerformed(evt);
            }
        });
        archivoMenu.add(cerrarItem);

        menuBar.add(archivoMenu);

        ayudaMenu.setText("Ayuda");
        ayudaMenu.setToolTipText("¿Deseas saber más?");

        infoItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        infoItem.setText("Más información");
        infoItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                infoItemActionPerformed(evt);
            }
        });
        ayudaMenu.add(infoItem);

        menuBar.add(ayudaMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(rojoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(verdePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(azulPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 68, Short.MAX_VALUE))
                    .addComponent(panelScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(rojoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(verdePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(azulPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(panelScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cerrarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrarItemActionPerformed
        int res = JOptionPane.showConfirmDialog(rootPane, "¿Quieres cerrar la aplicación?."
                ,"Cerrar Aplicación", JOptionPane.YES_NO_OPTION);
        if(res==JOptionPane.YES_OPTION){
            System.exit(0);
            setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        }
    }//GEN-LAST:event_cerrarItemActionPerformed

    private void infoItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_infoItemActionPerformed
        JOptionPane.showMessageDialog(rootPane, "Carga una imagen y se mostrarán los valores de las componentes RGB " +
                            "\n" +  "Devs: @martinvplopez, @joelnavri"
                        , "AYUDA", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_infoItemActionPerformed

    private void abrirItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abrirItemActionPerformed
        jf.addChoosableFileFilter(new FileNameExtensionFilter("Fotos", "jpg", "jpeg", "png"));
        
        int res = jf.showOpenDialog(null);
        
        if(res==JFileChooser.APPROVE_OPTION){
            fichero = jf.getSelectedFile();
            lienzo2.openImage(fichero.getAbsolutePath());
        }
        
        panelScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        panelScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);    
    }//GEN-LAST:event_abrirItemActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Practica7.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Practica7.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Practica7.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Practica7.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Practica7().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem abrirItem;
    private javax.swing.JMenu archivoMenu;
    private javax.swing.JMenu ayudaMenu;
    private javax.swing.JPanel azulPanel;
    private javax.swing.JLabel azulaLabel;
    private javax.swing.JMenuItem cerrarItem;
    private javax.swing.JMenuItem infoItem;
    private com.mycompany.practica7diu.Lienzo lienzo2;
    private javax.swing.JTextField maxAzulField;
    private javax.swing.JLabel maxAzulLabel;
    private javax.swing.JTextField maxRojoField;
    private javax.swing.JLabel maxRojoLabel;
    private javax.swing.JTextField maxVerdeField;
    private javax.swing.JLabel maxVerdeLabel;
    private javax.swing.JTextField medAzulField;
    private javax.swing.JLabel medAzulLabel;
    private javax.swing.JTextField medRojoField;
    private javax.swing.JLabel medRojoLabel;
    private javax.swing.JTextField medVerdeField;
    private javax.swing.JLabel medVerdeLabel;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JTextField minAzulField;
    private javax.swing.JLabel minAzulLabel;
    private javax.swing.JTextField minRojoField;
    private javax.swing.JLabel minRojoLabel;
    private javax.swing.JTextField minVerdeField;
    private javax.swing.JLabel minVerdeLabel;
    private javax.swing.JScrollPane panelScroll;
    private javax.swing.JLabel rojoLabel;
    private javax.swing.JPanel rojoPanel;
    private javax.swing.JLabel verdeLabel;
    private javax.swing.JPanel verdePanel;
    // End of variables declaration//GEN-END:variables
}
