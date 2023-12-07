package com.mycompany.marketplace;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author lopes
 */
public class Carrinho extends javax.swing.JFrame {

    List<Produto> Lista;
    Home home;
    private JTable tabela;
    private DefaultTableModel modelo;
    private JLabel labelPrecoTotal;

    public Carrinho(List<Produto> Lista) {
        this.Lista = Lista;
        String[] colunas = {"Produto", "Preço", "Excluir"};
        modelo = new DefaultTableModel(colunas, 0);
        for (Produto p : Lista) {
            Object[] linha = {p.getNome(), String.format("%.2f", p.getPreco())};
            modelo.addRow(linha);
        }

        tabela = new JTable(modelo);

        tabela.getColumnModel().getColumn(2).setCellRenderer(new ButtonRenderer());
        tabela.getColumnModel().getColumn(2).setCellEditor(new ButtonEditor(new JCheckBox()));

        JScrollPane scrollPane = new JScrollPane(tabela);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        labelPrecoTotal = new JLabel("Preço Total: " + calcularPrecoTotal());
        getContentPane().add(labelPrecoTotal, BorderLayout.SOUTH);

        JButton btnExcluir = new JButton("Excluir Linha");
        btnExcluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                excluirLinhaSelecionada();
            }
        });

        JButton btnFinalizarCompra = new JButton("Finalizar Compra");
        btnFinalizarCompra.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                finalizarCompra();
            }
        });

        JPanel panelBotoes = new JPanel();
        panelBotoes.add(btnExcluir);
        panelBotoes.add(btnFinalizarCompra);

        getContentPane().add(panelBotoes, BorderLayout.NORTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Exemplo de Tabela");
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

    }

    private void excluirLinhaSelecionada() {
        int selectedRow = tabela.getSelectedRow();
        if (selectedRow != -1) {
            modelo.removeRow(selectedRow);
            Lista.remove(selectedRow);
            atualizarPrecoTotal();
        }
    }

    public List<Produto> getLista() {
        return Lista;
    }

    public void setLista(List<Produto> Lista) {
        this.Lista = Lista;
    }

    public void setHome(Home home) {
        this.home = home;
    }

    private void finalizarCompra() {
        // Adicione aqui a lógica para finalizar a compra
        JOptionPane.showMessageDialog(this, "Compra finalizada!");
        salvarListaEmJSON();
        Lista.clear();
        home.carregaHome();
        dispose();
    }

    private void atualizarPrecoTotal() {
        labelPrecoTotal.setText("Preço Total: " + calcularPrecoTotal());
    }

    private String calcularPrecoTotal() {
        double total = 0;
        for (Produto p : Lista) {
            total += p.getPreco();
        }
        NumberFormat formatoMoeda = NumberFormat.getCurrencyInstance();
        return formatoMoeda.format(total);
    }

    private class ButtonRenderer extends JButton implements TableCellRenderer {

        public ButtonRenderer() {
            setOpaque(true);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            setText((value == null) ? "" : value.toString());
            return this;
        }
    }

    private class ButtonEditor extends DefaultCellEditor {

        private JButton button;
        private String label;
        private boolean isPushed;

        public ButtonEditor(JCheckBox checkBox) {
            super(checkBox);
            button = new JButton();
            button.setOpaque(true);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    fireEditingStopped();
                }
            });
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            if (isSelected) {
                button.setForeground(table.getSelectionForeground());
                button.setBackground(table.getSelectionBackground());
            } else {
                button.setForeground(table.getForeground());
                button.setBackground(UIManager.getColor("Button.background"));
            }

            label = (value == null) ? "" : value.toString();
            button.setText(label);
            isPushed = true;
            return button;
        }

        @Override
        public Object getCellEditorValue() {
            if (isPushed) {
                if ("Excluir".equals(label)) {
                    excluirLinhaSelecionada();
                }
                // Adicione aqui outras ações ao clicar no botão
            }
            isPushed = false;
            return label;
        }

        @Override
        public boolean stopCellEditing() {
            isPushed = false;
            return super.stopCellEditing();
        }
    }

    private void salvarListaEmJSON() {
        try {
            // Obtenha o diretório do usuário
            String diretorioUsuario = System.getProperty("user.home");

            String nomeArquivoJSON = "arquivo_" + obterTimestamp() + ".json";
            String caminhoArquivoJSON = diretorioUsuario + File.separator + nomeArquivoJSON;

            List<InformacoesProduto> informacoesProdutos = extrairInformacoesProdutos(Lista);

            // Crie um objeto que inclui a nova lista e outras informações
            DadosCompra dadosCompra = new DadosCompra();
            dadosCompra.setInformacoesProdutos(informacoesProdutos);
            dadosCompra.setDataCompra(new Date()); // Supondo que você queira incluir a data da compra
            dadosCompra.setUsuario(home.getUsuario().getNome());
            System.out.println("asdfgvdfgadgrv: " + home.getUsuario().getNome());

            // Crie um ObjectMapper do Jackson
            ObjectMapper objectMapper = new ObjectMapper();

            // Converte a lista para JSON e escreve no arquivo
            objectMapper.writeValue(new File(caminhoArquivoJSON), dadosCompra);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        //jLabel1.setText("Este é o seu carrinho, ele possui " + getLista().size() + " itens");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 460, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /*public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }*/
    public void main(String args[]) {
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
            java.util.logging.Logger.getLogger(Carrinho.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Carrinho.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Carrinho.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Carrinho.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Carrinho(Lista).setVisible(true);
            }
        });
    }

    private List<InformacoesProduto> extrairInformacoesProdutos(List<Produto> listaProdutos) {
        List<InformacoesProduto> informacoesProdutos = new ArrayList<>();
        for (Produto produto : listaProdutos) {
            InformacoesProduto informacoesProduto = new InformacoesProduto();
            informacoesProduto.setNome(produto.getNome()); // Supondo que 'getNome()' retorne o nome do produto
            informacoesProduto.setPreco(produto.getPreco()); // Supondo que 'getPreco()' retorne o preço do produto
            informacoesProdutos.add(informacoesProduto);
        }
        return informacoesProdutos;
    }

    class InformacoesProduto {

        private String nome;
        private double preco;

        // Getters e Setters
        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public double getPreco() {
            return preco;
        }

        public void setPreco(double preco) {
            this.preco = preco;
        }
    }

    private String obterTimestamp() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
        return sdf.format(new Date());
    }

    class DadosCompra {

        private List<InformacoesProduto> informacoesProdutos;
        private Date dataCompra;
        private String usuario;

        // Getters e Setters
        public List<InformacoesProduto> getInformacoesProdutos() {
            return informacoesProdutos;
        }

        public void setInformacoesProdutos(List<InformacoesProduto> informacoesProdutos) {
            this.informacoesProdutos = informacoesProdutos;
        }

        public String getDataCompra() {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return sdf.format(dataCompra);
        }

        public void setDataCompra(Date dataCompra) {
            this.dataCompra = dataCompra;
        }

        public void setUsuario(String usuario) {
            this.usuario = usuario;
        }

        public String getUsuario() {
            return usuario;
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
