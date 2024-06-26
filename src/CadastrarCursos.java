
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author victor.gsmiranda
 */
public class CadastrarCursos extends javax.swing.JFrame {

    /**
     * Creates new form CadastrarCursos
     */
    public CadastrarCursos() {
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        titleVarejo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbnNomeCurso = new javax.swing.JLabel();
        btnEntrar = new javax.swing.JButton();
        lbnDuracaoCurso = new javax.swing.JLabel();
        lbnDescricaoCurso = new javax.swing.JLabel();
        txtNomeCurso = new javax.swing.JTextField();
        txtDuracaoCurso = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescricaoCurso = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(153, 0, 0));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(null);

        titleVarejo.setText("VarejoPro");
        titleVarejo.setMaximumSize(new java.awt.Dimension(60, 16));
        jPanel2.add(titleVarejo);
        titleVarejo.setBounds(167, 52, 60, 16);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo varejo 2.png"))); // NOI18N
        jPanel2.add(jLabel2);
        jLabel2.setBounds(108, 40, 53, 36);

        lbnNomeCurso.setText("Nome:");
        jPanel2.add(lbnNomeCurso);
        lbnNomeCurso.setBounds(30, 120, 90, 40);

        btnEntrar.setBackground(new java.awt.Color(51, 102, 0));
        btnEntrar.setForeground(new java.awt.Color(255, 255, 255));
        btnEntrar.setMnemonic('e');
        btnEntrar.setText("Salvar");
        btnEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntrarActionPerformed(evt);
            }
        });
        jPanel2.add(btnEntrar);
        btnEntrar.setBounds(80, 410, 210, 50);

        lbnDuracaoCurso.setText("Duração:");
        jPanel2.add(lbnDuracaoCurso);
        lbnDuracaoCurso.setBounds(30, 190, 60, 40);

        lbnDescricaoCurso.setText("Descrição:");
        jPanel2.add(lbnDescricaoCurso);
        lbnDescricaoCurso.setBounds(30, 290, 70, 16);

        txtNomeCurso.setToolTipText("");
        txtNomeCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeCursoActionPerformed(evt);
            }
        });
        jPanel2.add(txtNomeCurso);
        txtNomeCurso.setBounds(110, 120, 190, 40);

        txtDuracaoCurso.setToolTipText("");
        txtDuracaoCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDuracaoCursoActionPerformed(evt);
            }
        });
        jPanel2.add(txtDuracaoCurso);
        txtDuracaoCurso.setBounds(110, 190, 190, 40);

        txtDescricaoCurso.setColumns(20);
        txtDescricaoCurso.setRows(5);
        jScrollPane1.setViewportView(txtDescricaoCurso);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(100, 270, 240, 120);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(200, 70, 369, 524);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 830, 710);

        setSize(new java.awt.Dimension(847, 714));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntrarActionPerformed
        // TODO add U your handling code here:
        String n,dr,des;
        n = txtNomeCurso.getText();
        dr = txtDuracaoCurso.getText();
        des = txtDescricaoCurso.getText();
    

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
           Connection conectar = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/VarejoPro","root","Sarti007@");
            PreparedStatement st = (PreparedStatement) conectar.prepareStatement("INSERT INTO curso VALUES(?,?,?)");
            st.setString(1,n);
            st.setString(2,dr);
            st.setString(3,des);
            st.executeUpdate();
            JOptionPane.showMessageDialog(null, "Curso cadastrado com sucesso");
            //5- Limpar os campos
            txtNomeCurso.setText("");
            txtDuracaoCurso.setText("");
            txtDescricaoCurso.setText("");     
            txtNomeCurso.requestFocus(); // Posiciona o cursor no campo usuario

        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Erro encontrado, entre em contato com suporte e informe o erro:" + ex.getMessage());
        } catch (java.sql.SQLException ex) {
            String erro = ex.getMessage();
            if(erro.contains("Duplicate entry")){
                JOptionPane.showMessageDialog(null, "Curso já cadastrado");
            } else {
                JOptionPane.showMessageDialog(null, "Erro encontrado, entre em contato com suporte e informe o erro:" + ex.getMessage());
            }
        }

    }//GEN-LAST:event_btnEntrarActionPerformed

    private void txtNomeCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeCursoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeCursoActionPerformed

    private void txtDuracaoCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDuracaoCursoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDuracaoCursoActionPerformed

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
            java.util.logging.Logger.getLogger(CadastrarCursos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastrarCursos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastrarCursos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastrarCursos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastrarCursos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEntrar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbnDescricaoCurso;
    private javax.swing.JLabel lbnDuracaoCurso;
    private javax.swing.JLabel lbnNomeCurso;
    private javax.swing.JLabel titleVarejo;
    private javax.swing.JTextArea txtDescricaoCurso;
    private javax.swing.JTextField txtDuracaoCurso;
    private javax.swing.JTextField txtNomeCurso;
    // End of variables declaration//GEN-END:variables
}
