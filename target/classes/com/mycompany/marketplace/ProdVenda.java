/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.marketplace;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author lopes
 */
public class ProdVenda extends javax.swing.JFrame {

    Produto produto;
    Usuario usuario;
    Home home;

    public ProdVenda(Produto produto) {
        initComponents();
        //jButton1.setEnabled(false);
        jLabel1.setText(produto.getNome());
        jLabel2.setText(String.format("%.2f", produto.getPreco()));
 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jButton1.setText("COMPRAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("jLabel2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(174, 174, 174)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 799, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 333, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(38, 38, 38))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Object[] options = {"CADASTRAR", "JA POSSUO CADASTRO", "Sair"};
        
        if (usuario == null) {
            int result = JOptionPane.showOptionDialog(null, "Por favor, realize seu cadastro!", "Usuario não Cadastrado", JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null, // ícone (use 'null' para nenhum ícone)
                    options, // array de opções de botão
                    options[1]);
            if (result == 0) {
                if (usuario != null) {
                    Cadastro telaCadastro = new Cadastro(usuario.getPriv());
                    telaCadastro.setVisible(true);
                } else {
                    Cadastro telaCadastro = new Cadastro(3);
                    telaCadastro.setVisible(true);
                }
                dispose();
            } else if (result == 1) {
                Login telaLogin = new Login(home);
                telaLogin.setVisible(true);
                dispose();
            }

        } else if (usuario.getPriv() == 2) {
            UIManager.put("OptionPane.yesButtonText", "Dados CORRETOS");
            UIManager.put("OptionPane.noButtonText", "Preciso ALTERAR");
            StringBuilder mensagem = new StringBuilder();
            mensagem.append("Nome: ").append(usuario.getNome()).append("\n");
            mensagem.append("Endereço: ").append(usuario.getEndereco()).append("\n");

            int opcao = JOptionPane.showConfirmDialog(null, mensagem.toString(), "Confirmação de Dados", JOptionPane.YES_NO_OPTION);

            if (opcao == JOptionPane.YES_OPTION) {
                Pedido pedido = new Pedido(usuario,LocalDateTime.now());
                pedido.Carrinho.add(produto);
                home.verificaCarrinho(pedido);
                JOptionPane.showMessageDialog(null, "Os dados estão corretos!");
                this.dispose();
            } else if(opcao == JOptionPane.NO_OPTION){
                Cadastro telaCadastro = new Cadastro(2);
                telaCadastro.setVisible(true);
                telaCadastro.setUsuario(usuario);
                //JOptionPane.showMessageDialog(null, "Os dados foram rejeitados. Faça as correções necessárias.");
            } else {
                dispose();
            }

        }

    }//GEN-LAST:event_jButton1ActionPerformed

    public void setHome(Home home) {
        this.home = home;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProdVenda(produto).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    public javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
