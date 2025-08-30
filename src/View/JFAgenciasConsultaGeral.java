/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import net.proteanit.sql.DbUtils;
import java.sql.ResultSet;
import mvc_dao.ConnectDAO;
import javax.swing.JOptionPane;
import java.text.MessageFormat;
import javax.swing.JTable;

/**
 *
 * @author Alunos
 */
public class JFAgenciasConsultaGeral extends javax.swing.JFrame {
    /**
     * Creates new form JFAgenciasConsultaGeral
     */
    public JFAgenciasConsultaGeral() {
        initComponents();
    }
    
    public JFAgenciasConsultaGeral(String operacao) {
        initComponents();
        ConnectDAO objcon = new ConnectDAO() ;
        ResultSet agenciasRS;
        agenciasRS = objcon.consultaRegistroAgenciasRSBD("AGENCIAS");
        jTable1.setModel(DbUtils.resultSetToTableModel(agenciasRS));
        RelatorioUtils.ajustarTabela(jTable1);
        jTable1.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnPrint = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        btnPrint.setText("imprimir");
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(467, Short.MAX_VALUE)
                .addComponent(btnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(456, 456, 456))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                .addComponent(btnPrint)
                .addGap(68, 68, 68))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
    
    PrintService[] printServices = PrintServiceLookup.lookupPrintServices(null, null);

    if (printServices.length > 0) {

        JOptionPane.showMessageDialog(this, "Impressora encontrada! Abrindo diálogo de impressão.", "Imprimir", JOptionPane.INFORMATION_MESSAGE);
        
        MessageFormat header = new MessageFormat("Relatório de Agências");
        MessageFormat footer = new MessageFormat("Página {0,number,integer}");

        try {
            boolean complete = jTable1.print(JTable.PrintMode.NORMAL, header, footer);
            if (complete) {
                JOptionPane.showMessageDialog(this, "Impressão enviada com sucesso.", "Concluído", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "A impressão foi cancelada.", "Cancelado", JOptionPane.WARNING_MESSAGE);
            }
        } catch (java.awt.print.PrinterException ex) {
            System.err.println("Erro de impressão: " + ex.getMessage());
            JOptionPane.showMessageDialog(this, "Ocorreu um erro ao tentar imprimir.", "Erro de Impressão", JOptionPane.ERROR_MESSAGE);
        }
    } else {

        JOptionPane.showMessageDialog(this, "Nenhuma impressora foi encontrada.\nO relatório será gerado como um arquivo PDF.", "Gerar PDF", JOptionPane.INFORMATION_MESSAGE);
        
        RelatorioUtils.gerarRelatorioPDF(rootPane, jTable1, "Relatório de Agencias"); 
    }
    }//GEN-LAST:event_btnPrintActionPerformed
    
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
            java.util.logging.Logger.getLogger(JFAgenciasConsultaGeral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFAgenciasConsultaGeral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFAgenciasConsultaGeral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFAgenciasConsultaGeral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFAgenciasConsultaGeral().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPrint;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
