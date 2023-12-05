
package com.mycompany.marketplace;
import java.util.List;
import javax.swing.JOptionPane;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Cadastro extends javax.swing.JFrame {
    
    static int priv;
    private AppManager appManager;
    Usuario usuario;
    
    public Cadastro(int priv) {
        initComponents();
        appManager = AppManager.getInstance();
        List<Usuario> usuarios = appManager.getUsuarios();
        this.priv = priv;
        if(priv == 0){
            jLabel4.setText("Cadastrando Empresa");
        } else {
            jLabel4.setText("Cadastrando Cliente");
        }
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jTextField4 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(189, 191, 166));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(140, 41, 4));

        jTextField1.setPreferredSize(new java.awt.Dimension(64, 35));

        jButton1.setBackground(new java.awt.Color(232, 165, 24));
        jButton1.setFont(new java.awt.Font("Carlito", 1, 12)); // NOI18N
        jButton1.setText("CADASTRAR");
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextField4.setPreferredSize(new java.awt.Dimension(64, 35));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextField3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 35, Short.MAX_VALUE))
                    .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, -1, 340));

        jPanel2.setBackground(new java.awt.Color(29, 36, 30));
        jPanel2.setFont(new java.awt.Font("Carlito", 1, 24)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Carlito", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(232, 165, 24));
        jLabel1.setText("Nome");

        jLabel2.setFont(new java.awt.Font("Carlito", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(232, 165, 24));
        jLabel2.setText("Usuário");

        jLabel3.setFont(new java.awt.Font("Carlito", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(232, 165, 24));
        jLabel3.setText("Senha");

        jLabel5.setFont(new java.awt.Font("Carlito", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(232, 165, 24));
        jLabel5.setText("Endereço");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addContainerGap(112, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 140, 340));

        jLabel4.setFont(new java.awt.Font("Carlito", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(47, 28, 15));
        jLabel4.setText("jLabel4");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 216, 32));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String regex = "^[A-Za-z\\s]+,\\s*\\d+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher;
        if(priv == 0){
            if(!jTextField1.getText().isEmpty() && !jTextField2.getText().isEmpty() && !jTextField3.getText().isEmpty()){
                Filiada filiada = new Filiada(jTextField2.getText(), jTextField3.getText());
                filiada.setNome(jTextField1.getText());
                matcher = pattern.matcher(jTextField4.getText());
                if(matcher.matches()){
                    filiada.setEndereco(jTextField4.getText());
                    appManager.adicionarUsuario(filiada);
                    JOptionPane.showMessageDialog(this, "Cadastro Realizado com Sucesso!");
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Endereço inválido! Use o formato: nome da rua, número");
                }
                appManager.adicionarUsuario(filiada);
                JOptionPane.showMessageDialog(this, "Cadastro Realizado com Sucesso!");
                dispose();
            }
        } else if(priv == 3){
            if(!jTextField1.getText().isEmpty() && !jTextField2.getText().isEmpty() && !jTextField3.getText().isEmpty()){
                Cliente cliente = new Cliente(jTextField2.getText(), jTextField3.getText());
                cliente.setNome(jTextField1.getText());
                matcher = pattern.matcher(jTextField4.getText());
                if(matcher.matches()){
                    cliente.setEndereco(jTextField4.getText());
                    appManager.adicionarUsuario(cliente);
                    JOptionPane.showMessageDialog(this, "Cadastro Realizado com Sucesso!");
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Endereço inválido! Use o formato: nome da rua, número");
                }
            }
        }else if(priv == 2){
            if(!jTextField1.getText().isEmpty() && !jTextField2.getText().isEmpty() && !jTextField3.getText().isEmpty()){
                //Cliente cliente = new Cliente(jTextField2.getText(), jTextField3.getText());
                usuario.setNome(jTextField1.getText());
                matcher = pattern.matcher(jTextField4.getText());
                if(matcher.matches()){
                    usuario.setEndereco(jTextField4.getText());
                    usuario.setUserName(jTextField2.getText());
                    usuario.setSenha(jTextField3.getText());
                    appManager.adicionarUsuario(usuario);
                    JOptionPane.showMessageDialog(this, "Cadastro Realizado com Sucesso!");
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Endereço inválido! Use o formato: nome da rua, número");
                }
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    public void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cadastro(priv).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables

    
}
