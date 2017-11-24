package Doceria;

import java.util.List;

/*
gggggg * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class Pedido {
    private int numero = 0;
    private Cliente cliente;
    private List<ItemPedido> listaItemPedido;
    
    public void insereItemPedido(ItemPedido itemPedido){
        listaItemPedido.add(itemPedido);        
    }
    
    public void removeUltimoItemPedido(){     
        listaItemPedido.remove(listaItemPedido.size() - 1);
    }
    
    public double getValorTotal(){
        double retorno = 0;
        
        for (ItemPedido itemPedido : listaItemPedido){
            retorno += itemPedido.getValorTotal();
        }
        
        return retorno;
    }
    
    public String getResumo(){
        System.out.println("Cliente: ");
        System.out.println("Pedido #" + numero + '\n');
        
        return "";
    }
}
