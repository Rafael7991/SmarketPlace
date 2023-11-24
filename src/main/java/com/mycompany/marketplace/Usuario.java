
package com.mycompany.marketplace;

public class Usuario {
    
    private int id;
    private String nome;
    private String userName;
    private String senha;
    public int priv;

    public Usuario(String userName, String senha) {
        this.userName = userName;
        this.senha = senha;
    }

    public int getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getSenha() {
        return senha;
    }

    public int getPriv() {
        return priv;
    }

    public String getNome() {
        return nome;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setPriv(int priv) {
        this.priv = priv;
    }


}
