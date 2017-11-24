package Doceria;

import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author joaov
 */
public class ItemPedido {
    private int quantidade;
    private Doce doce;
    
    public double getValorTotal(){
        return doce.getValorTotal() * quantidade;
    }
    
    public String getResumo(){
        return doce.get;
    }
}
