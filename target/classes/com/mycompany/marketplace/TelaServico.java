/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.marketplace;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author iagom
 */
public class TelaServico extends javax.swing.JFrame {

    int priv;
    Usuario usuario;
    static Home home;
    static List<Servico> servicos;
    static List<Servico> results;
    private JsonTableModel modelo;
    boolean busca;
    private JTable tabela;
    private JButton excluirButton;

    public TelaServico(Usuario usuario, Home home) {
        initComponents();
        this.usuario = usuario;
        this.home = home;
        servicos = new ArrayList<>();
        if (usuario.getPriv() == 1) {
            jButton1.setVisible(false);
        } else {
            jButton2.setVisible(false);
            jButton3.setVisible(false);
            jButton4.setVisible(false);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(0, 204, 102));

        jPanel1.setBackground(new java.awt.Color(0, 204, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(255, 153, 0));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("SERVIÇOS");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jLabel1)
                .addContainerGap(90, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addContainerGap(454, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 220, -1));

        jPanel2.setBackground(new java.awt.Color(0, 153, 102));

        jButton2.setText("Solicitar delivery");
        jButton3.setText("Solicitar Matéria Prima");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton2.setText("Requisitar local de armazenamento");
        jButton4.setText("Solicitar Local de Armazenamento");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton2.setText("Requisitar materia prima");
        jButton2.setText("Solicitar Serviço de Delivery");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setText("Verificar Pedidos");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 274, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 730, 390));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        UIManager.put("OptionPane.yesButtonText", "Sim, CONFIRMAR");
        UIManager.put("OptionPane.noButtonText", "NÃO");
        int opcao = JOptionPane.showConfirmDialog(null, "Deseja contratar Este Serviço?", "Confirmação de Dados", JOptionPane.YES_NO_OPTION);

        if (opcao == JOptionPane.YES_OPTION) {
            adicionarServico("Serviço Delivery", 4800, usuario);
        } else if (opcao == JOptionPane.NO_OPTION) {
            dispose();
        } else {
            dispose();
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        UIManager.put("OptionPane.yesButtonText", "Sim, CONFIRMAR");
        UIManager.put("OptionPane.noButtonText", "NÃO");
        int opcao = JOptionPane.showConfirmDialog(null, "Deseja contratar Este Serviço?", "Confirmação de Dados", JOptionPane.YES_NO_OPTION);

        if (opcao == JOptionPane.YES_OPTION) {
            adicionarServico("Matéria Prima", 8000, usuario);
        } else if (opcao == JOptionPane.NO_OPTION) {
            dispose();
        } else {
            dispose();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        UIManager.put("OptionPane.yesButtonText", "Sim, CONFIRMAR");
        UIManager.put("OptionPane.noButtonText", "NÃO");
        int opcao = JOptionPane.showConfirmDialog(null, "Deseja contratar Este Serviço?", "Confirmação de Dados", JOptionPane.YES_NO_OPTION);

        if (opcao == JOptionPane.YES_OPTION) {
            adicionarServico("Local de Armazenamento", 5000, usuario);
        } else if (opcao == JOptionPane.NO_OPTION) {
            dispose();
        } else {
            dispose();
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         Object[][] dados = {
                {"Serviço 1", 100.0, "Cliente A"},
                {"Serviço 2", 150.0, "Cliente B"},
                {"Serviço 3", 200.0, "Cliente C"},
                // Adicione mais linhas conforme necessário
        };

        // Nomes das colunas
        String[] colunas = {"Serviço", "Preço", "Cliente"};

        // Criando o modelo da tabela
        DefaultTableModel modeloTabela = new DefaultTableModel(dados, colunas);

        // Criando a tabela com o modelo
        JTable tabela = new JTable(modeloTabela);

        // Adicionando a tabela a um painel de rolagem
        JScrollPane scrollPane = new JScrollPane(tabela);

        // Criando um novo JFrame para exibir a tabela
        JFrame frameTabela = new JFrame("Tabela de Serviços");
        frameTabela.add(scrollPane);
        frameTabela.setSize(400, 300);
        frameTabela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameTabela.setLocationRelativeTo(this); // Ajuste para que a tabela seja exibida ao lado da tela principal
        frameTabela.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private static void adicionarServico(String nome, double preco, Usuario usuario) {
        servicos.add(new Servico(nome, preco, usuario));
        home.getServico().addAll(servicos);

    }

    class JsonTableModel extends AbstractTableModel {

        private List<Map<String, Object>> dados;
        private String[] colunas;

        @Override
        public int getRowCount() {
            return (dados != null) ? dados.size() : 0;
        }

        @Override
        public int getColumnCount() {
            return (colunas != null) ? colunas.length : 0;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            if (dados == null || dados.isEmpty() || colunas == null || columnIndex >= colunas.length) {
                return null;
            }

            Map<String, Object> linha = dados.get(rowIndex);
            String coluna = colunas[columnIndex];

            return linha.get(coluna);
        }

        @Override
        public String getColumnName(int column) {
            return (colunas != null && column < colunas.length) ? colunas[column] : null;
        }

        public void setDados(List<Map<String, Object>> dados) {
            this.dados = dados;
            // Atualiza as colunas com base nos dados disponíveis
            atualizarColunas();
            fireTableDataChanged();
        }

        private void atualizarColunas() {
            if (dados != null && !dados.isEmpty()) {
                // Assume que todas as linhas têm as mesmas chaves
                colunas = dados.get(0).keySet().toArray(new String[0]);
            }
        }
    }

    public void main(String args[]) {

        try {

            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            
            

            public void run() {
                
                
                new TelaServico(usuario, home).setVisible(true);
            }
        }
        );
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    // End of variables declaration//GEN-END:variables
}
