package com.mycompany.marketplace;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author iagom
 */
public class Pedido {

    private Usuario usuario;
    protected List<Produto> Carrinho;
    private LocalDateTime data;
    private Float valor;

    public Pedido(Usuario usuario, LocalDateTime data) {
        Carrinho = new ArrayList<>();
        this.usuario = usuario;
        this.data = data;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    
    
    

}
