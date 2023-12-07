package com.mycompany.marketplace;

public class Servico {

    public String nome;
    private Double preco;
    protected Usuario usuario;
    protected boolean status;
    
    public Servico (String nome, Double preco, Usuario usuario){
        this.setNome(nome);
        this.setPreco(preco);
        this.usuario = usuario;
        status = false;
    }
    

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
   

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    
}
