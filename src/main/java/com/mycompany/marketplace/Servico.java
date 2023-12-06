/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.marketplace;

/**
 *
 * @author iagom
 */
public class Servico {
  
    private int id;
    public String nome;
    private String descricao;
    private Double preco;
    
    public Servico (String nome, Double preco){
        this.setNome(nome);
        this.setPreco(preco);
    }
    
    public int getId() {
        return id;
    }
    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
   
    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    
}
