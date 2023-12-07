package com.mycompany.marketplace;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Home extends JFrame {

    int priv;
    Usuario usuario;
    static List<Produto> produtos;
    static List<Produto> results;
    static List<Produto> Lista;
    static List<Servico> servico;
    boolean busca;

    public Home() {
        initComponents();
        int largura = 1050;
        int altura = (largura * 9) / 16;
        setSize(largura, altura);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        verificaPrivilegios();
        sairBut.setVisible(false);
        System.out.println("verirficação priv ao criar obj Home:" + priv);
    }

    public Home(Usuario usuario) {
        initComponents();
        this.usuario = usuario;
        int largura = 1050;
        int altura = (largura * 9) / 16;
        setSize(largura, altura);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        verificaPrivilegios();
        servico = new ArrayList<>();
        atualizarBemVindo(usuario);
        logBut.setVisible(false);
        Lista = new ArrayList<Produto>();
        System.out.println("verirficação priv ao criar obj Home:" + priv);
    }


    private static List<Produto> gerarProdutosAleatorios(int quantidade) {
        List<Produto> produtos = new ArrayList<>();
        Set<String> nomesGerados = new HashSet<>();
        Random random = new Random();

        String[] nomes = {"Smartphone UltraX", "Tênis Esportivo MaxFit", "Câmera Fotográfica ProShot", "Notebook InfinityBook", "Smartwatch TechGear", "Fones de Ouvido SonicBlast", "Mochila Voyager Plus", "Cafeteira Expressa BeanMaster", "Console de Jogos QuantumPlay", "Monitor Gamer VisionX", "Drone SkyTracker", "Máquina de Cortar Cabelo Profissional", "Liquidificador PowerBlend", "Relógio Inteligente SmartLife", "Kit de Maquiagem GlamourStyle"};

        while (produtos.size() < quantidade) {
            String nomeAleatorio = nomes[random.nextInt(nomes.length)];

            // Garante que o nome gerado ainda não foi utilizado
            if (nomesGerados.add(nomeAleatorio)) {
                double precoAleatorio = 50 + random.nextDouble() * 950; // Preço entre 50 e 1000
                Produto produto = new Produto(nomeAleatorio, precoAleatorio);
                produtos.add(produto);
            }
        }

        return produtos;
    }

    public void verificaCarrinho(Pedido pedido) {
       if (Lista.size() > 0) {
           carriBut.setEnabled(true);
        }

    }

    public Usuario getUsuario() {
        return usuario;
    }

    public List<Produto> getLista() {
        return Lista;
    }

    public static void setLista(List<Produto> Lista) {
        Home.Lista = Lista;
    }
    
    
    public int getPriv() {
        return priv;
    }

    public List<Servico> getServico() {
        return servico;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cadBut = new javax.swing.JButton();
        logBut = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        lupaBut = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        sairBut = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        carriBut = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(59, 89, 152));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(238, 86, 34));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("MasterStore");

        cadBut.setBackground(new java.awt.Color(215, 253, 236));
        cadBut.setFont(new java.awt.Font("Swis721 BT", 1, 14)); // NOI18N
        cadBut.setText("CADASTRO");
        cadBut.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(24, 119, 242), 3));
        cadBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadButActionPerformed(evt);
            }
        });

        logBut.setBackground(new java.awt.Color(215, 253, 236));
        logBut.setFont(new java.awt.Font("Swis721 BT", 1, 14)); // NOI18N
        logBut.setText("LOGIN");
        logBut.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(24, 119, 242), 3));
        logBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logButActionPerformed(evt);
            }
        });

        jButton13.setBackground(new java.awt.Color(215, 253, 236));
        jButton13.setFont(new java.awt.Font("Swis721 BT", 1, 14)); // NOI18N
        jButton13.setText("HOME");
        jButton13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(24, 119, 242), 3));
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton14.setBackground(new java.awt.Color(215, 253, 236));
        jButton14.setFont(new java.awt.Font("Swis721 BT", 1, 14)); // NOI18N
        jButton14.setText("SERVIÇOS");
        jButton14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(24, 119, 242), 3));
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(22, 22, 22))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButton14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                    .addComponent(logBut, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                    .addComponent(cadBut, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jButton13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(logBut)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cadBut)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton14)
                .addContainerGap(451, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 240, 650));

        jTextField1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jPanel2.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 20, 230, -1));

        lupaBut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lupa.png"))); // NOI18N
        lupaBut.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lupa.png"))); // NOI18N
        lupaBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lupaButActionPerformed(evt);
            }
        });
        jPanel2.add(lupaBut, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 20, 50, 40));

        jLabel2.setForeground(new java.awt.Color(254, 246, 205));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, 340, 20));

        sairBut.setText("Sair");
        sairBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sairButActionPerformed(evt);
            }
        });
        jPanel2.add(sairBut, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 40, -1, -1));

        jPanel1.setBackground(new java.awt.Color(139, 157, 195));

        jButton1.setText(produtos.get(0).nome);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText(produtos.get(1).nome);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText(produtos.get(2).nome);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton5.setText(produtos.get(4).nome);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText(produtos.get(5).nome);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText(produtos.get(6).nome);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton9.setText(produtos.get(8).nome);
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setText(produtos.get(9).nome);
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton11.setText(produtos.get(10).nome);
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setText(produtos.get(11).nome);
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton4.setText(produtos.get(3).nome);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton8.setText(produtos.get(7).nome);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jLabel3.setLayout(null);
        jLabel3.setFont(new java.awt.Font("Carlito", 1, 18)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(287, 287, 287)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(214, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 1200, 480));

        carriBut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/carrinho.png"))); // NOI18N
        carriBut.setEnabled(false);
        carriBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carriButActionPerformed(evt);
            }
        });
        jPanel2.add(carriBut, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 20, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1050, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1066, 896));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void logButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logButActionPerformed
        Login telaLogin = new Login(this);
        telaLogin.setVisible(true);
    }//GEN-LAST:event_logButActionPerformed

    private void sairButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sairButActionPerformed
        dispose();
        Home home = new Home();
        home.setVisible(true);
        home.setServico(servico);
    }//GEN-LAST:event_sairButActionPerformed

    private void cadButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadButActionPerformed
        Cadastro telaCadastro = new Cadastro(priv);
        telaCadastro.setVisible(true);
    }//GEN-LAST:event_cadButActionPerformed

    private void lupaButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lupaButActionPerformed

        String termoBusca;
        int cont = 0;
        if (!jTextField1.getText().isEmpty()) {
            busca = true;
            termoBusca = jTextField1.getText().toLowerCase();
            jTextField1.setText("");
            results = new ArrayList<Produto>();

            for (Produto p : produtos) {

                if (p.getNome().toLowerCase().contains(termoBusca) && cont < 13) {
                    results.add(p);
                    cont++;
                }
            }

            atualizaProd(cont);
            //busca = false;
        }

    }//GEN-LAST:event_lupaButActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        ProdVenda prod1;
        if (!busca) {
            prod1 = new ProdVenda(produtos.get(0), this);
        } else {
            prod1 = new ProdVenda(results.get(0), this);
        }

        
        prod1.setUsuario(usuario);
        prod1.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        ProdVenda prod1;
        if (!busca) {
            prod1 = new ProdVenda(produtos.get(1), this);
        } else {
            prod1 = new ProdVenda(results.get(1),this);
        }
        
        prod1.setUsuario(usuario);
        prod1.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        ProdVenda prod1;
        if (!busca) {
            prod1 = new ProdVenda(produtos.get(2), this);
        } else {
            prod1 = new ProdVenda(results.get(2), this);
        }
        
        prod1.setUsuario(usuario);
        prod1.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        ProdVenda prod1;
        if (!busca) {
            prod1 = new ProdVenda(produtos.get(3),this);
        } else {
            prod1 = new ProdVenda(results.get(3), this);
        }
        
        prod1.setUsuario(usuario);
        prod1.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        ProdVenda prod1;
        if (!busca) {
            prod1 = new ProdVenda(produtos.get(4), this);
        } else {
            prod1 = new ProdVenda(results.get(4), this);
        }
        
        prod1.setUsuario(usuario);
        prod1.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        ProdVenda prod1;
        if (!busca) {
            prod1 = new ProdVenda(produtos.get(5), this);
        } else {
            prod1 = new ProdVenda(results.get(5), this);
        }
        
        prod1.setUsuario(usuario);
        prod1.setVisible(true);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        ProdVenda prod1;
        if (!busca) {
            prod1 = new ProdVenda(produtos.get(6), this);
        } else {
            prod1 = new ProdVenda(results.get(6), this);
        }
        
        prod1.setUsuario(usuario);
        prod1.setVisible(true);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        ProdVenda prod1;
        if (!busca) {
            prod1 = new ProdVenda(produtos.get(7), this);
        } else {
            prod1 = new ProdVenda(results.get(7), this);
        }
        
        prod1.setUsuario(usuario);
        prod1.setVisible(true);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        ProdVenda prod1;
        if (!busca) {
            prod1 = new ProdVenda(produtos.get(8), this);
        } else {
            prod1 = new ProdVenda(results.get(8), this);
        }
        
        prod1.setUsuario(usuario);
        prod1.setVisible(true);
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        ProdVenda prod1;
        if (!busca) {
            prod1 = new ProdVenda(produtos.get(9), this);
        } else {
            prod1 = new ProdVenda(results.get(9), this);
        }
        
        prod1.setUsuario(usuario);
        prod1.setVisible(true);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        ProdVenda prod1;
        if (!busca) {
            prod1 = new ProdVenda(produtos.get(10), this);
        } else {
            prod1 = new ProdVenda(results.get(10), this);
        }
       
        prod1.setUsuario(usuario);
        prod1.setVisible(true);
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        ProdVenda prod1;
        if (!busca) {
            prod1 = new ProdVenda(produtos.get(11), this);
        } else {
            prod1 = new ProdVenda(results.get(11), this);
        }
        
        prod1.setUsuario(usuario);
        prod1.setVisible(true);
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        carregaHome();
        
    }//GEN-LAST:event_jButton13ActionPerformed

    private void carriButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carriButActionPerformed
        Carrinho carrinho = new Carrinho(Lista);
        carrinho.setHome(this);
        carrinho.setVisible(true);
    }//GEN-LAST:event_carriButActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        if(usuario == null || usuario.getPriv() == 2 ){
            JOptionPane.showMessageDialog(this, "Voce nao tem acesso a esta area");
        }
        else if (usuario.getPriv() == 1 || usuario.getPriv() == 0)
        {
            TelaServico telaServ = new TelaServico(usuario, this);
            telaServ.setVisible(true);
        }
    }//GEN-LAST:event_jButton14ActionPerformed

    public void atualizarBemVindo(Usuario usuario) {
        jLabel2.setText("Bem-vindo, " + usuario.getNome() + "!");
        remove(logBut);
        if (priv != 0) {
            remove(cadBut);
        }

    }
    
    protected void carregaHome(){
        if(busca){
           busca = false;
        }
        
        dispose();
        if(usuario == null){
            Home home = new Home();
            home.setVisible(true);
        } else {
            Home home = new Home(usuario);
            home.setVisible(true);
        }
    }

    public static void setServico(List<Servico> servico) {
        Home.servico = servico;
    }

    private void verificaPrivilegios() {
        if (usuario == null) {
            priv = 3;
        } else {
            priv = usuario.getPriv();
        }
    }

    private void atualizaProd(int cont) {

        jLabel3.setText(cont + " resultados encontrados");

        /*for (Produto p : results) {
            System.out.println(p.getNome());
        }*/
        if (0 < cont) {
            jButton1.setText(results.get(0).nome);
            jButton1.setVisible(true);
        } else {
            jButton1.setVisible(false);
        }

        if (1 < cont) {
            jButton2.setText(results.get(1).nome);
            jButton2.setVisible(true);
        } else {
            jButton2.setVisible(false);
        }

        if (2 < cont) {
            jButton3.setText(results.get(2).nome);
            jButton3.setVisible(true);
        } else {
            jButton3.setVisible(false);
        }
        if (3 < cont) {
            jButton4.setText(results.get(3).nome);
            jButton4.setVisible(true);
        } else {
            jButton4.setVisible(false);
        }
        if (4 < cont) {
            jButton5.setText(results.get(4).nome);
            jButton5.setVisible(true);
        } else {
            jButton5.setVisible(false);
        }
        if (5 < cont) {
            jButton6.setText(results.get(5).nome);
            jButton6.setVisible(true);
        } else {
            jButton6.setVisible(false);
        }
        if (6 < cont) {
            jButton7.setText(results.get(6).nome);
            jButton7.setVisible(true);
        } else {
            jButton7.setVisible(false);
        }
        if (7 < cont) {
            jButton8.setText(results.get(7).nome);
            jButton8.setVisible(true);
        } else {
            jButton8.setVisible(false);
        }
        if (8 < cont) {
            jButton9.setText(results.get(8).nome);
            jButton9.setVisible(true);
        } else {
            jButton9.setVisible(false);
        }
        if (9 < cont) {
            jButton10.setText(results.get(9).nome);
            jButton10.setVisible(true);
        } else {
            jButton10.setVisible(false);
        }
        if (10 < cont) {
            jButton11.setText(results.get(10).nome);
            jButton11.setVisible(true);
        } else {
            jButton11.setVisible(false);
        }
        if (11 < cont) {
            jButton12.setVisible(true);
            jButton12.setText(results.get(11).nome);
        } else {
            jButton12.setVisible(false);
        }

    }

    public static void main(String args[]) {

        try {

            produtos = gerarProdutosAleatorios(15);

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
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cadBut;
    private javax.swing.JButton carriBut;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    public javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton logBut;
    private javax.swing.JButton lupaBut;
    public javax.swing.JButton sairBut;
    // End of variables declaration//GEN-END:variables

}
