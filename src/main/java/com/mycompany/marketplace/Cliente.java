/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.marketplace;

public class Cliente extends Usuario{

    public Cliente(String userName, String senha) {
        super(userName, senha);
        this.priv = 2;
    }

}
