/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visual;

import analizadorLexico.tabelaLexica;
import analizadorLexico.AnalizadorLexico;
import analizadorSemantico.AnalizadorSemantico;

import pilha.MontaToken;
import pilha.Token;
import analizadorSintatico.AnalizadorSintatico;
import java.io.File;
import java.util.Stack;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.border.Border;

/**
 *
 * @author Clarita
 */
public class JFramePrincipal extends javax.swing.JFrame {

    visual.Compiladores comp = new visual.Compiladores();
    private Stack<Token> salvaPilha;

    /**
     * Creates new form JFramePrincipal
     */
    public JFramePrincipal() {
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

        jScrollPane1 = new javax.swing.JScrollPane();
        areaTxt = new javax.swing.JTextArea();
        botaoLexico = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaSintatica = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelaLexica = new javax.swing.JTable();
        botaoSintatico = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        campoErro = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuArc = new javax.swing.JMenu();
        jMenuItemSalvar = new javax.swing.JMenuItem();
        jMenuItemSalvarComo = new javax.swing.JMenuItem();
        jMenuItemBusca = new javax.swing.JMenuItem();
        jMenuItemNovo = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        areaTxt.setColumns(20);
        areaTxt.setRows(5);
        jScrollPane1.setViewportView(areaTxt);
        areaTxt.setBorder((Border) new NumeredBorder());

        botaoLexico.setText("Análise Léxica");
        botaoLexico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoLexicoActionPerformed(evt);
            }
        });

        tabelaSintatica.setVisible(false);
        tabelaSintatica.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Palavra"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tabelaSintatica);

        tabelaLexica.setVisible(false);
        tabelaLexica.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Palavra", "Linha"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tabelaLexica);

        botaoSintatico.setText("Analize Sintatica");
        botaoSintatico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSintaticoActionPerformed(evt);
            }
        });

        campoErro.setColumns(20);
        campoErro.setRows(5);
        jScrollPane4.setViewportView(campoErro);

        jButton1.setText("Analise Semantica");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jMenuArc.setText("Arquivo");
        jMenuArc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuArcActionPerformed(evt);
            }
        });

        jMenuItemSalvar.setText("Salvar");
        jMenuItemSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSalvarActionPerformed(evt);
            }
        });
        jMenuArc.add(jMenuItemSalvar);

        jMenuItemSalvarComo.setText("Salvar Como");
        jMenuItemSalvarComo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSalvarComoActionPerformed(evt);
            }
        });
        jMenuArc.add(jMenuItemSalvarComo);

        jMenuItemBusca.setText("Buscar");
        jMenuItemBusca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemBuscaActionPerformed(evt);
            }
        });
        jMenuArc.add(jMenuItemBusca);

        jMenuItemNovo.setText("Novo");
        jMenuItemNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemNovoActionPerformed(evt);
            }
        });
        jMenuArc.add(jMenuItemNovo);

        jMenuBar1.add(jMenuArc);

        jMenu2.setText("Edit");

        jMenuItem1.setText("Sobre o Compilador");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(botaoLexico)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                        .addComponent(botaoSintatico, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(141, 141, 141)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 230, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(13, 13, 13))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 899, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(botaoLexico, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botaoSintatico, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(11, 11, 11))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void jMenuArcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuArcActionPerformed

    }//GEN-LAST:event_jMenuArcActionPerformed

    private void jMenuItemNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemNovoActionPerformed
        areaTxt.setText("");
    }//GEN-LAST:event_jMenuItemNovoActionPerformed

    private void botaoLexicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoLexicoActionPerformed
        tabelaLexica.setVisible(true);
        tabelaSintatica.setVisible(true);

        campoErro.setVisible(true);
        AnalizadorLexico lexico = new AnalizadorLexico();
        MontaToken pega = new MontaToken();
        Stack<Token> pilha = new Stack();
        lexico.analizar(areaTxt.getText());
        pega = lexico.pegaPilha();
        pilha = pega.pilha();
        tabelaLexica tabela = new tabelaLexica(pilha);
        tabelaLexica.setModel(tabela);
        salvaPilha = (Stack) pilha.clone();

    }//GEN-LAST:event_botaoLexicoActionPerformed

    private void jMenuItemSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSalvarActionPerformed
        JFileChooser fc = new JFileChooser();
        fc.showSaveDialog(this);
        File selFile = fc.getSelectedFile();
        String text = areaTxt.getText();
        String salvo = comp.Salvar(selFile, text);
        if (salvo == "1") {
            JOptionPane.showMessageDialog(this, "Salvo com sucesso.");
        } else {
            JOptionPane.showMessageDialog(this, "Operação cancelada.");
        }
    }//GEN-LAST:event_jMenuItemSalvarActionPerformed

    private void jMenuItemBuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemBuscaActionPerformed
        JFileChooser fc = new JFileChooser();
        fc.showOpenDialog(this);
        File selFile = fc.getSelectedFile();

        String texto;
        texto = comp.lerArquivo(selFile);

        areaTxt.setText(texto);
    }//GEN-LAST:event_jMenuItemBuscaActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        JOptionPane.showMessageDialog(null, "Projeto de Compilador, desenvolvido por Juliano Augusto e Junior Port, para a matéria de compiladores.", "Compilador", JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItemSalvarComoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSalvarComoActionPerformed
        JFileChooser fc = new JFileChooser();
        fc.showSaveDialog(this);
        File selFile = fc.getSelectedFile();
        String text = areaTxt.getText();
        String salvo = comp.SalvarComo(selFile, text);
        if (salvo == "1") {
            JOptionPane.showMessageDialog(this, "Salvo com sucesso.");
        } else {
            JOptionPane.showMessageDialog(this, "Operação cancelada.");
        }
    }//GEN-LAST:event_jMenuItemSalvarComoActionPerformed

    private void botaoSintaticoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSintaticoActionPerformed
        tabelaLexica.setVisible(true);
        tabelaSintatica.setVisible(true);

        Stack<Token> pilha = new Stack<>();
        pilha = (Stack) salvaPilha.clone();
        AnalizadorSintatico sintatico = new AnalizadorSintatico(pilha);

        String mensagem = "";
        try {
            mensagem = sintatico.analisar(tabelaSintatica, tabelaLexica);
        } catch (Exception e) {
            mensagem = e.getMessage();
        }

        campoErro.setVisible(true);
        campoErro.setText(mensagem);
    }//GEN-LAST:event_botaoSintaticoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        tabelaLexica.setVisible(false);
        tabelaSintatica.setVisible(false);

        Stack<Token> pilha = new Stack<>();
        pilha = (Stack) salvaPilha.clone();
        AnalizadorSemantico semantico = new AnalizadorSemantico();
        semantico.analiza(pilha);

    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(JFramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFramePrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaTxt;
    private javax.swing.JButton botaoLexico;
    private javax.swing.JButton botaoSintatico;
    private javax.swing.JTextArea campoErro;
    private javax.swing.JButton jButton1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenuArc;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItemBusca;
    private javax.swing.JMenuItem jMenuItemNovo;
    private javax.swing.JMenuItem jMenuItemSalvar;
    private javax.swing.JMenuItem jMenuItemSalvarComo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable tabelaLexica;
    private javax.swing.JTable tabelaSintatica;
    // End of variables declaration//GEN-END:variables
}
