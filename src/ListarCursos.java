
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author victor.gsmiranda
 */
public class ListarCursos extends javax.swing.JFrame {

    /**
     * Creates new form ListarCursos
     */
    public ListarCursos() {
        initComponents();
        ListarCursos();
    }

    private void ListarCursos() {
        try {
            //conectar ao banco de dados 
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conectar = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/VarejoPro", "root", "Sarti007@");
            PreparedStatement st = conectar.prepareStatement("SELECT * FROM curso");
            ResultSet curso = st.executeQuery();

            DefaultTableModel tblModelo = (DefaultTableModel) tblCurso.getModel();//Serve para tirar o mode da tabela
            tblModelo.setRowCount(0);

            //4 - Faça linha por linha ate o final da tabela
            while (curso.next()) {
                String linha[] = {
                    curso.getString("nome"),
                    curso.getString("duracao"),
                    curso.getString("descricao")
                };
                tblModelo.addRow(linha);

            }
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ListarCursos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ListarCursos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblUsuarios = new javax.swing.JLabel();
        txtCurso = new javax.swing.JTextField();
        BtnBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCurso = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        titleVarejo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Listar Cursos");
        getContentPane().setLayout(null);

        lblUsuarios.setText("Curso:");
        getContentPane().add(lblUsuarios);
        lblUsuarios.setBounds(190, 100, 60, 16);

        txtCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCursoActionPerformed(evt);
            }
        });
        getContentPane().add(txtCurso);
        txtCurso.setBounds(250, 90, 150, 30);

        BtnBuscar.setText("Buscar");
        BtnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(BtnBuscar);
        BtnBuscar.setBounds(420, 90, 90, 30);

        tblCurso.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Duração", "Descrição"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblCurso);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(70, 150, 570, 290);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo varejo 2.png"))); // NOI18N
        jPanel1.add(jLabel2);

        titleVarejo.setText("VarejoPro");
        titleVarejo.setMaximumSize(new java.awt.Dimension(60, 16));
        jPanel1.add(titleVarejo);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(50, 30, 610, 430);

        jPanel2.setBackground(new java.awt.Color(153, 0, 0));
        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 0, 720, 540);

        setSize(new java.awt.Dimension(730, 524));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCursoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCursoActionPerformed

    private void BtnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBuscarActionPerformed
        // TODO add your handling code here:
        // 1 - Obter o cargo para a filtragem
        String u;
        u = txtCurso.getText();

        try {
            //conectar ao banco de dados 
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conectar = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/VarejoPro","root","Sarti007@");
            PreparedStatement st = conectar.prepareStatement("SELECT * FROM curso WHERE nome LIKE ?;");
            st.setString(1,  u + "%");
            ResultSet Curso = st.executeQuery();
            DefaultTableModel tblModelo = (DefaultTableModel) tblCurso.getModel();//Serve para tirar o mode da tabela
            tblModelo.setRowCount(0);

            //4 - Faça linha por linha ate o final da tabela
            while (Curso.next()) {
                String linha[] = {
                    Curso.getString("nome"),
                    Curso.getString("duracao"),
                    Curso.getString("descricao")
                };
                tblModelo.addRow(linha);

            }
        } catch (java.sql.SQLException ex) {
            JOptionPane.showConfirmDialog(null, "Erro entre em contato com suporte");

        } catch (ClassNotFoundException ex) {
            
        }
    }//GEN-LAST:event_BtnBuscarActionPerformed

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
            java.util.logging.Logger.getLogger(ListarCursos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListarCursos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListarCursos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListarCursos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListarCursos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnBuscar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblUsuarios;
    private javax.swing.JTable tblCurso;
    private javax.swing.JLabel titleVarejo;
    private javax.swing.JTextField txtCurso;
    // End of variables declaration//GEN-END:variables
}
